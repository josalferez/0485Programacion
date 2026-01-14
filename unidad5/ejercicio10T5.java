import java.util.Scanner;

public class ejercicio10T5 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double numero = 0; // Almacena el número introducido
        double suma = 0;   // Acumulador para la suma de los números
        int contador = 0;  // Contador de cuántos números positivos se han introducido

        System.out.println("--- Calculadora de Media de Números Positivos ---");
        System.out.println("Introduce números positivos.");
        System.out.println("Para calcular la media y finalizar, introduce un número negativo.");
        
        // El bucle 'do-while' asegura que al menos se pida un número
        do {
            System.out.print("Introduce un número: ");
            
            // Aseguramos que la entrada sea un número para evitar errores (opcional pero recomendado)
            if (sc.hasNextDouble()) {
                numero = sc.nextDouble(); // Lee el número
            } else {
                System.out.println("Entrada no válida. Por favor, introduce un número.");
                sc.next(); // Consumir la entrada no válida
                continue;  // Volver al inicio del bucle
            }

            // Comprobamos si el número es positivo (o cero)
            if (numero >= 0) {
                suma += numero;    // Acumulamos el número a la suma total
                contador++;        // Incrementamos el contador de números
            }
            
        } while (numero >= 0); // El bucle continúa mientras el número introducido sea positivo o cero.

        sc.close(); // Cerramos el Scanner

        // ------------------ Cálculo y Resultado ------------------
        
        // Verificamos si se introdujo al menos un número positivo
        if (contador > 0) {
            // Calculamos la media (suma total / cantidad de números)
            double media = suma / contador;
            
            System.out.println("\n-------------------------------------------");
            System.out.println("Resumen de la operación:");
            System.out.println("Suma total de los " + contador + " números: " + suma);
            System.out.printf("La media de los números positivos es: %.2f\n", media);
            System.out.println("-------------------------------------------");
        } else {
            // Este caso ocurre si el usuario introduce un negativo en la primera entrada
            System.out.println("\nNo se introdujo ningún número positivo. No se puede calcular la media.");
        }
    }
}