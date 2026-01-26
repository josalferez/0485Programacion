public class RobotEntrenamiento  extends Robot{
    
    // Atributos
    private boolean usoEducativo;  

    // Metodos
    public RobotEntrenamiento(boolean usoEducativo, int combatesRealizados, String id, int nivel, TipoRobot tipo) {
        super(combatesRealizados, id, nivel, tipo);
        this.usoEducativo = usoEducativo;
    }
    
    @Override
    public void actualizarSoftware(){
        this.setNivel(getNivel()+1);
    }

    @Override
    public boolean esProfesional(){
        return false;
    }

    @Override 
    public int calcularPuntuacion(){
        return super.calcularPuntuacion() + 10;
    }
}
