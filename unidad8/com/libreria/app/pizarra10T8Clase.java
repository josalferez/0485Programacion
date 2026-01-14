
/**
 * Desarrollar una aplicación de consola en Java que simule un sistema de
 * gestión de inventario para una librería.
 * La aplicación debe permitir registrar ventas, actualizar las existencias
 * (stock) y generar un reporte final.
 * * =================================================================
 * REQUISITOS DEL SISTEMA DE INVENTARIO
 * =================================================================
 * * REQUISITOS FUNCIONALES:
 * * 1. Inventario Fijo (Datos): Usar un Array Bidimensional de String
 * (String[][]) llamado 'inventario'.
 * - Columna 0: Título del libro.
 * - Columna 1: Precio (como String).
 * - Columna 2: Stock (Cantidad disponible, como String).
 * * 2. Registro de Venta: Usar un Array de String de tamaño fijo (máximo 15
 * ítems) llamado 'carrito'.
 * - Debe usarse un contador (int) para rastrear cuántos ítems se han añadido al
 * carrito.
 * * 3. Interacción: Usar la clase Scanner dentro de un bucle while (condición
 * de salida: selección = 0).
 * * * REQUISITOS DE ESTRUCTURA Y CONCEPTOS (Java):
 * * 1. Método mostrarInventario: Método static que reciba 'inventario' y lo
 * imprima.
 * * 2. Lógica de Compra: Usar una estructura Switch para gestionar la selección
 * del cliente (libro 1, 2, 3, etc.).
 * * 3. Control de Stock (Doble If-Else): Dentro de cada 'case':
 * - PRIMER IF: Comprobar si hay stock disponible para ese libro (Stock > 0).
 * - SEGUNDO IF (anidado): Comprobar si el carrito ha alcanzado su límite de 15
 * ítems.
 * - Si es válido: Decrementar el stock en el 'inventario' (requiere String ->
 * int -> String), añadir al 'carrito', e incrementar el contador.
 * * 4. Método procesarVenta: Método static que reciba el 'carrito', el contador
 * y el 'inventario', y devuelva el ingreso total (double).
 * - Debe calcular el ingreso total y mostrar un listado de los títulos
 * vendidos.
 * * RESULTADO FINAL ESPERADO:
 * * Al introducir '0', el programa debe imprimir el Reporte de Venta final con
 * los ingresos totales.
 */

import java.util.Scanner;

public class pizarra10T8Clase {
    public static void main(String[] args) {

        String[][] inventario = {
                { "Título", "Precio", "Stock" },
                { "El Quijote", "5", "5" },
                { "El Lazarillo de Tormes", "15", "5" },
                { "La Celestina", "25", "5" },
                { "Siddharta", "10", "5" },
        };

        String[] carrito = new String[15];
        int contadorLibros = 0;
        int opcion = -1;
        Scanner sc = new Scanner(System.in);

        while (opcion != 0) {
            System.out.print("\033c"); // Limpio la pantalla
            System.out.println("----------- Nuestro Inventario ----------");
            System.out.println(" No.|    Título    |   Precio   |  Stock ");
            System.out.println("-----------------------------------------");
            for (int i = 1; i < inventario.length; i++) {
                System.out.printf("%d.  | %-25s | %-3s | %s\n", i, inventario[i][0], inventario[i][1], inventario[i][2]);
            }

            System.out.print("\nSeleccione un libro por número (0 para terminar): ");
            opcion = sc.nextInt();
            int stock = 0;

            switch (opcion) {
                case 0:
                    System.out.print("\033c"); // Limpio la pantalla
                    System.out.print("\nGracias por usar nuestro programa.");
                    break;
                case 1:
                    if (contadorLibros < carrito.length) {
                        if (Integer.parseInt(inventario[1][2]) > 0) {
                            // System.out.print("\033c"); // Limpio la pantalla
                            System.out.print("\nHas elegido el libro 1");
                            carrito[contadorLibros] = inventario[1][1]; // Lo añado al carrito
                            stock = Integer.parseInt(inventario[1][2]); // Calculo el stock
                            stock--; // Lo decremento en 1
                            inventario[1][2] = "" + stock; // Lo actualizo en la tabla
                            contadorLibros++; // Incremento el contador del carrito
                        } else {
                            System.out.println("\033c"); // Limpio la pantalla
                            System.out.println("\nNo hay más stock del libro 1");
                        }
                    } else {
                        System.out.print("\033c"); // Limpio la pantalla
                        System.out.print("\nNo puedes añadir más libros");
                    }
                    break;
                case 2:
                    if (contadorLibros < carrito.length) {
                        if (Integer.parseInt(inventario[2][2]) > 0) {
                            // System.out.print("\033c"); // Limpio la pantalla
                            System.out.print("\nHas elegido el libro 2");
                            carrito[contadorLibros] = inventario[2][1]; // Lo añado al carrito
                            stock = Integer.parseInt(inventario[2][2]); // Calculo el stock
                            stock--; // Lo decremento en 1
                            inventario[2][2] = "" + stock; // Lo actualizo en la tabla
                            contadorLibros++; // Incremento el contador del carrito
                        } else {
                            System.out.println("\033c"); // Limpio la pantalla
                            System.out.println("\nNo hay más stock del libro 2");
                        }
                    } else {
                        System.out.print("\033c"); // Limpio la pantalla
                        System.out.print("\nNo puedes añadir más libros");
                    }
                    break;
                case 3:
                    if (contadorLibros < carrito.length) {
                        if (Integer.parseInt(inventario[3][2]) > 0) {
                            // System.out.print("\033c"); // Limpio la pantalla
                            System.out.print("\nHas elegido el libro 3");
                            carrito[contadorLibros] = inventario[3][1]; // Lo añado al carrito
                            stock = Integer.parseInt(inventario[3][2]); // Calculo el stock
                            stock--; // Lo decremento en 1
                            inventario[3][2] = "" + stock; // Lo actualizo en la tabla
                            contadorLibros++; // Incremento el contador del carrito
                        } else {
                            System.out.println("\033c"); // Limpio la pantalla
                            System.out.println("\nNo hay más stock del libro 3");
                        }
                    } else {
                        System.out.print("\033c"); // Limpio la pantalla
                        System.out.print("\nNo puedes añadir más libros");
                    }
                    break;
                default:
                    System.out.print("\033c"); // Limpio la pantalla
                    System.out.println("¡¡¡¡Opción no válida. Por favor, elige un número entre 1 y 3.!!!!");
                    // Espero 2 segundos antes de continuar
                    try {
                        Thread.sleep(5000); // Paro 2000 milisegundos = 2 segundos
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    sc.nextLine(); // Limpiamos el buffer
                    break;
            }
        }
        sc.close(); // Libero el recurso
    }
}