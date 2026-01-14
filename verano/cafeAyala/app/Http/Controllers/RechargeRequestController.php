<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use App\Models\RechargeRequest;
use Illuminate\Support\Facades\Auth;

class RechargeRequestController extends Controller
{
    public function myRecharges()
    {
        $requests = RechargeRequest::where('user_id', Auth::id())
            ->latest()
            ->get();
        
        return view('profile.my-recharges', compact('requests'));
    }
}
