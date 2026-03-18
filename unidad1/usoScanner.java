

import java.util.Scanner;

public class usoScanner{
	public static void main (String[] args){
		
		Scanner sc = new Scanner(System.in);
		
		/*
		// Le pregunto el nombre
		System.out.print("¿Cómo te llamas?: ");
		String nombre = sc.nextLine();
		System.out.println("Hola " + nombre);
		
		// Le pregunto la edad
		System.out.print("¿Cuántos años tienes?: ");
		int edad = sc.nextInt();
		System.out.println(nombre + " tienes " + edad + " años.");
		
		// Le pregunto cuanto dinero tienes en el banco?
		System.out.print("¿Cuánto dinero tienes en el banco?: ");
		double dinero = sc.nextDouble();
		System.out.println(nombre + " tienes " + edad + " años y " + dinero + " en el banco" );
		
		
		// Le pregunto en que ciudad vives y cual es tu numero favorito?
		System.out.print("¿En qué ciudad vives y dime tu numero favorito?: ");
		String ciudad = sc.next();
		int numeroFavorito = sc.nextInt();
		System.out.println("Vives en " + ciudad + " y tu numero favorito es " + numeroFavorito);
		*/
		
		// ¿cuanto pesas?
		System.out.print("¿Cuánto pesas?: ");
		int peso = Integer.parseInt(sc.nextLine());
		System.out.println("Pesas " + peso + " kilos.");
		
		// Libero el recurso
		sc.close();
	}
}