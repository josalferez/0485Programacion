import java.util.Scanner;
import validacion.metodosValidacion;

public class pizarra1T8 {
	public static void main (String[] args){
		Scanner sc = new Scanner(System.in);
		
		int numero = -1; // Lo inicio en negativo para que entre en el while
		
		while(!validacion.metodosValidacion.esPositivo(numero)){
			System.out.print("Introduce un número: ");
			numero = sc.nextInt();
		}
		
		if (validacion.metodosValidacion.esNumeroPar(numero))
			System.out.println("El numero es par");
		else
			System.out.println("El numero es impar");
	}
}