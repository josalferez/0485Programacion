import java.util.Scanner;

public class esPrimo { // 1. Clase con nombre en CamelCase (convención)

    // Función principal para la ejecución
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Introduce un número entero: ");
        int numero = sc.nextInt();
        
        sc.close(); // Buena práctica: cerrar el Scanner

        // 2. Llamamos a la función que implementa la lógica
        if (esPrimo(numero)) { 
            System.out.println("El número " + numero + " ES primo.");
        } else {
            System.out.println("El número " + numero + " NO es primo.");
        }
    }

    /**
     * Comprueba si un número entero positivo es primo.
     * @param n El número a verificar.
     * @return true si es primo, false si no lo es.
     */
    public static boolean esPrimo(int n) { // 3. El método de lógica es boolean

        // Caso 1: Los números menores o iguales a 1 NO son primos.
        if (n <= 1) {
            return false;
        }

        // Caso 2: El 2 y 3 son primos, pero la lógica del bucle funciona bien
        // para ellos, aunque podemos optimizar:
        if (n <= 3) {
            return true;
        }

        // Caso 3: Bucle de comprobación.
        // Solo necesitamos buscar divisores hasta la raíz cuadrada del número.
        // Si no encontramos ningún divisor hasta ahí, no lo encontraremos después.
        // Usamos 'i * i <= n' para evitar llamar a Math.sqrt() en cada iteración.
        for (int i = 2; i * i <= n; i++) {
            
            // Si encontramos algún divisor (el resto de la división es 0), NO es primo.
            if (n % i == 0) {
                return false; 
            }
        }

        // Si el bucle termina sin encontrar divisores, ES primo.
        return true;
    }
}