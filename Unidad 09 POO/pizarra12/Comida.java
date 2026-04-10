public class Comida extends Producto {
    private String tipoPlato;

    public Comida(String tipoPlato, String nombre, double precioBase) {
        super(nombre, precioBase);
        this.tipoPlato = tipoPlato;
    }

    @Override
    public void servir() {
        System.out.println("Sirviendo en plato de cerámica un producto..." + tipoPlato);
    }


}
