import java.util.Scanner;

public class ejercicio24T6 {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        String numeroTexto;

        System.out.println("--- Extractor de Dígito Aleatorio ---");
        
        // 1. Solicitar y validar la entrada del usuario
        // Mantenemos la entrada como String para evitar problemas de límite de int si es un número grande
        do {
            System.out.print("Por favor, introduzca un número entero positivo: ");
            // Leer la línea completa como String
            if (scanner.hasNextLine()) {
                numeroTexto = scanner.nextLine().trim();
            } else {
                numeroTexto = "";
            }
            
            // Comprobación simple para asegurar que se introdujo algo parecido a un número positivo
            if (numeroTexto.isEmpty() || !numeroTexto.matches("\\d+")) {
                System.out.println("Error: Por favor, introduzca un número entero positivo válido.");
            }
        } while (numeroTexto.isEmpty() || !numeroTexto.matches("\\d+"));
        
        // 2. Obtener la longitud (número de dígitos)
        int longitud = numeroTexto.length();
        
        // 3. Elegir un índice al azar
        // Math.random() * longitud genera un índice entre 0.0 y (longitud - 0.00...1)
        // (int) trunca el resultado, dando un índice válido: 0, 1, 2, ..., longitud-1
        int indiceAleatorio = (int) (Math.random() * longitud);
        
        // 4. Extraer el dígito en ese índice
        // charAt(indice) devuelve el carácter (dígito) en la posición aleatoria
        char digitoElegido = numeroTexto.charAt(indiceAleatorio);
        
        // 5. Mostrar el resultado
        System.out.println("----------------------------------------");
        System.out.println(digitoElegido);

        scanner.close();
    }
}