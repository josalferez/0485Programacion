@extends('layouts.app')

@section('content')
<div class="cart-sidebar">
    <div class="cart-header">
        <span>Mi Pedido</span>
        <span id="cart-count">0 items</span>
    </div>
    <div class="cart-items" id="cart-items-container">
        <!-- JS will populate this -->
        <div style="text-align: center; color: #999; margin-top: 2rem;">
            Tu carrito está vacío
        </div>
    </div>
    <div class="cart-footer">
        <div style="display: flex; justify-content: space-between; margin-bottom: 1rem; font-weight: bold; font-size: 1.2rem;">
            <span>Total</span>
            <span id="cart-total">0.00€</span>
        </div>
        <button onclick="checkout()" class="btn-checkout" id="btn-checkout" disabled>
            Pagar y Pedir
        </button>
    </div>
</div>

<div class="main-content">
    <div class="category-nav">
        <div class="category-pill active" onclick="filterCategory('all', this)">Todo</div>
        @foreach($categories as $category)
            <div class="category-pill" onclick="filterCategory('{{ $category->id }}', this)">
                {{ $category->name }}
            </div>
        @endforeach
    </div>

    <div class="menu-grid">
        @foreach($categories as $category)
            @foreach($category->products as $product)
                <div class="product-card" 
                     data-category="{{ $category->id }}" 
                     data-product-id="{{ $product->id }}"
                     data-product-name="{{ $product->name }}"
                     data-product-price="{{ $product->price }}"
                     data-product-image="{{ $product->image }}">
                    <div class="product-image">
                        <img src="{{ $product->image }}" alt="{{ $product->name }}">
                    </div>
                    <div class="product-info">
                        <div class="product-name">{{ $product->name }}</div>
                        <div class="product-price">{{ number_format($product->price, 2) }}€</div>
                    </div>
                </div>
            @endforeach
        @endforeach
    </div>
</div>
@endsection

@push('scripts')
<script>
    let cart = [];

    // Event delegation for product cards
    document.addEventListener('DOMContentLoaded', function() {
        const menuGrid = document.querySelector('.menu-grid');
        if (menuGrid) {
            menuGrid.addEventListener('click', function(e) {
                const productCard = e.target.closest('.product-card');
                if (productCard) {
                    const product = {
                        id: parseInt(productCard.dataset.productId),
                        name: productCard.dataset.productName,
                        price: parseFloat(productCard.dataset.productPrice),
                        image: productCard.dataset.productImage
                    };
                    addToCart(product);
                }
            });
        }
    });

    function addToCart(product) {
        const existing = cart.find(item => item.id === product.id);
        if (existing) {
            existing.quantity++;
        } else {
            cart.push({
                ...product,
                quantity: 1
            });
        }
        renderCart();
        animateAdd();
    }

    function removeFromCart(productId) {
        cart = cart.filter(item => item.id !== productId);
        renderCart();
    }

    function updateQuantity(productId, change) {
        const item = cart.find(item => item.id === productId);
        if (item) {
            item.quantity += change;
            if (item.quantity <= 0) {
                removeFromCart(productId);
            } else {
                renderCart();
            }
        }
    }

    function renderCart() {
        const container = document.getElementById('cart-items-container');
        const countSpan = document.getElementById('cart-count');
        const totalSpan = document.getElementById('cart-total');
        const checkoutBtn = document.getElementById('btn-checkout');

        if (cart.length === 0) {
            container.innerHTML = '<div style="text-align: center; color: #999; margin-top: 2rem;">Tu carrito está vacío</div>';
            checkoutBtn.disabled = true;
            countSpan.innerText = '0 items';
            totalSpan.innerText = '0.00€';
            return;
        }

        checkoutBtn.disabled = false;
        container.innerHTML = '';
        let total = 0;
        let count = 0;

        cart.forEach(item => {
            total += item.price * item.quantity;
            count += item.quantity;
            
            const div = document.createElement('div');
            div.className = 'cart-item';
            div.innerHTML = `
                <div>
                    <div style="font-weight: 600;">${item.name}</div>
                    <div style="color: #666; font-size: 0.9rem;">${parseFloat(item.price).toFixed(2)}€</div>
                </div>
                <div style="display: flex; align-items: center; gap: 0.5rem;">
                    <button onclick="updateQuantity(${item.id}, -1)" style="width: 28px; height: 28px; border-radius: 50%; border: 1px solid #ddd; background: white; cursor: pointer;">-</button>
                    <span style="font-weight: 600; min-width: 20px; text-align: center;">${item.quantity}</span>
                    <button onclick="updateQuantity(${item.id}, 1)" style="width: 28px; height: 28px; border-radius: 50%; border: 1px solid #ddd; background: white; cursor: pointer;">+</button>
                </div>
            `;
            container.appendChild(div);
        });

        countSpan.innerText = `${count} items`;
        totalSpan.innerText = `${total.toFixed(2)}€`;
    }

    function filterCategory(catId, element) {
        document.querySelectorAll('.category-pill').forEach(el => el.classList.remove('active'));
        element.classList.add('active');

        const cards = document.querySelectorAll('.product-card');
        cards.forEach(card => {
            if (catId === 'all' || card.dataset.category === catId) {
                card.style.display = 'flex';
            } else {
                card.style.display = 'none';
            }
        });
    }

    function animateAdd() {
        // Optional: Simple vibration or flash
        const cartSidebar = document.querySelector('.cart-sidebar');
        cartSidebar.style.transform = 'translateX(-5px)';
        setTimeout(() => cartSidebar.style.transform = 'none', 100);
    }

    async function checkout() {
        if (cart.length === 0) return;

        const btn = document.getElementById('btn-checkout');
        btn.disabled = true;
        btn.innerText = 'Procesando...';

        try {
            const response = await fetch('{{ route("order.store") }}', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                    'X-CSRF-TOKEN': document.querySelector('meta[name="csrf-token"]').content
                },
                body: JSON.stringify({ items: cart })
            });

            const result = await response.json();

            if (result.success) {
                cart = [];
                renderCart();
                showNotification('¡Pedido realizado con éxito!', 'success');
                setTimeout(() => {
                    window.location.reload();
                }, 3000);
            } else {
                showNotification(result.message || 'Error al procesar el pedido. Inténtalo de nuevo.', 'error');
            }
        } catch (error) {
            console.error('Checkout error:', error);
            showNotification('Error de conexión o del servidor. Por favor, revisa tu conexión.', 'error');
        } finally {
            btn.disabled = false;
            btn.innerText = 'Pagar y Pedir';
        }
    }

    function showNotification(message, type = 'success') {
        const notification = document.createElement('div');
        notification.style.cssText = `
            position: fixed;
            top: 50%;
            left: 50%;
            transform: translate(-50%, -50%);
            background: ${type === 'success' ? '#ffc72c' : '#f44336'};
            color: ${type === 'success' ? '#27251f' : 'white'};
            padding: 2rem 3rem;
            border-radius: 12px;
            font-size: 1.2rem;
            font-weight: bold;
            box-shadow: 0 10px 40px rgba(0,0,0,0.3);
            z-index: 10000;
            animation: fadeIn 0.3s ease-in;
        `;
        notification.textContent = message;
        document.body.appendChild(notification);

        if (type === 'success') {
            setTimeout(() => {
                notification.style.animation = 'fadeOut 0.3s ease-out';
                setTimeout(() => notification.remove(), 300);
            }, 2700);
        }
    }
</script>
@endpush
