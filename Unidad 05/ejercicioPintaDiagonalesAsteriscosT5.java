import java.util.Scanner;

public class ejercicioPintaDiagonalesAsteriscosT5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int altura;

        // Pedir y validar la altura
        do {
            System.out.print("Introduce la altura del cuadrado (entero positivo): ");
            if (scanner.hasNextInt()) {
                altura = scanner.nextInt();
                if (altura > 0) {
                    break;
                } else {
                    System.out.println("La altura debe ser un número entero positivo.");
                }
            } else {
                System.out.println("Entrada no válida. Por favor, introduce un número.");
                scanner.next(); // Limpiar el buffer
            }
        } while (true);

        scanner.close();

         // Bucle para dibujar el cuadrado
        for (int i = 0; i < altura; i++) { // i = fila
            for (int j = 0; j < altura; j++) { // j = columna

                /*
                 * CONDICIÓN LÓGICA CORRECTA:
                 * 1. Diagonal Principal: i == j
                 * 2. Diagonal Secundaria: i + j == altura - 1
                 */
                if (i == j || i + j == altura - 1) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println(); // Salto de línea al terminar la fila
        }
    }
}