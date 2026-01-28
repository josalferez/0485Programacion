import java.util.Scanner;

public class RobotEntrenamiento extends Robot {
    private boolean usoEducativo;

    public RobotEntrenamiento(boolean usoEducativo, int combatesRealizados, String id, int nivel, TipoRobot tipo) {
        super(combatesRealizados, nivel, tipo);
        this.usoEducativo = usoEducativo;
    }
    public RobotEntrenamiento() {
        super(0, 0, TipoRobot.DEFENSA);
        this.usoEducativo = false;
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

    @Override
    public void leerDatos() {
        Scanner sc = new Scanner(System.in);
        System.out.print("¿El robot es de uso educativo? (true/false): ");
        this.usoEducativo = Boolean.parseBoolean(sc.nextLine());
        System.out.println("Robot de entrenamiento añadido correctamente.\n");
    }

}
