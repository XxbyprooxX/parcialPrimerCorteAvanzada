package edu.progAvUD.parcialPrimerCorte.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JTable;

import edu.progAvUD.parcialPrimerCorte.vista.DialogInformacionGato;
import edu.progAvUD.parcialPrimerCorte.vista.PanelConsultarGato;
import edu.progAvUD.parcialPrimerCorte.vista.PanelMostrarGatos;
import edu.progAvUD.parcialPrimerCorte.vista.VentanaPrincipal;

/**
 * Esta clase de encarga de crear la ventana principal, ademas se encarga de
 * manejar los action listener y comunicarse con el controlPrincipal
 *
 * @author Andres Felipe
 */
public class ControlGrafico implements ActionListener {

    private ControlPrincipal controlPrincipal;
    private VentanaPrincipal ventanaPrincipal;

    /**
     * Constructor de la clase ControlGrafico. Inicializa la ventana principal y
     * registra todos los listeners necesarios para los componentes gráficos de
     * la interfaz.
     *
     * @param controlPrincipal Referencia al controlador principal que conecta
     * la lógica de negocio.
     */
    public ControlGrafico(ControlPrincipal controlPrincipal) {
        this.controlPrincipal = controlPrincipal;
        this.ventanaPrincipal = new VentanaPrincipal(this);

        ventanaPrincipal.jMenuBar1.setVisible(false);
        ventanaPrincipal.mostrarPanel(ventanaPrincipal.panelPrincipal);
        ventanaPrincipal.panelPrincipal.jButtonContinuar.setEnabled(false);
        ventanaPrincipal.panelPrincipal.jButtonPropiedadesGatos.setEnabled(false);

        ventanaPrincipal.jMenuItemSalir.addActionListener(this);
        ventanaPrincipal.jMenuItemSerializar.addActionListener(this);

        ventanaPrincipal.panelPrincipal.jButtonContinuar.addActionListener(this);
        ventanaPrincipal.panelPrincipal.jButtonPropiedadesBD.addActionListener(this);
        ventanaPrincipal.panelPrincipal.jButtonPropiedadesGatos.addActionListener(this);

        ventanaPrincipal.panelOpcionesCRUD.jButtonActualizarGato.addActionListener(this);
        ventanaPrincipal.panelOpcionesCRUD.jButtonBuscarGato.addActionListener(this);
        ventanaPrincipal.panelOpcionesCRUD.jButtonVerGatos.addActionListener(this);
        ventanaPrincipal.panelOpcionesCRUD.jButtonEliminarGato.addActionListener(this);
        ventanaPrincipal.panelOpcionesCRUD.jButtonCrearGato.addActionListener(this);

        ventanaPrincipal.panelInsertarGato.jButtonInsertarGato.addActionListener(this);
        ventanaPrincipal.panelInsertarGato.jButtonAtras.addActionListener(this);
        ventanaPrincipal.panelInsertarGato.jButtonLimpiarCampos.addActionListener(this);

        ventanaPrincipal.panelMostrarGatos.jButtonAtras.addActionListener(this);
        ventanaPrincipal.panelMostrarGatos.jButtonMasInfo.addActionListener(this);

        ventanaPrincipal.panelConsultarGato.jButtonAtras.addActionListener(this);
        ventanaPrincipal.panelConsultarGato.jButtonConsultar.addActionListener(this);
        ventanaPrincipal.panelConsultarGato.jButtonLimpiarCampos.addActionListener(this);
        ventanaPrincipal.panelConsultarGato.jButtonInfoGato.addActionListener(this);
        ventanaPrincipal.panelConsultarGato.jRadioButtonRaza.addActionListener(this);
        ventanaPrincipal.panelConsultarGato.jRadioButtonCodigoEMS.addActionListener(this);

        ventanaPrincipal.panelModificarGato.jButtonAtras.addActionListener(this);
        ventanaPrincipal.panelModificarGato.jButtonMasInfo.addActionListener(this);
        ventanaPrincipal.panelModificarGato.dialogModificarGato.jButtonRealizarCambios.addActionListener(this);

        ventanaPrincipal.panelEliminarGato.jButtonAtras.addActionListener(this);
        ventanaPrincipal.panelEliminarGato.jButtonIrAEliminar.addActionListener(this);
        ventanaPrincipal.panelEliminarGato.dialogEliminarGato.jButtonEliminarGato.addActionListener(this);
    }

