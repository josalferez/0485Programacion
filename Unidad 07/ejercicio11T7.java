import java.util.Scanner;

public class ejercicio11T7{

    public static void main(String[] args) {
        // 1. Configuración y Declaración
        final int TAMANO_ARRAY = 20;
        final int MAX_RANGO_VALOR = 50;
        
        int[] arrayInicial = new int[TAMANO_ARRAY];
        
        // Arrays para almacenar primos y no-primos por separado (valores)
        int[] arrayPrimos = new int[TAMANO_ARRAY];
        int[] arrayNoPrimos = new int[TAMANO_ARRAY]; 
        
        int contadorPrimos = 0;
        int contadorNoPrimos = 0;
        
        Scanner scanner = new Scanner(System.in);        
        
        // -----------------------------------------------------

        // 2. Rellenar el array y clasificar los números
        for (int i = 0; i < TAMANO_ARRAY; i++) {
            // Genera números aleatorios entre 0 y 50
            arrayInicial[i] = (int) (Math.random() * (MAX_RANGO_VALOR + 1)); 

            int numero = arrayInicial[i];
            boolean esPrimo = true;

            // Lógica de Primalidad 
            if (numero <= 1) {
                esPrimo = false;
            } else {
                // Comprobamos la divisibilidad hasta la raíz cuadrada
                for (int l = 2; l * l <= numero; l++) {
                    if (numero % l == 0) {
                        esPrimo = false;
                        break; // No es necesario seguir comprobando
                    }
                }
            }

            // Clasificación
            if (esPrimo) {
                arrayPrimos[contadorPrimos] = numero; // Guarda el valor primo
                contadorPrimos++;
            } else {
                arrayNoPrimos[contadorNoPrimos] = numero; // Guarda el valor no-primo
                contadorNoPrimos++;
            }
        }
        
        // -----------------------------------------------------

        // 3. Crear el Array Final Reordenado
        int[] arrayFinalReordenado = new int[TAMANO_ARRAY];
        int indiceFinal = 0;

        // A. Copiar los Primos al array final
        for (int i = 0; i < contadorPrimos; i++) {
            arrayFinalReordenado[indiceFinal] = arrayPrimos[i];
            indiceFinal++;
        }

        // B. Copiar los No-Primos al array final
        for (int i = 0; i < contadorNoPrimos; i++) {
            arrayFinalReordenado[indiceFinal] = arrayNoPrimos[i];
            indiceFinal++;
        }
        
        // -----------------------------------------------------

        // 4. Mostrar el Array Inicial
        System.out.println("--- Array Inicial (" + TAMANO_ARRAY + " elementos) ---");
        for (int i = 0; i < TAMANO_ARRAY; i++) {
            System.out.printf(" %d", arrayInicial[i]);
            if ((i + 1) % 10 == 0) {
                System.out.println();
            }
        }
        System.out.println();

        // 5. Mostrar el Array Final Reordenado
        System.out.printf("Se reordenó el array: **%d números primos** y **%d números no primos**.\n", contadorPrimos, contadorNoPrimos);
        System.out.println("--- Array Final Reordenado (Primos Primero) ---");
        for (int i = 0; i < TAMANO_ARRAY; i++) {
            System.out.printf(" %d", arrayFinalReordenado[i]);
            if ((i + 1) % 10 == 0) { 
                System.out.println();
            }
        }
        System.out.println();

        // Cierro el Scanner
        scanner.close();
    }
}