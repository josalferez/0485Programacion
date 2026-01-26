public class MovilSegundaMano extends Movil {
    private String estado;

    // Constructor
    public MovilSegundaMano(String marca, String modelo, int capacidad, double precio, String estado, Gama gama) {
        super(marca, modelo, capacidad, precio, gama);
        this.estado = estado;
    }

    @Override
    public void mostrarDatos() {
        super.mostrarDatos();
        System.out.println("Estado: " + estado);
    }

    // Getter Estado
    public String getEstado() {
        return estado;
    }

    @Override
    public String toString() {
        return "MovilSegundaMano [estado=" + estado + "]";
    }

    @Override
    public void encender() {
        System.out.println("Enciendo el teléfono");
    }

    // Implemento el método de la interfaz configurable
    @Override
    public void resetearFabrica() {
        System.out.println("Móvil reseteado de fábrica");
    }
}
