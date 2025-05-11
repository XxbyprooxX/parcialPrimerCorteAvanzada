package edu.progAvUD.parcialPrimerCorte.control;

import edu.progAvUD.parcialPrimerCorte.vista.VentanaPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.swing.ImageIcon;

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

        ventanaPrincipal.panelModificarGato.jButtonAtras.addActionListener(this);

        ventanaPrincipal.panelEliminarGato.jButtonAtras.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == ventanaPrincipal.jMenuItemSalir) {
            controlPrincipal.crearArchivoAleatorio();
        }
        if(e.getSource()== ventanaPrincipal.jMenuItemSerializar){
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
            ventanaPrincipal.mostrarPanel(ventanaPrincipal.panelConsultarGato);
        }
        if (e.getSource() == ventanaPrincipal.panelOpcionesCRUD.jButtonActualizarGato) {
            ventanaPrincipal.mostrarPanel(ventanaPrincipal.panelModificarGato);
        }
        if (e.getSource() == ventanaPrincipal.panelOpcionesCRUD.jButtonEliminarGato) {
            ventanaPrincipal.mostrarPanel(ventanaPrincipal.panelEliminarGato);
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
            mostrarDatosGatoDialogMostrarGatos();

        }
        if (e.getSource() == ventanaPrincipal.panelMostrarGatos.jButtonAtras) {
            ventanaPrincipal.mostrarPanel(ventanaPrincipal.panelOpcionesCRUD);
        }
        // ActionListener de PanelConsultarGatos
        if (e.getSource() == ventanaPrincipal.panelConsultarGato.jButtonAtras) {
            ventanaPrincipal.mostrarPanel(ventanaPrincipal.panelOpcionesCRUD);
        }
        // Action Listener de PanelModificarGato
        if (e.getSource() == ventanaPrincipal.panelModificarGato.jButtonAtras) {
            ventanaPrincipal.mostrarPanel(ventanaPrincipal.panelOpcionesCRUD);
        }
        // Action Listener de PanelEliminarGato
        if (e.getSource() == ventanaPrincipal.panelEliminarGato.jButtonAtras) {
            ventanaPrincipal.mostrarPanel(ventanaPrincipal.panelOpcionesCRUD);
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

    public void mostrarDatosGatoDialogMostrarGatos() {
        int filaSeleccionada = ventanaPrincipal.panelMostrarGatos.jTable1.getSelectedRow();

        if (filaSeleccionada != -1) { // Verificar que se haya seleccionado una fila
            Object IdGatoObject = ventanaPrincipal.panelMostrarGatos.jTable1.getValueAt(filaSeleccionada, 0);
            int idGatoSeleccionado = (IdGatoObject instanceof Integer)
                    ? (Integer) IdGatoObject
                    : Integer.parseInt(IdGatoObject.toString());
            Object[] datosGatoSeleccionado = controlPrincipal.pedirConsultaGato(idGatoSeleccionado);
            ventanaPrincipal.panelMostrarGatos.dialogInformacionGato.jLabelIdGato.setText(String.valueOf(datosGatoSeleccionado[0]));
            ventanaPrincipal.panelMostrarGatos.dialogInformacionGato.jLabelNombreGato.setText(String.valueOf(datosGatoSeleccionado[1]));
            ventanaPrincipal.panelMostrarGatos.dialogInformacionGato.jLabelPesoGato.setText(String.valueOf(datosGatoSeleccionado[2]));
            ventanaPrincipal.panelMostrarGatos.dialogInformacionGato.jLabelEdadGato.setText(String.valueOf(datosGatoSeleccionado[3]));
            ventanaPrincipal.panelMostrarGatos.dialogInformacionGato.jLabelRazaGato.setText(String.valueOf(datosGatoSeleccionado[4]));
            ventanaPrincipal.panelMostrarGatos.dialogInformacionGato.jLabelEMSGato.setText(String.valueOf(datosGatoSeleccionado[5]));
            String codigoEMS = (String) datosGatoSeleccionado[5];
            String[] atributosGato = codigoEMS.split("/");
            String color = controlPrincipal.identificarColorCuerpoSegunEMS(new String[]{atributosGato[1]});
            String patron = controlPrincipal.identificarPatronSegunEMS(new String[]{atributosGato[2]});
            String colorOjos = controlPrincipal.identificarColorOjosSegunEMS(new String[]{atributosGato[3]});
            String cola = controlPrincipal.identificarColaSegunEMS(new String[]{atributosGato[4]});
            ventanaPrincipal.panelMostrarGatos.dialogInformacionGato.jLabelColorGato.setText(color);
            ventanaPrincipal.panelMostrarGatos.dialogInformacionGato.jLabelPatronGato.setText(patron);
            ventanaPrincipal.panelMostrarGatos.dialogInformacionGato.jLabelColorOjosGato.setText(colorOjos);
            ventanaPrincipal.panelMostrarGatos.dialogInformacionGato.jLabelColaGato.setText(cola);

            //ventanaPrincipal.panelMostrarGatos.dialogInformacionGato.jLabelImagenGato.setIcon(new ImageIcon(System.getProperty("user.dir") + "/src/main/java/edu/progAvUD/parcialPrimerCorte/Imagenes/"+atributosGato[0]+".png"));
            ventanaPrincipal.panelMostrarGatos.dialogInformacionGato.setVisible(true);
        } else {
            ventanaPrincipal.mostrarMensajeError("No se ha seleccionado ninguna fila de la tabla.");
        }

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
    
    public String pedirNombreArchivo(){
        return ventanaPrincipal.pedirNombreArchivo();
    }
}
