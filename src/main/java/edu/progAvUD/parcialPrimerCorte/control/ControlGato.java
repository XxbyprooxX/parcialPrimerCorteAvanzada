package edu.progAvUD.parcialPrimerCorte.control;

import edu.progAvUD.parcialPrimerCorte.modelo.GatoDAO;
import edu.progAvUD.parcialPrimerCorte.modelo.GatoVO;
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
        String[] divisionRaza = raza.split("-");
        String[] divisionColor = color.split("-");
        String[] divisionPatron = patron.split("-");
        String[] divisionColorOjos = colorOjos.split("-");
        String[] divisionCola = cola.split("-");
        String codigoEMS = divisionRaza[0] + "/" + divisionColor[0] + "/" + divisionPatron[0] + "/" + divisionColorOjos[0] + "/" + divisionCola[0];
        GatoVO gato = new GatoVO(id, nombre, peso, edad, codigoEMS, raza, color, patron, colorOjos, cola);
        gatos.add(gato);
        insertarGato(gato);
    }

    public void pedirListaGatos() {
        try {
            while (gatoDao.getResultSet().next()) {
                GatoVO gato = new GatoVO();
                gatoDao.darListaGatos(gato);
            }
        } catch (SQLException ex) {
            controlPrincipal.mostrarMensajeError("SQLException");
        }
    }

    public void pedirConsultaGato(int id) {
        GatoVO gato = new GatoVO();
        try {
            gatoDao.consultarGato(id, gato);
        } catch (SQLException ex) {
            controlPrincipal.mostrarMensajeError("SQLException");
        }
    }

    public void insertarGato(GatoVO gato) {
        try {
            gatoDao.insertarGato(gato);
        } catch (SQLException ex) {
            controlPrincipal.mostrarMensajeError("SQLException");
        }
    }

    public void eliminarGato(int id) {
        try {
            gatoDao.eliminarGato(id);
        } catch (SQLException ex) {
            controlPrincipal.mostrarMensajeError("SQLExceptio_ex :PPPPPPPPPPPPPPPPPPPPPPPPPPPPpp");
        }
    }

    public String identificarRazaSegunEMS(String[] divisionRaza) {
        for (String raza : divisionRaza) {
            if (raza.equals("ABY") || raza.equalsIgnoreCase("Abyssinian")) {
                return "ABY-Abyssinian";
            } else if (raza.equals("AMB") || raza.equalsIgnoreCase("American Burmese")) {
                return "AMB-American Burmese";
            } else if (raza.equals("ACL") || raza.equalsIgnoreCase("American Curl Longhair")) {
                return "ACL-American Curl Longhair";
            } else if (raza.equals("ACS") || raza.equalsIgnoreCase("American Curl Shorthair")) {
                return "ACS-American Curl Shorthair";
            } else if (raza.equals("ASH") || raza.equalsIgnoreCase("American Shorthair")) {
                return "ASH-American Shorthair";
            } else if (raza.equals("AWH") || raza.equalsIgnoreCase("American Wirehair")) {
                return "AWH-American Wirehair";
            } else if (raza.equals("ANA") || raza.equalsIgnoreCase("Anatoli")) {
                return "ANA-Anatoli";
            } else if (raza.equals("APL") || raza.equalsIgnoreCase("Aphrodite’s Giant Longhair")) {
                return "APL-Aphrodite’s Giant Longhair";
            } else if (raza.equals("APS") || raza.equalsIgnoreCase("Aphrodite’s Giant Shorthair")) {
                return "APS-Aphrodite’s Giant Shorthair";
            } else if (raza.equals("ARM") || raza.equalsIgnoreCase("Arabian Mau")) {
                return "ARM-Arabian Mau";
            } else if (raza.equals("ASI") || raza.equalsIgnoreCase("Asian")) {
                return "ASI-Asian";
            } else if (raza.equals("AUM") || raza.equalsIgnoreCase("Australian Mist")) {
                return "AUM-Australian Mist";
            } else if (raza.equals("BAL") || raza.equalsIgnoreCase("Balinese")) {
                return "BAL-Balinese";
            } else if (raza.equals("BEN") || raza.equalsIgnoreCase("Bengal")) {
                return "BEN-Bengal";
            } else if (raza.equals("BOM") || raza.equalsIgnoreCase("Bombay")) {
                return "BOM-Bombay";
            } else if (raza.equals("BRA") || raza.equalsIgnoreCase("Brazilian Shorthair")) {
                return "BRA-Brazilian Shorthair";
            } else if (raza.equals("BLH") || raza.equalsIgnoreCase("British Longhair")) {
                return "BLH-British Longhair";
            } else if (raza.equals("BRI") || raza.equalsIgnoreCase("British Shorthair")) {
                return "BRI-British Shorthair";
            } else if (raza.equals("BUR") || raza.equalsIgnoreCase("Burmese")) {
                return "BUR-Burmese";
            } else if (raza.equals("BML") || raza.equalsIgnoreCase("Burmilla Longhair")) {
                return "BML-Burmilla Longhair";
            } else if (raza.equals("BMS") || raza.equalsIgnoreCase("Burmilla Shorthair")) {
                return "BMS-Burmilla Shorthair";
            } else if (raza.equals("CAM") || raza.equalsIgnoreCase("Cashmere")) {
                return "CAM-Cashmere";
            } else if (raza.equals("KKH") || raza.equalsIgnoreCase("Celtic Shorthair")) {
                return "KKH-Celtic Shorthair";
            } else if (raza.equals("CEY") || raza.equalsIgnoreCase("Ceylon")) {
                return "CEY-Ceylon";
            } else if (raza.equals("CHA") || raza.equalsIgnoreCase("Chartreux")) {
                return "CHA-Chartreux";
            } else if (raza.equals("CHS") || raza.equalsIgnoreCase("Chausie")) {
                return "CHS-Chausie";
            } else if (raza.equals("CRX") || raza.equalsIgnoreCase("Cornish Rex")) {
                return "CRX-Cornish Rex";
            } else if (raza.equals("CYM") || raza.equalsIgnoreCase("Cymric")) {
                return "CYM-Cymric";
            } else if (raza.equals("DLH") || raza.equalsIgnoreCase("Deutsch-Langhaar")) {
                return "DLH-Deutsch-Langhaar";
            } else if (raza.equals("DRX") || raza.equalsIgnoreCase("Devon Rex")) {
                return "DRX-Devon Rex";
            } else if (raza.equals("DSX") || raza.equalsIgnoreCase("Don Sphynx")) {
                return "DSX-Don Sphynx";
            } else if (raza.equals("MAU") || raza.equalsIgnoreCase("Egyptian Mau")) {
                return "MAU-Egyptian Mau";
            } else if (raza.equals("EXO") || raza.equalsIgnoreCase("Exotic Shorthair")) {
                return "EXO-Exotic Shorthair";
            } else if (raza.equals("GRX") || raza.equalsIgnoreCase("German Rex")) {
                return "GRX-German Rex";
            } else if (raza.equals("HAV") || raza.equalsIgnoreCase("Havana")) {
                return "HAV-Havana";
            } else if (raza.equals("SFL") || raza.equalsIgnoreCase("Highland Fold")) {
                return "SFL-Highland Fold";
            } else if (raza.equals("PER") || raza.equalsIgnoreCase("Persian")) {
                return "PER-Persian";
            } else if (raza.equals("HHP") || raza.equalsIgnoreCase("Household Pet")) {
                return "HHP-Household Pet";
            } else if (raza.equals("JBL") || raza.equalsIgnoreCase("Japanese Bobtail Longhair")) {
                return "JBL-Japanese Bobtail Longhair";
            } else if (raza.equals("JBS") || raza.equalsIgnoreCase("Japanese Bobtail Shorthair")) {
                return "JBS-Japanese Bobtail Shorthair";
            } else if (raza.equals("KAN") || raza.equalsIgnoreCase("Kanaani")) {
                return "KAN-Kanaani";
            } else if (raza.equals("KAL") || raza.equalsIgnoreCase("Karelian Bobtail Longhair")) {
                return "KAL-Karelian Bobtail Longhair";
            } else if (raza.equals("KAS") || raza.equalsIgnoreCase("Karelian Bobtail Shorthair")) {
                return "KAS-Karelian Bobtail Shorthair";
            } else if (raza.equals("KAM") || raza.equalsIgnoreCase("Khao Manee")) {
                return "KAM-Khao Manee";
            } else if (raza.equals("KOR") || raza.equalsIgnoreCase("Korat")) {
                return "KOR-Korat";
            } else if (raza.equals("KBL") || raza.equalsIgnoreCase("Kurilian Bobtail Langhaar")) {
                return "KBL-Kurilian Bobtail Langhaar";
            } else if (raza.equals("KBS") || raza.equalsIgnoreCase("Kurilian Bobtail Shorthair")) {
                return "KBS-Kurilian Bobtail Shorthair";
            } else if (raza.equals("LPL") || raza.equalsIgnoreCase("LaPerm Longhair")) {
                return "LPL-LaPerm Longhair";
            } else if (raza.equals("LPS") || raza.equalsIgnoreCase("LaPerm Shorthair")) {
                return "LPS-LaPerm Shorthair";
            } else if (raza.equals("LYS") || raza.equalsIgnoreCase("Lykoi")) {
                return "LYS-Lykoi";
            } else if (raza.equals("MCO") || raza.equalsIgnoreCase("Maine Coon")) {
                return "MCO-Maine Coon";
            } else if (raza.equals("MAN") || raza.equalsIgnoreCase("Manx")) {
                return "MAN-Manx";
            } else if (raza.equals("MBT") || raza.equalsIgnoreCase("Mekong Bobtail")) {
                return "MBT-Mekong Bobtail";
            } else if (raza.equals("MIL") || raza.equalsIgnoreCase("Minuet Longhair")) {
                return "MIL-Minuet Longhair";
            } else if (raza.equals("MIS") || raza.equalsIgnoreCase("Minuet Shorthair")) {
                return "MIS-Minuet Shorthair";
            } else if (raza.equals("MNL") || raza.equalsIgnoreCase("Munchkin Longhair")) {
                return "MNL-Munchkin Longhair";
            } else if (raza.equals("MNS") || raza.equalsIgnoreCase("Munchkin Shorthair")) {
                return "MNS-Munchkin Shorthair";
            } else if (raza.equals("NEB") || raza.equalsIgnoreCase("Nebelung")) {
                return "NEB-Nebelung";
            } else if (raza.equals("NFO") || raza.equalsIgnoreCase("Norwegian Forest")) {
                return "NFO-Norwegian Forest";
            } else if (raza.equals("OCI") || raza.equalsIgnoreCase("Ocicat")) {
                return "OCI-Ocicat";
            } else if (raza.equals("OSL") || raza.equalsIgnoreCase("Oriental Semilonghair")) {
                return "OSL-Oriental Semilonghair";
            } else if (raza.equals("OSH") || raza.equalsIgnoreCase("Oriental Shorthair")) {
                return "OSH-Oriental Shorthair";
            } else if (raza.equals("TLH") || raza.equalsIgnoreCase("Original Longhair")) {
                return "TLH-Original Longhair";
            } else if (raza.equals("PBD") || raza.equalsIgnoreCase("Peterbald")) {
                return "PBD-Peterbald";
            } else if (raza.equals("RGM") || raza.equalsIgnoreCase("Ragamuffin")) {
                return "RGM-Ragamuffin";
            } else if (raza.equals("RAG") || raza.equalsIgnoreCase("Ragdoll")) {
                return "RAG-Ragdoll";
            } else if (raza.equals("RUS") || raza.equalsIgnoreCase("Russian Blue")) {
                return "RUS-Russian Blue";
            } else if (raza.equals("SBI") || raza.equalsIgnoreCase("Sacred Birman")) {
                return "SBI-Sacred Birman";
            } else if (raza.equals("SFS") || raza.equalsIgnoreCase("Scottish Fold")) {
                return "SFS-Scottish Fold";
            } else if (raza.equals("SRL") || raza.equalsIgnoreCase("Selkirk Rex Longhair")) {
                return "SRL-Selkirk Rex Longhair";
            } else if (raza.equals("SRS") || raza.equalsIgnoreCase("Selkirk Rex Shorthair")) {
                return "SRS-Selkirk Rex Shorthair";
            } else if (raza.equals("SIA") || raza.equalsIgnoreCase("Siamese")) {
                return "SIA-Siamese";
            } else if (raza.equals("SIB") || raza.equalsIgnoreCase("Siberian cat / Neva Masquerade")) {
                return "SIB-Siberian cat / Neva Masquerade";
            } else if (raza.equals("SIN") || raza.equalsIgnoreCase("Singapura")) {
                return "SIN-Singapura";
            } else if (raza.equals("SNO") || raza.equalsIgnoreCase("Snowshoe")) {
                return "SNO-Snowshoe";
            } else if (raza.equals("SOM") || raza.equalsIgnoreCase("Somali")) {
                return "SOM-Somali";
            } else if (raza.equals("SPH") || raza.equalsIgnoreCase("Sphynx")) {
                return "SPH-Sphynx";
            } else if (raza.equals("THA") || raza.equalsIgnoreCase("Thai")) {
                return "THA-Thai";
            } else if (raza.equals("TIF") || raza.equalsIgnoreCase("Tiffanie")) {
                return "TIF-Tiffanie";
            } else if (raza.equals("TON") || raza.equalsIgnoreCase("Tonkinese")) {
                return "TON-Tonkinese";
            } else if (raza.equals("TOB") || raza.equalsIgnoreCase("Toy Bob")) {
                return "TOB-Toy Bob";
            } else if (raza.equals("TUA") || raza.equalsIgnoreCase("Turkish Angora")) {
                return "TUA-Turkish Angora";
            } else if (raza.equals("TUV") || raza.equalsIgnoreCase("Turkish Van")) {
                return "TUV-Turkish Van";
            } else if (raza.equals("URL") || raza.equalsIgnoreCase("Ural Rex Longhair")) {
                return "URL-Ural Rex Longhair";
            } else if (raza.equals("URS") || raza.equalsIgnoreCase("Ural Rex Shorthair")) {
                return "URS-Ural Rex Shorthair";
            } else if (raza.equals("YOR") || raza.equalsIgnoreCase("York")) {
                return "YOR-York";
            }
        }
        controlPrincipal.mostrarMensajeError("La raza digitada no existe o el campo se encuentra vacio");
        return controlPrincipal.pedirAtributoNoExistente("raza");
    }

    public String identificarColorCuerpoSegunEMS(String[] divisionColor) {
        for (String colorCuerpo : divisionColor) {
            if (colorCuerpo.equals("n") || colorCuerpo.equalsIgnoreCase("black") || colorCuerpo.equalsIgnoreCase("seal")) {
                return "n-black / seal";
            } else if (colorCuerpo.equals("f") || colorCuerpo.equalsIgnoreCase("black tortie")) {
                return "f-black tortie";
            } else if (colorCuerpo.equals("a") || colorCuerpo.equalsIgnoreCase("blue")) {
                return "a-blue";
            } else if (colorCuerpo.equals("g") || colorCuerpo.equalsIgnoreCase("blue tortie")) {
                return "g-blue tortie";
            } else if (colorCuerpo.equals("b") || colorCuerpo.equalsIgnoreCase("chocolate")) {
                return "b-chocolate";
            } else if (colorCuerpo.equals("h") || colorCuerpo.equalsIgnoreCase("chocolate tortie")) {
                return "h-chocolate tortie";
            } else if (colorCuerpo.equals("c") || colorCuerpo.equalsIgnoreCase("lilac")) {
                return "c-lilac";
            } else if (colorCuerpo.equals("o") || colorCuerpo.equalsIgnoreCase("cinnamon")) {
                return "o-cinnamon";
            } else if (colorCuerpo.equals("q") || colorCuerpo.equalsIgnoreCase("cinnamon tortie")) {
                return "q-cinnamon tortie";
            } else if (colorCuerpo.equals("d") || colorCuerpo.equalsIgnoreCase("red")) {
                return "d-red";
            } else if (colorCuerpo.equals("e") || colorCuerpo.equalsIgnoreCase("cream")) {
                return "e-cream";
            } else if (colorCuerpo.equals("p") || colorCuerpo.equalsIgnoreCase("fawn")) {
                return "p-fawn";
            } else if (colorCuerpo.equals("r") || colorCuerpo.equalsIgnoreCase("fawn tortie")) {
                return "r-fawn tortie";
            } else if (colorCuerpo.equals("j") || colorCuerpo.equalsIgnoreCase("lilac tortie")) {
                return "j-lilac tortie";
            } else if (colorCuerpo.equals("w") || colorCuerpo.equalsIgnoreCase("white")) {
                return "w-white";
            } else if (colorCuerpo.equals("x") || colorCuerpo.equalsIgnoreCase("unrecognized")) {
                return "x-unrecognized";
            }
        }
        controlPrincipal.mostrarMensajeError("La raza digitada no existe o el campo se encuentra vacio");
        return controlPrincipal.pedirAtributoNoExistente("colorCuerpo");
    }

    public String identificarColaSegunEMS(String[] divisionCola) {
        for (String cola : divisionCola) {
            if (cola.equals("51") || cola.equalsIgnoreCase("rumpy") || cola.equalsIgnoreCase("sin cola")) {
                return "51-rumpy – sin cola";
            } else if (cola.equals("52") || cola.equalsIgnoreCase("rumpy riser") || cola.equalsIgnoreCase("solo un poco de cola al final de la columna")) {
                return "52-rumpy riser – solo un poco de cola al final de la columna";
            } else if (cola.equals("53") || cola.equalsIgnoreCase("stumpy") || cola.equalsIgnoreCase("cola corta") || cola.equalsIgnoreCase("cola corta de aprox 3-4 cm")) {
                return "53-stumpy – cola corta de aprox 3-4 cm";
            } else if (cola.equals("54") || cola.equalsIgnoreCase("longie")) {
                return "54-longie";
            }
        }
        controlPrincipal.mostrarMensajeError("La cola digitada no existe o el campo se encuentra vacio");
        return controlPrincipal.pedirAtributoNoExistente("cola");
    }

    public String identificarPatronSegunEMS(String[] divisionPatron) {
        for (String patron : divisionPatron) {
            if (patron.equals("11") || patron.equalsIgnoreCase("shaded")) {
                return "11-shaded";
            } else if (patron.equals("12") || patron.equalsIgnoreCase("shell")) {
                return "12-shell";
            } else if (patron.equals("21") || patron.equalsIgnoreCase("tabby") || patron.equalsIgnoreCase("lynx") || patron.equalsIgnoreCase("tabby / lynx")) {
                return "21-tabby / lynx";
            } else if (patron.equals("22") || patron.equalsIgnoreCase("classic")) {
                return "22-classic";
            } else if (patron.equals("23") || patron.equalsIgnoreCase("mackerel")) {
                return "23-mackerel";
            } else if (patron.equals("24") || patron.equalsIgnoreCase("spotted")) {
                return "24-spotted";
            } else if (patron.equals("25") || patron.equalsIgnoreCase("ticked")) {
                return "25-ticked";
            } else if (patron.equals("26") || patron.equalsIgnoreCase("grizzled") || patron.equalsIgnoreCase("grizzled ticked")) {
                return "26-grizzled ticked";
            }
        }
        controlPrincipal.mostrarMensajeError("El patron digitado no existe o el campo se encuentra vacio");
        return controlPrincipal.pedirAtributoNoExistente("patron");
    }

    public String identificarColorOjosSegunEMS(String[] divisionColorOjos) {
        for (String colorOjos : divisionColorOjos) {
            if (colorOjos.equals("61") || colorOjos.equalsIgnoreCase("blue")) {
                return "61-blue";
            } else if (colorOjos.equals("62") || colorOjos.equalsIgnoreCase("orange")) {
                return "62-orange";
            } else if (colorOjos.equals("63") || colorOjos.equalsIgnoreCase("odd")) {
                return "63-odd";
            } else if (colorOjos.equals("64") || colorOjos.equalsIgnoreCase("green")) {
                return "64-green";
            } else if (colorOjos.equals("65") || colorOjos.equalsIgnoreCase("golden") || colorOjos.equalsIgnoreCase("golden (BUR)")) {
                return "65-golden (BUR)";
            } else if (colorOjos.equals("66") || colorOjos.equalsIgnoreCase("aquamarine") || colorOjos.equalsIgnoreCase("aquamarine (TON)")) {
                return "66-aquamarine (TON)";
            } else if (colorOjos.equals("67") || colorOjos.equalsIgnoreCase("dark blue") || colorOjos.equalsIgnoreCase("dark blue (SIA)")) {
                return "67-dark blue (SIA)";
            }
        }
        controlPrincipal.mostrarMensajeError("El color digitado no existe o el campo se encuentra vacio");
        return controlPrincipal.pedirAtributoNoExistente("colorOjos");
    }
}