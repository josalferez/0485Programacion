package temperaturas;

public class metodos {
    // Método 1: encontrar la temperatura más frecuente (moda)
    public static int encontrarTemperaturaFrecuente(int[] temperaturas) {
        int moda = temperaturas[0];
        int maxFrecuencia = 0;

        for (int i = 0; i < temperaturas.length; i++) {
            int contador = 0;

            for (int j = 0; j < temperaturas.length; j++) {
                if (temperaturas[j] == temperaturas[i]) {
                    contador++;
                }
            }

            if (contador > maxFrecuencia) {
                maxFrecuencia = contador;
                moda = temperaturas[i];
            }
        }
        return moda;
    }

    // Método 2: convertir a Fahrenheit y contar cuántas quedan bajo 32°F
    public static int convertirYContarBajoCero(int[] temperaturas) {
        int contador = 0;

        for (int celsius : temperaturas) {
            double fahrenheit = celsius * 9.0 / 5.0 + 32;

            if (fahrenheit < 32) {
                contador++;
            }
        }
        return contador;
    }

    // Método 3: verificar si el rango es menor o igual al rango máximo permitido
    public static boolean verificarHomogeneidad(int[] temperaturas, int rangoMaximo) {
        int max = temperaturas[0];
        int min = temperaturas[0];

        for (int temp : temperaturas) {
            if (temp > max)
                max = temp;
            if (temp < min)
                min = temp;
        }

        int rango = max - min;
        return rango <= rangoMaximo;
    }
}
