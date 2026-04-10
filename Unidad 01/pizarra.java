/*
*
* Escribe un programa que lea un número n e imprima una pirámide de números
* con n filas como en la siguiente figura:
*       1
*      121
*     12321
*    1234321
*/
import java.util.Scanner;

public class pizarra {
	public static void main(String[] args){
		
		
		// Declaro las variables
		Scanner sc = new Scanner(System.in);
		
		System.out.print("¿Cuantas filas quieres imprimir?: ");
		int numeroFilas = sc.nextInt();

		// Logica del programa
		// 1. For que pinta las filas
		for (int i = 1; i<=numeroFilas; i++){

			// 2. Pinto espacios en blanco
			for (int j = i; j<numeroFilas; j++){
				System.out.print("*");

			}

			// 3. Pinto los numeros ascendentes
			for (int k = 1; k<=i; k++){
				System.out.print(k);
			}

			// 4. Pinto los numeros descendentes
			for (int l = i-1; l >= 1; l-- ){
				System.out.print(l);
			}


			// Salto de linea para pintar la siguiente fila
			System.out.println(" ");
		}
	}
}
