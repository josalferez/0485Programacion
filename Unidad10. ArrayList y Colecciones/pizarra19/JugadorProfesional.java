public class JugadorProfesional extends Jugador {

    // Atributos
    private double salario;

    // Métodos

    public JugadorProfesional(double salario, int nivel, String nombre, int partidasJugadas, RolJugador rol) {
        super(nivel, nombre, partidasJugadas, rol);
        this.salario = salario;
    }

    @Override
    public void entrenar() {
        this.setNivel(this.getNivel() + 2);
    }

    @Override
    public boolean esProfesional() {
        return true;
    }

    @Override
    public int calcularPuntuacion() {
        return (this.getNivel() * this.getPartidasJugadas()) + 50;
    }

}
