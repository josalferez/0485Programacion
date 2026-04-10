public class Gerente extends Empleado{
    private String departamento;
    private int personalACargo;
    private double objetivoVentas;
    private boolean esSocio;

    public Gerente(String departamento, boolean esSocio, double objetivoVentas, int personalACargo, String nombre, Turno turno, double sueldobase) {
        super(nombre, turno, sueldobase);
        this.departamento = departamento;
        this.esSocio = esSocio;
        this.objetivoVentas = objetivoVentas;
        this.personalACargo = personalACargo;
    }

    @Override
    public double calcularSueldo(double propinas){
        return this.getSueldoBase() + propinas;
    }
    
    @Override
    public void realizarTarea(){
        System.out.println("...Soy el Gerente. Estoy realizando una tarea...");
    }

    public void modificarPrecio(Producto p, double nuevoPrecio){
        p.setPrecio(nuevoPrecio);
    }

    public void organizarTurno(Empleado e, Turno nuevoTurno){
        e.setTurno(nuevoTurno);
    }

    public void cerrarCaja(double totalRecaudado){
        if (totalRecaudado < getObjetivoVentas()){
            System.out.println("...Hoy hemos vendido menos de lo esperado...");
        } else {
            System.out.println("...Hoy hemos vendido más de lo esperado...");
        }
    }

    public void premiarEmpleado(Camarero c, double bono){
        c.setSueldobase(c.getSueldoBase()+bono);
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public int getPersonalACargo() {
        return personalACargo;
    }

    public void setPersonalACargo(int personalACargo) {
        this.personalACargo = personalACargo;
    }

    public double getObjetivoVentas() {
        return objetivoVentas;
    }

    public void setObjetivoVentas(double objetivoVentas) {
        this.objetivoVentas = objetivoVentas;
    }

    public boolean isEsSocio() {
        return esSocio;
    }

    public void setEsSocio(boolean esSocio) {
        this.esSocio = esSocio;
    }


}
