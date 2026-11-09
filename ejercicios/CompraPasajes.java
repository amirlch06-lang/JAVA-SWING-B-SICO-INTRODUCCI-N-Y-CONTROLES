package ejercicios;

import javax.swing.*;
import java.awt.*;

public class CompraPasajes extends JFrame {
    private JTextField txtNombres, txtDNI, txtFecha;
    private JCheckBox chkAudifonos, chkManta, chkRevistas;
    private JRadioButton rbPiso1, rbPiso2;
    private JComboBox<String> cbOrigen, cbDestino;
    private JList<String> listServicio;
    private JButton btnMostrar, btnLimpiar;

    public CompraPasajes() {
        super("Compra de Pasajes - Transporte Terrestre");
        setLayout(new BorderLayout(10, 10));

        // Panel principal usando GridLayout para ordenar campos verticalmente
        JPanel panelCentral = new JPanel(new GridLayout(8, 2, 5, 5));

        // Etiquetas y Campos de Texto
        panelCentral.add(new JLabel(" Nombres:"));
        txtNombres = new JTextField();
        panelCentral.add(txtNombres);

        panelCentral.add(new JLabel(" Documento de Identidad (DNI):"));
        txtDNI = new JTextField();
        panelCentral.add(txtDNI);

        panelCentral.add(new JLabel(" Fecha de Viaje (DD/MM/AAAA):"));
        txtFecha = new JTextField();
        panelCentral.add(txtFecha);

        // Casillas de Verificación (Múltiples opciones)
        panelCentral.add(new JLabel(" Servicios Opcionales:"));
        JPanel panelChecks = new JPanel(new FlowLayout(FlowLayout.LEFT));
        chkAudifonos = new JCheckBox("Audífonos");
        chkManta = new JCheckBox("Manta");
        chkRevistas = new JCheckBox("Revistas");
        panelChecks.add(chkAudifonos);
        panelChecks.add(chkManta);
        panelChecks.add(chkRevistas);
        panelCentral.add(panelChecks);

        // Botones de Opción (Excluyentes)
        panelCentral.add(new JLabel(" Selección de Piso:"));
        JPanel panelRadios = new JPanel(new FlowLayout(FlowLayout.LEFT));
        rbPiso1 = new JRadioButton("1er Piso", true);
        rbPiso2 = new JRadioButton("2do Piso");
        ButtonGroup grupoPiso = new ButtonGroup(); // Relación lógica mutuamente excluyente
        grupoPiso.add(rbPiso1);
        grupoPiso.add(rbPiso2);
        panelRadios.add(rbPiso1);
        panelRadios.add(rbPiso2);
        panelCentral.add(panelRadios);

        // Cuadros Combinados (Origen y Destino)
        panelCentral.add(new JLabel(" Origen / Destino:"));
        JPanel panelCombos = new JPanel(new GridLayout(1, 2, 5, 5));
        String[] ciudades = {"Arequipa", "Lima", "Cusco", "Puno", "Tacna"};
        cbOrigen = new JComboBox<>(ciudades);
        cbDestino = new JComboBox<>(ciudades);
        panelCombos.add(cbOrigen);
        panelCombos.add(cbDestino);
        panelCentral.add(panelCombos);

        // Lista de Calidad de Servicio
        panelCentral.add(new JLabel(" Calidad del Servicio:"));
        String[] calidades = {"Económico", "Standard", "VIP"};
        listServicio = new JList<>(calidades);
        listServicio.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listServicio.setSelectedIndex(1);
        // JScrollPane permite visualizar el JList correctamente
        panelCentral.add(new JScrollPane(listServicio));

        add(panelCentral, BorderLayout.CENTER);

        // Botones de Comando
        JPanel panelBotones = new JPanel(new FlowLayout());
        btnMostrar = new JButton("Procesar Compra");
        btnLimpiar = new JButton("Reiniciar Campos");
        panelBotones.add(btnMostrar);
        panelBotones.add(btnLimpiar);
        add(panelBotones, BorderLayout.SOUTH);

        // Manejadores de eventos integrados
        btnMostrar.addActionListener(e -> mostrarResumen());
        btnLimpiar.addActionListener(e -> reiniciarFormulario());
    }

    // Cuadro de Diálogo JOptionPane 
    private void mostrarResumen() {
        String extras = "";
        if (chkAudifonos.isSelected()) extras += "Audífonos ";
        if (chkManta.isSelected()) extras += "Manta ";
        if (chkRevistas.isSelected()) extras += "Revistas ";
        if (extras.isEmpty()) extras = "Ninguno";

        String piso = rbPiso1.isSelected() ? "1er Piso" : "2do Piso";
        
        String mensaje = String.format(
            "RESUMEN DE COMPRA:\n\nNombre: %s\nDNI: %s\nFecha: %s\nOrigen: %s\nDestino: %s\nCalidad: %s\nPiso: %s\nExtras: %s",
            txtNombres.getText(), txtDNI.getText(), txtFecha.getText(),
            cbOrigen.getSelectedItem(), cbDestino.getSelectedItem(),
            listServicio.getSelectedValue(), piso, extras
        );
        // JOptionPane.INFORMATION_MESSAGE muestra el diálogo con icono informativo
        JOptionPane.showMessageDialog(this, mensaje, "Resumen del Pasajero", JOptionPane.INFORMATION_MESSAGE);
    }

    private void reiniciarFormulario() {
        txtNombres.setText("");
        txtDNI.setText("");
        txtFecha.setText("");
        chkAudifonos.setSelected(false);
        chkManta.setSelected(false);
        chkRevistas.setSelected(false);
        rbPiso1.setSelected(true);
        cbOrigen.setSelectedIndex(0);
        cbDestino.setSelectedIndex(0);
        listServicio.setSelectedIndex(1);
    }

    public static void main(String[] args) {
        CompraPasajes ventana = new CompraPasajes();
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize(600, 450);
        ventana.setVisible(true);
    }
}