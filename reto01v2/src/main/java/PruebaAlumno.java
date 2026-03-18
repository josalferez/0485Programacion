import java.util.List;
import java.util.Scanner;

public class PruebaAlumno {

    static Scanner sc = new Scanner(System.in);
    static AlumnoDAO dao = new AlumnoDAOImpl();

    public static void main(String[] args) {
        Menu();
    }

    public static void Menu() {

        int opcion = -1;

        while (opcion != 0) {
            System.out.println("------------ MENU -------------");
            System.out.println("1. Insertar alumno");
            System.out.println("2. Informe de matriculados");
            System.out.println("0. Salir");
            System.out.print("Pulse una opcion para continuar: ");
            opcion = Integer.parseInt(sc.nextLine());

            switch (opcion) {
                case 1:
                    insertarAlumno();
                    break;

                case 2:
                    listarAlumnos();
                    break;

                case 3:
                    buscadorInteligente();
                    break;

                default:
                    break;
            }
        }
        sc.close(); // Aquí se cierra el Scanner.
    }

    public static void insertarAlumno() {
        System.out.print("Introduce el nombre del alumno: ");
        String nombre = sc.nextLine();
        int edad = -1;
        boolean edadValida = false;

        while (!edadValida) {
            try {
                System.out.print("Introduce la edad del alumno: ");
                edad = Integer.parseInt(sc.nextLine());
                if (edad > 0 && edad < 120) {
                    edadValida = true;
                } else {
                    System.out.println("Error: Por favor, introduce una edad real (1-119).");
                }
            } catch (Exception e) {
                // TODO: handle exception
                System.out.println("Error: La edad tiene que ser un numero entero.");
            }
        }

        System.out.print("Introduce el email del alumno: ");
        String email = sc.nextLine();

        try {
            dao.insertar(new Alumno(nombre, edad, email));
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Listamos los alumnos de la base de datos
    public static void listarAlumnos() {
        try {
            List<Alumno> lista = dao.listar();
            System.out.println("\n--- LISTADO DE USUARIOS con LAMBDA ---");
            lista.forEach(n -> System.out.println(n));

        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Buscamos nombres que cominecen por una letra
    static void buscadorInteligente() {
        try {
            List<Alumno> lista = dao.listar();

            // Vamos a buscar los nombres que empiecen por la letra que quiera el usuario.
            System.out.print("Introduce la letra por la que debe empezar el nombre: ");
            String letra = sc.nextLine();

            // Función Lambda para buscar en la lista los nombres que empiezan por letra.
            for (Alumno a : lista) {
                if (a.getNombre().startsWith(letra)) {
                    System.out.println(a);
                }
            }

        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("Error: " + e.getMessage());
        }

    }
}
