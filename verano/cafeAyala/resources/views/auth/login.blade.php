@extends('layouts.app')

@section('content')
<div style="display: flex; align-items: center; justify-content: center; height: 100vh; flex-direction: column; background: #da291c;">
    <div style="background: white; padding: 3rem; border-radius: 20px; text-align: center; width: 100%; max-width: 400px; box-shadow: 0 10px 25px rgba(0,0,0,0.2);">
        <h1 style="color: #da291c; margin-bottom: 2rem;">Café Ayala</h1>
        
        <form action="{{ route('login.post') }}" method="POST">
            @csrf
            
            @if($errors->any())
                <div style="background: #ffe6e6; color: red; padding: 0.75rem; border-radius: 8px; margin-bottom: 1rem; text-align: left; font-size: 0.9rem;">
                    {{ $errors->first() }}
                </div>
            @endif

            <div style="margin-bottom: 1.5rem; text-align: left;">
                <label style="display: block; font-weight: bold; margin-bottom: 0.5rem;">Usuario</label>
                <input type="text" name="email" style="width: 100%; padding: 0.75rem; border: 2px solid #eee; border-radius: 8px; font-size: 1rem; box-sizing: border-box;" required autofocus>
            </div>

            <div style="margin-bottom: 2rem; text-align: left;">
                <label style="display: block; font-weight: bold; margin-bottom: 0.5rem;">Contraseña</label>
                <input type="password" name="password" style="width: 100%; padding: 0.75rem; border: 2px solid #eee; border-radius: 8px; font-size: 1rem; box-sizing: border-box;" required>
            </div>

            <button type="submit" style="width: 100%; padding: 1rem; background: #ffc72c; color: #27251f; font-weight: 800; border: none; border-radius: 8px; font-size: 1.1rem; cursor: pointer; text-transform: uppercase;">
                Entrar
            </button>
        </form>
    </div>
</div>
@endsection
