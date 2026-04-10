import java.util.Scanner;

public class BuscaTesoro {
    public static void main(String[] args) {
        // se definen constantes para representar el contenido de las celdas
        final int VACIO = 0;
        final int MINA = 1;
        final int TESORO = 2;
        final int INTENTO = 3;

        int x;
        int y;
        Scanner sc = new Scanner(System.in); // Necesario para leer la entrada

        // Array de 5 columnas (x) y 4 filas (y)
        int[][] cuadrante = new int[5][4];

        // 1. CORRECCIÓN: Inicializa el array completamente (5 columnas x 4 filas)
        for(x = 0; x < 5; x++) {
            for(y = 0; y < 4; y++) {
                cuadrante[x][y] = VACIO;
            }
        }

        // coloca la mina (Coordenadas aleatorias entre 0-4 y 0-3)
        int minaX = (int)(Math.random() * 5);
        int minaY = (int)(Math.random() * 4);
        cuadrante[minaX][minaY] = MINA;

        // coloca el tesoro
        int tesoroX;
        int tesoroY;
        do {
            tesoroX = (int)(Math.random() * 5);
            tesoroY = (int)(Math.random() * 4);
        } while ((minaX == tesoroX) && (minaY == tesoroY));
        cuadrante[tesoroX][tesoroY] = TESORO;

        // juego
        System.out.println("¡BUSCA EL TESORO!");
        
        boolean salir = false;
        String c = "";
        
        do {
            // pinta el cuadrante oculto
            for(y = 3; y >= 0; y--) { // Recorre de arriba a abajo (y=3 a y=0)
                System.out.print(y + "|");
                for(x = 0; x < 5; x++) { // Recorre de izquierda a derecha (x=0 a x=4)
                    if (cuadrante[x][y] == INTENTO) {
                        System.out.print("X ");
                    } else {
                        System.out.print("  "); // Se usa doble espacio para alinear con "X "
                    }
                }
                System.out.println();
            }
            System.out.println("  ----------\n  0 1 2 3 4\n");
            
            // pide las coordenadas
            System.out.print("Coordenada x (0-4): ");
            // Se usa Scanner para una lectura más robusta
            x = sc.nextInt(); 
            
            System.out.print("Coordenada y (0-3): ");
            y = sc.nextInt();

            // Validación de límites (¡IMPORTANTE!)
            if (x < 0 || x > 4 || y < 0 || y > 3) {
                System.out.println("¡Coordenadas fuera del mapa! Inténtalo de nuevo.");
                continue; // Vuelve al inicio del bucle do-while
            }
            
            // mira lo que hay en las coordenadas indicadas por el usuario
            switch(cuadrante[x][y]) {
                case VACIO:
                    cuadrante[x][y] = INTENTO;
                    break;
                case MINA:
                    System.out.println("Lo siento, has perdido.");
                    salir = true;
                    break;
                case TESORO:
                    System.out.println("¡Enhorabuena! ¡Has encontrado el tesoro!");
                    salir = true;
                    break;
                case INTENTO:
                    System.out.println("¡Ya has probado esta casilla! Elige otra.");
                    break;
                default:
            }
        } while (!salir);

        // pinta el cuadrante final (mostrando todo)
        System.out.println("\n--- Mapa Final ---");
        for(y = 3; y >= 0; y--) {
            System.out.print(y + "|");
            for(x = 0; x < 5; x++) {
                switch(cuadrante[x][y]) {
                    case VACIO:
                        c = "  "; // Espacio doble
                        break;
                    case MINA:
                        c = "* "; // Mina
                        break;
                    case TESORO:
                        c = "€ "; // Tesoro
                        break;
                    case INTENTO:
                        c = "X "; // Intento fallido
                        break;
                    default:
                }
                System.out.print(c);
            }
            System.out.println();
        }
        System.out.println("  ----------\n  0 1 2 3 4\n");
        
        sc.close();
    }
}