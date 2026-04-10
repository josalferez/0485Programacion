public class analizadorDatosVentas{
	 
	 // Metodo 1. Encuentro el monto de ventas más bajo
	 public static double encontrarMenorVenta(double[] ventas){
		double ventaMinima = Double.MAX_VALUE;
		
		for (int i = 0; i < ventas.length; i++){
			if (ventas[i] < ventaMinima) ventaMinima = ventas[i];
		}
		return ventaMinima;	
	 }
	 
	 // Metodo 2. Calculo la suma total
	 public static double calcularSumaTotal(double[] ventas){
		double acumulador =  0;
		for (int i = 0; i < ventas.length; i++){
			acumulador += ventas[i];
		}
		
		return acumulador;
	 }
	 
	 // Metodo 3. Cuento Ventas Bajas
	 public static int contarVentasBajas(double[] ventas, double limiteBajo){
		int contadorLimiteBajo = 0;
		 
		for (int i = 0; i < ventas.length; i++)
			if(ventas[i] < limiteBajo){contadorLimiteBajo++};
		 
		return contadorLimiteBajo;
	 }
	 
	 // Método principal
	 public static void main(String[] args) {
		double[] ventas = {150.75,45.00, 200.50, 99.99, 30.2, 120.00};
		double limiteVentaBaja = 100.00;
		
		// Llamo al método 1
		System.out.println("La venta mínima es: " + encontrarMenorVenta(ventas));
		System.out.println("La suma total de ventas es: " + calcularSumaTotal(ventas));
		System.out.println("El número de ventas por debajo del límite es: " + contarVentasBajas(ventas,limiteVentaBaja));
		
	 }
}