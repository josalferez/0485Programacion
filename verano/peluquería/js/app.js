// Data is loaded from data.js


// State
const state = {
    cart: [], // Array of service IDs
    selectedCategory: categories[0].id,
    step: 0, // 0: Services, 1: Time, 2: Confirmation, 3: My Bookings
    selectedTime: null,
    bookings: JSON.parse(localStorage.getItem('kiosk_bookings')) || []
};

// DOM Elements
const attractScreen = document.getElementById('attract-screen');
const categoryNav = document.getElementById('category-nav');
const servicesGrid = document.getElementById('services-grid');
const timeGrid = document.getElementById('time-grid');
const itemsCountEl = document.getElementById('item-count');
const totalPriceEl = document.getElementById('total-price');
const actionBtn = document.getElementById('main-action-btn');
const servicesSection = document.getElementById('services-section');
const timeSection = document.getElementById('time-section');
const confirmationSection = document.getElementById('confirmation-section');
const confirmationSection = document.getElementById('confirmation-section');
const orderSummary = document.getElementById('order-summary');
const userBookingsSection = document.getElementById('user-bookings-section');
const bookingsList = document.getElementById('bookings-list');

// Initialization
function init() {
    renderCategories();
    renderServices();
    renderTimeSlots();

    // Attract Screen Listener
    attractScreen.addEventListener('click', () => {
        attractScreen.classList.add('hidden');
    });

    // Action Button Listener
    actionBtn.addEventListener('click', handleAction);
}

// Render Categories
function renderCategories() {
    categoryNav.innerHTML = '';
    categories.forEach(cat => {
        const btn = document.createElement('button');
        btn.className = `category-btn ${cat.id === state.selectedCategory ? 'active' : ''}`;
        btn.innerHTML = `${cat.icon} <span>${cat.name}</span>`;
        btn.onclick = () => {
            state.selectedCategory = cat.id;
            state.step = 0; // Reset to services view
            updateView();
            renderCategories();
            renderServices();
            updateFooter();
        };
        categoryNav.appendChild(btn);
    });

    // Add "Mis Reservas" Button
    const myBookingsBtn = document.createElement('button');
    myBookingsBtn.className = `category-btn ${state.selectedCategory === 'bookings' ? 'active' : ''}`;
    myBookingsBtn.innerHTML = `👤 <span>Mis Reservas</span>`;
    myBookingsBtn.onclick = () => {
        state.selectedCategory = 'bookings';
        state.step = 3; // Special step for bookings
        renderCategories();
        updateView();
        renderBookings();
    };
    categoryNav.appendChild(myBookingsBtn);
}

// Render Services
function renderServices() {
    servicesGrid.innerHTML = '';
    const filteredServices = services.filter(s => s.categoryId === state.selectedCategory);

    filteredServices.forEach(service => {
        const isSelected = state.cart.includes(service.id);

        const card = document.createElement('div');
        card.className = `kiosk-card ${isSelected ? 'selected' : ''}`;

        card.innerHTML = `
            <div class="card-image" style="background-image: url('${service.image}')"></div>
            <div class="card-content">
                <div>
                    <div class="card-title">${service.name}</div>
                    <div class="card-desc">${service.description}</div>
                </div>
                <div class="card-price">$${service.price.toFixed(2)}</div>
            </div>
        `;

        card.onclick = () => toggleService(service.id);
        servicesGrid.appendChild(card);
    });
}

// Render Time Slots
function renderTimeSlots() {
    timeGrid.innerHTML = '';
    timeSlots.forEach(time => {
        const btn = document.createElement('button');
        btn.className = `time-btn ${state.selectedTime === time ? 'selected' : ''}`;
        btn.textContent = time;
        btn.onclick = () => {
            // Toggle time
            if (state.selectedTime === time) {
                state.selectedTime = null;
            } else {
                state.selectedTime = time;
            }
            renderTimeSlots();
            updateFooter();
        };
        timeGrid.appendChild(btn);
    });
}

// Logic: Toggle Service
function toggleService(id) {
    if (state.cart.includes(id)) {
        state.cart = state.cart.filter(itemId => itemId !== id);
    } else {
        state.cart.push(id);
    }
    renderServices();
    updateFooter();
}

// Logic: Update Footer
function updateFooter() {
    // Calculate Total
    const total = state.cart.reduce((sum, id) => {
        const service = services.find(s => s.id === id);
        return sum + (service ? service.price : 0);
    }, 0);

    itemsCountEl.textContent = state.cart.length;
    totalPriceEl.textContent = total.toFixed(2);

    // Button State
    if (state.step === 0) {
        actionBtn.disabled = state.cart.length === 0;
        actionBtn.textContent = 'CONTINUAR / ELEGIR HORA';
        actionBtn.style.display = 'block';
        document.querySelector('.cart-info').style.opacity = '1';
    } else if (state.step === 1) {
        actionBtn.disabled = !state.selectedTime;
        actionBtn.textContent = 'FINALIZAR RESERVA';
        actionBtn.style.display = 'block';
        document.querySelector('.cart-info').style.opacity = '1';
    } else if (state.step === 2) {
        actionBtn.disabled = false;
        actionBtn.textContent = 'NUEVA RESERVA';
        actionBtn.style.display = 'block';
        document.querySelector('.cart-info').style.opacity = '0';
    } else if (state.step === 3) {
        // My Bookings view - hide footer action button or change to "Back"
        actionBtn.style.display = 'none';
        document.querySelector('.cart-info').style.opacity = '0';
    }
}

