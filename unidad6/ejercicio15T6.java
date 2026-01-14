public class ejercicio15T6 {

    public static void main(String[] args) {
        
        // 1. Generar el número total de notas (longitud de la melodía)
        int numNotas;
        
        // El bucle do-while asegura que el número sea múltiplo de 4, entre 4 y 28.
        do {
            // Genera un número aleatorio entre 4 y 28 (ambos inclusive).
            numNotas = (int) (Math.random() * 25) + 4;
            
        } while (numNotas % 4 != 0); // Repite mientras el número no sea múltiplo de 4
        
        System.out.println("--- Generador de Melodía ---");
        System.out.println("Longitud: " + numNotas + " notas (" + (numNotas / 4) + " compases)");
        System.out.println("----------------------------");
        
        // 2. Generar la primera nota (que será también la última)
        int indicePrimeraNota = (int) (Math.random() * 7) + 1;
        
        // Obtener el String de la primera nota mediante un switch
        String primeraNota;
        switch (indicePrimeraNota) {
            case 1: primeraNota = "do"; break;
            case 2: primeraNota = "re"; break;
            case 3: primeraNota = "mi"; break;
            case 4: primeraNota = "fa"; break;
            case 5: primeraNota = "sol"; break;
            case 6: primeraNota = "la"; break;
            case 7: primeraNota = "si"; break;
            default: primeraNota = "???"; break; 
        }

        // 3. Construir la melodía usando concatenación de String (+=)
        String melodia = ""; // Inicializamos el String vacío
        int notasEnCompas = 0;
        
        for (int i = 0; i < numNotas; i++) {
            
            String notaActual;
            
            // Lógica para la primera y última nota (d)
            if (i == 0) {
                notaActual = primeraNota;
            } else if (i == numNotas - 1) {
                notaActual = primeraNota;
            } else {
                // a) Generar el resto de las notas al azar (número entre 1 y 7)
                int indice = (int) (Math.random() * 7) + 1; 
                
                // Lógica del switch para obtener el nombre de la nota
                switch (indice) {
                    case 1: notaActual = "do"; break;
                    case 2: notaActual = "re"; break;
                    case 3: notaActual = "mi"; break;
                    case 4: notaActual = "fa"; break;
                    case 5: notaActual = "sol"; break;
                    case 6: notaActual = "la"; break;
                    case 7: notaActual = "si"; break;
                    default: notaActual = "???"; break;
                }
            }
            
			// Construyo las notas de la melodía
            melodia += notaActual;
            
            // Control de compás
            notasEnCompas++;
            
            if (i < numNotas - 1) {
                // Separador entre notas: un espacio
                melodia += " ";
            }

            // c) Separación por compases (|) cada 4 notas
            if (notasEnCompas == 4) {
                if (i < numNotas - 1) {
                    // Separar del siguiente compás con una barra
                    melodia += "| ";
                }
                notasEnCompas = 0; // Reiniciar el contador de compás
            }
        }
        
        // c) Marcar el final de la melodía con dos barras
        melodia += "||";

        // 4. Imprimir el resultado
        System.out.println(melodia); // Imprimimos directamente el String
    }
}