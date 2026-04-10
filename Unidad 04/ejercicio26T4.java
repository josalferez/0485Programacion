import java.util.Scanner;

public class ejercicio26T4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // precios base
        final int PRECIO_NORMAL = 8;
        final int PRECIO_MIERCOLES = 5;
        final int PRECIO_PAREJA = 11;

        // datos de entrada
        System.out.print("¿Cuántas entradas quieres?: ");
        int entradas = Integer.parseInt(sc.nextLine());

        System.out.print("¿Qué día de la semana es?: ");
        String dia = sc.nextLine().toLowerCase().trim();

        // calcular precio total
        int total = 0;

        switch(dia) {
            case "miercoles":
                total = entradas * PRECIO_MIERCOLES;
                break;

            case "jueves":
                int parejas = entradas / 2;
                int sueltas = entradas % 2;
                total = parejas * PRECIO_PAREJA + sueltas * PRECIO_NORMAL;
                break;

            default:
                total = entradas * PRECIO_NORMAL;
        }

        // descuento por tarjeta
        System.out.print("¿Tienes la tarjeta CineCampa? (s/n): ");
        char tarjeta = sc.next().toLowerCase().charAt(0);

        // aplica 10% de descuento
		if (tarjeta == 's') {
            total = total - (total / 10);
        }

        // salida
        System.out.println("\nResumen de la compra:");
        System.out.println("Entradas: " + entradas);
        System.out.println("Día: " + dia);
        System.out.println("Total a pagar: " + total + " euros");

        // Liberamos el recurso
		sc.close();
    }
}
