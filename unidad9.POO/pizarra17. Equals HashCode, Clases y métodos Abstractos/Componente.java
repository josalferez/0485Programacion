public abstract class Componente{
    String modelo;
    String numeroSerie;
    double precioBase;

    public Componente(String modelo, String numeroSerie, double precioBase) {
        this.modelo = modelo;
        this.numeroSerie = numeroSerie;
        this.precioBase = precioBase;
    }

    
    public abstract void imprimirDetalles();

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((modelo == null) ? 0 : modelo.hashCode());
        result = prime * result + ((numeroSerie == null) ? 0 : numeroSerie.hashCode());
        long temp;
        temp = Double.doubleToLongBits(precioBase);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Componente other = (Componente) obj;
        if (modelo == null) {
            if (other.modelo != null)
                return false;
        } else if (!modelo.equals(other.modelo))
            return false;
        if (numeroSerie == null) {
            if (other.numeroSerie != null)
                return false;
        } else if (!numeroSerie.equals(other.numeroSerie))
            return false;
        if (Double.doubleToLongBits(precioBase) != Double.doubleToLongBits(other.precioBase))
            return false;
        return true;
    }


    @Override
    public String toString() {
        return "Componente [modelo=" + modelo + ", numeroSerie=" + numeroSerie + ", precioBase=" + precioBase + "]";
    }

    


}