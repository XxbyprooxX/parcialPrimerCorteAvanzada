package edu.progAvUD.parcialPrimerCorte.control;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import edu.progAvUD.parcialPrimerCorte.modelo.GatoDAO;
import edu.progAvUD.parcialPrimerCorte.modelo.GatoVO;
import edu.progAvUD.parcialPrimerCorte.modelo.Serializacion;

/**
 * Este conctrol se se encarga de manejar el gato y su de hablar con la conexion
 * a la base de datos para manejar la informacion de cada cosa
 *
 * @author Andres Felipe
 */
public class ControlGato {

    private ControlPrincipal controlPrincipal;
    private GatoDAO gatoDao;

    /**
     * Este metodo es el constructor del control y de la conexion
     *
     * @param controlPrincipal parametro para la comunicaciones entre los
     * controles
     */
    public ControlGato(ControlPrincipal controlPrincipal) {
        this.controlPrincipal = controlPrincipal;
        this.gatoDao = new GatoDAO();
    }

    /**
     * Este metodo se encarga de crear el gato
     *
     * @param id parametro unico del gato
     * @param nombre del gato
     * @param peso del gato
     * @param edad del gato
     * @param raza del gato
     * @param color del gato
     * @param patron del gato
     * @param colorOjos del gato
     * @param cola del gato
     */
    public void crearGato(int id, String nombre, String peso, String edad, String raza, String color, String patron, String colorOjos, String cola) {
        Object[] opcionesRaza = {
            "ABY-Abyssinian",
            "AMB-American Burmese",
            "ACL-American Curl Longhair",
            "ACS-American Curl Shorthair",
            "ASH-American Shorthair",
            "AWH-American Wirehair",
            "ANA-Anatoli",
            "APL-Aphrodite’s Giant Longhair",
            "APS-Aphrodite’s Giant Shorthair",
            "ARM-Arabian Mau",
            "ASI-Asian",
            "AUM-Australian Mist",
            "BAL-Balinese",
            "BEN-Bengal",
            "BOM-Bombay",
            "BRA-Brazilian Shorthair",
            "BLH-British Longhair",
            "BRI-British Shorthair",
            "BUR-Burmese",
            "BML-Burmilla Longhair",
            "BMS-Burmilla Shorthair",
            "CAM-Cashmere",
            "KKH-Celtic Shorthair",
            "CEY-Ceylon",
            "CHA-Chartreux",
            "CHS-Chausie",
            "CRX-Cornish Rex",
            "CYM-Cymric",
            "DLH-Deutsch-Langhaar",
            "DRX-Devon Rex",
            "DSX-Don Sphynx",
            "MAU-Egyptian Mau",
            "EXO-Exotic Shorthair",
            "GRX-German Rex",
            "HAV-Havana",
            "SFL-Highland Fold",
            "PER-Himalayan / Colourpoint",
            "HHP-Household Pet",
            "JBL-Japanese Bobtail Longhair",
            "JBS-Japanese Bobtail Shorthair",
            "KAN-Kanaani",
            "KAL-Karelian Bobtail Longhair",
            "KAS-Karelian Bobtail Shorthair",
            "KAM-Khao Manee",
            "KOR-Korat",
            "KBL-Kurilian Bobtail Langhaar",
            "KBS-Kurilian Bobtail Shorthair",
            "LPL-LaPerm Longhair",
            "LPS-LaPerm Shorthair",
            "LYS-Lykoi",
            "MCO-Maine Coon",
            "MAN-Manx",
            "MBT-Mekong Bobtail",
            "MIL-Minuet Longhair",
            "MIS-Minuet Shorthair",
            "MNL-Munchkin Longhair",
            "MNS-Munchkin Shorthair",
            "NEB-Nebelung",
            "NFO-Norwegian Forest",
            "OCI-Ocicat",
            "OSL-Oriental Semilonghair",
            "OSH-Oriental Shorthair",
            "TLH-Original Longhair",
            "PER-Persian",
            "PBD-Peterbald",
            "RGM-Ragamuffin",
            "RAG-Ragdoll",
            "RUS-Russian Blue",
            "SBI-Sacred Birman",
            "SFS-Scottish Fold",
            "SRL-Selkirk Rex Longhair",
            "SRS-Selkirk Rex Shorthair",
            "SIA-Siamese",
            "SIB-Siberian cat / Neva Masquerade",
            "SIN-Singapura",
            "SNO-Snowshoe",
            "SOM-Somali",
            "SPH-Sphynx",
            "THA-Thai",
            "TIF-Tiffanie",
            "TON-Tonkinese",
            "TOB-Toy Bob",
            "TUA-Turkish Angora",
            "TUV-Turkish Van",
            "URL-Ural Rex Longhair",
            "URS-Ural Rex Shorthair",
            "YOR-York"};
        Object[] opcionesColor = {
            "n-black",
            "f-black tortie",
            "a-blue",
            "g-blue tortie",
            "b-chocolate",
            "h-chocolate tortie",
            "c-lilac",
            "o-cinnamon",
            "q-cinnamon tortie",
            "d-red",
            "e-cream",
            "p-fawn",
            "r-fawn tortie",
            "j-lilac tortie",
            "w-white",
            "n-seal",
            "x-unrecognized"};
        Object[] opcionesPatron = {
            "11-shaded",
            "12-shell",
            "21-tabby",
            "21-lynx",
            "22-classic",
            "23-mackerel",
            "24-spotted",
            "25-ticked",
            "26-grizzled ticked"
        };
        Object[] opcionesColorOjos = {
            "61-blue",
            "62-orange",
            "63-odd",
            "64-green",
            "65-golden BUR",
            "66-aquamarine TON",
            "67-dark blue SIA"
        };
        Object[] opcionesCola = {
            "51-rumpy",
            "52-rumpy riser",
            "53-stumpy",
            "54-longie"
        };

        if (nombre.isBlank()) {
            nombre = obtenerDatoFaltante("nombre del gato " + id, "nombre");
        }
        if (peso.isBlank()) {
            peso = obtenerDatoFaltante("peso del gato " + id, "peso");
        }
        if (edad.isBlank()) {
            edad = obtenerDatoFaltante("edad del gato " + id, "edad");
        }
        if (raza.isBlank()) {
            raza = seleccionarOpcionFaltante("raza del gato " + id, opcionesRaza);
        }
        if (color.isBlank()) {
            color = seleccionarOpcionFaltante("color del gato " + id, opcionesColor);
        }
        if (patron.isBlank()) {
            patron = seleccionarOpcionFaltante("patrón del gato " + id, opcionesPatron);
        }
        if (colorOjos.isBlank()) {
            colorOjos = seleccionarOpcionFaltante("color de ojos del gato " + id, opcionesColorOjos);
        }
        if (cola.isBlank()) {
            cola = seleccionarOpcionFaltante("cola del gato " + id, opcionesCola);
        }

        String[] divisionRaza = raza.split("-");
        divisionRaza = identificarRazaSegunEMS(divisionRaza).split("-");
        String[] divisionColor = color.split("-");
        divisionColor = identificarColorCuerpoSegunEMS(divisionColor).split("-");
        String[] divisionPatron = patron.split("-");
        divisionPatron = identificarPatronSegunEMS(divisionPatron).split("-");
        String[] divisionColorOjos = colorOjos.split("-");
        divisionColorOjos = identificarColorOjosSegunEMS(divisionColorOjos).split("-");
        String[] divisionCola = cola.split("-");
        divisionCola = identificarColaSegunEMS(divisionCola).split("-");

        String codigoEMS = divisionRaza[0] + "/" + divisionColor[0] + "/" + divisionPatron[0] + "/" + divisionColorOjos[0] + "/" + divisionCola[0];
        GatoVO gato = new GatoVO(nombre, peso, edad, codigoEMS, raza, color, patron, colorOjos, cola);

        if (consultarCantidadGatos() == 0) {
            insertarGato(gato);
        } else {
            if (verificarGatoRepetido(gato)) {
                insertarGato(gato);
            } else {
                controlPrincipal.mostrarMensajeError("No se ha creado el gato" + id + " de propiedades porque ya se encuentra en la Base de Datos");
            }
        }

    }

