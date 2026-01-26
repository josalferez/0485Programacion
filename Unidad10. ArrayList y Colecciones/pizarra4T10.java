// Practicamos con funciones Lambda

import java.util.ArrayList;
import java.util.Collections;

public class pizarra4T10 {
    public static void main(String[] args) {
        ArrayList<String> nombres = new ArrayList<>();
        
        nombres.add("Luis");
        nombres.add("Sara");
        nombres.add("Pedro");
        nombres.add("Alejandro");

        // ¿Cómo completarías esta línea?
        nombres.removeIf( nombre -> nombre.length() == 4); // Lamnbda que elimina nombres de 4 letras
        Collections.sort(nombres); // Ordena la lista alfabéticamente

        System.out.println(nombres); // Debería quedar: [Alejandro, Pedro]
    }
}