import java.util.Scanner;

/**
 * Ejercicio 36: Comprueba si un número introducido por teclado es capicúa.
 * Utiliza el tipo 'long' para números largos.
 */
public class Ejercicio36T5 {

    public static void main(String[] args) {
        // Inicialización del Scanner
        Scanner scanner = new Scanner(System.in);

        // --- 1. Entrada de Datos ---
        System.out.print("Por favor, introduzca un número entero positivo (long):");
        
        // Se lee directamente como long
        long numeroOriginal = scanner.nextLong();
        scanner.close();

        // Variables para el proceso
        // numeroTemp es la copia que se modificará en el bucle.
        long numeroTemp = numeroOriginal; 
        // numeroInvertido almacenará el resultado.
        long numeroInvertido = 0;

        // --- 2. Validación Básica (Opcional, pero recomendado) ---
        if (numeroOriginal < 0) {
            System.out.println("Error: El programa solo procesa números positivos.");
            return;
        }

        // --- 3. Proceso: Invertir el Número (Usando el Bucle while) ---
        while (numeroTemp > 0) {
            // 1. Obtener el último dígito con el operador módulo (%)
            long digito = numeroTemp % 10;

            // 2. Construir el número invertido: desplazar y sumar el nuevo dígito
            numeroInvertido = (numeroInvertido * 10) + digito;

            // 3. Eliminar el último dígito con la división entera (/)
            numeroTemp = numeroTemp / 10; 
        }

        // --- 4. Salida y Comparación ---
        System.out.println("------------------------------------");
        System.out.println("El número introducido es: " + numeroOriginal);

        if (numeroOriginal == numeroInvertido) {
            System.out.println("El " + numeroOriginal + " es capicúa.");
        } else {
            System.out.println("El " + numeroOriginal + " no es capicúa.");
        }
    }
}