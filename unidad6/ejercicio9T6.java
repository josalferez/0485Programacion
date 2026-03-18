public class ejercicio9T6 {

    public static void main(String[] args) {
        
        int contadorNumeros = 0;
        int numeroActual = -1; // Inicializamos con un valor que no sea par ni 24 (ej: -1)

        System.out.println("--- Generador de Pares hasta el 24 ---");
        
        // El bucle continuará MIENTRAS el número generado no sea 24.
        while (numeroActual != 24) {
            
            // 1. Generar un número aleatorio entre 0 y 100.
            // Math.random() * 101 -> [0.0, 100.99...]
            int numeroBruto = (int) (Math.random() * 101);
            
            // 2. Asegurar que el número sea PAR.
            // Si el número es impar (resto de la división por 2 es 1), le restamos 1.
            // Esto asegura que el número resultante esté en el rango [0, 100] y sea par.
            if (numeroBruto % 2 != 0) {
                numeroActual = numeroBruto - 1;
            } else {
                numeroActual = numeroBruto;
            }
            
            // 3. Contar el número generado e imprimirlo (excepto el 24)
            // Contamos el 24 para que la cuenta sea precisa.
            contadorNumeros++; 
            
            // Imprimir todos los números generados, separados por comas.
            if (contadorNumeros > 1) {
                System.out.print(", ");
            }
            System.out.print(numeroActual);
            
            // Si sacamos el 24, el bucle terminará en la siguiente evaluación del while.
        }
        
        // Imprimimos el resultado final
        System.out.println(); // Salto de línea después de la lista de números
        System.out.println("----------------------------------------------");
        System.out.println("¡Se ha generado el número 24!");
        System.out.println("Se generaron un total de **" + contadorNumeros + "** números.");
    }
}