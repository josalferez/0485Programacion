package view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import dao.*;
import model.*;
import dto.*;
import java.sql.SQLException;
import java.util.List;

public class Principal extends JFrame implements ActionListener {

    // Componentes de la Interfaz
    private JMenuBar menuBar;
    private JMenu menuArchivo, menuEdicion, menuAyuda;
    private JMenuItem itemSalir, itemCerrarSesion, itemColor, itemAcerca;
    
    private JButton btnAlumnos, btnCursos, btnMatriculas, btnGuardar, btnEliminar, btnGestionUsuarios;
    private JTable tablaDatos;
    private DefaultTableModel modeloTabla;
    private JTextArea txtConsola;
    
    private JTextField txtCampo1, txtCampo2, txtCampo3, txtCampo4, txtCampo5, txtCampo6;
    private JLabel lblCampo1, lblCampo2, lblCampo3, lblCampo4, lblCampo5, lblCampo6, lblRol;
    private JComboBox<String> comboRol;

    private int modoActual = 0; // 1: Alumnos, 2: Cursos, 3: Matrículas, 4: Usuarios
    private int idSeleccionado = -1; 
    private AlumnoDAO alumnoDAO = new AlumnoDAOImpl();
    private CursoDAO cursoDAO = new CursoDAOImpl();
    private MatriculaDAO matriculaDAO = new MatriculaDAOImpl();
    private UsuarioDAO usuarioDAO = new UsuarioDAOImpl();

    public Principal() {
        setTitle("Sistema de Gestión Académica - Universidad DB");
        setSize(1250, 750);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        initMenu();
        initPanelNavegacion();
        initPanelCentral();
        initPanelOperaciones();
        
        setLocationRelativeTo(null);
    }

    private void initMenu() {
        menuBar = new JMenuBar();
        
        menuArchivo = new JMenu("Archivo");
        itemCerrarSesion = new JMenuItem("Cerrar Sesión");
        itemCerrarSesion.addActionListener(this);
        itemSalir = new JMenuItem("Salir");
        itemSalir.addActionListener(e -> System.exit(0));
        menuArchivo.add(itemCerrarSesion);
        menuArchivo.add(itemSalir);

        menuEdicion = new JMenu("Edición");
        itemColor = new JMenuItem("Preferencias (Color)");
        itemColor.addActionListener(this);
        menuEdicion.add(itemColor);

        menuAyuda = new JMenu("Ayuda");
        itemAcerca = new JMenuItem("Acerca de...");
        itemAcerca.addActionListener(this);
        menuAyuda.add(itemAcerca);

        menuBar.add(menuArchivo);
        menuBar.add(menuEdicion);
        menuBar.add(menuAyuda);
        setJMenuBar(menuBar);
    }

    private void initPanelNavegacion() {
        JPanel panelLateral = new JPanel();
        panelLateral.setLayout(new GridLayout(6, 1, 0, 10) ); // 6 filas, 1 columna, espaciado de 10px
        panelLateral.setBackground(new Color(45, 52, 54));
        panelLateral.setPreferredSize(new Dimension(200, 0)); 

        btnAlumnos = new JButton("Gestión Alumnos");
        btnCursos = new JButton("Gestión Cursos");
        btnMatriculas = new JButton("Gestionar Matrículas");
        btnGestionUsuarios = new JButton("Gestión Usuarios");

        JButton[] botones = {btnAlumnos, btnCursos, btnMatriculas, btnGestionUsuarios};
        for (JButton b : botones) {
            b.addActionListener(this);
            panelLateral.add(b);
        }

        add(panelLateral, BorderLayout.WEST);
    }

