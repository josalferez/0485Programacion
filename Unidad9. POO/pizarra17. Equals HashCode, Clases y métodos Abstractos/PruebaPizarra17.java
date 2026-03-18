
import java.util.ArrayList;

public class PruebaPizarra17 {
    public static void main(String[] args) {
        ArrayList<Componente> stock = new ArrayList<>();

        Procesador pr1 = new Procesador(4, "Intel i7", "ABC-123", 80);
        DiscoDuro d1 = new DiscoDuro(512, "Kingston", "ABC-123", 85);

        // 1. Añado los dos componentes al arrayList pero antes valido duplicados
        if (stock.contains(pr1))
            System.out.println("El procesador ya esta en el stoc");
        else
            stock.add(pr1);

        if (stock.contains(d1))
            System.out.println("El procesador ya esta en el stoc");
        else
            stock.add(d1);

        // Imprimo el arrayList
        for (Componente c : stock) {
            System.out.println(c);
        }

        // 2. Comparación Secuencial. Recorro el ArrayList y comparo si
        // actual es igual a siguiente
        Componente anterior = null;
        for (Componente actual : stock) {
            if(actual.equals(anterior))
                System.out.println("Son iguales");
            anterior = actual;
        }

    }
}
