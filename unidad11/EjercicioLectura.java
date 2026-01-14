import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class EjercicioLectura {
    public static void main(String[] args) {
        try {
            // 1. Crea el "lector" (FileReader) apuntando a "datos.txt"
            // 2. Envuélvelo en un BufferedReader para leer línea a línea
            FileReader fichero = new FileReader("datos.txt");
            BufferedReader file = new BufferedReader(fichero);
            
            String linea = "";
            
            // 3. Necesitamos un bucle que lea mientras la linea NO sea null
            // Dentro del bucle, imprime la línea por pantalla
            while ( (linea = file.readLine()) != null){
                System.out.println(linea);
            }
            
            // 4. No olvides cerrar el buffer al terminar
            file.close();
            
        } catch (IOException e) {
            System.out.println("No se pudo leer el archivo: " + e.getMessage());
        }
    }
}