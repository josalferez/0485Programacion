import java.util.Scanner;

public class ejercicio28T4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Turno del jugador 1
        System.out.print("Turno del jugador 1 (introduzca piedra, papel o tijera): ");
        String jugada1 = sc.nextLine().toLowerCase();

        // Turno del jugador 2
        System.out.print("Turno del jugador 2 (introduzca piedra, papel o tijera): ");
        String jugada2 = sc.nextLine().toLowerCase();

        // Validación de jugadas
        if (!(jugada1.equals("piedra") || jugada1.equals("papel") || jugada1.equals("tijera")) ||
            !(jugada2.equals("piedra") || jugada2.equals("papel") || jugada2.equals("tijera"))) {
			System.out.println("Error: jugada incorrecta.");
        } else if (jugada1.equals(jugada2)) {
            System.out.println("Empate");
        } else if (
            (jugada1.equals("piedra") && jugada2.equals("tijera")) ||
            (jugada1.equals("tijera") && jugada2.equals("papel")) ||
            (jugada1.equals("papel") && jugada2.equals("piedra"))
        ) {
            System.out.println("Gana el jugador 1");
        } else {
            System.out.println("Gana el jugador 2");
        }

        // Libero el recurso
		sc.close();
    }
}
