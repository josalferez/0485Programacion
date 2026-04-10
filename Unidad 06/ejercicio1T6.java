public class ejercicio1T6 {
  public static void main(String[] args) {
    int dado1 = 0;
    int dado2 = 0;
    int dado3 = 0;
    int sumaTotal;

    // Fórmula general para generar un entero entre Min y Max (ambos incluidos):
    // (int) (Math.random() * (Max - Min + 1) + Min)
    
    // Dado 1: Generar un número entre 1 y 6
    dado1 = (int) (Math.random() * 6) + 1;
    
    // Dado 2: Generar un número entre 1 y 6
    dado2 = (int) (Math.random() * 6) + 1;
    
    // Dado 3: Generar un número entre 1 y 6
    dado3 = (int) (Math.random() * 6) + 1;
    
    sumaTotal = dado1 + dado2 + dado3;

    System.out.println("Resultados de la tirada de dados:");
    System.out.println("Dado 1: " + dado1);
    System.out.println("Dado 2: " + dado2);
    System.out.println("Dado 3: " + dado3);
    System.out.println("--------------------");
    System.out.println("Suma total: " + sumaTotal);
  }
}