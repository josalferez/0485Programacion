
import java.util.ArrayList;

enum Curso {
    PROGRAMACION(60), BASES_DE_DATOS(40), REDES(20);

    private int duracionMinutos;

    private Curso(int duracionMinutos) {
        this.duracionMinutos = duracionMinutos;
    }

    public int devolverDuracion(){
        return duracionMinutos;
    }

}

enum Dia {
    LUNES, MARTES, MIERCOLES, JUEVES, VIERNES, SABADO, DOMINGO;
}

public class Clase {

    Curso curso;
    Dia dia;

    // Constructor de la clase
    public Clase(Curso curso, Dia dia) {
        this.curso = curso;
        this.dia = dia;
    }

    // Imprimir Clase
    public void imprimirClase() {
        System.out.println("La clase de " + this.curso + " es el " + this.dia + " y dura: " + this.curso.devolverDuracion() + " minutos.");
    }

    public static void main(String[] args) {

        // Creo el arrayList de clases
        ArrayList<Clase> horario = new ArrayList<Clase>();

        // Recorro el enum Curso para asignar todas las clases al estudiante los lunes, martes y miercoles
        for (int i = 0; i < Curso.values().length; i++) {
            switch (i) {
                case 0:
                    Clase c = new Clase(Curso.PROGRAMACION, Dia.LUNES);
                    horario.add(c);
                    break;
                case 1:
                    c = new Clase(Curso.BASES_DE_DATOS, Dia.MARTES);
                    horario.add(c);
                    break;
                case 2:
                    c = new Clase(Curso.REDES, Dia.MIERCOLES);
                    horario.add(c);
                    break;
            }

        }

        // Imprimo laS claseS
        for (Clase elem : horario) {
            elem.imprimirClase();
        }

    }

}
