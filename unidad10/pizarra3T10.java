// Practicamos con funciones Lambda

import java.util.ArrayList;

public class pizarra3T10 {
    public static void main(String[] args) {
        ArrayList<Integer> notas = new ArrayList<>();
        notas.add(8);
        notas.add(3);
        notas.add(10);
        notas.add(4);
        notas.add(6);

        // Queremos borrar si la nota es menor a 5
        notas.removeIf(n -> n < 5); 

        System.out.println(notas); // Debería imprimir [8, 10, 6]
    }
}