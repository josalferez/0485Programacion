
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class cuentaLetras {

    public static void main(String[] args) {

        // 1. Abro el fichero
        String fichero = args[0];
        String linea = "";
        int totalLetras = 0;

        try (FileReader reader = new FileReader(fichero); Scanner sc = new Scanner(reader)) {
            while (sc.hasNextLine()) {
                linea = sc.nextLine().replaceAll("[^a-zA-Z]","");
                totalLetras += linea.length();
            }
        } catch (IOException e) {
            System.out.println("El fichero no existe" + e.getMessage());
        }
        System.out.println("El número de caracteres del fichero es: " + totalLetras);
    }
}