/*
* Escribe un programa que genere la nómina (bien desglosada) de un empleado
* según las siguientes condiciones:
* Se pregunta el cargo del empleado (1 - Prog. junior, 2 - Prog. senior, 3 - Jefe
* de proyecto), los días que ha estado de viaje visitando clientes durante el
* mes y su estado civil (1 - Soltero, 2 - Casado).
* El sueldo base según el cargo es de 950, 1200 y 1600 euros según
* si se trata de un prog. junior, un prog. senior o un jefe de proyecto
* respectivamente.
* Por cada día de viaje visitando clientes se pagan 30 euros extra en
* concepto de dietas. Al sueldo neto hay que restarle el IRPF, que será de
* un 25% en caso de estar soltero y un 20% en caso de estar casado.
*/

import java.util.Scanner;

public class ejercicio24T4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Pedir el cargo
        System.out.print("Introduce tu cargo: 1. Prog. Junior 2. Prog. Senior 3. Jefe de Proyecto: ");
        int cargo = sc.nextInt();
		System.out.print("Tu cargo es: " + cargo);

        // Pedir los días de viaje
        System.out.print("Introduce los días que has estado de viaje: ");
        int diasViaje = sc.nextInt();		
		System.out.println("Has estado viajando : " + diasViaje + " días");

/*
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
*/
        sc.close();
    }
}
