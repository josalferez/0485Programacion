package src.model;

import java.time.LocalDate;

public class Prestamo {
    private int socioId;
    private int libroId;
    private LocalDate fecha;
    
    public int getSocioId() {
        return socioId;
    }
    public void setSocioId(int socioId) {
        this.socioId = socioId;
    }
    public int getLibroId() {
        return libroId;
    }
    public void setLibroId(int libroId) {
        this.libroId = libroId;
    }
    public LocalDate getFecha() {
        return fecha;
    }
    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
    @Override
    public String toString() {
        return "Prestamo [socioId=" + socioId + ", libroId=" + libroId + ", fecha=" + fecha + "]";
    }

    
}
