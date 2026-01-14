
import java.util.ArrayList;

public class main {

    public enum semaforo {
        ROJO(30), VERDE(30), AMBAR(5);

        private int duracionSegundos = 0;

        // Constructor del enum       
        semaforo( int duracion ){
                this.duracionSegundos = duracion;
        }

        // Getter del enum
        public int getDuracionSegundos(){
            return duracionSegundos;
        }

        public semaforo siguienteEstado() {
            switch (this) {
                case ROJO:
                    return VERDE;
                case VERDE:
                    return AMBAR;
                default:
                    return ROJO;
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<semaforo> semaforosGranada = new ArrayList<semaforo>();

        // Relleno el ArrayList
        for (semaforo s : semaforo.values()) {
            semaforosGranada.add(s);
        }

        // Imprimo el ArrayList
        System.out.println("Imprimo el ArrayList");
        for (int i = 0; i < semaforosGranada.size(); i++) {
            System.out.println(semaforosGranada.get(i).toString() + " duracion: " + semaforosGranada.get(i).getDuracionSegundos() + " segundos");
        }
    }
}
