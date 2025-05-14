package edu.progAvUD.parcialPrimerCorte.vista;

import java.awt.Dimension;
import java.io.File;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;
import edu.progAvUD.parcialPrimerCorte.control.ControlGrafico;
import javax.swing.JComboBox;
import javax.swing.JDialog;

/**
 *
 * @author Andres Felipe
 */
public class VentanaPrincipal extends javax.swing.JFrame {

    // Controlador gráfico principal que coordina la interfaz
    private ControlGrafico controlGrafico;

    /**
     * Panel principal que se muestra al inicio.
     */
    public PanelPrincipal panelPrincipal;

    /**
     * Panel con las opciones CRUD (Crear, Leer, Actualizar, Eliminar).
     */
    public PanelOpcionesCRUD panelOpcionesCRUD;

    /**
     * Panel para consultar información de un gato.
     */
    public PanelConsultarGato panelConsultarGato;

    /**
     * Panel para eliminar un gato de la base de datos.
     */
    public PanelEliminarGato panelEliminarGato;

    /**
     * Panel para insertar un nuevo gato.
     */
    public PanelInsertarGato panelInsertarGato;

    /**
     * Panel para modificar la información de un gato.
     */
    public PanelModificarGato panelModificarGato;

    /**
     * Panel para mostrar todos los gatos registrados.
     */
    public PanelMostrarGatos panelMostrarGatos;

    /**
     * Constructor de la clase VentanaPrincipal. Inicializa todos los paneles y
     * los deja listos para ser mostrados.
     *
     * @param controlGrafico el controlador gráfico que se encargará de manejar
     * las acciones de la interfaz.
     */
    public VentanaPrincipal(ControlGrafico controlGrafico) {
        this.controlGrafico = controlGrafico;
        initComponents(); // Inicializa la ventana
        setVisible(true); // Hace visible la ventana

        // Se inicializan los distintos paneles que se usarán en la aplicación
        this.panelPrincipal = new PanelPrincipal();
        this.panelOpcionesCRUD = new PanelOpcionesCRUD();
        this.panelConsultarGato = new PanelConsultarGato();
        this.panelEliminarGato = new PanelEliminarGato(this);
        this.panelInsertarGato = new PanelInsertarGato();
        this.panelModificarGato = new PanelModificarGato(this);
        this.panelMostrarGatos = new PanelMostrarGatos();
    }

    /**
     * Muestra un mensaje de éxito en una ventana emergente.
     *
     * @param mensaje el texto que se mostrará.
     */
    public void mostrarMensajeExito(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, "Éxito", JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Muestra un mensaje de error en una ventana emergente.
     *
     * @param mensaje el texto que se mostrará.
     */
    public void mostrarMensajeError(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
    }

    /**
     * Abre un diálogo para que el usuario seleccione un archivo `.properties`.
     *
     * @return el archivo seleccionado o null si se cancela.
     */
    public File pedirArchivoPropiedades() {
        JFileChooser fileChooser = new JFileChooser(System.getProperty("user.dir") + "/src/main/java/edu/progAvUD/parcialPrimerCorte/data");
        fileChooser.setFileFilter(new FileNameExtensionFilter("Archivos .properties", "properties"));
        fileChooser.showOpenDialog(null);
        return fileChooser.getSelectedFile();
    }

    /**
     * Abre un diálogo para seleccionar un directorio donde guardar un archivo
     * aleatorio.
     *
     * @return el directorio seleccionado o null si se cancela.
     */
    public File pedirDirectorioArchivoAleatorio() {
        JFileChooser fileChooser = new JFileChooser(System.getProperty("user.dir") + "/src/main/java/edu/progAvUD/parcialPrimerCorte/data");
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        fileChooser.setDialogTitle("Selecciona un directorio");
        fileChooser.showOpenDialog(null);
        return fileChooser.getSelectedFile();
    }

    /**
     * Cambia el contenido de la ventana principal y muestra el panel recibido
     * como parámetro.
     *
     * @param panel el nuevo panel a mostrar.
     */
    public void mostrarPanel(JPanel panel) {
        setContentPane(panel);
        pack(); // Ajusta la ventana al nuevo contenido
        setLocationRelativeTo(null); // Centra la ventana en la pantalla
        revalidate();
        repaint();
    }

    /**
     * Muestra un JOptionPane con un JComboBox para que el usuario seleccione un
     * dato faltante.
     *
     * @param datoFaltante nombre del dato que falta.
     * @param opciones opciones disponibles a elegir.
     * @return la opción seleccionada por el usuario.
     */
    public Object mostrarJOptionSeleccionarDatoFaltante(String datoFaltante, Object[] opciones) {
        JComboBox<Object> comboBox = new JComboBox<>(opciones);
        String mensaje = "Hace falta el dato de '" + datoFaltante + "'.\nSeleccione una opción:";

        Object[] contenido = {mensaje, comboBox};
        Object[] botones = {"Aceptar"};

        JOptionPane optionPane = new JOptionPane(
                contenido,
                JOptionPane.QUESTION_MESSAGE,
                JOptionPane.DEFAULT_OPTION,
                null,
                botones,
                botones[0]
        );

        JDialog dialogo = optionPane.createDialog("Dato Faltante");
        dialogo.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        dialogo.setModal(true);
        dialogo.setVisible(true);
        return comboBox.getSelectedItem();
    }

    /**
     * Muestra un JOptionPane con un campo de texto para que el usuario escriba
     * un dato faltante.
     *
     * @param datoFaltante nombre del dato que falta.
     * @return el texto ingresado por el usuario.
     */
    public String mostrarJOptionEscribirDatoFaltante(String datoFaltante) {
        String mensaje = "Hace falta el dato de '" + datoFaltante + "'.\nEscriba el dato:";

        JTextField textField = new JTextField();
        Object[] contenido = {mensaje, textField};
        Object[] botones = {"Aceptar"};

        JOptionPane optionPane = new JOptionPane(
                contenido,
                JOptionPane.QUESTION_MESSAGE,
                JOptionPane.DEFAULT_OPTION,
                null,
                botones,
                botones[0]
        );

        JDialog dialog = optionPane.createDialog("Dato Faltante");
        dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        dialog.setModal(true);
        dialog.setVisible(true);

        return textField.getText();
    }

    /**
     * Solicita al usuario que ingrese el nombre de un archivo mediante un
     * diálogo.
     *
     * @return el nombre del archivo escrito por el usuario, sin espacios al
     * inicio o al final.
     */
    public String pedirNombreArchivo() {
        JTextField txtNombre = new JTextField(20);
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(new JLabel("Digite el nombre del archivo:"));
        panel.add(Box.createRigidArea(new Dimension(0, 5)));
        panel.add(txtNombre);

        int opcion = JOptionPane.showConfirmDialog(
                null,
                panel,
                "Nombre de archivo",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE
        );
        return txtNombre.getText().trim();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItemSalir = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItemSerializar = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jMenu1.setText("Salir");

        jMenuItemSalir.setText("Salir");
        jMenu1.add(jMenuItemSalir);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Serializar Base de Datos");

        jMenuItemSerializar.setText("Serializar");
        jMenu2.add(jMenuItemSerializar);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 277, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    public javax.swing.JMenuBar jMenuBar1;
    public javax.swing.JMenuItem jMenuItemSalir;
    public javax.swing.JMenuItem jMenuItemSerializar;
    // End of variables declaration//GEN-END:variables
}