    /**
     * Este se encarga de indicar que hacer en caso de que el usuario haga algo
     * en alguna ventana
     *
     * @param e es el evento ocurrido
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == ventanaPrincipal.jMenuItemSalir) {
            controlPrincipal.crearArchivoAleatorio();
        }
        if (e.getSource() == ventanaPrincipal.jMenuItemSerializar) {
            controlPrincipal.crearSerializacion();
        }
        // ActionListener de PanelPrincipal
        if (e.getSource() == ventanaPrincipal.panelPrincipal.jButtonPropiedadesBD) {
            controlPrincipal.cargarDatosBD();
            ventanaPrincipal.panelPrincipal.jButtonPropiedadesBD.setEnabled(false);
            ventanaPrincipal.panelPrincipal.jButtonPropiedadesGatos.setEnabled(true);
            verificarBotonesInctivos();
        }
        if (e.getSource() == ventanaPrincipal.panelPrincipal.jButtonPropiedadesGatos) {
            controlPrincipal.cargarDatosGatosPropiedades();
            ventanaPrincipal.panelPrincipal.jButtonPropiedadesGatos.setEnabled(false);
            verificarBotonesInctivos();
        }
        if (e.getSource() == ventanaPrincipal.panelPrincipal.jButtonContinuar) {
            ventanaPrincipal.mostrarPanel(ventanaPrincipal.panelOpcionesCRUD);
            ventanaPrincipal.jMenuBar1.setVisible(true);
        }
        // ActionListener de PanelOpcionesCRUD
        if (e.getSource() == ventanaPrincipal.panelOpcionesCRUD.jButtonVerGatos) {
            ventanaPrincipal.mostrarPanel(ventanaPrincipal.panelMostrarGatos);
            cargarDatosTablaPanelMostrarGatos();
        }
        if (e.getSource() == ventanaPrincipal.panelOpcionesCRUD.jButtonCrearGato) {
            ventanaPrincipal.mostrarPanel(ventanaPrincipal.panelInsertarGato);
        }
        if (e.getSource() == ventanaPrincipal.panelOpcionesCRUD.jButtonBuscarGato) {
            ventanaPrincipal.panelConsultarGato.jButtonInfoGato.setEnabled(false);
            ventanaPrincipal.panelConsultarGato.jButtonLimpiarCampos.setEnabled(false);
            ventanaPrincipal.panelConsultarGato.jTextFieldCodigoEMS.setEnabled(false);
            ventanaPrincipal.panelConsultarGato.jComboBoxRaza.setEnabled(false);
            ventanaPrincipal.panelConsultarGato.jLabelTextoCodigoEMS.setEnabled(false);
            ventanaPrincipal.panelConsultarGato.jLabelTextoRaza.setEnabled(false);
            ventanaPrincipal.panelConsultarGato.jButtonConsultar.setEnabled(false);
            ventanaPrincipal.mostrarPanel(ventanaPrincipal.panelConsultarGato);
        }
        if (e.getSource() == ventanaPrincipal.panelOpcionesCRUD.jButtonActualizarGato) {
            ventanaPrincipal.mostrarPanel(ventanaPrincipal.panelModificarGato);
            cargarDatosTablaPanelModificarGatos();
        }
        if (e.getSource() == ventanaPrincipal.panelOpcionesCRUD.jButtonEliminarGato) {
            ventanaPrincipal.mostrarPanel(ventanaPrincipal.panelEliminarGato);
            cargarDatosTablaPanelEliminarGatos();
        }
        // ActionListener de PanelInsertarGato
        if (e.getSource() == ventanaPrincipal.panelInsertarGato.jButtonInsertarGato) {
            String nombre = ventanaPrincipal.panelInsertarGato.jTextFieldNombreGato.getText();
            Double pesoDouble = (Double) ventanaPrincipal.panelInsertarGato.jSpinnerPesoGato.getValue();
            double pesoRedondeado = Math.round(pesoDouble * 100.0) / 100.0;
            String peso = pesoRedondeado + "";
            int edadInt = (int) ventanaPrincipal.panelInsertarGato.jSpinnerEdadGato.getValue();
            String edad = edadInt + "";
            String raza = (String) ventanaPrincipal.panelInsertarGato.jComboBoxRazaGato.getSelectedItem();
            String color = (String) ventanaPrincipal.panelInsertarGato.jComboBoxColorGato.getSelectedItem();
            String patron = (String) ventanaPrincipal.panelInsertarGato.jComboBoxPatronGato.getSelectedItem();
            String colorOjos = (String) ventanaPrincipal.panelInsertarGato.jComboBoxColorOjosGato.getSelectedItem();
            String cola = (String) ventanaPrincipal.panelInsertarGato.jComboBoxColaGato.getSelectedItem();
            String cantidadBlanco = (String) ventanaPrincipal.panelInsertarGato.jComboBoxCantidadBlanco.getSelectedItem();
            String puntosColor = (String) ventanaPrincipal.panelInsertarGato.jComboBoxPuntosColor.getSelectedItem();
            controlPrincipal.crearInsercionGato(nombre, peso, edad, raza, color, cantidadBlanco, patron, puntosColor, cola, colorOjos);
        }
        if (e.getSource() == ventanaPrincipal.panelInsertarGato.jButtonLimpiarCampos) {
            ventanaPrincipal.panelInsertarGato.limpiarCampos();
        }
        if (e.getSource() == ventanaPrincipal.panelInsertarGato.jButtonAtras) {
            ventanaPrincipal.mostrarPanel(ventanaPrincipal.panelOpcionesCRUD);
        }
        // ActionListener de PanelMostrarGatos
        if (e.getSource() == ventanaPrincipal.panelMostrarGatos.jButtonMasInfo) {
            ventanaPrincipal.panelMostrarGatos.crearDialog(ventanaPrincipal);
            mostrarDatosGatoDialog(ventanaPrincipal.panelMostrarGatos.dialogInformacionGato, ventanaPrincipal.panelMostrarGatos);

        }
        if (e.getSource() == ventanaPrincipal.panelMostrarGatos.jButtonAtras) {
            ventanaPrincipal.mostrarPanel(ventanaPrincipal.panelOpcionesCRUD);
        }
        // ActionListener de PanelConsultarGatos
        if (e.getSource() == ventanaPrincipal.panelConsultarGato.jButtonAtras) {
            ventanaPrincipal.mostrarPanel(ventanaPrincipal.panelOpcionesCRUD);
        }
        if (e.getSource() == ventanaPrincipal.panelConsultarGato.jButtonConsultar) {
            ventanaPrincipal.panelConsultarGato.jScrollPaneTablaGatos.setVisible(true);
            ventanaPrincipal.panelConsultarGato.jTableGatos.setVisible(true);
            ventanaPrincipal.panelConsultarGato.jButtonInfoGato.setEnabled(true);
            if (ventanaPrincipal.panelConsultarGato.jRadioButtonRaza.isSelected()) {
                String nombreRaza = (String) ventanaPrincipal.panelConsultarGato.jComboBoxRaza.getSelectedItem();
                cargarDatosTablaPanelConsultarGatos("nombreRaza", nombreRaza);
            } else if (ventanaPrincipal.panelConsultarGato.jRadioButtonCodigoEMS.isSelected()) {
                String codigoEMS = (String) ventanaPrincipal.panelConsultarGato.jTextFieldCodigoEMS.getText();
                cargarDatosTablaPanelConsultarGatos("codigoEMS", codigoEMS);
            }
        }
        if (e.getSource() == ventanaPrincipal.panelConsultarGato.jButtonLimpiarCampos) {
            ventanaPrincipal.panelConsultarGato.jButtonInfoGato.setEnabled(false);
            ventanaPrincipal.panelConsultarGato.jButtonLimpiarCampos.setEnabled(false);
            ventanaPrincipal.panelConsultarGato.jTextFieldCodigoEMS.setEnabled(false);
            ventanaPrincipal.panelConsultarGato.jComboBoxRaza.setEnabled(false);
            ventanaPrincipal.panelConsultarGato.jLabelTextoCodigoEMS.setEnabled(false);
            ventanaPrincipal.panelConsultarGato.jLabelTextoRaza.setEnabled(false);
            ventanaPrincipal.panelConsultarGato.jButtonConsultar.setEnabled(false);
            ventanaPrincipal.panelConsultarGato.limpiarCampos();
        }
        if (e.getSource() == ventanaPrincipal.panelConsultarGato.jButtonInfoGato) {
            ventanaPrincipal.panelConsultarGato.crearDialog(ventanaPrincipal);
            mostrarDatosGatoDialog(ventanaPrincipal.panelConsultarGato.dialogInformacionGato, ventanaPrincipal.panelConsultarGato);
        }
        if (e.getSource() == ventanaPrincipal.panelConsultarGato.jRadioButtonCodigoEMS) {
            ventanaPrincipal.panelConsultarGato.jLabelTextoRaza.setEnabled(false);
            ventanaPrincipal.panelConsultarGato.jComboBoxRaza.setEnabled(false);
            ventanaPrincipal.panelConsultarGato.jLabelTextoCodigoEMS.setEnabled(true);
            ventanaPrincipal.panelConsultarGato.jTextFieldCodigoEMS.setEnabled(true);
            ventanaPrincipal.panelConsultarGato.jButtonConsultar.setEnabled(true);
            ventanaPrincipal.panelConsultarGato.jButtonLimpiarCampos.setEnabled(true);
        }
        if (e.getSource() == ventanaPrincipal.panelConsultarGato.jRadioButtonRaza) {
            ventanaPrincipal.panelConsultarGato.jLabelTextoRaza.setEnabled(true);
            ventanaPrincipal.panelConsultarGato.jComboBoxRaza.setEnabled(true);
            ventanaPrincipal.panelConsultarGato.jLabelTextoCodigoEMS.setEnabled(false);
            ventanaPrincipal.panelConsultarGato.jTextFieldCodigoEMS.setEnabled(false);
            ventanaPrincipal.panelConsultarGato.jButtonConsultar.setEnabled(true);
            ventanaPrincipal.panelConsultarGato.jButtonLimpiarCampos.setEnabled(true);
        }
        // Action Listener de PanelModificarGato
        if (e.getSource() == ventanaPrincipal.panelModificarGato.jButtonAtras) {
            ventanaPrincipal.mostrarPanel(ventanaPrincipal.panelOpcionesCRUD);
        }
        if (e.getSource() == ventanaPrincipal.panelModificarGato.jButtonMasInfo) {
            mostrarDatosGatoDialogModificar();
        }
        if (e.getSource() == ventanaPrincipal.panelModificarGato.dialogModificarGato.jButtonRealizarCambios) {
            if (modificarDatosGato()) {
                mostrarMensajeExito("Se han hecho los cambios");
                ventanaPrincipal.panelModificarGato.dialogModificarGato.setVisible(false);
                cargarDatosTablaPanelModificarGatos();
            } else {
                mostrarMensajeError("El campo del nombre esta vacio");
            }

        }
        // Action Listener de PanelEliminarGato
        if (e.getSource() == ventanaPrincipal.panelEliminarGato.jButtonAtras) {
            ventanaPrincipal.mostrarPanel(ventanaPrincipal.panelOpcionesCRUD);
        }
        if (e.getSource() == ventanaPrincipal.panelEliminarGato.jButtonIrAEliminar) {
            mostrarDatosGatoDialogEliminar();
        }
        if (e.getSource() == ventanaPrincipal.panelEliminarGato.dialogEliminarGato.jButtonEliminarGato) {
            int filaSeleccionada = ventanaPrincipal.panelEliminarGato.jTable1.getSelectedRow();

            int idGatoSeleccionado = obtenerIdGatoSeleccionado(ventanaPrincipal.panelEliminarGato.jTable1, filaSeleccionada);

            controlPrincipal.eliminarGato(idGatoSeleccionado);
            ventanaPrincipal.mostrarMensajeExito("Se ha eliminado el gato seleccionado");
            ventanaPrincipal.panelEliminarGato.dialogEliminarGato.setVisible(false);
            cargarDatosTablaPanelEliminarGatos();

        }
    }

    /**
     * Verifica si los botones de propiedades de gatos y de base de datos están
     * inactivos. Si ambos están deshabilitados, habilita el botón "Continuar".
     */
    public void verificarBotonesInctivos() {
        if (!ventanaPrincipal.panelPrincipal.jButtonPropiedadesGatos.isEnabled() && !ventanaPrincipal.panelPrincipal.jButtonPropiedadesBD.isEnabled()) {
            ventanaPrincipal.panelPrincipal.jButtonContinuar.setEnabled(true);
        }
    }

