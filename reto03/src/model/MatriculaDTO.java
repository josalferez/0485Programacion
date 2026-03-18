package src.model;

import java.time.LocalDate;

public class MatriculaDTO {
    private String nombreAlumno;
    private String tituloCurso;
    private LocalDate fecha;

    public MatriculaDTO() {
    }

    public MatriculaDTO(String nombreAlumno, String tituloCurso, LocalDate fecha) {
        this.nombreAlumno = nombreAlumno;
        this.tituloCurso = tituloCurso;
        this.fecha = fecha;
    }

    public String getNombreAlumno() {
        return nombreAlumno;
    }

    public void setNombreAlumno(String nombreAlumno) {
        this.nombreAlumno = nombreAlumno;
    }

    public String getTituloCurso() {
        return tituloCurso;
    }

    public void setTituloCurso(String tituloCurso) {
        this.tituloCurso = tituloCurso;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "MatriculaDTO{" +
                "nombreAlumno='" + nombreAlumno + '\'' +
                ", tituloCurso='" + tituloCurso + '\'' +
                ", fecha=" + fecha +
                '}';
    }
}