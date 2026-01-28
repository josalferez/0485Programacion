
import java.io.BufferedReader;
import java.io.FileReader;

public class EjemploFichero08 {

    public static void main(String[] args) {
        try {
            // 1. Abro un fichero
            BufferedReader br = new BufferedReader(new FileReader("numeros.txt"));

            // 2. Sumo cada línea
            String linea = "";
            int suma = 0;
            while ((linea = br.readLine()) != null) {
                suma += Integer.parseInt(linea);
            }

            // 3. Imprimo por pantalla el resultado final.
            System.out.println("La suma de los números del fichero es: " + suma);

            // 4. Cerramos el bufer.
            br.close();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