    /**
     * Carga los datos de los gatos en la tabla del panel "Mostrar Gatos". Borra
     * previamente el contenido de la tabla antes de insertar los nuevos datos.
     */
    public void cargarDatosTablaPanelMostrarGatos() {
        Object[][] datosGatos = controlPrincipal.darListaGatosObject();
        ventanaPrincipal.panelMostrarGatos.modeloTablaGatos.setRowCount(0);
        for (Object[] fila : datosGatos) {
            ventanaPrincipal.panelMostrarGatos.modeloTablaGatos.addRow(fila);
        }
    }

    /**
     * Carga los datos de los gatos en la tabla del panel "Eliminar Gatos".
     * Borra previamente el contenido de la tabla antes de insertar los nuevos
     * datos.
     */
    public void cargarDatosTablaPanelEliminarGatos() {
        Object[][] datosGatos = controlPrincipal.darListaGatosObject();
        ventanaPrincipal.panelEliminarGato.modeloTablaGatos.setRowCount(0);
        for (Object[] fila : datosGatos) {
            ventanaPrincipal.panelEliminarGato.modeloTablaGatos.addRow(fila);
        }
    }

    /**
     * Carga los datos de los gatos en la tabla del panel "Modificar Gatos".
     * Borra previamente el contenido de la tabla antes de insertar los nuevos
     * datos.
     */
    public void cargarDatosTablaPanelModificarGatos() {
        Object[][] datosGatos = controlPrincipal.darListaGatosObject();
        ventanaPrincipal.panelModificarGato.modeloTablaGatos.setRowCount(0);
        for (Object[] fila : datosGatos) {
            ventanaPrincipal.panelModificarGato.modeloTablaGatos.addRow(fila);
        }
    }

