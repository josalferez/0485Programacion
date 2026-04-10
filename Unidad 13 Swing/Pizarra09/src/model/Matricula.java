package model;

import java.time.LocalDate;

public class Matricula {
    private int id;
    private int alumnoId;
    private int cursoId;
    private LocalDate fecha;

    public Matricula() {
    }

    public Matricula(int id, int alumnoId, int cursoId, LocalDate fecha) {
        this.id = id;
        this.alumnoId = alumnoId;
        this.cursoId = cursoId;
        this.fecha = fecha;
    }

    public Matricula(int alumnoId, int cursoId, LocalDate fecha) {
        this.alumnoId = alumnoId;
        this.cursoId = cursoId;
        this.fecha = fecha;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAlumnoId() {
        return alumnoId;
    }

    public void setAlumnoId(int alumnoId) {
        this.alumnoId = alumnoId;
    }

    public int getCursoId() {
        return cursoId;
    }

    public void setCursoId(int cursoId) {
        this.cursoId = cursoId;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Matricula{" +
                "id=" + id +
                ", alumnoId=" + alumnoId +
                ", cursoId=" + cursoId +
                ", fecha=" + fecha +
                '}';
    }
}


