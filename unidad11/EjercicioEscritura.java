import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class EjercicioEscritura {
    public static void main(String[] args) {
        try {
            // 1. Crea el FileWriter apuntando a "salida.txt"
            // 2. Envuélvelo en un BufferedWriter
            BufferedWriter bw = new BufferedWriter(new FileWriter("salida.txt",true)); // true para añadir al final del fichero

            // 3. Usa el método .write("tu texto") para escribir
            // 4. Usa el método .newLine() para saltar de línea

            bw.write("Hola, esto es una prueba");
            bw.newLine();
            bw.write("Segunda línea del fichero");

            // 5. MUY IMPORTANTE: Cierra el buffer
            bw.close();

            System.out.println("Archivo creado con éxito.");
        } catch (IOException e) {
            System.out.println("Error al escribir: " + e.getMessage());
        }
    }
}
