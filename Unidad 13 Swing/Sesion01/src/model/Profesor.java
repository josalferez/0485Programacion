package model;

public class Profesor extends Usuario {
    private String departamento;
    private String especialidad;

    public Profesor() {
        super();
    }

    public Profesor(String departamento, String especialidad) {
        this.departamento = departamento;
        this.especialidad = especialidad;
    }

    public Profesor(int id, String username, String password, String email, String nombre, String apellidos, String dni, String rol, String departamento, String especialidad) {
        super(id, username, password, email, nombre, apellidos, dni, rol);
        this.departamento = departamento;
        this.especialidad = especialidad;
    }

    public String getDepartamento() { return departamento; }
    public void setDepartamento(String departamento) { this.departamento = departamento; }

    public String getEspecialidad() { return especialidad; }
    public void setEspecialidad(String especialidad) { this.especialidad = especialidad; }

    @Override
    public String toString() {
        return "Profesor{" +
                "id=" + getId() +
                ", nombre='" + getNombre() + '\'' +
                ", apellidos='" + getApellidos() + '\'' +
                ", departamento='" + departamento + '\'' +
                ", especialidad='" + especialidad + '\'' +
                '}';
    }
}
