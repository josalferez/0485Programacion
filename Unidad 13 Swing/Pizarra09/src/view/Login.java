package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;

// Importamos la lógica de datos
import dao.UsuarioDAO;
import dao.UsuarioDAOImpl;

public class Login extends JFrame implements ActionListener {

    // Componentes de la interfaz
    private JTextField txtUsuario;
    private JPasswordField txtPassword;
    private JButton btnLogin, btnRegistro, btnOlvidado;

    public Login() {
        // Configuración de la ventana
        setTitle("Gestión Académica - Acceso");
        setSize(350, 320);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        // --- Etiqueta y Campo Usuario ---
        JLabel lblUsuario = new JLabel("Usuario:");
        lblUsuario.setBounds(50, 30, 80, 25);
        add(lblUsuario);

        txtUsuario = new JTextField();
        txtUsuario.setBounds(130, 30, 150, 25);
        add(txtUsuario);

        // --- Etiqueta y Campo Contraseña ---
        JLabel lblPassword = new JLabel("Contraseña:");
        lblPassword.setBounds(50, 70, 80, 25);
        add(lblPassword);

        txtPassword = new JPasswordField();
        txtPassword.setBounds(130, 70, 150, 25);
        add(txtPassword);

        // --- Botón Iniciar Sesión ---
        btnLogin = new JButton("Iniciar Sesión");
        btnLogin.setBounds(90, 120, 160, 35);
        btnLogin.setBackground(new Color(41, 128, 185)); // Azul elegante
        btnLogin.setForeground(Color.WHITE);
        btnLogin.setFocusPainted(false);
        btnLogin.addActionListener(this);
        add(btnLogin);

        // --- Botón Crear Cuenta ---
        btnRegistro = new JButton("Crear Cuenta");
        btnRegistro.setBounds(90, 170, 160, 30);
        btnRegistro.addActionListener(this);
        add(btnRegistro);

        // --- Botón "¿Olvidó su contraseña?" ---
        btnOlvidado = new JButton("¿Olvidó su contraseña?");
        btnOlvidado.setBounds(75, 220, 190, 20);
        btnOlvidado.setBorderPainted(false);
        btnOlvidado.setContentAreaFilled(false);
        btnOlvidado.setForeground(Color.GRAY);
        btnOlvidado.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnOlvidado.addActionListener(this);
        add(btnOlvidado);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnLogin) {
            ejecutarLogin();
        } 
        
        if (e.getSource() == btnRegistro) {
            // Abrir ventana de registro 
            Registro reg = new Registro();
            reg.setVisible(true);
        }

        if (e.getSource() == btnOlvidado) {
            JOptionPane.showMessageDialog(this, 
                "Por favor, contacte con soporte técnico para recuperar su acceso.", 
                "Recuperación", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    /**
     * Método que conecta la vista con el DAO
     */
    private void ejecutarLogin() {
        String user = txtUsuario.getText();
        String pass = new String(txtPassword.getPassword());

        // Validaciones básicas de cliente
        if (user.isEmpty() || pass.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, rellene todos los campos.");
            return;
        }

        // Instanciamos el DAO para consultar la base de datos
        UsuarioDAO usuarioDAO = new UsuarioDAOImpl();

        try {
            // Llamada al método que ejecuta el SELECT
            boolean esValido = usuarioDAO.validar(user, pass);

            if (esValido) {
                // Éxito: Abrimos Principal y cerramos Login
                Principal p = new Principal();
                p.setVisible(true);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, 
                    "Usuario o contraseña incorrectos", 
                    "Acceso Denegado", JOptionPane.ERROR_MESSAGE);
            }

        } catch (SQLException ex) {
            // Error de conexión o de SQL
            JOptionPane.showMessageDialog(this, 
                "Error al conectar con la base de datos:\n" + ex.getMessage(), 
                "Error de Sistema", JOptionPane.ERROR_MESSAGE);
        }
    }
}