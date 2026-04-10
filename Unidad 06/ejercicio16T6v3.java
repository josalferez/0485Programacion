import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class ejercicio16T6v3 extends JFrame implements ActionListener {

    // --- Componentes de la Interfaz ---
    private JLabel saldoLabel;
    private JLabel mensajeLabel;
    private JLabel slot1, slot2, slot3; // Usamos JLabel para mostrar las imágenes
    private JButton tirarButton;
    private JButton meterDineroButton;

    // --- Lógica del Juego ---
    private double saldo = 0.0;
    private final double costeTirada = 1.0;
    
    // Función auxiliar para obtener la ruta de la imagen (similar a JavaFX)
    private ImageIcon getFiguraIcon(int valor) {
        String path = switch (valor) {
            case 1 -> "corazon.png";
            case 2 -> "diamante.png";
            case 3 -> "herradura.png";
            case 4 -> "campana.png";
            default -> "limon.png"; 
        };
        // Asume que las imágenes están en la misma carpeta que el código o accesible
        // Nota: En un proyecto grande se usaría getResource() para cargar las imágenes correctamente.
        return new ImageIcon(path); 
    }
    
    // Constructor de la ventana
    public ejercicio16T6v3() {
        super("Tragaperras en Swing");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout()); // Layout principal
        
        // Inicialización de componentes
        saldoLabel = new JLabel("SALDO: 0.00 €", SwingConstants.RIGHT);
        mensajeLabel = new JLabel("¡Ingresa dinero para empezar!", SwingConstants.CENTER);
        slot1 = new JLabel(new ImageIcon("default.png")); // Asume una imagen por defecto
        slot2 = new JLabel(new ImageIcon("default.png"));
        slot3 = new JLabel(new ImageIcon("default.png"));
        
        slot1.setPreferredSize(new Dimension(100, 100)); // Fija el tamaño
        slot2.setPreferredSize(new Dimension(100, 100));
        slot3.setPreferredSize(new Dimension(100, 100));

        tirarButton = new JButton("TIRAR (1.00 €)");
        meterDineroButton = new JButton("Meter 5.00 €");
        
        // --- Paneles (Layouts) ---
        
        // Panel Norte (Saldo)
        JPanel northPanel = new JPanel(new BorderLayout());
        northPanel.add(saldoLabel, BorderLayout.EAST);
        
        // Panel Central (Slots)
        JPanel centerPanel = new JPanel();
        centerPanel.add(slot1);
        centerPanel.add(slot2);
        centerPanel.add(slot3);
        
        // Panel Sur (Mensajes y Botones)
        JPanel southPanel = new JPanel(new GridLayout(2, 1));
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(meterDineroButton);
        buttonPanel.add(tirarButton);

        southPanel.add(mensajeLabel);
        southPanel.add(buttonPanel);
        
        // Añadir paneles a la ventana principal
        this.add(northPanel, BorderLayout.NORTH);
        this.add(centerPanel, BorderLayout.CENTER);
        this.add(southPanel, BorderLayout.SOUTH);

        // --- Manejo de Eventos ---
        meterDineroButton.addActionListener(this);
        tirarButton.addActionListener(this);
        
        // Configuración final de la ventana
        this.pack();
        this.setLocationRelativeTo(null); // Centrar
        this.setVisible(true);
        
        actualizarInterfaz("¡Bienvenido! Usa el botón 'Meter 5.00 €'.");
    }

    // --- Lógica del Juego (Manejador de Eventos) ---
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == meterDineroButton) {
            saldo += 5.0;
            actualizarInterfaz("¡5.00 € ingresados!");
        } else if (e.getSource() == tirarButton) {
            tirar();
        }
    }

    private void tirar() {
        if (saldo < costeTirada) {
            actualizarInterfaz("SALDO INSUFICIENTE. ¡Mete más dinero!");
            return;
        }

        saldo -= costeTirada;
        
        // 1. Generar la tirada
        int f1 = (int) (Math.random() * 5) + 1;
        int f2 = (int) (Math.random() * 5) + 1;
        int f3 = (int) (Math.random() * 5) + 1;

        // 2. Actualizar las imágenes
        slot1.setIcon(getFiguraIcon(f1));
        slot2.setIcon(getFiguraIcon(f2));
        slot3.setIcon(getFiguraIcon(f3));
        
        // 3. Comprobar Premio y Actualizar Saldo
        String mensajePremio;
        double premio = 0.0;
        
        if (f1 == f2 && f2 == f3) { // Tres iguales
            premio = 10.0;
            mensajePremio = "¡PREMIO MAYOR! Ganaste 10.00 €";
        } else if (f1 == f2 || f1 == f3 || f2 == f3) { // Dos iguales
            premio = 1.0;
            mensajePremio = "Has recuperado tu moneda (1.00 €)";
        } else { // Diferentes
            mensajePremio = "Lo siento, has perdido.";
        }
        
        saldo += premio;
        actualizarInterfaz(mensajePremio);
    }
    
    private void actualizarInterfaz(String mensaje) {
        saldoLabel.setText("SALDO: " + String.format("%.2f", saldo) + " €");
        mensajeLabel.setText(mensaje);
        tirarButton.setEnabled(saldo >= costeTirada);
    }

    public static void main(String[] args) {
        // Ejecutar la interfaz en el hilo de despacho de eventos de Swing
        SwingUtilities.invokeLater(() -> new ejercicio16T6v3());
    }
}