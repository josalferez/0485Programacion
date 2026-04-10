public class ejercicio7{
	public static void main ( String[] args ) {
		System.out.printf("El numero %d no tiene decimales \n", 21);
		System.out.printf("El numero %f sale con decimales \n", 21.0);
		System.out.printf("El numero %.3f sale con 3 decimales \n", 21.0);
		System.out.println("--------------------------------------");
		System.out.printf("%-20s %8.2f %6d \n", "manzanas", 4.5, 10 );
		System.out.printf("%-20s %8.2f %6d \n", "peras", 2.75, 120);
	}	
}