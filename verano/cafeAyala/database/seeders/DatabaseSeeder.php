<?php

namespace Database\Seeders;

use Illuminate\Database\Seeder;
use App\Models\Category;
use App\Models\Product;

class DatabaseSeeder extends Seeder
{
    public function run(): void
    {
        $cat1 = Category::create(['name' => 'Cafés', 'image' => '/images/cafe-solo.png']);
        $cat2 = Category::create(['name' => 'Bollos', 'image' => '/images/croissant.png']);
        $cat3 = Category::create(['name' => 'Bebidas Frías', 'image' => '/images/coca-cola.png']);

        Product::create([
            'category_id' => $cat1->id,
            'name' => 'Café Solo',
            'price' => 1.20,
            'image' => '/images/cafe-solo.png',
            'description' => 'Intenso café espresso.'
        ]);
        Product::create([
            'category_id' => $cat1->id,
            'name' => 'Café con Leche',
            'price' => 1.50,
            'image' => '/images/cafe-con-leche.png',
            'description' => 'Suave café con leche cremosa.'
        ]);
        Product::create([
            'category_id' => $cat2->id,
            'name' => 'Croissant',
            'price' => 1.80,
            'image' => '/images/croissant.png',
            'description' => 'Crujiente y mantequilloso.'
        ]);
        Product::create([
            'category_id' => $cat3->id,
            'name' => 'Coca Cola',
            'price' => 2.00,
            'image' => '/images/coca-cola.png',
            'description' => 'Refrescante.'
        ]);

        // Users
        \App\Models\User::factory()->create([
            'name' => 'Cliente',
            'email' => 'a',
            'password' => 'a',
            'balance' => 50.00,
        ]);

        \App\Models\User::factory()->create([
            'name' => 'Admin',
            'email' => 'aa',
            'password' => 'aa',
            'balance' => 1000.00,
        ]);
    }
}
