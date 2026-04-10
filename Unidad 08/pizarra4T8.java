import java.util.Scanner;

public class pizarra4T8{
	
	public static double pedirPrecio(){
		double precio=-1;
		Scanner sc = new Scanner(System.in);
				
		while (precio < 0){
			System.out.print("Introduce el precio: ");
			precio = Double.parseDouble(sc.nextLine());
		}
		
		return precio;
	}
	
	public static double calcularDescuento(double precio){
		return precio * 0.15;
	}
	
	public static void mostrarResultado(double original, double descuento){
		double temp = original - descuento;
		System.out.println("El precio final es: " + temp);
	}
	
	public static void main(String[] args){
		
		// 1. Le pido un numero al usuario
		double precio = pedirPrecio();
		
		// 2. Calculo el descuento
		double descuento = calcularDescuento(precio);

		// 3. Muestro el resultado
		mostrarResultado(precio,descuento);

	}
}