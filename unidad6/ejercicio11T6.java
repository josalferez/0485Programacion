public class ejercicio11T6 {
  public static void main(String[] args) {
    int suspensos = 0;
    int suficientes = 0;
    int bienes = 0;
    int notables = 0;
    int sobresalientes = 0;

    System.out.println("20 Notas Generadas al Azar:");
    
    // Bucle para generar 20 notas
    for (int i = 1; i <= 20; i++) {
      // Generar un número entero entre 0 y 10 (ambos incluidos)
      int notaNum = (int) (Math.random() * 11); 
      String notaCualitativa;

      if (notaNum <= 4) {
        notaCualitativa = "Suspenso";
        suspensos++;
      } else if (notaNum == 5) {
        notaCualitativa = "Suficiente";
        suficientes++;
      } else if (notaNum == 6) {
        notaCualitativa = "Bien";
        bienes++;
      } else if (notaNum <= 8) {
        notaCualitativa = "Notable";
        notables++;
      } else { // 9 o 10
        notaCualitativa = "Sobresaliente";
        sobresalientes++;
      }

      System.out.print(notaCualitativa + " ");
      
      // Salto de línea cada 5 notas para mejor visualización
      if (i % 5 == 0) {
        System.out.println();
      }
    }

    System.out.println("\n--- Resumen de Notas ---");
    System.out.println("Suspensos: " + suspensos);
    System.out.println("Suficientes: " + suficientes);
    System.out.println("Bienes: " + bienes);
    System.out.println("Notables: " + notables);
    System.out.println("Sobresalientes: " + sobresalientes);
  }
}