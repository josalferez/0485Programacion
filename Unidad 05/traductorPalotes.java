import java.util.Scanner;

public class traductorPalotes{
	public static void main(String[] args){

		long numeroOriginal = 0;
		long numeroInvertido = 0;
		int i,j;

        // Inicialización del Scanner
        Scanner sc = new Scanner(System.in);

        // --- 1. Entrada de Datos ---
        System.out.print("Por favor, introduzca un número entero positivo (long): ");
		numeroOriginal = Long.parseLong(sc.nextLine());

		// ---2. Pinto palotes
		int longitud = String.valueOf(numeroOriginal).length(); // Saca la longitud del numero
		for (i = 0; i < longitud ; i++){
			
			// --- 3. Saco el digito actual
			int ultimoDigito = (int) (numeroOriginal % 10);
			
			for (j = 0 ; j < ultimoDigito; j++ ){
				System.out.print("|");
			}
			
			// ---4. Imprimo el separador
			if (i < longitud -1){
				System.out.print(" - ");
			}
			
			numeroOriginal /= 10;
		}

	}
}