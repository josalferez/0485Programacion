import java.util.Scanner;

public class PruebaLibro {
    public static void main(String[] args){
        
        Scanner sc = new Scanner(System.in); // Creo un objeto de tipo Scanner que se llama sc
        Libro2 l1 = new Libro2("0125452141","El desierto de los Tártaros","Dino Buzzati",340,19.90); // Crea un objeto de tipo libro que se llama l1

        // Imprimo los valores del libro
        System.out.println(l1.getTitulo());

        //Modifico el título del objeto
        l1.setTitulo("La llanura de los Tártaros");

        // Imprimo los valores del libro
        System.out.println(l1.getTitulo());

        // Quiero saber el precio
        System.out.println(l1.getPvp());

        // Modifico el pvp
        l1.setPvp(21.05);

        // Quiero saber el precio
        System.out.println(l1.getPvp());
    }
}
