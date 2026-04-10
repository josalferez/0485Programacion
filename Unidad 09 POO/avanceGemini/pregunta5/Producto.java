public class Producto {

    public static int getTotalProductosCreados() {
        return totalProductosCreados;
    }

    public static void setTotalProductosCreados(int totalProductosCreados) {
        Producto.totalProductosCreados = totalProductosCreados;
    }

    private String nombre;
    private double precio;
    private static int totalProductosCreados = 0;

    // Constructores
    Producto(String nombre, double precio){
        this.nombre = nombre;
        this.precio = precio;
        totalProductosCreados++;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return nombre + ", precio=" + precio;
    }
}