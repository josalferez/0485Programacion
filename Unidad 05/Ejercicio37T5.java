import java.util.Scanner;

/**
 * Ejercicio 37: Conversor del sistema decimal al sistema de “palotes”.
 * Utiliza el tipo 'long' y la técnica estándar de inversión.
 */
public class Ejercicio37T5 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long numeroOriginal;

        // 1. Entrada de datos
        System.out.print("Por favor, introduzca un número entero positivo (long):");
        numeroOriginal = scanner.nextLong();
        scanner.close();

        // Validación simple
        if (numeroOriginal < 0) {
            System.out.println("Error: El número debe ser positivo.");
            return;
        }

        // Manejo del Cero
        if (numeroOriginal == 0) {
            System.out.println("El 0 en decimal es el - en el sistema de palotes.");
            return;
        }

        // --- 2. Preparación: Invertir el Número  ---
        // Necesario para procesar los dígitos de izquierda a derecha (orden de lectura).
        long numeroTemp = numeroOriginal;
        long numeroInvertido = 0;

        // El bucle solicitado para la inversión:
        while (numeroTemp > 0) {
            // 1. Obtener el último dígito con el operador módulo (%)
            long digito = numeroTemp % 10;

            // 2. Construir el número invertido: desplazar y sumar el nuevo dígito
            numeroInvertido = (numeroInvertido * 10) + digito;

            // 3. Eliminar el último dígito con la división entera (/)
            numeroTemp = numeroTemp / 10; 
        }

        // --- 3. Conversión a Palotes (Bucles Anidados) ---

        // La longitud original es necesaria para controlar las iteraciones y el separador.
        // Se usa String.valueOf().length() para obtener el número de dígitos sin un bucle adicional.
        int longitud = String.valueOf(numeroOriginal).length();  // Obtengo la longitud del número
        long numeroProcesar = numeroInvertido;

        // Inicio de la salida
        System.out.print("El " + numeroOriginal + " en decimal es el ");

        // Bucle exterior: Itera por cada dígito del número (ahora en orden correcto)
        for (int i = 0; i < longitud; i++) {

            // a. Obtener el dígito actual
            int digito = (int) (numeroProcesar % 10);

            // b. Imprimir la representación del dígito
            if (digito == 0) {
                // Representación del CERO
                System.out.print("-");
            } else {
                // Bucle anidado: Imprime '| ' 'digito' veces
                for (int j = 0; j < digito; j++) {
                    System.out.print("| ");
                }
            }

            // c. Imprimir el separador (guion)
            // Se imprime el separador si NO es el último dígito
            if (i < longitud - 1) {
                System.out.print(" - ");
            }

            // d. Pasar al siguiente dígito del número invertido
            numeroProcesar = numeroProcesar / 10;
        }

        // Final de la salida
        System.out.println(" en el sistema de palotes.");
    }
}