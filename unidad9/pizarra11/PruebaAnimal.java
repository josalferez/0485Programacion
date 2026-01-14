public class PruebaAnimal {
    public static void main(String[] args) {
        
        Gato lena = new Gato(Sexo.HEMBRA,"british shortair");
        Gato lisa = new Gato();

        // Utilizo en Gato el método del padre
        lena.duerme(); // Método del padre

        // Utilizo un método del hijo
        lena.maulla();

        // Uso otro método del hijo
        lena.peleaCon(lisa);

        //Lena come
        lena.come("pienso");

        Animal animalGenerico = new Animal();
        System.out.println(animalGenerico);
        animalGenerico.duerme();




      

    }
}
