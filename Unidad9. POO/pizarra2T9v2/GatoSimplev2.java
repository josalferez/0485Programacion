
public class GatoSimplev2 {
    // Atributos
    String nombre, color, raza, sexo;
    int edad;
    double peso;

    // metodos
    // Constructor
    public GatoSimplev2(String color, int edad, double peso, String raza, String sexo) {
        this.color = color;
        this.edad = edad;
        this.peso = peso;
        this.raza = raza;
        this.sexo = sexo;
    }

    // Getter y Setter
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
 
    public String getColor() {
        return color;
    }

    public void setColor(String color) { // lena.setColor("marrón");
        this.color = color;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    // El gato maulla
    public void Maulla(){
        System.out.println("Miauuuuuu");
    }

    // El gato ronronea
    public void Ronronea(){
        System.out.println("Ruuuuuuuu");
    }

    // El gato come
    public void Come(String comida){
        if(comida.equals("pescado")){
            System.out.println("Que rico el pescado");
        }else{
            System.out.println("solo como pescado!!!!");    
        }
    }

    // El gato se pelea con otros gatos
    public void peleaCon(GatoSimplev2 contrincante){
        if(this.getSexo().equals("hembra")){
            System.out.println("No me gusta pelear");
        }else if(contrincante.getSexo().equals("macho")){
            System.out.println("Te voy a matar.");
        }else{
            System.out.println("No peleo con hembras");
        }
    }

    //Método toString
    @Override
    public String toString(){
        return "Soy " + this.getNombre() + ", un gato de color " + this.getColor() + ". Soy de raza " + getRaza() + " y tengo " + getEdad() + " años.";
    }
}
