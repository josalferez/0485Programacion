public class Cliente extends Usuario {
    
    private int saldo;

    public Cliente( String nombre, int id, String email, int saldo) {
        super(nombre, id, email);
        this.saldo = saldo;
    }

    @Override
    public void mostrarRol(){
        System.out.println("Soy un cliente");
    }

    // Getter y Setter
    public void setSaldo ( int saldo) {
        this.saldo = saldo;
    }

    public int  getSaldo () {
        return this.saldo;
    }    
}
