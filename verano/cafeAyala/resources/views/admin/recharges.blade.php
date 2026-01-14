@extends('layouts.app')

@section('content')
<div style="padding: 2rem; max-width: 1200px; margin: 0 auto;">
    <h1 style="font-size: 2rem; font-weight: 800; margin-bottom: 2rem; color: var(--dark);">Solicitudes de Recarga Pendientes</h1>

    @if(session('success'))
        <div style="background: #4CAF50; color: white; padding: 1rem; border-radius: 8px; margin-bottom: 1rem;">
            {{ session('success') }}
        </div>
    @endif

    @if($requests->isEmpty())
        <div style="background: white; padding: 3rem; border-radius: 12px; text-align: center; color: #999;">
            No hay solicitudes pendientes
        </div>
    @else
        <div style="display: grid; gap: 1rem;">
            @foreach($requests as $request)
                <div style="background: white; padding: 1.5rem; border-radius: 12px; box-shadow: 0 2px 8px rgba(0,0,0,0.1); display: flex; justify-content: space-between; align-items: center;">
                    <div>
                        <div style="font-weight: 700; font-size: 1.1rem; margin-bottom: 0.5rem;">
                            {{ $request->user->name }}
                        </div>
                        <div style="color: #666; font-size: 0.9rem;">
                            Email: {{ $request->user->email }}
                        </div>
                        <div style="color: #666; font-size: 0.9rem;">
                            Solicitado: {{ $request->created_at->format('d/m/Y H:i') }}
                        </div>
                        <div style="color: var(--primary); font-weight: 800; font-size: 1.5rem; margin-top: 0.5rem;">
                            {{ number_format($request->amount, 2) }}€
                        </div>
                    </div>
                    <div style="display: flex; gap: 1rem;">
                        <form action="{{ route('admin.recharges.approve', $request) }}" method="POST">
                            @csrf
                            <button type="submit" style="padding: 0.75rem 1.5rem; background: #4CAF50; color: white; border: none; border-radius: 8px; font-weight: bold; cursor: pointer; font-size: 1rem;">
                                ✓ Aprobar
                            </button>
                        </form>
                        <form action="{{ route('admin.recharges.reject', $request) }}" method="POST">
                            @csrf
                            <button type="submit" style="padding: 0.75rem 1.5rem; background: #f44336; color: white; border: none; border-radius: 8px; font-weight: bold; cursor: pointer; font-size: 1rem;">
                                ✗ Rechazar
                            </button>
                        </form>
                    </div>
                </div>
            @endforeach
        </div>
    @endif

    <a href="{{ route('admin.dashboard') }}" style="display: inline-block; margin-top: 2rem; color: #666; text-decoration: none;">
        ← Volver al panel admin
    </a>
</div>
@endsection
