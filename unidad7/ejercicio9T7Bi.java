import java.util.Scanner;

public class ejercicio9T7Bi {

    public static void main(String[] args) {
        // Constantes y variables
        final int N = 3; // La matriz es N x N
        final int MAX_VALOR = 10;
        final int TOTAL_ELEMENTOS = N * N; // 9

        int[][] matriz = new int[N][N];
        
        // Variables para la rotación
        int valorTemporal;
        int filaOrigen, colOrigen;
        int filaDestino, colDestino;

        // ----------------------------------------------------
        // 1. Rellenar la matriz y mostrar la matriz ORIGINAL
        // ----------------------------------------------------
        System.out.println("--- Matriz Original " + N + "x" + N + " ---");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                // Generar número al azar entre 0 y 100
                matriz[i][j] = (int) (Math.random() * (MAX_VALOR + 1));
                // Imprimir y alinear (el %4d asegura el espacio para números de 3 cifras)
                System.out.printf("%4d", matriz[i][j]);
            }
            System.out.println();
        }

        // ----------------------------------------------------
        // 2. Rotar la matriz una posición en sentido horario
        // ----------------------------------------------------
        
        // 2a. Guardar el valor del último elemento
        // Este valor irá a la posición [0][0] después de la rotación.
        valorTemporal = matriz[N - 1][N - 1]; 
        
        // 2b. Desplazar todos los elementos de la posición [k] a [k+1]
        // Se recorre la matriz linealmente desde el penúltimo elemento (142) hasta el primero (0).
        for (int k = TOTAL_ELEMENTOS - 2; k >= 0; k--) {
            
            // Mapeo de la posición lineal k a coordenadas 2D [fila][columna]
            // Nota: La división entera (/) da la fila. El resto (%) da la columna.
            
            // Coordenadas de la celda de la que se *obtiene* el valor (la celda de origen)
            colOrigen = k % N;
            filaOrigen = k / N;
            
            // Coordenadas de la celda a la que se *asigna* el valor (la celda de destino)
            colDestino = (k + 1) % N;
            filaDestino = (k + 1) / N;

            // Realizar el desplazamiento:
            matriz[filaDestino][colDestino] = matriz[filaOrigen][colOrigen];
        }

        // 2c. Asignar el valor temporal guardado a la primera posición
        matriz[0][0] = valorTemporal;

        // ----------------------------------------------------
        // 3. Mostrar la matriz ROTADA
        // ----------------------------------------------------
        System.out.println("\n--- Matriz Rotada (1 posición a la derecha) ---");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.printf("%4d", matriz[i][j]);
            }
            System.out.println();
        }
    }
}