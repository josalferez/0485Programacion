
import java.io.*;

public class leoxml {

    public static void main(String[] args) {

        try (BufferedReader lector = new BufferedReader(new FileReader("libros.xml"))) {
            String linea = "";
            while ((linea = lector.readLine()) != null) {
                if (linea.contains("titulo")) {
                    int beginIndex = linea.indexOf("<titulo>");
                    int endIndex = linea.indexOf("</titulo>");
                    String titulo = linea.substring(beginIndex+8, endIndex);
                    System.out.println("Titulo: " + titulo);
                }                    
            }
        } catch (Exception e) {
            System.out.println("El fichero no existe");
        }

    }
}
