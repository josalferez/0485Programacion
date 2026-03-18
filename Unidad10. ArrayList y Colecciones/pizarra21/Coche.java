public class Coche extends Vehiculo {
    
    public Coche(String matricula, String marca) {
        super(matricula, marca);
    }

    @Override
    public String toString() {
        return "Coche [matricula=" + matricula + "]";
    }

    @Override
    public void arrancar() {
        System.out.println("El coche arranca");
    }

    @Override
    public void parar() {
        System.out.println("El coche se para");
    }
}
