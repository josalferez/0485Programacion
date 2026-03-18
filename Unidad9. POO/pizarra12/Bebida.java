public class Bebida extends Producto {
    private String tamano;

    public Bebida(String tamano, String nombre, double precioBase) {
        super(nombre, precioBase);
        this.tamano = tamano;
    }

    
    @Override
    public void servir() {
        System.out.println("Sirviendo en vaso " + this.tamano);
    }
}
