
import java.io.BufferedWriter;
import java.io.FileWriter;

public class EjemploFichero02 {
    public static void main(String[] args) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("fruta.txt",true));
            bw.write("Platano\n");
            bw.write("uvas\n");
            bw.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
