/*
Realiza un programa que calcule el máximo, el mínimo y la media de una serie
de números enteros positivos introducidos por teclado. El programa terminará
cuando el usuario introduzca un número primo. Este último número no se
tendrá en cuenta en los cálculos. El programa debe indicar también cuántos
números ha introducido el usuario (sin contar el primo que sirve para salir).
*/

import java.util.Scanner;

public class ejercicio49T5 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numero = 0;             // Almacena el número introducido por el usuario
        int maximo = 0;             // Se inicializará con el primer número válido
        int minimo = 0;             // Se inicializará con el primer número válido
        long suma = 0;              // Usamos 'long' para evitar desbordamientos de la suma
        int contador = 0;           // Cuenta la cantidad de números introducidos (sin el primo)
        boolean primerNumero = true; // Bandera para inicializar correctamente
        boolean esNumeroPrimo;      // Bandera para la verificación de primalidad

        System.out.println("------------------------------------------------------------------");
        System.out.println("Calculadora de Máximo, Mínimo y Media de Enteros Positivos");
        System.out.println("   El programa terminará cuando introduzcas un número primo.");
        System.out.println("------------------------------------------------------------------");

        // --- Bucle principal de lectura y cálculo ---
        do {
            System.out.print("Introduce un número entero positivo (o un primo para terminar): ");

            // 1. Manejo y validación de la entrada
            if (!scanner.hasNextInt()) {
                System.out.println("Error: Por favor, introduce un número entero válido.");
                scanner.next(); // Descartar la entrada no válida
                continue; // Volver al inicio del bucle
            }

            numero = scanner.nextInt();

            // 2. Validación de número positivo
            if (numero <= 0) {
                System.out.println("Advertencia: Solo se procesan números enteros positivos. Inténtalo de nuevo.");
                continue; // Volver al inicio del bucle
            }

            // 3. Lógica para verificar si el número introducido es PRIMO
            esNumeroPrimo = true; // Asumimos que es primo al inicio
            
            // Un número positivo mayor que 1 es el que se analiza
            // (Ya sabemos que 'numero' es > 0 por la validación anterior)
            if (numero == 1) { // 1 no es primo
                esNumeroPrimo = false;
            } else {
                // Comprobación de divisibilidad hasta la raíz cuadrada del número
                for (int i = 2; i < numero; i++) {
				//for (int i = 2; i * i <= numero; i++) { Esta forma es más eficiente MEMORIZARLA
                    if (numero % i == 0) {
                        esNumeroPrimo = false; // Es divisible por otro número, no es primo
                        break;                 // Rompemos el bucle interno de primalidad
                    }
                }
            }

            // 4. Condición de salida: Si el número es primo, salimos del bucle
            if (esNumeroPrimo) {
                System.out.println("\nHas introducido un número primo (" + numero + "). El programa ha finalizado.");
                break;
            }

            // 5. Procesamiento del número (si no es el de salida)
            // Inicialización de mínimo y máximo con el primer número válido
            if (primerNumero) {
                maximo = numero;
                minimo = numero;
                primerNumero = false; // Desactivamos la bandera después de la primera inicialización
            } else {
                // Actualización del Máximo
                if (numero > maximo) {
                    maximo = numero;
                }
                // Actualización del Mínimo
                if (numero < minimo) {
                    minimo = numero;
                }
            }

            // Acumulación de la suma y el contador
            suma += numero;
            contador++;

        } while (true); // Bucle infinito que se rompe con el 'break'

        scanner.close();

        // --- 6. Mostrar resultados ---
        System.out.println("\n=====================================");
        if (contador > 0) {
            double media = (double) suma / contador; // Cálculo de la media
            
            System.out.println("Resumen de los " + contador + " números introducidos:");
            System.out.println("   - Máximo: " + maximo);
            System.out.println("   - Mínimo: " + minimo);
            System.out.printf("   - Media: %.2f%n", media);
        } else {
            System.out.println("No se introdujeron números válidos antes de salir.");
        }
        System.out.println("=====================================");
    }
}