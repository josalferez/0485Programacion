package Pizarra09;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class Formulario extends JFrame implements ActionListener {

    private JMenuBar menubar;
    private JMenu menu1, menu2, menu3;
    private JMenuItem menuitem1, menuitem2, menuitem3, menuitem4;
    private JCheckBox check1, check2, check3;


    public Formulario() {
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Configuración de la barra de menú
        menubar = new JMenuBar();
        setJMenuBar(menubar);

        // Menú principal "Opciones"
        menu1 = new JMenu("Opciones");
        menubar.add(menu1);

        // Submenú 1: Tamaño de la ventana
        menu2 = new JMenu("Tamaño de la ventana");
        menu1.add(menu2);

        // Submenú 2: Color de fondo
        menu3 = new JMenu("Color de fondo");
        menu1.add(menu3);

        // Ítems para el tamaño de ventana (añadidos a menu2)
        menuitem1 = new JMenuItem("300*200");
        menu2.add(menuitem1);
        menuitem1.addActionListener(this);

        menuitem2 = new JMenuItem("640*480");
        menu2.add(menuitem2);
        menuitem2.addActionListener(this);

        // Ítems para el color de fondo (añadidos a menu3)
        menuitem3 = new JMenuItem("Rojo");
        menu3.add(menuitem3);
        menuitem3.addActionListener(this);

        menuitem4 = new JMenuItem("Verde");
        menu3.add(menuitem4);
        menuitem4.addActionListener(this);

        check1 = new JCheckBox("Hombre");
        check1.setBounds(10, 10, 150, 40);
        check1.addItemListener(e -> actualizarTitulo());
        add(check1);

        check2 = new JCheckBox("Mujer");
        check2.setBounds(10, 40, 150, 40);
        check2.addItemListener(e -> actualizarTitulo());
        add(check2);

        check3 = new JCheckBox("Sin definir");
        check3.setBounds(10, 70, 150, 40);
        check3.addItemListener(e -> actualizarTitulo());
        add(check3);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Eventos para cambiar el tamaño
        if (e.getSource() == menuitem1) {
            setSize(300, 200);
        }
        if (e.getSource() == menuitem2) {
            setSize(640, 480);
        }

        // Eventos para cambiar el color de fondo
        if (e.getSource() == menuitem3) {
            getContentPane().setBackground(new Color(255, 0, 0)); // Rojo
        }
        if (e.getSource() == menuitem4) {
            getContentPane().setBackground(new Color(0, 255, 0)); // Verde
        }
    }

    private void actualizarTitulo() {
        String cadena = "";

        if (check1.isSelected()) {
            cadena = cadena + "Hombre ";
        }
        if (check2.isSelected()) {
            cadena = cadena + "Mujer ";
        }
        if (check3.isSelected()) {
            cadena = cadena + "Sin definir ";
        }
        setTitle(cadena.trim());
    }

    public static void main(String[] args) {
        // El main ahora está en Main.java para iniciar con Login
    }
}