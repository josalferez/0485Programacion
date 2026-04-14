
import java.util.Scanner;

import src.dao.*;
import src.model.*;

public class Main {

    static ProductoDAO productoDAO = new ProductoDAOImpl();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int opcion;

        System.out.println("\n--- Menú de Gestión de Productos ---");
        System.out.println("1. Crear Producto");
        // System.out.println("2. Buscar socio por ID");
        System.out.println("0. Salir");
        System.out.print("Seleccione una opción: ");

        while (!scanner.hasNextInt()){
            System.out.println("Por favor, introduzca un número valido");
            scanner.next();
            System.out.println("Seleccione una opcion: ");
            
        }
        opcion = Integer.parseInt(scanner.nextLine());

        switch (opcion) {
            case 1->crearProducto();
            case 0->System.exit(0);
            default->System.out.println("Opcion no válida");
        }
    }

    static void crearProducto(){
        try {
            // Cojo los datos del producto
            System.out.print("Nombre del producto: ");
            String nombre = scanner.nextLine();
            System.out.print("Cantidad: ");
            int cantidad = Integer.parseInt(scanner.nextLine());
            System.out.print("Precio: ");
            double precio = Double.parseDouble(scanner.nextLine());
            Producto nuevoProducto = new Producto(0,nombre,cantidad,precio);
            productoDAO.crear(nuevoProducto);
            System.out.println("Producto creado con éxito.");

        } catch (Exception e) {
            // TODO: handle exception
        }
    }

}
