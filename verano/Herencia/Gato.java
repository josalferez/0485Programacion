public class Gato extends Mamifero implements Comportamiento{
    
    public void comer () {
        System.out.println("El gato está comiendo");
    }

    public void dormir () {
            System.out.println("El gato está durmiendo");
        }

    public void moverse () {
        System.err.println("El gato se está moviendo");
    }
}
