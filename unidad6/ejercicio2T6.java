
import java.util.Scanner;



public class ejercicio2T6 {
    public static void main(String [] args){
        
        Scanner sc = new Scanner(System.in);

        while (true) { 
            
            // Saco el palo
            int palo = (int) (Math.random() * 4) + 1;
            
            switch(palo) {
                case 1:
                    System.out.print("Oros: ");
                    break;
                
                case 2:
                    System.out.print("Copas: ");
                    break;
                
                case 3:
                    System.out.print("Bastos: ");
                    break;
                
                case 4:
                    System.out.print("Espadas: ");
                    break;
            }
            
            // Saco el numero de carta
            int valor = (int) (Math.random() * 13) + 1;
            System.out.print(valor);
            

            
            System.out.print("\n ¿Quieres Salir? (S/N)");
            String salir = sc.nextLine().toLowerCase();     

            if (salir.equals("s")){
                System.out.print("\033c");
                System.out.println("Programa Finalizado");
                break;
            }
        }        
    }
}