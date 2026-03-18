<?php

use Illuminate\Support\Facades\Route;
use App\Http\Controllers\MenuController;
use App\Http\Controllers\OrderController;
use App\Http\Controllers\RechargeRequestController;

use App\Http\Controllers\LoginController;

Route::get('/', [LoginController::class, 'show'])->name('login');
Route::post('/login', [LoginController::class, 'login'])->name('login.post');
Route::post('/logout', [LoginController::class, 'logout'])->name('logout');

// Kiosk Routes (Authenticated)
Route::middleware('auth')->group(function () {
    Route::get('/kiosk', [MenuController::class, 'index'])->name('home');
    // Order Management
    Route::post('/order', [OrderController::class, 'store'])->name('order.store');
    Route::get('/order/{order}', [OrderController::class, 'show'])->name('order.show');
    
    // User Features
    Route::get('/mis-pedidos', [OrderController::class, 'history'])->name('orders.history');
    Route::get('/mis-recargas', [RechargeRequestController::class, 'myRecharges'])->name('my.recharges');
    Route::get('/recargar', [OrderController::class, 'showRecharge'])->name('recharge.show');
    Route::post('/recargar', [OrderController::class, 'recharge'])->name('recharge.post');

    // Admin Routes
    Route::get('/admin', function () {
        return view('admin.dashboard');
    })->name('admin.dashboard');
    
    Route::get('/admin/recharges', [OrderController::class, 'showRechargeRequests'])->name('admin.recharges');
    Route::post('/admin/recharges/{request}/approve', [OrderController::class, 'approveRecharge'])->name('admin.recharges.approve');
    Route::post('/admin/recharges/{request}/reject', [OrderController::class, 'rejectRecharge'])->name('admin.recharges.reject');
});
