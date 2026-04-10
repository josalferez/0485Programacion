import java.util.Scanner;

public class capitales {
	public static void main ( String[] args){
		
		// Declaro las variables
		Scanner sc = new Scanner (System.in);
		String respuestaCorrecta = "Madrid";
		
		// ¿Pregunto por la capital de España
		System.out.print("Cuál es la capital de España: ");
		String respuesta = sc.nextLine();
		
		// Analizo la respuesta
		if ( respuesta.equals(respuestaCorrecta)){
			System.out.print("Has acertado");	
		}else{
			System.out.print("Has acertado");
		}

		// Libero el objeto escaner
		sc.close();
	}
}
