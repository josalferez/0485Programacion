import java.util.Scanner;
import src.dao.*;
import src.model.*;

public class Main {

    static LibroDAO libroDAO = new LibroDAOImpl();
    static SocioDAO socioDAO = new SocioDAOImpl();
    static PrestamoDAO prestamoDAO = new PrestamoDAOImpl();
    static Scanner scanner = new Scanner(System.in);   

    public static void main(String[] args) {
        pintarMenu();
    }

    public static void pintarMenu() {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- Menú de Gestión Académica ---");
            System.out.println("1. Listar socios");
            System.out.println("2. Buscar socio por ID");
            System.out.println("3. Crear socio");
            System.out.println("4. Actualizar socio");
            System.out.println("5. Eliminar socio");
            System.out.println("6. Listar libros");
            System.out.println("7. Crear libro");
            System.out.println("8. Registrar préstamo");
            System.out.println("9. Listar préstamos detallados");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");

            while (!scanner.hasNextInt()) {
                System.out.println("Por favor, introduzca un número válido.");
                scanner.next(); // Limpiar entrada incorrecta
                System.out.print("Seleccione una opción: ");
            }
            opcion = Integer.parseInt(scanner.nextLine());
            
            switch (opcion) {
                case 1->listarSocios();
                case 2->buscarSocioPorId();
                case 3->crearSocio();
                case 4->actualizarSocio();
                case 5->eliminarSocio();
                case 6->listarLibros();
                case 7->crearLibro();
                case 8->registrarPrestamo();
                case 9->listarPrestamos();
                case 0->System.out.println("\nSaliendo del programa...");
                default->System.out.println("\nOpción no válida. Intente de nuevo.");
            }
        } while (opcion != 0);

        scanner.close();
    }

    // Listamos todos los socios
    static void listarSocios() {
        try {
            System.out.println("\n--- Lista de Socios ---");
            for (Socio socio : socioDAO.listarTodos()) {
                System.out.println(socio);
            }
        } catch (Exception e) {
            System.out.println("Error al listar socios: " + e.getMessage());
        }       
    }

    // Buscamos socio por ID
        static void buscarSocioPorId() {
        try {
            System.out.print("\nIngrese el ID del socio: ");
            int id = Integer.parseInt(scanner.nextLine());
            Socio socio = socioDAO.obtenerPorId(id);
            if (socio != null) {
                System.out.println("Socio encontrado: " + socio);
            } else {
                System.out.println("No se encontró un socio con ese ID.");
            }
        } catch (Exception e) {
            System.out.println("Error al buscar socio: " + e.getMessage());
        }
    }

    // Crear nuevo socio
    static void crearSocio() {
        try {
            System.out.print("\nIngrese el nombre del socio: ");
            String nombre = scanner.nextLine();
            System.out.print("Ingrese el email del socio: ");
            String email = scanner.nextLine();
            Socio nuevoSocio = new Socio(0, nombre, email); // ID se asignará automáticamente
            socioDAO.insertar(nuevoSocio);
            System.out.println("Socio creado exitosamente.");
        } catch (Exception e) {
            System.out.println("Error al crear socio: " + e.getMessage());
        }
    }

    static void actualizarSocio() {
        try {
            System.out.print("\nIngrese el ID del socio a actualizar: ");
            int id = Integer.parseInt(scanner.nextLine());
            Socio socio = socioDAO.obtenerPorId(id);
            if (socio != null) {
                System.out.print("Ingrese el nuevo nombre del socio (" + socio.getNombre() + "): ");
                String nombre = scanner.nextLine();
                if (!nombre.trim().isEmpty()) {
                    socio.setNombre(nombre);
                }
                
                System.out.print("Ingrese el nuevo email del socio (" + socio.getEmail() + "): ");
                String email = scanner.nextLine();
                if (!email.trim().isEmpty()) {
                    socio.setEmail(email);
                }
                
                socioDAO.actualizar(socio);
                System.out.println("Socio actualizado exitosamente.");
            } else {
                System.out.println("No se encontró un socio con ese ID.");
            }
        } catch (Exception e) {
            System.out.println("Error al actualizar socio: " + e.getMessage());
        }
    }

    static void eliminarSocio() {
        try {
            System.out.print("\nIngrese el ID del socio a eliminar: ");
            int id = Integer.parseInt(scanner.nextLine());
            socioDAO.eliminar(id);
            System.out.println("Socio eliminado exitosamente.");
        } catch (Exception e) {
            System.out.println("Error al eliminar socio: " + e.getMessage());
        }
    }

    static void listarLibros() {
        try {
            System.out.println("\n--- Lista de Libros ---");
            for (Libro libro : libroDAO.listarTodos()) {
                System.out.println(libro);
            }
        } catch (Exception e) {
            System.out.println("Error al listar libros: " + e.getMessage());
        }
    }

    static void crearLibro() {
        try {
            System.out.print("\nIngrese el título del libro: ");
            String titulo = scanner.nextLine();
            System.out.print("Ingrese el autor del libro: ");
            String autor = scanner.nextLine();
            Libro nuevoLibro = new Libro(0, titulo, autor);
            libroDAO.insertar(nuevoLibro);
            System.out.println("Libro creado exitosamente.");
        } catch (Exception e) {
            System.out.println("Error al crear libro: " + e.getMessage());
        }
    }

    static void registrarPrestamo() {
        try {
            System.out.print("\nIngrese el ID del socio: ");
            int idSocio = Integer.parseInt(scanner.nextLine());
            System.out.print("Ingrese el ID del libro: ");
            int idLibro = Integer.parseInt(scanner.nextLine());
            
            Socio socio = socioDAO.obtenerPorId(idSocio);
            Libro libro = libroDAO.obtenerPorId(idLibro);
            
            if (socio == null) {
                System.out.println("Error: No existe un socio con el ID " + idSocio);
                return;
            }
            if (libro == null) {
                System.out.println("Error: No existe un libro con el ID " + idLibro);
                return;
            }
            
            java.time.LocalDate fecha = java.time.LocalDate.now();
            prestamoDAO.registrarPrestamo(idSocio, idLibro, fecha);
            System.out.println("Préstamo registrado exitosamente.");
        } catch (Exception e) {
            System.out.println("Error al registrar préstamo: " + e.getMessage());
        }
    }

    static void listarPrestamos() {
        try {
            System.out.println("\n--- Lista de Préstamos Detallados ---");
            for (PrestamoDTO prestamo : prestamoDAO.listarPrestamosDetallados()) {
                System.out.println("Socio: " + prestamo.getNombreSocio() + 
                                   " - Libro: " + prestamo.getTituloLibro() + 
                                   " - Fecha: " + prestamo.getFecha());
            }
        } catch (Exception e) {
            System.out.println("Error al listar préstamos: " + e.getMessage());
        }
    }
}