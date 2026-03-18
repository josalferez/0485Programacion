public class Producto implements Pagable{
    private String nombre;
    private int precio;
    private int stock;

    
    // Constructor de la clase Producto
    public Producto(String nombre, int precio, int stock) {
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    // Definición del método Pagar de la interface
    @Override
    public void Pagar(Cliente cliente, int cantidad){
        
        // Compruebo primero que el cliente tenga saldo y en caso afirmativo hago el cargo. 
        if (cliente.getSaldo() >= (cantidad * this.precio)) {
            this.stock -= cantidad;
            int total = cliente.getSaldo() - (cantidad * this.precio);
            cliente.setSaldo(total);
            System.out.println(cliente.getNombre() + " ha comprado " + cantidad + " " + getNombre() + " por " + (cantidad * getPrecio()) + " Euros");
        } else { 
            System.out.println("No tienes saldo suficiente");
        }
    }

    // Muestro la información de un producto
    public void mostrarInformacion(){
        System.out.println("Producto: " + getNombre() + " | Cantidad: " + getStock() + " | Precio: " + getPrecio());
    }

    
}
