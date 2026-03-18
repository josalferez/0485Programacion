import java.util.Scanner;

public class ejercicio15T4 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Pedimos el carácter
        System.out.print("Introduce el carácter para la pirámide: ");
        char c = sc.next().charAt(0);

        // Menú
        System.out.println("\nElige la orientación de la pirámide:");
        System.out.println("1. Vértice hacia arriba");
        System.out.println("2. Vértice hacia abajo");
        System.out.println("3. Vértice hacia la izquierda");
        System.out.println("4. Vértice hacia la derecha");
        System.out.print("Opción: ");
        int opcion = sc.nextInt();

        System.out.println();

        switch (opcion) {
            case 1: // hacia arriba
                System.out.println("  " + c);
                System.out.println(" " + c + c + c);
                System.out.println("" + c + c + c + c + c);
                break;
            case 2: // hacia abajo
                System.out.println("" + c + c + c + c + c);
                System.out.println(" " + c + c + c);
                System.out.println("  " + c);
                break;
            case 3: // hacia la izquierda
                System.out.println("  " + c);
                System.out.println(" " + c + c);
                System.out.println("" + c + c + c);
                System.out.println(" " + c + c);
                System.out.println("  " + c);
                break;
            case 4: // hacia la derecha
                System.out.println(c + "  ");
                System.out.println(c + "" + c + " ");
                System.out.println(c + "" + c + "" + c);
                System.out.println(c + "" + c + " ");
                System.out.println(c + "  ");
                break;
            default:
                System.out.println("Opción no válida.");
        }

        // Libero el recurso
		sc.close();
    }
}
