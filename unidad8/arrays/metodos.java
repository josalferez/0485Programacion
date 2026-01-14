/*metodos.java */
package arrays;

public class metodos {

    public static int rellenoArrays(int[] temperaturas) {
        int promedio = 0, i;

        // 1. Relleno el array
        System.out.print("El array de temperaturas es: ");
        for (i = 0; i < temperaturas.length; i++) {
            temperaturas[i] = (int) (Math.random() * 40) + 20;
            promedio += temperaturas[i];
            System.out.print(temperaturas[i] + " ");
        }
        System.out.println("");

        return promedio;
    }
}   
