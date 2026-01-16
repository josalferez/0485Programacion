import java.util.ArrayList;

public class PruebaArrayList {
    public static void main(String[] args) {

        // Creo un ArrayList de String
        ArrayList<String> Lista = new ArrayList<>();

        // Añado elementos a mi ArrayList
        Lista.add("Pera");
        Lista.add("Platano");
        Lista.add("Manzana");

        // Imprimimos las frutas
        for (String fruta : Lista) {
            System.out.println(fruta);
        }

        // Devolver el tamaño del array
        System.out.println("El tamaño de mi ArrayList es: " + Lista.size());

        // Borramos un elemento de mi array
        Lista.remove("Pera");

        // Imprimimos las frutas
        for (String fruta : Lista) {
            System.out.println(fruta);
        }
        // Devolver el tamaño del array
        System.out.println("El tamaño de mi ArrayList es: " + Lista.size());

        // Limpiamos el array
        Lista.clear();

        // Le metemos los productos de nuevo
        Lista.add("Pera");
        Lista.add("Platano");
        Lista.add("Manzana");

        // Quiero meter un mango en la posicion 1 del array
        Lista.set(1, "mango");
        Lista.add(1, "platano");
        System.out.println("\n Imprimo la posicion 2 del arraylist con el método get: " + Lista.get(2));

        // Imprimimos las frutas
        for (String fruta : Lista) {
            System.out.println(fruta);
        }

        // contains
        if (Lista.contains("platano")) 
            System.out.println("Hay un plátano"); 
        else 
            System.out.println("no hay plátano");

        Lista.removeIf(fruta -> fruta.equalsIgnoreCase("platano")); // Función lambda

        for (String fruta : Lista) {
            
        }
        
        // contains
        if (Lista.contains("platano")) 
            System.out.println("Hay un plátano"); 
        else 
            System.out.println("No hay plátano");
        

    }
}