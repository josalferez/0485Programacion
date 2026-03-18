import java.util.Scanner;

public class generaClaveAleatoria{
	public static void main(String[] args){
		 char[] simbolos = {'A','B','C','D','E','F','G','H','1','2','3','4','5','6','7','8','9'};
		 Scanner sc = new Scanner(System.in);
		 
		 System.out.print("Introduce el tamaño de la clave: ");
		 int tamanio = sc.nextInt();
		 
		 char[] contrasenia = new char[tamanio];
		 
		 for(int i = 0; i<tamanio; i++){
			 contrasenia[i] = simbolos[(int)(Math.random()*17)];
		 }
		 
		 System.out.print("La contraseña es: ");
		 for (char j: contrasenia){
			 System.out.print(j);
		 }
	}
}