// Importo la libreriía que me permite 
// leer valores por pantalla
import java.util.Scanner;

public class kebab{
    public static void main(String[] args) {
		// Variables tipo escaner
		Scanner sc = new Scanner(System.in);
		   
		// Le preguntamos al usuario cuanto dinero tiene
		System.out.print("¿Cuanto dinero tienes?: ");
		int euros = Integer.parseInt(sc.nextLine());
	   
	    // Hago la comprobación
		if (euros > 5) {
			System.out.println("Enhorabuena,te puedes comer un kebab");
		} else {
			System.out.println("Sigue ahorrando :(");
		}
		
		// Libero el objeto Scanner
		sc.close();
    }
}
