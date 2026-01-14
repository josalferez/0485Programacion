
import java.util.ArrayList;

enum TipoPizza {
    MARGARITA, PEPPERONI, HAWAINA, VEGETAL;


}

public class Main {

    public static void main(String[] args) {
        ArrayList<TipoPizza> pedidosDelDia = new ArrayList<TipoPizza>();

        // Creamos los pedidos
        pedidosDelDia.add(TipoPizza.MARGARITA);
        pedidosDelDia.add(TipoPizza.HAWAINA);
        pedidosDelDia.add(TipoPizza.VEGETAL);
        pedidosDelDia.add(TipoPizza.HAWAINA);
        pedidosDelDia.add(TipoPizza.PEPPERONI);

        // Imprimo los pedidos del arrayList
        for (TipoPizza elem : pedidosDelDia) {
            System.out.println(elem.name());
            
        }
    }
}