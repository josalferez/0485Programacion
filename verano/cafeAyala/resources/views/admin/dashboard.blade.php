@extends('layouts.app')

@section('content')
<div style="padding: 2rem; max-width: 800px; margin: 0 auto;">
    <h1 style="font-size: 2rem; font-weight: 800; margin-bottom: 2rem; color: var(--dark);">Panel de Administración</h1>

    <div style="display: grid; gap: 1rem;">
        <a href="{{ route('admin.recharges') }}" style="background: white; padding: 2rem; border-radius: 12px; text-decoration: none; color: inherit; box-shadow: 0 2px 8px rgba(0,0,0,0.1); display: block; transition: transform 0.2s;">
            <div style="font-weight: 700; font-size: 1.3rem; margin-bottom: 0.5rem; color: var(--primary);">
                💰 Solicitudes de Recarga
            </div>
            <div style="color: #666;">
                Ver y gestionar solicitudes pendientes de recarga de saldo
            </div>
        </a>

        <div style="background: white; padding: 2rem; border-radius: 12px; box-shadow: 0 2px 8px rgba(0,0,0,0.1);">
            <div style="font-weight: 700; font-size: 1.3rem; margin-bottom: 0.5rem; color: #666;">
                📊 Gestión de Pedidos
            </div>
            <div style="color: #999;">
                Próximamente...
            </div>
        </div>
    </div>

    <form action="{{ route('logout') }}" method="POST" style="margin-top: 2rem;">
        @csrf
        <button type="submit" style="background: #f44336; color: white; padding: 0.75rem 1.5rem; border: none; border-radius: 8px; font-weight: bold; cursor: pointer;">
            Cerrar Sesión
        </button>
    </form>
</div>
@endsection
