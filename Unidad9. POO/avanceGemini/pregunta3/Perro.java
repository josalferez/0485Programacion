public class Perro extends Animal implements Adoptable {

    public Perro(TipoDieta dieta, int edad, String nombre) {
        super(dieta, edad, nombre);
    }
    
    
    
    @Override
    public void hacerSonido() {
        System.out.println("Guau guau");
    }

    @Override
    public void serAdoptado() {
        System.out.println("Ahora tengo una familia");
    }

}
