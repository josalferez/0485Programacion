public class CafeteraIndustrial extends Cafetera{
    
    // Atributos
    private int numeroPlatosCalientes;

    // Constructor 1
    public CafeteraIndustrial(int agua, int cafe, TipoCafe tipo, int numeroPlatos){
        super(agua, cafe, tipo);
        this.numeroPlatosCalientes = numeroPlatos;
    }

    // Método 1
    public void prepararBebidaGrande(){
      System.out.println("Sirviendo jarra tamaño familiar"); 
      // Hago dos servicios Simulando que echo dos cafés
      this.setAgua(this.getAgua() - 400); // Actualizo el agua
      this.setCafe(this.getCafe() - 40); // Actualizo el café
    }

}