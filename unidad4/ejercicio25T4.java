import java.util.Scanner;

public class ejercicio25T4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Pedir la altura
        System.out.print("Introduzca la altura de la bandera en cm: ");
        int altura = sc.nextInt();
		
		// Pedir la anchura
        System.out.print("Introduzca la anchura de la bandera en cm: ");
        int anchura = sc.nextInt();
		
        // Pedir si quiere escudo bordado
        System.out.print("¿Quieres escudo bordado?: (s/n) ");
        char escudoBordado = sc.next().charAt(0);		
		
		// Imprimo el final
		double tamanioBandera = altura * anchura;
		double precioBandera = (altura * anchura)/100;
		double escudo = 0;
		
		System.out.println("");
		System.out.println("Gracias, aquí tiene el desglose de su compra");
		System.out.println("- Bandera de " + tamanioBandera + " cm2: " + precioBandera + " euros");
		if (escudoBordado == 's'){
			System.out.println("- Escudo: 2'50 euros");
			escudo = 2.5;
		}else{
			System.out.println("- Escudo: 0 euros");
			escudo = 0;
		}
		System.out.println("- Gastos de envío: 3'25 euros");
		double totalPedido = precioBandera + escudo + 3.25; 
		
		System.out.println(" ** Total: " + totalPedido + " **");
        
		
		sc.close();
    }
}
