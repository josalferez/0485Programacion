import java.util.Scanner;

public class menuSwitch{
	public static void main(String[] args){
		
		// Declaracion de variables
		int base, altura, lado;
		
		System.out.println(" CÁLCULO DE ÁREAS");
		System.out.println(" ----------------");
		System.out.println(" 1. Cuadrado");
		System.out.println(" 2. Rectángulo");
		System.out.println(" 3. Triángulo");
		System.out.print("\n Elija una opción (1-3): ");
		
		Scanner sc = new Scanner(System.in);
		int respuesta = sc.nextInt();
		
		switch(respuesta){
			case 1:
				System.out.print("Introduce el valor del lado: ");
				lado = sc.nextInt();
				System.out.print("El área del cuadrado es " + (lado*lado));
				break;			
			case 2:
				System.out.print("Introduce la base y la altura: ");
				base = sc.nextInt();
				altura = sc.nextInt();
				System.out.print("El área del rectángulo es " + (base*altura));
				break;	
			case 3:
				System.out.print("Introduce la base y la altura: ");
				base = sc.nextInt();
				altura = sc.nextInt();				
				System.out.print("El área del triángulo es " + ((base*altura)/2));
				break;	
			default:
				System.out.print("Esa opción no existe");
		}
	}
}
