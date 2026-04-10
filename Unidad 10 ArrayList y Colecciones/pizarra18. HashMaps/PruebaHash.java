import java.util.HashMap;

public class PruebaHash {
    public static void main(String[] args) {
        // <Tipo de la Clave, Tipo del Valor>
        HashMap<String, Double> notas = new HashMap<>();
        HashMap<String, Double> diccionario = new HashMap<>();
        HashMap<String, String> diccionario2 = new HashMap<>();

        // Añadir datos
        notas.put("Pepe", 8.5);
        notas.put("Maria", 9.7);

        // Recuperar un dato sin recorrer nada
        System.out.println("La nota de Maria es: " + notas.get("Maria"));

        diccionario2.put("Carlos", "Subnormal");

        System.out.println(diccionario2.get("Carlos"));

        diccionario.put("Hola", 123.45);
        System.out.println(diccionario.get("Hola"));
        System.out.println(diccionario);

        diccionario.clear();

        HashMap<Integer, String> errores = new HashMap<>();

        errores.put(404, "Página no encontrada");
        errores.put(500, "Error interno del servidor");
        errores.put(505, "Otro error");

        int codigoBuscado = 405;

        // Compruebo que existe el error antes de imprimirlo
        if (errores.containsKey(codigoBuscado)) {
            System.out.println("Error " + errores.get(codigoBuscado));
        }else{System.out.println("Error desconocido");}

        // Borramos el error 500
        errores.remove(500);

        codigoBuscado = 500;

        // Compruebo que existe el error antes de imprimirlo
        if (errores.containsKey(codigoBuscado)) {
            System.out.println("Error " + errores.get(codigoBuscado));
        }else{System.out.println("Error desconocido");}

        // Imprimos  todos los errores
        for (Integer error : errores.keySet()) {
            System.out.println(error + errores.get(error));
        }

    }
}