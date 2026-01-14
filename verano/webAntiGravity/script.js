// Simulación de Inventario (Titulo, Precio, Stock)
// Equivalente al String[][] inventario del Java
// Global State
let inventory = [];
let cart = [];
let userBalance = 0;
const MAX_CART_ITEMS = 15;

// DOM Elements
const inventoryGrid = document.getElementById('inventory-grid');
const cartItemsContainer = document.getElementById('cart-items');
const cartCountSpan = document.getElementById('cart-count');
const historyModal = document.getElementById('history-modal');
const historyList = document.getElementById('history-list');
const receiptModal = document.getElementById('receipt-modal');
const userBalanceSpan = document.getElementById('user-balance');

// Inicializar
document.addEventListener('DOMContentLoaded', () => {
    fetchData();
    // Poll for balance updates (every 2 seconds) to handle mobile recharges
    setInterval(fetchData, 2000);
});

async function fetchData() {
    try {
        const res = await fetch('/api/data');
        const data = await res.json();

        // Update State
        inventory = data.inventory;
        // Only update balance if changed to avoid UI flickering/resetting (though textContent is cheap)
        if (data.user.balance !== userBalance) {
            // If we just got a top-up, show alert/notification if needed, 
            // but for now just silent update + UI refresh
            const oldBalance = userBalance;
            userBalance = data.user.balance;

            // Check if we should notify user of recharge
            if (userBalance > oldBalance && oldBalance !== 0) {
                const qrModal = document.getElementById('qr-modal');
                if (!qrModal.classList.contains('hidden')) {
                    closeModal('qr-modal');
                    alert(`¡Recarga detectada! Nuevo saldo: ${userBalance.toFixed(2)} €`);
                }
            }
        }

        // Always re-render inventory to show correct stock if other users buy items
        renderInventory();
        updateBalanceUI();

    } catch (err) {
        console.error("Error fetching data:", err);
    }
}

function updateBalanceUI() {
    if (userBalanceSpan) {
        userBalanceSpan.textContent = userBalance.toFixed(2) + " €";
    }
}

function addFunds() {
    const amountStr = prompt("Ingrese la cantidad a recargar (Ej: 50):");
    if (amountStr) {
        const amount = parseFloat(amountStr);
        if (!isNaN(amount) && amount > 0) {
            showQR(amount);
        } else {
            alert("Cantidad inválida.");
        }
    }
}

function showQR(amount) {
    const qrModal = document.getElementById('qr-modal');
    const qrContainer = document.getElementById('qr-code');
    const qrLink = document.getElementById('qr-link');

    // Clear previous QR
    qrContainer.innerHTML = '';

    // Construct URL relative to server
    const baseUrl = window.location.origin;
    const targetUrl = `${baseUrl}/mobile.html?amount=${amount}`;

    // Generate QR
    new QRCode(qrContainer, {
        text: targetUrl,
        width: 200,
        height: 200
    });

    // Set link for easy testing without scanner
    qrLink.href = targetUrl;

    qrModal.classList.remove('hidden');
}

function renderInventory() {
    inventoryGrid.innerHTML = '';

    inventory.forEach(book => {
        const bookCard = document.createElement('div');
        bookCard.className = 'book-card';
        bookCard.innerHTML = `
            <div>
                <div class="book-title">${book.title}</div>
                <div class="book-details">
                    <span class="price-tag">${book.price} €</span>
                    <span class="stock-tag">Stock: ${book.stock}</span>
                </div>
            </div>
            <button class="btn-buy" onclick="addToCart(${book.id})" ${book.stock === 0 ? 'disabled' : ''}>
                ${book.stock === 0 ? 'Sin Stock' : 'Añadir al Carrito'}
            </button>
        `;
        inventoryGrid.appendChild(bookCard);
    });
}

function addToCart(bookId) {
    if (cart.length >= MAX_CART_ITEMS) {
        alert("¡Carrito lleno! No se pueden agregar más libros.");
        return;
    }

    const book = inventory.find(b => b.id === bookId);
    if (book && book.stock > 0) {
        // Optimistic UI update - we don't reduce server stock yet
        // but we reduce local visual stock to prevent double add
        // Real validation happens on server checkout

        // Add copy to cart
        cart.push({ ...book });

        updateCartUI();
    } else {
        alert("Lo sentimos, este artículo se ha agotado.");
        fetchData(); // Refresh to be sure
    }
}

