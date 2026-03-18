import java.util.ArrayList;

public class GestionTaller {
    public static void main(String[] args) {
        // 1. Apertura del Taller: Crear el ArrayList
        ArrayList<Coche> colaTaller = new ArrayList<>();

        // Añadir 3 coches
        colaTaller.add(new Coche("ABC-1234"));
        colaTaller.add(new Coche("XYZ-5678"));
        colaTaller.add(new Coche("MNO-9012"));

        System.out.println("--- Taller Abierto ---");

        // 2. Estado del Inventario
        System.out.println("Coches actualmente en el taller: " + colaTaller.size());

        // 3. Reparación del primer vehículo (Índice 0)
        Coche primerCoche = colaTaller.get(0);
        primerCoche.reparar(); // Cambiamos el estado a true
        System.out.println("Reparando primer vehículo...");
        System.out.println("Estado actual: " + primerCoche.toString());

        // 4. Entrega del vehículo (Borrar)
        System.out.println("\nEntregando coche reparado...");
        colaTaller.remove(0); // Elimina el elemento en la posición 0

        // Comprobación
        System.out.println("Coches restantes: " + colaTaller.size());
        if (!colaTaller.isEmpty()) {
            System.out.println("El nuevo primero en la cola es: " + colaTaller.get(0));
        }

        // 5. Cierre por Vacaciones (Limpiar)
        System.out.println("\nCerrando taller por vacaciones...");
        colaTaller.clear();

        // Mensaje final
        System.out.println("Confirmación: El taller tiene " + colaTaller.size() + " coches.");
    }
}