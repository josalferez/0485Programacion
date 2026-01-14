
import java.awt.GridLayout;
import javax.swing.*;

public class CafeteriaFrame extends JFrame {

        private static int contadorPedidos = 0;

    public CafeteriaFrame(){
        setLayout(new GridLayout(0, 2)); // 0 filas (crece automáticamente), 2 columnas
        setTitle("Mi Cafetería");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800,600);
        setLocationRelativeTo(null);
        
        // Creo un cliente
        Cliente c1 = new Cliente("Juan", 1, "juan@prueba.com", 100);

        // Creo la etiqueta del contador de pedidos 
        JLabel etiquetaContadorPedidos = new JLabel("Pedido numero: " + getNumeroPedidos());
        add(etiquetaContadorPedidos);
        
        // Instanciamos café y te
        Cafe cafe1 = new Cafe("Grande", "Expreso", "Café Expreso", 3, 10);
        Te te1 = new Te("Té Verde", 2, 15, "Hoja Suelta", "Verde");

        // Creo la etiqueta del saldo
        JLabel etiquetaSaldo = new JLabel("El saldo de " + c1.getNombre() + " es: " + c1.getSaldo());
        add(etiquetaSaldo);
        
        // Creo las etiquetas del saldo y del café con stock y Precio
        JLabel etiquetaCafe = new JLabel(cafe1.getNombre() + " \n Stock: " + cafe1.getStock() + " \n Precio: " + cafe1.getPrecio() + " Euros");
        JLabel etiquetaTe = new JLabel(te1.getNombre() + " \n Stock: " + te1.getStock() + " \n Precio: " + te1.getPrecio() + " Euros");
        add(etiquetaCafe);
        add(etiquetaTe);
        

        // Creo y añado los botones
        JButton botonCafe = new JButton("Pagar Café");
        JButton botonTe = new JButton("Pagar Té");
        add(botonCafe);
        add(botonTe);

        botonTe.addActionListener(e -> {   
            te1.Pagar(c1, 1);
            etiquetaSaldo.setText("El saldo de " + c1.getNombre() + " es: " + c1.getSaldo());
            CafeteriaFrame.incrementaNumeroPedidos();
            etiquetaContadorPedidos.setText("Pedido numero: " + CafeteriaFrame.getNumeroPedidos());
            JOptionPane.showMessageDialog(this,"Compra de Té realizada");
        });

        botonCafe.addActionListener(e -> {
            cafe1.Pagar(c1, 1);
            etiquetaSaldo.setText("El saldo de " + c1.getNombre() + " es: " + c1.getSaldo());
            CafeteriaFrame.incrementaNumeroPedidos();
            etiquetaContadorPedidos.setText("Pedido numero: " + CafeteriaFrame.getNumeroPedidos());
            JOptionPane.showMessageDialog(this,"Compra de café realizada");
        });       
        
        setVisible(true);        
    }

    // Getter y Setter del contador de Pedidos
    public static int getNumeroPedidos(){
        return contadorPedidos;
    }

    public static void incrementaNumeroPedidos(){
        contadorPedidos ++;
    }

    public static void main(String[] args) {
        new CafeteriaFrame();
    }  
}
