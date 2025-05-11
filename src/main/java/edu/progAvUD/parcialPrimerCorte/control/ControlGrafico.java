package edu.progAvUD.parcialPrimerCorte.control;

import edu.progAvUD.parcialPrimerCorte.vista.VentanaPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

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
        if(e.getSource()== ventanaPrincipal.jMenuItemSalir){
            
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
        if(e.getSource() == ventanaPrincipal.panelOpcionesCRUD.jButtonVerGatos){
            ventanaPrincipal.mostrarPanel(ventanaPrincipal.panelMostrarGatos);
            cargarDatosTablaPanelMostrarGatos();
        }
        if(e.getSource() == ventanaPrincipal.panelOpcionesCRUD.jButtonCrearGato){
            ventanaPrincipal.mostrarPanel(ventanaPrincipal.panelInsertarGato);
        }
        if(e.getSource() == ventanaPrincipal.panelOpcionesCRUD.jButtonBuscarGato){
            ventanaPrincipal.mostrarPanel(ventanaPrincipal.panelConsultarGato);
        }
        if(e.getSource() == ventanaPrincipal.panelOpcionesCRUD.jButtonActualizarGato){
            ventanaPrincipal.mostrarPanel(ventanaPrincipal.panelModificarGato);
        }
        if(e.getSource() == ventanaPrincipal.panelOpcionesCRUD.jButtonEliminarGato){
            ventanaPrincipal.mostrarPanel(ventanaPrincipal.panelEliminarGato);
        }
        // ActionListener de PanelInsertarGato
        if(e.getSource() == ventanaPrincipal.panelInsertarGato.jButtonInsertarGato){
            String nombre = ventanaPrincipal.panelInsertarGato.jTextFieldNombreGato.getText();
            Double pesoDouble = (Double) ventanaPrincipal.panelInsertarGato.jSpinnerPesoGato.getValue();
            double pesoRedondeado = Math.round(pesoDouble * 100.0) / 100.0;
            String peso = pesoRedondeado+"";
            int edadInt = (int) ventanaPrincipal.panelInsertarGato.jSpinnerEdadGato.getValue();
            String edad = edadInt+"";
            String raza = (String) ventanaPrincipal.panelInsertarGato.jComboBoxRazaGato.getSelectedItem();
            String color = (String) ventanaPrincipal.panelInsertarGato.jComboBoxColorGato.getSelectedItem();
            String patron = (String) ventanaPrincipal.panelInsertarGato.jComboBoxPatronGato.getSelectedItem();
            String colorOjos = (String) ventanaPrincipal.panelInsertarGato.jComboBoxColorOjosGato.getSelectedItem();
            String cola = (String) ventanaPrincipal.panelInsertarGato.jComboBoxColaGato.getSelectedItem();
            
            controlPrincipal.crearInsercionGato(nombre, peso, edad, raza, color, patron, colorOjos, cola);
        }
        if(e.getSource() == ventanaPrincipal.panelInsertarGato.jButtonLimpiarCampos){
            ventanaPrincipal.panelInsertarGato.limpiarCampos();
        }
        if(e.getSource() == ventanaPrincipal.panelInsertarGato.jButtonAtras){
            ventanaPrincipal.mostrarPanel(ventanaPrincipal.panelOpcionesCRUD);
        }
        // ActionListener de PanelMostrarGatos
        if(e.getSource() == ventanaPrincipal.panelMostrarGatos.jButtonMasInfo){
            ventanaPrincipal.panelMostrarGatos.crearDialog(ventanaPrincipal);
            
        }
        if(e.getSource() == ventanaPrincipal.panelMostrarGatos.jButtonAtras){
            ventanaPrincipal.mostrarPanel(ventanaPrincipal.panelOpcionesCRUD);
        }
        // ActionListener de PanelConsultarGatos
        if(e.getSource() == ventanaPrincipal.panelConsultarGato.jButtonAtras){
            ventanaPrincipal.mostrarPanel(ventanaPrincipal.panelOpcionesCRUD);
        }
        // Action Listener de PanelModificarGato
        if(e.getSource() == ventanaPrincipal.panelModificarGato.jButtonAtras){
            ventanaPrincipal.mostrarPanel(ventanaPrincipal.panelOpcionesCRUD);
        }
        // Action Listener de PanelEliminarGato
        if(e.getSource() == ventanaPrincipal.panelEliminarGato.jButtonAtras){
            ventanaPrincipal.mostrarPanel(ventanaPrincipal.panelOpcionesCRUD);
        }
    }

    public void verificarBotonesInctivos() {
        if (!ventanaPrincipal.panelPrincipal.jButtonPropiedadesGatos.isEnabled() && !ventanaPrincipal.panelPrincipal.jButtonPropiedadesBD.isEnabled()) {
            ventanaPrincipal.panelPrincipal.jButtonContinuar.setEnabled(true);
        }
    }
    
    public void cargarDatosTablaPanelMostrarGatos(){
        Object[][] datosGatos= controlPrincipal.darListaGatosObject();
        ventanaPrincipal.panelMostrarGatos.modeloTablaGatos.setRowCount(0);
        for(Object[] fila: datosGatos){
            ventanaPrincipal.panelMostrarGatos.modeloTablaGatos.addRow(fila);
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
    
    public Object mostrarJOptionSeleccionarDatoFaltante(String datoFaltante, Object[] opciones){
        return ventanaPrincipal.mostrarJOptionSeleccionarDatoFaltante(datoFaltante, opciones);
    }
    
    public String mostrarJOptionEscribirDatoFaltante(String datoFaltante){
        return ventanaPrincipal.mostrarJOptionEscribirDatoFaltante(datoFaltante);
    }
    
    public File pedirArchivoAleatorio() throws NullPointerException, IOException {
        return ventanaPrincipal.pedirDirectorioArchivoAleatorio();
    }
}
