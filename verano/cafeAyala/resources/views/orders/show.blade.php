@extends('layouts.app')

@section('content')
<div style="display: flex; align-items: center; justify-content: center; height: 100vh; flex-direction: column; text-align: center;">
    <div style="font-size: 4rem; color: #bad80a; margin-bottom: 1rem;">✔</div>
    <h1 style="font-size: 2.5rem; margin-bottom: 0.5rem;">¡Pedido Realizado!</h1>
    <p style="font-size: 1.2rem; color: #666; margin-bottom: 2rem;">Tu pedido #{{ $order->id }} se está preparando.</p>
    
    <div style="background: white; padding: 2rem; border-radius: 12px; box-shadow: 0 4px 15px rgba(0,0,0,0.05); width: 100%; max-width: 400px; text-align: left;">
        <h3 style="border-bottom: 1px solid #eee; padding-bottom: 0.5rem; margin-bottom: 1rem;">Resumen</h3>
        @foreach($order->items as $item)
            <div style="display: flex; justify-content: space-between; margin-bottom: 0.5rem;">
                <span>{{ $item->quantity }}x {{ $item->product->name }}</span>
                <span>{{ number_format($item->price * $item->quantity, 2) }}€</span>
            </div>
        @endforeach
        <div style="border-top: 1px solid #eee; padding-top: 1rem; margin-top: 1rem; font-weight: bold; display: flex; justify-content: space-between; font-size: 1.2rem;">
            <span>Total</span>
            <span>{{ number_format($order->total, 2) }}€</span>
        </div>
    </div>

    <a href="{{ route('home') }}" class="btn-checkout" style="margin-top: 2rem; text-decoration: none; display: inline-block; padding: 1rem 3rem;">
        Volver al Inicio
    </a>
</div>
@endsection
