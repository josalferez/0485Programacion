import java.util.Scanner;

public class PruebaArticulo {
    public static void main(String[] args) {

        // Creo un array de 10 artículos vacío
        Articulo[] almacen = new Articulo[10];
        int opcion = -1; // Inicializo el valor de opcion a -1 para que entre al menú
        Scanner sc = new Scanner(System.in);
        int numeroArticulos = 0;

        while (opcion != 7) {
            System.out.print("\033c"); // Limpio la pantalla
            System.out.println("\n--- MENÚ DE GESTIÓN ---");
            System.out.println("1. Listado");
            System.out.println("2. Alta");
            System.out.println("3. Baja");
            System.out.println("4. Modificación");
            System.out.println("5. Entrada de mercancía");
            System.out.println("6. Salida de mercancía");
            System.out.println("7. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    if (numeroArticulos != 0) {
                        for (Articulo articulo : almacen) {
                            if (articulo != null)
                                System.out.println(articulo.toString());
                        }
                    } else {
                        System.out.println("El almacén está vacío");
                    }
                    esperarSegundos();
                    break;
                case 2:
                    creaArticulo(almacen, numeroArticulos);
                    numeroArticulos++;
                    break;
                case 3:
                    System.out.println("Ejecutando: Baja...");
                    esperarSegundos();
                    break;
                case 4:
                    System.out.println("Ejecutando: Modificación...");
                    esperarSegundos();
                    break;
                case 5:
                    System.out.println("Ejecutando: Entrada de mercancía...");
                    esperarSegundos();
                    break;
                case 6:
                    System.out.println("Ejecutando: Salida de mercancía...");
                    esperarSegundos();
                    break;
                case 7:
                    System.out.println("Saliendo del programa. ¡Hasta pronto!");
                    esperarSegundos();
                    break;
                default:
                    System.out.println("Opción no válida. Inténtelo de nuevo.");
                    esperarSegundos();
            }
        }
    }

    // Metodo que simula una espera de 5 segundos
    public static void esperarSegundos() {
        try {
            // 5000 milisegundos = 5 segundos
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            System.out.println("La espera fue interrumpida.");
        }
    }

    // Metodo para añadir un artículo al almacén
    public static void creaArticulo(Articulo[] almacen, int indice) {

        Scanner sc = new Scanner(System.in);
        long codigo;
        String Descripcion;
        double precioCompra;
        double precioVenta;
        int stock;
        System.out.print("\033c"); // Limpio la pantalla

        System.out.print("Descripcion: ");
        Descripcion = sc.nextLine();

        System.out.print("Codigo: ");
        codigo = Long.parseLong(sc.nextLine());

        System.out.print("Precio de compra: ");
        precioCompra = Double.parseDouble(sc.nextLine());

        System.out.print("Precio de venta: ");
        precioVenta = Double.parseDouble(sc.nextLine());

        System.out.print("Stock: ");
        stock = Integer.parseInt(sc.nextLine());

        Articulo a = new Articulo(Descripcion, codigo, precioCompra, precioVenta, stock);
        almacen[indice] = a;

    }
}
