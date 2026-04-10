/*
*
* Realiza un programa que vaya pidiendo números hasta que se introduzca un
* numero negativo y nos diga cuantos números se han introducido, la media de
* los impares y el mayor de los pares. El número negativo sólo se utiliza para
* indicar el final de la introducción de datos pero no se incluye en el cómputo.
*
*/
import java.util.Scanner;

public class ejercicio21T5 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Inicialización de variables
        int contadorNumeros = 0;
        int sumaImpares = 0;
        int contadorImpares = 0;
        Integer mayorPar = null; // Usamos Integer para permitir null (como bandera)

        System.out.println("Introduce números (introduce un número negativo para terminar):");

        // Bucle principal de entrada de datos
        while (true) {
            System.out.print("Introduce un número: ");
            
            // Intenta leer el número
            if (sc.hasNextInt()) { // Compruebo que el usuario ha introducido un numero
                int numero = sc.nextInt(); // Lo leo

                // 1. Condición de parada: Número negativo
                if (numero < 0) {
                    System.out.println("Se introdujo un número negativo. Terminando la entrada de datos.");
                    break; // Sale del bucle while sin procesar el número negativo
                }

                // Si es un número válido (no negativo), lo procesamos
                contadorNumeros++;

                // 2. Comprobación de paridad
                if (numero % 2 == 0) { // Es un número par
                    // Actualiza el mayor de los pares
                    if (mayorPar == null || numero > mayorPar) {
                        mayorPar = numero;
                    }
                } else { // Es un número impar
                    // Acumula para la media de impares
                    sumaImpares += numero;
                    contadorImpares++;
                }
                
            } else {
                // Manejo de entrada no válida (no es un entero)
                System.out.println("¡Entrada no válida! Por favor, introduce un número entero.");
                sc.next(); // Consume la entrada no válida para evitar un bucle infinito
            }
        }

        // ----------------------------------------
        // Resultados
        // ----------------------------------------

        System.out.println("\n--- Resultados del Análisis ---");

        // 1. Total de números introducidos
        System.out.println("Total de números introducidos (sin contar el negativo de parada): " + contadorNumeros);

        // 2. Media de los impares
        if (contadorImpares > 0) {
            double mediaImpares = (double) sumaImpares / contadorImpares;
            System.out.printf("Media de los números impares: %.2f%n", mediaImpares);
        } else {
            System.out.println("No se introdujo ningún número impar, no se puede calcular la media.");
        }

        // 3. Mayor de los pares
        if (mayorPar != null) {
            System.out.println("Mayor de los números pares: " + mayorPar);
        } else {
            System.out.println("No se introdujo ningún número par.");
        }

        // Cierro el objeto Scanner
		sc.close(); 
    }
}