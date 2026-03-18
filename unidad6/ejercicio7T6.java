public class ejercicio7T6 {
  public static void main(String[] args) {
    System.out.println("      APUESTA 1  APUESTA 2  APUESTA 3");
    System.out.println("-------------------------------------");

    // Bucle para los 14 partidos
    for (int i = 1; i <= 14; i++) {
      System.out.printf("P%02d: ", i); // Etiqueta del partido (P01, P02...)
      
      // Generar y mostrar 3 resultados aleatorios (1, X, 2)
      for (int apuesta = 1; apuesta <= 3; apuesta++) {
        // Generar un número entre 1 y 3 (ambos incluidos)
        int resultadoNum = (int) (Math.random() * 3) + 1;
        String resultado;

        switch (resultadoNum) {
          case 1:
            resultado = "1";
            break;
          case 2:
            resultado = "X";
            break;
          case 3:
            resultado = "2";
            break;
          default:
            resultado = "?"; // No debería ocurrir
        }
        
        System.out.printf("    %s     |", resultado);
      }
      System.out.println(); // Saltamos a la siguiente apuesta
    }

    // Pleno al 15 (fila 15)
    System.out.println("-------------------------------------");
    System.out.print("P15: ");
    
    // El pleno al 15 se suele mostrar como M0, M1, M2, donde M0 es 0 goles, M1 es 1 gol, etc.
    // Usaremos un rango de 0 a 3 (0, 1, 2, M) para cada equipo, que se genera dos veces.
    
    for (int apuesta = 1; apuesta <= 3; apuesta++) {
        int golesLocalNum = (int) (Math.random() * 4); // 0, 1, 2, 3
        int golesVisitanteNum = (int) (Math.random() * 4); // 0, 1, 2, 3
        
        String golesLocal;
		if (golesLocalNum == 3) {
			golesLocal = "M"; 
		} else {
			golesLocal = String.valueOf(golesLocalNum); // Así convierto el int a String
		}
        
		String golesVisitante;
		if (golesVisitanteNum == 3) {
			golesVisitante = "M";
		} else {
			golesVisitante = String.valueOf(golesVisitanteNum); // Así convierto el int a String
		}

        System.out.printf("   %s-%s   |", golesLocal, golesVisitante);
    }
    System.out.println();
  }
}