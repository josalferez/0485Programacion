public class ejercicio3T6 {
  public static void main(String[] args) {
    // 1. Generar el Palo: un número entre 0 y 3
    int paloNum = (int) (Math.random() * 4);
    String palo = "";

    switch (paloNum) {
      case 0:
        palo = "Oros";
        break;
      case 1:
        palo = "Copas";
        break;
      case 2:
        palo = "Espadas";
        break;
      case 3:
        palo = "Bastos";
        break;
    }

    // 2. Generar el Valor: un número entre 1 y 10 (donde 1 es As, 8 es Sota, 9 es Caballo y 10 es Rey)
    int valorNum = (int) (Math.random() * 10) + 1;
    String valor = "";

    switch (valorNum) {
      case 1:
        valor = "As"; 
        break;
      case 8:
        valor = "Sota"; 
        break;
      case 9:
        valor = "Caballo"; 
        break;
      case 10:
        valor = "Rey"; 
        break;
      default:
        // Para los valores numerales (2 al 7)
        valor = String.valueOf(valorNum);
    }

    System.out.println("La carta generada al azar es: " + valor + " de " + palo);
  }
}