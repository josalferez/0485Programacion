import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class quitacomentarios2 {
    public static void main(String[] args) {

        // 1. Aseguramos que el programa recibe los dos argumentos esperados.
        if (args.length != 2) {
            System.out.println("Uso: java quitacomentarios <fichero_original> <fichero_limpio>");
            return; // Termina el programa si la cantidad de argumentos no es correcta.
        }

        String ficheroOriginal = args[0];
        String ficheroLimpio = args[1];

        // 2. Usamos un try-with-resources para asegurar el cierre automático de los ficheros.
        try (
            BufferedReader reader = new BufferedReader(new FileReader(ficheroOriginal));    // Abres el bufer de lectura
            BufferedWriter writer = new BufferedWriter(new FileWriter(ficheroLimpio))                               // Abres el bufer de escritura
        ) {
            boolean dentroDeComentarioDeBloque = false;
            String linea;

            // 3. Leemos el fichero línea por línea.
            while ((linea = reader.readLine()) != null) {
                // 4. Se usa una nueva variable para ir modificando la línea.
                String lineaProcesada = linea;

                if (dentroDeComentarioDeBloque) {
                    int finDeBloque = lineaProcesada.indexOf("*/");
                    if (finDeBloque != -1) {
                        // Salimos del comentario de bloque y procesamos el resto de la línea.
                        lineaProcesada = lineaProcesada.substring(finDeBloque + 2);
                        dentroDeComentarioDeBloque = false;
                    } else {
                        // La línea completa está dentro de un comentario de bloque.
                        lineaProcesada = "";
                    }
                }

                if (!dentroDeComentarioDeBloque) {
                    // Quitamos comentarios de línea.
                    int inicioDeLinea = lineaProcesada.indexOf("//");
                    if (inicioDeLinea != -1) {
                        lineaProcesada = lineaProcesada.substring(0, inicioDeLinea);
                    }

                    // Quitamos comentarios de bloque que empiezan en la misma línea.
                    int inicioDeBloque = lineaProcesada.indexOf("/*");
                    if (inicioDeBloque != -1) {
                        int finDeBloque = lineaProcesada.indexOf("*/", inicioDeBloque);
                        if (finDeBloque != -1) {
                            // Si el comentario de bloque termina en la misma línea, lo borramos.
                            lineaProcesada = lineaProcesada.substring(0, inicioDeBloque) + lineaProcesada.substring(finDeBloque + 2);
                        } else {
                            // Si el comentario de bloque no termina, se borra hasta el final de la línea.
                            lineaProcesada = lineaProcesada.substring(0, inicioDeBloque);
                            dentroDeComentarioDeBloque = true;
                        }
                    }
                }
                
                // 5. Escribimos la línea procesada en el nuevo fichero.
                if (!lineaProcesada.trim().isEmpty() || dentroDeComentarioDeBloque) {
                     writer.write(lineaProcesada);
                     writer.newLine(); // Usamos newLine() para agregar el salto de línea.
                }

            }
            System.out.println("Fichero procesado con éxito.");

        } catch (IOException e) {
            System.err.println("Error de entrada/salida: " + e.getMessage());
        }
    }
}