
/**
 * Desarrollar una aplicación de consola en Java que simule un sistema de gestión de inventario para una librería.
 * La aplicación debe permitir registrar ventas, actualizar las existencias (stock) y generar un reporte final.
 * * =================================================================
 * REQUISITOS DEL SISTEMA DE INVENTARIO
 * =================================================================
 * * REQUISITOS FUNCIONALES:
 * * 1. Inventario Fijo (Datos): Usar un Array Bidimensional de String (String[][]) llamado 'inventario'.
 * - Columna 0: Título del libro.
 * - Columna 1: Precio (como String).
 * - Columna 2: Stock (Cantidad disponible, como String).
 * * 2. Registro de Venta: Usar un Array de String de tamaño fijo (máximo 15 ítems) llamado 'carrito'.
 * - Debe usarse un contador (int) para rastrear cuántos ítems se han añadido al carrito.
 * * 3. Interacción: Usar la clase Scanner dentro de un bucle while (condición de salida: selección = 0).
 * * * REQUISITOS DE ESTRUCTURA Y CONCEPTOS (Java):
 * * 1. Método mostrarInventario: Método static que reciba 'inventario' y lo imprima.
 * * 2. Lógica de Compra: Usar una estructura Switch para gestionar la selección del cliente (libro 1, 2, 3, etc.).
 * * 3. Control de Stock (Doble If-Else): Dentro de cada 'case':
 * - PRIMER IF: Comprobar si hay stock disponible para ese libro (Stock > 0).
 * - SEGUNDO IF (anidado): Comprobar si el carrito ha alcanzado su límite de 15 ítems.
 * - Si es válido: Decrementar el stock en el 'inventario' (requiere String -> int -> String), añadir al 'carrito', e incrementar el contador.
 * * 4. Método procesarVenta: Método static que reciba el 'carrito', el contador y el 'inventario', y devuelva el ingreso total (double).
 * - Debe calcular el ingreso total y mostrar un listado de los títulos vendidos.
 * * RESULTADO FINAL ESPERADO:
 * * Al introducir '0', el programa debe imprimir el Reporte de Venta final con los ingresos totales.
 */

import java.util.Scanner;

public class pizarra10T8 {
    public static void main(String[] args) {
        String[][] inventario = new String[4][3];

        // Inicializo la fila 0 con los datos, título, precio, stock
        inventario[0][0] = "Título";
        inventario[0][1] = "Precio";
        inventario[0][2] = "Stock";

        // Añado el libro 1
        inventario[1][0] = "Libro 1";
        inventario[1][1] = "10";
        inventario[1][2] = "5";

        // Añado el libro 2
        inventario[2][0] = "Libro 2";
        inventario[2][1] = "30";
        inventario[2][2] = "15";

        // Añado el libro 3
        inventario[3][0] = "Libro 3";
        inventario[3][1] = "40";
        inventario[3][2] = "20";

        String[] carrito = new String[15];
        int contadorCarrito = 0;

        Scanner sc = new Scanner(System.in);
        int seleccion = -1;

        while (seleccion != 0) {
            System.out.print("\033c"); // Limpio la pantalla
            // Mostramos el inventario
            mostrarInventario(inventario);
            System.out.print("\nSeleccione un libro por número (0 para terminar): ");
            seleccion = sc.nextInt();

            switch (seleccion) {
                case 1:
                    if (contadorCarrito < 15) {
                        System.out.print("\033c"); // Limpio la pantalla
                        System.out.println("Has elegido el libro 1");
                        carrito[contadorCarrito] = inventario[1][0];
                        contadorCarrito++;
                        reducirStock(inventario, 1);
                        mostrarInventario(inventario);
                    } else {
                        System.out.println("¡Carrito lleno! No se pueden agregar más libros.");
                    }
                    break;
                case 2:
                    if (contadorCarrito < 15) {
                        System.out.print("\033c"); // Limpio la pantalla
                        System.out.println("Has elegido el libro 2");
                        carrito[contadorCarrito] = inventario[2][0];
                        contadorCarrito++;
                        reducirStock(inventario, 2);
                        mostrarInventario(inventario);
                    } else {
                        System.out.println("¡Carrito lleno! No se pueden agregar más libros.");
                    }
                    break;
                case 3:
                    if (contadorCarrito < 15) {
                        System.out.print("\033c"); // Limpio la pantalla
                        System.out.println("Has elegido el libro 3");
                        carrito[contadorCarrito] = inventario[3][0];
                        contadorCarrito++;
                        reducirStock(inventario, 3);
                        mostrarInventario(inventario);
                    } else {
                        System.out.println("¡Carrito lleno! No se pueden agregar más libros.");
                    }
                    break;
                case 0:
                    break;

                default:
                    System.out.print("\033c"); // Limpio la pantalla
                    System.out.println("¡¡¡¡Opción no válida. Por favor, elige un número entre 1 y 3.!!!!");
                    // Espero 2 segundos antes de continuar
                    try {
                        Thread.sleep(2000); // Paro 2000 milisegundos = 2 segundos
                        
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    sc.nextLine(); // Limpiamos el buffer
                    break;
            }
        }

        double total = procesarVenta(carrito, contadorCarrito, inventario);
        System.out.printf("\n--- FACTURA FINAL ---\n");
        System.out.printf("Total de ítems: %d\n", contadorCarrito);
        System.out.printf("TOTAL A PAGAR: %.2f Euros\n", total);
        sc.close();
    }

    public static void mostrarInventario(String[][] inventario) {
        System.out.println("--- Nuestro Inventario ---");
        System.out.println("No. | Título   | Precio | Stock");
        System.out.println("---------------------------");
        for (int i = 1; i < inventario.length; i++) {
            System.out.printf("%d.  | %-10s | %s | %s\n", i, inventario[i][0], inventario[i][1], inventario[i][2]);
        }
    }

    public static double procesarVenta(String[] carrito, int contadorCarrito, String[][] inventario) {
        double total = 0.0;

        for (int i = 0; i < contadorCarrito; i++) {
            String libroSeleccionado = carrito[i];

            for (int j = 1; j < inventario.length; j++) {
                if (libroSeleccionado.equals(inventario[j][0])) {
                    total += Double.parseDouble(inventario[j][1]);
                    break;
                }
            }
        }

        return total;
    }

    // Metodo para reducir el stock
    public static void reducirStock(String[][] inventario, int libroSeleccionado) {
        int stockActual = Integer.parseInt(inventario[libroSeleccionado][2]);
        if (stockActual > 0) {
            inventario[libroSeleccionado][2] = String.valueOf(stockActual - 1);
        }
    }
}
