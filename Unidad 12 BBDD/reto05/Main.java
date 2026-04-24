
import java.util.List;
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
            System.out.println("4. Actualizar un producto");
            System.out.println("5. Eliminar un producto");
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
                case 4 -> actualizarProducto();
                case 5 -> eliminarProducto();
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

    static void obtenerTodosProductos() {
        try {
            // Creo una lista de productos
            List<Producto> lista = productoDAO.obtenerTodos();

            // La imprimo por pantalla
            for (Producto producto : lista) {
                System.out.println(producto);
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    static void actualizarProducto() {
        // Listo todos los productos y le pido un id para actualizar
        obtenerTodosProductos();

        System.out.print("Introduce el id para actualizar");
        int idActualizar = Integer.parseInt(scanner.nextLine());
        try {
            // Recupero el producto de la base de datos a actualizar antes de operar con él
            Producto producto = productoDAO.obtenerPorId(idActualizar);

            System.out.println("1. Nombre");
            System.out.println("2. Cantidad");
            System.out.println("3. Precio");
            System.out.print("Pulsa el numero del campo que quieras actualizar: ");
            int campoActualizar = Integer.parseInt(scanner.nextLine());
            switch (campoActualizar) {
                case 1:
                    System.out.print("Introduce el nuevo nombre: ");
                    producto.setNombre(scanner.nextLine());
                    // nuevoNombre = scanner.nextLine();
                    break;

                case 2:
                    System.out.print("Introduce la cantidad: ");
                    producto.setCantidad(Integer.parseInt(scanner.nextLine()));
                    break;

                case 3:
                    System.out.print("Introduce el nuevo precio: ");
                    producto.setPrecio(Double.parseDouble(scanner.nextLine()));
                    break;

                default:
                    System.out.println("Elige un numero entre 1 y 3");
                    break;
            }

            productoDAO.actualizar(producto);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    static void eliminarProducto(){
        try {
            // Listo todos los productos
            obtenerTodosProductos();
            System.out.print("¿Qué producto quieres eliminar?: ");
            productoDAO.eliminar(Integer.parseInt(scanner.nextLine()));

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
