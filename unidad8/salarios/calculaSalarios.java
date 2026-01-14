package salarios;
import java.util.Scanner;

public class calculaSalarios{

	public static int pideHoras(){
		// Declaro las variables
		Scanner sc = new Scanner(System.in);
		
		// Logica del programa
		// Le pido al usuario el número de horas trabajadas
		System.out.print("¿Cuantas horas has trabajado?: ");
		int horas = sc.nextInt();
		
		return horas;		
	}
	
	public static int calculaSueldo(int horas){
		
		int salario;
		int extras;
		// Las horas extras se pagan a 16
		// Las horas normales a 12
		if (horas <= 40){
			salario = horas * 12;
		} else {
			extras = horas - 40;
			salario = (extras*16) + (40*12);
		}
		
		return salario;
	}
}