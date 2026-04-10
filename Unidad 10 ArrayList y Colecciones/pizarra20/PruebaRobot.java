import java.util.HashMap;
import java.util.Scanner;

public class PruebaRobot {
    public static void main(String[] args) {

        // Creo el diccionario
        HashMap<String, Robot> torneo = new HashMap<>();
        Scanner sc = new Scanner(System.in);

        // Cargo los robots
        cargaRobots(torneo);

        // Cargo el menú
        while (true) {
            cargaMenu();
            System.out.print("Seleccione una opción (0 para salir): ");
            int opcion = Integer.parseInt(sc.nextLine());

            if (opcion == 0) {
                System.out.println("Saliendo del programa...");
                break;
            }

            switch (opcion) {
                case 1:
                    System.out.println("=== LISTA DE ROBOTS EN EL TORNEO ===");
                    for (Robot robot : torneo.values()) {
                        System.out.println("ID: " + robot.getId() + ", Tipo: " + robot.getTipo() + ", Nivel: "
                                + robot.getNivel() + ", Combates Realizados: " + robot.getCombatesRealizados());
                    }
                    System.out.println();
                    break;
                case 2:
                    System.out.println("1. Añadir Robot de Competición");
                    System.out.println("2. Añadir Robot de Entrenamiento");
                    System.out.print("Seleccione el tipo de robot a añadir: ");
                    int tipoRobot = Integer.parseInt(sc.nextLine());
                    if (tipoRobot == 1) {
                        Robot temp = new RobotCompeticion();
                        temp.leerDatos();
                        torneo.put(temp.getId(), temp); // lo añado al diccionario
                    } else if (tipoRobot == 2) {
                        Robot temp = new RobotEntrenamiento();
                        temp.leerDatos();
                        torneo.put(temp.getId(), temp); // lo añado al diccionario
                    } else {
                        System.out.println("Tipo de robot no válido.\n");
                    }

                   

                    break;
                case 3:
                    System.out.println("Funcionalidad para eliminar un robot aún no implementada.\n");
                    break;

                default:
                    System.out.println("Opción no válida. Por favor, intente de nuevo.\n");
            }
        }

    }

    // Cargo los 10 robots
    public static void cargaRobots(HashMap<String, Robot> torneo) {
        // Robot 1
        torneo.put("Robot_001", new RobotCompeticion(15000.0, 3, "Robot_001", 5, TipoRobot.ATAQUE));

        // Robot 2
        torneo.put("Robot_002", new RobotEntrenamiento(true, 1, "Robot_002", 2, TipoRobot.DEFENSA));

        // Robot 3
        torneo.put("Robot_003", new RobotCompeticion(25000.0, 5, "Robot_003", 7, TipoRobot.SOPORTE));

        // Robot 4
        torneo.put("Robot_004", new RobotEntrenamiento(false, 2, "Robot_004", 3, TipoRobot.ATAQUE));

        // Robot 5
        torneo.put("Robot_005", new RobotCompeticion(20000.0, 4, "Robot_005", 6, TipoRobot.DEFENSA));

        // Robot 6
        torneo.put("Robot_006", new RobotCompeticion(18000.0, 2, "Robot_006", 4, TipoRobot.SOPORTE));

        // Robot 7
        torneo.put("Robot_007", new RobotEntrenamiento(true, 0, "Robot_007", 1, TipoRobot.ATAQUE));

        // Robot 8
        torneo.put("Robot_008", new RobotCompeticion(30000.0, 6, "Robot_008", 8, TipoRobot.DEFENSA));

        // Robot 9
        torneo.put("Robot_009", new RobotEntrenamiento(false, 1, "Robot_009", 2, TipoRobot.SOPORTE));

        // Robot 10
        torneo.put("Robot_010", new RobotCompeticion(16000.0, 3, "Robot_010", 5, TipoRobot.ATAQUE));

        System.out.println("✅ Se han cargado 10 robots en el torneo.\n");
    }

    //
    public static void cargaMenu() {
        System.out.println("=== MENÚ DEL TORNEO DE ROBOTS ===");
        System.out.println("1. Mostrar todos los robots");
        System.out.println("2. Añadir un nuevo robot");
        System.out.println("3. Eliminar un robot");
        System.out.println("0. Salir");
    }

}
