package validacion;

public class metodosValidacion{
	
	public static boolean esPositivo(int number){
		return (number > 0);
	}
	
	public static boolean esNumeroPar(int number){
		/*if (number%2 == 0)
			return true;
		else
			return false;*/
		return (number%2 == 0) ? true : false;
	}
}