import java.util.Scanner;

public class ejercicio5T7{
	public static void main(String[] args){
		int[] numeros = new int[10];
		
		// Relleno el array y lo imprimo
		for(int i = 0; i< numeros.length; i++){
			numeros[i] = (int)(Math.random()*101);
			System.out.print(numeros[i] + " ");
		}
		System.out.println(" ");
		
		// Creo las variables maximo y minimo
		int maximo = numeros[0];
		int minimo = numeros[0];
		
		// leo el array para calcular cuál es el máximo y el mínimo
		for(int n : numeros){
			if (n > maximo){
				maximo = n;
			}
			if (n < minimo){
				minimo = n;
			}
		}		
		System.out.println("El maximo es: "+ maximo);
		System.out.println("El minimo es: "+ minimo);
		
		// Muestro el array resaltando los extremos 
        System.out.println("--- Array con máximo y mínimo resaltados ---");
        for (int n : numeros) {
            System.out.print(n);
            
            // Añadir las palabras "máximo" y "mínimo" al lado del número
            if (n == maximo) {
                System.out.print(" (máximo)");
            } else if (n == minimo) {
                System.out.print(" (mínimo)");
            }
            System.out.print(" | ");
        }
        System.out.println();	
	}
}