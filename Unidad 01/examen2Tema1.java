import java.util.Scanner;

public class examen2Tema1 {
	
	public static void main(String [] args){
		
		// Declaro el objeto Scanner
		Scanner sc = new Scanner(System.in);
		double precioBase = 0.0;
		double descuentoEdad = 0.0;
		
		while (true){
			// 1. Le pedimos al usuario el tipo de entrada
			System.out.print("Tipo de entrada. adulto, ninio,senior, familiar: ");
			String tipoEntrada = sc.nextLine().toLowerCase();
			
			// 2. Asignamos el precioBase de la entrada
			switch(tipoEntrada){
				case "adulto":
					precioBase = 20;
					break;
				case "ninio":
					precioBase = 10;
					break;
				case "senior":
					precioBase = 15;
					break;
				case "familiar":
					precioBase = 50;
					break;
				default:
					System.out.print("Tipo de entrada erróneo.");
					precioBase = 0;
			}	
			
			// 3. Pedimos edad, esSocio y codigoPromocional 
			System.out.print("¿Cuantos años tienes?: ");
			int edad = Integer.parseInt(sc.nextLine().toLowerCase());
			
			System.out.print("¿Eres Socio? (si/no): ");
			String esSocio = sc.nextLine().toLowerCase();
			
			System.out.print("Introduce el codigo promocional (ninguno, 10%, 20% y 50%): ");
			String codigoPromo = sc.nextLine().toLowerCase();

			// 4. Vamos a aplicar el descuento por edad o socio
			if (edad < 6){
				descuentoEdad = 0.6; // Si es menor de 6 años le aplico un descuento del 60%
			} else if(edad >= 6 && edad <= 18 && esSocio.equals("si")){
				descuentoEdad = 0.2;
			} else if(edad >= 6 && edad <= 18){
				descuentoEdad = 0.15;
			} else if(edad >= 60){
				descuentoEdad = 0.25;
			} else if(esSocio.equals("si")){
				descuentoEdad = 0.20;
			} 
			
			// 5. Código promocional a aplicar
			double codigoPromocional = 0.0;
			switch(codigoPromo){
				case "10%":
					codigoPromocional = 0.1;
					break;
				case "20%":
					codigoPromocional = 0.2;
					break;
				case "50%":
					codigoPromocional = 0.5;
					break;
			}
			
			// 6. Calculo los valores
			//                                     100   *  1 - 0.6
			double precioDescuentoEdadSocio = precioBase * (1 - descuentoEdad);
			//                                      40                *  1 -    0.5 
			double precioCodigoPromocional = precioDescuentoEdadSocio * (1 - codigoPromocional);
		
			// 7. Imprimo los precios por pantalla
			System.out.println(" ");
			System.out.println(" ***********************************************");
			System.out.println(" *************  RESULTADOS  ********************");
			System.out.println(" ***********************************************");
			System.out.println(" El precio base es: " + precioBase);
			System.out.println(" El precio despues descuento edad/socio: " + precioDescuentoEdadSocio);
			System.out.println(" El precio tras aplicar el codigo promocional es: " + precioCodigoPromocional);
			
			// 8. Le pregunto si quiere salir
			System.out.print("\n¿Quieres salir del programa? (si/no): ");
			String quiereSalir = sc.nextLine().toLowerCase();
			
			if (quiereSalir.equals("si")){
				return; // Salgo del while y termino el programa
			}
			
			// 9. Limpio la pantalla antes de preguntar de nuevo
			System.out.print("\033c");
		}
	}
}