
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

        Producto[] arrayProductos = { new Bebida("Café", "Grande", 2.0), new Comida("Croissant", "Dulce", 1.5) };

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
        System.out.println("Imprimo el ArrayList la primera vez \n");
        System.out.println(carrito);

        // Añado todos los productos del array estático al dinámico
        for(Producto pr : arrayProductos) {
            carrito.add(pr);
        }

        // Imprimo el arrayList
        System.out.println("Imprimo el arrayList la segunda vez");
        System.out.println(carrito);



    }
}