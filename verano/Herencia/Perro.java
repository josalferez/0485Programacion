public class Perro extends Mamifero {
    private String raza;
    private float tamanio;

    public void ladrar(){
        System.out.println("Guau");
    }

    @Override    
    public void moverse() {
        System.out.println("El perro se está moviendo.");
    }

    
}
