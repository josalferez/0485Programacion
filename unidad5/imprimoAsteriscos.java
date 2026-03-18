import java.util.Scanner;

public class imprimoAsteriscos{
	public static void main (String[] args){
		
        Scanner sc = new Scanner(System.in);
		
		// 1. Entrada de datos
        System.out.print("Por favor, introduce la altura:");
        int altura = Integer.parseInt(sc.nextLine());
		
		System.out.print("Por favor, introduce la anchura:");
        int anchura = Integer.parseInt(sc.nextLine());
        
		for (int i = 0; i< altura ; i++){
			for (int j = 0; j< anchura; j++){
				// System.out.print("(" + i + "," + j + ")");
				if ( i == 0 || j == 0 || i == altura - 1 
				|| j == anchura - 1){
					System.out.print("*");
				} else {
					System.out.print(" ");
				}
			}
			System.out.print("\n");
		}
		
	}
}