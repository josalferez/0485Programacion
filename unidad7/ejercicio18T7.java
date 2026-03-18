import java.util.Scanner;

public class ejercicio18T7{

    public static void main(String[] args) {
        // 1. Configuración y Declaración
        final int TAMANO_ARRAY = 10;
        final int MAX_RANGO_VALOR = 200;
        
        // Se mantienen los arrays de tamaño fijo TAMANO_ARRAY.
        int[] arrayAlterno = new int[TAMANO_ARRAY];
        int[] arrayMenores100 = new int[TAMANO_ARRAY];
        int[] arrayMayores100 = new int[TAMANO_ARRAY];
                
        // Los índices se usan para CONTAR y LUEGO como TAMAÑO REAL de los arrays auxiliares.
        int indiceMenores = 0;
        int indiceMayores = 0;
        int numero = 0;
        
        // -----------------------------------------------------

        // 1. Generar Array Inicial y Clasificar
        System.out.println("--- Array Inicial (Generado) ---");
        System.out.print("Números: ");
        
        for (int i = 0; i < TAMANO_ARRAY; i++) {
            // Genera números aleatorios entre 0 y 200 (inclusive)
            numero = (int) (Math.random() * (MAX_RANGO_VALOR + 1)); 
            System.out.printf("%d ", numero);
            
            if (numero <= 100){
                // Inserta el número en la posición actual del índice y luego incrementa el índice
                arrayMenores100[indiceMenores] = numero;
                indiceMenores++;                
            } else {
                arrayMayores100[indiceMayores] = numero;
                indiceMayores++;
            }   
        }
        System.out.println();
        System.out.println();
        
        // Estos son los TAMAÑOS REALES de los elementos que debemos usar.
        int tamanioMenores = indiceMenores;
        int tamanioMayores = indiceMayores; 
        
        // Reinicio los índices para RECORRER los arrays auxiliares.
        indiceMenores = 0;
        indiceMayores = 0;
        
        // -----------------------------------------------------

        // 2. Llenar arrayAlterno de forma intercalada
        for (int i = 0; i < TAMANO_ARRAY; i++) {
            
            // Posición Par (0, 2, 4, ...): Prioridad a números <= 100
            if (i % 2 == 0) {
                if (indiceMenores < tamanioMenores) {
                    arrayAlterno[i] = arrayMenores100[indiceMenores];   
                    indiceMenores++;
                } else {
                    // Si se agotaron los menores, relleno con mayores
                    arrayAlterno[i] = arrayMayores100[indiceMayores];
                    indiceMayores++;    
                }
            } else {
                // Posición Impar (1, 3, 5, ...): Prioridad a números > 100
                if (indiceMayores < tamanioMayores) {
                    arrayAlterno[i] = arrayMayores100[indiceMayores];
                    indiceMayores++;
                } else {
                    // Si se agotaron los mayores, relleno con menores
                    arrayAlterno[i] = arrayMenores100[indiceMenores];   
                    indiceMenores++;                    
                }           
            }      
        } 

        // 3. Mostrar el Array Final
        System.out.println("--- Array Final Reordenado ---");
        for (int i = 0; i < TAMANO_ARRAY; i++) {
            System.out.printf(" %d", arrayAlterno[i]);
        }
        System.out.println();
    }
}