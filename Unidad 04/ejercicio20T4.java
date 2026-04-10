import java.util.Scanner;

public class ejercicio20T4 {
    public static void main(String[] args) {
        
    // Declaramos las variables
    Scanner sc = new Scanner(System.in);
    
    // Pedimos el numero de hasta 5 cifras
    System.out.print("Introduce un número entero de hasta 5 cifras: ");
    int numero = sc.nextInt();
    
    // Convertimos el Int en String
    String numStr = numero + "";

	switch (numStr.length()) { // Devolvemos el tamaño del string
		case 1:
			System.out.println("El número es capicúa.");
			break;

		case 2:
			if (numStr.charAt(0) == numStr.charAt(1)) {
				System.out.println("El número es capicúa.");
			} else {
				System.out.println("El número no es capicúa.");
			}
			break;

		case 3:
			if (numStr.charAt(0) == numStr.charAt(2)) {
				System.out.println("El número es capicúa.");
			} else {
				System.out.println("El número no es capicúa.");
			}
			break;

		case 4:
			if (numStr.charAt(0) == numStr.charAt(3) && numStr.charAt(1) == numStr.charAt(2)) {
				System.out.println("El número es capicúa.");
			} else {
				System.out.println("El número no es capicúa.");
			}
			break;

		case 5:
			if (numStr.charAt(0) == numStr.charAt(4) && numStr.charAt(1) == numStr.charAt(3)) {
				System.out.println("El número es capicúa.");
			} else {
				System.out.println("El número no es capicúa.");
			}
			break;
		}
	}
}