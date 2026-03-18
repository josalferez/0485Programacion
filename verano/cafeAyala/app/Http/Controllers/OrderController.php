<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;

use App\Models\Order;
use App\Models\OrderItem;
use App\Models\RechargeRequest;

use Illuminate\Support\Facades\DB;

use Illuminate\Support\Facades\Auth;

class OrderController extends Controller
{
    public function store(Request $request)
    {
        $user = Auth::user();

        $data = $request->validate([
            'items' => 'required|array',
            'items.*.id' => 'required|exists:products,id',
            'items.*.quantity' => 'required|integer|min:1',
            'items.*.price' => 'required|numeric',
        ]);

        $total = 0;
        foreach ($data['items'] as $item) {
            $total += $item['price'] * $item['quantity'];
        }

        if ($user->balance < $total) {
            return response()->json(['success' => false, 'message' => 'Saldo insuficiente. Recarga tu saldo.']);
        }

        $order = DB::transaction(function () use ($data, $user, $total) {
            
            // Deduct balance
            $user->balance -= $total;
            $user->save();

            $order = Order::create([
                'user_id' => $user->id,
                'total' => $total,
                'status' => 'paid',
                'payment_method' => 'balance',
            ]);

            foreach ($data['items'] as $item) {
                OrderItem::create([
                    'order_id' => $order->id,
                    'product_id' => $item['id'],
                    'quantity' => $item['quantity'],
                    'price' => $item['price'],
                ]);
            }

            return $order;
        });

        return response()->json(['success' => true, 'order_id' => $order->id]);
    }

    public function show(Order $order)
    {
        // Simple authorization check
        if ($order->user_id !== Auth::id()) {
            abort(403);
        }
        return view('orders.show', compact('order'));
    }

    public function history()
    {
        $orders = Order::where('user_id', Auth::id())->with('items.product')->latest()->get();
        return view('orders.history', compact('orders'));
    }

    public function showRecharge()
    {
        return view('profile.recharge');
    }

    public function recharge(Request $request)
    {
        $request->validate(['amount' => 'required|numeric|min:0.01']);
        
        RechargeRequest::create([
            'user_id' => Auth::id(),
            'amount' => $request->amount,
            'status' => 'pending',
        ]);

        return redirect()->route('home')->with('success', 'Solicitud de recarga enviada. Espera la aprobación del camarero.');
    }

    public function showRechargeRequests()
    {
        $requests = RechargeRequest::with('user')
            ->where('status', 'pending')
            ->latest()
            ->get();
        
        return view('admin.recharges', compact('requests'));
    }

    public function approveRecharge(RechargeRequest $request)
    {
        DB::transaction(function () use ($request) {
            $request->user->balance += $request->amount;
            $request->user->save();

            $request->update([
                'status' => 'approved',
                'approved_by' => Auth::id(),
                'approved_at' => now(),
            ]);
        });

        return redirect()->route('admin.recharges')->with('success', 'Recarga aprobada correctamente.');
    }

    public function rejectRecharge(RechargeRequest $request)
    {
        $request->update([
            'status' => 'rejected',
            'approved_by' => Auth::id(),
            'approved_at' => now(),
        ]);

        return redirect()->route('admin.recharges')->with('success', 'Recarga rechazada.');
    }
}
