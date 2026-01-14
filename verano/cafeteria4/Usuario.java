public abstract class Usuario{
    private String nombre;
    private int id;
    private String email;

    // Constructor de la clase
    public Usuario(String nombre, int id, String email ) {
        this.email = email;
        this.id = id;
        this.nombre = nombre;
    }

    // Getters
    public String getNombre(){
        return this.nombre;
    }

    public int getId(){
        return this.id;
    }

    public String getEmail(){
        return this.email;
    }

    // Setters
    public void setNombre( String nombre ){
        this.nombre = nombre;
    }

    public void setId( int id ){
        this.id = id;
    }

    public void setEmail( String email){
        this.email = email;
    }   
    
    
    public void mostrarInformacion(){
        System.out.println("El usuario " + getId() + " se llama " + getNombre() + " y su email es: " + getEmail());
    }

    // Metodo abstracto que implementarán las clases hijas, Cliente y Empleado
    public abstract void mostrarRol();
    
}