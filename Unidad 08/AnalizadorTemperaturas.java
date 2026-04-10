
public class AnalizadorTemperaturas {

    // Método principal
    public static void main(String[] args) {
        int[] lecturas = {-5, 10, 5, 10, 20, 15, 5, 0};
        int rangoTolerancia = 15;

        int moda = temperaturas.metodos.encontrarTemperaturaFrecuente(lecturas);
        int bajoCeroF = temperaturas.metodos.convertirYContarBajoCero(lecturas);
        boolean esHomogeneo = temperaturas.metodos.verificarHomogeneidad(lecturas, rangoTolerancia);

        System.out.println("Temperatura más frecuente (moda): " + moda);
        System.out.println("Lecturas bajo 32°F: " + bajoCeroF);
        System.out.println("¿Lecturas homogéneas?: " + esHomogeneo);
    }
}
