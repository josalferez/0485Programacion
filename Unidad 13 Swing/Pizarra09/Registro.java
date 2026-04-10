package Pizarra09;

import javax.swing.*;
import java.awt.event.*;

public class Registro extends JFrame implements ActionListener {

    private JTextField txtUsuario;
    private JPasswordField txtPassword;
    private JPasswordField txtConfirmarPassword;
    private JButton btnRegistrar;
    private JButton btnVolver;

    public Registro() {
        setTitle("Registro de Usuario");
        setSize(350, 280);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel lblUsuario = new JLabel("Usuario:");
        lblUsuario.setBounds(30, 30, 140, 25);
        add(lblUsuario);

        txtUsuario = new JTextField();
        txtUsuario.setBounds(180, 30, 120, 25);
        add(txtUsuario);

        JLabel lblPassword = new JLabel("Contraseña:");
        lblPassword.setBounds(30, 70, 140, 25);
        add(lblPassword);

        txtPassword = new JPasswordField();
        txtPassword.setBounds(180, 70, 120, 25);
        add(txtPassword);

        JLabel lblConfirmarPassword = new JLabel("Confirmar Contraseña:");
        lblConfirmarPassword.setBounds(30, 110, 140, 25);
        add(lblConfirmarPassword);

        txtConfirmarPassword = new JPasswordField();
        txtConfirmarPassword.setBounds(180, 110, 120, 25);
        add(txtConfirmarPassword);

        btnRegistrar = new JButton("Registrarse");
        btnRegistrar.setBounds(40, 170, 110, 30);
        btnRegistrar.addActionListener(this);
        add(btnRegistrar);

        btnVolver = new JButton("Volver");
        btnVolver.setBounds(180, 170, 110, 30);
        btnVolver.addActionListener(this);
        add(btnVolver);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnRegistrar) {
            String usuario = txtUsuario.getText();
            String password = new String(txtPassword.getPassword());
            String confirmarPassword = new String(txtConfirmarPassword.getPassword());

            if (usuario.isEmpty() || password.isEmpty() || confirmarPassword.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
            } else if (!password.equals(confirmarPassword)) {
                JOptionPane.showMessageDialog(this, "Las contraseñas no coinciden.", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Usuario '" + usuario + "' registrado correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                // Opcional: Cerrar la ventana de registro y volver al Login
                volverAlLogin();
            }
        } 
        
        if (e.getSource() == btnVolver) {
            volverAlLogin();
        }
    }

    private void volverAlLogin() {
        Login login = new Login();
        login.setSize(350, 250); 
        login.setVisible(true);
        login.setLocationRelativeTo(null); 
        login.setResizable(false); 
        login.setTitle("Inicio de Sesión");
        this.dispose(); // Cierra la ventana de registro
    }

    public static void main(String[] args) {
        Registro registro = new Registro();
        registro.setVisible(true);
    }
}
