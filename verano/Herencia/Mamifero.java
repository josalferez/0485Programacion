public class Mamifero extends Animal {

    private int tiempoGestacion;

    public int getTiempoGestacion() {
        return tiempoGestacion;
    }

    public void setTiempoGestacion(int tiempoGestacion){
        this.tiempoGestacion = tiempoGestacion;
    }

    public void amamantar() {
        System.out.println("El mamífero está amamantando.");
    }

    public void moverse() {
        System.out.println("El mamífero se está moviendo.");
    }

    public static void saltar() {
        System.out.println("El mamífero está saltando.");
    }

}
