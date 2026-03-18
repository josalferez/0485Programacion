public class Principal {

    public static void main(String[] args) {

        // Creo el bote y la cafetera
        Bote bote1 = new Bote("Arábica", 1000);
        Cafetera cafetera1 = new Cafetera();

        cafetera1.rellenarAgua();

        cafetera1.consultarEstado();

        cafetera1.cargarCafe(bote1, 250);

        cafetera1.consultarEstado();
        bote1.informe();
    }

}
