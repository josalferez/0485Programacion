
import java.util.Scanner;

import src.dao.*;
import src.model.*;

public class Main {

    static ProductoDAO productoDAO = new ProductoDAOImpl();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int opcion = -1;

        while (opcion != 0) {
            System.out.println("\n--- Menú de Gestión de Productos ---");
            System.out.println("1. Crear Producto");
            System.out.println("2. Buscar Producto por ID");
            System.out.println("3. Listar todos los productos");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");

            String entrada = scanner.nextLine();
            try {
                opcion = Integer.parseInt(entrada.trim());
            } catch (NumberFormatException e) {
                System.out.println("Por favor, introduzca un número válido.");
                continue;
            }

            switch (opcion) {
                case 1 -> crearProducto();
                case 2 -> obtenerProductoID();
                case 3 -> obtenerTodosProductos();
                case 0 -> System.out.println("Saliendo...");
                default -> System.out.println("Opción no válida.");
            }
        }
    }

    static void crearProducto() {
        try {
            // Cojo los datos del producto
            System.out.print("Nombre del producto: ");
            String nombre = scanner.nextLine();
            System.out.print("Cantidad: ");
            int cantidad = Integer.parseInt(scanner.nextLine());
            System.out.print("Precio: ");
            double precio = Double.parseDouble(scanner.nextLine());
            Producto nuevoProducto = new Producto(0, nombre, cantidad, precio);
            productoDAO.crear(nuevoProducto);
            System.out.println("Producto creado con éxito.");

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    static void obtenerProductoID() {
        try {
            System.out.print("Ingrese el ID del producto: ");
            int id = Integer.parseInt(scanner.nextLine());
            Producto producto = productoDAO.obtenerPorId(id);
            if (producto != null) {
                System.out.println(producto);
            } else {
                System.out.println("Producto no encontrado!");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    static void obtenerTodosProductos(){
        try {
            
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
