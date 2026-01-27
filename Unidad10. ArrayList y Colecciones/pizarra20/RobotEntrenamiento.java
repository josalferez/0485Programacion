public class RobotEntrenamiento extends Robot {
    private boolean usoEducativo;

    public RobotEntrenamiento(boolean usoEducativo, int combatesRealizados, String id, int nivel, TipoRobot tipo) {
        super(combatesRealizados, id, nivel, tipo);
        this.usoEducativo = usoEducativo;
    }

    @Override
    public void actualizarSoftware() {
        this.mejorarNivel(1);
    }

    @Override
    public boolean esProfesional() {
        return false;
    }

    @Override
    public int calcularPuntuacion() {
        return super.calcularPuntuacion() + 10;
    }

}
