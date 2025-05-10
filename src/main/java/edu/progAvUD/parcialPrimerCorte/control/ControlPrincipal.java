package edu.progAvUD.parcialPrimerCorte.control;

import edu.progAvUD.parcialPrimerCorte.modelo.ConexionArchivoAleatorio;
import edu.progAvUD.parcialPrimerCorte.modelo.ConexionBD;
import edu.progAvUD.parcialPrimerCorte.modelo.ConexionPropiedades;
import java.io.File;
import java.io.FileNotFoundException;
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

    public void cargarDatosBD() {
        ConexionPropiedades conexionPropiedades = crearConexionPropiedades();
        try {
            Properties propiedadesBD = conexionPropiedades.cargarPropiedades();
            String URLBD = propiedadesBD.getProperty("URLBD");
            String usuario = propiedadesBD.getProperty("usuario");
            String contrasena = propiedadesBD.getProperty("contrasena");
            ConexionBD.setURLBD(URLBD);
            ConexionBD.setUsuario(usuario);
            ConexionBD.setContrasena(contrasena);

        } catch (IOException ex) {
            controlGrafico.mostrarMensajeError("No se pudo cargar el archivo propiedades de la Base de Datos");
        }
    }

    public void cargarDatosGatosPropiedades() {
        ConexionPropiedades conexionPropiedades = crearConexionPropiedades();
        try {
            Properties propiedadesGatos = conexionPropiedades.cargarPropiedades();
            int cantidadDeGatosRegistrar = Integer.parseInt(propiedadesGatos.getProperty("cantidadGatosARegistrar"));
            for (int i = 1; i <= cantidadDeGatosRegistrar; i++) {
                String nombre = propiedadesGatos.getProperty("gato" + i + ".nombre");
                String peso = propiedadesGatos.getProperty("gato" + i + ".peso");
                double peso2 = Double.parseDouble(peso);
                String edad = propiedadesGatos.getProperty("gato" + i + ".edad");
                int edad2 = Integer.parseInt(edad);
                String raza = propiedadesGatos.getProperty("gato" + i + ".raza");
                String color = propiedadesGatos.getProperty("gato" + i + ".color");
                String patron = propiedadesGatos.getProperty("gato" + i + ".patron");
                String colorOjos = propiedadesGatos.getProperty("gato" + i + ".colorOjos");
                String cola = propiedadesGatos.getProperty("gato" + i + ".cola");
                controlGato.crearGato(i, nombre, peso, edad, raza, color, patron, colorOjos, cola);
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

    public void crearArchivoAleatorio() {
        try {
            File carpetaSeleccionada = controlGrafico.pedirArchivoAleatorio();
            if (carpetaSeleccionada == null || !carpetaSeleccionada.isDirectory()) {
                controlGrafico.mostrarMensajeError("Debe seleccionar una carpeta válida.");
                return;
            }
            File archivo = new File(carpetaSeleccionada, "ArchivoAleatorio.dat");
            if (!archivo.exists()) {
                boolean creado = archivo.createNewFile();
                if (!creado) {
                    controlGrafico.mostrarMensajeError("No se pudo crear el archivo.");
                    return;
                }
            }
            ConexionArchivoAleatorio archivoAleatorio = new ConexionArchivoAleatorio(archivo);
            escrituraArchivoAleatorio(2, "", archivoAleatorio);
        } catch (IOException ioe) {
            controlGrafico.mostrarMensajeError("Error al crear o abrir el archivo: " + ioe.getMessage());
        }
    }

    public void escrituraArchivoAleatorio(int id, String datosGato, ConexionArchivoAleatorio archivoAleatorio) {
        try {
            archivoAleatorio.escribirArchivoAleatorio(id, datosGato);
        } catch (FileNotFoundException fnfe) {
            controlGrafico.mostrarMensajeError("El archivo no ha sido encontrado");
        } catch (IOException ioe) {
            controlGrafico.mostrarMensajeError("Hay un error al momento de escribir el archivo");
        }
    }
    

    public void mostrarMensajeError(String mensaje) {
        controlGrafico.mostrarMensajeError(mensaje);
    }

    public void mostrarMensajeExito(String mensaje) {
        controlGrafico.mostrarMensajeExito(mensaje);
    }

    

    public Object mostrarJOptionSeleccionarDatoFaltante(String datoFaltante, Object[] opciones) {
        return controlGrafico.mostrarJOptionSeleccionarDatoFaltante(datoFaltante, opciones);
    }
    
    public String mostrarJOptionEscribirDatoFaltante(String datoFaltante){
        return controlGrafico.mostrarJOptionEscribirDatoFaltante(datoFaltante);
    }
    
    public File crearArchivoSerializado(){
        return null;
    }
}