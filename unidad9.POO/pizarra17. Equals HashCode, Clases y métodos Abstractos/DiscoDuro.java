public class DiscoDuro extends Componente {
    private int capacidadGB;

    public DiscoDuro(int capacidadGB, String modelo, String numeroSerie, double precioBase) {
        super(modelo, numeroSerie, precioBase);
        this.capacidadGB = capacidadGB;
    }

    @Override
    public void imprimirDetalles() {
        System.out.println("El Disco duro tiene " + capacidadGB + " GB.");
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + this.capacidadGB;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final DiscoDuro other = (DiscoDuro) obj;
        return this.capacidadGB == other.capacidadGB;
    }

 

}