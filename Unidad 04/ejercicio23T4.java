import java.util.Scanner;

public class ejercicio23T4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Pedir base imponible
        System.out.print("Introduce la base imponible (precio antes de impuestos): ");
        double base = sc.nextDouble();

        // Pedir tipo de IVA
        System.out.print("Introduce el tipo de IVA (general, reducido o superreducido): ");
        String tipoIva = sc.next().toLowerCase();

        double iva = 0;
        switch (tipoIva) {
            case "general":
                iva = 0.21;
                break;
            case "reducido":
                iva = 0.10;
                break;
            case "superreducido":
                iva = 0.04;
                break;
            default:
                System.out.println("Tipo de IVA no válido. Se aplicará 21% por defecto.");
                iva = 0.21;
        }

        double precioConIva = base * (1 + iva);

        // Pedir código promocional
        System.out.print("Introduce el código promocional (nopro, mitad, meno5, 5porc): ");
        String promo = sc.next().toLowerCase();

        double precioFinal = precioConIva;

        switch (promo) {
            case "nopro":
                // no hay descuento
                break;
            case "mitad":
                precioFinal = precioConIva / 2;
                break;
            case "meno5":
                precioFinal = precioConIva - 5;
                break;
            case "5porc":
                precioFinal = precioConIva * 0.95;
                break;
            default:
                System.out.println("Código promocional no válido. No se aplica promoción.");
        }

        // Mostrar resultados
        System.out.println("\nBase imponible: " + base + " Euros");
        System.out.println("IVA (" + (iva * 100) + "%): " + (base * iva) + " Euros");
        System.out.println("Precio con IVA: " + precioConIva + " Euros");
        System.out.println("Promoción (" + promo + "): aplicado");
        System.out.println("Precio final: " + precioFinal + " Euros");

        sc.close();
    }
}
