import java.util.Scanner;

public class ejercicio13T7  {

    public static void main(String[] args) {
        // 1. Configuración y Declaración
        final int TAMANO_ARRAY = 100;
        final int MAX_RANGO_VALOR = 500;
        int[] array = new int[TAMANO_ARRAY];
        Scanner scanner = new Scanner(System.in);
        
        // Inicialización de máximo y mínimo usando los límites de Integer
        int maximo = Integer.MIN_VALUE;
        int minimo = Integer.MAX_VALUE;
        
        // Variables para almacenar la elección final
        int valorADestacar;
        String nombreValor;
        
        // -----------------------------------------------------

        // 2. Rellenar el array y encontrar el máximo/mínimo
        for (int i = 0; i < TAMANO_ARRAY; i++) {
            // Genera números aleatorios entre 0 y 500
            array[i] = (int) (Math.random() * (MAX_RANGO_VALOR + 1)); 

            // Encontrar el máximo y el mínimo
            if (array[i] > maximo) {
                maximo = array[i];
            }
            if (array[i] < minimo) {
                minimo = array[i];
            }
        }
        
        // -----------------------------------------------------

        // 3. Mostrar el array inicial
        System.out.println("--- Array Inicial (100 elementos) ---");
        
        for (int i = 0; i < TAMANO_ARRAY; i++) {
            System.out.printf(" %d", array[i]);
            
            // Salto de línea cada 10 números para formato
            if ((i + 1) % 10 == 0) {
                System.out.println();
            }
        }
        
        // -----------------------------------------------------

        // 4. Preguntar al usuario qué valor destacar y asignar variables
        String opcion = "";
        
		System.out.println("\n¿Qué valor quieres destacar?");
		System.out.print("Introduce (M) para el Máximo o (m) para el Mínimo: ");
		if (scanner.hasNextLine()) {
			opcion = scanner.nextLine();
		}
        
        if (opcion.equals("m")) {
            valorADestacar = minimo;
            nombreValor = "Mínimo";
        } else {
            valorADestacar = maximo;
            nombreValor = "Máximo";
        }
        
        // -----------------------------------------------------

        // 5. Volver a mostrar el array destacando el valor elegido
        System.out.println("\n--- Array Final Destacando el " + nombreValor + " (" + valorADestacar + ") ---");
        
        for (int i = 0; i < TAMANO_ARRAY; i++) {
            // Comprueba si el elemento actual es el que debe destacarse
            if (array[i] == valorADestacar) {
                // Imprime entre dobles asteriscos
                System.out.printf(" **%d**", array[i]);
            } else {
                // Imprime normalmente
                System.out.printf(" %d", array[i]);
            }

            // Salto de línea cada 10 números para formato
            if ((i + 1) % 10 == 0) {
                System.out.println(); 
            }
        }
        scanner.close();
    }
}