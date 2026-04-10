import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Ejemplo de uso de la clase File
 * Escritura en un fichero de texto
 *
 * @author Luis José Sánchez
 */
class escritura {
    public static void main(String[] args) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("fruta.txt",true));
            bw.write("naranja2\n");
            bw.write("mango2\n");
            bw.write("chirimoyassssssssss\n");
            bw.close();
        } catch (IOException ioe) {
            System.out.println("No se ha podido escribir en el fichero");
        }
    }
}
