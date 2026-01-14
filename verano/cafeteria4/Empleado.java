
public class Empleado extends Usuario {
    
    private int sueldo;
    private String puesto;

    // Constructor de empleado + Usuario
    public Empleado ( String Nombre, int ide, String email, int sueldo, String puesto) {
        super(Nombre, ide, email); // Constructor del padre
        this.puesto = puesto;
        this.sueldo = sueldo;
    }

    // Defino la clase abatracta de Usuario    
    @Override
    public void mostrarRol(){
        System.out.println("Soy un Empleado");
    }

    // Getter y Setter
    public void setSueldo ( int sueldo) {
        this.sueldo = sueldo;
    }
    public int  getSueldo () {
        return this.sueldo;
    }    

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }
    

}
