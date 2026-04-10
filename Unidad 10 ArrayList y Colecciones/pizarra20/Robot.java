
import java.util.Objects;

public abstract class Robot implements Competidor {
    private String id;
    private TipoRobot tipo;
    private int nivel;
    private int combatesRealizados;
    private static int numeroRobots = 0;
    
    // Constructor Getter y Setter

    public Robot(int combatesRealizados, int nivel, TipoRobot tipo) {
        this.combatesRealizados = combatesRealizados;
        this.id = "Robot_" + String.format("%03d", ++numeroRobots);
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
    public int hashCode() {
        int hash = 5;
        hash = 31 * hash + Objects.hashCode(this.id);
        hash = 31 * hash + Objects.hashCode(this.tipo);
        hash = 31 * hash + this.nivel;
        hash = 31 * hash + this.combatesRealizados;
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

    @Override
    public int calcularPuntuacion(){
        return nivel * combatesRealizados;
    }

    // Falta implementar el método public boolean esProfesional();
    
    public void mejorarNivel(){
        nivel = nivel + 1;
    }

    public void mejorarNivel(int cantidad){
        nivel = nivel + cantidad;
    }

    public abstract void leerDatos();
    
}
