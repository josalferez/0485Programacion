import java.util.ArrayList;
import java.util.Collections; // Para ordenar

public class pizarra1T10 {
    public static void main(String[] args) {
        // 1. Crear el ArrayList
        ArrayList<String> texto = new ArrayList<String>();

        // 2. add(valor) - Añadir elementos
        texto.add("hola");
        texto.add("mundo");
        texto.add("Java");
        
        // add(índice, valor) - Insertar en una posición específica
        texto.add(1, "amigo"); // Ahora es: [hola, amigo, mundo, Java]

        // 3. size() - Obtener el tamaño
        System.out.println("Nº de elementos: " + texto.size());

        // 4. get(índice) - Leer un elemento
        System.out.println("El segundo elemento es: " + texto.get(1));

        // 5. set(índice, valor) - Modificar un elemento
        texto.set(0, "buenos días"); // Cambia "hola" por "buenos días"

        // 6. contains(valor) - Comprobar si existe algo (devuelve true/false)
        if (texto.contains("Java")) {
            System.out.println("La lista contiene la palabra Java");
        }

        // 7. remove() - Eliminar elementos
        texto.remove(2); // Elimina por índice (elimina "mundo")
        texto.remove("Java"); // Elimina por contenido

        // 8. toArray() - Convertir a array (lo que ya tenías)
        String[] arrayDeStrings = texto.toArray(new String[0]);

        // Verificación final
        System.out.println("Contenido final del ArrayList: " + texto);
        
        // 9. clear() - Vaciar la lista por completo
        texto.clear();
        System.out.println("¿Está vacía después del clear? " + texto.isEmpty());
    }
}