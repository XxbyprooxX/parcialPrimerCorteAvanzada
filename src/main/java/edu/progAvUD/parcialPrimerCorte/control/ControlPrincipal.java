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
                    String cantidadBlanco = propiedadesGatos.getProperty("gato" + i + ".cantidadBlanco");
                    String patron = propiedadesGatos.getProperty("gato" + i + ".patron");
                    String puntosColor = propiedadesGatos.getProperty("gato" + i + ".puntosColor");
                    String colorOjos = propiedadesGatos.getProperty("gato" + i + ".colorOjos");
                    String cola = propiedadesGatos.getProperty("gato" + i + ".cola");
                    controlGato.crearGato(i, nombre, peso, edad, raza, color, cantidadBlanco, patron, puntosColor, cola, colorOjos);
                }
                flag = false;
                controlGrafico.mostrarMensajeExito("Se han creado correctamente los gatos");
            } catch (IOException ex) {
                controlGrafico.mostrarMensajeError("No se pudo cargar el archivo propiedades de los gatos");
                System.exit(0);
            } catch (NumberFormatException ex) {
                controlGrafico.mostrarMensajeError("El texto no es un valor valido");
                System.exit(0);
            } catch (Exception ex) {
                controlGrafico.mostrarMensajeError("Algun dato del gato no corresponde");
                ex.printStackTrace();
                System.exit(0);
            }
        } while (flag);
    }

    /**
     * Crea el archivo aleatorio en una direccion elejida por el usuario
     */
    public void crearArchivoAleatorio() {
        boolean archivoCreado = false;
        do {
            String nombreBase = pedirNombreArchivo();
            if (nombreBase == null || nombreBase.trim().isEmpty()) {
                controlGrafico.mostrarMensajeError("Debe ingresar un nombre de archivo válido.");
                continue;
            }
            String nombreArchivo = nombreBase.trim() + ".dat";
            try {
                controlGrafico.mostrarMensajeExito("Seleccione el lugar donde desea crear el archivo");
                File carpetaSeleccionada = controlGrafico.pedirArchivoAleatorio();

                if (carpetaSeleccionada == null || !carpetaSeleccionada.isDirectory()) {
                    controlGrafico.mostrarMensajeError("Debe seleccionar una carpeta válida.");
                    continue;
                }
                File archivo = new File(carpetaSeleccionada, nombreArchivo);
                if (!archivo.exists()) {
                    boolean creado = archivo.createNewFile();
                    if (!creado) {
                        controlGrafico.mostrarMensajeError("No se pudo crear el archivo. Intente de nuevo.");
                        continue;
                    }
                }
                archivoCreado = true;
                ConexionArchivoAleatorio archivoAleatorio = new ConexionArchivoAleatorio(archivo);
                pedirBaseDatosYEscribirAleatorio(archivoAleatorio);
                controlGrafico.mostrarMensajeExito("Archivo creado y datos escritos con éxito en:\n" + archivo.getAbsolutePath());
            } catch (IOException ioe) {
                controlGrafico.mostrarMensajeError("Error al crear o abrir el archivo: " + ioe.getMessage());
            }
        } while (!archivoCreado);
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

    public void pedirBaseDatosYEscribirAleatorio(ConexionArchivoAleatorio archivoAleatorio) {
        Object[][] gatoInfo = darListaGatosObjectArchivoAleatorio();
        for (int i = 0; i < gatoInfo.length; i++) {
            int id = (Integer) gatoInfo[i][0];
            String nombre = (String) gatoInfo[i][1];
            String codigoEMS = (String) gatoInfo[i][2];
            String datosGato = id + "," + nombre + "," + codigoEMS;
            escrituraArchivoAleatorio(id, datosGato, archivoAleatorio);
        }
        System.exit(0);
    }

    /**
     * Pide la lista de los gatos para enviarla
     *
     * @return la lista de gatos
     */
    public Object[][] darListaGatosObject() {
        return controlGato.darListaGatosObject();
    }

    public Object[][] darListaGatosObjectArchivoAleatorio() {
        return controlGato.darListaGatosObjectArchivoAleatorio();
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
    public Object[][] pedirConsultaGatos(String factorBusqueda, String datoBuscado) {
        return controlGato.pedirConsultaGatos(factorBusqueda, datoBuscado);
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
    public void crearInsercionGato(String nombre, String peso, String edad, String raza, String color, String cantidadBlanco, String patron, String puntosColor, String cola, String colorOjos) {
        controlGato.crearInsercionGato(nombre, peso, edad, raza, color, cantidadBlanco, patron, puntosColor, cola, colorOjos);
    }

    /**
     * Permite eliminar a un gato segun la id
     *
     * @param id parametro identificador
     */
    public void eliminarGato(int id) {
        controlGato.eliminarGato(id);
    }

    public void modificarGato(int id, String factorACambiar, String valorModificado) {
        controlGato.modificarGato(id, factorACambiar, valorModificado);
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
    
    public String identificarCantidadBlancosSegunEMS(String[] divisionCantidadBlancos){
        return controlGato.identificarCantidadBlancoSegunEMS(divisionCantidadBlancos);
    }
    
    public String identificarPuntosColorSegunEMS(String[] divisionPuntosColor){
        return controlGato.identificarPuntosColorSegunEMS(divisionPuntosColor);
    }

    public void crearSerializacion() {
        controlGato.crearSerializacion();
    }

    public String pedirNombreArchivo() {
        controlGrafico.mostrarMensajeExito("Porfavor escriba como desea guardar el archivo");
        return controlGrafico.pedirNombreArchivo();
    }
}
