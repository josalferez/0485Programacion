
public class AnalisisDeNotas {
    public static void main(String[] args) {
        // 1. Configuración y Declaración
        final int NUM_NOTAS = 25;
        final int RANGO = 10;

        int[] notas = new int[NUM_NOTAS];
        int[] estadoAprobacion = new int[NUM_NOTAS]; // Array auxiliar

        int sobresalientes = 0;
        int suspensas = 0;

        // -----------------------------------------------------

        // 1. Creo el array principal
        notas2.metodos.setArray(notas, NUM_NOTAS, RANGO);
        notas2.metodos.getArray(NUM_NOTAS, notas);
                
        // -----------------------------------------------------

        // 2. Generar notas, contar y crear el array auxiliar
        System.out.println("--- Notas Generadas (" + NUM_NOTAS + " elementos) ---");
        sobresalientes = notas2.metodos.getSobresalientes(NUM_NOTAS, notas);
        suspensas = notas2.metodos.getSuspensos(NUM_NOTAS, notas);

        // -----------------------------------------------------

        // 3. Imprimir el resumen del análisis
        notas2.metodos.getResumenAnalisis(sobresalientes, suspensas);

        // -----------------------------------------------------

        // 4. Imprimir el array auxiliar (Estado de Aprobación)
        System.out.println("\n--- Array Auxiliar (0=Suspensa, 1=Aprobada) ---");
        notas2.metodos.setArrayAuxiliar(notas, NUM_NOTAS, estadoAprobacion);
        notas2.metodos.getArray(NUM_NOTAS, estadoAprobacion);

    }
}
