@extends('layouts.app')

@section('content')
<div style="display: flex; align-items: center; justify-content: center; height: 100vh; flex-direction: column;">
    <div style="background: white; padding: 3rem; border-radius: 20px; text-align: center; width: 100%; max-width: 400px; box-shadow: 0 10px 25px rgba(0,0,0,0.1);">
        <h1 style="color: var(--secondary); margin-bottom: 0.5rem;">Recargar Saldo</h1>
        <p style="color: #666; margin-bottom: 2rem;">Saldo actual: <strong>{{ number_format(auth()->user()->balance, 2) }}€</strong></p>
        
        <form action="{{ route('recharge.post') }}" method="POST">
            @csrf
            
            <div style="margin-bottom: 1.5rem;">
                <label for="custom-amount" style="display: block; text-align: left; margin-bottom: 0.5rem; font-weight: 600; color: #333;">Cantidad a recargar:</label>
                <input 
                    type="number" 
                    id="custom-amount" 
                    name="amount" 
                    min="0.01" 
                    step="0.01" 
                    value="10.00"
                    style="width: 100%; padding: 1rem; border: 2px solid #eee; border-radius: 12px; font-size: 1.5rem; text-align: center; font-weight: bold;"
                    oninput="updateDisplay()"
                >
            </div>

            <div style="display: grid; grid-template-columns: 1fr 1fr; gap: 1rem; margin-bottom: 2rem;">
                <button type="button" onclick="setAmount(1)" class="amount-btn">+1€</button>
                <button type="button" onclick="setAmount(2)" class="amount-btn">+2€</button>
                <button type="button" onclick="setAmount(5)" class="amount-btn">+5€</button>
                <button type="button" onclick="setAmount(10)" class="amount-btn">+10€</button>
            </div>

            <button type="submit" style="width: 100%; padding: 1rem; background: var(--primary); color: white; font-weight: 800; border: none; border-radius: 12px; font-size: 1.2rem; cursor: pointer;">
                Confirmar Recarga
            </button>
            <a href="{{ route('home') }}" style="display: block; margin-top: 1rem; color: #999; text-decoration: none;">Cancelar</a>
        </form>
    </div>
</div>

<style>
    .amount-btn {
        padding: 1rem;
        border: 2px solid #eee;
        background: white;
        border-radius: 12px;
        font-weight: bold;
        cursor: pointer;
        transition: all 0.2s;
        font-size: 1.1rem;
    }
    .amount-btn:hover {
        border-color: var(--secondary);
        background: #fffdf5;
    }
    .amount-btn.active {
        border-color: var(--secondary);
        background: var(--secondary);
        color: var(--dark);
    }
</style>

<script>
    function setAmount(amount) {
        const input = document.getElementById('custom-amount');
        const currentValue = parseFloat(input.value) || 0;
        input.value = (currentValue + amount).toFixed(2);
    }
    
    function updateDisplay() {
        const input = document.getElementById('custom-amount');
        const value = parseFloat(input.value) || 0;
        if (value < 0.01) {
            input.value = '0.01';
        }
    }
</script>
@endsection
