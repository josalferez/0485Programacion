public class Cafetera {
    int cantidadCafe;
    int cantidadAgua;
    

    public Cafetera(){
        this.cantidadAgua = 0;
        this.cantidadCafe = 0;
    }

    public void rellenarAgua(){
        this.cantidadAgua += 2000;
    }

    public void cargarCafe(Bote boteExterno, int cantidad){
        this.cantidadCafe += boteExterno.getContenidoActual(); // Añado el café a mi cafetera
        boteExterno.setContenidoActual(boteExterno.getContenidoActual() - cantidad); // Actualizo la cantidad de café que queda en el bote

        System.out.println("Cargando " + cantidad + " de café " + boteExterno.getVariedad() + " en la cafetera...");
    }

    public void consultarEstado(){
        System.out.println("Los valores actuales de la cafetera son Café: " + this.cantidadCafe + " agua: " + this.cantidadAgua);
    }


}
