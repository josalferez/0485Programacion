
import java.util.Scanner;

public class factura {
    public static void main (String[] args) {
        
        // Declaro las variables
        double baseImponible = 0;
        double iva=0;
        double total = 0;
        Scanner sc = new Scanner(System.in);
        boolean bandera = false;

        System.out.print("Dime la base imponible de la factura: ");
        baseImponible = sc.nextDouble();

        // Calculo el iva y el total
        iva = (baseImponible * 0.21);
        total =  iva + baseImponible;

        // Lo imprimo por pantalla
        System.out.printf("El total de la factura es: %.2f", total);
        bandera = true;
        
        if (!bandera) { // Si bandera no ha cambiado de valor desde que se declaró
            System.out.print("\n La bandera no se ha cambiado");
        }

        // Cierro el objeto Scanner. 
        sc.close();
    }
}