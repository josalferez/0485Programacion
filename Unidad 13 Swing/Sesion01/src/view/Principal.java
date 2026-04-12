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
    
    private JTextField txtCampo1, txtCampo2, txtCampo3; // Para Nombre/Email/DNI o Titulo/Créditos
    private JLabel lblCampo1, lblCampo2, lblCampo3;

    private int modoActual = 0; // 1: Alumnos, 2: Cursos, 3: Matrículas
    private int idSeleccionado = -1; // ID del registro seleccionado para edición
    private AlumnoDAO alumnoDAO = new AlumnoDAOImpl();
    private CursoDAO cursoDAO = new CursoDAOImpl();
    private MatriculaDAO matriculaDAO = new MatriculaDAOImpl();

    public Principal() {
        setTitle("Sistema de Gestión Académica - Universidad DB");
        setSize(1250, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10)); // Divide el panel en 5 zonas y las separa 10px horizontal y 10px vertical

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
        menuAyuda.add(itemAcerca);

        menuBar.add(menuArchivo);
        menuBar.add(menuEdicion);
        menuBar.add(menuAyuda);
        setJMenuBar(menuBar);
    }

    private void initPanelNavegacion() {
        JPanel panelLateral = new JPanel();
        panelLateral.setLayout(new GridLayout(6, 1, 0, 10) ); // 3 filas, 1 columna, 0px horizontal, 10px vertical
        panelLateral.setBackground(new Color(45, 52, 54)); // Color de fondo del panel lateral
        panelLateral.setPreferredSize(new Dimension(200, 0)); // Tamaño del panel lateral

        btnAlumnos = new JButton("Gestión Alumnos");
        btnCursos = new JButton("Gestión Cursos");
        btnMatriculas = new JButton("Ver Matrículas (JOIN)");
        btnGestionUsuarios = new JButton("Gestión Usuarios");

        // Estilo rápido para botones
        JButton[] botones = {btnAlumnos, btnCursos, btnMatriculas, btnGestionUsuarios};
        for (JButton b : botones) {
            b.addActionListener(this);
            panelLateral.add(b);
        }

        add(panelLateral, BorderLayout.WEST);
    }

    private void initPanelCentral() {
        JPanel panelCentro = new JPanel(new BorderLayout(5, 5));

        // Tabla
        modeloTabla = new DefaultTableModel();
        tablaDatos = new JTable(modeloTabla);
        tablaDatos.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting() && modoActual == 1) {
                int fila = tablaDatos.getSelectedRow();
                if (fila != -1) {
                    idSeleccionado = (int) modeloTabla.getValueAt(fila, 0);
                    txtCampo1.setText((String) modeloTabla.getValueAt(fila, 1));
                    txtCampo2.setText((String) modeloTabla.getValueAt(fila, 2));
                    txtCampo3.setText((String) modeloTabla.getValueAt(fila, 3));
                }
            }
        });
        JScrollPane scrollTabla = new JScrollPane(tablaDatos);

        // Consola de estado
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

        lblCampo1 = new JLabel("Nombre / Título:");
        txtCampo1 = new JTextField(18); // Tamaño del campo de texto
        lblCampo2 = new JLabel("Email / Créditos:");
        txtCampo2 = new JTextField(18);
        lblCampo3 = new JLabel("DNI:");
        txtCampo3 = new JTextField(18);
        lblCampo1.setBounds(10, 20, 100, 20);
        txtCampo1.setBounds(120, 20, 200, 20);
        lblCampo2.setBounds(10, 50, 100, 20);
        txtCampo2.setBounds(120, 50, 200, 20);
        lblCampo3.setBounds(10, 80, 100, 20);
        txtCampo3.setBounds(120, 80, 200, 20);  

        btnGuardar = new JButton("Guardar Registro");
        btnEliminar = new JButton("Eliminar Seleccionado");
        btnGuardar.setBounds(10, 110, 150, 30);
        btnEliminar.setBounds(170, 110, 150, 30);
        
        btnGuardar.addActionListener(this);
        btnEliminar.addActionListener(this);

        panelDerecho.add(lblCampo1);
        panelDerecho.add(txtCampo1);
        panelDerecho.add(lblCampo2);
        panelDerecho.add(txtCampo2);
        panelDerecho.add(lblCampo3);
        panelDerecho.add(txtCampo3);
        panelDerecho.add(btnGuardar);
        panelDerecho.add(btnEliminar);

        add(panelDerecho, BorderLayout.EAST); // Añadimos el panel derecho al frame

    }

    private void log(String msj) {
        txtConsola.append("> " + msj + "\n");
    }

    private void cargarAlumnos() {
        modoActual = 1;
        idSeleccionado = -1;
        txtCampo1.setText("");
        txtCampo2.setText("");
        txtCampo3.setText("");
        setLayout(null);
        lblCampo1.setText("Nombre:");
        lblCampo2.setText("Email:");
        lblCampo3.setText("DNI:");
        lblCampo1.setBounds(10, 20, 100, 20);
        txtCampo1.setBounds(120, 20, 200, 20);
        lblCampo2.setBounds(10, 50, 100, 20);
        txtCampo2.setBounds(120, 50, 200, 20);
        lblCampo3.setBounds(10, 80, 100, 20);
        txtCampo3.setBounds(120, 80, 200, 20);
        btnGuardar.setBounds(10, 110, 150, 30);
        btnEliminar.setBounds(170, 110, 150, 30);
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
        txtCampo1.setText("");
        txtCampo2.setText("");
        txtCampo3.setText("");
        lblCampo1.setText("Título:");
        lblCampo2.setText("Créditos:");
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
        txtCampo1.setText("");
        txtCampo2.setText("");
        txtCampo3.setText("");
        modeloTabla.setColumnIdentifiers(new String[]{"Alumno", "Curso", "Fecha"});
        modeloTabla.setRowCount(0);
        try {
            List<MatriculaDTO> lista = matriculaDAO.listarMatriculasDetalladas();
            for (MatriculaDTO m : lista) {
                modeloTabla.addRow(new Object[]{m.getNombreAlumno(), m.getTituloCurso(), m.getFecha()});
            }
            log("Matrículas (JOIN) cargadas correctamente.");
        } catch (SQLException e) {
            log("Error al cargar matrículas: " + e.getMessage());
        }
    }

    private void ejecutarGuardar() {
        try {
            if (modoActual == 1) { // Alumno
                Alumno a;
                if (idSeleccionado != -1) {
                    a = new Alumno(idSeleccionado, txtCampo1.getText(), txtCampo2.getText(), txtCampo3.getText());
                    alumnoDAO.actualizar(a);
                    log("Alumno actualizado.");
                } else {
                    a = new Alumno(txtCampo1.getText(), txtCampo2.getText(), txtCampo3.getText());
                    alumnoDAO.insertar(a);
                    log("Alumno guardado.");
                }
                cargarAlumnos();
            } else if (modoActual == 2) { // Curso
                Curso c = new Curso(txtCampo1.getText(), Integer.parseInt(txtCampo2.getText()));
                cursoDAO.insertar(c);
                log("Curso guardado.");
                cargarCursos();
            }
            txtCampo1.setText("");
            txtCampo2.setText("");
            txtCampo3.setText("");
            idSeleccionado = -1;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al guardar: " + e.getMessage());
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnAlumnos) {
            cargarAlumnos();
        } 
        
        if (e.getSource() == btnCursos) {
            cargarCursos();
        }

        if (e.getSource() == btnMatriculas) {
            cargarMatriculas();
        }

        if (e.getSource() == btnGestionUsuarios) {
            new Registro().setVisible(true);
        }   

        if (e.getSource() == btnGuardar) {
            ejecutarGuardar();
        }

        if (e.getSource() == itemColor) {
            Color c = JColorChooser.showDialog(this, "Selecciona un color", getBackground());
            if(c != null) getContentPane().setBackground(c);
        }

        if (e.getSource() == btnEliminar) {
            ejecutarEliminar();
        }

        if (e.getSource() == itemCerrarSesion) {
            new Login().setVisible(true);
            this.dispose();
        }
    }

    private void ejecutarEliminar() {
        int fila = tablaDatos.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(this, "Selecciona una fila primero.");
            return;
        }

        int id = (int) modeloTabla.getValueAt(fila, 0);
        int confirm = JOptionPane.showConfirmDialog(this, "¿Estás seguro de eliminar el registro ID " + id + "?", "Confirmar", JOptionPane.YES_NO_OPTION);
        
        if (confirm == JOptionPane.YES_OPTION) {
            try {
                if (modoActual == 1) {
                    alumnoDAO.eliminar(id);
                    cargarAlumnos();
                } else if (modoActual == 2) {
                    cursoDAO.eliminar(id);
                    cargarCursos();
                }
                log("Registro eliminado.");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Error al eliminar: " + ex.getMessage());
            }
        }
    }
}