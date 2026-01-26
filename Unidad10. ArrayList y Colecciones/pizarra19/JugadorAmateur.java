public class JugadorAmateur extends Jugador {
    private boolean juegaPorDiversion;

    public JugadorAmateur(boolean juegaPorDiversion, int nivel, String nombre, int partidasJugadas, RolJugador rol) {
        super(nivel, nombre, partidasJugadas, rol);
        this.juegaPorDiversion = juegaPorDiversion;
    }

    public void entrenar() {
        this.setNivel(this.getNivel() + 1);
    }

    @Override
    public boolean esProfesional() {
        return false;
    }

    public boolean isJuegaPorDiversion() {
        return juegaPorDiversion;
    }

    public void setJuegaPorDiversion(boolean juegaPorDiversion) {
        this.juegaPorDiversion = juegaPorDiversion;
    }

    @Override
    public int calcularPuntuacion() {
        return (this.getNivel() * this.getPartidasJugadas()) + 10;
    }



}
