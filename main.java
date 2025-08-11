import java.awt.Color;
import javax.swing.*;

public class main extends JFrame{

    private JTextField valor1, valor2;
    private JButton boton1;
    private JLabel resultado, etiqueta1, etiqueta2;
    private JComboBox menu;

    // Declaración de los nuevos componentes
    private JRadioButton radioBoton1, radioBoton2;
    private JCheckBox checkCasilla1, checkCasilla2, checkCasilla3;
    private ButtonGroup grupoRadioBotones;

    // Creamos el constructor
    public main(){
        setLayout(null);
        setTitle("Formulario 8");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Creamos la etiqueta1 y la añadimos al JFrame
        etiqueta1 = new JLabel("Valor 1: ");
        etiqueta1.setBounds(10,10,80,30);
        add(etiqueta1);

        // Creamos la etiqueta2 y la añadimos al JFrame
        etiqueta2 = new JLabel("Valor 2: ");
        etiqueta2.setBounds(10,50,80,30);
        add(etiqueta2);

        // Creamos el campo 1 y lo añadimos al JFrame
        valor1 = new JTextField("");
        valor1.setBounds(60,10,150,30);
        add(valor1);

        // Creamos el campo 2 y lo añadimos al JFrame
        valor2 = new JTextField("");
        valor2.setBounds(60,50,150,30);
        add(valor2);

        // Creo el JComboBox y lo añado al JFrame
        menu = new JComboBox();
        menu.setBounds(250,10,100,20);
        menu.addItem("Sumar");
        menu.addItem("Restar");
        menu.addItem("Multiplicar");
        menu.addItem("Dividir");
        add(menu);

        // Creamos la Resultado y la añadimos al JFrame
        resultado = new JLabel("Resultado: ");
        resultado.setBounds(10,90,100,30);
        add(resultado);
        resultado.setVisible(false);

        // Vamos con el botón Calcular
        boton1 = new JButton("Calcular");
        boton1.setBounds(250,110,100,30);
        add(boton1);
        boton1.addActionListener(e -> {
            try {
                String operacion = menu.getSelectedItem().toString();
                switch (operacion) {
                    case "Sumar":
                        float suma = (Float.parseFloat(valor1.getText())) + (Float.parseFloat(valor2.getText()));
                        resultado.setVisible(true);
                        resultado.setText("Resultado: " + suma);
                        break;
                    case "Restar":
                        float resta = (Float.parseFloat(valor1.getText())) - (Float.parseFloat(valor2.getText()));
                        resultado.setVisible(true);
                        resultado.setText("Resultado: " + resta);
                        break;
                    case "Multiplicar":
                        float multiplicar = (Float.parseFloat(valor1.getText())) * (Float.parseFloat(valor2.getText()));
                        resultado.setVisible(true);
                        resultado.setText("Resultado: " + multiplicar);
                        break;
                    case "Dividir":
                        if ((Float.parseFloat(valor2.getText())) != 0) {
                            float dividir = (Float.parseFloat(valor1.getText())) / (Float.parseFloat(valor2.getText()));
                            resultado.setVisible(true);
                            resultado.setText("Resultado: " + dividir);
                        } else {
                            JOptionPane.showMessageDialog(this,"El divisor no puede ser 0", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                        break;
                }

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this,"Introduce solo números", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        // ------------------------------------
        // -- Inicio de JRadioButtons y JCheckBoxes --
        // ------------------------------------

        // JRadioButtons
        grupoRadioBotones = new ButtonGroup();
        radioBoton1 = new JRadioButton("Radio 1");
        radioBoton1.setBounds(10, 150, 80, 20);
        radioBoton2 = new JRadioButton("Radio 2");
        radioBoton2.setBounds(100, 150, 80, 20);

        grupoRadioBotones.add(radioBoton1);
        grupoRadioBotones.add(radioBoton2);

        add(radioBoton1);
        add(radioBoton2);

        // JCheckBoxes
        checkCasilla1 = new JCheckBox("Opción A");
        checkCasilla1.setBounds(200, 150, 80, 20);
        checkCasilla2 = new JCheckBox("Opción B");
        checkCasilla2.setBounds(200, 170, 80, 20);
        checkCasilla3 = new JCheckBox("Opción C");
        checkCasilla3.setBounds(200, 190, 80, 20);

        add(checkCasilla1);
        add(checkCasilla2);
        add(checkCasilla3);

        // -- Fin de JRadioButtons y JCheckBoxes --
        // ------------------------------------

        // Creamos la barra de menú principal
        JMenuBar menuBar = new JMenuBar();
        JMenu herramientasMenu = new JMenu("Herramientas");
        JMenu opcionesSubMenu = new JMenu("Colores");
        JMenuItem configuracionItemRojo = new JMenuItem("Rojo");
        JMenuItem configuracionItemVerde = new JMenuItem("Verde");
        JMenuItem configuracionItemAzul = new JMenuItem("Azul");

        opcionesSubMenu.add(configuracionItemRojo);
        opcionesSubMenu.add(configuracionItemVerde);
        opcionesSubMenu.add(configuracionItemAzul);
        herramientasMenu.add(opcionesSubMenu);
        menuBar.add(herramientasMenu);
        setJMenuBar(menuBar);

        configuracionItemRojo.addActionListener ( e-> getContentPane().setBackground(Color.red));
        configuracionItemVerde.addActionListener ( e-> getContentPane().setBackground(Color.green));
        configuracionItemAzul.addActionListener ( e-> getContentPane().setBackground(Color.lightGray));

        // Hago visible el JFrame
        setVisible(true);
        setLocationRelativeTo(null);
        setBounds(400,100,450,450);
    }

    public static void main(String[] args) {
        new main();
    }
}