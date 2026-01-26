import java.util.ArrayList;
import java.util.Scanner;

public class PruebaRobot {
    public static void main(String[] args) {

        // Creo un arrayList vacío
        ArrayList<Robot> torneo = new ArrayList<>();
        int opcion = -1;
        Scanner sc = new Scanner(System.in);
        while (opcion != 0) {
            System.out.print("\033c"); // Limpio la pantalla
            System.out.println("\n--- MENÚ OPERACIONES ARRAYLIST ---");
            System.out.println("1. Cargar datos de prueba.");
            System.out.println("2. Listar todos los robots.");
            System.out.println("3. Actualizar software.");
            System.out.println("0. Salir");
            System.out.print("Selecciona una opción: ");
            opcion = sc.nextInt();
            sc.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1:
                    RobotEntrenamiento re1 = new RobotEntrenamiento(false, 3, "0001", 10, TipoRobot.ATAQUE);
                    RobotEntrenamiento re2 = new RobotEntrenamiento(false, 2, "0002", 10, TipoRobot.ATAQUE);
                    RobotCompeticion rc1 = new RobotCompeticion(1500, 25, "0003", 15, TipoRobot.DEFENSA);
                    RobotCompeticion rc2 = new RobotCompeticion(2500, 21, "0004", 11, TipoRobot.DEFENSA);

                    // Añado robots
                    torneo.add(re1);
                    torneo.add(re2);
                    torneo.add(rc1);
                    torneo.add(rc2);
                    System.out.print("\033c"); // Limpio la pantalla
                    System.out.println("Actualmente hay " + torneo.size() + " robots.");
                    System.out.println("...Robots añadidos. Pulse una tecla para continuar...");
                    sc.nextLine();
                    break;

                case 2:
                    System.out.print("\033c"); // Limpio la pantalla
                    for (Robot r : torneo) {
                        System.out.println(r);
                    }
                    System.out.println("... Pulse una tecla para continuar...");
                    sc.nextLine();
                    break;

                case 3:
                    System.out.print("\033c"); // Limpio la pantalla
                    for (Robot r : torneo) {
                        if (r instanceof RobotCompeticion miRobotCompeticion){
                            miRobotCompeticion.actualizarSoftware();
                            System.out.println("Alerta: Software del ordenador actualizado!");
                        }

                    }
                    System.out.println("... Pulse una tecla para continuar...");
                    sc.nextLine();
                    break;

            }
        }

    }
}
