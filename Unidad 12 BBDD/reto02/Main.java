import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import src.model.*;
import src.dao.*;

public class Main {

    public static void main(String[] args) {
        // Usamos la clase ConexionDB para obtener la conexión
        try (Connection conn = ConexionDB.conectar()) {
            System.out.println("Conexión exitosa a la base de datos.");
            
            // Instanciamos el DAO pasando la conexión abierta
            ProductoDAO dao = new ProductoDAOImpl(conn);
            
            // Ejecutamos el menú pasando la instancia del DAO
            pintarMenu(dao);

        } catch (SQLException e) {
            System.err.println("Error al conectar con la base de datos: " + e.getMessage());
            System.err.println("Asegúrate de que la BD esté encendida y el driver configurado.");
        }
    }

    public static void pintarMenu(ProductoDAO dao) {
        Scanner sc = new Scanner(System.in);
        int opcion = -1;

        do {
            System.out.println("\n--- GESTIÓN DE INVENTARIO (PRODUCTOS) ---");
            System.out.println("1. Listar todos los productos");
            System.out.println("2. Buscar producto por ID");
            System.out.println("3. Crear nuevo producto");
            System.out.println("4. Actualizar producto");
            System.out.println("5. Eliminar producto");
            System.out.println("6. Filtrar por categoría");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");

            try {
                opcion = Integer.parseInt(sc.nextLine());

                switch (opcion) {
                    case 1:
                        List<Producto> lista = dao.findAll();
                        if (lista.isEmpty()) System.out.println("No hay productos.");
                        else lista.forEach(System.out::println);
                        break;

                    case 2:
                        System.out.print("Introduce el ID: ");
                        int idB = Integer.parseInt(sc.nextLine());
                        dao.findById(idB).ifPresentOrElse(
                            System.out::println,
                            () -> System.out.println("Producto no encontrado.")
                        );
                        break;

                    case 3:
                        System.out.print("Nombre: "); String nom = sc.nextLine();
                        System.out.print("Categoría: "); String cat = sc.nextLine();
                        System.out.print("Precio: "); double pre = Double.parseDouble(sc.nextLine());
                        System.out.print("Stock: "); int stk = Integer.parseInt(sc.nextLine());
                        dao.save(new Producto(0, nom, cat, pre, stk));
                        System.out.println("Producto guardado.");
                        break;

                    case 4:
                        System.out.print("ID del producto a actualizar: ");
                        int idA = Integer.parseInt(sc.nextLine());
                        if (dao.findById(idA).isPresent()) {
                            System.out.print("Nuevo Nombre: "); String nNom = sc.nextLine();
                            System.out.print("Nueva Categoría: "); String nCat = sc.nextLine();
                            System.out.print("Nuevo Precio: "); double nPre = Double.parseDouble(sc.nextLine());
                            System.out.print("Nuevo Stock: "); int nStk = Integer.parseInt(sc.nextLine());
                            dao.update(new Producto(idA, nNom, nCat, nPre, nStk));
                            System.out.println("Producto actualizado.");
                        } else {
                            System.out.println("Error: ID no encontrado.");
                        }
                        break;

                    case 5:
                        System.out.print("ID a eliminar: ");
                        int idD = Integer.parseInt(sc.nextLine());
                        dao.delete(idD);
                        System.out.println("Producto eliminado.");
                        break;

                    case 6:
                        System.out.print("Categoría a filtrar: ");
                        String catF = sc.nextLine();
                        List<Producto> filtrados = dao.findByCategoria(catF);
                        if (filtrados.isEmpty()) System.out.println("No hay productos en esa categoría.");
                        else filtrados.forEach(System.out::println);
                        break;

                    case 0:
                        System.out.println("Saliendo...");
                        break;

                    default:
                        System.out.println("Opción no válida.");
                }
            } catch (Exception e) {
                System.out.println("Error en la entrada de datos: " + e.getMessage());
            }
        } while (opcion != 0);

        sc.close();
    }
}