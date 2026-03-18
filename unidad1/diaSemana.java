import java.util.Scanner;

public class diaSemana{
	public static void main(String[] args){
			
		Scanner sc = new Scanner(System.in);
		
		System.out.print("¿Qué dia de la semana es: ");
		String diaSemana = sc.nextLine();
		
		switch(diaSemana){
			case "lunes":
				System.out.print("Hoy es lunes");
				break;

			case "martes":
				System.out.print("Hoy es martes");
				break;

			case "sabado":
				System.out.print("Hoy es sabado");
				break;				
				
			default:
				System.out.print("Ese día de la semana no existe");			
		}
	}
}