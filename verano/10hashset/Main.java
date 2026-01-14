import java.util.HashSet;

public class Main{

    public static void main(String[] args) {
        

        HashSet<String> agenda = new HashSet<>();

        agenda.add("Ana Alferez");
        agenda.add("Jose Alferez");
        agenda.add("Pepe Alferez");
        agenda.add("Pepe Alferez");

        System.out.println(agenda);

        if (agenda.contains("Jose Alferez")) {
            System.out.println("Jose Alferez está en el HashSet");
        } else {
            System.out.println("Jose Alferez no está en el HashSet");
        }

        // Lo borramos
        //agenda.clear();

        agenda.remove("Jose Alferez");    
        
        if (agenda.contains("Jose Alferez")) {
            System.out.println("Jose Alferez está en el HashSet");
        } else {
            System.out.println("Jose Alferez no está en el HashSet");
        }

        System.out.println(agenda);

        for ( String elem : agenda) {
            System.out.println(elem);
        }

        agenda.clear();


    }
}