public class GatoSimple {
    private String color, raza, sexo;
    private int edad;
    private double peso;

    // Métodos
    // Constructor con Género
    GatoSimple(String s) {
        this.sexo = s;
    }

    // Constructor vacío
    GatoSimple() {}
 
    // Getter
    public String getSexo() {
        return this.sexo;
    }

    public String getColor() {
        return color;
    }

    public String getRaza() {
        return raza;
    }

    public int getEdad() {
        return edad;
    }

    public double getPeso() {
        return peso;
    }

    // Setter

    public void setColor(String color) {
        this.color = color;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    /**
     * Hace que el gato maulle
     */
    void maulla() {
        System.out.println("Miauuuu");
    }

    /**
     * Hace que el gato ronronee
     */
    void ronronea() {
        System.out.println("mrrrrrr");
    }

    void come(String comida) {
        if (comida.equals("pescado")) {
            System.out.println("Hmmmm, gracias");
        } else {
            System.out.println("Lo siento, yo solo como pescado");
        }
    }

    /**
     * Pone a pelear dos gatos.
     * Solo se van a pelear dos machos entre sí.
     *
     * @param contrincante es el gato contra el que pelear
     */
    void peleaCon(GatoSimple contrincante) {
        if (this.sexo.equals("hembra")) {
            System.out.println("no me gusta pelear");
        } else {
            if (contrincante.getSexo().equals("hembra")) {
                System.out.println("no peleo contra gatitas");
            } else {
                System.out.println("ven aquí que te vas a enterar");
            }
        }
    }
    @Override // No es obligatorio ponerlo pero se aconseja usarlo
    public String toString() {
        return "GatoSimple [color=" + color + ", raza=" + raza + ", sexo=" + sexo + ", edad=" + edad + ", peso=" + peso
                + "]";
    }

}