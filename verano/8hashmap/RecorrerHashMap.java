
import java.util.HashMap;
import java.util.Map;

public class RecorrerHashMap {

    public static void main(String[] args) {
        Map<String, Integer> agenda = new HashMap<>();

        agenda.put("Pepe Alferez", 625804115);
        agenda.put("Ana Garcia", 665228901);
        agenda.put("Luis Ramos", 610998765);

        // Recorremos el HashMap usando entrySet()
        for (Map.Entry<String, Integer> entrada : agenda.entrySet()) {
            // entry.getKey() para la clave y entry.getValue() para el valor
            System.out.println("Nombre: " + entrada.getKey() + ", Teléfono: " + entrada.getValue());
        }

        // Busco Ana Garcia en nuestro HashMap
        if (agenda.containsKey("Ana Garcia")) {
            System.out.println("Nombre: Ana García" + ", Teléfono: " + agenda.get("Ana Garcia"));
        } else {
            System.out.println("Ana García no está en la lista");
        }
    }
}
