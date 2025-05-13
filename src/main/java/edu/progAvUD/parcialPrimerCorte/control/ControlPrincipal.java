package edu.progAvUD.parcialPrimerCorte.control;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import edu.progAvUD.parcialPrimerCorte.modelo.ConexionArchivoAleatorio;
import edu.progAvUD.parcialPrimerCorte.modelo.ConexionBD;
import edu.progAvUD.parcialPrimerCorte.modelo.ConexionPropiedades;

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
                mostrarMensajeError("Se ha cerrado el programa sin crear el archivo aleatorio");
                System.exit(0);
            }
            if (nombreBase.trim().isEmpty()) {
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

    /**
     * Recorre la lista completa de gatos y escribe cada registro en un archivo
     * aleatorio. Después muestra un mensaje de confirmación y termina la
     * aplicación.
     *
     * @param archivoAleatorio instancia de ConexionArchivoAleatorio para
     * escribir en el archivo.
     */
    public void pedirBaseDatosYEscribirAleatorio(ConexionArchivoAleatorio archivoAleatorio) {
        Object[][] gatoInfo = darListaGatosObjectArchivoAleatorio();
        for (int i = 0; i < gatoInfo.length; i++) {
            int id = (Integer) gatoInfo[i][0];
            String nombre = (String) gatoInfo[i][1];
            String codigoEMS = (String) gatoInfo[i][2];
            String datosGato = id + "," + nombre + "," + codigoEMS;
            escrituraArchivoAleatorio(id, datosGato, archivoAleatorio);
        }
        // Aunque se crea correctamente el archivo, se usa mostrarMensajeError para indicar finalización
        mostrarMensajeError("Se ha creado el archivo aleatorio");
        System.exit(0);
    }

    /**
     * Obtiene la lista de gatos formateada para interfaz de tabla.
     *
     * @return matriz Object[][] con datos básicos de cada gato (ID, Nombre,
     * Código EMS).
     */
    public Object[][] darListaGatosObject() {
        return controlGato.darListaGatosObject();
    }

    /**
     * Obtiene la lista de gatos con detalles extendidos para archivo aleatorio.
     *
     * @return matriz Object[][] con datos extendidos de cada gato (ID, Nombre,
     * Peso, Edad, Raza, EMS).
     */
    public Object[][] darListaGatosObjectArchivoAleatorio() {
        return controlGato.darListaGatosObjectArchivoAleatorio();
    }

    /**
     * Delegación para consultar un gato por su ID.
     *
     * @param id identificador único del gato.
     * @return arreglo Object[] con los datos del gato, o null si no existe.
     */
    public Object[] pedirConsultaGato(int id) {
        return controlGato.pedirConsultaGato(id);
    }

    /**
     * Delegación para buscar gatos según un criterio específico.
     *
     * @param factorBusqueda nombre del campo para filtrar (e.g., "nombre").
     * @param datoBuscado valor a filtrar.
     * @return matriz Object[][] con los gatos que cumplen el criterio.
     */
    public Object[][] pedirConsultaGatos(String factorBusqueda, String datoBuscado) {
        return controlGato.pedirConsultaGatos(factorBusqueda, datoBuscado);
    }

    /**
     * Inserta un nuevo gato en la base de datos usando el controlador de gatos.
     *
     * @param nombre nombre del gato.
     * @param peso peso del gato.
     * @param edad edad del gato.
     * @param raza raza del gato.
     * @param color color del cuerpo.
     * @param cantidadBlanco proporción de blanco.
     * @param patron patrón del pelaje.
     * @param puntosColor puntos de color.
     * @param cola tipo de cola.
     * @param colorOjos color de ojos.
     */
    public void crearInsercionGato(String nombre, String peso, String edad, String raza, String color,
            String cantidadBlanco, String patron, String puntosColor,
            String cola, String colorOjos) {
        controlGato.crearInsercionGato(nombre, peso, edad, raza, color, cantidadBlanco, patron, puntosColor, cola, colorOjos);
    }

    /**
     * Elimina un gato de la base de datos delegando al controlador de gatos.
     *
     * @param id identificador único del gato a eliminar.
     */
    public void eliminarGato(int id) {
        controlGato.eliminarGato(id);
    }

    /**
     * Modifica un campo específico de un gato existente.
     *
     * @param id identificador del gato a modificar.
     * @param factorACambiar nombre del atributo a actualizar.
     * @param valorModificado nuevo valor que se asignará.
     */
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

    /**
     * Identifica la raza del gato según el código EMS proporcionado.
     *
     * @param divisionRaza Arreglo de cadenas que representa partes del código
     * EMS relacionadas con la raza.
     * @return Una cadena que representa la raza identificada del gato.
     */
    public String identificarRazaSegunEMS(String[] divisionRaza) {
        return controlGato.identificarRazaSegunEMS(divisionRaza);
    }

    /**
     * Identifica el color del cuerpo del gato según el código EMS
     * proporcionado.
     *
     * @param divisionColor Arreglo de cadenas que representa partes del código
     * EMS relacionadas con el color del cuerpo.
     * @return Una cadena que representa el color del cuerpo del gato.
     */
    public String identificarColorCuerpoSegunEMS(String[] divisionColor) {
        return controlGato.identificarColorCuerpoSegunEMS(divisionColor);
    }

    /**
     * Identifica el tipo de cola del gato según el código EMS proporcionado.
     *
     * @param divisionCola Arreglo de cadenas que representa partes del código
     * EMS relacionadas con la cola.
     * @return Una cadena que representa el tipo de cola del gato.
     */
    public String identificarColaSegunEMS(String[] divisionCola) {
        return controlGato.identificarColaSegunEMS(divisionCola);
    }

    /**
     * Identifica el patrón del pelaje del gato según el código EMS
     * proporcionado.
     *
     * @param divisionPatron Arreglo de cadenas que representa partes del código
     * EMS relacionadas con el patrón.
     * @return Una cadena que representa el patrón del pelaje del gato.
     */
    public String identificarPatronSegunEMS(String[] divisionPatron) {
        return controlGato.identificarPatronSegunEMS(divisionPatron);
    }

    /**
     * Identifica el color de los ojos del gato según el código EMS
     * proporcionado.
     *
     * @param divisionColorOjos Arreglo de cadenas que representa partes del
     * código EMS relacionadas con el color de los ojos.
     * @return Una cadena que representa el color de los ojos del gato.
     */
    public String identificarColorOjosSegunEMS(String[] divisionColorOjos) {
        return controlGato.identificarColorOjosSegunEMS(divisionColorOjos);
    }

    /**
     * Identifica la cantidad de manchas blancas del gato según el código EMS
     * proporcionado.
     *
     * @param divisionCantidadBlancos Arreglo de cadenas que representa partes
     * del código EMS relacionadas con las manchas blancas.
     * @return Una cadena que representa la cantidad de manchas blancas del
     * gato.
     */
    public String identificarCantidadBlancosSegunEMS(String[] divisionCantidadBlancos) {
        return controlGato.identificarCantidadBlancoSegunEMS(divisionCantidadBlancos);
    }

    /**
     * Identifica los puntos de color en el cuerpo del gato según el código EMS
     * proporcionado.
     *
     * @param divisionPuntosColor Arreglo de cadenas que representa partes del
     * código EMS relacionadas con los puntos de color.
     * @return Una cadena que representa los puntos de color del gato.
     */
    public String identificarPuntosColorSegunEMS(String[] divisionPuntosColor) {
        return controlGato.identificarPuntosColorSegunEMS(divisionPuntosColor);
    }

    /**
     * Inicia el proceso de serialización de los datos del gato, guardando su
     * información en un archivo.
     */
    public void crearSerializacion() {
        controlGato.crearSerializacion();
    }

    /**
     * Solicita al usuario el nombre con el que desea guardar el archivo de
     * datos serializados.
     *
     * @return El nombre del archivo ingresado por el usuario.
     */
    public String pedirNombreArchivo() {
        controlGrafico.mostrarMensajeExito("Porfavor escriba como desea guardar el archivo");
        return controlGrafico.pedirNombreArchivo();
    }
}