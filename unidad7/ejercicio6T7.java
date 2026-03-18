import java.util.Scanner;

public class ejercicio6T7{
	public static void main(String[] args){
		int[] numeros = new int[5];
		int[] numerosRotados = new int[5];
		
		// Relleno el array y lo imprimo
		for(int i = 0; i< numeros.length; i++){
			numeros[i] = (int)(Math.random()*101);
		}
	
		// Relleno numerosRotados de la posicion 2 hasta el final 
		for (int i=0;i<numeros.length-1;i++){
			numerosRotados[i+1] = numeros[i];
		}
		
		// Añado la posición inicial de numerosRotados
		numerosRotados[0] = numeros[numeros.length-1];
		
		// Imprimo los dos arrays. El original y el rotado.
		System.out.print("Array original:  ");
		for (int i=0; i<numeros.length; i++){
			System.out.print(numeros[i] + " ");
		}
		
		System.out.println(" "); // Salto de línea
		
		System.out.print("Array rotado:  ");
		for (int i=0; i<numeros.length; i++){
			System.out.print(numerosRotados[i] + " ");
		}
		
	}
}