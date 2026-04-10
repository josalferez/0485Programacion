package model;

public class Usuario {
    private int id;
    private String username;
    private String password;
    private String email;
    private Integer alumnoId; // Opcional, puede ser null
    private Integer profesorId; // Opcional, puede ser null
    private String rol;

    public Usuario() {
    }

    public Usuario(int id, String username, String password, String email, Integer alumnoId, Integer profesorId, String rol) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.alumnoId = alumnoId;
        this.profesorId = profesorId;
        this.rol = rol;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAlumnoId() {
        return alumnoId;
    }

    public void setAlumnoId(Integer alumnoId) {
        this.alumnoId = alumnoId;
    }

    public Integer getProfesorId() {
        return profesorId;
    }

    public void setProfesorId(Integer profesorId) {
        this.profesorId = profesorId;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", alumnoId=" + alumnoId +
                ", profesorId=" + profesorId +
                ", rol='" + rol + '\'' +
                '}';
    }
}
