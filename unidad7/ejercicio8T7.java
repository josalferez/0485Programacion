import java.util.Scanner;

public class ejercicio8T7{

    public static void main(String[] args) {
        // 1. Configuración y Declaración
        final int TAMANO_ARRAY = 12;
        final int MAX_RANGO_VALOR = 25;
        
        // Se mantienen los arrays de tamaño fijo TAMANO_ARRAY.
        int[] arrayTemperaturas = new int[TAMANO_ARRAY];
		String[] meses = {"Ene", "Feb", "Mar", "Abr", "May", "Jun", 
                  "Jul", "Ago", "Sep", "Oct", "Nov", "Dic"};
        
        
        // -----------------------------------------------------

        // 1. Generar Array Inicial y Clasificar
        System.out.println("--- Array Temperaturas ---");
             
        for (int i = 0; i < TAMANO_ARRAY; i++) {
            // Genera números aleatorios entre 0 y 200 (inclusive)
            arrayTemperaturas[i] = (int) (Math.random() * (MAX_RANGO_VALOR + 1) + 20 ); 
            System.out.printf("%d ", arrayTemperaturas[i]);
        }
		
        // -----------------------------------------------------

        // 2. Imprimo las barras
        System.out.println();     
        for (int i = 0; i < TAMANO_ARRAY; i++) {
			System.out.printf("%s: ", meses[i]);
			for (int j = 0; j< arrayTemperaturas[i];j++){
				System.out.print("*");
			}
			System.out.println();
        }
        System.out.println();
    }
}