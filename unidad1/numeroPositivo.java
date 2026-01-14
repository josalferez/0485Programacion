import java.util.Scanner;

public class numeroPositivo {
	public static void main (String[] args){
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Introduce un numero: ");
		int numero = sc.nextInt();
		
		int resultado = numero % 2; 
		
		if (resultado == 0){
			System.out.print("El número " + numero + " es par.");
		}else{ 
			System.out.print("El número " + numero + " es impar.");
		}
		
		sc.close();
	}
}