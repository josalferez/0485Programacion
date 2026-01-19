public class Gato extends Animal {

    // Atributos
    private String raza;

    // Metodos
    // Constructor 1
    public Gato() {
        super(Sexo.HEMBRA);
        this.raza = "Europeo común";
    }

    // Constructor 2
    public Gato(Sexo s) {
        super(s);
        this.raza = "Europeo común";
    }

    // Constructor 3
    public Gato(String raza) {
        super(Sexo.HEMBRA);
        this.raza = raza;
    }

    // Constructor 4
    public Gato(Sexo s, String r) {
        super(s);
        raza = r;
    }

    @Override
    public String toString() {
        return "Gato [raza=" + raza + "]";
    }

    public void maulla() {
        System.out.println("Miauuuu");
    }

    public void ronronea() {
        System.out.println("Mrrrmrrr");
    }

    public void come(String comida) {
        if (comida.equals("pescado")) {
            System.out.println("Ummm que rico!");
        } else {
            System.out.println("Lo siento, solo como pescado");
        }
    }

    public void peleaCon(Gato contrincante) {
        if (this.getSexo() == Sexo.HEMBRA) {
            System.out.println("No me gusta pelear");
        } else {
            if (contrincante.getSexo() == Sexo.HEMBRA) {
                System.out.println("No peleo con gatitas");
            } else {
                System.out.println("Im gonna kill you!");
            }
        }
    }

    // Sobrecarga del método duerme
    @Override
    public void duerme() {
        System.out.println("ZzzzzSoyUnGato");
    }
}
