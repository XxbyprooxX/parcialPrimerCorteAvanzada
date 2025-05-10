package edu.progAvUD.parcialPrimerCorte.control;

import edu.progAvUD.parcialPrimerCorte.modelo.ConexionBD;
import edu.progAvUD.parcialPrimerCorte.modelo.ConexionPropiedades;
import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author Andres Felipe
 */
public class ControlPrincipal {

    private ControlGato controlGato;
    private ControlGrafico controlGrafico;

    public ControlPrincipal() {
        this.controlGato = new ControlGato(this);
        this.controlGrafico = new ControlGrafico(this);
    }

    public ConexionPropiedades crearConexionPropiedades() {
        ConexionPropiedades conexionPropiedades = null;
        boolean flag = true;
        do {
            try {
                conexionPropiedades = new ConexionPropiedades(controlGrafico.pedirArchivoPropiedades());
                if (conexionPropiedades != null) {
                    flag = false;
                }
            } catch (Exception ex) {
                controlGrafico.mostrarMensajeError("No se pudo crear la conexion correctamente");
            }
        } while (flag);
        
        return conexionPropiedades;
    }

    public void cargarDatosBD(){
        ConexionPropiedades conexionPropiedades = crearConexionPropiedades();
        try{
            Properties propiedadesBD = conexionPropiedades.cargarPropiedades();
            String URLBD = propiedadesBD.getProperty("URLBD");
            String usuario = propiedadesBD.getProperty("usuario");
            String contrasena = propiedadesBD.getProperty("contrasena");
            ConexionBD.setURLBD(URLBD);
            ConexionBD.setUsuario(usuario);
            ConexionBD.setContrasena(contrasena);
            
        }catch (IOException ex) {
            controlGrafico.mostrarMensajeError("No se pudo cargar el archivo propiedades de la Base de Datos");
        }
    }
    
    public void cargarDatosGatosPropiedades() {
        ConexionPropiedades conexionPropiedades = crearConexionPropiedades();
        try {
            Properties propiedadesGatos = conexionPropiedades.cargarPropiedades();
            int cantidadDeGatosRegistrar = Integer.parseInt(propiedadesGatos.getProperty("numeroRegistrosGatos"));
            for (int i=1; i <= cantidadDeGatosRegistrar; i++){
                int id = Integer.parseInt(propiedadesGatos.getProperty("idGato"));
                String nombre = propiedadesGatos.getProperty("nombre");
                String peso = propiedadesGatos.getProperty("peso");
                double peso2 = Double.parseDouble(peso);
                String edad = propiedadesGatos.getProperty("edad");
                int edad2 = Integer.parseInt(edad);
                String colorCuerpo = propiedadesGatos.getProperty("colorCuerpo");
                String patron = propiedadesGatos.getProperty("patron");
                String colorOjos = propiedadesGatos.getProperty("colorOjos");
                String cola = propiedadesGatos.getProperty("cola");
                String codigoEMS = propiedadesGatos.getProperty("codigoEMS");
                controlGato.crearGato(id, nombre, peso, edad, codigoEMS);
            }
            controlGrafico.mostrarMensajeExito("Se han creado correctamente los gatos");
        } catch (IOException ex) {
            controlGrafico.mostrarMensajeError("No se pudo cargar el archivo propiedades de los gatos");
        } catch (NumberFormatException ex) {
            controlGrafico.mostrarMensajeError("El texto no es un valor valido");
        } catch (Exception ex) {
            controlGrafico.mostrarMensajeError("Algun dato del gato no corresponde");
        }
    }

}
