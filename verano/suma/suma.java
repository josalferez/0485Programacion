package suma;

public class suma {

    // Variables de la clase
    private int vUno, vDos, Resultado;

    // Declaramos el constructor de la clase
    public suma(int valorUno, int valorDos){
        this.vUno = valorUno;
        this.vDos = valorDos;
    }
    
    // Declaro el método imprimirResultado
    public void imprimirResultado(){

        this.Resultado = this.vUno + this.vDos;
        
        System.out.println("El resultado de la suma es: " + this.Resultado);
    }
}
