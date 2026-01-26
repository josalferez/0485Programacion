public class Procesador extends Componente{
    private int numNucleos;

    public Procesador(int numNucleos, String modelo, String numeroSerie, double precioBase) {
        super(modelo, numeroSerie, precioBase);
        this.numNucleos = numNucleos;
    }

   
    @Override
    public void imprimirDetalles(){
        System.out.println("El procesador tiene " + numNucleos + " núcleos.");
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + numNucleos;
        return result;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        Procesador other = (Procesador) obj;
        if (numNucleos != other.numNucleos)
            return false;
        return true;
    }




}