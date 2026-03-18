
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class quitacomentarios {

    public static void main(String[] args) {

        // Aseguro que el programa recibe dos argumentos
        if (args.length == 2) {
            String fichero = args[0];
            String ficheroLimpio = args[1];
            // 1. Abrimos el fichero y buscamos el caracter #, si lo encontramos, nos lo cepillamos
            try (FileReader lector = new FileReader(fichero); BufferedReader buferLector = new BufferedReader(lector); Scanner linea = new Scanner(buferLector)) {
                FileWriter escritor = new FileWriter(ficheroLimpio);
                while (linea.hasNext()) {
                    String lineaSinComentarios = linea.nextLine().replaceAll("//.*", "");
                    // 2. Abro el fichero limpio y añado la palabra sin comentario
                    
                    escritor.write(lineaSinComentarios + "\n");
                }
                escritor.close();

            } catch (Exception e) {
                System.out.println("Error al abrir el fichero" + e.getMessage());
            }

        } else {
            System.out.println("El número de argumentos debe ser uno: quitacomentarios <nombreFichero> <nombreFicheroLimpio");
            return; // Termina el progrma
        }
    }

}
