import java.util.Scanner;

public class ejercicio9T5{

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String entrada;
        long numero;
        int contador;

        System.out.println("Programa para contar dígitos de un número (introduce 's' para salir).");
        
        // Bucle principal: pide entrada y la procesa hasta que se detecta 's'
        while (true) {
            contador = 0; // Reiniciamos el contador
            
            System.out.print("\nIntroduce un número entero (o 's' para salir): ");
            
            // Leemos la entrada como una cadena de texto (String)
            entrada = sc.nextLine().trim(); 

            // 1. Condición de salida
            if (entrada.equalsIgnoreCase("s")) {
                break; // Salimos del bucle principal
            }
            
		   // Convertimos la cadena de texto a un long
			numero = Long.parseLong(entrada); 

			// 3. Manejar el caso especial del 0
			if (numero == 0) {
				contador = 1; 
			} 
			
			// 4. Usar un bucle para contar los dígitos
			else {
				long tempNumero = Math.abs(numero); 
				
				while (tempNumero > 0) {
					tempNumero = tempNumero / 10;
					contador++;
				}
			}

			// 5. Mostrar el resultado
			System.out.println("El número introducido es: " + numero);
			System.out.println("Tiene " + contador + " dígitos.");

        } // Fin del bucle while (true)

        // Mensaje de despedida
        System.out.println("\n Programa finalizado. ¡Hasta luego!");
        sc.close();
    }
}