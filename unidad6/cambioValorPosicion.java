public class cambioValorPosicion{
	public static void main(String[] args){
		String numero = "54689";
		
		int posicion = 3;
		
		System.out.println("El numero es: " + numero);
		System.out.println("El valor de la posicion 3 es: " + numero.charAt(3));
		
		char valorNuevo = '4';
		
		numero = numero.replace(numero.charAt(3), valorNuevo);
		System.out.println("El numero es: " + numero);
		
	}
}