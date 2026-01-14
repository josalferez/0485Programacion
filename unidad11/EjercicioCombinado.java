import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class EjercicioCombinado {
    public static void main(String[] args) {

        // Validación de argumentos
        if (args.length < 1) {
            System.out.println("Error: Debes proporcionar al menos 1 argumento.");
            System.out.println("Uso: java EjercicioCombinado <nombre_estudiante>");
            return;
        }
        try {
            // Leer e imprimir el contenido original
            System.out.println("=== CONTENIDO ORIGINAL ===");
            try (BufferedReader br1 = new BufferedReader(new FileReader("lista_clase.txt"))) {
                String linea;
                while ((linea = br1.readLine()) != null) {
                    System.out.println(linea);
                }
            }

            // Modificar el fichero añadiendo el nuevo nombre
            try (BufferedWriter bw = new BufferedWriter(new FileWriter("lista_clase.txt", true))) {
                bw.newLine();
                bw.write(args[0]);
            }

            // Leer e imprimir el contenido actualizado
            System.out.println("\n=== CONTENIDO ACTUALIZADO ===");
            try (BufferedReader br2 = new BufferedReader(new FileReader("lista_clase.txt"))) {
                String linea;
                while ((linea = br2.readLine()) != null) {
                    System.out.println(linea);
                }
            }

            System.out.println("\nNombre añadido con éxito: " + args[0]);

        } catch (IOException e) {
            System.out.println("Error al trabajar con el archivo: " + e.getMessage());
        }
    }
}
