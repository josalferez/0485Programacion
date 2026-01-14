
import java.util.ArrayList;

enum palos {
    PICAS, CORAZONES, DIAMANTES, TREBOLES;
}

enum valores {
    AS, DOS, TRES, CUATRO, CINCO, SEIS, SIETE, OCHO, NUEVE, DIEZ, J, Q, K;
}

public class Carta {

    palos palo;
    valores valor;

    // Constructor de la clase carta
    public Carta(palos p, valores v) {
        this.palo = p;
        this.valor = v;
    }

    // Getter de Carta
    public void imprimirCarta(){
        System.out.println("" + this.palo + this.valor + " ");
    }

    public static void main(String[] args) {

        // Creo la coleccion baraja
        ArrayList<Carta> baraja = new ArrayList<Carta>();
        
        // Rellenamos la baraja
        for (palos p : palos.values()) {
            for (valores v : valores.values()) {
                // Creo una carta y la añado a la baraja
                Carta nuevaCarta = new Carta(p, v);
                baraja.add(nuevaCarta);
            }
        }

        // Imprimos las cartas de la coleccion baraja
        for (Carta c : baraja ) {
            c.imprimirCarta();
        }
    }
}
