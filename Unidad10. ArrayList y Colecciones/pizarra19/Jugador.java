
import java.util.Objects;

public abstract class Jugador implements Competidor{
    // Atributos
    private String nombre;
    private RolJugador rol;
    private int nivel;
    private int partidasJugadas;

    // Métodos

    public Jugador(int nivel, String nombre, int partidasJugadas, RolJugador rol) {
        this.nivel = nivel;
        this.nombre = nombre;
        this.partidasJugadas = partidasJugadas;
        this.rol = rol;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public RolJugador getRol() {
        return rol;
    }

    public void setRol(RolJugador rol) {
        this.rol = rol;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public int getPartidasJugadas() {
        return partidasJugadas;
    }

    public void setPartidasJugadas(int partidasJugadas) {
        this.partidasJugadas = partidasJugadas;
    }

    // Implemento la interfaz competidor
    public int calcularPuntuacion(){
        return this.getNivel() * this.getPartidasJugadas();
    }
    
    public boolean esProfesional(){
        return false;
    }

    // Método abstracto
    public abstract void entrenar();

    @Override
    public String toString() {
        return "Jugador [nombre=" + nombre + ", rol=" + rol + ", nivel=" + nivel + ", partidasJugadas="
                + partidasJugadas + "]";
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 11 * hash + Objects.hashCode(this.nombre);
        hash = 11 * hash + Objects.hashCode(this.rol);
        hash = 11 * hash + this.nivel;
        hash = 11 * hash + this.partidasJugadas;
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
        final Jugador other = (Jugador) obj;
        if (this.nivel != other.nivel) {
            return false;
        }
        if (this.partidasJugadas != other.partidasJugadas) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) { // Continua con True si tienen el mismo nombre
            return false;
        }
        return this.rol == other.rol; // Acaba devolviendo true Si tienen el mismo rol
    }

    // 9. Sobrecargo subirNivel
    public void subirNivel(){
        this.setNivel(this.getNivel() + 1);
    }

    public void subirNivel(int cantidad){
        this.setNivel(this.getNivel() + cantidad);
    }



}
