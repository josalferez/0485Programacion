public class RobotCompeticion extends Robot {

    // Atributos
    private double Presupuesto;

    // Metodos

    public RobotCompeticion(double Presupuesto, int combatesRealizados, String id, int nivel, TipoRobot tipo) {
        super(combatesRealizados, id, nivel, tipo);
        this.Presupuesto = Presupuesto;
    }

    @Override
    public void actualizarSoftware() {
        this.setNivel(getNivel() + 2);
    }

    @Override
    public boolean esProfesional() {
        return true;
    }

    @Override
    public int calcularPuntuacion() {
        return super.calcularPuntuacion() + 50;
    }

}