    /**
     * Se encarga de verificar que en la base de datos no esten repetidos los
     * mismos gatos
     *
     * @param gato le llega el gato para comprobar si esta o no repetido
     * @return un true o false para saber si esta o no repetido
     */
    public boolean verificarGatoRepetido(GatoVO gato) {
        ArrayList<GatoVO> gatos = darListaGatos();
        for (GatoVO gatoValidar : gatos) {
            String nombre1 = gato.getNombre() != null ? gato.getNombre().trim().toLowerCase() : "";
            String nombre2 = gatoValidar.getNombre() != null ? gatoValidar.getNombre().trim().toLowerCase() : "";
            String codigoEMS1 = gato.getCodigoEMS() != null ? gato.getCodigoEMS().trim().toLowerCase() : "";
            String codigoEMS2 = gatoValidar.getCodigoEMS() != null ? gatoValidar.getCodigoEMS().trim().toLowerCase() : "";
            double peso1 = 0;
            double peso2 = 0;
            int edad1 = 0;
            int edad2 = 0;
            try {
                peso1 = Double.parseDouble(gato.getPeso().trim());
            } catch (Exception e) {
                peso1 = 0;
            }
            try {
                peso2 = Double.parseDouble(gatoValidar.getPeso().trim());
            } catch (Exception e) {
                peso2 = 0;
            }
            try {
                edad1 = Integer.parseInt(gato.getEdad().trim());
            } catch (Exception e) {
                edad1 = 0;
            }
            try {
                edad2 = Integer.parseInt(gatoValidar.getEdad().trim());
            } catch (Exception e) {
                edad2 = 0;
            }

            if (nombre1.equals(nombre2)
                    && peso1 == peso2
                    && edad1 == edad2
                    && codigoEMS1.equals(codigoEMS2)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Se encarga de consultar la cantidad de filas o gatos que hay en la base
     * de datos
     *
     * @return el valor total de gatos o -1 en caso de que no pueda conectarse o
     * sea 0
     */
    public int consultarCantidadGatos() {
        try {
            return gatoDao.consultarCantidadGatos();
        } catch (SQLException ex) {
            controlPrincipal.mostrarMensajeError("SQLException ConsultarCantidadGatos");
            ex.printStackTrace();
        }
        return -1;
    }

    /**
     * Pide la lista completa de los gatos
     *
     * @return la lista con los gatos que estan en la dataBase
     */
    public ArrayList<GatoVO> darListaGatos() {
        try {
            return gatoDao.darListaGatos();
        } catch (SQLException ex) {
            controlPrincipal.mostrarMensajeError("SQLException darListaGatos");
            ex.printStackTrace();
        }
        return null;
    }

    /**
     * Vuelve los gatos de la base de datos a un String para mostrar en una
     * tabla
     *
     * @return devuelte la tabla en strings
     */
    public Object[][] darListaGatosObject() {
        ArrayList<GatoVO> gatos = darListaGatos();
        Object[][] arrGatos = new Object[gatos.size()][3];
        for (int i = 0; i < gatos.size(); i++) {
            GatoVO g = gatos.get(i);
            arrGatos[i][0] = g.getId();
            arrGatos[i][1] = g.getNombre();
            arrGatos[i][2] = g.getCodigoEMS();
        }
        return arrGatos;
    }

    /**
     * Consulta un gato por la id
     *
     * @param id es el parametro unico identificador
     */
    public Object[] pedirConsultaGato(int id) {
        GatoVO gato = new GatoVO();
        Object[] datosGato = new Object[6];
        try {
            GatoVO gatoCompleto = gatoDao.consultarGato(id, gato);
            datosGato[0]=gatoCompleto.getId();
            datosGato[1]=gatoCompleto.getNombre();
            datosGato[2]=gatoCompleto.getPeso();
            datosGato[3]=gatoCompleto.getEdad();
            datosGato[4]=gatoCompleto.getNombreRaza();
            datosGato[5]=gatoCompleto.getCodigoEMS();
            return datosGato;
        } catch (SQLException ex) {
            controlPrincipal.mostrarMensajeError("SQLException pedirConsultaGato");
            ex.printStackTrace();
        }
        return null;
    }

    /**
     * Consulta el gato segun un dato referente
     *
     * @param datoBuscado es el dato identificador
     */
    public void pedirConsultaGato(String datoBuscado) {
        GatoVO gato = new GatoVO();
        try {
            gatoDao.consultarGato(datoBuscado, gato);
        } catch (SQLException ex) {
            controlPrincipal.mostrarMensajeError("SQLException pedirConsultaGato");
            ex.printStackTrace();
        }
    }

    /**
     * Este metodo se encarga de insertar un gato a la tabla
     *
     * @param gato
     */
    public void insertarGato(GatoVO gato) {
        try {
            gatoDao.insertarGato(gato);
        } catch (SQLException ex) {
            controlPrincipal.mostrarMensajeError("SQLException insertarGato");
            ex.printStackTrace();
        }
    }

    /**
     * Se encarga de comunicar la creacion del gato con la insercion de este a
     * la base de datos
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
        crearGato(0, nombre, peso, edad, raza, color, patron, colorOjos, cola);
        controlPrincipal.mostrarMensajeExito("Se ha insertado correctamente el usuario");
    }

    /**
     * Se encarga de eliminar al gato de la base de datos
     *
     * @param id parametro unico identificador
     */
    public void eliminarGato(int id) {
        try {
            gatoDao.eliminarGato(id);
        } catch (SQLException ex) {
            controlPrincipal.mostrarMensajeError("SQLException eliminarGato");
            ex.printStackTrace();
        }
    }

    /**
     * Este metodo comprueba si el dato si es un double o un int
     *
     * @param mensaje para pedir el dato faltante
     * @param tipo es para saber que parametro se va a parsear
     * @return el valor
     */
    private String obtenerDatoFaltante(String mensaje, String tipo) {
        String dato = controlPrincipal.mostrarJOptionEscribirDatoFaltante(mensaje);
        if (tipo.equals("peso") || tipo.equals("edad")) {
            try {
                if (tipo.equals("peso")) {
                    Double.parseDouble(dato);
                } else {
                    Integer.parseInt(dato);
                }
            } catch (NumberFormatException e) {
                controlPrincipal.mostrarMensajeError("Se ha escrito algo incorrecto en el " + tipo);
                return obtenerDatoFaltante(mensaje, tipo);
            }
        }
        return dato;
    }

    /**
     * Este metodo pide las opciones faltantes para crear correctamente el gato
     *
     * @param mensaje a mostar para pedir la informacion
     * @param opciones son las opciones que eligira la persona
     * @return el valor elegido por la persona
     */
    private String seleccionarOpcionFaltante(String mensaje, Object[] opciones) {
        Object seleccion = controlPrincipal.mostrarJOptionSeleccionarDatoFaltante(mensaje, opciones);
        return seleccion != null ? seleccion.toString() : "";
    }

    /**
     * Crea la serializacion para poder escribir el documento
     */
    public void crearSerializacion() {
        boolean flag = true;
        Serializacion serializacion = null;
        do {
            try {
                serializacion = new Serializacion(controlPrincipal.crearArchivoSerializado());
                if (serializacion != null) {
                    flag = false;
                }
            } catch (FileNotFoundException ex) {
                controlPrincipal.mostrarMensajeError("El archivo no ha sido encontrado");
            } catch (IOException ex) {
                controlPrincipal.mostrarMensajeError("No se pudo cargar el archivo serializado");
            }
        } while (flag);
        escribirArchivoSerializado(serializacion);
        cerrarArchivoSerializadoIn(serializacion);
    }

    /**
     *
     * Cierra el stream de entrada de objetos si está abierto.
     *
     * @param serializacion
     */
    public void cerrarArchivoSerializadoIn(Serializacion serializacion) {
        if (serializacion != null && serializacion.getSalidaSerializacion() != null) {
            try {
                serializacion.cerrarArchivoSerializadoOut();
            } catch (IOException ex) {
                controlPrincipal.mostrarMensajeError("No se puede cerrar la entrada");
            }
        }
    }

    /**
     * Escribe en el documento lo que se requiere
     *
     * @param serializacion es la referencia para llamar a los metodos
     */
    public void escribirArchivoSerializado(Serializacion serializacion) {
        GatoVO gato = null;
        try {
            serializacion.escribirArchivoSerializado(gato);
        } catch (IOException ex) {
            controlPrincipal.mostrarMensajeError("No se puede serializar la persona");
        }
    }

    /**
     * Completa la raza segun los puesto por la persona
     *
     * @param divisionRaza es el dato para identificar
     * @return el nuevo valor de la raza
     */
    public String identificarRazaSegunEMS(String[] divisionRaza) {
        for (String raza : divisionRaza) {
            if (raza.equals("ABY") || raza.equalsIgnoreCase("Abyssinian")) {
                return ("ABY-Abyssinian");
            } else if (raza.equals("AMB") || raza.equalsIgnoreCase("American Burmese")) {
                return ("AMB-American Burmese");
            } else if (raza.equals("ACL") || raza.equalsIgnoreCase("American Curl Longhair")) {
                return ("ACL-American Curl Longhair");
            } else if (raza.equals("ACS") || raza.equalsIgnoreCase("American Curl Shorthair")) {
                return ("ACS-American Curl Shorthair");
            } else if (raza.equals("ASH") || raza.equalsIgnoreCase("American Shorthair")) {
                return ("ASH-American Shorthair");
            } else if (raza.equals("AWH") || raza.equalsIgnoreCase("American Wirehair")) {
                return ("AWH-American Wirehair");
            } else if (raza.equals("ANA") || raza.equalsIgnoreCase("Anatoli")) {
                return ("ANA-Anatoli");
            } else if (raza.equals("APL") || raza.equalsIgnoreCase("Aphrodite’s Giant Longhair")) {
                return ("APL-Aphrodite’s Giant Longhair");
            } else if (raza.equals("APS") || raza.equalsIgnoreCase("Aphrodite’s Giant Shorthair")) {
                return ("APS-Aphrodite’s Giant Shorthair");
            } else if (raza.equals("ARM") || raza.equalsIgnoreCase("Arabian Mau")) {
                return ("ARM-Arabian Mau");
            } else if (raza.equals("ASI") || raza.equalsIgnoreCase("Asian")) {
                return ("ASI-Asian");
            } else if (raza.equals("AUM") || raza.equalsIgnoreCase("Australian Mist")) {
                return ("AUM-Australian Mist");
            } else if (raza.equals("BAL") || raza.equalsIgnoreCase("Balinese")) {
                return ("BAL-Balinese");
            } else if (raza.equals("BEN") || raza.equalsIgnoreCase("Bengal")) {
                return ("BEN-Bengal");
            } else if (raza.equals("BOM") || raza.equalsIgnoreCase("Bombay")) {
                return ("BOM-Bombay");
            } else if (raza.equals("BRA") || raza.equalsIgnoreCase("Brazilian Shorthair")) {
                return ("BRA-Brazilian Shorthair");
            } else if (raza.equals("BLH") || raza.equalsIgnoreCase("British Longhair")) {
                return ("BLH-British Longhair");
            } else if (raza.equals("BRI") || raza.equalsIgnoreCase("British Shorthair")) {
                return ("BRI-British Shorthair");
            } else if (raza.equals("BUR") || raza.equalsIgnoreCase("Burmese")) {
                return ("BUR-Burmese");
            } else if (raza.equals("BML") || raza.equalsIgnoreCase("Burmilla Longhair")) {
                return ("BML-Burmilla Longhair");
            } else if (raza.equals("BMS") || raza.equalsIgnoreCase("Burmilla Shorthair")) {
                return ("BMS-Burmilla Shorthair");
            } else if (raza.equals("CAM") || raza.equalsIgnoreCase("Cashmere")) {
                return ("CAM-Cashmere");
            } else if (raza.equals("KKH") || raza.equalsIgnoreCase("Celtic Shorthair")) {
                return ("KKH-Celtic Shorthair");
            } else if (raza.equals("CEY") || raza.equalsIgnoreCase("Ceylon")) {
                return ("CEY-Ceylon");
            } else if (raza.equals("CHA") || raza.equalsIgnoreCase("Chartreux")) {
                return ("CHA-Chartreux");
            } else if (raza.equals("CHS") || raza.equalsIgnoreCase("Chausie")) {
                return ("CHS-Chausie");
            } else if (raza.equals("CRX") || raza.equalsIgnoreCase("Cornish Rex")) {
                return ("CRX-Cornish Rex");
            } else if (raza.equals("CYM") || raza.equalsIgnoreCase("Cymric")) {
                return ("CYM-Cymric");
            } else if (raza.equals("DLH") || raza.equalsIgnoreCase("Deutsch-Langhaar")) {
                return ("DLH-Deutsch-Langhaar");
            } else if (raza.equals("DRX") || raza.equalsIgnoreCase("Devon Rex")) {
                return ("DRX-Devon Rex");
            } else if (raza.equals("DSX") || raza.equalsIgnoreCase("Don Sphynx")) {
                return ("DSX-Don Sphynx");
            } else if (raza.equals("MAU") || raza.equalsIgnoreCase("Egyptian Mau")) {
                return ("MAU-Egyptian Mau");
            } else if (raza.equals("EXO") || raza.equalsIgnoreCase("Exotic Shorthair")) {
                return ("EXO-Exotic Shorthair");
            } else if (raza.equals("GRX") || raza.equalsIgnoreCase("German Rex")) {
                return ("GRX-German Rex");
            } else if (raza.equals("HAV") || raza.equalsIgnoreCase("Havana")) {
                return ("HAV-Havana");
            } else if (raza.equals("SFL") || raza.equalsIgnoreCase("Highland Fold")) {
                return ("SFL-Highland Fold");
            } else if (raza.equals("PER") || raza.equalsIgnoreCase("Persian")) {
                return ("PER-Persian");
            } else if (raza.equals("HHP") || raza.equalsIgnoreCase("Household Pet")) {
                return ("HHP-Household Pet");
            } else if (raza.equals("JBL") || raza.equalsIgnoreCase("Japanese Bobtail Longhair")) {
                return ("JBL-Japanese Bobtail Longhair");
            } else if (raza.equals("JBS") || raza.equalsIgnoreCase("Japanese Bobtail Shorthair")) {
                return ("JBS-Japanese Bobtail Shorthair");
            } else if (raza.equals("KAN") || raza.equalsIgnoreCase("Kanaani")) {
                return ("KAN-Kanaani");
            } else if (raza.equals("KAL") || raza.equalsIgnoreCase("Karelian Bobtail Longhair")) {
                return ("KAL-Karelian Bobtail Longhair");
            } else if (raza.equals("KAS") || raza.equalsIgnoreCase("Karelian Bobtail Shorthair")) {
                return ("KAS-Karelian Bobtail Shorthair");
            } else if (raza.equals("KAM") || raza.equalsIgnoreCase("Khao Manee")) {
                return ("KAM-Khao Manee");
            } else if (raza.equals("KOR") || raza.equalsIgnoreCase("Korat")) {
                return ("KOR-Korat");
            } else if (raza.equals("KBL") || raza.equalsIgnoreCase("Kurilian Bobtail Langhaar")) {
                return ("KBL-Kurilian Bobtail Langhaar");
            } else if (raza.equals("KBS") || raza.equalsIgnoreCase("Kurilian Bobtail Shorthair")) {
                return ("KBS-Kurilian Bobtail Shorthair");
            } else if (raza.equals("LPL") || raza.equalsIgnoreCase("LaPerm Longhair")) {
                return ("LPL-LaPerm Longhair");
            } else if (raza.equals("LPS") || raza.equalsIgnoreCase("LaPerm Shorthair")) {
                return ("LPS-LaPerm Shorthair");
            } else if (raza.equals("LYS") || raza.equalsIgnoreCase("Lykoi")) {
                return ("LYS-Lykoi");
            } else if (raza.equals("MCO") || raza.equalsIgnoreCase("Maine Coon")) {
                return ("MCO-Maine Coon");
            } else if (raza.equals("MAN") || raza.equalsIgnoreCase("Manx")) {
                return ("MAN-Manx");
            } else if (raza.equals("MBT") || raza.equalsIgnoreCase("Mekong Bobtail")) {
                return ("MBT-Mekong Bobtail");
            } else if (raza.equals("MIL") || raza.equalsIgnoreCase("Minuet Longhair")) {
                return ("MIL-Minuet Longhair");
            } else if (raza.equals("MIS") || raza.equalsIgnoreCase("Minuet Shorthair")) {
                return ("MIS-Minuet Shorthair");
            } else if (raza.equals("MNL") || raza.equalsIgnoreCase("Munchkin Longhair")) {
                return ("MNL-Munchkin Longhair");
            } else if (raza.equals("MNS") || raza.equalsIgnoreCase("Munchkin Shorthair")) {
                return ("MNS-Munchkin Shorthair");
            } else if (raza.equals("NEB") || raza.equalsIgnoreCase("Nebelung")) {
                return ("NEB-Nebelung");
            } else if (raza.equals("NFO") || raza.equalsIgnoreCase("Norwegian Forest")) {
                return ("NFO-Norwegian Forest");
            } else if (raza.equals("OCI") || raza.equalsIgnoreCase("Ocicat")) {
                return ("OCI-Ocicat");
            } else if (raza.equals("OSL") || raza.equalsIgnoreCase("Oriental Semilonghair")) {
                return ("OSL-Oriental Semilonghair");
            } else if (raza.equals("OSH") || raza.equalsIgnoreCase("Oriental Shorthair")) {
                return ("OSH-Oriental Shorthair");
            } else if (raza.equals("TLH") || raza.equalsIgnoreCase("Original Longhair")) {
                return ("TLH-Original Longhair");
            } else if (raza.equals("PBD") || raza.equalsIgnoreCase("Peterbald")) {
                return ("PBD-Peterbald");
            } else if (raza.equals("RGM") || raza.equalsIgnoreCase("Ragamuffin")) {
                return ("RGM-Ragamuffin");
            } else if (raza.equals("RAG") || raza.equalsIgnoreCase("Ragdoll")) {
                return ("RAG-Ragdoll");
            } else if (raza.equals("RUS") || raza.equalsIgnoreCase("Russian Blue")) {
                return ("RUS-Russian Blue");
            } else if (raza.equals("SBI") || raza.equalsIgnoreCase("Sacred Birman")) {
                return ("SBI-Sacred Birman");
            } else if (raza.equals("SFS") || raza.equalsIgnoreCase("Scottish Fold")) {
                return ("SFS-Scottish Fold");
            } else if (raza.equals("SRL") || raza.equalsIgnoreCase("Selkirk Rex Longhair")) {
                return ("SRL-Selkirk Rex Longhair");
            } else if (raza.equals("SRS") || raza.equalsIgnoreCase("Selkirk Rex Shorthair")) {
                return ("SRS-Selkirk Rex Shorthair");
            } else if (raza.equals("SIA") || raza.equalsIgnoreCase("Siamese")) {
                return ("SIA-Siamese");
            } else if (raza.equals("SIB") || raza.equalsIgnoreCase("Siberian cat / Neva Masquerade")) {
                return ("SIB-Siberian cat / Neva Masquerade");
            } else if (raza.equals("SIN") || raza.equalsIgnoreCase("Singapura")) {
                return ("SIN-Singapura");
            } else if (raza.equals("SNO") || raza.equalsIgnoreCase("Snowshoe")) {
                return ("SNO-Snowshoe");
            } else if (raza.equals("SOM") || raza.equalsIgnoreCase("Somali")) {
                return ("SOM-Somali");
            } else if (raza.equals("SPH") || raza.equalsIgnoreCase("Sphynx")) {
                return ("SPH-Sphynx");
            } else if (raza.equals("THA") || raza.equalsIgnoreCase("Thai")) {
                return ("THA-Thai");
            } else if (raza.equals("TIF") || raza.equalsIgnoreCase("Tiffanie")) {
                return ("TIF-Tiffanie");
            } else if (raza.equals("TON") || raza.equalsIgnoreCase("Tonkinese")) {
                return ("TON-Tonkinese");
            } else if (raza.equals("TOB") || raza.equalsIgnoreCase("Toy Bob")) {
                return ("TOB-Toy Bob");
            } else if (raza.equals("TUA") || raza.equalsIgnoreCase("Turkish Angora")) {
                return ("TUA-Turkish Angora");
            } else if (raza.equals("TUV") || raza.equalsIgnoreCase("Turkish Van")) {
                return ("TUV-Turkish Van");
            } else if (raza.equals("URL") || raza.equalsIgnoreCase("Ural Rex Longhair")) {
                return ("URL-Ural Rex Longhair");
            } else if (raza.equals("URS") || raza.equalsIgnoreCase("Ural Rex Shorthair")) {
                return ("URS-Ural Rex Shorthair");
            } else if (raza.equals("YOR") || raza.equalsIgnoreCase("York")) {
                return ("YOR-York");
            }
        }
        controlPrincipal.mostrarMensajeError("La raza digitada no existe o el campo se encuentra vacio");
        return null;
    }

    /**
     * Completa la raza segun los puesto por la persona
     *
     * @param divisionColor parametro para identificar
     * @return el valor
     */
    public String identificarColorCuerpoSegunEMS(String[] divisionColor) {
        for (String colorCuerpo : divisionColor) {
            if (colorCuerpo.equals("n") || colorCuerpo.equalsIgnoreCase("black") || colorCuerpo.equalsIgnoreCase("seal")) {
                return ("n-black / seal");
            } else if (colorCuerpo.equals("f") || colorCuerpo.equalsIgnoreCase("black tortie")) {
                return ("f-black tortie");
            } else if (colorCuerpo.equals("a") || colorCuerpo.equalsIgnoreCase("blue")) {
                return ("a-blue");
            } else if (colorCuerpo.equals("g") || colorCuerpo.equalsIgnoreCase("blue tortie")) {
                return ("g-blue tortie");
            } else if (colorCuerpo.equals("b") || colorCuerpo.equalsIgnoreCase("chocolate")) {
                return ("b-chocolate");
            } else if (colorCuerpo.equals("h") || colorCuerpo.equalsIgnoreCase("chocolate tortie")) {
                return ("h-chocolate tortie");
            } else if (colorCuerpo.equals("c") || colorCuerpo.equalsIgnoreCase("lilac")) {
                return ("c-lilac");
            } else if (colorCuerpo.equals("o") || colorCuerpo.equalsIgnoreCase("cinnamon")) {
                return ("o-cinnamon");
            } else if (colorCuerpo.equals("q") || colorCuerpo.equalsIgnoreCase("cinnamon tortie")) {
                return ("q-cinnamon tortie");
            } else if (colorCuerpo.equals("d") || colorCuerpo.equalsIgnoreCase("red")) {
                return ("d-red");
            } else if (colorCuerpo.equals("e") || colorCuerpo.equalsIgnoreCase("cream")) {
                return ("e-cream");
            } else if (colorCuerpo.equals("p") || colorCuerpo.equalsIgnoreCase("fawn")) {
                return ("p-fawn");
            } else if (colorCuerpo.equals("r") || colorCuerpo.equalsIgnoreCase("fawn tortie")) {
                return ("r-fawn tortie");
            } else if (colorCuerpo.equals("j") || colorCuerpo.equalsIgnoreCase("lilac tortie")) {
                return ("j-lilac tortie");
            } else if (colorCuerpo.equals("w") || colorCuerpo.equalsIgnoreCase("white")) {
                return ("w-white");
            } else if (colorCuerpo.equals("x") || colorCuerpo.equalsIgnoreCase("unrecognized")) {
                return ("x-unrecognized");
            }
        }
        return null;
    }

    /**
     * Completa la raza segun los puesto por la persona
     *
     * @param divisionCola parametro identificador
     * @return el valor
     */
    public String identificarColaSegunEMS(String[] divisionCola) {
        for (String cola : divisionCola) {
            if (cola.equals("51") || cola.equalsIgnoreCase("rumpy") || cola.equalsIgnoreCase("sin cola")) {
                return ("51-rumpy");
            } else if (cola.equals("52") || cola.equalsIgnoreCase("rumpy riser") || cola.equalsIgnoreCase("solo un poco de cola al final de la columna")) {
                return ("52-rumpy riser");
            } else if (cola.equals("53") || cola.equalsIgnoreCase("stumpy") || cola.equalsIgnoreCase("cola corta") || cola.equalsIgnoreCase("cola corta de aprox 3-4 cm")) {
                return ("53-stumpy");
            } else if (cola.equals("54") || cola.equalsIgnoreCase("longie")) {
                return ("54-longie");
            }
        }
        return null;
    }

    /**
     * Completa la raza segun los puesto por la persona
     *
     * @param divisionPatron parametro identificador
     * @return el valor
     */
    public String identificarPatronSegunEMS(String[] divisionPatron) {
        for (String patron : divisionPatron) {
            if (patron.equals("11") || patron.equalsIgnoreCase("shaded")) {
                return ("11-shaded");
            } else if (patron.equals("12") || patron.equalsIgnoreCase("shell")) {
                return ("12-shell");
            } else if (patron.equals("21") || patron.equalsIgnoreCase("tabby") || patron.equalsIgnoreCase("lynx") || patron.equalsIgnoreCase("tabby / lynx")) {
                return ("21-tabby / lynx");
            } else if (patron.equals("22") || patron.equalsIgnoreCase("classic")) {
                return ("22-classic");
            } else if (patron.equals("23") || patron.equalsIgnoreCase("mackerel")) {
                return ("23-mackerel");
            } else if (patron.equals("24") || patron.equalsIgnoreCase("spotted")) {
                return ("24-spotted");
            } else if (patron.equals("25") || patron.equalsIgnoreCase("ticked")) {
                return ("25-ticked");
            } else if (patron.equals("26") || patron.equalsIgnoreCase("grizzled") || patron.equalsIgnoreCase("grizzled ticked")) {
                return ("26-grizzled ticked");
            }
        }
        return null;
    }

    /**
     * Completa la raza segun los puesto por la persona
     *
     * @param divisionColorOjos parametro identificador
     * @return el valor
     */
    public String identificarColorOjosSegunEMS(String[] divisionColorOjos) {
        for (String colorOjos : divisionColorOjos) {
            if (colorOjos.equals("61") || colorOjos.equalsIgnoreCase("blue")) {
                return ("61-blue");
            } else if (colorOjos.equals("62") || colorOjos.equalsIgnoreCase("orange")) {
                return ("62-orange");
            } else if (colorOjos.equals("63") || colorOjos.equalsIgnoreCase("odd")) {
                return ("63-odd");
            } else if (colorOjos.equals("64") || colorOjos.equalsIgnoreCase("green")) {
                return ("64-green");
            } else if (colorOjos.equals("65") || colorOjos.equalsIgnoreCase("golden") || colorOjos.equalsIgnoreCase("golden (BUR)")) {
                return ("65-golden (BUR)");
            } else if (colorOjos.equals("66") || colorOjos.equalsIgnoreCase("aquamarine") || colorOjos.equalsIgnoreCase("aquamarine (TON)")) {
                return ("66-aquamarine (TON)");
            } else if (colorOjos.equals("67") || colorOjos.equalsIgnoreCase("dark blue") || colorOjos.equalsIgnoreCase("dark blue (SIA)")) {
                return ("67-dark blue (SIA)");
            }
        }
        controlPrincipal.mostrarMensajeError("El color digitado no existe o el campo se encuentra vacio");
        return null;
    }

}
