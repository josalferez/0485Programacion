
import java.util.Objects;

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

    public String getNombre() {
        return nombre;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    // Sobrecargo el equals y el hashcode del padre para poder comparar dos prouctos
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + Objects.hashCode(this.nombre);
        hash = 31 * hash + (int) (Double.doubleToLongBits(this.precioBase) ^ (Double.doubleToLongBits(this.precioBase) >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Producto other = (Producto) obj;
        if (Double.doubleToLongBits(this.precioBase) != Double.doubleToLongBits(other.precioBase)) {
            return false;
        }
        return Objects.equals(this.nombre, other.nombre);
    }


}
