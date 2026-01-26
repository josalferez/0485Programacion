
import java.util.HashMap;
import java.util.Map;

public class PruebaHash {
    public static void main(String[] args) {
        // Creo un diccinario HashMap de Vehículos
        HashMap<Integer, Vehiculo> listaReparar = new HashMap<>();

        // Vamos a implementar CRUD del diccionario

        // 1. Create
        listaReparar.put(1, new Coche("2058BAA", "Toyota"));
        listaReparar.put(2, new Moto("3169CBB", "Yamaha"));
        listaReparar.put(3, new Coche("4270DCC", "Honda"));
        listaReparar.put(4, new Moto("5381EDD", "Kawasaki"));
        listaReparar.put(5, new Moto("6492FEE", "Ducati"));
        listaReparar.put(6, new Coche("7503GFF", "Volkswagen"));
        listaReparar.put(7, new Coche("8614HGG", "BMW"));
        listaReparar.put(8, new Moto("9725IHH", "Suzuki"));
        listaReparar.put(9, new Coche("0836JII", "Mercedes"));
        listaReparar.put(10, new Moto("1947KJJ", "KTM"));
        listaReparar.put(11, new Coche("2058LKK", "Renault"));

        // 2. Read
        for (Map.Entry<Integer, Vehiculo> en : listaReparar.entrySet()) {
            Integer key = en.getKey();
            Vehiculo val = en.getValue();

            val.mostrarDatos();
        }

        // ó Lambda
        listaReparar.values().forEach(v -> v.mostrarDatos());

        // 2. Muestro los datos del vehículo 5
        listaReparar.get(5).mostrarDatos();
        System.out.println(listaReparar.get(5));

        // 3. Comprobamos si existe la key 3 en el taller y devolvemos un mensaje.
        if (listaReparar.containsKey(3)) {
            System.out.println("El vehiculo existe.");
        } else {
            System.out.println("El vehículo no existe.");
        }

        // 4. Eliminamos el par key value para la key 3
        // mostramos los datos para ver que el key 3 no está
        listaReparar.remove(3);
        listaReparar.values().forEach(p -> p.mostrarDatos());

        // 5. Size, clear y mostrarDatos
        System.out.println("\nEl tamaño del diccionario es: " + listaReparar.size());
        System.out.println("Borro el diccionario");
        listaReparar.clear();
        listaReparar.values().forEach(p -> p.mostrarDatos());
        System.out.println("\nEl tamaño del diccionario es: " + listaReparar.size());

        // 6. Obtención de vistas
        // Busca en listaReparar si existe el key 10, si existe imprimes
        // el vehículo y si no dices que no existe.
        listaReparar.put(1, new Coche("2058BAA", "Toyota"));
        listaReparar.put(2, new Moto("3169CBB", "Yamaha"));
        listaReparar.put(3, new Coche("4270DCC", "Honda"));
        listaReparar.put(4, new Moto("5381EDD", "Kawasaki"));
        listaReparar.put(5, new Moto("6492FEE", "Ducati"));
        listaReparar.put(6, new Coche("7503GFF", "Volkswagen"));
        listaReparar.put(7, new Coche("8614HGG", "BMW"));
        listaReparar.put(8, new Moto("9725IHH", "Suzuki"));
        listaReparar.put(9, new Coche("0836JII", "Mercedes"));
        listaReparar.put(10, new Moto("1947KJJ", "KTM"));
        listaReparar.put(11, new Coche("2058LKK", "Renault"));

        if (listaReparar.containsKey(10)) {
            listaReparar.get(10).mostrarDatos();
        } else {
            System.out.println("No existe el vehículo");
        }

        // ó

        listaReparar.getOrDefault(100, new Vehiculo("null", "null")).mostrarDatos();

        // Le cambiamos la matrícula al vehículo 5
        if (listaReparar.containsKey(5)) {
            listaReparar.get(5).setMatricula("254abc");
        } else {
            System.out.println("El vehiculo 5 no existe en el stock");
        }

        // ó

        Vehiculo v = listaReparar.get(5);
        if (v != null) {
            v.setMatricula("0810GHV");
            System.out.println("Matrícula actualizada.");
        }
    }
}
