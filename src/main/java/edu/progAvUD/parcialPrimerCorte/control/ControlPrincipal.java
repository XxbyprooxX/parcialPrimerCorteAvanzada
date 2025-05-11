package edu.progAvUD.parcialPrimerCorte.control;

import edu.progAvUD.parcialPrimerCorte.modelo.ConexionArchivoAleatorio;
import edu.progAvUD.parcialPrimerCorte.modelo.ConexionBD;
import edu.progAvUD.parcialPrimerCorte.modelo.ConexionPropiedades;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * Se encarga de hacer de tunel comunicador, crear y precargar documentos
 *
 * @author Andres Felipe
 */
public class ControlPrincipal {

    private ControlGato controlGato;
    private ControlGrafico controlGrafico;

    /**
     * Contruye el control y crea los otros controles
     */
    public ControlPrincipal() {
        this.controlGato = new ControlGato(this);
        this.controlGrafico = new ControlGrafico(this);
    }

    /**
     * Este metodo se encarga de crear la conexion con las propiedades
     *
     * @return la conexion
     */
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

    /**
     * Este metodo se encarga de cargar las propiedades de la base de datos
     */
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

    /**
     * Carga los datos de los gatos desde las propiedades
     */
    public void cargarDatosGatosPropiedades() {
        ConexionPropiedades conexionPropiedades = crearConexionPropiedades();
        boolean flag = true;
        do {
            try {
                Properties propiedadesGatos = conexionPropiedades.cargarPropiedades();
                int cantidadDeGatosRegistrar = Integer.parseInt(propiedadesGatos.getProperty("cantidadGatosARegistrar"));
                for (int i = 1; i <= cantidadDeGatosRegistrar; i++) {
                    String nombre = propiedadesGatos.getProperty("gato" + i + ".nombre");
                    String peso = propiedadesGatos.getProperty("gato" + i + ".peso");
                    if (!peso.isBlank()) {
                        double peso2 = Double.parseDouble(peso);
                    }
                    String edad = propiedadesGatos.getProperty("gato" + i + ".edad");
                    if (!edad.isBlank()) {
                        int edad2 = Integer.parseInt(edad);
                    }
                    String raza = propiedadesGatos.getProperty("gato" + i + ".raza");
                    String color = propiedadesGatos.getProperty("gato" + i + ".color");
                    String patron = propiedadesGatos.getProperty("gato" + i + ".patron");
                    String colorOjos = propiedadesGatos.getProperty("gato" + i + ".colorOjos");
                    String cola = propiedadesGatos.getProperty("gato" + i + ".cola");
                    controlGato.crearGato(i, nombre, peso, edad, raza, color, patron, colorOjos, cola);
                }
                flag = false;
                controlGrafico.mostrarMensajeExito("Se han creado correctamente los gatos");
            } catch (IOException ex) {
                controlGrafico.mostrarMensajeError("No se pudo cargar el archivo propiedades de los gatos");
                flag = true;
            } catch (NumberFormatException ex) {
                controlGrafico.mostrarMensajeError("El texto no es un valor valido");
                flag = true;
            } catch (Exception ex) {
                controlGrafico.mostrarMensajeError("Algun dato del gato no corresponde");
                flag = true;
            }
        } while (flag);
    }

    /**
     * Crea el archivo aleatorio en una direccion elejida por el usuario
     */
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

    /**
     * Escribe en el archivo la informacion a guardar
     *
     * @param id parametro del gato
     * @param datosGato informacion completa del gato
     * @param archivoAleatorio es la conexion para poder escribir
     */
    public void escrituraArchivoAleatorio(int id, String datosGato, ConexionArchivoAleatorio archivoAleatorio) {
        try {
            archivoAleatorio.escribirArchivoAleatorio(id, datosGato);
        } catch (FileNotFoundException fnfe) {
            controlGrafico.mostrarMensajeError("El archivo no ha sido encontrado");
        } catch (IOException ioe) {
            controlGrafico.mostrarMensajeError("Hay un error al momento de escribir el archivo");
        }
    }

