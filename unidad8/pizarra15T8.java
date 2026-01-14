/**
 * Ejercicio Propuesto: Doble Diagonal y Condición de Mayoría
 *
 * Objetivo:
 * Realizar un programa que genere un array cuadrado de 11 filas por 11 columnas
 * (un array 11x11) rellenándolo con números aleatorios entre 200 y 800.
 *
 * A continuación, el programa debe:
 *
 * 1. Imprimir la matriz completa por pantalla.
 *
 * 2. Identificar y mostrar los números de las dos diagonales principales:
 * - Diagonal Principal (DP): Superior Izquierda a Inferior Derecha (i == j).
 * - Diagonal Secundaria (DS): Inferior Izquierda a Superior Derecha (i + j ==
 * 10).
 *
 * 3. Calcular la suma total de los elementos que componen la Diagonal Principal
 * (DP)
 * y la media de los elementos de la Diagonal Secundaria (DS).
 *
 * 4. Verificar una Condición:
 * Contar cuántos elementos de la matriz NO DIAGONAL (elementos que no están
 * ni en DP ni en DS) son mayores que la suma total de la Diagonal Principal
 * (calculada en el punto anterior).
 *
 * 5. Mostrar por pantalla la suma de la DP, la media de la DS y el conteo de
 * elementos no diagonales que cumplen la condición.
 *
 * Pistas para la Implementación:
 * - El tamaño del array es N=11 (índices de 0 a 10).
 * - Condición de Diagonal Principal (DP): i == j.
 * - Condición de Diagonal Secundaria (DS): i + j == 10.
 * - Un elemento NO DIAGONAL cumple: (i != j) AND (i + j != 10).
 */

public class pizarra15T8 {
    public static void main(String[] args) {
        int[][] array = new int[11][11];
        int promedio = 0;
        int maximo = Integer.MIN_VALUE;
        int minimo = Integer.MAX_VALUE;
        int sumaTotalDP = 0;

        // Relleno el array con números entre 500 y 900
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                array[i][j] = (int) (Math.random() * 600) + 500;
                System.out.print(array[i][j] + " ");
                sumaTotalDP += array[i][j];
            }
            System.out.println();
        }

        // Imprimo los números de la diagonal principal
        System.out.println("El contenido de la diagonal principal es: ");
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (i == j)
                    System.out.print(array[i][j] + " ");
            }
            System.out.print(" ");
        }

        // Imprimo los números de la diagonal secundaria
        System.out.println("");
        System.out.println("El contenido de la diagonal secundaria es: ");
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (i + j == 9)
                    System.out.print(array[i][j] + " ");
            }
            System.out.print(" ");
        }

        // Imprimo los resultados
        System.out.println("");
        System.out.println("-------IMPRIMO RESULTADOS-----");
        System.out.println(" La suma de la DP es: " + sumaTotalDP);

    }
}