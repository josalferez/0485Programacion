import java.util.Scanner;

public class ejercicioExamenT4 {
    public static void main(String[] args) {
        
        // Inicialización de Scanner y variables
        Scanner sc = new Scanner(System.in);
        double precioBase = 0.0;
        double porcentajeDescuentoEdadEstudiante = 0.0;

        // 1. Tipo de transporte
        System.out.println("--- 1. TIPO DE TRANSPORTE ---");
        System.out.print("Introduzca el tipo de transporte (bus, tren, avión o barco): ");
        String transporte = sc.nextLine().toLowerCase();

        // Uso de switch para asignar el precio base (Rúbrica 3)
        switch (transporte) {
            case "bus":
                precioBase = 5.0;
                break;
            case "tren":
                precioBase = 15.0;
                break;
            case "avion":
                precioBase = 100.0;
                break;
            case "barco":
                precioBase = 50.0;
                break;
            default:
				// Explicar el return para finalizar el programa.
                System.out.println("ERROR: Transporte no válido. Precio base asignado: 0 Euros.");
                precioBase = 0.0;
        }

        // Si el precio base es 0, podemos terminar la ejecución aquí o continuar.
        // Asumiremos que se continúa con el precioBase=0 para aplicar los descuentos.

        // 2. Datos adicionales (Rúbrica 2)
        System.out.println("\n--- 2. DATOS ADICIONALES ---");
        System.out.print("Introduzca su edad (número entero): ");
        int edad = sc.nextInt();
        sc.nextLine(); // Limpiar el buffer después de nextInt()
        System.out.print("¿Tiene carnet de estudiante? (si/no): ");
        String carnetEstudiante = sc.nextLine().toLowerCase();
        System.out.print("Introduzca un código promocional (nopro, 5%, 25%, 50%): ");
        String codigoPromocional = sc.nextLine().toLowerCase();
        
        // 3. Descuentos por edad o estudiante (if-else if para el mayor posible)
        // Se ordena de mayor a menor descuento para asegurar que se escoge el mayor posible. (Rúbrica 4)
        if (edad < 12) { // 50%
            porcentajeDescuentoEdadEstudiante = 0.50;
        } else if (edad >= 65) { // 30%
            porcentajeDescuentoEdadEstudiante = 0.30;
        } else if (carnetEstudiante.equals("si")) { // 20%
            porcentajeDescuentoEdadEstudiante = 0.20;
        } else if (edad >= 12 && edad <= 25) { // 10% (Uso de &&, Rúbrica 5)
            porcentajeDescuentoEdadEstudiante = 0.10;
        }
        
        double precioConDescuentoEdadEstudiante = precioBase * (1.0 - porcentajeDescuentoEdadEstudiante);
        
        // 4. Códigos promocionales (Descuento adicional) (Rúbrica 6)
        double porcentajeDescuentoPromo = 0.0;
        
        switch (codigoPromocional) {
            case "5%":
                porcentajeDescuentoPromo = 0.05;
                break;
            case "25%":
                porcentajeDescuentoPromo = 0.25;
                break;
            case "50%":
                porcentajeDescuentoPromo = 0.50;
                break;
            case "nopro":
            default:
                // Si es "nopro" o cualquier otro código no válido, el descuento es 0
                porcentajeDescuentoPromo = 0.0; 
        }

        double precioFinal = precioConDescuentoEdadEstudiante * (1.0 - porcentajeDescuentoPromo);

        // 5. Salida del programa (Rúbrica 7)
        System.out.println("\n--- 5. RESUMEN DEL BILLETE ---");
        System.out.printf("Tipo de transporte: %s\n", transporte);
        System.out.printf("Precio base: %.2f €\n", precioBase);
        System.out.printf("Descuento (Edad/Estudiante): %.0f%%\n", porcentajeDescuentoEdadEstudiante * 100);
        System.out.printf("Precio después de descuentos por edad/estudiante: %.2f Euros\n", precioConDescuentoEdadEstudiante);
        System.out.printf("Descuento (Código Promocional): %.0f%%\n", porcentajeDescuentoPromo * 100);
        System.out.printf("Precio FINAL a pagar: %.2f Euros\n", precioFinal);
        System.out.println("------------------------------------");

        // Libero el recurso
		sc.close();
    }
}