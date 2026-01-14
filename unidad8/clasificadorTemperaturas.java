import java.util.*;

public class clasificadorTemperaturas{
	public static void main(String[] args){
		
		double celsius = 25.5;
		double temperatura;
		boolean estadoCongelacion;
		
		temperatura = convertirFarenheit(celsius);
		estadoCongelacion = esPuntoCongelacion(celsius);
		
		System.out.println("La temperatura en Farenheit es: " + temperatura);
		System.out.println("El estado de congelación es: " + estadoCongelacion);
		System.out.println("La clasificación del clima es: " + clasificarClima(celsius));
	}
	
	public static double convertirFarenheit(double celsius){
		return (celsius * 9.0 / 5) + 32;
	}
	
	public static boolean esPuntoCongelacion(double celsius){
		return (celsius <= 0) ? true : false;
	}
	
	public static String clasificarClima(double celsius){
		if(celsius >= 25){
			return "Caluroso";
		} else if (celsius >= 10 && celsius <= 24.9){
			return "Templado";
		} else{
			return "Frío";
		}
	}
}