    /**
     * Carga los datos de los gatos en la tabla del panel "Consultar Gatos" en
     * base al factor de búsqueda y al dato proporcionado.
     *
     * @param factorBusqueda El criterio de búsqueda (por ejemplo, raza o código
     * EMS).
     * @param datoBuscado El valor a buscar según el factor seleccionado.
     */
    public void cargarDatosTablaPanelConsultarGatos(String factorBusqueda, String datoBuscado) {
        Object[][] datosGatos = controlPrincipal.pedirConsultaGatos(factorBusqueda, datoBuscado);
        ventanaPrincipal.panelConsultarGato.modeloTablaGatos.setRowCount(0);
        for (Object[] fila : datosGatos) {
            ventanaPrincipal.panelConsultarGato.modeloTablaGatos.addRow(fila);
        }
    }

    /**
     * Muestra los datos completos del gato seleccionado en la tabla del panel
     * "Modificar Gatos" dentro de un cuadro de diálogo con campos de texto,
     * etiquetas e imagen del gato. Si no hay ninguna fila seleccionada, muestra
     * un mensaje de error.
     */
    public void mostrarDatosGatoDialogModificar() {
        int filaSeleccionada = ventanaPrincipal.panelModificarGato.jTable1.getSelectedRow();

        if (filaSeleccionada != -1) {
            Object IdGatoObject = ventanaPrincipal.panelModificarGato.jTable1.getValueAt(filaSeleccionada, 0);
            int idGatoSeleccionado = (IdGatoObject instanceof Integer)
                    ? (Integer) IdGatoObject
                    : Integer.parseInt(IdGatoObject.toString());
            Object[] datosGatoSeleccionado = controlPrincipal.pedirConsultaGato(idGatoSeleccionado);

            ventanaPrincipal.panelModificarGato.dialogModificarGato.jLabelIdGato.setText(String.valueOf(datosGatoSeleccionado[0]));
            ventanaPrincipal.panelModificarGato.dialogModificarGato.jLabelNombreGato.setText(String.valueOf(datosGatoSeleccionado[1]));
            ventanaPrincipal.panelModificarGato.dialogModificarGato.jLabelPesoGato.setText(String.valueOf(datosGatoSeleccionado[2]));
            ventanaPrincipal.panelModificarGato.dialogModificarGato.jLabelEdadGato.setText(String.valueOf(datosGatoSeleccionado[3]));
            ventanaPrincipal.panelModificarGato.dialogModificarGato.jLabelRazaGato.setText(String.valueOf(datosGatoSeleccionado[4]));
            ventanaPrincipal.panelModificarGato.dialogModificarGato.jLabelEMSGato.setText(String.valueOf(datosGatoSeleccionado[5]));

            String codigoEMS = (String) datosGatoSeleccionado[5];
            String[] atributosGato = codigoEMS.split("/");

            // Interpretar cada atributo EMS y mostrarlo
            String color = controlPrincipal.identificarColorCuerpoSegunEMS(new String[]{atributosGato[1]});
            String cantidadBlanco = controlPrincipal.identificarCantidadBlancosSegunEMS(new String[]{atributosGato[2]});
            String patron = controlPrincipal.identificarPatronSegunEMS(new String[]{atributosGato[3]});
            String puntosColor = controlPrincipal.identificarPuntosColorSegunEMS(new String[]{atributosGato[4]});
            String cola = controlPrincipal.identificarColaSegunEMS(new String[]{atributosGato[5]});
            String colorOjos = controlPrincipal.identificarColorOjosSegunEMS(new String[]{atributosGato[6]});

            ventanaPrincipal.panelModificarGato.dialogModificarGato.jLabelColorGato.setText(color);
            ventanaPrincipal.panelModificarGato.dialogModificarGato.jLabelPatronGato.setText(patron);
            ventanaPrincipal.panelModificarGato.dialogModificarGato.jLabelColorOjosGato.setText(colorOjos);
            ventanaPrincipal.panelModificarGato.dialogModificarGato.jLabelColaGato.setText(cola);
            ventanaPrincipal.panelModificarGato.dialogModificarGato.jLabelCantidadBlanco.setText(cantidadBlanco);
            ventanaPrincipal.panelModificarGato.dialogModificarGato.jLabelPuntosColor.setText(puntosColor);

            // Cargar datos editables
            ventanaPrincipal.panelModificarGato.dialogModificarGato.jTextFieldNombre.setText(String.valueOf(datosGatoSeleccionado[1]));
            double peso = Double.parseDouble(datosGatoSeleccionado[2].toString());
            int edad = Integer.parseInt(datosGatoSeleccionado[3].toString());
            ventanaPrincipal.panelModificarGato.dialogModificarGato.jSpinnerPeso.setValue(peso);
            ventanaPrincipal.panelModificarGato.dialogModificarGato.jSpinnerEdad.setValue(edad);

            // Mostrar imagen del gato
            ventanaPrincipal.panelModificarGato.dialogModificarGato.jLabelImagenGato.setIcon(
                    new ImageIcon(System.getProperty("user.dir") + "/src/main/java/edu/progAvUD/parcialPrimerCorte/Imagenes/" + atributosGato[0] + ".png")
            );

            ventanaPrincipal.panelModificarGato.dialogModificarGato.setVisible(true);
        } else {
            ventanaPrincipal.mostrarMensajeError("No se ha seleccionado ninguna fila de la tabla.");
        }
    }

