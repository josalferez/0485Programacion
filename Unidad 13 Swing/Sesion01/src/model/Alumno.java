package model;

public class Alumno extends Usuario {
    private String beca;
    private String promocion;

    public Alumno() {
        super();
    }

    public Alumno(String beca, String promocion) {
        this.beca = beca;
        this.promocion = promocion;
    }

    public Alumno(int id, String username, String password, String email, String nombre, String apellidos, String dni, String rol, String beca, String promocion) {
        super(id, username, password, email, nombre, apellidos, dni, rol);
        this.beca = beca;
        this.promocion = promocion;
    }

    public String getBeca() { return beca; }
    public void setBeca(String beca) { this.beca = beca; }

    public String getPromocion() { return promocion; }
    public void setPromocion(String promocion) { this.promocion = promocion; }

    @Override
    public String toString() {
        return "Alumno{" +
                "id=" + getId() +
                ", nombre='" + getNombre() + '\'' +
                ", apellidos='" + getApellidos() + '\'' +
                ", beca='" + beca + '\'' +
                ", promocion='" + promocion + '\'' +
                '}';
    }
}
