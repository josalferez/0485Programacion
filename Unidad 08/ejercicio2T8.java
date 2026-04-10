import java.util.Scanner;

public class ejercicio2T8{

    private static boolean esPrimo(int numero){
		
		boolean esPrimo = true;
		
		if (numero <= 1 )
			esPrimo = false;
		else{
			for (int i=2; i*i <= numero; i++){
				if (numero % i == 0){
					esPrimo = false;
				}
			}
		}
		return esPrimo;
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		System.out.print("Introduce un numero: ");
		int numero = Integer.parseInt(sc.nextLine());
		
		if(esPrimo(numero)){
			System.out.printf("El numero %d es primo", numero);
		}else{
			System.out.printf("El numero %d no es primo", numero);
		}
		sc.close();
    }
}