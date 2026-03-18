
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class notas {

    public static void main(String[] args) {

        Map<String, Integer> libreta = new HashMap<>();
        boolean bandera = true;

        libreta.put("Ana", 10);
        libreta.put("Pedro", 10);
        libreta.put("Luis", 10);

        int notaAlumno = libreta.get("Pedro");

        System.out.println("La nota de Pedro es: " + notaAlumno);

        if (libreta.containsKey("Luis")) {
            System.out.println("La nota de Luis es: " + libreta.get("Luis"));
        } else {
            System.out.println("Luís no está en la agenda");
        }

        // Vamos a pedirle al usuario Alumnos y notas
        Scanner sc = new Scanner(System.in);
        while (bandera) {
            System.out.println("Introduce el nombre del proximo alumno: (o 's' para salir)");
            String nombre = sc.nextLine();
            if (!nombre.equals("s")) {
                System.out.println("Introduce la nota: ");
                int nota = sc.nextInt();
                libreta.put(nombre, nota);
                sc.nextLine();

            } else {
                bandera = false;
                System.out.println("Hasta luego Mari Carmens");
            }
        }

        // Imprimos los usuarios del HashMap
        for (Map.Entry<String, Integer> entrada : libreta.entrySet()) {
            System.out.println("Nombre: " + entrada.getKey() + " Nota: " + entrada.getValue());
        }

        // Vamos a borrar a alguno
        System.out.println("¿Quieres borrar a alguno (s/n): ");
        String respuesta = sc.nextLine();

        if (respuesta.equals("s")) {
            System.out.println("Dime el nombre: ");
            respuesta = sc.nextLine();
            libreta.remove(respuesta);
        }

        // Imprimos los usuarios del HashMap sin el borrado
        for (Map.Entry<String, Integer> entrada : libreta.entrySet()) {
            System.out.println("Nombre: " + entrada.getKey() + " Nota: " + entrada.getValue());
        }

        sc.close();
    }
}
