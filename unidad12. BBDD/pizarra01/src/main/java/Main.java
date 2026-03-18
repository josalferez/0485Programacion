import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            // 1. Crear la tabla si no existe
            crearTablaUsuarios();

            Scanner sc = new Scanner(System.in);
            UsuarioDAO dao = new UsuarioDAOImpl();
            int opcion;

            do {
                System.out.println("\n--- GESTIÓN DE USUARIOS ---");
                System.out.println("1. Listar Usuarios");
                System.out.println("2. Crear Usuario");
                System.out.println("3. Actualizar Usuario");
                System.out.println("4. Eliminar Usuario");
                System.out.println("0. Salir");
                System.out.print("Seleccione una opción: ");

                try {
                    opcion = Integer.parseInt(sc.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Por favor, introduzca un número válido.");
                    opcion = -1;
                    continue;
                }

                try {
                    switch (opcion) {
                        case 1:
                            System.out.println("\n--- LISTADO DE USUARIOS ---");
                            for (Usuario u : dao.listar()) {
                                System.out.println(u.getId() + " - " + u.getNombre() + " - " + u.getEmail());
                            }
                            break;

                        case 2:
                            System.out.print("Nombre: ");
                            String nombre = sc.nextLine();

                            if (nombre.isBlank()) {
                                System.out.println("El nombre no puede estar vacío.");
                                break;
                            }

                            System.out.print("Email: ");
                            String email = sc.nextLine();

                            if (!email.contains("@")) {
                                System.out.println("Email no válido.");
                                break;
                            }

                            dao.insertar(new Usuario(nombre, email));
                            System.out.println("Usuario creado correctamente.");
                            break;

                        case 3:
                            System.out.print("ID a modificar: ");
                            int id = Integer.parseInt(sc.nextLine());

                            System.out.print("Nuevo nombre: ");
                            String nom = sc.nextLine();

                            System.out.print("Nuevo email: ");
                            String em = sc.nextLine();

                            dao.actualizar(new Usuario(id, nom, em));
                            System.out.println("Usuario actualizado correctamente.");
                            break;

                        case 4:
                            System.out.print("ID a eliminar: ");
                            int idEliminar = Integer.parseInt(sc.nextLine());
                            dao.eliminar(idEliminar);
                            System.out.println("Usuario eliminado correctamente.");
                            break;

                        case 0:
                            System.out.println("Saliendo...");
                            break;

                        default:
                            System.out.println("Opción no válida.");
                            break;
                    }
                } catch (SQLException e) {
                    System.out.println("Error en la base de datos: " + e.getMessage());
                } catch (NumberFormatException e) {
                    System.out.println("Entrada no válida para el ID.");
                }

            } while (opcion != 0);

            // Cierro el Scanner
            sc.close();

        } catch (SQLException e) {
            System.err.println("Error en la inicialización:");
            e.printStackTrace();
        }
    }

    private static void crearTablaUsuarios() throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS usuarios (" +
                "id INT AUTO_INCREMENT PRIMARY KEY," +
                "nombre VARCHAR(100) NOT NULL," +
                "email VARCHAR(100) NOT NULL" +
                ")";

        try (Connection conn = ConexionDB.conectar();
                Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("Tabla 'usuarios' verificada/creada.");
        }
    }
}
