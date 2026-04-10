import java.util.Scanner;

/*
 * Escribe un programa que permita ir introduciendo una serie indeterminada
 * de números mientras su suma no supere el valor 10000. Cuando esto último
 * ocurra, se debe mostrar el total acumulado, el contador de los números
 * introducidos y la media.
 */
public class ejercicio23T5 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Inicialización de variables
        int sumaTotal = 0;
        int contador = 0;
        final int LIMITE = 10000;
        int numeroIntroducido; // Se declara aquí para ser accesible dentro del bucle

        System.out.println("--- Acumulador de Números ---");
        System.out.println("Introduce números. El programa se detendrá al SUPERAR el límite de " + LIMITE + ".");
        System.out.println("-----------------------------");

        // Bucle do-while: Se ejecuta al menos una vez y se repite mientras la suma no supere el límite.
        do {
            System.out.print("Introduce un número entero (Suma actual: " + sumaTotal + "): ");

            // 1. Validación de la entrada (evita errores si el usuario no introduce un número)
            if (sc.hasNextInt()) {
                numeroIntroducido = sc.nextInt();

                // 2. Comprobar si el número actual al sumarse SUPERARÁ el límite
                if (sumaTotal + numeroIntroducido > LIMITE) {
                    System.out.println("\nEl número " + numeroIntroducido + " hubiera superado el límite. El programa se detiene.");
                    break; // Salimos del bucle
                }

                // 3. Acumular y contar
                sumaTotal += numeroIntroducido;
                contador++;
            } else {
                System.out.println("ERROR: Entrada no válida. Por favor, introduce un número entero.");
                sc.next(); // Limpiamos el búfer del Scanner para evitar bucle infinito
            }

        } while (sumaTotal <= LIMITE);

        // Bloque de resultados finales
		System.out.println("\n=====================================");
        System.out.println("  RESULTADOS FINALES");
        System.out.println("=====================================");

        // CÁLCULOS Y RESULTADOS
        if (contador > 0) {
            // Se realiza la conversión a double para obtener una división con decimales
            double media = (double) sumaTotal / contador;

            System.out.println("Total acumulado:\t\t " + sumaTotal);
            System.out.println("Contador de números:\t " + contador);
            // Uso de printf para formatear la media a dos decimales
            System.out.printf("Media de los números:\t %.2f\n", media);
        } else {
            System.out.println("No se introdujo ningún número válido en la suma.");
        }
        
		// Liberamos el objeto scaner
		sc.close();
    }
}