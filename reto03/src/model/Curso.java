package src.model;

public class Curso {
    private int id;
    private String titulo;
    private int creditos;

    public Curso() {
    }

    public Curso(int id, String titulo, int creditos) {
        this.id = id;
        this.titulo = titulo;
        this.creditos = creditos;
    }

    public Curso(String titulo, int creditos) {
        this.titulo = titulo;
        this.creditos = creditos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getCreditos() {
        return creditos;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    @Override
    public String toString() {
        return "Curso{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", creditos=" + creditos +
                '}';
    }
}
