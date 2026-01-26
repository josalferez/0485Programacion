public class Moto extends Vehiculo {
    
    public Moto(String matricula, String marca) {
        super(matricula, marca);
    }

    @Override
    public String toString() {
        return "Moto [matricula=" + matricula + "]";
    }

    @Override
    public void arrancar() {
        System.out.println("La moto arranca");
    }

    @Override
    public void parar() {
        System.out.println("La moto se para");
    }

    public void hacerCaballito() {
        System.out.println("La moto hace caballito");
    }

    
}
