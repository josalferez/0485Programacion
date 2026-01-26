public abstract class Empleado implements Trabajable {
    String nombre;
    Turno turno;
    private double sueldobase;

    public Empleado(String nombre, Turno turno, double sueldobase) {
        this.nombre = nombre;
        this.turno = turno;
        this.sueldobase = sueldobase;
    }
    

    public abstract double calcularSueldo(double propinas);

    public String getNombre() {
        return nombre;
    }

    public Turno getTurno() {
        return turno;
    }

    public double getSueldoBase() {
        return sueldobase;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTurno(Turno turno) {
        this.turno = turno;
    }

    public void setSueldobase(double sueldobase) {
        this.sueldobase = sueldobase;
    }
    
}
