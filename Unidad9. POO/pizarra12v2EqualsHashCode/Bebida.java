
import java.util.Objects;

public class Bebida extends Producto {
    private String tamano;

    public Bebida(String tamano, String nombre, double precioBase) {
        super(nombre, precioBase);
        this.tamano = tamano;
    }

    
    @Override
    public void servir() {
        System.out.println("Sirviendo en vaso " + this.tamano);
    }

    // Sobrecargo también en Bebida Equals y Hascode para poder comparar bebidas

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + Objects.hashCode(this.tamano);
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
        final Bebida other = (Bebida) obj;
        return Objects.equals(this.tamano, other.tamano);
    }

}
