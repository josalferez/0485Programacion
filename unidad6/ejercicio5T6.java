public class ejercicio5T6 {
  public static void main(String[] args) {
    int numero;
    int maximo = 100; // Inicializamos con el mínimo del rango
    int minimo = 199; // Inicializamos con el máximo del rango
    int suma = 0;
    
    System.out.println("50 números aleatorios entre 100 y 199:");

    for (int i = 1; i <= 50; i++) {
      // Generar un número entre 100 y 199. 
      // Rango = 199 - 100 + 1 = 100 números.
      // Mínimo = 100.
      numero = (int) (Math.random() * 100) + 100;

      System.out.print(numero + " ");
      
      // Acumular la suma
      suma += numero;

      // Actualizar el máximo
      if (numero > maximo) {
        maximo = numero;
      }

      // Actualizar el mínimo
      if (numero < minimo) {
        minimo = numero;
      }
      
      // Salto de línea cada 10 números
      if (i % 10 == 0) {
        System.out.println();
      }
    }

    // El cálculo de la media se hace después del bucle
    double media = (double) suma / 50; 

    System.out.println("\n--- Estadísticas ---");
    System.out.println("Máximo generado: " + maximo);
    System.out.println("Mínimo generado: " + minimo);
    System.out.printf("Media de los 50 números: %.2f\n", media);
  }
}