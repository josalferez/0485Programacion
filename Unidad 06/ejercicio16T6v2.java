import java.util.Scanner;

/**
 * Opciones disponibles:
 * 1. Meter Dinero (Recargar saldo)
 * 2. Tirar (Jugar una ronda)
 * 3. Salir (Finalizar el programa)
 */
public class ejercicio16T6v2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        // Variables para la lógica
        int figura1, figura2, figura3;
        int opcion;
        double saldo = 0.0; // Saldo inicial
        double costeTirada = 1.0; // Coste fijo de la tirada
        
        System.out.println("--- MÁQUINA TRAGAPERRAS (Ejercicio 16 T6 v2) ---");

        while (true) {
            
            // Limpio la pantalla y muestro el saldo arriba a la derecha
            System.out.print("\033c"); 
            System.out.println("------------------------------------------ SALDO: " + String.format("%.2f", saldo) + " € ---");
            System.out.println("----------------------------------------------------------------------");
            
            // Menú de Opciones
            System.out.println("\nMENU:");
            System.out.println("1. Recargar saldo ");
            System.out.println("2. Tirar (Cuesta " + String.format("%.2f", costeTirada) + " €)");
            System.out.println("3. Salir");
            System.out.print("Selecciona una opción: ");
            
            // Validar que la entrada sea un número entero
            if (sc.hasNextInt()) {
                opcion = sc.nextInt();
                sc.nextLine(); // Consumir el salto de línea
            } else {
                System.out.println("\nERROR: Opción no válida. Introduce un número (1, 2 o 3).");
                sc.nextLine(); // Limpiar el buffer
                continue; // Vuelve a mostrar el menú
            }

            // Lógica del Menú
            switch (opcion) {
                
                case 1: // METER DINERO
                    System.out.print("\n¿Cuánto dinero quieres meter?: ");
                    if (sc.hasNextDouble()) {
                        double ingreso = sc.nextDouble();
                        sc.nextLine(); 
                        if (ingreso > 0) {
                            saldo += ingreso;
                            System.out.println("¡Ingreso exitoso! Saldo actual: " + String.format("%.2f", saldo) + " €");
                        } else {
                            System.out.println("Debes ingresar una cantidad positiva.");
                        }
                    } else {
                        System.out.println("ERROR: Cantidad no válida.");
                        sc.nextLine(); 
                    }
                    System.out.print("\nPulsa ENTER para continuar...");
                    sc.nextLine();
                    break;

                case 2: // TIRAR
                    if (saldo >= costeTirada) {
                        
                        saldo -= costeTirada; // Descontar el coste
                        
                        // 1. GENERAR LA TIRADA USANDO Math.random() (Valores 1 a 5)
                        figura1 = (int) (Math.random() * 5) + 1;
                        figura2 = (int) (Math.random() * 5) + 1;
                        figura3 = (int) (Math.random() * 5) + 1;
                        
                        // 2. MOSTRAR LA TIRADA
                        System.out.print("\n--- ¡TIRANDO! ---\nResultado: ");
                        
                        // Figura 1
                        switch (figura1) {
                            case 1: System.out.print("corazón "); break;
                            case 2: System.out.print("diamante "); break;
                            case 3: System.out.print("herradura "); break;
                            case 4: System.out.print("campana "); break;
                            case 5: System.out.print("limón "); break;
                        }
                        // Figura 2
                        switch (figura2) {
                            case 1: System.out.print("corazón "); break;
                            case 2: System.out.print("diamante "); break;
                            case 3: System.out.print("herradura "); break;
                            case 4: System.out.print("campana "); break;
                            case 5: System.out.print("limón "); break;
                        }
                        // Figura 3
                        switch (figura3) {
                            case 1: System.out.print("corazón"); break;
                            case 2: System.out.print("diamante"); break;
                            case 3: System.out.print("herradura"); break;
                            case 4: System.out.print("campana"); break;
                            case 5: System.out.print("limón"); break;
                        }
                        System.out.println("\n");
                        
                        // 3. COMPROBAR PREMIO Y ACTUALIZAR SALDO
                        
                        // Requisito d) Tres figuras iguales (+10 monedas)
                        if (figura1 == figura2 && figura2 == figura3) {
                            System.out.println("** ¡PREMIO MAYOR! Enhorabuena, ha ganado 10 monedas (10.00 €) **");
                            saldo += 10.0;
                            
                        // Requisito c) Dos figuras iguales y una diferente (+1 moneda)
                        } else if (figura1 == figura2 || figura1 == figura3 || figura2 == figura3) {
                            System.out.println("Bien, ha recuperado su moneda (1.00 €)");
                            saldo += 1.0;
                            
                        // Requisito b) Tres figuras diferentes (Pérdida neta de 1 moneda)
                        } else {
                            System.out.println("Lo siento, ha perdido. No hay premio.");
                        }

                        System.out.println("Saldo restante: " + String.format("%.2f", saldo) + " €");
                        
                    } else {
                        System.out.println("\nATENCIÓN: Saldo insuficiente. Por favor, ingrese dinero (Opción 1).");
                    }
                    System.out.print("\nPulsa ENTER para continuar...");
                    sc.nextLine();
                    break;

                case 3: // SALIR
                    System.out.print("\033c");
                    System.out.println("------------------------------------------");
                    System.out.println("👋 ¡Hasta luego! Gracias por jugar.");
                    System.out.println("El saldo final retirado es de: " + String.format("%.2f", saldo) + " €");
                    System.out.println("------------------------------------------");
                    sc.close();
                    return; // Termina la ejecución del método main
                    
                default:
                    System.out.println("\nOpción no reconocida. Por favor, selecciona 1, 2 o 3.");
                    System.out.print("Pulsa ENTER para continuar...");
                    sc.nextLine();
                    break;
            }
        }
    }
}