public class Cafe extends Producto {

    private String tipoDeCafe;
    private String tamaño;

    public Cafe(String tamaño, String tipoDeCafe, String nombre, int precio, int stock) {
        super(nombre, precio, stock); // Uso el constructor del padre
        this.tamaño = tamaño;
        this.tipoDeCafe = tipoDeCafe;
    }

    public String getTipoDeCafe() {
        return tipoDeCafe;
    }

    public void setTipoDeCafe(String tipoDeCafe) {
        this.tipoDeCafe = tipoDeCafe;
    }

    public String getTamaño() {
        return tamaño;
    }

    public void setTamaño(String tamaño) {
        this.tamaño = tamaño;
    }
}
