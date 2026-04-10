import java.sql.Statement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class PruebaBaseDatos {
    public static void main(String[] args) {

        // Creamos un usuario
        Usuario u = new Usuario("Pedro", "pedro@soypedro.com");
        int opcion = -1;
        String nombre;
        String email;
        Scanner sc = new Scanner(System.in);
        UsuarioDAO dao = new UsuarioDAOImpl();

        try {
            // Creo la tabla usuarios
            CrearTablaUsuarios();
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
        }

        do {
            System.out.println("\n--- GESTIÓN DE USUARIOS ---");
            System.out.println("1. Listar Usuarios");
            System.out.println("2. Crear Usuario");
            System.out.println("3. Actualizar Usuario");
            System.out.println("4. Eliminar Usuario");
            System.out.println("0. Salir");
            System.out.print("Pulsa una opcion para salir: ");
            opcion = Integer.parseInt(sc.nextLine());

            switch (opcion) {

                case 1:

                    try {
                        for (Usuario usu : dao.listar()) {
                            System.out.println(usu);
                        }
                    } catch (Exception e) {
                        // TODO: handle exception
                        System.out.println("Error: " + e.getMessage());
                    }

                    break;

                case 2:
                    // Le pido los datos al usuario
                    System.out.print("Introduce tu nombre: ");
                    nombre = sc.nextLine();

                    System.out.print("Introduce tu email: ");
                    email = sc.nextLine();

                    try {
                        dao.insertar(new Usuario(nombre, email));
                        System.out.println("Usuario insertado correctamente");
                    } catch (Exception e) {
                        // TODO: handle exception
                        System.out.println(e.getMessage());
                    }

                    // Inserto el usuario en la base de datos

                    break;

                // Actualizamos un usuario
                case 3:
                    try {
                        // Listamos los usuarios
                        for (Usuario usu : dao.listar()) {
                            System.out.println(usu);
                        }

                        // Le pido el identificador del usuario que voy a actualizar
                        System.out.print("Introduce el número del usuario que quieres actualizar: ");
                        int id = Integer.parseInt(sc.nextLine());

                        // Le pido el nuevo nombre y el nuevo email
                        System.out.print("Introduce el nuevo nombre: ");
                        nombre = sc.nextLine();
                        System.out.print("Introduce el nuevo email: ");
                        email = sc.nextLine();
                        
                        dao.update(new Usuario(id, nombre, email));
                        System.out.println("El usuario " + u.getNombre() + "ha sido actualizado");


                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                // Borro un usuario de la base de datos
                case 4:
                    try {
                        // Listo los usuarios
                        for (Usuario usu : dao.listar()) {
                            System.out.println(usu);
                        }

                        // Le pido el identificador del usuario que voy a borrar
                        System.out.print("Introduce el número del usuario que quieres borrar: ");
                        int numero = Integer.parseInt(sc.nextLine());

                        dao.delete(numero);
                    } catch (SQLException e) {
                        // TODO: handle exception
                        System.out.println("Error: " + e.getMessage());
                    }

                    break;
                default:
                    break;
            }
        } while (opcion != 0);

    }

    private static void CrearTablaUsuarios() throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS usuarios (" +
                "id INT AUTO_INCREMENT PRIMARY KEY," +
                "nombre VARCHAR(100) NOT NULL," +
                "email VARCHAR(100) NOT NULL" +
                ")";

        try (Connection conn = ConexionDB.conectar();
                Statement stmt = conn.createStatement()) {

            stmt.execute(sql);
            System.out.println("Tabla 'usuarios' verificada/creada!");

        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
        }
    }
}
