package edu.progAvUD.parcialPrimerCorte.control;

import edu.progAvUD.parcialPrimerCorte.vista.DialogInformacionGato;
import edu.progAvUD.parcialPrimerCorte.vista.PanelConsultarGato;
import edu.progAvUD.parcialPrimerCorte.vista.PanelMostrarGatos;
import edu.progAvUD.parcialPrimerCorte.vista.VentanaPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JTable;

/**
 *
 * @author Andres Felipe
 */
public class ControlGrafico implements ActionListener {

    private ControlPrincipal controlPrincipal;
    private VentanaPrincipal ventanaPrincipal;

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

        ventanaPrincipal.panelEliminarGato.jButtonAtras.addActionListener(this);
        ventanaPrincipal.panelEliminarGato.jButtonIrAEliminar.addActionListener(this);
    }

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

            controlPrincipal.crearInsercionGato(nombre, peso, edad, raza, color, patron, colorOjos, cola);
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
            mostrarDatosGatoDialogMostrarGatos(ventanaPrincipal.panelMostrarGatos.dialogInformacionGato, ventanaPrincipal.panelMostrarGatos);

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
            mostrarDatosGatoDialogMostrarGatos(ventanaPrincipal.panelConsultarGato.dialogInformacionGato, ventanaPrincipal.panelConsultarGato);
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
            ventanaPrincipal.panelModificarGato.crearDialog(ventanaPrincipal);
            ventanaPrincipal.panelModificarGato.dialogModificarGato.setVisible(true);
        }
        // Action Listener de PanelEliminarGato
        if (e.getSource() == ventanaPrincipal.panelEliminarGato.jButtonAtras) {
            ventanaPrincipal.mostrarPanel(ventanaPrincipal.panelOpcionesCRUD);
        }
        if (e.getSource() == ventanaPrincipal.panelEliminarGato.jButtonIrAEliminar) {
            ventanaPrincipal.panelEliminarGato.crearDialog(ventanaPrincipal);
            ventanaPrincipal.panelModificarGato.dialogModificarGato.setVisible(true);
        }
    }

    public void verificarBotonesInctivos() {
        if (!ventanaPrincipal.panelPrincipal.jButtonPropiedadesGatos.isEnabled() && !ventanaPrincipal.panelPrincipal.jButtonPropiedadesBD.isEnabled()) {
            ventanaPrincipal.panelPrincipal.jButtonContinuar.setEnabled(true);
        }
    }

    public void cargarDatosTablaPanelMostrarGatos() {
        Object[][] datosGatos = controlPrincipal.darListaGatosObject();
        ventanaPrincipal.panelMostrarGatos.modeloTablaGatos.setRowCount(0);
        for (Object[] fila : datosGatos) {
            ventanaPrincipal.panelMostrarGatos.modeloTablaGatos.addRow(fila);
        }
    }

    public void cargarDatosTablaPanelEliminarGatos() {
        Object[][] datosGatos = controlPrincipal.darListaGatosObject();
        ventanaPrincipal.panelEliminarGato.modeloTablaGatos.setRowCount(0);
        for (Object[] fila : datosGatos) {
            ventanaPrincipal.panelEliminarGato.modeloTablaGatos.addRow(fila);
        }
    }

    public void cargarDatosTablaPanelModificarGatos() {
        Object[][] datosGatos = controlPrincipal.darListaGatosObject();
        ventanaPrincipal.panelModificarGato.modeloTablaGatos.setRowCount(0);
        for (Object[] fila : datosGatos) {
            ventanaPrincipal.panelModificarGato.modeloTablaGatos.addRow(fila);
        }
    }

    public void cargarDatosTablaPanelConsultarGatos(String factorBusqueda, String datoBuscado) {
        Object[][] datosGatos = controlPrincipal.pedirConsultaGatos(factorBusqueda, datoBuscado);
        ventanaPrincipal.panelConsultarGato.modeloTablaGatos.setRowCount(0);
        for (Object[] fila : datosGatos) {
            ventanaPrincipal.panelConsultarGato.modeloTablaGatos.addRow(fila);
        }
    }

    public void mostrarDatosGatoDialogMostrarGatos(DialogInformacionGato dialogInformacionGato, JPanel panel) {
        JTable tablaGatos = null;

        if (panel instanceof PanelMostrarGatos) {
            tablaGatos = ventanaPrincipal.panelMostrarGatos.jTable1;
        } else if (panel instanceof PanelConsultarGato) {
            tablaGatos = ventanaPrincipal.panelConsultarGato.jTableGatos;
        }

        if (tablaGatos != null) {
            int filaSeleccionada = tablaGatos.getSelectedRow();

            if (filaSeleccionada != -1) { // Verificar que se haya seleccionado una fila
                int idGatoSeleccionado = obtenerIdGatoSeleccionado(tablaGatos, filaSeleccionada);
                Object[] datosGatoSeleccionado = controlPrincipal.pedirConsultaGato(idGatoSeleccionado);
                actualizarDialogInformacionGato(dialogInformacionGato, datosGatoSeleccionado);
                dialogInformacionGato.setVisible(true);
            } else {
                ventanaPrincipal.mostrarMensajeError("No se ha seleccionado ninguna fila de la tabla.");
            }
        }
    }

    private int obtenerIdGatoSeleccionado(JTable tablaGatos, int filaSeleccionada) {
        Object IdGatoObject = tablaGatos.getValueAt(filaSeleccionada, 0);
        return (IdGatoObject instanceof Integer)
                ? (Integer) IdGatoObject
                : Integer.parseInt(IdGatoObject.toString());
    }

    private void actualizarDialogInformacionGato(DialogInformacionGato dialogInformacionGato, Object[] datosGatoSeleccionado) {
        dialogInformacionGato.jLabelIdGato.setText(String.valueOf(datosGatoSeleccionado[0]));
        dialogInformacionGato.jLabelNombreGato.setText(String.valueOf(datosGatoSeleccionado[1]));
        dialogInformacionGato.jLabelPesoGato.setText(String.valueOf(datosGatoSeleccionado[2]));
        dialogInformacionGato.jLabelEdadGato.setText(String.valueOf(datosGatoSeleccionado[3]));
        dialogInformacionGato.jLabelRazaGato.setText(String.valueOf(datosGatoSeleccionado[4]));
        dialogInformacionGato.jLabelEMSGato.setText(String.valueOf(datosGatoSeleccionado[5]));

        String codigoEMS = (String) datosGatoSeleccionado[5];
        String[] atributosGato = codigoEMS.split("/");
        dialogInformacionGato.jLabelColorGato.setText(controlPrincipal.identificarColorCuerpoSegunEMS(new String[]{atributosGato[1]}));
        dialogInformacionGato.jLabelPatronGato.setText(controlPrincipal.identificarPatronSegunEMS(new String[]{atributosGato[2]}));
        dialogInformacionGato.jLabelColorOjosGato.setText(controlPrincipal.identificarColorOjosSegunEMS(new String[]{atributosGato[3]}));
        dialogInformacionGato.jLabelColaGato.setText(controlPrincipal.identificarColaSegunEMS(new String[]{atributosGato[4]}));

        dialogInformacionGato.jLabelImagenGato.setIcon(new ImageIcon(System.getProperty("user.dir") + "/src/main/java/edu/progAvUD/parcialPrimerCorte/Imagenes/" + atributosGato[0] + ".png"));
    }

    public File pedirArchivoPropiedades() {
        return ventanaPrincipal.pedirArchivoPropiedades();
    }

    public void mostrarMensajeError(String mensaje) {
        ventanaPrincipal.mostrarMensajeError(mensaje);
    }

    public void mostrarMensajeExito(String mensaje) {
        ventanaPrincipal.mostrarMensajeExito(mensaje);
    }

    public Object mostrarJOptionSeleccionarDatoFaltante(String datoFaltante, Object[] opciones) {
        return ventanaPrincipal.mostrarJOptionSeleccionarDatoFaltante(datoFaltante, opciones);
    }

    public String mostrarJOptionEscribirDatoFaltante(String datoFaltante) {
        return ventanaPrincipal.mostrarJOptionEscribirDatoFaltante(datoFaltante);
    }

    public File pedirArchivoAleatorio() throws NullPointerException, IOException {
        return ventanaPrincipal.pedirDirectorioArchivoAleatorio();
    }

    public String pedirNombreArchivo() {
        return ventanaPrincipal.pedirNombreArchivo();
    }
}
