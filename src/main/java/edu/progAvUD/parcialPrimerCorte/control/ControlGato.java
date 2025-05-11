package edu.progAvUD.parcialPrimerCorte.control;

import edu.progAvUD.parcialPrimerCorte.modelo.GatoDAO;
import edu.progAvUD.parcialPrimerCorte.modelo.GatoVO;
import edu.progAvUD.parcialPrimerCorte.modelo.Serializacion;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Andres Felipe
 */
public class ControlGato {

    private ControlPrincipal controlPrincipal;
    private ArrayList<GatoVO> gatos;
    private GatoDAO gatoDao;

    public ControlGato(ControlPrincipal controlPrincipal) {
        this.controlPrincipal = controlPrincipal;
        this.gatos = new ArrayList<>();
        this.gatoDao = new GatoDAO();
    }

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
            Object[] colores = { /* Lista de colores */};
            color = seleccionarOpcionFaltante("color del gato " + id, opcionesColor);
        }
        if (patron.isBlank()) {
            Object[] patrones = { /* Lista de patrones */};
            patron = seleccionarOpcionFaltante("patrón del gato " + id, opcionesPatron);
        }
        if (colorOjos.isBlank()) {
            Object[] coloresOjos = { /* Lista de colores de ojos */};
            colorOjos = seleccionarOpcionFaltante("color de ojos del gato " + id, opcionesColorOjos);
        }
        if (cola.isBlank()) {
            Object[] colas = { /* Lista de tipos de cola */};
            cola = seleccionarOpcionFaltante("cola del gato " + id, opcionesCola);
        }

        GatoVO gato = null;
        String[] divisionRaza = raza.split("-");
        divisionRaza = identificarRazaSegunEMS(divisionRaza);
        String[] divisionColor = color.split("-");
        divisionColor = identificarColorCuerpoSegunEMS(divisionColor);
        String[] divisionPatron = patron.split("-");
        divisionPatron = identificarPatronSegunEMS(divisionPatron);
        String[] divisionColorOjos = colorOjos.split("-");
        divisionColorOjos = identificarColorOjosSegunEMS(divisionColorOjos);
        String[] divisionCola = cola.split("-");
        divisionCola = identificarColaSegunEMS(divisionCola);

        String codigoEMS = divisionRaza[0] + "/" + divisionColor[0] + "/" + divisionPatron[0] + "/" + divisionColorOjos[0] + "/" + divisionCola[0];
        gato = new GatoVO(nombre, peso, edad, codigoEMS, raza, color, patron, colorOjos, cola);

        if (consultarCantidadGatos() == 0) {
            insertarGato(gato);
            System.out.println("Se inserto gato "+ id);
        } else {
            if (verificarGatoRepetido(gato)) {
                insertarGato(gato);
                System.out.println("Se inserto gato "+ id);
            } else {
                controlPrincipal.mostrarMensajeError("No se ha creado el gato" + id + " de propiedades porque ya se encuentra en la Base de Datos");
            }
        }

    }

    public boolean verificarGatoRepetido(GatoVO gato) {
        ArrayList<GatoVO> gatos = darListaGatos();
        for (GatoVO gatoValidar : gatos) {

            System.out.println(gato.getNombre() + " == " + gatoValidar.getNombre() + "\n"
                    + gato.getPeso() + " == " + gatoValidar.getPeso() + "\n"
                    + gato.getEdad() + " == " + gatoValidar.getEdad() + "\n"
                    + gato.getCodigoEMS() + " == " + gatoValidar.getCodigoEMS() + "\n"+"\n");

            if (gato.getNombre().equals(gatoValidar.getNombre())
                    && gato.getPeso().equals(gatoValidar.getPeso())
                    && gato.getEdad().equals(gatoValidar.getEdad())
                    && gato.getCodigoEMS().equals(gatoValidar.getCodigoEMS())) {
                return false;
            }
        }
        return true;
    }

    public int consultarCantidadGatos() {
        try {
            return gatoDao.consultarCantidadGatos();
        } catch (SQLException ex) {
            controlPrincipal.mostrarMensajeError("SQLException ConsultarCantidadGatos");
            ex.printStackTrace();
        }
        return -1;
    }

    public ArrayList<GatoVO> darListaGatos() {
        GatoVO gato = new GatoVO();
        ArrayList<GatoVO> gatos = new ArrayList<>();
        try {
            return gatoDao.darListaGatos(gato, gatos);
        } catch (SQLException ex) {
            controlPrincipal.mostrarMensajeError("SQLException darListaGatos");
        }
        return null;
    }

    public void pedirConsultaGato(int id) {
        GatoVO gato = new GatoVO();
        try {
            gatoDao.consultarGato(id, gato);
        } catch (SQLException ex) {
            controlPrincipal.mostrarMensajeError("SQLException pedirConsultaGato");
        }
    }

    public void insertarGato(GatoVO gato) {
        try {
            gatoDao.insertarGato(gato);
        } catch (SQLException ex) {
            controlPrincipal.mostrarMensajeError("SQLException insertarGato");
        }
    }

    public void eliminarGato(int id) {
        try {
            gatoDao.eliminarGato(id);
        } catch (SQLException ex) {
            controlPrincipal.mostrarMensajeError("SQLException eliminarGato");
        }
    }

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
                return obtenerDatoFaltante(mensaje, tipo); // Volver a pedir el dato
            }
        }
        return dato;
    }

    private String seleccionarOpcionFaltante(String mensaje, Object[] opciones) {
        Object seleccion = controlPrincipal.mostrarJOptionSeleccionarDatoFaltante(mensaje, opciones);
        return seleccion != null ? seleccion.toString() : "";
    }

    public void crearSerializacion(String accion) {
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

    public void escribirArchivoSerializado(Serializacion serializacion) {
        GatoVO gato = null;
        try {
            serializacion.escribirArchivoSerializado(gato);
        } catch (IOException ex) {
            controlPrincipal.mostrarMensajeError("No se puede serializar la persona");
        }
    }

    public String[] identificarRazaSegunEMS(String[] divisionRaza) {
        for (String raza : divisionRaza) {
            if (raza.equals("ABY") || raza.equalsIgnoreCase("Abyssinian")) {
                return ("ABY-Abyssinian").split("-");
            } else if (raza.equals("AMB") || raza.equalsIgnoreCase("American Burmese")) {
                return ("AMB-American Burmese").split("-");
            } else if (raza.equals("ACL") || raza.equalsIgnoreCase("American Curl Longhair")) {
                return ("ACL-American Curl Longhair").split("-");
            } else if (raza.equals("ACS") || raza.equalsIgnoreCase("American Curl Shorthair")) {
                return ("ACS-American Curl Shorthair").split("-");
            } else if (raza.equals("ASH") || raza.equalsIgnoreCase("American Shorthair")) {
                return ("ASH-American Shorthair").split("-");
            } else if (raza.equals("AWH") || raza.equalsIgnoreCase("American Wirehair")) {
                return ("AWH-American Wirehair").split("-");
            } else if (raza.equals("ANA") || raza.equalsIgnoreCase("Anatoli")) {
                return ("ANA-Anatoli").split("-");
            } else if (raza.equals("APL") || raza.equalsIgnoreCase("Aphrodite’s Giant Longhair")) {
                return ("APL-Aphrodite’s Giant Longhair").split("-");
            } else if (raza.equals("APS") || raza.equalsIgnoreCase("Aphrodite’s Giant Shorthair")) {
                return ("APS-Aphrodite’s Giant Shorthair").split("-");
            } else if (raza.equals("ARM") || raza.equalsIgnoreCase("Arabian Mau")) {
                return ("ARM-Arabian Mau").split("-");
            } else if (raza.equals("ASI") || raza.equalsIgnoreCase("Asian")) {
                return ("ASI-Asian").split("-");
            } else if (raza.equals("AUM") || raza.equalsIgnoreCase("Australian Mist")) {
                return ("AUM-Australian Mist").split("-");
            } else if (raza.equals("BAL") || raza.equalsIgnoreCase("Balinese")) {
                return ("BAL-Balinese").split("-");
            } else if (raza.equals("BEN") || raza.equalsIgnoreCase("Bengal")) {
                return ("BEN-Bengal").split("-");
            } else if (raza.equals("BOM") || raza.equalsIgnoreCase("Bombay")) {
                return ("BOM-Bombay").split("-");
            } else if (raza.equals("BRA") || raza.equalsIgnoreCase("Brazilian Shorthair")) {
                return ("BRA-Brazilian Shorthair").split("-");
            } else if (raza.equals("BLH") || raza.equalsIgnoreCase("British Longhair")) {
                return ("BLH-British Longhair").split("-");
            } else if (raza.equals("BRI") || raza.equalsIgnoreCase("British Shorthair")) {
                return ("BRI-British Shorthair").split("-");
            } else if (raza.equals("BUR") || raza.equalsIgnoreCase("Burmese")) {
                return ("BUR-Burmese").split("-");
            } else if (raza.equals("BML") || raza.equalsIgnoreCase("Burmilla Longhair")) {
                return ("BML-Burmilla Longhair").split("-");
            } else if (raza.equals("BMS") || raza.equalsIgnoreCase("Burmilla Shorthair")) {
                return ("BMS-Burmilla Shorthair").split("-");
            } else if (raza.equals("CAM") || raza.equalsIgnoreCase("Cashmere")) {
                return ("CAM-Cashmere").split("-");
            } else if (raza.equals("KKH") || raza.equalsIgnoreCase("Celtic Shorthair")) {
                return ("KKH-Celtic Shorthair").split("-");
            } else if (raza.equals("CEY") || raza.equalsIgnoreCase("Ceylon")) {
                return ("CEY-Ceylon").split("-");
            } else if (raza.equals("CHA") || raza.equalsIgnoreCase("Chartreux")) {
                return ("CHA-Chartreux").split("-");
            } else if (raza.equals("CHS") || raza.equalsIgnoreCase("Chausie")) {
                return ("CHS-Chausie").split("-");
            } else if (raza.equals("CRX") || raza.equalsIgnoreCase("Cornish Rex")) {
                return ("CRX-Cornish Rex").split("-");
            } else if (raza.equals("CYM") || raza.equalsIgnoreCase("Cymric")) {
                return ("CYM-Cymric").split("-");
            } else if (raza.equals("DLH") || raza.equalsIgnoreCase("Deutsch-Langhaar")) {
                return ("DLH-Deutsch-Langhaar").split("-");
            } else if (raza.equals("DRX") || raza.equalsIgnoreCase("Devon Rex")) {
                return ("DRX-Devon Rex").split("-");
            } else if (raza.equals("DSX") || raza.equalsIgnoreCase("Don Sphynx")) {
                return ("DSX-Don Sphynx").split("-");
            } else if (raza.equals("MAU") || raza.equalsIgnoreCase("Egyptian Mau")) {
                return ("MAU-Egyptian Mau").split("-");
            } else if (raza.equals("EXO") || raza.equalsIgnoreCase("Exotic Shorthair")) {
                return ("EXO-Exotic Shorthair").split("-");
            } else if (raza.equals("GRX") || raza.equalsIgnoreCase("German Rex")) {
                return ("GRX-German Rex").split("-");
            } else if (raza.equals("HAV") || raza.equalsIgnoreCase("Havana")) {
                return ("HAV-Havana").split("-");
            } else if (raza.equals("SFL") || raza.equalsIgnoreCase("Highland Fold")) {
                return ("SFL-Highland Fold").split("-");
            } else if (raza.equals("PER") || raza.equalsIgnoreCase("Persian")) {
                return ("PER-Persian").split("-");
            } else if (raza.equals("HHP") || raza.equalsIgnoreCase("Household Pet")) {
                return ("HHP-Household Pet").split("-");
            } else if (raza.equals("JBL") || raza.equalsIgnoreCase("Japanese Bobtail Longhair")) {
                return ("JBL-Japanese Bobtail Longhair").split("-");
            } else if (raza.equals("JBS") || raza.equalsIgnoreCase("Japanese Bobtail Shorthair")) {
                return ("JBS-Japanese Bobtail Shorthair").split("-");
            } else if (raza.equals("KAN") || raza.equalsIgnoreCase("Kanaani")) {
                return ("KAN-Kanaani").split("-");
            } else if (raza.equals("KAL") || raza.equalsIgnoreCase("Karelian Bobtail Longhair")) {
                return ("KAL-Karelian Bobtail Longhair").split("-");
            } else if (raza.equals("KAS") || raza.equalsIgnoreCase("Karelian Bobtail Shorthair")) {
                return ("KAS-Karelian Bobtail Shorthair").split("-");
            } else if (raza.equals("KAM") || raza.equalsIgnoreCase("Khao Manee")) {
                return ("KAM-Khao Manee").split("-");
            } else if (raza.equals("KOR") || raza.equalsIgnoreCase("Korat")) {
                return ("KOR-Korat").split("-");
            } else if (raza.equals("KBL") || raza.equalsIgnoreCase("Kurilian Bobtail Langhaar")) {
                return ("KBL-Kurilian Bobtail Langhaar").split("-");
            } else if (raza.equals("KBS") || raza.equalsIgnoreCase("Kurilian Bobtail Shorthair")) {
                return ("KBS-Kurilian Bobtail Shorthair").split("-");
            } else if (raza.equals("LPL") || raza.equalsIgnoreCase("LaPerm Longhair")) {
                return ("LPL-LaPerm Longhair").split("-");
            } else if (raza.equals("LPS") || raza.equalsIgnoreCase("LaPerm Shorthair")) {
                return ("LPS-LaPerm Shorthair").split("-");
            } else if (raza.equals("LYS") || raza.equalsIgnoreCase("Lykoi")) {
                return ("LYS-Lykoi").split("-");
            } else if (raza.equals("MCO") || raza.equalsIgnoreCase("Maine Coon")) {
                return ("MCO-Maine Coon").split("-");
            } else if (raza.equals("MAN") || raza.equalsIgnoreCase("Manx")) {
                return ("MAN-Manx").split("-");
            } else if (raza.equals("MBT") || raza.equalsIgnoreCase("Mekong Bobtail")) {
                return ("MBT-Mekong Bobtail").split("-");
            } else if (raza.equals("MIL") || raza.equalsIgnoreCase("Minuet Longhair")) {
                return ("MIL-Minuet Longhair").split("-");
            } else if (raza.equals("MIS") || raza.equalsIgnoreCase("Minuet Shorthair")) {
                return ("MIS-Minuet Shorthair").split("-");
            } else if (raza.equals("MNL") || raza.equalsIgnoreCase("Munchkin Longhair")) {
                return ("MNL-Munchkin Longhair").split("-");
            } else if (raza.equals("MNS") || raza.equalsIgnoreCase("Munchkin Shorthair")) {
                return ("MNS-Munchkin Shorthair").split("-");
            } else if (raza.equals("NEB") || raza.equalsIgnoreCase("Nebelung")) {
                return ("NEB-Nebelung").split("-");
            } else if (raza.equals("NFO") || raza.equalsIgnoreCase("Norwegian Forest")) {
                return ("NFO-Norwegian Forest").split("-");
            } else if (raza.equals("OCI") || raza.equalsIgnoreCase("Ocicat")) {
                return ("OCI-Ocicat").split("-");
            } else if (raza.equals("OSL") || raza.equalsIgnoreCase("Oriental Semilonghair")) {
                return ("OSL-Oriental Semilonghair").split("-");
            } else if (raza.equals("OSH") || raza.equalsIgnoreCase("Oriental Shorthair")) {
                return ("OSH-Oriental Shorthair").split("-");
            } else if (raza.equals("TLH") || raza.equalsIgnoreCase("Original Longhair")) {
                return ("TLH-Original Longhair").split("-");
            } else if (raza.equals("PBD") || raza.equalsIgnoreCase("Peterbald")) {
                return ("PBD-Peterbald").split("-");
            } else if (raza.equals("RGM") || raza.equalsIgnoreCase("Ragamuffin")) {
                return ("RGM-Ragamuffin").split("-");
            } else if (raza.equals("RAG") || raza.equalsIgnoreCase("Ragdoll")) {
                return ("RAG-Ragdoll").split("-");
            } else if (raza.equals("RUS") || raza.equalsIgnoreCase("Russian Blue")) {
                return ("RUS-Russian Blue").split("-");
            } else if (raza.equals("SBI") || raza.equalsIgnoreCase("Sacred Birman")) {
                return ("SBI-Sacred Birman").split("-");
            } else if (raza.equals("SFS") || raza.equalsIgnoreCase("Scottish Fold")) {
                return ("SFS-Scottish Fold").split("-");
            } else if (raza.equals("SRL") || raza.equalsIgnoreCase("Selkirk Rex Longhair")) {
                return ("SRL-Selkirk Rex Longhair").split("-");
            } else if (raza.equals("SRS") || raza.equalsIgnoreCase("Selkirk Rex Shorthair")) {
                return ("SRS-Selkirk Rex Shorthair").split("-");
            } else if (raza.equals("SIA") || raza.equalsIgnoreCase("Siamese")) {
                return ("SIA-Siamese").split("-");
            } else if (raza.equals("SIB") || raza.equalsIgnoreCase("Siberian cat / Neva Masquerade")) {
                return ("SIB-Siberian cat / Neva Masquerade").split("-");
            } else if (raza.equals("SIN") || raza.equalsIgnoreCase("Singapura")) {
                return ("SIN-Singapura").split("-");
            } else if (raza.equals("SNO") || raza.equalsIgnoreCase("Snowshoe")) {
                return ("SNO-Snowshoe").split("-");
            } else if (raza.equals("SOM") || raza.equalsIgnoreCase("Somali")) {
                return ("SOM-Somali").split("-");
            } else if (raza.equals("SPH") || raza.equalsIgnoreCase("Sphynx")) {
                return ("SPH-Sphynx").split("-");
            } else if (raza.equals("THA") || raza.equalsIgnoreCase("Thai")) {
                return ("THA-Thai").split("-");
            } else if (raza.equals("TIF") || raza.equalsIgnoreCase("Tiffanie")) {
                return ("TIF-Tiffanie").split("-");
            } else if (raza.equals("TON") || raza.equalsIgnoreCase("Tonkinese")) {
                return ("TON-Tonkinese").split("-");
            } else if (raza.equals("TOB") || raza.equalsIgnoreCase("Toy Bob")) {
                return ("TOB-Toy Bob").split("-");
            } else if (raza.equals("TUA") || raza.equalsIgnoreCase("Turkish Angora")) {
                return ("TUA-Turkish Angora").split("-");
            } else if (raza.equals("TUV") || raza.equalsIgnoreCase("Turkish Van")) {
                return ("TUV-Turkish Van").split("-");
            } else if (raza.equals("URL") || raza.equalsIgnoreCase("Ural Rex Longhair")) {
                return ("URL-Ural Rex Longhair").split("-");
            } else if (raza.equals("URS") || raza.equalsIgnoreCase("Ural Rex Shorthair")) {
                return ("URS-Ural Rex Shorthair").split("-");
            } else if (raza.equals("YOR") || raza.equalsIgnoreCase("York")) {
                return ("YOR-York").split("-");
            }
        }
        controlPrincipal.mostrarMensajeError("La raza digitada no existe o el campo se encuentra vacio");
        return null;
    }

    public String[] identificarColorCuerpoSegunEMS(String[] divisionColor) {
        for (String colorCuerpo : divisionColor) {
            if (colorCuerpo.equals("n") || colorCuerpo.equalsIgnoreCase("black") || colorCuerpo.equalsIgnoreCase("seal")) {
                return ("n-black / seal").split("-");
            } else if (colorCuerpo.equals("f") || colorCuerpo.equalsIgnoreCase("black tortie")) {
                return ("f-black tortie").split("-");
            } else if (colorCuerpo.equals("a") || colorCuerpo.equalsIgnoreCase("blue")) {
                return ("a-blue").split("-");
            } else if (colorCuerpo.equals("g") || colorCuerpo.equalsIgnoreCase("blue tortie")) {
                return ("g-blue tortie").split("-");
            } else if (colorCuerpo.equals("b") || colorCuerpo.equalsIgnoreCase("chocolate")) {
                return ("b-chocolate").split("-");
            } else if (colorCuerpo.equals("h") || colorCuerpo.equalsIgnoreCase("chocolate tortie")) {
                return ("h-chocolate tortie").split("-");
            } else if (colorCuerpo.equals("c") || colorCuerpo.equalsIgnoreCase("lilac")) {
                return ("c-lilac").split("-");
            } else if (colorCuerpo.equals("o") || colorCuerpo.equalsIgnoreCase("cinnamon")) {
                return ("o-cinnamon").split("-");
            } else if (colorCuerpo.equals("q") || colorCuerpo.equalsIgnoreCase("cinnamon tortie")) {
                return ("q-cinnamon tortie").split("-");
            } else if (colorCuerpo.equals("d") || colorCuerpo.equalsIgnoreCase("red")) {
                return ("d-red").split("-");
            } else if (colorCuerpo.equals("e") || colorCuerpo.equalsIgnoreCase("cream")) {
                return ("e-cream").split("-");
            } else if (colorCuerpo.equals("p") || colorCuerpo.equalsIgnoreCase("fawn")) {
                return ("p-fawn").split("-");
            } else if (colorCuerpo.equals("r") || colorCuerpo.equalsIgnoreCase("fawn tortie")) {
                return ("r-fawn tortie").split("-");
            } else if (colorCuerpo.equals("j") || colorCuerpo.equalsIgnoreCase("lilac tortie")) {
                return ("j-lilac tortie").split("-");
            } else if (colorCuerpo.equals("w") || colorCuerpo.equalsIgnoreCase("white")) {
                return ("w-white").split("-");
            } else if (colorCuerpo.equals("x") || colorCuerpo.equalsIgnoreCase("unrecognized")) {
                return ("x-unrecognized").split("-");
            }
        };
        return null;
    }

    public String[] identificarColaSegunEMS(String[] divisionCola) {
        for (String cola : divisionCola) {
            if (cola.equals("51") || cola.equalsIgnoreCase("rumpy") || cola.equalsIgnoreCase("sin cola")) {
                return ("51-rumpy – sin cola").split("-");
            } else if (cola.equals("52") || cola.equalsIgnoreCase("rumpy riser") || cola.equalsIgnoreCase("solo un poco de cola al final de la columna")) {
                return ("52-rumpy riser – solo un poco de cola al final de la columna").split("-");
            } else if (cola.equals("53") || cola.equalsIgnoreCase("stumpy") || cola.equalsIgnoreCase("cola corta") || cola.equalsIgnoreCase("cola corta de aprox 3-4 cm")) {
                return ("53-stumpy – cola corta de aprox 3-4 cm").split("-");
            } else if (cola.equals("54") || cola.equalsIgnoreCase("longie")) {
                return ("54-longie").split("-");
            }
        }
        ;
        return null;
    }

    public String[] identificarPatronSegunEMS(String[] divisionPatron) {
        for (String patron : divisionPatron) {
            if (patron.equals("11") || patron.equalsIgnoreCase("shaded")) {
                return ("11-shaded").split("-");
            } else if (patron.equals("12") || patron.equalsIgnoreCase("shell")) {
                return ("12-shell").split("-");
            } else if (patron.equals("21") || patron.equalsIgnoreCase("tabby") || patron.equalsIgnoreCase("lynx") || patron.equalsIgnoreCase("tabby / lynx")) {
                return ("21-tabby / lynx").split("-");
            } else if (patron.equals("22") || patron.equalsIgnoreCase("classic")) {
                return ("22-classic").split("-");
            } else if (patron.equals("23") || patron.equalsIgnoreCase("mackerel")) {
                return ("23-mackerel").split("-");
            } else if (patron.equals("24") || patron.equalsIgnoreCase("spotted")) {
                return ("24-spotted").split("-");
            } else if (patron.equals("25") || patron.equalsIgnoreCase("ticked")) {
                return ("25-ticked").split("-");
            } else if (patron.equals("26") || patron.equalsIgnoreCase("grizzled") || patron.equalsIgnoreCase("grizzled ticked")) {
                return ("26-grizzled ticked").split("-");
            }
        }
        return null;
    }

    public String[] identificarColorOjosSegunEMS(String[] divisionColorOjos) {
        for (String colorOjos : divisionColorOjos) {
            if (colorOjos.equals("61") || colorOjos.equalsIgnoreCase("blue")) {
                return ("61-blue").split("-");
            } else if (colorOjos.equals("62") || colorOjos.equalsIgnoreCase("orange")) {
                return ("62-orange").split("-");
            } else if (colorOjos.equals("63") || colorOjos.equalsIgnoreCase("odd")) {
                return ("63-odd").split("-");
            } else if (colorOjos.equals("64") || colorOjos.equalsIgnoreCase("green")) {
                return ("64-green").split("-");
            } else if (colorOjos.equals("65") || colorOjos.equalsIgnoreCase("golden") || colorOjos.equalsIgnoreCase("golden (BUR)")) {
                return ("65-golden (BUR)").split("-");
            } else if (colorOjos.equals("66") || colorOjos.equalsIgnoreCase("aquamarine") || colorOjos.equalsIgnoreCase("aquamarine (TON)")) {
                return ("66-aquamarine (TON)").split("-");
            } else if (colorOjos.equals("67") || colorOjos.equalsIgnoreCase("dark blue") || colorOjos.equalsIgnoreCase("dark blue (SIA)")) {
                return ("67-dark blue (SIA)").split("-");
            }
        }
        controlPrincipal.mostrarMensajeError("El color digitado no existe o el campo se encuentra vacio");
        return null;
    }

}
