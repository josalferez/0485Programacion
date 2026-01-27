import java.util.Scanner;

public class RobotCompeticion extends Robot {
    private double extra;

    public RobotCompeticion(double extra, int combatesRealizados, String id, int nivel, TipoRobot tipo) {
        super(combatesRealizados, nivel, tipo);
        this.extra = extra;
    }

    public RobotCompeticion() {
        super(0, 0, TipoRobot.ATAQUE);
        this.extra = 0.0;
    }

    

    @Override
    public void actualizarSoftware() {
        this.mejorarNivel(2);
    }

    @Override
    public boolean esProfesional() {
        return true;
    }

    @Override
    public int calcularPuntuacion() {
        return super.calcularPuntuacion() + 50;
    }

    @Override
    public void leerDatos() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese el Presupuesto disponible para el robot de competición: ");
        this.extra = Double.parseDouble(sc.nextLine());
        System.out.println("Robot de competición añadido correctamente.\n");
    }



}
