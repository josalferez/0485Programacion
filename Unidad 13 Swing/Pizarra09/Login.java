package Pizarra09;

import javax.swing.*;
import java.awt.event.*;

public class Login extends JFrame implements ActionListener {

    private JTextField txtUsuario;
    private JPasswordField txtPassword;
    private JButton btnLogin;

    public Login() {
        setTitle("Login");
        setSize(300, 250);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel lblUsuario = new JLabel("Usuario:");
        lblUsuario.setBounds(50, 30, 80, 25);
        add(lblUsuario);

        txtUsuario = new JTextField();
        txtUsuario.setBounds(130, 30, 120, 25);
        add(txtUsuario);

        JLabel lblPassword = new JLabel("Contraseña:");
        lblPassword.setBounds(50, 70, 80, 25);
        add(lblPassword);

        txtPassword = new JPasswordField();
        txtPassword.setBounds(130, 70, 120, 25);
        add(txtPassword);

        btnLogin = new JButton("Iniciar Sesión");
        btnLogin.setBounds(90, 120, 120, 30);
        btnLogin.addActionListener(this);
        add(btnLogin);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnLogin) {
            String usuario = txtUsuario.getText();
            String password = new String(txtPassword.getPassword());

            if (usuario.equals("admin") && password.equals("1234")) {
                // Credenciales correctas, abrir Formulario y cerrar Login
                // 2. Si el login tiene exito, lanzo la segunda ventana.
                Formulario formulario = new Formulario();

                formulario.setSize(800, 640); // Ancho y alto del formulario. No del label
                formulario.setVisible(true);
                formulario.setLocationRelativeTo(null); // Lo posiciona en el centro
                                                         // El setLocation... siempre va después del setVisible
                formulario.setResizable(false); // No deja al usuairo cambiar el tamaño de la pantalla.
                formulario.setTitle("Formulario");
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Usuario o contraseña incorrectos", "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static void main(String[] args) {
        Login login = new Login();
        login.setVisible(true);
    }
}
