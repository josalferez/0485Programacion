import java.util.Scanner;

public class ejercicio16T6 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        // Declaramos 3 variables para almacenar los valores numéricos (1 a 5) de la tirada
        int figura1, figura2, figura3;
        String salir;
        
        System.out.println("--- MÁQUINA TRAGAPERRAS (Ejercicio 16) ---");

        while (true) {
            
            // Limpio la pantalla (carácter de escape ANSI)
            System.out.print("\033c");

            // 1. GENERAR LA TIRADA USANDO Math.random() (Valores 1 a 5)
            figura1 = (int) (Math.random() * 5) + 1;
            figura2 = (int) (Math.random() * 5) + 1;
            figura3 = (int) (Math.random() * 5) + 1;
            
            // 2. MOSTRAR LA TIRADA (Usando switch/case para cada figura)
            
            System.out.print("Resultado de la tirada: ");
            
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
            
            // 3. COMPROBAR LAS CONDICIONES DE PREMIO
            
            // Requisito d) Tres figuras iguales
            if (figura1 == figura2 && figura2 == figura3) {
                System.out.println("** Enhorabuena, ha ganado 10 monedas **");
                
            // Requisito c) Dos figuras iguales y una diferente
            } else if (figura1 == figura2 || figura1 == figura3 || figura2 == figura3) {
                System.out.println("Bien, ha recuperado su moneda");
                
            // Requisito b) Tres figuras diferentes
            } else {
                System.out.println("Lo siento, ha perdido");
            }
            
            // 4. PREGUNTAR SI QUIERE SALIR
            System.out.print("\n ¿Quieres Salir? (S/N): ");
            // Consumir el ENTER pendiente y leer la línea
            salir = sc.nextLine().toLowerCase();

            if (salir.equals("s")) {
                System.out.print("\033c");
                System.out.println("Programa Finalizado.");
                break; // Sale del bucle
            }
        }
        
        sc.close();
    }
}