    /**
     * Muestra los datos del gato seleccionado en el panel de eliminación dentro
     * del diálogo de confirmación de eliminación.
     */
    public void mostrarDatosGatoDialogEliminar() {
        int filaSeleccionada = ventanaPrincipal.panelEliminarGato.jTable1.getSelectedRow();

        // Verifica si se ha seleccionado una fila en la tabla
        if (filaSeleccionada != -1) {
            // Obtiene el ID del gato seleccionado (puede ser Integer o String)
            Object IdGatoObject = ventanaPrincipal.panelEliminarGato.jTable1.getValueAt(filaSeleccionada, 0);
            int idGatoSeleccionado = (IdGatoObject instanceof Integer)
                    ? (Integer) IdGatoObject
                    : Integer.parseInt(IdGatoObject.toString());

            // Solicita los datos del gato al controlador principal
            Object[] datosGatoSeleccionado = controlPrincipal.pedirConsultaGato(idGatoSeleccionado);

            // Muestra los datos básicos del gato en el diálogo
            ventanaPrincipal.panelEliminarGato.dialogEliminarGato.jLabelIdGato.setText(String.valueOf(datosGatoSeleccionado[0]));
            ventanaPrincipal.panelEliminarGato.dialogEliminarGato.jLabelNombreGato.setText(String.valueOf(datosGatoSeleccionado[1]));
            ventanaPrincipal.panelEliminarGato.dialogEliminarGato.jLabelPesoGato.setText(String.valueOf(datosGatoSeleccionado[2]));
            ventanaPrincipal.panelEliminarGato.dialogEliminarGato.jLabelEdadGato.setText(String.valueOf(datosGatoSeleccionado[3]));
            ventanaPrincipal.panelEliminarGato.dialogEliminarGato.jLabelRazaGato.setText(String.valueOf(datosGatoSeleccionado[4]));
            ventanaPrincipal.panelEliminarGato.dialogEliminarGato.jLabelEMSGato.setText(String.valueOf(datosGatoSeleccionado[5]));

            // Procesa el código EMS para mostrar características adicionales del gato
            String codigoEMS = (String) datosGatoSeleccionado[5];
            String[] atributosGato = codigoEMS.split("/");

            // Se identifican y muestran las características específicas a partir del código EMS
            String color = controlPrincipal.identificarColorCuerpoSegunEMS(new String[]{atributosGato[1]});
            String cantidadBlanco = controlPrincipal.identificarCantidadBlancosSegunEMS(new String[]{atributosGato[2]});
            String patron = controlPrincipal.identificarPatronSegunEMS(new String[]{atributosGato[3]});
            String puntosColor = controlPrincipal.identificarPuntosColorSegunEMS(new String[]{atributosGato[4]});
            String cola = controlPrincipal.identificarColaSegunEMS(new String[]{atributosGato[5]});
            String colorOjos = controlPrincipal.identificarColorOjosSegunEMS(new String[]{atributosGato[6]});

            // Asigna los valores procesados al diálogo
            ventanaPrincipal.panelEliminarGato.dialogEliminarGato.jLabelColorGato.setText(color);
            ventanaPrincipal.panelEliminarGato.dialogEliminarGato.jLabelPatronGato.setText(patron);
            ventanaPrincipal.panelEliminarGato.dialogEliminarGato.jLabelColorOjosGato.setText(colorOjos);
            ventanaPrincipal.panelEliminarGato.dialogEliminarGato.jLabelColaGato.setText(cola);
            ventanaPrincipal.panelEliminarGato.dialogEliminarGato.jLabelCantidadBlanco.setText(cantidadBlanco);
            ventanaPrincipal.panelEliminarGato.dialogEliminarGato.jLabelPuntosColor.setText(puntosColor);

            // Carga y muestra la imagen correspondiente al gato
            ventanaPrincipal.panelEliminarGato.dialogEliminarGato.jLabelImagenGato.setIcon(
                    new ImageIcon(System.getProperty("user.dir")
                            + "/src/main/java/edu/progAvUD/parcialPrimerCorte/Imagenes/"
                            + atributosGato[0] + ".png"));

            // Muestra el diálogo
            ventanaPrincipal.panelEliminarGato.dialogEliminarGato.setVisible(true);
        } else {
            // Si no se seleccionó ninguna fila, muestra un mensaje de error
            ventanaPrincipal.mostrarMensajeError("No se ha seleccionado ninguna fila de la tabla.");
        }
    }

