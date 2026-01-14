public abstract class Animal {
    String nombre;
    int edad;
    TipoDieta dieta;

    // Constructor de la clase
    public Animal(TipoDieta dieta, int edad, String nombre) {
        this.dieta = dieta;
        this.edad = edad;
        this.nombre = nombre;
    }

    public abstract void hacerSonido();

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public TipoDieta getDieta() {
        return dieta;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setDieta(TipoDieta dieta) {
        this.dieta = dieta;
    }

    @Override
    public String toString() {
        return "Animal [nombre=" + nombre + ", edad=" + edad + ", dieta=" + dieta + "]";
    }

    
    
}
