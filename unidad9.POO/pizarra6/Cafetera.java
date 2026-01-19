public class Cafetera {
    int agua;
    int cafe;
    TipoCafe tipoEnDeposito;

    public Cafetera(){
        this.agua = 0;
        this.cafe = 0;
    }

    public void recargarCafe(Bote boteSuministro, int cantidadASacar){
        this.cafe += cantidadASacar;  // Cargo la cafetera
        boteSuministro.gramosActuales -= cantidadASacar; // Reduzco la cantidad de cafe en el bote
        this.tipoEnDeposito = boteSuministro.variedad; // Relleno el café de la cafetera

        System.out.println("Recargando cafetera con " + cantidadASacar + "gr. de café tipo " + this.tipoEnDeposito.toString());
    }

    public void hacerCafe(){
        this.agua -= 200;
        this.cafe -= 20;

        System.out.println("Sirviendo una taza de " + tipoEnDeposito);
    }

    public void rellenarAgua(){
        this.agua += 1000;
    }
}
