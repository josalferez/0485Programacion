
import java.util.Objects;

public class Comida extends Producto {
    private String tipoPlato;

    public Comida(String tipoPlato, String nombre, double precioBase) {
        super(nombre, precioBase);
        this.tipoPlato = tipoPlato;
    }

    @Override
    public void servir() {
        System.out.println("Sirviendo en plato de cerámica un producto..." + tipoPlato);
    }

    // Sobrecargo también en Bebida Equals y Hashcode para poder comparar comidas

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.tipoPlato);
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
        final Comida other = (Comida) obj;
        return Objects.equals(this.tipoPlato, other.tipoPlato);
    }
    

}
