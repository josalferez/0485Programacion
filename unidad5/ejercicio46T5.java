/*
Realiza un programa que pinte por pantalla un rectángulo hueco hecho con
asteriscos. Se debe pedir al usuario la anchura y la altura. Hay que comprobar
que tanto la anchura como la altura sean mayores o iguales que 2, en caso
contrario se debe mostrar un mensaje de error.
*/

import java.util.Scanner;

public class ejercicio46T5 {

    public static void main(String[] args) {
        // Objeto Scanner para leer la entrada del usuario
        Scanner scanner = new Scanner(System.in);

        int anchura;
        int altura;

        // --- 1. Pedir y validar la ANCHURA ---
        System.out.print("Por favor, introduce la anchura del rectángulo (debe ser >= 2):");
        if (scanner.hasNextInt()) {
            anchura = scanner.nextInt();
        } else {
            System.out.println("Error: La entrada para la anchura no es un número entero válido.");
            scanner.close();
            return; // Termina el programa si la entrada no es un número
        }

        // --- 2. Pedir y validar la ALTURA ---
        System.out.print("Por favor, introduce la altura del rectángulo (debe ser >= 2):");
        if (scanner.hasNextInt()) {
            altura = scanner.nextInt();
        } else {
            System.out.println("Error: La entrada para la altura no es un número entero válido.");
            scanner.close();
            return; // Termina el programa si la entrada no es un número
        }

        // --- 3. Validación de restricciones de tamaño (Anchura y Altura >= 2) ---
        if (anchura < 2 || altura < 2) {
            System.out.println("Error: Tanto la anchura como la altura deben ser mayores o iguales a 2.");
            scanner.close();
            return; // Termina el programa si no cumple la condición
        }

        System.out.println("\n Rectángulo generado con " + anchura + " de anchura y " + altura + " de altura:\n");

        // --- 4. Dibujar el rectángulo ---

        // Bucle exterior para recorrer la ALTURA (filas)
        for (int i = 1; i <= altura; i++) {
            
            // Bucle interior para recorrer la ANCHURA (columnas)
            for (int j = 1; j <= anchura; j++) {
                
                /* * La lógica para pintar un asterisco ('*') se cumple si estamos en:
                 * 1. La primera fila (i == 1)
                 * 2. La última fila (i == altura)
                 * 3. La primera columna (j == 1)
                 * 4. La última columna (j == anchura)
                 * En cualquier otro caso, pintamos un espacio (' ').
                 */
                if (i == 1 || i == altura || j == 1 || j == anchura) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            
            // Salto de línea al finalizar cada fila
            System.out.println();
        }

        // Cerrar el scanner
        scanner.close();
    }
}