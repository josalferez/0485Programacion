import java.util.*;

public class generadorSecuencias{
	public static void main(String[] args){
		
		int numero = 10;
		boolean esPosi;
		int limite = 7;
		
		if (esPositivo(numero)){
			generarSecuencia(limite);
			System.out.println("La suma de temperaturas es: " + sumarSecuencia(limite));
		}
	}
	
	public static boolean esPositivo(int numero){
		return numero > 0;
	}
	
	public static void generarSecuencia(int limite){
		for (int i=1; i <= limite; i++)
			System.out.println(" " + i);
	}
	
	public static int sumarSecuencia(int limite){
		int suma=0;
		
		for (int i = 1; i<= limite; i++){
			suma += i;
		}
		
		return suma;
	}
	
}