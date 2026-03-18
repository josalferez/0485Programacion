import java.util.Scanner;

public class ejercicio1T5{
	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		int esMultiploDe5 = 0;
		
		// Leemos el número
		System.out.println("Imprimo los múltiplos de 5.");
		for (int i=0; i<=100; i++){
			esMultiploDe5 = i % 5;
			if (esMultiploDe5 == 0){
				System.out.println("El numero " + i + " es un múltiplo de 5");
			}
					
		}
			

		// Libero el recurso
		sc.close();
	}	
}