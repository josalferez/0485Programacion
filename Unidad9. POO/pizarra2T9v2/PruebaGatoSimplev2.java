
public class PruebaGatoSimplev2 {
    public static void main(String[] args) {
        
        GatoSimplev2 lena = new GatoSimplev2("naranja", 5, 3, "Scottish Shorthair", "macho"); 
        GatoSimplev2 nara = new GatoSimplev2("blanco", 4, 3.5, "europeo común", "macho");

        // Imprimo la raza de mi gato
        System.out.println(lena.getRaza());

        // Modifico la raza de mi gato
        /*
        Scanner sc = new Scanner(System.in);
        System.out.print("Dime la raza de tu gato: ");
        lena.setRaza(sc.nextLine());
        // Cierro el Scanner
        sc.close();
        */

        // Imprimo la raza de mi gato
        System.out.println(nara.getRaza());

        // Vamos a ver si lena maulla
        lena.Maulla();

        // Lena ronronea
        lena.Ronronea();

        //Lena come
        lena.Come("habichuelas");

        // Lena pelea con otro gato.
        lena.peleaCon(nara);

        lena.setColor("marron");
        lena.setNombre("Lena");
        nara.setNombre("Nara");

        // Método toString
        System.out.println(lena);
        System.out.println(nara);

        
    }
}
