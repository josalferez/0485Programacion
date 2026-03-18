/*Realiza un programa que muestre por pantalla un array de 10 filas por 10
columnas relleno con números aleatorios entre 200 y 300. A continuación, el
programa debe mostrar los números de la diagonal que va desde la esquina
superior izquierda a la esquina inferior derecha, así como el máximo, el mínimo
y la media de los números que hay en esa diagonal.*/

public class pizarra13T8{
    public static void main(String[] args){
        int[][] array = new int[10][10];
        int promedio = 0;
        int maximo = Integer.MIN_VALUE;
        int minimo = Integer.MAX_VALUE;

        for (int i = 0; i < 10; i++){
            for (int j = 0; j < 10; j++){
                array[i][j] = (int)(Math.random()*100) + 200;
                if (array[i][j] > maximo)
                    maximo = array[i][j];
                if (array[i][j] < minimo)
                    minimo = array[i][j];
            }
        }

        for (int k = 0; k < 10; k++) {
            promedio += array[k][k]; 
        }

        System.out.println("Promedio: " + promedio/10);
        System.out.println("Maximo: " + maximo);
        System.out.println("Minimo: " + minimo);
    }
}