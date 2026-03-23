import java.util.Scanner;

import src.dao.*;
import src.model.*;


public class Main {

    static AlumnoDAO alumnoDAO = new AlumnoDAOImpl();
    static CursoDAO cursoDAO = new CursoDAOImpl();
    static MatriculaDAO matriculaDAO = new MatriculaDAOImpl(); 
    static Scanner scanner = new Scanner(System.in);
    static int opcion;

    public static void main(String[] args) {
        pintarMenu();
    }

    public static void pintarMenu() {
        do {
            System.out.println("\n--- Menú de Gestión Académica ---");
            System.out.println("1. Listar alumnos");
            System.out.println("2. Buscar alumno por ID");
            System.out.println("3. Crear alumno");
            System.out.println("4. Actualizar alumno");
            System.out.println("5. Eliminar alumno");
            System.out.println("6. Listar cursos");
            System.out.println("7. Crear curso");
            System.out.println("8. Matricular alumno");
            System.out.println("9. Listar matrículas");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");

            while (!scanner.hasNextInt()) {
                System.out.println("Por favor, introduzca un número válido.");
                scanner.next(); // Limpiar entrada incorrecta
                System.out.print("Seleccione una opción: ");
            }
            opcion = Integer.parseInt(scanner.nextLine());

            switch (opcion) {
                case 1:
                    listarAlumnos();
                    break;
                case 2:
                    buscarAlumnoPorId(scanner);
                    break;
                case 3:
                    crearAlumno(scanner);
                    break;
                case 4:
                    actualizarAlumno(scanner);
                    break;
                case 5:
                    eliminarAlumno(scanner);
                    break;
                case 6:
                    listarCursos();
                    break;
                case 7:
                    crearCurso(scanner);
                    break;
                case 8:
                    matricularAlumno(scanner);
                    break;
                case 9:
                    listarMatriculas();
                    break;
                case 0:
                    System.out.println("\nSaliendo del programa...");
                    break;
                default:
                    System.out.println("\nOpción no válida. Intente de nuevo.");
            }
        } while (opcion != 0);

        scanner.close();
    }

    static void listarAlumnos() {
        try {
            System.out.println("\n--- Listado de Alumnos ---");
            for (Alumno alumno : alumnoDAO.listarTodos()) {
                System.out.println(alumno);
            }
        } catch (Exception e) {
            System.out.println("Error al listar alumnos: " + e.getMessage());
        }
    }

    static void buscarAlumnoPorId(Scanner scanner) {
        try {
            System.out.print("Ingrese el ID del alumno: ");
            int id = scanner.nextInt();
            scanner.nextLine(); // Consumir salto de línea
            Alumno alumno = alumnoDAO.obtenerPorId(id);
            if (alumno != null) {
                System.out.println(alumno);
            } else {
                System.out.println("Alumno no encontrado.");
            }
        } catch (Exception e) {
            System.out.println("Error al buscar alumno: " + e.getMessage());
        }
    }

    static void crearAlumno(Scanner scanner) {
        try {
            System.out.print("Ingrese el nombre del alumno: ");
            String nombre = scanner.nextLine();
            System.out.print("Ingrese el email del alumno: ");
            String email = scanner.nextLine();
            Alumno alumno = new Alumno(0, nombre, email); // ID se asignará en la base de datos
            alumnoDAO.insertar(alumno);
            System.out.println("Alumno creado exitosamente.");
        } catch (Exception e) {
            System.out.println("Error al crear alumno: " + e.getMessage());
        }
    }

    static void actualizarAlumno(Scanner scanner) {
        try {
            System.out.print("Ingrese el ID del alumno a actualizar: ");
            int id = scanner.nextInt();
            scanner.nextLine(); // Consumir salto de línea
            Alumno alumno = alumnoDAO.obtenerPorId(id);
            if (alumno != null) {
                System.out.print("Ingrese el nuevo nombre del alumno: ");
                String nombre = scanner.nextLine();
                System.out.print("Ingrese el nuevo email del alumno: ");
                String email = scanner.nextLine();
                alumno.setNombre(nombre);
                alumno.setEmail(email);
                alumnoDAO.actualizar(alumno);
                System.out.println("Alumno actualizado exitosamente.");
            } else {
                System.out.println("Alumno no encontrado.");
            }
        } catch (Exception e) {
            System.out.println("Error al actualizar alumno: " + e.getMessage());
        }
    }

    static void eliminarAlumno(Scanner scanner) {
        try {
            System.out.print("Ingrese el ID del alumno a eliminar: ");
            int id = scanner.nextInt();
            scanner.nextLine(); // Consumir salto de línea
            alumnoDAO.eliminar(id);
            System.out.println("Alumno eliminado exitosamente.");
        } catch (Exception e) {
            System.out.println("Error al eliminar alumno: " + e.getMessage());
        }
    }

    static void listarCursos(){
        try {
            System.out.println("\n--- Listado de Cursos ---");
            for (Curso curso : cursoDAO.listarTodos()) {
                System.out.println(curso);
            }
        } catch (Exception e) {
            System.out.println("Error al listar cursos: " + e.getMessage());
        }
    }

    static void crearCurso(Scanner scanner) {
        try {
            System.out.print("Ingrese el título del curso: ");
            String titulo = scanner.nextLine();
            System.out.print("Ingrese los créditos del curso: ");
            int creditos = scanner.nextInt();
            scanner.nextLine(); // Consumir salto de línea
            Curso curso = new Curso(0, titulo, creditos); // ID se asignará en la base de datos
            cursoDAO.insertar(curso);
            System.out.println("Curso creado exitosamente.");
        } catch (Exception e) {
            System.out.println("Error al crear curso: " + e.getMessage());
        }
    }

    static void matricularAlumno(Scanner scanner) {
        try {
            System.out.print("Ingrese el ID del alumno a matricular: ");
            int alumnoId = scanner.nextInt();
            System.out.print("Ingrese el ID del curso para matricular: ");
            int cursoId = scanner.nextInt();
            scanner.nextLine(); // Consumir salto de línea
            matriculaDAO.matricular(alumnoId, cursoId, java.time.LocalDate.now());
            System.out.println("Alumno matriculado exitosamente.");
        } catch (Exception e) {
            System.out.println("Error al matricular alumno: " + e.getMessage());
        }
    }

    static void listarMatriculas() {
        try {
            System.out.println("\n--- Listado de Matrículas ---");
            for (var matricula : matriculaDAO.listarMatriculasDetalladas()) {
                System.out.println(matricula);
            }
        } catch (Exception e) {
            System.out.println("Error al listar matrículas: " + e.getMessage());
        }
    }
}