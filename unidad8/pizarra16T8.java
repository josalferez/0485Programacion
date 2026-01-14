/**
 * Ejercicio Propuesto: Implementación de la Lógica del Buscaminas
 *
 * Objetivo:
 * Simular el proceso de inicialización de un tablero de Buscaminas,
 * generando minas y calculando el número de minas vecinas.
 *
 * 1. Inicialización del Tablero:
 * - Define un tamaño N=10 y una cantidad de 15 minas.
 * - Crea un array bidimensional int[10][10] (Tablero Lógico).
 *
 * 2. Colocación Aleatoria de las Minas:
 * - Coloca 15 minas aleatoriamente en celdas distintas.
 * - Convención: -1 = Mina, 0 = Sin Mina.
 *
 * 3. Cálculo de Pistas (Números Vecinos):
 * - Recorre todo el tablero.
 * - Para cada celda que NO es una mina (valor 0):
 * - Cuenta cuántas minas (-1) hay en sus 8 celdas vecinas (incluyendo
 * diagonales).
 * - Asigna este conteo (1-8) a la celda.
 * - Manejo de Bordes: Implementa la lógica para no salirse de los límites del
 * array.
 *
 * 4. Impresión del Resultado:
 * - Imprime el Tablero Lógico Final, mostrando los valores -1, 0, y del 1 al 8.
 */

public class pizarra16T8 {

    public static void main(String[] args) {

        // Defino el tablero
        int[][] tablero = new int[10][10];
        int cantidadMinas = 15;
        int fila, columna;

        // Inicio el array a 0
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                tablero[i][j] = 0;
            }
        }

        // coloco las 15 minas
        while (cantidadMinas > 0) {
            fila = (int)(Math.random()*10);
            columna = (int)(Math.random()*10);

            tablero[fila][columna] = -1;
            cantidadMinas--; // Decreemento el numero de minas a colocar
        }

        // Imprimo el tablero
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.printf("%3d ",tablero[i][j]);
            }
            System.out.println("");
        }

        // Imprimo el tablero poniendo el número de minas que hay alrededor
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                contarMinas(i, j, tablero);
            }
            System.out.println("");
        }

    }

    public static int contarMinas(int pos_i_Mina, int pos_j_Mina, int[][] tablero){
        int numeroMinas = 0;
        // Si no es esquina ni borde
        for (int i=pos_i_Mina-1;i<pos_i_Mina+2 ; i++){
            for (int j=pos_j_Mina-1;i<pos_j_Mina+2 ; j++)
                if (tablero[i][j] == -1){
                    numeroMinas++;
                }
        }

        return numeroMinas;
    }
}
