/*
Crear una aplicación de consola para 
gestionar un Sistema de Órdenes para un Restaurante 🥡.
*/
package com.restaurant.app;

import java.util.Scanner;

public class pizarra9T8Antigravity {
    public static void main(String[] args) {
        String[][] menu = {
                { "nombre", "precio" },
                { "migas", "8" },
                { "sardinas", "8" },
                { "arroz", "8" }
        };

        mostrarMenu(menu);

        Scanner sc = new Scanner(System.in);
        String[] orden = new String[10];
        int contadorOrdenes = 0;
        int opcion = -1;

        while (opcion != 0) {

            System.out.print("\nSeleccione platos por número (0 para terminar):");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    if (contadorOrdenes < 10) {

                        System.out.print("\033c"); // Limpio la pantalla
                        System.out.println("Has elegido el plato 1");
                        orden[contadorOrdenes] = menu[1][0];
                        contadorOrdenes++;
                        mostrarMenu(menu);
                    } else {
                        System.out.println("¡Mesa llena! No se pueden agregar más platos.");
                    }
                    break;
                case 2:
                    if (contadorOrdenes < 10) {
                        System.out.print("\033c"); // Limpio la pantalla
                        System.out.println("Has elegido el plato 2");
                        orden[contadorOrdenes] = menu[2][0];
                        contadorOrdenes++;
                        mostrarMenu(menu);
                    } else {
                        System.out.println("¡Mesa llena! No se pueden agregar más platos.");
                    }
                    break;
                case 3:
                    if (contadorOrdenes < 10) {
                        System.out.print("\033c"); // Limpio la pantalla
                        System.out.println("Has elegido el plato 3");
                        orden[contadorOrdenes] = menu[3][0];
                        contadorOrdenes++;
                        mostrarMenu(menu);
                    } else {
                        System.out.println("¡Mesa llena! No se pueden agregar más platos.");
                    }
                    break;
                default:
                    break;
            }

        }
        double totalFinal = 0.0;

        // 1. Invocar calcularTotal aquí
        totalFinal = calcularTotal(orden, contadorOrdenes, menu);

        // 2. Imprimir el resultado
        System.out.printf("\n--- FACTURA FINAL ---\n");
        System.out.printf("Total de ítems: %d\n", contadorOrdenes);
        System.out.printf("TOTAL A PAGAR: %.2f Euros\n", totalFinal);
        sc.close();

    }

    public static void mostrarMenu(String[][] menu) {
        System.out.println("--- Nuestro Menú ---");
        System.out.println("No. | Plato      | Precio");
        System.out.println("---------------------------");
        for (int i = 1; i < menu.length; i++) {
            System.out.printf("%d.  | %-10s | %s\n", i, menu[i][0], menu[i][1]);
        }
    }

    public static double calcularTotal(String[] orden, int contadorOrdenes, String[][] menu) {
        double total = 0.0;

        // Bucle FOR para recorrer la ORDEN (hasta contadorOrdenes)
        for (int i = 0; i < contadorOrdenes; i++) {
            String platoOrdenado = orden[i];

            // Bucle FOR-EACH para buscar el platoOrdenado en el MENU
            // Nota: Aquí necesitamos el índice para acceder al precio (Columna 1)
            // Por lo tanto, un bucle FOR tradicional en el menú podría ser más simple:
            for (int j = 1; j < menu.length; j++) { // Empezamos en j=1 para saltar la cabecera

                // Comparar el platoOrdenado con el nombre en el menú (Columna 0)
                if (platoOrdenado.equals(menu[j][0])) {
                    // Convertir el precio (Columna 1) a double y sumarlo al total
                    total += Double.parseDouble(menu[j][1]);
                    // Una vez encontrado el plato, podemos salir de este bucle interno
                    break;
                }
            }
        }

        return total;
    }
}