    private void initPanelCentral() {
        JPanel panelCentro = new JPanel(new BorderLayout(5, 5));

        modeloTabla = new DefaultTableModel();
        tablaDatos = new JTable(modeloTabla);
        tablaDatos.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                int fila = tablaDatos.getSelectedRow();
                if (fila != -1) {
                    idSeleccionado = (int) modeloTabla.getValueAt(fila, 0);
                    if (modoActual == 1) { // Alumnos
                        try {
                            Alumno a = alumnoDAO.obtenerPorId(idSeleccionado);
                            if (a != null) {
                                txtCampo1.setText(a.getNombre());
                                txtCampo2.setText(a.getEmail());
                                txtCampo3.setText(a.getDni());
                                txtCampo4.setText(a.getApellidos());
                            }
                        } catch (SQLException ex) {
                            log("Error al recuperar alumno: " + ex.getMessage());
                        }
                    } else if (modoActual == 2) { // Cursos
                        txtCampo1.setText((String) modeloTabla.getValueAt(fila, 1));
                        txtCampo2.setText(String.valueOf(modeloTabla.getValueAt(fila, 2)));
                    } else if (modoActual == 4) { // Usuarios
                        try {
                            Usuario u = usuarioDAO.obtenerPorId(idSeleccionado);
                            if (u != null) {
                                txtCampo1.setText(u.getUsername());
                                txtCampo2.setText(u.getEmail());
                                txtCampo3.setText(u.getDni());
                                txtCampo4.setText(u.getNombre());
                                txtCampo5.setText(u.getApellidos());
                                txtCampo6.setText(u.getPassword());
                                comboRol.setSelectedItem(u.getRol());
                            }
                        } catch (SQLException ex) {
                            log("Error al recuperar usuario: " + ex.getMessage());
                        }
                    }
                }
            }
        });
        
        JScrollPane scrollTabla = new JScrollPane(tablaDatos);

        txtConsola = new JTextArea(5, 20);
        txtConsola.setEditable(false);
        txtConsola.setBackground(Color.BLACK);
        txtConsola.setForeground(Color.GREEN);
        txtConsola.setFont(new Font("Consolas", Font.PLAIN, 12));
        JScrollPane scrollConsola = new JScrollPane(txtConsola);
        
        panelCentro.add(scrollTabla, BorderLayout.CENTER);
        panelCentro.add(scrollConsola, BorderLayout.SOUTH);

        add(panelCentro, BorderLayout.CENTER);
        log("Sistema iniciado correctamente.");
    }

    private void initPanelOperaciones() {
        JPanel panelDerecho = new JPanel();
        panelDerecho.setPreferredSize(new Dimension(450, 0));
        panelDerecho.setBorder(BorderFactory.createTitledBorder("Operaciones"));
        panelDerecho.setLayout(null);

        lblCampo1 = new JLabel("Label 1:");
        txtCampo1 = new JTextField();
        lblCampo2 = new JLabel("Label 2:");
        txtCampo2 = new JTextField();
        lblCampo3 = new JLabel("Label 3:");
        txtCampo3 = new JTextField();
        lblCampo4 = new JLabel("Label 4:");
        txtCampo4 = new JTextField();
        lblCampo5 = new JLabel("Label 5:");
        txtCampo5 = new JTextField();
        lblCampo6 = new JLabel("Label 6:");
        txtCampo6 = new JTextField();
        lblRol = new JLabel("Rol:");
        comboRol = new JComboBox<>(new String[]{"alumno", "profesor"});

        int lx = 10, tx = 130, w = 250, h = 25, space = 35;
        int y = 30;

        JLabel[] labels = {lblCampo1, lblCampo2, lblCampo3, lblCampo4, lblCampo5, lblCampo6, lblRol};
        JComponent[] fields = {txtCampo1, txtCampo2, txtCampo3, txtCampo4, txtCampo5, txtCampo6, comboRol};

        for (int i = 0; i < labels.length; i++) {
            labels[i].setBounds(lx, y, 110, h);
            fields[i].setBounds(tx, y, w, h);
            panelDerecho.add(labels[i]);
            panelDerecho.add(fields[i]);
            y += space;
        }

        btnGuardar = new JButton("Guardar Registro");
        btnEliminar = new JButton("Eliminar Seleccionado");
        btnGuardar.setBounds(lx, y + 10, 180, 40);
        btnEliminar.setBounds(tx + 80, y + 10, 180, 40);
        
        btnGuardar.addActionListener(this);
        btnEliminar.addActionListener(this);

        panelDerecho.add(btnGuardar);
        panelDerecho.add(btnEliminar);

        add(panelDerecho, BorderLayout.EAST);
        setVisibilidadCamposExtra(false);
    }

    private void setVisibilidadCamposExtra(boolean visible) {
        lblCampo4.setVisible(visible);
        txtCampo4.setVisible(visible);
        lblCampo5.setVisible(visible);
        txtCampo5.setVisible(visible);
        lblCampo6.setVisible(visible);
        txtCampo6.setVisible(visible);
        lblRol.setVisible(visible);
        comboRol.setVisible(visible);
    }

    private void log(String msj) {
        txtConsola.append("> " + msj + "\n");
    }

    private void cargarAlumnos() {
        modoActual = 1;
        idSeleccionado = -1;
        limpiarCampos();
        setVisibilidadCamposExtra(false);
        txtCampo3.setVisible(true);
        lblCampo3.setVisible(true);

        lblCampo1.setText("Nombre:");
        lblCampo2.setText("Email:");
        lblCampo3.setText("DNI:");
        lblCampo4.setText("Apellidos:");
        lblCampo4.setVisible(true);
        txtCampo4.setVisible(true);

        modeloTabla.setColumnIdentifiers(new String[]{"ID", "Nombre", "Email", "DNI"});
        modeloTabla.setRowCount(0);
        try {
            List<Alumno> lista = alumnoDAO.listarTodos();
            for (Alumno a : lista) {
                modeloTabla.addRow(new Object[]{a.getId(), a.getNombre(), a.getEmail(), a.getDni()});
            }
            log("Alumnos cargados correctamente.");
        } catch (SQLException e) {
            log("Error al cargar alumnos: " + e.getMessage());
        }
    }

    private void cargarCursos() {
        modoActual = 2;
        idSeleccionado = -1;
        limpiarCampos();
        setVisibilidadCamposExtra(false);
        
        lblCampo1.setText("Título:");
        lblCampo2.setText("Créditos:");
        lblCampo3.setText("");
        txtCampo3.setVisible(false);
        lblCampo3.setVisible(false);

        modeloTabla.setColumnIdentifiers(new String[]{"ID", "Título", "Créditos"});
        modeloTabla.setRowCount(0);
        try {
            List<Curso> lista = cursoDAO.listarTodos();
            for (Curso c : lista) {
                modeloTabla.addRow(new Object[]{c.getId(), c.getTitulo(), c.getCreditos()});
            }
            log("Cursos cargados correctamente.");
        } catch (SQLException e) {
            log("Error al cargar cursos: " + e.getMessage());
        }
    }

    private void cargarMatriculas() {
        modoActual = 3;
        idSeleccionado = -1;
        limpiarCampos();
        setVisibilidadCamposExtra(false);
        txtCampo3.setVisible(false);
        lblCampo3.setVisible(false);

        modeloTabla.setColumnIdentifiers(new String[]{"Alumno", "Curso", "Fecha"});
        modeloTabla.setRowCount(0);
        try {
            List<MatriculaDTO> lista = matriculaDAO.listarMatriculasDetalladas();
            for (MatriculaDTO m : lista) {
                modeloTabla.addRow(new Object[]{m.getNombreAlumno(), m.getTituloCurso(), m.getFecha()});
            }
            log("Matrículas cargadas correctamente.");
        } catch (SQLException e) {
            log("Error al cargar matrículas: " + e.getMessage());
        }
    }

    private void cargarUsuarios() {
        modoActual = 4;
        idSeleccionado = -1;
        limpiarCampos();
        setVisibilidadCamposExtra(true);
        txtCampo3.setVisible(true);
        lblCampo3.setVisible(true);

        lblCampo1.setText("Username:");
        lblCampo2.setText("Email:");
        lblCampo3.setText("DNI:");
        lblCampo4.setText("Nombre:");
        lblCampo5.setText("Apellidos:");
        lblCampo6.setText("Password:");
        lblRol.setText("Rol:");

        modeloTabla.setColumnIdentifiers(new String[]{"ID", "Username", "Email", "Rol"});
        modeloTabla.setRowCount(0);
        try {
            List<Usuario> lista = usuarioDAO.listarTodos();
            for (Usuario u : lista) {
                modeloTabla.addRow(new Object[]{u.getId(), u.getUsername(), u.getEmail(), u.getRol()});
            }
            log("Usuarios cargados correctamente.");
        } catch (SQLException e) {
            log("Error al cargar usuarios: " + e.getMessage());
        }
    }

    private void limpiarCampos() {
        txtCampo1.setText("");
        txtCampo2.setText("");
        txtCampo3.setText("");
        txtCampo4.setText("");
        txtCampo5.setText("");
        txtCampo6.setText("");
        txtCampo1.setVisible(true);
        txtCampo2.setVisible(true);
        txtCampo3.setVisible(true);
        lblCampo1.setVisible(true);
        lblCampo2.setVisible(true);
        lblCampo3.setVisible(true);
    }

    private void ejecutarGuardar() {
        try {
            if (modoActual == 1) { // Alumno
                Alumno a = new Alumno();
                a.setNombre(txtCampo1.getText());
                a.setApellidos(txtCampo4.getText());
                a.setEmail(txtCampo2.getText());
                a.setDni(txtCampo3.getText());
                
                if (idSeleccionado != -1) {
                    a.setId(idSeleccionado);
                    alumnoDAO.actualizar(a);
                    log("Alumno actualizado.");
                } else {
                    // Para insertar desde aquí usamos valores por defecto
                    a.setApellidos("Registrado");
                    a.setUsername(a.getDni());
                    a.setPassword("1234");
                    a.setRol("alumno");
                    int newId = usuarioDAO.registrar(a);
                    if (newId > 0) {
                        a.setId(newId);
                        alumnoDAO.insertar(a);
                        log("Alumno guardado.");
                    }
                }
                cargarAlumnos();
            } else if (modoActual == 2) { // Curso
                Curso c = new Curso(txtCampo1.getText(), Integer.parseInt(txtCampo2.getText()));
                if (idSeleccionado != -1) {
                    c.setId(idSeleccionado);
                    // cursoDAO.actualizar(c); // Si existiera
                } else {
                    cursoDAO.insertar(c);
                }
                log("Curso guardado.");
                cargarCursos();
            } else if (modoActual == 4) { // Usuario
                Usuario u = new Usuario();
                u.setUsername(txtCampo1.getText());
                u.setEmail(txtCampo2.getText());
                u.setDni(txtCampo3.getText());
                u.setNombre(txtCampo4.getText());
                u.setApellidos(txtCampo5.getText());
                u.setPassword(txtCampo6.getText());
                u.setRol((String) comboRol.getSelectedItem());

                if (idSeleccionado != -1) {
                    u.setId(idSeleccionado);
                    usuarioDAO.actualizar(u);
                    log("Usuario actualizado.");
                } else {
                    usuarioDAO.registrar(u);
                    log("Usuario registrado.");
                }
                cargarUsuarios();
            }
            idSeleccionado = -1;
            limpiarCampos();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al guardar: " + e.getMessage());
        }
    }

    private void ejecutarEliminar() {
        if (idSeleccionado == -1) {
            JOptionPane.showMessageDialog(this, "Selecciona una fila primero.");
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(this, "¿Eliminar registro ID " + idSeleccionado + "?", "Confirmar", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            try {
                if (modoActual == 1) {
                    alumnoDAO.eliminar(idSeleccionado);
                    cargarAlumnos();
                } else if (modoActual == 2) {
                    cursoDAO.eliminar(idSeleccionado);
                    cargarCursos();
                } else if (modoActual == 4) {
                    usuarioDAO.eliminar(idSeleccionado);
                    cargarUsuarios();
                }
                log("Registro eliminado.");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Error al eliminar: " + ex.getMessage());
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnAlumnos) cargarAlumnos();
        else if (e.getSource() == btnCursos) cargarCursos();
        else if (e.getSource() == btnMatriculas) cargarMatriculas();
        else if (e.getSource() == btnGestionUsuarios) cargarUsuarios();
        else if (e.getSource() == btnGuardar) ejecutarGuardar();
        else if (e.getSource() == btnEliminar) ejecutarEliminar();
        else if (e.getSource() == itemCerrarSesion) {
            new Login().setVisible(true);
            this.dispose();
        } else if (e.getSource() == itemColor) {
            Color c = JColorChooser.showDialog(this, "Color fondo", getBackground());
            if(c != null) getContentPane().setBackground(c);
        } else if (e.getSource() == itemAcerca) {
            JOptionPane.showMessageDialog(this, "Sistema Académico v2.0\nGestión Integral Usuarios", "Acerca de", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}