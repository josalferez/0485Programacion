import java.util.Scanner;

public class esPrimo{
	public static void main (String[] args){
		
        Scanner sc = new Scanner(System.in);
		boolean esNumeroPrimo = true; // false o true
		
		// 1. Entrada de datos
        System.out.print("Por favor, introduce un numero: ");
        int numero = Integer.parseInt(sc.nextLine());
				     
		// for (int i = 2; i < numero ; i++){
		for (int i = 2; i * i <= numero; i++) {
			if (numero % i == 0){
				esNumeroPrimo = false;
				break;
			}
		}
		if (esNumeroPrimo){
			System.out.print("El numero es primo");
		} else {
			System.out.print("El numero no es primo");
		}
	}
}