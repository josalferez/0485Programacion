import java.util.Scanner;

public class ejercicio8T7Bi {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String posicion;
        int filaInicio = -1;
        int colInicio = -1;

        // Definición de constantes locales (final int)
        final int TAMANO_TABLERO = 8;
        // El máximo de casillas a las que puede saltar un alfil es 13. Usamos 14 por seguridad.
        final int MAX_MOVIMIENTOS = 14; 

        // Array de tamaño fijo para almacenar las casillas resultantes
        String[] movimientosPosibles = new String[MAX_MOVIMIENTOS];
        int contadorMovimientos = 0;

        // 1. Pedir y validar la posición de inicio
        System.out.println("--- Movimiento de Alfil en Tablero de Ajedrez (" + TAMANO_TABLERO + "x" + TAMANO_TABLERO + ") ---");
        
        // El bucle do-while realiza la validación simple 
        do {
            System.out.print("Introduce la posición del alfil (ej: d5, a1, h8): ");
            posicion = s.nextLine().toLowerCase();

            // Comprobación de que la entrada tiene 2 caracteres y cumple los rangos
            if (posicion.length() == 2) {
                
                char letraColumna = posicion.charAt(0);
                char caracterFila = posicion.charAt(1);
                
                // 1. Validar la Columna ('a' a 'h')
                if (letraColumna >= 'a' && letraColumna <= 'h') {
                    colInicio = letraColumna - 'a'; // 'a'->0, 'b'->1, ..., 'h'->7
                } else {
                    colInicio = -1; // Marcar como inválido
                }

                // 2. Validar la Fila ('1' a '8')
                if (caracterFila >= '1' && caracterFila <= '8') {
                    int numeroFila = caracterFila - '0'; // Convertir '1' a 1, '8' a 8, etc.
                    // Mapeo a índice de matriz: 8 -> 0, 1 -> 7
                    filaInicio = TAMANO_TABLERO - numeroFila;
                } else {
                    filaInicio = -1; // Marcar como inválido
                }

                // Si alguna de las coordenadas es inválida, se fuerza la repetición
                if (colInicio == -1 || filaInicio == -1) {
                    System.out.println("Posición inválida. El formato debe ser [a-h][1-8] (ej: c5).");
                    posicion = ""; // Reiniciar la posición para repetir el bucle
                }
                
            } else {
                System.out.println("Posición inválida. Debe tener 2 caracteres.");
                posicion = "";
            }
        } while (posicion.isEmpty());

        s.close();

        // 2. Calcular los movimientos posibles
        
        // dr (delta fila) y dc (delta columna) para las 4 diagonales:
        // Noroeste (-1,-1), Noreste (-1, 1), Suroeste (1, -1), Sureste (1, 1)
        int[] dr = {-1, -1, 1, 1}; 
        int[] dc = {-1, 1, -1, 1}; 
        
        // Iterar sobre las 4 direcciones
        for (int i = 0; i < 4; i++) {
            
            // Moverse a lo largo de la diagonal (k es la distancia, de 1 a 7)
            for (int k = 1; k < TAMANO_TABLERO; k++) { 
                
                int filaActual = filaInicio + dr[i] * k;
                int colActual = colInicio + dc[i] * k;
                
                // Comprobar si la nueva posición está dentro del tablero (índices 0 a 7)
                if (filaActual >= 0 && filaActual < TAMANO_TABLERO && colActual >= 0 && colActual < TAMANO_TABLERO) {
                    
                    // Conversión a notación algebraica EN LÍNEA
                    char letraColumnaResultado = (char) ('a' + colActual);
                    int numeroFilaResultado = TAMANO_TABLERO - filaActual;
                    
                    // Crear la cadena de notación
                    String notacion = "" + letraColumnaResultado + numeroFilaResultado;
                    
                    // Almacenar el movimiento si cabe en el array
                    if (contadorMovimientos < MAX_MOVIMIENTOS) {
                        movimientosPosibles[contadorMovimientos] = notacion;
                        contadorMovimientos++;
                    } 
                } else {
                    // Si se sale del tablero, detener la búsqueda en esta diagonal y pasar a la siguiente
                    break;
                }
            }
        }
        
        // 3. Mostrar el resultado
        System.out.println("\n------------------------------------------------");
        System.out.println("Posición inicial del alfil: " + posicion.toUpperCase());
        System.out.println("------------------------------------------------");
        
        
        if (contadorMovimientos == 0) {
            System.out.println("No se encontraron movimientos posibles. (Esto es imposible en un tablero 8x8 con un alfil).");
        } else {
            System.out.println("El alfil puede saltar a las siguientes " + contadorMovimientos + " casillas:");
            
            // Imprimir la lista de casillas
            for (int i = 0; i < contadorMovimientos; i++) {
                System.out.print(movimientosPosibles[i].toUpperCase());
                
                // Formateo para separar con coma y añadir salto de línea cada 8 elementos
                if (i < contadorMovimientos - 1) {
                    System.out.print(", ");
                }
                if ((i + 1) % 8 == 0 && i < contadorMovimientos - 1) {
                    System.out.println();
                }
            }
            System.out.println(); 
        }
        System.out.println("------------------------------------------------");
    }
}