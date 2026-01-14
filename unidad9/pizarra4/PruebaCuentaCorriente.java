public class PruebaCuentaCorriente {
    public static void main(String[] args) {
        CuentaCorriente cuenta1 = new CuentaCorriente(100,"Jose");

        // Muestro los datos de la cuenta
        cuenta1.mostrarDatos();

        // Ingreso 1000 euros en la cuenta
        cuenta1.ingresar(50);

        // Muestro los datos de la cuenta
        cuenta1.mostrarDatos();

        // Saco dinero de la cuenta
        cuenta1.sacar(20);
        
        // Muestro los datos de la cuenta
        cuenta1.mostrarDatos();

    }    
}
