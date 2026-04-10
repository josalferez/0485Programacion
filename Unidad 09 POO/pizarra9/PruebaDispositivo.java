public class PruebaDispositivo {
    public static void main(String[] args) {

        CamaraSeguridad camara1 = new CamaraSeguridad(64, false, "Entrada", "camaraEntrada");
        camara1.encender();
        camara1.enviarAlertaMovil("Movimiento detectado en la entrada");
        camara1.activarAlarma("Intrusión detectada");
        camara1.motrarEspacioCamara();
    }
}
