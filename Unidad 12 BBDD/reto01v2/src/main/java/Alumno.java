public class Alumno {
    private int id;
    private String Nombre;
    private int Edad;
    private String email;

    public Alumno(String nombre, int edad, String email) {
        Nombre = nombre;
        Edad = edad;
        this.email = email;
    }

    // Este constructor es para cuando recupero los datos de la 
    // base de datos
    public Alumno(int id, String nombre, int edad, String email) {
        this.id = id;
        Nombre = nombre;
        Edad = edad;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public int getEdad() {
        return Edad;
    }

    public void setEdad(int edad) {
        Edad = edad;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return this.getId() + " - " + this.getNombre() + " - " + this.getEdad() + " - " + this.getEmail();
    }
}
