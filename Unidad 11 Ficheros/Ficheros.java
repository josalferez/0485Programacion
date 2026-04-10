import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Scanner;

public class Ficheros {
    public static void main(String[] args) {

        // Leyendo un fichero e imprimiéndolo por pantalla
        try {
            BufferedReader file = new BufferedReader(new FileReader("datos.txt"));

            String linea = "";

            while ((linea = file.readLine()) != null) {
                System.out.println(linea);
            }

            System.out.println("\n Has leído el fichero completo :)");

            // Cierro el fichero.
            file.close();

        } catch (IOException e) {
            System.out.println("No se pudo leer el archivo: " + e.getMessage());
        }

        // Escribiendo en el fichero
        try {
            BufferedWriter fWriter = new BufferedWriter(new FileWriter("datos.txt",true));
            Scanner sc = new Scanner(System.in);

            System.out.println("Introduce una línea de texto: ");
            String linea = sc.nextLine();

            fWriter.newLine(); // Meto un salto de línea en el fichero
            fWriter.write(linea);

            // Cierro el bufer e estcritura
            fWriter.close();

        } catch (Exception e) {
            System.out.println("No se pudo leer el archivo: " + e.getMessage());
        }

        // Leyendo un fichero e imprimiéndolo por pantalla
        try {
            BufferedReader file = new BufferedReader(new FileReader("datos.txt"));

            String linea = "";

            while ((linea = file.readLine()) != null) {
                System.out.println(linea);
            }

            System.out.println("\n Has leído el fichero completo :)");

            // Cierro el fichero.
            file.close();

        } catch (IOException e) {
            System.out.println("No se pudo leer el archivo: " + e.getMessage());
        }
    }
}
