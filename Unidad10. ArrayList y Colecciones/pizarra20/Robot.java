
import java.util.Objects;

public abstract class Robot implements Competidor{
    private String id;
    private TipoRobot tipo;
    private int nivel;
    private int combatesRealizados;

    // Metodos
    public Robot(int combatesRealizados, String id, int nivel, TipoRobot tipo) {
        this.combatesRealizados = combatesRealizados;
        this.id = id;
        this.nivel = nivel;
        this.tipo = tipo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public TipoRobot getTipo() {
        return tipo;
    }

    public void setTipo(TipoRobot tipo) {
        this.tipo = tipo;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public int getCombatesRealizados() {
        return combatesRealizados;
    }

    public void setCombatesRealizados(int combatesRealizados) {
        this.combatesRealizados = combatesRealizados;
    }

    public abstract void actualizarSoftware();

    @Override
    public String toString() {
        return "Robot [id=" + id + ", tipo=" + tipo + ", nivel=" + nivel + ", combatesRealizados=" + combatesRealizados
                + "]";
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.id);
        hash = 89 * hash + Objects.hashCode(this.tipo);
        hash = 89 * hash + this.nivel;
        hash = 89 * hash + this.combatesRealizados;
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
        final Robot other = (Robot) obj;
        if (this.nivel != other.nivel) {
            return false;
        }
        if (this.combatesRealizados != other.combatesRealizados) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return this.tipo == other.tipo;
    }

    public int calcularPuntuacion(){
        return nivel * combatesRealizados;
    }

    public void mejorarNivel(){
        nivel += 1;
    }

    public void mejorarNivel(int cantidad){
        nivel += cantidad;
    }
}
