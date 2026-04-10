import java.util.Scanner;

public class ejercicio19T7 {

    public static void main(String[] args) {
        // 1. Configuración de constantes y herramientas
        final int TAMANO_ARRAY = 12;
        int[] array = new int[TAMANO_ARRAY];
        Scanner scanner = new Scanner(System.in);

        // ---

        // 2. Generación del array inicial usando Math.random()
        for (int i = 0; i < TAMANO_ARRAY; i++) {
            array[i] = (int) (Math.random() * 21); 
        }

        // ---

        // 3. Mostrar el contenido del array inicial 
        System.out.println("--- Array Inicial ---");
        System.out.println("Índices:  0  1  2  3  4  5  6  7  8  9 10 11");
        System.out.print("Valores: ");
        for (int i = 0; i < TAMANO_ARRAY; i++) {
            System.out.printf("%3d", array[i]); // Formato para alinear los números
        }
        System.out.println();
        System.out.println("---------------------");

        // ---

        // 4. Pedir datos al usuario
        int numeroAInsertar;
        int posicionAInsertar;

        // Pedir el número a insertar CON VALIDACIÓN
        System.out.print("Introduce el número entero que quieres insertar: ");
        if (scanner.hasNextInt()) {
            numeroAInsertar = scanner.nextInt();
        } else {
            System.out.println("Entrada inválida. Saliendo del programa.");
            scanner.close();
            return; // Se sale del programa
        }

        // Pedir la posición y validar que esté dentro del rango [0, 11]
        do {
            System.out.print("Introduce la posición (0-11) donde quieres insertarlo: ");
            if (scanner.hasNextInt()) {
                posicionAInsertar = scanner.nextInt();
            } else { // Caso en el que no meto un entero
                System.out.println("Entrada inválida. Saliendo del programa.");
                scanner.close();
                return;
            }

            if (posicionAInsertar < 0 || posicionAInsertar >= TAMANO_ARRAY) {
                System.out.println("La posición debe estar entre 0 y 11. Inténtalo de nuevo.");
            }
        } while (posicionAInsertar < 0 || posicionAInsertar >= TAMANO_ARRAY);

        scanner.close();
        System.out.println();

        // ---

        // 5. Realizar la inserción y desplazamiento
        
        // Desplazar los elementos una posición a la derecha
        // Desde el índice 10 hasta la posición de inserción.
        for (int i = TAMANO_ARRAY - 2; i >= posicionAInsertar; i--) {
            array[i + 1] = array[i];
        }

        // Insertar el nuevo número en la posición elegida
        array[posicionAInsertar] = numeroAInsertar;

        // ---

        // 6. Mostrar el contenido del array final (usando for tradicional)
        System.out.println("--- Array Final (Número insertado en posición " + posicionAInsertar + ") ---");
        System.out.println("Índices:  0  1  2  3  4  5  6  7  8  9 10 11");
        System.out.print("Valores: ");
        for (int i = 0; i < TAMANO_ARRAY; i++) {
            System.out.printf("%3d", array[i]);
        }
        System.out.println();
        System.out.println("---------------------");
    }
}