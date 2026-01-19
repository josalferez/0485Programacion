public class GestionTaller {
    public static void main(String[] args) {
        Neumatico[] inventario = new Neumatico[3];

        inventario[0] = new Neumatico(TipoNeumatico.ALL_SEASON, 25);
        inventario[1] = new Neumatico(TipoNeumatico.INVIERNO, 18);
        inventario[2] = new Neumatico(TipoNeumatico.OFF_ROAD, 16);

        // Muestro el estado de todos los neumáticos
        for (Neumatico neumatico : inventario) {
            neumatico.mostrarEstado();
        }

        // Muestro Alerta si la presión de inflado es menor de 20 psi
        for (Neumatico neumatico : inventario) {
            if (neumatico.getPsi() < 20)
                System.out.println("¡ALERTA: PRESIÓN CRÍTICA! Necesita inflado");
        }
    }
}
