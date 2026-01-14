import java.util.Scanner;

public class ejercicio12T5 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n; // Número de términos a mostrar

        // 1. Pedir la cantidad de términos
        System.out.println("--- Generador de la Serie de Fibonacci ---");
        System.out.print("¿Cuántos términos de la serie de Fibonacci quieres ver? (n > 0): ");

        // Aseguramos que la entrada sea un entero positivo
        if (sc.hasNextInt()) {
            n = sc.nextInt();
            if (n <= 0) {
                System.out.println("Error: Debes introducir un número entero positivo.");
                sc.close();
                return;
            }
        } else {
            System.out.println("Error: Entrada no válida. Por favor, introduce un número entero.");
            sc.close();
            return;
        }

        // 2. Inicializar los dos primeros términos
        // Usamos 'long' para evitar desbordamiento con valores grandes de n
        long a = 0; // Primer término de la serie
        long b = 1; // Segundo término de la serie
        long c;     // Almacenará el siguiente término (a + b)

        System.out.println("\nLos " + n + " primeros términos de Fibonacci son:");

        // 3. Generar la serie usando un bucle 'for'
        for (int i = 1; i <= n; i++) {
            
            if (i == 1) {
                // Primer término
                System.out.println(a);
            } else if (i == 2) {
                // Segundo término
                System.out.println(b);
            } else {
                // Términos restantes (a partir del tercero)
                
                // a) Calcular el siguiente término
                c = a + b;
                
                // b) Mostrarlo
                System.out.println(c);
                
                // c) Actualizar 'a' y 'b' para la siguiente iteración
                // 'a' toma el valor de 'b'
                a = b; 
                // 'b' toma el valor del nuevo término 'c'
                b = c;
            }
        }
        System.out.println(); // Salto de línea al final
       
		// Libero el recurso
	    sc.close();
    }
}