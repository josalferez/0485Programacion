public class CuentaCorriente {
    private String titular;
    private double saldo;

    // Métodos

    public CuentaCorriente(double saldo, String titular) {
        this.saldo = saldo;
        this.titular = titular;
    }

    public void ingresar(double cantidad){
        this.saldo += cantidad;
    }

    public void sacar(double cantidad){
        this.saldo -= cantidad;
    }

    public void mostrarDatos(){
        System.out.println("El usuario " + this.getTitular() + " tiene " + this.getSaldo() + " en su cuenta.");
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    


}
