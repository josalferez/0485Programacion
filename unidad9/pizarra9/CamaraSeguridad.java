public class CamaraSeguridad extends Dispositivo implements Vigilante {
    private int almacenamientoSD;

    public CamaraSeguridad(int almacenamientoSD, boolean estaEncendido, String habitacion, String nombreDispositivo) {
        super(estaEncendido, habitacion, nombreDispositivo);
        this.almacenamientoSD = almacenamientoSD;
    }

    // Implemento los métodos de la interfaz
    @Override
    public void activarAlarma(String motivo) {
        System.out.println("Suena la alarma por " + motivo);
    }

    @Override
    public void enviarAlertaMovil(String mensaje) {
        this.almacenamientoSD -= 1;
        System.out.println(mensaje);
    }

    @Override
    public void encender(){
        System.out.println("El sensor de movimiento está operativo.");
        
    }

    public void motrarEspacioCamara(){
        System.out.println("Quedan " + this.almacenamientoSD + " gigas en el disco duro de la cámara");
    }

}
