public class Animal {
    // Atributos
    private String tipo; // Definimos que tipo de animal es
    private int edad; // Edad del animal
    private String nombre; // Nombre del animal

    // Constructor
    public Animal(String tipo, int edad, String nombre) {
        this.tipo = tipo;
        this.edad = edad;
        this.nombre = nombre;
    }
    
    // Metodos GetterAni
    
    // Metodos Getter
    public String getTipo(){
        return tipo;
    }

    public int getEdad(){
        return edad;
    }

    public String getNombre(){
        return nombre;
    }

    // Métodos Setter
    public void setTipo(String tipo){
        this.tipo = tipo;
    }

    public void setEdad(int edad){
        this.edad = edad;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString(){
        return "Mi animal es un " + getTipo() + " se llama " 
        + getNombre() + " y tiene " + getEdad() + " años.";     
    }
}
