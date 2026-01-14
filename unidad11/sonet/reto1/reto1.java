import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class reto1 {
    public static void main(String[] args) {

        int numeroTotalLineas = 0;
        int numeroTotalPalabras = 0;
        int numeroTotalCaracteres = 0;
        HashMap<String, Integer> contador = new HashMap<>();
        String palabraMasRepetida = "";
        int maxRepeticiones = 0;

        try {
            System.out.println("Reto 1: Contador de palabras");
            try (BufferedReader bf = new BufferedReader(new FileReader("lista_clase.txt"))) {
                String linea;
                while ((linea = bf.readLine()) != null) {
                    numeroTotalLineas++;
                    String[] temp = linea.split(" ");
                    for (String palabra : temp) // for (String palabra : linea.split("")) -- PRO
                        if (!palabra.isEmpty()) { // Compruebo que la palabra no esté vacía
                            numeroTotalPalabras++; // Incremento el número de palabras
                            numeroTotalCaracteres += palabra.length(); // Incremento el número de caracteres

                            // Busco las veces que aparece la palabra en el fichero
                            if (contador.containsKey(palabra)) { // Si la palabra está en el HashMap le incremento el
                                                                 // key
                                int valor = contador.get(palabra); // Devuelve las veces que aparece la palabra
                                valor++;
                                contador.put(palabra, valor);
                            } else { // Si no está la añado
                                contador.put(palabra, 1);
                            }
                        }
                }

                // Encontrar la palabra más repetida
                for (Map.Entry<String, Integer> entry : contador.entrySet()) {
                    if (entry.getValue() > maxRepeticiones) {
                        maxRepeticiones = entry.getValue();
                        palabraMasRepetida = entry.getKey();
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error al trabajar con el archivo: " + e.getMessage());
        }

        System.out.println("=== RESULTADOS ===");
        System.out.println("Líneas totales: " + numeroTotalLineas);
        System.out.println("Palabras totales: " + numeroTotalPalabras);
        System.out.println("Caracteres totales: " + numeroTotalCaracteres);
        System.out.println("Palabra más repetida: '" + palabraMasRepetida + "' (" + maxRepeticiones + " veces)");

    }
}
