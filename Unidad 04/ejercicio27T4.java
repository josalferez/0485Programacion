import java.util.Scanner;

public class ejercicio27T4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
		double precio = 0; // Precio de la tarta
		String nombrePedido = ""; // Nombre del pedido para poner en la tarta

		// Sabor de la tarta
		System.out.print("¿De qué sabor quieres la tarta?: ");
		String sabor = sc.nextLine().toLowerCase().trim();
		
		// Calculo el precio de la tarta
		switch(sabor){
			case "fresa":
				precio = 16;
				break;
				
			case "manzana":
				precio = 18;
				break;
				
			case "chocolate":
				System.out.print("¿Blanco o negro?: (b/n)");
				char chocolate = sc.next().charAt(0);
				if (chocolate == 'b'){
					precio = 15;
				} else {
					precio = 14;
				}	
			default:	
		}
		
		// Le pregunto si quiere nata
		System.out.print("¿Quieres nata?: (s/n)");
		char chocolate = sc.next().charAt(0);
		if (chocolate == 's'){
			precio = precio + 2.5 ;
		} 	
		
		// Le pregunto si quiere añadirle un nombre
		System.out.print("¿Quieres añadirle un nombre?: (s/n)");
		String nombre = sc.nextLine();
		if (nombre.equals("s")){
			precio = precio + 2.75 ;
			System.out.print("¿Cuál es tu nombre?: ");
			nombrePedido = sc.nextLine();
		} 

        // salida
        System.out.println("** Resumen de la compra **");
		System.out.println(" Hola " + nombrePedido);
		System.out.println("Sabor: " + sabor);
		System.out.println("Precio: " + precio);
        

        // Liberamos el recurso
		sc.close();
    }
}
