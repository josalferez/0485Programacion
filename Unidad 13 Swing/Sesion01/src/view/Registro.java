package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import dao.UsuarioDAO;
import dao.UsuarioDAOImpl;
import dao.AlumnoDAO;
import dao.AlumnoDAOImpl;
import dao.ProfesorDAO;
import dao.ProfesorDAOImpl;
import model.Usuario;
import model.Alumno;
import model.Profesor;

public class Registro extends JFrame implements ActionListener {

    private JTextField txtNombre, txtDNI, txtEmail;
    private JPasswordField txtPassword, txtConfirmar;
    private JComboBox<String> comboRol;
    private JButton btnRegistrar, btnCancelar;

    public Registro() {
        setTitle("Gestión Académica - Registro de Usuario");
        setSize(400, 500);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);

        int lblX = 50, txtX = 160, width = 180, height = 25;

        // Nombre y Apellidos
        JLabel lblNombre = new JLabel("Nombre y Apell.:");
        lblNombre.setBounds(lblX, 30, 100, height);
        add(lblNombre);

        txtNombre = new JTextField();
        txtNombre.setBounds(txtX, 30, width, height);
        add(txtNombre);

        // DNI (Será el nombre de usuario)
        JLabel lblDNI = new JLabel("DNI (Usuario):");
        lblDNI.setBounds(lblX, 75, 100, height);
        add(lblDNI);

        txtDNI = new JTextField();
        txtDNI.setBounds(txtX, 75, width, height);
        add(txtDNI);

        // Email
        JLabel lblEmail = new JLabel("Email:");
        lblEmail.setBounds(lblX, 120, 100, height);
        add(lblEmail);

        txtEmail = new JTextField();
        txtEmail.setBounds(txtX, 120, width, height);
        add(txtEmail);

        // Contraseña
        JLabel lblPass = new JLabel("Contraseña:");
        lblPass.setBounds(lblX, 165, 100, height);
        add(lblPass);

        txtPassword = new JPasswordField();
        txtPassword.setBounds(txtX, 165, width, height);
        add(txtPassword);

        // Confirmar Contraseña
        JLabel lblConf = new JLabel("Confirmar:");
        lblConf.setBounds(lblX, 210, 100, height);
        add(lblConf);

        txtConfirmar = new JPasswordField();
        txtConfirmar.setBounds(txtX, 210, width, height);
        add(txtConfirmar);

        // Rol
        JLabel lblRol = new JLabel("Rol:");
        lblRol.setBounds(lblX, 255, 100, height);
        add(lblRol);

        comboRol = new JComboBox<>(new String[]{"alumno", "profesor"});
        comboRol.setBounds(txtX, 255, width, height);
        add(comboRol);

        // Botones
        btnRegistrar = new JButton("Registrar");
        btnRegistrar.setBounds(70, 330, 120, 35);
        btnRegistrar.setBackground(new Color(46, 204, 113));
        btnRegistrar.setForeground(Color.WHITE);
        btnRegistrar.addActionListener(this);
        add(btnRegistrar);

        btnCancelar = new JButton("Cancelar");
        btnCancelar.setBounds(210, 330, 120, 35);
        btnCancelar.addActionListener(this);
        add(btnCancelar);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnCancelar) {
            this.dispose();
        }

        if (e.getSource() == btnRegistrar) {
            ejecutarRegistro();
        }
    }

    private void ejecutarRegistro() {
        String nombre = txtNombre.getText();
        String dni = txtDNI.getText();
        String email = txtEmail.getText();
        String pass = new String(txtPassword.getPassword());
        String conf = new String(txtConfirmar.getPassword());
        String rol = (String) comboRol.getSelectedItem();

        if (nombre.isEmpty() || dni.isEmpty() || email.isEmpty() || pass.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Rellene todos los campos.");
            return;
        }

        if (!pass.equals(conf)) {
            JOptionPane.showMessageDialog(this, "Las contraseñas no coinciden.");
            return;
        }

        Usuario nuevoUsuario = new Usuario();
        nuevoUsuario.setUsername(dni);
        nuevoUsuario.setEmail(email);
        nuevoUsuario.setPassword(pass);
        nuevoUsuario.setRol(rol);

        try {
            if (rol.equals("alumno")) {
                Alumno nuevoAlumno = new Alumno(nombre, email);
                AlumnoDAO alumnoDAO = new AlumnoDAOImpl();
                int idAlumno = alumnoDAO.insertar(nuevoAlumno);
                nuevoUsuario.setAlumnoId(idAlumno);
            } else if (rol.equals("profesor")) {
                Profesor nuevoProfesor = new Profesor(nombre, email);
                ProfesorDAO profesorDAO = new ProfesorDAOImpl();
                int idProfesor = profesorDAO.insertar(nuevoProfesor);
                nuevoUsuario.setProfesorId(idProfesor);
            }

            UsuarioDAO usuarioDAO = new UsuarioDAOImpl();
            usuarioDAO.registrar(nuevoUsuario);
            
            JOptionPane.showMessageDialog(this, "Usuario y " + rol + " registrados con éxito.");
            this.dispose();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error al registrar: " + ex.getMessage());
        }
    }
    // Añadimos el método main para poder ejecutar la interfaz desde aquí
    // y probarla sin necesidad de ejecutar el login
    public static void main(String[] args) {
        // Iniciamos la interfaz en el hilo de despacho de eventos
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Registro frame = new Registro();
                // Opcional: Cambiamos el comportamiento de cierre solo para esta prueba
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }

}
