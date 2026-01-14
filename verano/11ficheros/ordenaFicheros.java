
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ordenaFicheros {

    public static void main(String[] args) {

        // Declaro las variables
        Scanner sc = new Scanner(System.in);
        String fichero = null;

        System.out.println("Introduce el nombre del fichero: palabras.txt");
        fichero = sc.nextLine();

        // 1. Abro y leo las palabras del fichero almacenándolas en un ArrayList
        try (FileReader lector = new FileReader(fichero); 
             BufferedReader buferLector = new BufferedReader(lector); 
             Scanner scanner = new Scanner(buferLector)) {
                ArrayList<String> archivoPalabrasTemporal = new ArrayList<>();
                while (scanner.hasNext()) {
                    String palabra = scanner.next();
                    archivoPalabrasTemporal.add(palabra);
                    System.out.println("Palabra leída: " + palabra);
                }

            // Ordeno el arrayList
            archivoPalabrasTemporal.sort(null);

            // Guardo el arrayList ordenado en el fichero palabrasSort.txt
            try (FileWriter escritor = new FileWriter("palabrasSort.txt")) {
                for (String palabra : archivoPalabrasTemporal) {
                    escritor.write(palabra + "\n");
                }
                System.out.println("Los datos se han guardado en el fichero correctamente.");
            } catch (IOException e) {
                System.out.println("Ha ocurrido un error al escribir en el fichero." + e.getMessage());
            }

        } catch (IOException e) {
            System.out.println("Error al abrir el fichero" + e.getMessage());
        }
    }

}
