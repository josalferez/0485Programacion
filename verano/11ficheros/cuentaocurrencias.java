
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class cuentaocurrencias {

    public static void main(String[] args) {

        if (args.length == 2) {
            String palabraABuscar = args[0];
            String fichero = args[1];
            int numeroVecesEncontrada = 0;
            // 1. Abro el fichero  y leo cada una de las palabras con el objeto Scanner
            try (FileReader lector = new FileReader(fichero); BufferedReader buferLector = new BufferedReader(lector); Scanner scanner = new Scanner(buferLector)) {
                while (scanner.hasNext()) {
                    String palabra = scanner.next();
                    palabra = palabra.replaceAll("[^a-zA-Z0-9]",""); // quita los puntos de las palabras por ejemplo Hola. lo deja como Hola
                    if (palabra.toLowerCase().equals(palabraABuscar.toLowerCase())) { // Pongo las dos palabras a minuscula antes de compararlas
                        numeroVecesEncontrada++;
                    }
                    System.out.println("Palabra leída: " + palabra);
                }

                System.out.println("La Palabra ** " + palabraABuscar + " ** aparece " + numeroVecesEncontrada + " vez en el fichero " + fichero);

            } catch (IOException e) {
                System.out.println("Error al abrir el fichero" + e.getMessage());
            }
        } else {
            System.out.println("El número de argumentos debe ser dos: cuentaocurrencias <palabraABuscar> <nombreFichero>");
        }
    }
}
