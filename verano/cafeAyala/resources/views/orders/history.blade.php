@extends('layouts.app')

@section('content')
<div class="main-content" style="padding: 2rem; overflow-y: auto;">
    <div style="display: flex; justify-content: space-between; align-items: center; margin-bottom: 2rem;">
        <h1 style="color: var(--primary);">Mis Pedidos</h1>
        <a href="{{ route('home') }}" style="background: var(--dark); color: white; padding: 0.75rem 1.5rem; text-decoration: none; border-radius: 50px; font-weight: bold;">Volver al Kiosco</a>
    </div>

    @if($orders->count() > 0)
        <div style="display: grid; gap: 1.5rem;">
            @foreach($orders as $order)
                <div style="background: white; padding: 1.5rem; border-radius: 12px; box-shadow: 0 4px 10px rgba(0,0,0,0.05); display: flex; flex-direction: column; gap: 1rem;">
                    <div style="display: flex; justify-content: space-between; border-bottom: 1px solid #eee; padding-bottom: 0.5rem; color: #666; font-size: 0.9rem;">
                        <span>Pedido #{{ $order->id }}</span>
                        <span>{{ $order->created_at->format('d/m/Y H:i') }}</span>
                    </div>
                    
                    <div style="flex: 1;">
                        @foreach($order->items as $item)
                            <div style="display: flex; justify-content: space-between; margin-bottom: 0.25rem;">
                                <span style="font-weight: 500;">{{ $item->quantity }}x {{ $item->product->name }}</span>
                                <span style="color: #666;">{{ number_format($item->price, 2) }}€</span>
                            </div>
                        @endforeach
                    </div>

                    <div style="border-top: 1px solid #eee; padding-top: 1rem; display: flex; justify-content: space-between; font-weight: 800; font-size: 1.2rem; color: var(--primary);">
                        <span>Total Pago</span>
                        <span>{{ number_format($order->total, 2) }}€</span>
                    </div>
                </div>
            @endforeach
        </div>
    @else
        <div style="text-align: center; color: #999; margin-top: 3rem;">
            <h3>No has realizado ningún pedido aún.</h3>
        </div>
    @endif
</div>
@endsection
