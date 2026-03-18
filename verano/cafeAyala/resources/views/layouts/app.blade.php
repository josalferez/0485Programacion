<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Café Ayala - Kiosk</title>
    <link rel="icon" type="image/png" href="{{ asset('favicon.png') }}">
    <link rel="stylesheet" href="{{ asset('css/kiosk.css') }}">
    <!-- Fonts -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Inter:wght@400;600;800&display=swap" rel="stylesheet">
    <meta name="csrf-token" content="{{ csrf_token() }}">
</head>
<body>
    @auth
        <div style="background: white; border-bottom: 1px solid #ddd; padding: 0.75rem 1.5rem; display: flex; justify-content: space-between; align-items: center; position: fixed; top: 0; left: 0; right: 0; height: 60px; z-index: 1000;">
            <div style="font-weight: 800; font-size: 1.25rem; color: var(--dark);">
                <a href="{{ route('home') }}" style="text-decoration: none; color: inherit;">Café Ayala</a>
            </div>
            
            @if(request()->routeIs('admin.dashboard'))
                 <div>Admin Panel</div>
            @else
                <div style="display: flex; gap: 1rem; align-items: center;">
                    <a href="{{ route('recharge.show') }}" style="padding: 0.5rem 1rem; background: var(--secondary); color: var(--dark); border-radius: 50px; text-decoration: none; font-weight: bold; font-size: 0.9rem;">
                        + Recargar
                    </a>
                    
                    <!-- User Info (non-clickable) -->
                    <div style="display: flex; flex-direction: column; text-align: right; font-size: 0.9rem;">
                        <span style="font-weight: bold; color: var(--dark);">{{ Auth::user()->name }}</span>
                        <span style="color: var(--secondary); font-weight: 800;">{{ number_format(Auth::user()->balance, 2) }}€</span>
                    </div>
                    
                    <!-- Hamburger Menu -->
                    <div style="position: relative;">
                        <button onclick="toggleUserMenu()" style="background: none; border: 3px solid var(--dark); border-radius: 8px; cursor: pointer; padding: 0.5rem; display: flex; flex-direction: column; gap: 4px; width: 40px; height: 40px; justify-content: center; align-items: center;">
                            <span style="display: block; width: 20px; height: 4px; background: var(--dark); border-radius: 2px;"></span>
                            <span style="display: block; width: 20px; height: 4px; background: var(--dark); border-radius: 2px;"></span>
                            <span style="display: block; width: 20px; height: 4px; background: var(--dark); border-radius: 2px;"></span>
                        </button>
                        
                        <div id="user-menu" style="display: none; position: absolute; right: 0; top: 100%; background: white; border-radius: 8px; box-shadow: 0 4px 12px rgba(0,0,0,0.15); min-width: 200px; z-index: 1001; margin-top: 0.5rem;">
                            <a href="{{ route('orders.history') }}" style="display: block; padding: 0.75rem 1rem; text-decoration: none; color: var(--dark); border-bottom: 1px solid #eee; transition: background 0.2s;">
                                📦 Mis Pedidos
                            </a>
                            <a href="{{ route('my.recharges') }}" style="display: block; padding: 0.75rem 1rem; text-decoration: none; color: var(--dark); border-bottom: 1px solid #eee; transition: background 0.2s;">
                                💰 Mis Recargas
                            </a>
                            <form action="{{ route('logout') }}" method="POST" style="margin: 0;">
                                @csrf
                                <button type="submit" style="width: 100%; text-align: left; padding: 0.75rem 1rem; background: none; border: none; color: var(--dark); cursor: pointer; font-size: 1rem; transition: background 0.2s;">
                                    🚪 Salir
                                </button>
                            </form>
                        </div>
                    </div>
                </div>
                
                <script>
                    function toggleUserMenu() {
                        const menu = document.getElementById('user-menu');
                        menu.style.display = menu.style.display === 'none' ? 'block' : 'none';
                    }
                    
                    // Close menu when clicking outside
                    document.addEventListener('click', function(event) {
                        const menu = document.getElementById('user-menu');
                        const button = event.target.closest('button[onclick="toggleUserMenu()"]');
                        if (!button && !menu.contains(event.target)) {
                            menu.style.display = 'none';
                        }
                    });
                </script>
                
                <style>
                    #user-menu a:hover, #user-menu button:hover {
                        background: #f5f5f5;
                    }
                </style>
            @endif
        </div>
        <div style="height: 60px;"></div> <!-- Spacer for fixed header -->
    @endauth

    @yield('content')
    
    @stack('scripts')
</body>
</html>
