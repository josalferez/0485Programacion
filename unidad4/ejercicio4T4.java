import java.util.Scanner;

public class ejercicio4T4 {
	public static void main (String[] args){
		
		// Declaro las variables
		Scanner sc = new Scanner(System.in);
		
		// Logica del programa
		// Le pido al usuario el número de horas trabajadas
		System.out.print("¿Cuantas horas has trabajado?: ");
		int horas = sc.nextInt();
		int salario;
		
		// Las horas extras se pagan a 16
		// Las horas normales a 12
		if (horas <= 40){
			salario = horas * 12;
		} else {
			int extras = horas - 40;
			salario = (extras*16) + (40*12);
		}

		System.out.println("Tu salario esta semana es: " + salario + " euros");
		
		// Cierro el Scanner
		sc.close();
	}
}