// Logic: Navigation Flow
function handleAction() {
    if (state.step === 0) {
        // From Services to Time
        state.step = 1;
        updateView();
    } else if (state.step === 1) {
        // From Time to Confirmation
        state.step = 2;
        updateView();
        saveBooking(); // Save to persistence
        showConfirmation();
    } else {
        // Reset
        location.reload();
    }
    updateFooter();
}

function updateView() {
    servicesSection.classList.remove('active');
    timeSection.classList.remove('active');
    confirmationSection.classList.remove('active');
    userBookingsSection.classList.remove('active');

    if (state.step === 0) {
        servicesSection.classList.add('active');
    } else if (state.step === 1) {
        timeSection.classList.add('active');
    } else if (state.step === 2) {
        confirmationSection.classList.add('active');
    } else if (state.step === 3) {
        userBookingsSection.classList.add('active');
    }
}

function showConfirmation() {
    const selectedServices = services.filter(s => state.cart.includes(s.id));
    const total = selectedServices.reduce((sum, s) => sum + s.price, 0);

    orderSummary.innerHTML = `
        <div style="font-size: 1.5rem; margin-bottom: 20px;">
            <p><strong>Hora:</strong> ${state.selectedTime}</p>
        </div>
        <ul style="list-style: none; font-size: 1.2rem; margin-bottom: 20px;">
            ${selectedServices.map(s => `
                <li style="display: flex; justify-content: space-between; margin-bottom: 10px; border-bottom: 1px solid #333; padding-bottom: 5px;">
                    <span>${s.name}</span>
                    <span>$${s.price.toFixed(2)}</span>
                </li>
            `).join('')}
        </ul>
        <div style="text-align: right; font-size: 2rem; color: var(--primary-color); font-weight: bold;">
            Total: $${total.toFixed(2)}
        </div>
        <div style="margin-top: 40px; text-align: center; color: #4caf50;">
            <h3>¡Reserva Confirmada!</h3>
            <p>Te esperamos.</p>
        </div>
    `;

    // Hide footer info in confirmation, only show button
    document.querySelector('.cart-info').style.opacity = '0';
}

function saveBooking() {
    const selectedServices = services.filter(s => state.cart.includes(s.id));
    const total = selectedServices.reduce((sum, s) => sum + s.price, 0);

    const booking = {
        id: Date.now(), // timestamp as ID
        date: new Date().toLocaleDateString(),
        time: state.selectedTime,
        services: selectedServices.map(s => s.name),
        total: total
    };

    state.bookings.push(booking);
    localStorage.setItem('kiosk_bookings', JSON.stringify(state.bookings));
}

function renderBookings() {
    bookingsList.innerHTML = '';

    if (state.bookings.length === 0) {
        bookingsList.innerHTML = '<p style="color: var(--text-secondary); font-size: 1.2rem; text-align: center; grid-column: 1 / -1;">No tienes reservas activas.</p>';
        return;
    }

    state.bookings.slice().reverse().forEach(booking => {
        const card = document.createElement('div');
        card.className = 'kiosk-card';
        card.style.cursor = 'default';

        card.innerHTML = `
            <div class="card-content">
                <div>
                     <div style="display:flex; justify-content:space-between; align-items:flex-start;">
                        <h3 class="card-title">Reserva #${booking.id.toString().slice(-4)}</h3>
                        <span style="background:var(--primary-color); color:black; padding:4px 8px; border-radius:4px; font-weight:bold;">
                            ${booking.time}
                        </span>
                     </div>
                     <p class="card-desc" style="margin-bottom:5px;"><strong>Fecha:</strong> ${booking.date}</p>
                     <ul style="margin-bottom:15px; padding-left:20px; color:var(--text-secondary);">
                        ${booking.services.map(s => `<li>${s}</li>`).join('')}
                     </ul>
                </div>
                <div style="display:flex; justify-content:space-between; align-items:center; margin-top: auto;">
                    <div class="card-price">$${booking.total.toFixed(2)}</div>
                    <button class="time-btn" style="border-color: #ff4444; color: #ff4444;" onclick="cancelBooking(${booking.id})">CANCELAR</button>
                </div>
            </div>
        `;
        bookingsList.appendChild(card);
    });
}

// Global scope for onclick
window.cancelBooking = function (id) {
    if (confirm('¿Seguro que quieres cancelar esta reserva?')) {
        state.bookings = state.bookings.filter(b => b.id !== id);
        localStorage.setItem('kiosk_bookings', JSON.stringify(state.bookings));
        renderBookings();
    }
};

// Start
init();
