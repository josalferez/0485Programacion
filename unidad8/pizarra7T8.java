/*pizarra7T8.java */

public class pizarra7T8 {
    public static void main(String[] args) {
        int[] temperaturas = new int[25];
        int i, promedio = 0;

        promedio = arrays.metodos.rellenoArrays(temperaturas);

        // 2. Temperatura máxima del array
        int temperaturaMaxima = Integer.MIN_VALUE;
        for (i = 0; i < temperaturas.length; i++) {
            if (temperaturas[i] > temperaturaMaxima) {
                temperaturaMaxima = temperaturas[i];
            }
        }

        // 3. Temperatura mínima del array
        int temperaturaMinima = Integer.MAX_VALUE;
        for (i = 0; i < temperaturas.length; i++) {
            if (temperaturas[i] < temperaturaMinima) {
                temperaturaMinima = temperaturas[i];
            }
        }

        //4. Calculo el promedio
        promedio = promedio / 25;

        // Imprimo por pantalla los valores. 
        System.out.println("La temperatura máxima es: " + temperaturaMaxima);
        System.out.println("La temperatura minima es: " + temperaturaMinima);
        System.out.println("La temperatura promedio es: " + promedio);
    }
}
