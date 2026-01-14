
import java.io.*;

public class EscrituraFichero2{

    public static void main(String[] args) {

        String contenido = "¡Hola, mundo! Este es un ejemplo de cómo guardar texto en un fichero.";

        // Paso 1 y 2: Crear un FileWriter para escribir en el fichero
        // El 'true' en el constructor indica que se añadirá al final del fichero si existe.
        // Si fuera 'false' (por defecto), sobrescribiría el contenido.
        
        try( FileWriter escritor = new FileWriter("miarchivo.txt")) {
            
            // Paso 3: Escribir el contenido en el fichero
            escritor.write(contenido);
 
            System.out.println("Los datos se han guardado en el fichero correctamente.");

        } catch (IOException e) {
            System.out.println("Ha ocurrido un error al escribir en el fichero." + e.getMessage());
        } 

        // Leo el contenido del fichero
        // Abro el fichero en modo lectura y creo el Stream para leerlo
        try (BufferedReader bufer = new BufferedReader( new FileReader("miarchivo.txt"))) {
            
            String linea = "";
            while ((linea = bufer.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (IOException e) {
            System.out.println("Ha habido un error en la lectura del fichero" + e.getMessage());
        }    
    }
}