    /**
     * Muestra los datos de un gato seleccionado en un diálogo genérico
     * (información). El panel puede ser de consulta o de visualización general.
     */
    public void mostrarDatosGatoDialog(DialogInformacionGato dialogInformacionGato, JPanel panel) {
        JTable tablaGatos = null;

        // Determina de qué panel proviene la tabla
        if (panel instanceof PanelMostrarGatos) {
            tablaGatos = ventanaPrincipal.panelMostrarGatos.jTable1;
        } else if (panel instanceof PanelConsultarGato) {
            tablaGatos = ventanaPrincipal.panelConsultarGato.jTableGatos;
        }

        // Si se encontró la tabla, se continúa
        if (tablaGatos != null) {
            int filaSeleccionada = tablaGatos.getSelectedRow();

            // Verifica que se haya seleccionado una fila
            if (filaSeleccionada != -1) {
                int idGatoSeleccionado = obtenerIdGatoSeleccionado(tablaGatos, filaSeleccionada);
                Object[] datosGatoSeleccionado = controlPrincipal.pedirConsultaGato(idGatoSeleccionado);
                actualizarDialogInformacionGato(dialogInformacionGato, datosGatoSeleccionado);
                dialogInformacionGato.setVisible(true);
            } else {
                ventanaPrincipal.mostrarMensajeError("No se ha seleccionado ninguna fila de la tabla.");
            }
        }
    }

