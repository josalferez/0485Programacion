public class PruebaAnimal {
    public static void main(String[] args) {

        Animal leo = new Leon(TipoDieta.CARNIVORO, 5, "Simba");
        Animal firulais = new Perro(TipoDieta.CARNIVORO, 2, "Firulais");

        Animal[] misAnimales = new Animal[2];

        misAnimales[0] = leo;
        misAnimales[1] = firulais;

        for (Animal animal : misAnimales) {
            animal.hacerSonido();
            if (animal instanceof Adoptable) {
                ((Adoptable) animal).serAdoptado();
            }
        }
    }
}
