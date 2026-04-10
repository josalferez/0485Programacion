import java.util.Scanner;

public class ejercicio2T7Bi {

    public static void main(String[] args) {
        // Constantes para el tamaño del array
        final int FILAS = 4;
        final int COLUMNAS = 5;
		final int MAX_RANGO_VALOR = 200;

        // Array para almacenar los números (4 filas x 5 columnas)
        int[][] numeros = new int[FILAS][COLUMNAS];
        
        // Arrays para almacenar las sumas
        int[] sumaFilas = new int[FILAS];
        int[] sumaColumnas = new int[COLUMNAS];
        int sumaTotal = 0;

        Scanner s = new Scanner(System.in);

        // 1. Pedir e introducir los 20 números en el array
        System.out.println("... Rellenando la matriz 4x5 con 20 números enteros...");
        
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                numeros[i][j] = (int) (Math.random() * (MAX_RANGO_VALOR + 1));
            }
        }

        // 2. Calcular las sumas parciales de filas y columnas, y la suma total
        
        // Sumas de filas
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                sumaFilas[i] += numeros[i][j];
            }
        }
        
        // Sumas de columnas
        for (int j = 0; j < COLUMNAS; j++) {
            for (int i = 0; i < FILAS; i++) {
                sumaColumnas[j] += numeros[i][j];
            }
        }
        
        // Suma total (se calcula sumando las sumas parciales de las filas o las columnas)
        for (int suma : sumaFilas) {
            sumaTotal += suma;
        }
		/*for (int i = 0; i < FILAS; i++){
			sumaTotal += sumaFilas[i];
		} */

        // 3. Mostrar la matriz con las sumas parciales (formato hoja de cálculo)
        
        System.out.println("\n\n **Resultado de la Matriz y Sumas Parciales** \n");

        // Imprimir la matriz y las sumas de las filas
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                // Imprime el valor de la celda, ajustando el formato para que quede alineado
                System.out.printf("%5d", numeros[i][j]);
            }
            // Imprime la suma de la fila
            System.out.printf(" | **%5d** (Suma Fila %d)\n", sumaFilas[i], i);
        }

        // Separador para las sumas de las columnas
        for (int j = 0; j < COLUMNAS; j++) {
            System.out.print("------"); 
        }
        System.out.println(" | -----------");

        // Imprimir las sumas de las columnas y la suma total
        for (int j = 0; j < COLUMNAS; j++) {
            // Imprime la suma de la columna
            System.out.printf("**%5d**", sumaColumnas[j]);
        }
        
        // Imprime la suma total en la esquina inferior derecha
        System.out.printf(" | **%5d** (Suma Total)\n", sumaTotal);

        s.close();
    }
}