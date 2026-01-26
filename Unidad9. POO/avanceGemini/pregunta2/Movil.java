public abstract class Movil implements Configurable {
    private String marca, modelo;
    private int capacidad;
    private double pvp;
    private static int totalMoviles = 0;
    private Gama gama;

    // Método abstracto
    public abstract void encender();
    
    public Movil(String marca, String modelo, int capacidad, double pvp, Gama gama) {
        this.marca = marca;
        this.modelo = modelo;
        this.capacidad = capacidad;
        this.pvp = pvp;
        incrementarTotalMoviles(); // incremento con un método estático la variable estática totalMoviles
        this.gama = gama;
    }

    public double getPvp() {
        return pvp;
    }

    public String getModelo() {
        return modelo;
    }

    public void setPvp(double pvp) {
        if (pvp > 0) {
            this.pvp = pvp;
        } else {
            System.out.println("El pvp debe ser mayor que 0");
        }
    }

    public void mostrarDatos() {
        System.out.println("Marca: " + marca + " Modelo: " + modelo + " Capacidad: " + capacidad + " PVP: " + pvp);
    }

    public boolean esGamaAlta(){
        return (pvp > 900);
    }

    public void coompararPrecioMoviles(Movil otroMovil){
        if (this.pvp > otroMovil.pvp){
            this.mostrarDatos();
            System.out.println("Es más caro que: ");
            otroMovil.mostrarDatos();
        } else {
            otroMovil.mostrarDatos();
            System.out.println("Es más caro que: ");
            this.mostrarDatos();
        }
    }

    public static int getTotalMoviles(){
        return totalMoviles;
    }

    // Incremento con un método estático la variable estática totalMoviles
    public static void incrementarTotalMoviles(){
        totalMoviles++;
    }

    // Implemento el método de la interfaz configurable  Podría no haberlo implementado aquí
    @Override
    public void resetearFabrica(){
        System.out.println("Móvil reseteado de fábrica");
    }
}