    /**
     * Extrae el ID del gato desde la tabla, independientemente de si es Integer
     * o String.
     */
    private int obtenerIdGatoSeleccionado(JTable tablaGatos, int filaSeleccionada) {
        Object IdGatoObject = tablaGatos.getValueAt(filaSeleccionada, 0);
        return (IdGatoObject instanceof Integer)
                ? (Integer) IdGatoObject
                : Integer.parseInt(IdGatoObject.toString());
    }

    /**
     * Actualiza los campos del diálogo con la información del gato (datos y
     * características EMS).
     */
    private void actualizarDialogInformacionGato(DialogInformacionGato dialogInformacionGato, Object[] datosGatoSeleccionado) {
        dialogInformacionGato.jLabelIdGato.setText(String.valueOf(datosGatoSeleccionado[0]));
        dialogInformacionGato.jLabelNombreGato.setText(String.valueOf(datosGatoSeleccionado[1]));
        dialogInformacionGato.jLabelPesoGato.setText(String.valueOf(datosGatoSeleccionado[2]));
        dialogInformacionGato.jLabelEdadGato.setText(String.valueOf(datosGatoSeleccionado[3]));
        dialogInformacionGato.jLabelRazaGato.setText(String.valueOf(datosGatoSeleccionado[4]));
        dialogInformacionGato.jLabelEMSGato.setText(String.valueOf(datosGatoSeleccionado[5]));

        // Procesa el código EMS para mostrar las características específicas
        String codigoEMS = (String) datosGatoSeleccionado[5];
        String[] atributosGato = codigoEMS.split("/");

        // Actualiza los campos gráficos con los valores derivados del código EMS
        dialogInformacionGato.jLabelColorGato.setText(controlPrincipal.identificarColorCuerpoSegunEMS(new String[]{atributosGato[1]}));
        dialogInformacionGato.jLabelCantidadBlanco.setText(controlPrincipal.identificarCantidadBlancosSegunEMS(new String[]{atributosGato[2]}));
        dialogInformacionGato.jLabelPatronGato.setText(controlPrincipal.identificarPatronSegunEMS(new String[]{atributosGato[3]}));
        dialogInformacionGato.jLabelPuntosColor.setText(controlPrincipal.identificarPuntosColorSegunEMS(new String[]{atributosGato[4]}));
        dialogInformacionGato.jLabelColaGato.setText(controlPrincipal.identificarColaSegunEMS(new String[]{atributosGato[5]}));
        dialogInformacionGato.jLabelColorOjosGato.setText(controlPrincipal.identificarColorOjosSegunEMS(new String[]{atributosGato[6]}));

        // Muestra la imagen correspondiente al gato
        dialogInformacionGato.jLabelImagenGato.setIcon(new ImageIcon(System.getProperty("user.dir")
                + "/src/main/java/edu/progAvUD/parcialPrimerCorte/Imagenes/" + atributosGato[0] + ".png"));
    }

