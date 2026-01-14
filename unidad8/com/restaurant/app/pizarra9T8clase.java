package com.restaurant.app;

/**
 * Desarrollar una aplicación de consola en Java que simule el sistema de toma de órdenes y facturación para un restaurante con un menú fijo.
 * * =================================================================
 * REQUISITOS DEL SISTEMA DE ÓRDENES
 * =================================================================
 * * REQUISITOS FUNCIONALES:
 * * 1. Menú Fijo: Usar un Array Bidimensional de String (String[][]) para almacenar al menos 3 platos:
 * - Columna 0: Nombre del plato.
 * - Columna 1: Precio (como String).
 * * 2. Almacenamiento de la Orden: Usar un Array de String de tamaño fijo (máximo 10 ítems) para almacenar la orden.
 * - Debe usarse un contador (int) para rastrear cuántos ítems reales se han añadido.
 * * 3. Interacción: Usar la clase Scanner dentro de un bucle while (condición de salida: selección = 0) para tomar la orden.
 * * * REQUISITOS DE ESTRUCTURA Y CONCEPTOS (Java):
 * * 1. Package: El código debe estar contenido dentro de un package llamado 'com.restaurant.app'.
 * * 2. Método mostrarMenu: Método static que reciba el menú y lo imprima.
 * - Debe usar una combinación de bucle for tradicional (para numerar) y for-each (para iterar los detalles).
 * * 3. Toma de Decisión: Usar una estructura Switch para gestionar la selección del cliente (plato 1, 2, 3 o 0).
 * * 4. Control de Límites: Usar If-Else Anidados dentro de cada 'case' para comprobar el límite de 10 ítems antes de añadir el plato.
 * * 5. Método calcularTotal: Método static que reciba la orden, el contador y el menú, y devuelva el precio total (double).
 * - Debe iterar sobre la orden y buscar el precio del plato en el array bidimensional del menú.
 * - Debe convertir el precio de String a double (usando Double.parseDouble()) para sumar el total.
 * * RESULTADO FINAL ESPERADO:
 * * Al introducir '0', el programa debe imprimir por consola la factura final (total de ítems y coste total).
 */

import java.util.Scanner;

public class pizarra9T8clase {
    public static void main(String[] args) {
        String[][] menu = {
                { "Plato", "Precio" },
                { "Migas", "8" },
                { "Arroz", "8" },
                { "Espaguetis", "4" }
        };

        String[] orden = new String[10];
        int ordenContador = 0;
        int opcion = -1; // Inicializo opcion a -1 para que entre en el menú
        Scanner sc = new Scanner(System.in);
        double total = 0.0;

        while (opcion != 0) {
            mostrarMenu(menu);
            opcion = sc.nextInt();
            if (opcion == 0) {
                System.out.println("Gracias por venir a nuestro restaurante");
            } else {
                // 3. Toma de decisión
                switch (opcion) {
                    case 1:
                        if (ordenContador < orden.length) {
                            // 1. Añado la comanda
                            orden[ordenContador] = menu[1][0];

                            // 5. Calcular el total
                            total += calcularTotal(orden, ordenContador, menu);

                            // Incremento el contador
                            ordenContador++;

                        } else {
                            System.out.print("\033c"); // Limpio la pantalla
                            System.out.println("No puedes pedir más platos.");
                        }
                        break;

                    case 2:
                        if (ordenContador < orden.length) {
                            // 1. Añado la comanda
                            orden[ordenContador] = menu[2][0];

                            // 5. Calcular el total
                            total += calcularTotal(orden, ordenContador, menu);

                            // Incremento el contador
                            ordenContador++;

                        } else {
                            System.out.print("\033c"); // Limpio la pantalla
                            System.out.println("No puedes pedir más platos.");
                        }
                        break;

                    case 3:
                        if (ordenContador < orden.length) {
                            // 1. Añado la comanda
                            orden[ordenContador] = menu[1][0];

                            // 5. Calcular el total
                            total += calcularTotal(orden, ordenContador, menu);

                            // Incremento el contador
                            ordenContador++;

                        } else {
                            System.out.print("\033c"); // Limpio la pantalla
                            System.out.println("No puedes pedir más platos.");
                        }
                        break;
                    case 4:
                        if (ordenContador < orden.length) {
                            // 1. Añado la comanda
                            orden[ordenContador] = menu[1][0];

                            // 5. Calcular el total
                            total += calcularTotal(orden, ordenContador, menu);

                            // Incremento el contador
                            ordenContador++;

                        } else {
                            System.out.print("\033c"); // Limpio la pantalla
                            System.out.println("No puedes pedir más platos.");
                        }
                        break;

                    default:
                        break;
                }
            }
        }

        // 6. Imprimir el resultado
        System.out.printf("\n--- FACTURA FINAL ---\n");
        System.out.printf("Total de ítems: %d\n", ordenContador);
        System.out.printf("TOTAL A PAGAR: %.2f Euros\n", total);

        // Cierro el Scanner
        sc.close();
    }

    public static void mostrarMenu(String[][] menu) {
        // Muestro el menú
        System.out.println("--- Nuestro Menú ---");
        System.out.println("No. | Plato      | Precio");
        System.out.println("---------------------------");
        for (int i = 1; i < menu.length; i++) {
            System.out.printf("%d.  | %-10s | %s\n", i, menu[i][0], menu[i][1]);
        }
        System.out.print("\nSeleccione platos por número (0 para terminar):");
    }

    public static double calcularTotal(String[] orden, int ordenContador, String[][] menu) {
        double total = 0.0;

        for (int i = 1; i < menu.length; i++) {
            if (menu[i][0].equals(orden[ordenContador]))
                total = Double.parseDouble(menu[i][1]);
        }
        return total;
    }
}
