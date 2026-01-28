import java.io.BufferedWriter;
import java.util.Scanner;
import java.io.FileWriter;

public class EjemploFichero10 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        // Le pedimos una palabra al usuario y la introducimos en el fichero.

        try {
            System.out.print("Dime una palabra: ");
            String palabra = sc.nextLine();

            BufferedWriter bw = new BufferedWriter(new FileWriter("palabras.txt", true)); // Introduzco en palabras.txt
             
            bw.write(palabra); // Añadimos la palabra en el fichero

            bw.close(); // Cierro el recurso
            
            
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("Error: " + e.getMessage());
        }
    }
}
