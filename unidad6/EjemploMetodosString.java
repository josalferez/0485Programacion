import java.util.Scanner;

public class EjemploMetodosString {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("--- Demostración de Métodos String ---");
        
        // 1. Pedir entrada
        System.out.print("Introduce una frase con mayúsculas y minúsculas: ");
        String fraseOriginal = scanner.nextLine().trim(); // Usando trim()
		System.out.println(fraseOriginal);
        
        System.out.print("Introduce una palabra a buscar: ");
        String palabraBusqueda = scanner.nextLine();
        
        System.out.println("\n-------------------------------------");

        // 2. Obtener Información y Longitud (length(), charAt(), isEmpty())
        System.out.println("1. Información:");
        System.out.println("  Longitud de la frase: " + fraseOriginal.length());
        
        if (fraseOriginal.length() > 0) {
            System.out.println("  Primer carácter: " + fraseOriginal.charAt(0));
            System.out.println("  Último carácter: " + fraseOriginal.charAt(fraseOriginal.length() - 1));
        }

        // 3. Búsqueda e Índice (contains(), indexOf())
        System.out.println("\n2. Búsqueda:");
        
        // contains()
        if (fraseOriginal.contains(palabraBusqueda)) {
            System.out.println("  La frase contiene la palabra \"" + palabraBusqueda + "\".");
            // indexOf()
            int indice = fraseOriginal.indexOf(palabraBusqueda);
            System.out.println("  Aparece por primera vez en el índice: " + indice);
        } else {
            System.out.println("  La palabra \"" + palabraBusqueda + "\" NO se encontró.");
        }

        // 4. Comparación (equalsIgnoreCase())
        String fraseMayusculas = fraseOriginal.toUpperCase(); // Usando toUpperCase()
        System.out.println("\n3. Comparación:");
        System.out.println("  Frase en mayúsculas: " + fraseMayusculas);
	        
        if (fraseOriginal.equalsIgnoreCase(fraseMayusculas)) { // Usando equalsIgnoreCase()
            System.out.println("  La frase original y la frase en mayúsculas son iguales ignorando el caso.");
        } else {
             System.out.println("  La frase original y la frase en mayúsculas no son iguales.");
        }

        // 5. Manipulación (substring(), replace())
        System.out.println("\n4. Manipulación:");
        
        // substring()
        if (fraseOriginal.length() >= 5) {
            String subcadena = fraseOriginal.substring(0, 5);
            System.out.println("  Los primeros 5 caracteres: " + subcadena);
        }
        
        // replace()
        String fraseModificada = fraseOriginal.replace('a', '@');
        System.out.println("  Frase con 'a' reemplazada por '@': " + fraseModificada);
        
        // 6. Conversión (valueOf())
        int numero = 42;
        String numeroTexto = String.valueOf(numero);
        System.out.println("\n5. Conversión:");
        System.out.println("  Número entero (42) convertido a String: \"" + numeroTexto + "\"");

        scanner.close();
    }
}