package src.model;

import java.time.LocalDate;

public class PrestamoDTO {
    private String nombreSocio;
    private String tituloLibro;
    private LocalDate fecha;

    public PrestamoDTO() {
    }

    public PrestamoDTO(String nombreSocio, String tituloLibro, LocalDate fecha) {
        this.nombreSocio = nombreSocio;
        this.tituloLibro = tituloLibro;
        this.fecha = fecha;
    }

    public String getNombreSocio() {
        return nombreSocio;
    }
    public void setNombreSocio(String nombreSocio) {
        this.nombreSocio = nombreSocio;
    }
    public String getTituloLibro() {
        return tituloLibro;
    }
    public void setTituloLibro(String tituloLibro) {
        this.tituloLibro = tituloLibro;
    }
    public LocalDate getFecha() {
        return fecha;
    }
    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    
    
}

