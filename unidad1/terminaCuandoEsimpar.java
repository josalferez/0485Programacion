import java.util.Scanner;

public class terminaCuandoEsimpar{
	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		int i = 0;
		int esPar = 0;
		
		// Esto se ejecuta mientras el número introducido
		// sea par. 
		do {
			// Leemos el número
			System.out.print("Introduce un numero por pantalla. Para terminar introduce un numero impar: ");
			i = sc.nextInt();
			
			// Comprobamos si el numero es par o impar
			esPar = i%2;
			if (esPar == 0){
				System.out.println("El numero es par");	
			} else {
				System.out.println("El numero es impar");	
			}
		} while (esPar == 0);
		
		// Libero el recurso
		sc.close();
	}	
}