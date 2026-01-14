public class Dispositivo{
    private String nombreDispositivo;
    private String habitacion;
    private boolean estaEncendido = false;

    public Dispositivo(boolean estaEncendido, String habitacion, String nombreDispositivo) {
        this.estaEncendido = estaEncendido;
        this.habitacion = habitacion;
        this.nombreDispositivo = nombreDispositivo;
    }

    public void encender(){
        System.out.println("Encendiendo el dispositivo ...");
        this.estaEncendido = true;
    }


}
