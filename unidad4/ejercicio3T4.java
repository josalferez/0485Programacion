import java.util.Scanner;

public class ejercicio3T4 {
	public static void main (String[] args){
		
		// Declaro las variables
		Scanner sc = new Scanner(System.in);
		
		// Logica del programa
		// Le pido al usuario un número entre 1 y 7
		System.out.print("¿Me das un número entre 1 y 7?");
		int numero = sc.nextInt();
		
		// Comprobamos que el número está entre 1 y 7
		if (numero < 1 || numero > 7){
			System.out.println("El número debe estar entre 1 y 7");
		} else {
			switch(numero){
				case 1: 
					System.out.println("Hoy es lunes");
					break;
				case 2: 
					System.out.println("Hoy es martes");
					break;
				case 3: 
					System.out.println("Hoy es miércoles");
					break;
				case 4: 
					System.out.println("Hoy es jueves");
					break;
				case 5: 
					System.out.println("Hoy es viernes y el cuerpo lo sabe.");
					break;
				case 6: 
					System.out.println("Hoy es sabado y el cuerpo lo sabe");
					break;
				case 7: 
					System.out.println("Hoy es domingo, mamita me quiero morir");
					break;
				default: 
					System.out.println("Debes introducir un numero entre 1 y 7");
			}
		}
	}
}