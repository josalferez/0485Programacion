
public class Bote {
    private String variedad;
    private int contenidoActual;

    public Bote(String variedad, int contenido){
        this.variedad = variedad;
        this.contenidoActual = contenido;
    }

    public void informe(){
        System.out.println("El bote de café tiene una variedad" 
        + this.variedad + " y le quedan " + this.contenidoActual 
        + " gramos." ) ;
    }

    public String getVariedad() {
        return variedad;
    }

    public void setVariedad(String variedad) {
        this.variedad = variedad;
    }

    public int getContenidoActual() {
        return contenidoActual;
    }

    public void setContenidoActual(int contenidoActual) {
        this.contenidoActual = contenidoActual;
    }
}
