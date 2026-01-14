import java.util.Scanner;

public class AnalisisDeNotas {

    public static void main(String[] args) {
        // 1. Configuración y Declaración
        final int NUM_NOTAS = 25;
        // El rango es [1, 10]. Math.random() * (10 - 1 + 1) + 1
        final int RANGO = 10; 
        
        int[] notas = new int[NUM_NOTAS];
        int[] estadoAprobacion = new int[NUM_NOTAS]; // Array auxiliar
        
        int sobresalientes = 0;
        int suspensas = 0;

        // -----------------------------------------------------

        // 2. Generar notas, contar y crear el array auxiliar
        System.out.println("--- Notas Generadas (" + NUM_NOTAS + " elementos) ---");
        
        for (int i = 0; i < NUM_NOTAS; i++) {
            // Genera enteros aleatorios entre 1 y 10 (ambos incluidos)
            notas[i] = (int) (Math.random() * RANGO) + 1; 
            
            // Muestra la nota
            System.out.printf("%3d", notas[i]);

            // Formato de impresión: 5 notas por línea
            if ((i + 1) % 5 == 0) {
                System.out.println();
            }

            // A. Contar Sobresalientes (>= 9)
            if (notas[i] >= 9) {
                sobresalientes++;
            }

            // B. Contar Suspensas (< 5)
            if (notas[i] < 5) {
                suspensas++;
                estadoAprobacion[i] = 0; // Suspensa = 0
            } else {
                estadoAprobacion[i] = 1; // Aprobada (>= 5) = 1
            }
        }
        
        // -----------------------------------------------------
        
        // 3. Imprimir el resumen del análisis
        System.out.println("\n--- Resumen del Análisis ---");
        System.out.println("Notas Sobresalientes (>= 9): " + sobresalientes);
        System.out.println("Notas Suspensas (< 5):      " + suspensas);
        
        // -----------------------------------------------------

        // 4. Imprimir el array auxiliar (Estado de Aprobación)
        System.out.println("\n--- Array Auxiliar (0=Suspensa, 1=Aprobada) ---");
        
        for (int i = 0; i < NUM_NOTAS; i++) {
            System.out.printf("%3d", estadoAprobacion[i]);

            // Formato de impresión: 5 elementos por línea
            if ((i + 1) % 5 == 0) {
                System.out.println();
            }
        }
    }
}




