
import java.util.ArrayList;


public class PruebaProducto {

    public static void main(String[] args) {

        boolean esSocio = true;
        /*
         * Bebida bebida1 = new Bebida("Café", "Grande", 2.0);
         * Comida comida1 = new Comida("Croissant", "Dulce", 1.5);
         * 
         * Producto[] arrayProductos = {bebida1, comida1};
         * 
         */

        Producto[] arrayProductos = { new Bebida("Mediano", "cafe", 2.0), new Comida("Croissant", "Dulce", 1.5) };

        for (Producto p : arrayProductos) {
            p.servir();

            System.out.println(p.calcularPrecio());
            System.out.println(p.calcularPrecio(esSocio));
            System.out.println(p.calcularPrecio(15));
        }


        // Creo un arrayList de Productos
        ArrayList<Producto> carrito = new ArrayList<>();


        // Añado una bebida al arrayList:
        carrito.add(new Bebida("Grande", "Matcha", 2.30));
        
        // Imprimo el arrayList
        System.out.println("\n Imprimo el ArrayList la primera vez");
        System.out.println(carrito);

        // Añado todos los productos del array estático al dinámico
        for(Producto pr : arrayProductos) {
            carrito.add(pr);
        }

        // Imprimo el arrayList
        System.out.println("\n Imprimo el arrayList la segunda vez");
        System.out.println(carrito);

        // modifico el valor del primer índice del arrayList
        carrito.set(0, new Bebida("Pequeño", "Té", 1.5)); // Cambia el primer elemento

        // Imprimo el arrayList
        System.out.println("\n Imprimo el arrayList la tercera vez");
        System.out.println(carrito);

        // Buscamos si en el arrayList hay una bebida que se llame café
        for (Producto producto : carrito) {
            if (producto.getNombre().equals("cafe"))
                System.out.println("Hay café en el carrito");
            else   
                System.out.println("No hay café en el carrito");
        }

        // 1. Probamos la comparación de productos. 
        Producto pr1 = new Producto("Galletas", 2);
        Producto pr2 = new Producto("Magdalenas", 6);

        if (pr1.equals(pr2)) System.out.println("Los productos son iguales"); else System.out.println("Los productos son distintos.");

        // Creo 2 bebidas y dos comidas y las comparo entre ellas y con los productos. 
        Bebida b1 = new Bebida("Grande", "Bebida 47", 2);
        Bebida b2 = new Bebida("Pequeños", "Bebida26", 2.40);
        Comida c1 = new Comida("Donete", "Donete", 1);
        Comida c2 = new Comida("Donete", "Donete", 1);

        if (b1.equals(b2)) System.out.println("Las bebidas son iguales"); else System.out.println("Los bebidas son distintas.");
        if (c1.equals(c2)) System.out.println("Las Comidas son iguales"); else System.out.println("Las comidas son distintas.");

        // Comparo ahora una bebida con con un Producto
        if (b1.equals(c1)) System.out.println("Las comparaciones son iguales"); else System.out.println("Las comparaciones son distintas.");

        // Comparo el producto del carrito con el siguiente 
        Producto anterior = null;
        for(Producto actual : carrito){
            if (anterior != null){
                if(actual.equals(anterior)) System.out.println("Los productos son iguales"); else System.out.println("Las comparaciones de productos en el foreach son distintas.");
            }
            anterior = actual;
        }
    }
}