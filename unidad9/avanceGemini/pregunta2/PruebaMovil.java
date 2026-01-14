
public class PruebaMovil {
    public static void main(String[] args) {
        Movil samsung = new MovilSegundaMano("Samsung ", "Galaxy A56 ", 512, 350,"regular", Gama.MEDIA);
        Movil iphone = new MovilSegundaMano("iPhone ", "16 Pro Max ", 512, 1350, "bueno", Gama.ALTA);

        samsung.mostrarDatos();
        iphone.mostrarDatos();

        // Subo el precio al iPhone
        iphone.setPvp(1400);
        iphone.mostrarDatos();
        System.out.println("El nuevo precio del modelo " + iphone.getModelo() + " es " + iphone.getPvp() + " euros");

        if (iphone.esGamaAlta()){
            System.out.println("El modelo " + iphone.getModelo() + " es de gama alta");
        }

        samsung.coompararPrecioMoviles(iphone);

        // Creo un movil de segunda mano y muestro sus datos
        MovilSegundaMano google = new MovilSegundaMano("Google", "Pixel", 256, 1200, "nuevo",Gama.ALTA);
        google.mostrarDatos();

        // Creo un movil de segunda mano y muestro sus datos
        MovilSegundaMano google2 = new MovilSegundaMano("Google", "Pixel", 256, 650, "usado", Gama.ALTA);
        google2.mostrarDatos();

        // Imprimimos el número total de móviles creados
        System.out.println("El numero total de móviles creados es: " + Movil.getTotalMoviles());

        // Creo un array de 3 teléfonos
        Movil[] arrayTelefonos = new Movil[3];

        arrayTelefonos[0] = samsung;
        arrayTelefonos[1] = google; 
        arrayTelefonos[2] = google2;

        // Muestro los datos de cada teléfono
        System.out.println("");
        System.out.println("");
        for(Movil telefono : arrayTelefonos){
            telefono.mostrarDatos();
        }

    }
}
