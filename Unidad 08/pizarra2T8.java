
import salarios.calculaSalarios;

public class pizarra2T8 {
	public static void main (String[] args){
		
		int uno = salarios.calculaSalarios.pideHoras();
		
		int dos = salarios.calculaSalarios.calculaSueldo(uno);

		System.out.println("Tu salario esta semana es: " + dos + " euros");
	}
}