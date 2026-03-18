import java.util.Scanner;

public class ejercicio6T6 {
    public static void main(String[] args) {
        
        // 1. Configuración del Juego
        int intentosRestantes = 5; // Valor fijo
        
        // Genera un número aleatorio entre 0 y 100 (ambos incluidos) usando Math.random()
        int numeroSecreto = (int) (Math.random() * 101); 
        
        Scanner scanner = new Scanner(System.in);
        boolean noAdivinado = true;
        
        System.out.println("--- ¡Juego de Adivinanza! ---");
        System.out.println("He pensado un número secreto entre 0 y 100.");
        System.out.println("Tienes 5 oportunidades para adivinarlo."); // Se usa el valor fijo 5
        System.out.println("----------------------------");

        // 2. Bucle Principal del Juego
        while (intentosRestantes > 0 && noAdivinado) {
            
            // Calculamos el número de intento actual
            int numeroDeIntento = 5 - intentosRestantes + 1;
            
            System.out.print("Introduce tu número (Intento " + numeroDeIntento + "): ");
            
            // Validación de entrada
            if (!scanner.hasNextInt()) {
                System.out.println("¡Error! Por favor, introduce solo números.");
                scanner.next(); 
                continue; // Vuelve al inicio del while sin consumir ningún valor
            }
            
            int intentoUsuario = scanner.nextInt();
            
            // 3. Comprobación del Intento
            if (intentoUsuario == numeroSecreto) {
                noAdivinado = false;
                System.out.println("🎉 ¡Felicidades! ¡Has adivinado el número secreto " + numeroSecreto + "!");
            } else {
                intentosRestantes--; // Gasta un intento
                
                // Pista al usuario
                if (intentoUsuario < numeroSecreto) {
                    System.out.println("El número que buscas es **MAYOR** que " + intentoUsuario + ".");
                } else { 
                    System.out.println("El número que buscas es **MENOR** que " + intentoUsuario + ".");
                }
                
                // Mensaje de oportunidades restantes
                if (intentosRestantes > 0) {
                    System.out.println("Te quedan **" + intentosRestantes + "** oportunidades.");
                    System.out.println();
                }
            }
        }
        
        // 4. Resultado Final
        if (noAdivinado) {
            System.out.println();
            System.out.println("Game Over. Te has quedado sin oportunidades.");
            System.out.println("El número secreto era el **" + numeroSecreto + "**.");
        }
        
        scanner.close();
    }
}