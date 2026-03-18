import java.util.Scanner;

public class examen2 {
	public static void main(String[] args){

		// Inicializo un objeto escaner y variables
		Scanner sc = new Scanner(System.in);
		int precioBase = 0;

		while (true){
			System.out.print("\n ¿Qué tipo de entrada? adulto, ninio, senior, familiar?: ");
			String tipoEntrada = sc.nextLine().toLowerCase();

			// 1. Asigno el precio base
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
					precioBase = 0;
			}

			// 2. Pedimos los datos adicionales.
			// Edad
			System.out.print("\n ¿Qué edad tienes?: ");
			int edad = Integer.parseInt(sc.nextLine());

			// Tarjeta de socio
			System.out.print("\n ¿Tienes tarjeta de socio? (si/no): ");
			String tarjetaSocio = sc.nextLine().toLowerCase();

			// Codigo Promocional
			System.out.print("\n Introduce un codigo promocional - (ninguno, 10%, 20%, 50%): ");
			String codigoPromocional = sc.nextLine().toLowerCase();

			// 3. Descuento por edad o socio
			// Si es socio
			double porcentajeDescuento = 0.0;
			if (edad < 6){
				porcentajeDescuento = 0.6;
			} else if (edad >= 6 && edad <= 18 && tarjetaSocio.equals("si")){
				porcentajeDescuento = 0.2;
			} else if (edad >= 6 && edad <= 18 && tarjetaSocio.equals("no")){
				porcentajeDescuento = 0.15;
			} else if (edad >= 60){
				porcentajeDescuento = 0.25;
			} else if (tarjetaSocio.equals("si")){
				porcentajeDescuento = 0.2;
			}

			// 4. Comprobamos el codigo Promocional y lo aplicamos
			double descuentoAdicional = 0.0;
			switch(codigoPromocional){
				case "10%":
						descuentoAdicional = 0.1;
					break;
				case "20%":
						descuentoAdicional = 0.2;
					break;
				case "50%":
						descuentoAdicional = 0.5;
					break;
			}

			// 5. Calculo los resultados
			double precioDescuentoEdadSocio = precioBase * (1 -  porcentajeDescuento);
			double precioFinal = precioDescuentoEdadSocio * (1 - descuentoAdicional);

			// 6. Imprimo los resultados
			System.out.println(" ");
			System.out.println(" ***********************************************");
			System.out.println(" *************  RESULTADOS  ********************");
			System.out.println(" ***********************************************");
			System.out.println("\n Precio base: " + precioBase);
			System.out.println("\n Precio descuento Edad / Socio: " + precioDescuentoEdadSocio);
			System.out.println("\n Precio Final: " + precioFinal);

			// 7. Le pregunto si quiere salir
			System.out.print("\n ¿Quieres salir?: (si/no) ");
			String salir = sc.nextLine().toLowerCase();
			if (salir.equals("si")){
				break;
			}
			
			// 8. Limpio la pantalla antes de preguntar de nuevo
			System.out.print("\033c");
		
		} // Fin del while. El usuario pulsó que quiere salir
		
		// 9. Libero el Scanner
		sc.close();
	}
}