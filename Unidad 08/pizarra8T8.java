import java.util.Scanner;

public class pizarra8T8 {
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        int opcion = 0, numero = 0;

        while (opcion !=4 ) { 
            System.out.println("\n--- MENÚ DE NÚMEROS ---");
            System.out.println("1. Comprobar si un número es Capicúa");
            System.out.println("2. Comprobar si un número es Primo");
            System.out.println("3. Comprobar el siguiente número Primo");
            System.out.println("4. Salir del programa");
            System.out.print("Seleccione una opción: ");

            // Leer la opción del usuario
            if (scanner.hasNextInt()) {
                opcion = scanner.nextInt();
            } else {
                System.out.println("\n*** ERROR: Entrada no válida. Por favor, introduzca un número del 1 al 3. ***");
                scanner.next(); // Consumir la entrada no válida
                continue; // Volver al inicio del bucle
            }

            // Usar el switch para manejar las opciones
            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el número a verificar (Capicúa): ");
                    if (scanner.hasNextInt()) {
                        numero = scanner.nextInt();
                        if (matematicas.metodos.esCapicua(numero)) {
                            System.out.println("\nEl número " + numero + " ES capicúa.");
                        } else {
                            System.out.println("\nEl número " + numero + " NO es capicúa.");
                        }
                    } else {
                        System.out.println("\n*** ERROR: Debe ingresar un número entero. ***");
                        scanner.next();
                    }
                    break;

                case 2:
                    System.out.print("Ingrese el número a verificar (Primo): ");
                    if (scanner.hasNextInt()) {
                        numero = scanner.nextInt();
                        if (matematicas.metodos.esPrimo(numero)) {
                            System.out.println("\nEl número " + numero + " ES primo.");
                        } else {
                            System.out.println("\nEl número " + numero + " NO es primo.");
                        }
                    } else {
                        System.out.println("\n*** ERROR: Debe ingresar un número entero. ***");
                        scanner.next();
                    }
                    break;

                case 3:
                    System.out.print("Ingrese el número a verificar (siguiente Primo): ");
                    if (scanner.hasNextInt()) {
                        numero = scanner.nextInt();
                        int siguPrimo = matematicas.metodos.siguientePrimo(numero);
                        System.out.println("\nEl número " + siguPrimo + " es el siguiente primo.");
                        
                    } else {
                        System.out.println("\n*** ERROR: Debe ingresar un número entero. ***");
                        scanner.next();
                    }
                    break;

                case 4:
                    System.out.println("\n¡Gracias por usar el programa! Saliendo...");
                    break;
                default:
                    System.out.println("\n*** Opción no válida. Por favor, seleccione 1, 2 o 3. ***");
                    break;
            }
        }
    }
}
