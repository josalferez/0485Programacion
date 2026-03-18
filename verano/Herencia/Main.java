public class Main {

    public static void main(String[] args) {
        Perro miPerro = new Perro();

        miPerro.setNombre("Toby");
        miPerro.setEdad(5);
    
        miPerro.ladrar();

        miPerro.amamantar();

        miPerro.moverse(); // Sobreescritura de métodos
    
        // Instancio el pez y lo hago moverse

        Pez miPez = new Pez();
        miPez.nadar();
    
        Perro.saltar();
    }
    
    
}
