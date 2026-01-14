import java.util.Scanner;

public class pizarra3T8{
	
	public static void esPar(int number){
		if (number % 2 == 0)
			System.out.println("El número es par");
		else
			System.out.println("El número es impar");
	}
	
	public static int pidoNumero(){
		// Le pido un número
		Scanner sc = new Scanner(System.in);
		int numero;
		
		System.out.print("Introduce un numero: ");
		numero = Integer.parseInt(sc.nextLine());
		
		return numero;
	}
	
	public static boolean esPositivo(int uno){
		return (uno > 0) ? true : false;
		
/*		if (uno <= 0)
			return false;
		else	
			return true;*/
	}
	
	public static void main(String[] args){
		// Vamos a calcular si un número es par o impar
		int numero;
		
		// 1. Le pido un numero al usuario
		numero = pidoNumero();
		
		// 2. Comprubo si es positivo
	
		if (esPositivo(numero)){
			// 3. Calculo si es par
			esPar(numero);
		} else {
			System.out.println("El numero es negativo");
		}
		
		

	}
}