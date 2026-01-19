public class Cliente {
    private String nombre;
    private double saldo;
    private Producto ultimoProductoComprado;

    public Cliente(String nombre, double saldo) {
        this.nombre = nombre;
        this.saldo = saldo;
    }

    public void pedirProducto(Producto p){
        if (this.saldo >= p.getPrecio()){
            this.saldo -= p.getPrecio(); // Resto el precio al saldo
            ultimoProductoComprado = p;
            System.out.println("El cliente " + this.nombre + " ha comprado " + p.getNombre());
        } else{
            System.out.println("Saldo insuficiente");
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public Producto getUltimoProductoComprado() {
        return ultimoProductoComprado;
    }

    
    
}
