import java.util.Scanner;

public class GestorPuntuaciones {
    public static void main(String[] args) {
        // Declaro e inicializo un array de tamaño 10 a 0
        int[] puntuaciones = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
        int opcion = 0;
        Scanner sc = new Scanner(System.in);

        // Implemento el menu do-while
        do {
            System.out.println("1. Ingresar Puntuación (1-10)");
            System.out.println("Opcion 2");
            System.out.println("Opcion 3");
            System.out.println("Opcion 4");
            System.out.println("Opcion 5");
            System.out.println("6. Salir del programa");

            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    ingresarPuntuacion(puntuaciones);
                    break;
                case 6:
                    System.out.println("Hasta luego!");
                    break;
                default:
                    break;
            }

        } while (opcion != 6);
    }
    public static void ingresarPuntuacion(int[] puntuaciones){
        
    }
}
