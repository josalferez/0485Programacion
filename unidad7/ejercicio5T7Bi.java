public class ejercicio5T7Bi {

    public static void main(String[] args) {
        // 1. Constantes para definir el tamaño y el rango
        final int FILAS = 6;
        final int COLUMNAS = 10;
        final int MAX_VALOR = 1000;
        final int MIN_VALOR = 0;

        // Array bidimensional para almacenar los números
        int[][] numeros = new int[FILAS][COLUMNAS];

        // Variables para almacenar el valor y la posición del máximo y el mínimo
        int maximo = MIN_VALOR - 1; // Inicializar con un valor menor al mínimo posible
        int minino = MAX_VALOR + 1; // Inicializar con un valor mayor al máximo posible
        
        // Posiciones (indices de fila y columna)
        int filaMax = 0;
        int colMax = 0;
        int filaMin = 0;
        int colMin = 0;

        // 2. Rellenar el array con números aleatorios y buscar el máximo y el mínimo simultáneamente
        System.out.println("... Rellenando la matriz " + FILAS + "x" + COLUMNAS + " con números aleatorios [" + MIN_VALOR + "-" + MAX_VALOR + "] ...");

        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                // Generar número entero positivo entre 0 y 1000 (ambos incluidos)
                numeros[i][j] = (int) (Math.random() * (MAX_VALOR + 1));
                
                // Buscar Máximo
                if (numeros[i][j] > maximo) {
                    maximo = numeros[i][j];
                    filaMax = i;
                    colMax = j;
                }
                
                // Buscar Mínimo
                if (numeros[i][j] < minino) {
                    minino = numeros[i][j];
                    filaMin = i;
                    colMin = j;
                }
            }
        }

        // 3. Mostrar la matriz
        System.out.println("\n** MATRIZ GENERADA (" + FILAS + "x" + COLUMNAS + ") **\n");
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                System.out.printf("%5d", numeros[i][j]);
            }
            System.out.println();
        }

        // 4. Mostrar el resultado
        System.out.println("\n" + "-".repeat(40));
        System.out.println("RESULTADOS:");
        System.out.println("-".repeat(40));
        
        // Nota: Se suma 1 a los índices (fila y columna) para mostrar la posición
        // de forma intuitiva al usuario (empezando en 1 en lugar de 0).
        
        System.out.println("El número máximo encontrado es: " + maximo);
        System.out.println("   -> Posición: Fila " + (filaMax + 1) + ", Columna " + (colMax + 1));
        
        System.out.println("El número mínimo encontrado es: " + minino);
        System.out.println("   -> Posición: Fila " + (filaMin + 1) + ", Columna " + (colMin + 1));
        System.out.println("-".repeat(40));
    }
}