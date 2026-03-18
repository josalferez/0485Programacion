public class PruebaCafetera {
    public static void main(String[] args) {

        Bote bote1 = new Bote(TipoCafe.DESCAFEINADO,1000);
        Cafetera cafetera1 = new Cafetera();
        
        cafetera1.recargarCafe(bote1, 400);
        cafetera1.rellenarAgua();

        cafetera1.hacerCafe();
        bote1.informeBote(); // Veo cuanto café queda en el bote
        
    }    
}
