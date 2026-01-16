import java.util.ArrayList;

public class PruebaArrayList {
    public static void main(String[] args) {

        // Creo un arrayList de String
        ArrayList<String> diccionario = new ArrayList<>();

        diccionario.add("Lechuga");
        diccionario.add("tomate");

        for (String string : diccionario) {
            System.out.println(string);
        }

        // contains
        if (diccionario.contains("Lechuga")) {
            System.out.println("hay lechugas");
        }

        // size
        System.out.println("El tamaño del diccionario es: " + diccionario.size());

        // Borro la posición 0 e imprimo el diccionario
        diccionario.remove(0);
        for (String string : diccionario) {
            System.out.println(string);
        }

        // Limipio e imprimo
        System.out.println("El diccionario debe estar vacío. Lo imprimo a ver...");
        diccionario.clear();
        for (String string : diccionario) {
            System.out.println(string);
        }

        diccionario.remove("tomate");
    }
}