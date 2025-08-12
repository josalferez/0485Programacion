
import java.awt.Color;
import java.util.Arrays;
import javax.swing.*;

public class acceso extends JFrame {

    private String usuario = "jose";
    private String password = "12";
    private JLabel etiquetaUsuario;
    private JLabel etiquetaPassword;
    private JTextField textoUsuario;
    private JPasswordField textoPassword;
    private JButton botonAceptar;
    private ImageIcon logo;
    private JLabel imagenLogo;

    public acceso() {
        // Posiciono los componentes de este constructor de forma manual
        setLayout(null);

        // Añado los dos JLabel y el JTextField
        etiquetaUsuario = new JLabel("Usuario: ");
        etiquetaUsuario.setBounds(130, 250, 100, 60);
        etiquetaUsuario.setForeground(Color.WHITE);
        add(etiquetaUsuario);

        etiquetaPassword = new JLabel("Contraseña: ");
        etiquetaPassword.setBounds(130, 280, 100, 60);
        etiquetaPassword.setForeground(Color.WHITE);
        add(etiquetaPassword);

        textoUsuario = new JTextField();
        textoUsuario.setBounds(220, 260, 150, 30);
        add(textoUsuario);

        textoPassword = new JPasswordField();
        textoPassword.setBounds(220, 290, 150, 30);
        add(textoPassword);

        // Creo el botón que acepta el usuario y la contraseña
        botonAceptar = new JButton("Validar");
        botonAceptar.setBounds(160, 350, 90, 30);
        add(botonAceptar);

        // Le doy la funcionalidad al botón
        botonAceptar.addActionListener(e -> {
            
            if (textoUsuario.getText().equals(usuario)) {
                char[] contrasenaCorrectaArray = password.toCharArray();
                char[] contrasenaIngresadaArray = textoPassword.getPassword();
                if (Arrays.equals(contrasenaIngresadaArray, contrasenaCorrectaArray)){
                    //Cierro la ventana actual y cargo la nueva ventana. 
                    dispose();
                    new main();
                } else {
                    JOptionPane.showMessageDialog(this,"La contraseña no es correcta", "Error", JOptionPane.ERROR_MESSAGE);   
                    textoPassword.requestFocusInWindow(); 
                    textoPassword.setText("");
                }
            } else {
                JOptionPane.showMessageDialog(this,"Por favor, introduzca un usuario correcto", "Error", JOptionPane.ERROR_MESSAGE);
                textoUsuario.requestFocusInWindow();
                textoUsuario.setText("");
            }
            
        });

        // Creo la imagen de logo y la posiciono sobre el texto de usuario/pass
        logo = new ImageIcon("Proyecto/images/logo.jpg");
        imagenLogo = new JLabel(logo);
        // Voy a poner la imagen centrada
        // Obtiene el ancho de la imagen
        int anchoImagen = logo.getIconWidth();
        // Calcula la posición X para centrarla
        int posicionX = (450 - anchoImagen) / 2;
        // Establece la nueva posición
        imagenLogo.setBounds(posicionX, 10, anchoImagen, logo.getIconHeight());
        add(imagenLogo);

        setVisible(true);
        setLocationRelativeTo(null);
        setBounds(400, 100, 450, 450);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(0x1f2b37));

        // Pongo un favicon en mi aplicación
        ImageIcon favicon = new ImageIcon("Proyecto/images/favicon.jpg");
        setIconImage(favicon.getImage());

    }

    public static void main(String[] args) {
        new acceso();
    }

}
