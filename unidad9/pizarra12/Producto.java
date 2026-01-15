public class Producto {
    private String nombre;
    private double precioBase;

    
    public Producto(String nombre, double precioBase) {
        this.nombre = nombre;
        this.precioBase = precioBase;
    }

    public void servir() {
        System.out.println("Sirviendo producto...");
    }

    public double calcularPrecio() {
        return this.precioBase;
    }

    public double calcularPrecio(double descuento) {
        return this.precioBase - ((descuento/100) * precioBase);
    }

    public double calcularPrecio(boolean esSocio) {
        return (esSocio) ? this.precioBase - (0.2 * precioBase) : precioBase;
    }

    @Override
    public String toString() {
        return "Producto [nombre=" + nombre + ", precioBase=" + precioBase + "]";
    }    
}
