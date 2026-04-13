package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import dao.UsuarioDAO;
import dao.UsuarioDAOImpl;
import dao.AlumnoDAOImpl;
import dao.ProfesorDAOImpl;
import model.Usuario;
import model.Alumno;
import model.Profesor;

public class Registro extends JFrame implements ActionListener {

    private JTextField txtNombre, txtApellidos, txtDNI, txtEmail;
    private JPasswordField txtPassword, txtConfirmar;
    private JComboBox<String> comboRol;
    private JLabel lblExtra1, lblExtra2;
    private JTextField txtExtra1, txtExtra2;
    private JButton btnRegistrar, btnCancelar;

    public Registro() {
        setTitle("Gestión Académica - Registro de Usuario Pro");
        setSize(450, 600);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);

        int lblX = 50, txtX = 180, width = 200, height = 25;
        int y = 30;

        // Nombre
        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setBounds(lblX, y, 100, height);
        add(lblNombre);

        txtNombre = new JTextField();
        txtNombre.setBounds(txtX, y, width, height);
        add(txtNombre);
        y += 40;

        // Apellidos
        JLabel lblApellidos = new JLabel("Apellidos:");
        lblApellidos.setBounds(lblX, y, 100, height);
        add(lblApellidos);

        txtApellidos = new JTextField();
        txtApellidos.setBounds(txtX, y, width, height);
        add(txtApellidos);
        y += 40;

        // DNI (Será el nombre de usuario)
        JLabel lblDNI = new JLabel("DNI (Username):");
        lblDNI.setBounds(lblX, y, 120, height);
        add(lblDNI);

        txtDNI = new JTextField();
        txtDNI.setBounds(txtX, y, width, height);
        add(txtDNI);
        y += 40;

        // Email
        JLabel lblEmail = new JLabel("Email:");
        lblEmail.setBounds(lblX, y, 100, height);
        add(lblEmail);

        txtEmail = new JTextField();
        txtEmail.setBounds(txtX, y, width, height);
        add(txtEmail);
        y += 40;

        // Contraseña
        JLabel lblPass = new JLabel("Contraseña:");
        lblPass.setBounds(lblX, y, 100, height);
        add(lblPass);

        txtPassword = new JPasswordField();
        txtPassword.setBounds(txtX, y, width, height);
        add(txtPassword);
        y += 40;

        // Confirmar Contraseña
        JLabel lblConf = new JLabel("Confirmar:");
        lblConf.setBounds(lblX, y, 100, height);
        add(lblConf);

        txtConfirmar = new JPasswordField();
        txtConfirmar.setBounds(txtX, y, width, height);
        add(txtConfirmar);
        y += 40;

        // Rol
        JLabel lblRol = new JLabel("Rol:");
        lblRol.setBounds(lblX, y, 100, height);
        add(lblRol);

        comboRol = new JComboBox<>(new String[]{"alumno", "profesor"});
        comboRol.setBounds(txtX, y, width, height);
        comboRol.addActionListener(e -> updateExtraFields());
        add(comboRol);
        y += 40;

        // Campos Extra (Dependen del rol)
        lblExtra1 = new JLabel("Beca:");
        lblExtra1.setBounds(lblX, y, 100, height);
        add(lblExtra1);

        txtExtra1 = new JTextField();
        txtExtra1.setBounds(txtX, y, width, height);
        add(txtExtra1);
        y += 40;

        lblExtra2 = new JLabel("Promoción:");
        lblExtra2.setBounds(lblX, y, 100, height);
        add(lblExtra2);

        txtExtra2 = new JTextField();
        txtExtra2.setBounds(txtX, y, width, height);
        add(txtExtra2);
        y += 50;

        // Botones
        btnRegistrar = new JButton("Registrar");
        btnRegistrar.setBounds(80, y, 130, 40);
        btnRegistrar.setBackground(new Color(52, 152, 219));
        btnRegistrar.setForeground(Color.WHITE);
        btnRegistrar.addActionListener(this);
        add(btnRegistrar);

        btnCancelar = new JButton("Cancelar");
        btnCancelar.setBounds(230, y, 130, 40);
        btnCancelar.addActionListener(this);
        add(btnCancelar);

        updateExtraFields(); // Inicializar etiquetas
    }

    private void updateExtraFields() {
        String rol = (String) comboRol.getSelectedItem();
        if ("alumno".equals(rol)) {
            lblExtra1.setText("Beca:");
            lblExtra2.setText("Promoción:");
        } else {
            lblExtra1.setText("Departamento:");
            lblExtra2.setText("Especialidad:");
        }
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
        String apellidos = txtApellidos.getText();
        String dni = txtDNI.getText();
        String email = txtEmail.getText();
        String pass = new String(txtPassword.getPassword());
        String conf = new String(txtConfirmar.getPassword());
        String rol = (String) comboRol.getSelectedItem();
        String extra1 = txtExtra1.getText();
        String extra2 = txtExtra2.getText();

        if (nombre.isEmpty() || apellidos.isEmpty() || dni.isEmpty() || email.isEmpty() || pass.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Rellene todos los campos obligatorios.");
            return;
        }

        if (!pass.equals(conf)) {
            JOptionPane.showMessageDialog(this, "Las contraseñas no coinciden.");
            return;
        }

        try {
            // 1. Crear el objeto Usuario (o su subclase)
            Usuario u;
            if ("alumno".equals(rol)) {
                Alumno a = new Alumno();
                a.setBeca(extra1);
                a.setPromocion(extra2);
                u = a;
            } else {
                Profesor p = new Profesor();
                p.setDepartamento(extra1);
                p.setEspecialidad(extra2);
                u = p;
            }

            // Configurar campos comunes
            u.setUsername(dni);
            u.setPassword(pass);
            u.setEmail(email);
            u.setNombre(nombre);
            u.setApellidos(apellidos);
            u.setDni(dni);
            u.setRol(rol);

            // 2. Transacción de Registro
            UsuarioDAO usuarioDAO = new UsuarioDAOImpl();
            int idGenerado = usuarioDAO.registrar(u);
            
            if (idGenerado > 0) {
                u.setId(idGenerado);
                if (u instanceof Alumno) {
                    new AlumnoDAOImpl().insertar((Alumno) u);
                } else if (u instanceof Profesor) {
                    new ProfesorDAOImpl().insertar((Profesor) u);
                }
                JOptionPane.showMessageDialog(this, "¡Éxito! " + rol + " registrado correctamente.");
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Error al obtener ID de usuario.");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error de base de datos: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        // Establecer Look & Feel System para que se vea más profesional
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ignored) {}
        
        SwingUtilities.invokeLater(() -> {
            new Registro().setVisible(true);
        });
    }
}
