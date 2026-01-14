/*
* Escriba un programa en Java que:
* Defina y rellene una matriz cuadrada N * N (usa N=5. final int TAMANIO_ARRAY = 5) con números aleatorios entre 1 y 10.
* Muestre la matriz original.
* Calcule y muestre por separado la suma de los elementos que cumplen alguna de las siguientes condiciones:
* Suma de la Diagonales: Suma de los elementos que están en la diagonal principal y en la diagonal secundaria.
* Suma de la Periferia (Borde): Suma de los elementos que se encuentran en el borde de la matriz (la primera fila, la última fila, la primera columna o la última columna).
*/

public class sumaBordes{
	public static void main(String[] args){
		final int N = 4;
		final int MAX_VALOR = 10;
		
		int[][] matriz = new int[N][N];
		int diagonalPrincipal = 0, diagonalSecundaria = 0;
		int bordeNorte = 0, bordeSur = 0, bordeEste = 0, bordeOeste = 0;
		
		// ----------------------------------------------------
        // 1. Rellenar la matriz y mostrar la matriz ORIGINAL
        // ----------------------------------------------------
        System.out.println("--- Matriz Original " + N + "x" + N + " ---");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                // Generar número al azar entre 0 y 10
                matriz[i][j] = (int) (Math.random() * (MAX_VALOR + 1));
                // Imprimir y alinear (el %4d asegura el espacio para números de 3 cifras)
                System.out.printf("%4d", matriz[i][j]);
            }
            System.out.println();
        }

		// ----------------------------------------------------
        // 2. Recorro la matriz y sumo diagonales
        // ----------------------------------------------------
        System.out.println("--- Matriz Original " + N + "x" + N + " ---");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
				// sumo la diagonal principal
				if (i == j ){
					diagonalPrincipal += matriz[i][j];
				}
				// Sumo la diagonal secundaria
				if (i+j == N - 1){
					diagonalSecundaria += matriz[i][j];
				}
				// Sumo borde norte
				if (i==0){
					bordeNorte += matriz[i][j];
				}
				// Sumo borde sur
				if (i==N-1){
					bordeSur += matriz[i][j];
				}
				// Sumo borde oeste
				if (j == N-1){
					bordeEste += matriz[i][j];
				}
				// Sumo borde este
				if (j == 0){
					bordeOeste += matriz[i][j];
				}
            }
            System.out.println();
        }
		System.out.println("Suma de la diagonal Principal: " + diagonalPrincipal);
		System.out.println("Suma de la diagonal Secundaria: " + diagonalSecundaria);
		System.out.println("Suma del Borde Norte: " + bordeNorte);
		System.out.println("Suma del Borde Sur: " + bordeSur);
		System.out.println("Suma del Borde Oeste: " + bordeOeste);
		System.out.println("Suma del Borde Este: " + bordeEste);
		
	}
}