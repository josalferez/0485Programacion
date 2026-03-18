package src.model;

/**
 * Clase que representa la entidad Producto para la gestión de inventario.
 */
public class Producto {

    // Atributos privados
    private int id;
    private String nombre;
    private String categoria;
    private double precio;
    private int stock;

    /**
     * Constructor vacío (necesario para frameworks o inicializaciones manuales)
     */
    public Producto() {
    }

    /**
     * Constructor con todos los parámetros
     * * @param id Identificador único
     * @param nombre Nombre del producto
     * @param categoria Categoría a la que pertenece
     * @param precio Precio de venta
     * @param stock Unidades disponibles
     */
    public Producto(int id, String nombre, String categoria, double precio, int stock) {
        this.id = id;
        this.nombre = nombre;
        this.categoria = categoria;
        this.precio = precio;
        this.stock = stock;
    }

    // --- GETTERS Y SETTERS ---

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    /**
     * Sobreescritura del método toString() para mostrar los datos con formato
     */
    @Override
    public String toString() {
        return String.format(
            "ID: %-4d | Nombre: %-20s | Categoría: %-15s | Precio: %8.2f€ | Stock: %d",
            id, nombre, categoria, precio, stock
        );
    }
}