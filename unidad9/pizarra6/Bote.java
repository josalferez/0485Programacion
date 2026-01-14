public class Bote {

    TipoCafe variedad; // TipoCafe es un enum. Ojo no es una clase. 
    int gramosActuales;

    public Bote(TipoCafe variedad, int gramos){
        this.variedad = variedad;
        this.gramosActuales = gramos;
    }

    public void informeBote(){
        System.out.println("El bote tiene cafe del tipo: " + this.variedad + " y quedan " + this.gramosActuales + " gramos.");
    }

}
