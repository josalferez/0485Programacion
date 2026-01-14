import java.util.Scanner;

public class BucleDoWhileControl {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numero;

        do {
            // 1. Pedir un número al usuario
            System.out.print("Ingrese un número (o un negativo para salir): ");
            numero = scanner.nextInt();

            // 🛑 Uso de BREAK (Terminación Completa)
            // Si el número es negativo, salimos del bucle do-while.
            if (numero < 0) {
                System.out.println("Se ingresó un número negativo. Terminando el bucle inmediatamente.");
                break; // *** Sale completamente del bucle ***
            }

            // ➡️ Uso de CONTINUE (Saltar Iteración)
            // Si el número es impar, saltamos el resto del código en esta iteración.
            if (numero % 2 != 0) {
                System.out.printf("El número %d es impar. Saltando al siguiente número (no se procesa).\n", numero);
                continue; // *** Salta al 'while' para la siguiente iteración ***
            }

            // --- Parte de procesamiento (Solo para números pares y no negativos) ---
            System.out.printf("El número %d es par. Procesando el valor...\n", numero);
            // Aquí iría más código de procesamiento (ej. suma, cálculo, etc.)
            
        } while (numero <= 100); // El bucle continúa mientras el número ingresado sea menor o igual a 100.

        System.out.println("\nFin del programa Java.");
        scanner.close();
    }
}