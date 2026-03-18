public class PruebaGatoSimple {
    public static void main(String[] args) {
        GatoSimple tedi = new GatoSimple("macho");

        tedi.maulla();
        tedi.ronronea();
        tedi.come("comida");
        tedi.come("pescado");
        tedi.setEdad(3);
        tedi.setRaza("british shorthair");
        tedi.setPeso(6);

        GatoSimple Leo = new GatoSimple();
        Leo.maulla();

        System.out.println(tedi);
    }
}
