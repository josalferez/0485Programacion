public class Camarero extends Empleado {
    
    public Camarero(String nombre, Turno turno, double sueldoBase) {
        super(nombre,turno,sueldoBase);
    }

    @Override
    public double calcularSueldo(double propinas) {
        return getSueldoBase() + propinas;
    }

    public void traspasarSaldo(Cliente origen, Cliente destino, double cantidad) {
        if (origen.getSaldo() >= cantidad) {
            origen.setSaldo(origen.getSaldo() - cantidad); // Le resto la cantidad al usuario que envía
            destino.setSaldo(destino.getSaldo() + cantidad); // Le actualizo el saldo al receptor
            System.out.println(origen.getNombre() + " le envió " + cantidad + " euros a " + destino.getNombre());
        }
    }

    public void servir(Cliente c) {
        System.out.println("Qué ha tomado el cliente?: ");
        System.out.println("El camarero " + getNombre() + " le sirve un "
                + c.getUltimoProductoComprado().getNombre() + " a " + c.getNombre());
    }

    @Override
    public void realizarTarea(){
        System.out.println("...Soy el camarero. Estoy realizando una tarea...");
    }

}
