/*

Realiza un programa que pida un número por teclado y que luego muestre ese
número al revés.

*/

import java.util.Scanner;

public class ejercicio25T5 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Variables: usamos 'long' para manejar números grandes
        long numeroOriginal = 0;
        long numeroTemporal;
        long numeroInvertido = 0;
        
        // Bucle de validación de entrada
        while (true) {
            System.out.print("Introduce un número entero: ");
            if (sc.hasNextLong()) {
                numeroOriginal = sc.nextLong();
                break; // Salimos del bucle si la entrada es un número válido
            } else {
                System.out.println("ERROR: Entrada no válida. Por favor, introduce un número entero.");
                sc.next(); // Limpiamos el búfer
            }
        }
        
        // Asignamos el valor a la variable temporal para no modificar el original
        numeroTemporal = numeroOriginal; 

        // Bucle para invertir el número
        // Se repite mientras queden dígitos en el número temporal
        while (numeroTemporal > 0) {
            
            // 1. Obtener el último dígito (operador módulo %)
            long digito = numeroTemporal % 10;
            
            // 2. Construir el número invertido: 
            // Multiplicamos por 10 para desplazar los dígitos existentes y sumamos el nuevo dígito
            numeroInvertido = (numeroInvertido * 10) + digito;
            
            // 3. Eliminar el último dígito del número temporal (división entera /)
            numeroTemporal = numeroTemporal / 10;
        }

        System.out.println("\n-------------------------------------");
        System.out.println("El número original es:  " + numeroOriginal);
        System.out.println("El número al revés es:  " + numeroInvertido);
        System.out.println("-------------------------------------");

        sc.close();
    }
}