    /**
     * Pide la lista de los gatos para enviarla
     *
     * @return la lista de gatos
     */
    public Object[][] darListaGatosObject() {
        return controlGato.darListaGatosObject();
    }

    /**
     * Ese parametro consula al gato segun su id
     *
     * @param id identificador
     */
    public Object[] pedirConsultaGato(int id) {
        return controlGato.pedirConsultaGato(id);
    }

    /**
     * Ese parametro consula al gato segun un dato especifico
     *
     * @param datoBuscado
     */
    public void pedirConsultaGato(String datoBuscado) {
        controlGato.pedirConsultaGato(datoBuscado);
    }

    /**
     * Permite insertar un nuevo gato a la base de datos
     *
     * @param nombre del gato
     * @param peso del gato
     * @param edad del gato
     * @param raza del gato
     * @param color del gato
     * @param patron del gato
     * @param colorOjos del gato
     * @param cola del gato
     */
    public void crearInsercionGato(String nombre, String peso, String edad, String raza, String color, String patron, String colorOjos, String cola) {
        controlGato.crearInsercionGato(nombre, peso, edad, raza, color, patron, colorOjos, cola);
    }

    /**
     * Permite eliminar a un gato segun la id
     *
     * @param id parametro identificador
     */
    public void eliminarGato(int id) {
        controlGato.eliminarGato(id);
    }

    /**
     * Muestra un mensaje a la persona en caso de error
     *
     * @param mensaje a mostrar
     */
    public void mostrarMensajeError(String mensaje) {
        controlGrafico.mostrarMensajeError(mensaje);
    }

    /**
     * Muestra un mensaje a la persona en caso de exito
     *
     * @param mensaje a mostrar
     */
    public void mostrarMensajeExito(String mensaje) {
        controlGrafico.mostrarMensajeExito(mensaje);
    }

    /**
     * Este metodo se encarga de crear el archivo en la direccion indicada por
     * la persona
     *
     * @return el archivo pedido al usuario
     * @throws NullPointerException devuelve la excepcion
     * @throws IOException devuelve la excepcion
     */
    public File crearArchivoSerializado() throws NullPointerException, IOException {
        return controlGrafico.pedirArchivoAleatorio();
    }

    /**
     * Manda a mostrar las opciones a elegir por el usuario
     *
     * @param datoFaltante es el dato vacio
     * @param opciones son las posibles elecciones de la persona
     * @return el valor seleccionado
     */
    public Object mostrarJOptionSeleccionarDatoFaltante(String datoFaltante, Object[] opciones) {
        return controlGrafico.mostrarJOptionSeleccionarDatoFaltante(datoFaltante, opciones);
    }

    /**
     * Manda a mostrar las opciones a elegir por el usuario
     *
     * @param datoFaltante es el dato esta en blanco
     * @return el valor seleccionado
     */
    public String mostrarJOptionEscribirDatoFaltante(String datoFaltante) {
        return controlGrafico.mostrarJOptionEscribirDatoFaltante(datoFaltante);
    }

    public String identificarRazaSegunEMS(String[] divisionRaza) {
        return controlGato.identificarRazaSegunEMS(divisionRaza);
    }

    public String identificarColorCuerpoSegunEMS(String[] divisionColor) {
        return controlGato.identificarColorCuerpoSegunEMS(divisionColor);
    }

    public String identificarColaSegunEMS(String[] divisionCola) {
        return controlGato.identificarColaSegunEMS(divisionCola);
    }

    public String identificarPatronSegunEMS(String[] divisionPatron) {
        return controlGato.identificarPatronSegunEMS(divisionPatron);
    }

    public String identificarColorOjosSegunEMS(String[] divisionColorOjos) {
        return controlGato.identificarColorOjosSegunEMS(divisionColorOjos);
    }

}
