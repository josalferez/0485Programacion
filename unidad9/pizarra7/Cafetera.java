public class Cafetera{
    // Atributos
    private int agua, cafe;
    private TipoCafe tipoEnDeposito;

    //Constructor1
    public Cafetera(int agua, int cafe, TipoCafe tipo){
        this.agua = agua;
        this.cafe = cafe;
        this.tipoEnDeposito = tipo;
    }

    public void mostrarEstado(){
        System.out.println("Quedan " + this.agua + " litros de agua y " 
            + this.cafe + " gramos de café.");
    }

    void hacerServicio(){
        this.agua -= 200;
        this.cafe -= 20;
        System.out.println("Sirvieno café estándar");
    }

    public void setAgua(int agua) {
        this.agua = agua;
    }

    public void setCafe(int cafe) {
        this.cafe = cafe;
    }

    public int getAgua() {
        return agua;
    }

    public int getCafe() {
        return cafe;
    }






}