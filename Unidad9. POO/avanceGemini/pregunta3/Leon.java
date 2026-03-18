public class Leon extends Animal implements Adoptable {

    public Leon(TipoDieta dieta, int edad, String nombre) {
        super(dieta, edad, nombre);
    }
    
    @Override
    public void  hacerSonido(){
        System.out.println("Grrrrrr");
    }
    @Override
    public void serAdoptado(){
        System.out.println("Un león no puede ser adoptado por seguridad");
    }
}
