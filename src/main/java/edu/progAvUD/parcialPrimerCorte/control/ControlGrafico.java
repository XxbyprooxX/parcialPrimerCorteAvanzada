package edu.progAvUD.parcialPrimerCorte.control;

import edu.progAvUD.parcialPrimerCorte.vista.VentanaPrincipal;
import java.io.File;

/**
 *
 * @author Andres Felipe
 */
public class ControlGrafico {
    
    private ControlPrincipal controlPrincipal;
    private VentanaPrincipal ventanaPrincipal;

    public ControlGrafico(ControlPrincipal controlPrincipal) {
        this.controlPrincipal = controlPrincipal;
        this.ventanaPrincipal = new VentanaPrincipal(this);
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
}
