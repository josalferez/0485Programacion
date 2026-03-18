/*
* Escriba un programa en Java que:
* Defina y rellene una matriz cuadrada N * N (usa N=4) con números aleatorios entre 1 y 10.
* Muestre la matriz original.
* Calcule y muestre los Puntos Silla (elemento mínimo de su fila y máximo de su columna).
*/

public class puntoSilla{
	public static void main(String[] args){
		// Tamaño de la matriz
		final int N = 4; 
		// Valor máximo para los números aleatorios
		final int MAX_VALOR = 10;
		
		int[][] matriz = new int[N][N];
		
		// ----------------------------------------------------
        // 1. Rellenar la matriz (1-10) y mostrar la matriz ORIGINAL
        // ----------------------------------------------------
        System.out.println("--- Matriz Original " + N + "x" + N + " ---");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                // Generar número al azar entre 1 y 10 (inclusive)
                matriz[i][j] = (int) (Math.random() * MAX_VALOR) + 1;
                // Imprimir y alinear
                System.out.printf("%4d", matriz[i][j]);
            }
            System.out.println();
        }

		// ----------------------------------------------------
        // 2. Buscar Puntos Silla
        // ----------------------------------------------------
		
		System.out.println("\n--- Búsqueda de Puntos Silla ---");
		boolean encontrado = false;

        // Iterar por cada fila para encontrar su mínimo
        for (int i = 0; i < N; i++) {
            
            // 2.1. Encontrar el mínimo de la fila i y su posición
            int minFila = matriz[i][0];
            int posColMin = 0;
            
            for (int j = 1; j < N; j++) {
                if (matriz[i][j] < minFila) {
                    minFila = matriz[i][j];
                    posColMin = j;
                }
            }
            
            // 2.2. Comprobar si ese mínimo de fila (minFila) es el máximo en su columna (posColMin)
            boolean esPuntoSilla = true;
            
            // Recorrer la columna donde se encontró el mínimo
            for (int k = 0; k < N; k++) { 
                // Si existe algún elemento en esa columna que es MAYOR que el mínimo de la fila, 
                // entonces NO es el máximo de la columna.
                if (matriz[k][posColMin] > minFila) { 
                    esPuntoSilla = false; 
                    break; 
                }
            }
            
            // 2.3. Si la bandera sigue en 'true', se encontró un Punto Silla
            if (esPuntoSilla) {
                System.out.println("Punto Silla encontrado en la fila " + i + ", columna " + posColMin + " con valor: " + minFila);
                encontrado = true;
            }
        }
        
        if (!encontrado) {
            System.out.println("No se encontró ningún Punto Silla en la matriz generada.");
        }
	}
}