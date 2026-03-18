public class Neumatico {
    private TipoNeumatico tipo;
    private double psi;
    
    // Constructor
    public Neumatico(TipoNeumatico tipo, double psi) {
        this.tipo = tipo;
        this.psi = psi;
    }

    public void mostrarEstado(){
        System.out.println(this.tipo.name() + "- Presión actual:  " + this.psi + " PSI");
    }

    public double getPsi() {
        return psi;
    }

    
}
