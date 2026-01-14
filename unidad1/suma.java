// Importo la libreriía que me permite 
// leer valores por pantalla
import java.util.Scanner;

public class suma {
    public static void main(String[] args) {
        // Variables tipo char
       String nombre;
	   int pesetas = 166;
	   Scanner sc = new Scanner(System.in);
	   
       // Le preguntamos al usuario cuantos euros quiere 
	   // convertir en pesetas.
       String pregunta = "¿Como te llamas?: ";
	   System.out.println(pregunta);
	   nombre = sc.nextLine();
	   
	   System.out.println("Hola " + nombre);


    }
}