function updateCartUI() {
    cartCountSpan.textContent = cart.length;
    cartItemsContainer.innerHTML = '';

    if (cart.length === 0) {
        cartItemsContainer.innerHTML = '<p class="empty-msg">El carrito está vacío</p>';
        return;
    }

    cart.forEach((item, index) => {
        const itemDiv = document.createElement('div');
        itemDiv.className = 'cart-item';
        // Just showing title like Java console output
        itemDiv.innerHTML = `
            <span>${item.title}</span>
            <span>${item.price} €</span>
        `;
        cartItemsContainer.appendChild(itemDiv);
    });
}

function procesarVenta() {
    if (cart.length === 0) {
        alert("El carrito está vacío");
        return;
    }

    let total = 0;
    let detailsHtml = "<ul>";

    cart.forEach(item => {
        total += item.price;
        detailsHtml += `<li>${item.title} - ${item.price} €</li>`;
    });

    detailsHtml += "</ul>";

    // Validar Saldo
    if (total > userBalance) {
        alert(`Saldo insuficiente. Total: ${total} €, Tu Saldo: ${userBalance.toFixed(2)} €\nPor favor, recarga tu saldo.`);
        return;
    }

    // Mostrar Factura Final
    const receiptDetails = document.getElementById('receipt-details');
    const receiptTotal = document.getElementById('receipt-total');

    receiptDetails.innerHTML = detailsHtml;
    // Store total in modal dataset for confirmation step
    receiptModal.dataset.total = total;
    receiptTotal.textContent = total.toFixed(2) + " Euros";

    receiptModal.classList.remove('hidden');
}

async function confirmOrder() {
    const total = parseFloat(receiptModal.dataset.total);

    try {
        const res = await fetch('/api/order', {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify({
                total: total,
                items: cart
            })
        });

        const result = await res.json();

        if (result.success) {
            alert(`¡Pedido guardado correctamente! Nuevo saldo: ${result.newBalance.toFixed(2)} €`);
            userBalance = result.newBalance; // Update local immediately
            updateBalanceUI();
            closeModal('receipt-modal');

            cart = [];
            updateCartUI();
            fetchData(); // Refresh inventory from server
        } else {
            alert("Error: " + (result.error || "No se pudo procesar la orden"));
        }

    } catch (err) {
        alert("Error de conexión con el servidor");
        console.error(err);
    }
}

async function showHistory() {
    try {
        const res = await fetch('/api/data');
        const data = await res.json();
        const history = data.history || [];

        historyList.innerHTML = '';

        if (history.length === 0) {
            historyList.innerHTML = '<p class="empty-msg">No hay pedidos anteriores.</p>';
        } else {
            history.slice().reverse().forEach(order => {
                const orderDiv = document.createElement('div');
                orderDiv.className = 'history-item';

                const itemsSummary = order.items.map(i => i.title).join(', ');

                orderDiv.innerHTML = `
                    <div class="history-date">${order.date}</div>
                    <div>
                        <span class="history-total">${order.total.toFixed(2)} €</span>
                        <strong>Compro:</strong> ${itemsSummary} (Total items: ${order.items.length})
                    </div>
                `;
                historyList.appendChild(orderDiv);
            });
        }

        historyModal.classList.remove('hidden');
    } catch (err) {
        console.error(err);
        alert("Error cargando historial");
    }
}

function clearHistory() {
    alert("Función no disponible en modo servidor para seguridad. Contacte al admin.");
}

function closeModal(modalId) {
    document.getElementById(modalId).classList.add('hidden');
}

function resetSystem() {
    // Resetting system client side only clears cart
    cart = [];
    updateCartUI();
    document.querySelectorAll('.modal').forEach(m => m.classList.add('hidden'));
}

// LOGIN SYSTEM (Simple FE check only, for real app this would be server side)
function login() {
    const user = document.getElementById('username').value;
    const pass = document.getElementById('password').value;

    if (user === 'a' && pass === 'a') {
        document.getElementById('login-view').classList.add('hidden');
        document.getElementById('app-view').classList.remove('hidden');
        fetchData();
    } else {
        alert("Usuario o Contraseña incorrectos");
    }
}

function logout() {
    document.getElementById('app-view').classList.add('hidden');
    document.getElementById('login-view').classList.remove('hidden');
    document.getElementById('username').value = '';
    document.getElementById('password').value = '';
}
