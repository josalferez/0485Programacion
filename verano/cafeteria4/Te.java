public class Te extends Producto {

    private String tipoDeHoja;
    private String sabor;


    // Constructor de la clase
    public Te(String nombre, int precio, int stock, String tipoDeHoja, String sabor) {
        super(nombre, precio, stock); // Constructor del padre
        this.tipoDeHoja = tipoDeHoja;
        this.sabor = sabor;
    }

    // Getters y Setters
    public String getTipoDeHoja() {
        return tipoDeHoja;
    }

    public void setTipoDeHoja(String tipoDeHoja) {
        this.tipoDeHoja = tipoDeHoja;
    }

    public String getSabor() {
        return sabor;
    }

    public void setSabor(String sabor) {
        this.sabor = sabor;
    }


}
