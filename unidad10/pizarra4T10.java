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
        nombres.removeIf( nombre -> nombre.length() == 4);
        Collections.sort(nombres);

        System.out.println(nombres); // Debería quedar: [Alejandro, Pedro]
    }
}