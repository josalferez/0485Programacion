/*Realiza un programa que muestre por pantalla un array de 9 filas por 9
columnas relleno con números aleatorios entre 500 y 900. A continuación, el
programa debe mostrar los números de la diagonal que va desde la esquina
inferior izquierda a la esquina superior derecha, así como el máximo, el mínimo
y la media de los números que hay en esa diagonal.
*/

public class pizarra14T8 {
    public static void main(String[] args) {
        int[][] array = new int[10][10];

        // Relleno el array con números entre 500 y 900
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                array[i][j] = (int) (Math.random() * 400) + 500;
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }

        // Imprimo los números de la diagonal
        System.out.println("El contenido de la diagonal es: ");
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++){
                if (i + j == 9)
                    System.out.print(array[i][j] + " ");
            }
            System.out.print(" ");
        }
    }
}