package notas2;

public class metodos{
    public static void setArray(int[] notas, int NUM_NOTAS, int RANGO) {
        for (int i = 0; i < NUM_NOTAS; i++) {
            // Genera enteros aleatorios entre 1 y 10 (ambos incluidos)
            notas[i] = (int) (Math.random() * RANGO) + 1;
        }
    }

    public static void setArrayAuxiliar(int[] notas, int NUM_NOTAS, int[] estadoAprobacion) {
        for (int i = 0; i < NUM_NOTAS; i++) {
            if (notas[i] < 5){
                estadoAprobacion[i] = 0;
            } else{
                estadoAprobacion[i] = 1;
            }       
        }
    }

    // 2. Método que devuelve el número de sobresalientes
    public static int getSobresalientes(int NUM_NOTAS, int[] notas) {
        int sobresalientes = 0;

        for (int i = 0; i < NUM_NOTAS; i++) {
            // A. Contar Sobresalientes (>= 9)
            if (notas[i] >= 9) {
                sobresalientes++;
            }
        }

        return sobresalientes;
    }

    // 2. Método que devuelve el número de sobresalientes
    public static int getSuspensos(int NUM_NOTAS, int[] notas) {
        int suspensos = 0;

        for (int i = 0; i < NUM_NOTAS; i++) {
            // A. Contar Suspensos (< 5)
            if (notas[i] < 5) {
                suspensos++;
            }
        }

        return suspensos;
    }

    public static void getResumenAnalisis(int sobresalientes, int suspensos) {
        System.out.println("\n--- Resumen del Análisis ---");
        System.out.println("Notas Sobresalientes (>= 9): " + sobresalientes);
        System.out.println("Notas Suspensas (< 5):      " + suspensos);
    }

    public static void getArray(int NUM_NOTAS, int[] estadoAprobacion) {
        for (int i = 0; i < NUM_NOTAS; i++) {
            System.out.printf("%3d", estadoAprobacion[i]);

            // Formato de impresión: 5 elementos por línea
            if ((i + 1) % 5 == 0) {
                System.out.println();
            }
        }
    }
}
