@extends('layouts.app')

@section('content')
<div style="padding: 2rem; max-width: 1000px; margin: 0 auto;">
    <h1 style="font-size: 2rem; font-weight: 800; margin-bottom: 2rem; color: var(--dark);">Mis Recargas</h1>

    @if($requests->isEmpty())
        <div style="background: white; padding: 3rem; border-radius: 12px; text-align: center; color: #999;">
            No has solicitado ninguna recarga aún
        </div>
    @else
        <div style="display: grid; gap: 1rem;">
            @foreach($requests as $request)
                <div style="background: white; padding: 1.5rem; border-radius: 12px; box-shadow: 0 2px 8px rgba(0,0,0,0.1); display: flex; justify-content: space-between; align-items: center;">
                    <div>
                        <div style="color: var(--primary); font-weight: 800; font-size: 1.5rem; margin-bottom: 0.5rem;">
                            {{ number_format($request->amount, 2) }}€
                        </div>
                        <div style="color: #666; font-size: 0.9rem;">
                            Solicitado: {{ $request->created_at->format('d/m/Y H:i') }}
                        </div>
                        @if($request->status !== 'pending')
                            <div style="color: #666; font-size: 0.9rem;">
                                {{ $request->status === 'approved' ? 'Aprobado' : 'Rechazado' }}: {{ $request->approved_at->format('d/m/Y H:i') }}
                            </div>
                        @endif
                    </div>
                    <div>
                        @if($request->status === 'pending')
                            <span style="padding: 0.5rem 1rem; background: #FFA500; color: white; border-radius: 50px; font-weight: bold; font-size: 0.9rem;">
                                ⏳ Pendiente
                            </span>
                        @elseif($request->status === 'approved')
                            <span style="padding: 0.5rem 1rem; background: #4CAF50; color: white; border-radius: 50px; font-weight: bold; font-size: 0.9rem;">
                                ✓ Aprobado
                            </span>
                        @else
                            <span style="padding: 0.5rem 1rem; background: #f44336; color: white; border-radius: 50px; font-weight: bold; font-size: 0.9rem;">
                                ✗ Rechazado
                            </span>
                        @endif
                    </div>
                </div>
            @endforeach
        </div>
    @endif

    <a href="{{ route('home') }}" style="display: inline-block; margin-top: 2rem; color: #666; text-decoration: none;">
        ← Volver al menú
    </a>
</div>
@endsection
