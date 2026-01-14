import java.util.Scanner;

public class Array02 {
	public static void main(String[] args) {
	// definición del array y reserva de memoria en la misma línea
		int[] x = new int[5];
		Scanner sc = new Scanner(System.in);
		x[0] = 8;
		x[1] = 33;
		x[2] = 200;
		x[3] = 150;
		x[4] = 11;
		
		System.out.println("El array x tiene 5 elementos ¿cuál de ellos quiere ver?");
		System.out.print("Introduzca un número del 0 al 4: ");
		int indice = Integer.parseInt(sc.nextLine());
		System.out.print("El elemento que se encuentra en la posición " + indice);
		System.out.println(" es el " + x[indice]);
		
		// Le preguntamos al usuario el valor nuevo y la posicion
		// y la modificamos
		
		// Imprimo el array original
		for (int i = 0; i<5; i++){
			System.out.print(" " + x[i]);
		}	
		
		System.out.print("\n Dime un valor: ");
		int valor = Integer.parseInt(sc.nextLine());
		System.out.println("\n Dime una posicion:(0-4) ");
		int posicion = Integer.parseInt(sc.nextLine());
		
		x[posicion] = valor;
		
		System.out.print("Los valores del array después del cambio son: ");
		// Imprimo el array modificado
		for (int i = 0; i<5; i++){
			System.out.print(" " + x[i]);
		}	
		// Libero el recurso
		sc.close();
	}
}