    /**
     * Modifica los datos de nombre, peso y edad del gato si fueron cambiados.
     */
    private boolean modificarDatosGato() {
        int filaSeleccionada = ventanaPrincipal.panelModificarGato.jTable1.getSelectedRow();

        int idGatoSeleccionado = obtenerIdGatoSeleccionado(ventanaPrincipal.panelModificarGato.jTable1, filaSeleccionada);

        // Se obtienen los valores actuales
        String nombreActual = ventanaPrincipal.panelModificarGato.dialogModificarGato.jLabelNombreGato.getText();
        String pesoActual = ventanaPrincipal.panelModificarGato.dialogModificarGato.jLabelPesoGato.getText();
        String edadActual = ventanaPrincipal.panelModificarGato.dialogModificarGato.jLabelEdadGato.getText();

        // Se obtienen los valores nuevos
        String nombreCambio = ventanaPrincipal.panelModificarGato.dialogModificarGato.jTextFieldNombre.getText();
        Double pesoDouble = (Double) ventanaPrincipal.panelModificarGato.dialogModificarGato.jSpinnerPeso.getValue();
        double pesoRedondeado = Math.round(pesoDouble * 100.0) / 100.0; // redondea a 2 decimales
        String pesoCambio = pesoRedondeado + "";
        int edadInt = (int) ventanaPrincipal.panelModificarGato.dialogModificarGato.jSpinnerEdad.getValue();
        String edadCambio = edadInt + "";

        // Si el nuevo nombre está vacío, no se permite continuar
        if (nombreCambio.isBlank()) {
            return false;
        }

        // Compara los valores y actualiza solo los que han cambiado
        if (!nombreActual.equals(nombreCambio)) {
            controlPrincipal.modificarGato(idGatoSeleccionado, "nombre", nombreCambio);
        }
        if (!pesoActual.equals(pesoCambio)) {
            controlPrincipal.modificarGato(idGatoSeleccionado, "peso", pesoCambio);
        }
        if (!edadActual.equals(edadCambio)) {
            controlPrincipal.modificarGato(idGatoSeleccionado, "edad", edadCambio);
        }
        return true;
    }

    /**
     * Solicita al usuario que seleccione un archivo de propiedades. Este
     * archivo puede contener configuraciones necesarias para el programa.
     *
     * @return el archivo seleccionado por el usuario.
     */
    public File pedirArchivoPropiedades() {
        return ventanaPrincipal.pedirArchivoPropiedades();
    }

    /**
     * Muestra un mensaje de error al usuario, generalmente mediante un cuadro
     * de diálogo.
     *
     * @param mensaje el mensaje de error que se desea mostrar.
     */
    public void mostrarMensajeError(String mensaje) {
        ventanaPrincipal.mostrarMensajeError(mensaje);
    }

    /**
     * Muestra un mensaje de éxito al usuario, generalmente cuando una acción se
     * realiza correctamente.
     *
     * @param mensaje el mensaje de éxito que se desea mostrar.
     */
    public void mostrarMensajeExito(String mensaje) {
        ventanaPrincipal.mostrarMensajeExito(mensaje);
    }

    /**
     * Muestra un cuadro de diálogo para que el usuario seleccione una opción
     * cuando falta un dato obligatorio.
     *
     * @param datoFaltante descripción del dato faltante.
     * @param opciones lista de opciones disponibles para elegir.
     * @return la opción seleccionada por el usuario.
     */
    public Object mostrarJOptionSeleccionarDatoFaltante(String datoFaltante, Object[] opciones) {
        return ventanaPrincipal.mostrarJOptionSeleccionarDatoFaltante(datoFaltante, opciones);
    }

    /**
     * Muestra un cuadro de diálogo para que el usuario escriba un dato que
     * falta.
     *
     * @param datoFaltante descripción del dato que debe ingresar el usuario.
     * @return el texto ingresado por el usuario.
     */
    public String mostrarJOptionEscribirDatoFaltante(String datoFaltante) {
        return ventanaPrincipal.mostrarJOptionEscribirDatoFaltante(datoFaltante);
    }

    /**
     * Solicita al usuario que seleccione un archivo aleatorio desde un
     * directorio. Puede lanzar una excepción si el usuario cancela o ocurre un
     * error.
     *
     * @return el archivo seleccionado por el usuario.
     * @throws NullPointerException si no se selecciona ningún archivo.
     * @throws IOException si ocurre un error al acceder al archivo.
     */
    public File pedirArchivoAleatorio() throws NullPointerException, IOException {
        return ventanaPrincipal.pedirDirectorioArchivoAleatorio();
    }

    /**
     * Solicita al usuario que proporcione un nombre para un archivo. Se usa
     * normalmente al guardar un nuevo archivo.
     *
     * @return el nombre ingresado por el usuario.
     */
    public String pedirNombreArchivo() {
        return ventanaPrincipal.pedirNombreArchivo();
    }

}