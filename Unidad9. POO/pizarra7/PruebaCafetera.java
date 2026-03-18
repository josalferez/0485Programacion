public class PruebaCafetera {
    public static void main(String[] args) {
        Cafetera caf1 = new Cafetera(1000, 100, TipoCafe.MEZCLA);
        
        CafeteraIndustrial caf2 = new CafeteraIndustrial(5000, 500, TipoCafe.ARABICA, 4);

        caf1.mostrarEstado();
        caf2.mostrarEstado();

        caf1.hacerServicio();
        caf2.prepararBebidaGrande();
    }
}
