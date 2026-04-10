import java.util.Scanner;

public class ejercicio47T5 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int altura;

        // --- 1. Pedir la altura y validarla ---
        System.out.println("🎉 ¡Feliz Día de la Mujer! 🎉");
        System.out.println("Introduce la altura para dibujar el número 8 (debe ser un número entero impar >= 5):");

        if (scanner.hasNextInt()) {
            altura = scanner.nextInt();
        } else {
            System.out.println("Error: La entrada no es un número entero válido.");
            scanner.close();
            return;
        }

        // Validación de restricciones: Impar Y Mayor o igual a 5
        if (altura < 5 || altura % 2 == 0) {
            System.out.println("Error: La altura debe ser un número impar y mayor o igual que 5.");
            scanner.close();
            return;
        }

        // Cerrar el scanner ya que hemos terminado de leer la entrada
        scanner.close();
        
        System.out.println("\n*** Patrón generado ***\n");

        // --- 2. Variables clave para el dibujo ---
        final int ANCHURA = 6;
        final int FILA_SUPERIOR = 1;
        final int FILA_INFERIOR = altura;
        final int FILA_CENTRAL = (altura / 2) + 1; // La fila media, clave en el patrón
        
        // --- 3. Bucle principal para dibujar el patrón ---
        
        for (int i = 1; i <= altura; i++) { // i: Fila actual
            
            // Determinar si la fila actual es un borde horizontal completo
            boolean esBordeHorizontal = (i == FILA_SUPERIOR || i == FILA_CENTRAL || i == FILA_INFERIOR);
            
            // Bucle interior para dibujar las columnas de la fila actual
            for (int j = 1; j <= ANCHURA; j++) { // j: Columna actual
                
                // Determinar si la columna actual es un borde vertical
                boolean esBordeVertical = (j == 1 || j == ANCHURA);
                
                /*
                 * Lógica para pintar la letra 'M':
                 * Se pinta 'M' si:
                 * 1. Es un borde horizontal (fila superior, central o inferior).
                 * O
                 * 2. Es un borde vertical (columna 1 o columna 6).
                 */
                if (esBordeHorizontal || esBordeVertical) {
                    System.out.print("M");
                } else {
                    // Si no cumple ninguna de las condiciones anteriores, es un espacio hueco
                    System.out.print(" ");
                }
            }
            
            // Salto de línea para pasar a la siguiente fila
            System.out.println();
        }
        
        System.out.println("\n*** Fin del programa ***");
    }
}