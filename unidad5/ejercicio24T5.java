/*
*
* Escribe un programa que lea un número n e imprima una pirámide de números
* con n filas como en la siguiente figura:
*       1
*      121
*     12321
*    1234321
*/
import java.util.Scanner;

public class ejercicio24T5 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
		Integer n = null;

			// Bucle que se ejecuta mientras la variable 'n' sea nula (entrada no válida)
			while (n == null){
				System.out.print("Introduce el número de filas (n): ");
				if (sc.hasNextInt()){
					n = sc.nextInt();
				} else {
					System.out.println("ERROR: Has introducido un valor no válido. Inténtalo de nuevo.");
					sc.next(); // Limpiamos el bufer de lectura 
				}
			}
        
        System.out.println("\n--- Pirámide de " + n + " filas ---");

        // Bucle exterior: Controla las filas (i)
        for (int i = 1; i <= n; i++) {
            
            // 1. Bucle de ESPACIOS: Para centrar la pirámide
            // Imprime n - i pares de espacios.
            for (int j = 1; j <= n - i; j++) {
                System.out.print("  "); 
            }
            
            // 2. Bucle de NÚMEROS ASCENDENTES: Imprime de 1 hasta i
            for (int k = 1; k <= i; k++) {
                System.out.print(k + " ");
            }
            
            // 3. Bucle de NÚMEROS DESCENDENTES: Imprime de i-1 hasta 1
            // Se usa l = i - 1 porque el número 'i' (el pico) ya se imprimió en el paso anterior.
            for (int l = i - 1; l >= 1; l--) {
                System.out.print(l + " ");
            }
            
            // Salto de línea para la siguiente fila
            System.out.println();
        }
		
		// Libero el objeto escaner
        sc.close();
    }
}