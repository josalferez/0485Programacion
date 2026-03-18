// Nombre de fichero: nombre_apellido.java
import java.util.Scanner;

public class ejercicioExamen_2_T4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 1) Tipo de transporte
        System.out.print("Elige transporte: bus, tren, avion, barco: ");
        String transporte = sc.nextLine().toLowerCase();

        double precioBase;
        switch (transporte) {
            case "bus":   precioBase = 5.0;   break;
            case "tren":  precioBase = 15.0;  break;
            case "avion": precioBase = 100.0; break;
            case "barco": precioBase = 50.0;  break;
            default:
                System.out.println("Error: transporte no válido.");
                sc.close();
                return; // El programa finaliza. ¡Explicar esto!
        }

        // 2) Edad y estudiante
        System.out.print("Introduce tu edad: ");
        int edad = Integer.parseInt(sc.nextLine()); 
        System.out.print("¿Tienes carnet de estudiante? (si/no): ");
        String esEstudiante = sc.nextLine().toLowerCase();

        // 3) Descuentos (aplicar solo el mayor)
        double descuentoMayor = 0.0;

        if (edad < 5) {
            descuentoMayor = 1.0; // gratis
        } else {
            if (edad < 12 && descuentoMayor < 0.50) {
                descuentoMayor = 0.50;
            }
            if (edad >= 18 && edad <= 25 && descuentoMayor < 0.10) {
                descuentoMayor = 0.10;
            }
            if (edad >= 65 && descuentoMayor < 0.30) {
                descuentoMayor = 0.30;
            }
            if (esEstudiante.equals("si") && descuentoMayor < 0.20) {
                descuentoMayor = 0.20;
            }
        }

        double precioTrasDescuento = precioBase * (1 - descuentoMayor);
        if (descuentoMayor == 1.0) { // gratis
            precioTrasDescuento = 0.0;
        }

        // 4) Código promocional
        System.out.print("Introduce código promocional (NOPRO/MITAD/MENOS5/PORC5): ");
        String promo = sc.nextLine().toUpperCase();

        double precioFinal = precioTrasDescuento;
        switch (promo) {
            case "NOPRO":
                break;
            case "MITAD":
                precioFinal = precioFinal * 0.5;
                break;
            case "MENOS5":
                precioFinal = precioFinal - 5.0;
                if (precioFinal < 0) {
                    precioFinal = 0.0;
                }
                break;
            case "PORC5":
                precioFinal = precioFinal * 0.95;
                break;
            default:
                System.out.println("Código no válido: se aplica NOPRO.");
        }

        // 5) Recibo
        System.out.println("\n--- RECIBO ---");
        System.out.println("Transporte: " + transporte);
        System.out.println("Edad: " + edad);
        System.out.println("Estudiante: " + (esEstudiante.equals("si") ? "Si" : "No"));
        System.out.printf("Precio base: %.2f Euros%n", precioBase);
        System.out.printf("Precio final: %.2f Euros%n", precioFinal);

        sc.close();
    }
}
