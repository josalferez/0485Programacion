

public class PruebaProducto {

    public static void main(String[] args) {

        boolean esSocio = true;

        Bebida bebida1 = new Bebida("Café", "Grande", 2.0);
        Comida comida1 = new Comida("Croissant", "Dulce", 1.5);

        Producto[] arrayProductos = {bebida1, comida1};

        for (Producto p : arrayProductos) {
            p.servir();
        }

        System.out.println(bebida1.calcularPrecio());
        System.out.println(bebida1.calcularPrecio(esSocio));
        System.out.println(bebida1.calcularPrecio(15));

        

        

    }
}