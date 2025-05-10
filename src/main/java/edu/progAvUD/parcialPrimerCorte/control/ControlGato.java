package edu.progAvUD.parcialPrimerCorte.control;

import edu.progAvUD.parcialPrimerCorte.modelo.GatoDAO;
import edu.progAvUD.parcialPrimerCorte.modelo.GatoVO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Andres Felipe
 */
public class ControlGato {

    private ControlPrincipal controlPrincipal;
    private ArrayList<GatoVO> gatos;
    private GatoDAO gatoDao;
    private String[] divisionEMS;

    public ControlGato(ControlPrincipal controlPrincipal) {
        this.controlPrincipal = controlPrincipal;
        this.gatos = new ArrayList<>();
        this.gatoDao = new GatoDAO();
    }

    public void crearGato(int id, String nombre, String peso, String edad,String raza, String color, String patron, String colorOjos, String cola) {
        String[] divisionRaza = raza.split("-");
        String[] divisionColor = color.split("-");
        String[] divisionPatron = patron.split("-");
        String[] divisionColorOjos = colorOjos.split("-");
        String[] divisionCola = cola.split("-");
        String codigoEMS = divisionRaza[0]+"/"+divisionColor[0]+"/"+divisionPatron[0]+"/"+divisionColorOjos[0]+"/"+divisionCola[0] ;
        GatoVO gato = new GatoVO(id, nombre, peso, edad,codigoEMS, raza, color, patron, colorOjos, cola);
        gatos.add(gato);
        insertarGato(gato);
    }

    public String identificarRazaSegunEMS() {
        for (String raza : divisionEMS) {
            if (raza.equals("ABY")) {
                return "ABY-Abyssinian";
            }
            if (raza.equals("AMB")) {
                return "AMB-American Burmese";
            }
            if (raza.equals("ACL")) {
                return "ACL-American Curl Longhair";
            }
            if (raza.equals("ACS")) {
                return "ACS-American Curl Shorthair";
            }
            if (raza.equals("ASH")) {
                return "ASH-American Shorthair";
            }
            if (raza.equals("AWH")) {
                return "AWH-American Wirehair";
            }
            if (raza.equals("ANA")) {
                return "ANA-Anatoli";
            }
            if (raza.equals("APL")) {
                return "APL-Aphrodite’s Giant Longhair";
            }
            if (raza.equals("APS")) {
                return "APS-Aphrodite’s Giant Shorthair";
            }
            if (raza.equals("ARM")) {
                return "ARM-Arabian Mau";
            }
            if (raza.equals("ASI")) {
                return "ASI-Asian";
            }
            if (raza.equals("AUM")) {
                return "AUM-Australian Mist";
            }
            if (raza.equals("BAL")) {
                return "BAL-Balinese";
            }
            if (raza.equals("BEN")) {
                return "BEN-Bengal";
            }
            if (raza.equals("BOM")) {
                return "BOM-Bombay";
            }
            if (raza.equals("BRA")) {
                return "BRA-Brazilian Shorthair";
            }
            if (raza.equals("BLH")) {
                return "BLH-British Longhair";
            }
            if (raza.equals("BRI")) {
                return "BRI-British Shorthair";
            }
            if (raza.equals("BUR")) {
                return "BUR-Burmese";
            }
            if (raza.equals("BML")) {
                return "BML-Burmilla Longhair";
            }
            if (raza.equals("BMS")) {
                return "BMS-Burmilla Shorthair";
            }
            if (raza.equals("CAM")) {
                return "CAM-Cashmere";
            }
            if (raza.equals("KKH")) {
                return "KKH-Celtic Shorthair";
            }
            if (raza.equals("CEY")) {
                return "CEY-Ceylon";
            }
            if (raza.equals("CHA")) {
                return "CHA-Chartreux";
            }
            if (raza.equals("CHS")) {
                return "CHS-Chausie";
            }
            if (raza.equals("CRX")) {
                return "CRX-Cornish Rex";
            }
            if (raza.equals("CYM")) {
                return "CYM-Cymric";
            }
            if (raza.equals("DLH")) {
                return "DLH-Deutsch-Langhaar";
            }
            if (raza.equals("DRX")) {
                return "DRX-Devon Rex";
            }
            if (raza.equals("DSX")) {
                return "DSX-Don Sphynx";
            }
            if (raza.equals("MAU")) {
                return "MAU-Egyptian Mau";
            }
            if (raza.equals("EXO")) {
                return "EXO-Exotic Shorthair";
            }
            if (raza.equals("GRX")) {
                return "GRX-German Rex";
            }
            if (raza.equals("HAV")) {
                return "HAV-Havana";
            }
            if (raza.equals("SFL")) {
                return "SFL-Highland Fold";
            }
            if (raza.equals("PER")) {
                return "PER-Persian";
            }
            if (raza.equals("HHP")) {
                return "HHP-Household Pet";
            }
            if (raza.equals("JBL")) {
                return "JBL-Japanese Bobtail Longhair";
            }
            if (raza.equals("JBS")) {
                return "JBS-Japanese Bobtail Shorthair";
            }
            if (raza.equals("KAN")) {
                return "KAN-Kanaani";
            }
            if (raza.equals("KAL")) {
                return "KAL-Karelian Bobtail Longhair";
            }
            if (raza.equals("KAS")) {
                return "KAS-Karelian Bobtail Shorthair";
            }
            if (raza.equals("KAM")) {
                return "KAM-Khao Manee";
            }
            if (raza.equals("KOR")) {
                return "KOR-Korat";
            }
            if (raza.equals("KBL")) {
                return "KBL-Kurilian Bobtail Langhaar";
            }
            if (raza.equals("KBS")) {
                return "KBS-Kurilian Bobtail Shorthair";
            }
            if (raza.equals("LPL")) {
                return "LPL-LaPerm Longhair";
            }
            if (raza.equals("LPS")) {
                return "LPS-LaPerm Shorthair";
            }
            if (raza.equals("LYS")) {
                return "LYS-Lykoi";
            }
            if (raza.equals("MCO")) {
                return "MCO-Maine Coon";
            }
            if (raza.equals("MAN")) {
                return "MAN-Manx";
            }
            if (raza.equals("MBT")) {
                return "MBT-Mekong Bobtail";
            }
            if (raza.equals("MIL")) {
                return "MIL-Minuet Longhair";
            }
            if (raza.equals("MIS")) {
                return "MIS-Minuet Shorthair";
            }
            if (raza.equals("MNL")) {
                return "MNL-Munchkin Longhair";
            }
            if (raza.equals("MNS")) {
                return "MNS-Munchkin Shorthair";
            }
            if (raza.equals("NEB")) {
                return "NEB-Nebelung";
            }
            if (raza.equals("NFO")) {
                return "NFO-Norwegian Forest";
            }
            if (raza.equals("OCI")) {
                return "OCI-Ocicat";
            }
            if (raza.equals("OSL")) {
                return "OSL-Oriental Semilonghair";
            }
            if (raza.equals("OSH")) {
                return "OSH-Oriental Shorthair";
            }
            if (raza.equals("TLH")) {
                return "TLH-Original Longhair";
            }
            if (raza.equals("PBD")) {
                return "PBD-Peterbald";
            }
            if (raza.equals("RGM")) {
                return "RGM-Ragamuffin";
            }
            if (raza.equals("RAG")) {
                return "RAG-Ragdoll";
            }
            if (raza.equals("RUS")) {
                return "RUS-Russian Blue";
            }
            if (raza.equals("SBI")) {
                return "SBI-Sacred Birman";
            }
            if (raza.equals("SFS")) {
                return "SFS-Scottish Fold";
            }
            if (raza.equals("SRL")) {
                return "SRL-Selkirk Rex Longhair";
            }
            if (raza.equals("SRS")) {
                return "SRS-Selkirk Rex Shorthair";
            }
            if (raza.equals("SIA")) {
                return "SIA-Siamese";
            }
            if (raza.equals("SIB")) {
                return "SIB-Siberian cat / Neva Masquerade";
            }
            if (raza.equals("SIN")) {
                return "SIN-Singapura";
            }
            if (raza.equals("SNO")) {
                return "SNO-Snowshoe";
            }
            if (raza.equals("SOM")) {
                return "SOM-Somali";
            }
            if (raza.equals("SPH")) {
                return "SPH-Sphynx";
            }
            if (raza.equals("THA")) {
                return "THA-Thai";
            }
            if (raza.equals("TIF")) {
                return "TIF-Tiffanie";
            }
            if (raza.equals("TON")) {
                return "TON-Tonkinese";
            }
            if (raza.equals("TOB")) {
                return "TOB-Toy Bob";
            }
            if (raza.equals("TUA")) {
                return "TUA-Turkish Angora";
            }
            if (raza.equals("TUV")) {
                return "TUV-Turkish Van";
            }
            if (raza.equals("URL")) {
                return "URL-Ural Rex Longhair";
            }
            if (raza.equals("URS")) {
                return "URS-Ural Rex Shorthair";
            }
            if (raza.equals("YOR")) {
                return "YOR-York";
            }
        }
        return null;
    }

    public String identificarColorCuerpoSegunEMS() {
        for (String colorCuerpo : divisionEMS) {
            if (colorCuerpo.equals("n")) {
                return "n-black / seal";
            }
            if (colorCuerpo.equals("f")) {
                return "f-black tortie";
            }
            if (colorCuerpo.equals("a")) {
                return "a-blue";
            }
            if (colorCuerpo.equals("g")) {
                return "g-blue tortie";
            }
            if (colorCuerpo.equals("b")) {
                return "b-chocolate";
            }
            if (colorCuerpo.equals("h")) {
                return "h-chocolate tortie";
            }
            if (colorCuerpo.equals("c")) {
                return "c-lilac";
            }
            if (colorCuerpo.equals("o")) {
                return "o-cinnamon";
            }
            if (colorCuerpo.equals("q")) {
                return "q-cinnamon tortie";
            }
            if (colorCuerpo.equals("d")) {
                return "d-red";
            }
            if (colorCuerpo.equals("e")) {
                return "e-cream";
            }
            if (colorCuerpo.equals("p")) {
                return "p-fawn";
            }
            if (colorCuerpo.equals("r")) {
                return "r-fawn tortie";
            }
            if (colorCuerpo.equals("j")) {
                return "j-lilac tortie";
            }
            if (colorCuerpo.equals("w")) {
                return "w-white";
            }
            if (colorCuerpo.equals("x")) {
                return "x-unrecognized";
            }
        }
        return null;
    }

    public String identificarColaSegunEMS() {
        for (String cola : divisionEMS) {
            if (cola.equals("51")) {
                return "51-rumpy – sin cola";
            }
            if (cola.equals("52")) {
                return "52-rumpy riser – solo un poco de cola al final de la columna";
            }
            if (cola.equals("53")) {
                return "53-stumpy – cola corta de aprox 3-4 cm";
            }
            if (cola.equals("54")) {
                return "54-longie";
            }
        }
        return null;
    }

    public String identificarPatronSegunEMS() {
        for (String patron : divisionEMS) {
            if (patron.equals("11")) {
                return "11-shaded";
            }
            if (patron.equals("12")) {
                return "12-shell";
            }
            if (patron.equals("21")) {
                return "21-tabby / lynx";
            }
            if (patron.equals("22")) {
                return "22-classic";
            }
            if (patron.equals("23")) {
                return "23-mackerel";
            }
            if (patron.equals("24")) {
                return "24-spotted";
            }
            if (patron.equals("25")) {
                return "25-ticked";
            }
            if (patron.equals("26")) {
                return "26-grizzled ticked";
            }
        }
        return null;
    }

    public String identificarColorOjosSegunEMS() {
        for (String colorOjos : divisionEMS) {
            if (colorOjos.equals("61")) {
                return "61-blue";
            }
            if (colorOjos.equals("62")) {
                return "62-orange";
            }
            if (colorOjos.equals("63")) {
                return "63-odd";
            }
            if (colorOjos.equals("64")) {
                return "64-green";
            }
            if (colorOjos.equals("65")) {
                return "65-golden (BUR)";
            }
            if (colorOjos.equals("66")) {
                return "66-aquamarine (TON)";
            }
            if (colorOjos.equals("67")) {
                return "67-dark blue (SIA)";
            }
        }
        return null;
    }

    public void pedirListaGatos() {
        try {
            while (gatoDao.getResultSet().next()) {
                GatoVO gato = new GatoVO();
                gatoDao.darListaGatos(gato);
            }
        } catch (SQLException ex) {
            controlPrincipal.mostrarMensajeError("SQLExceptio_ex :PPPPPPPPPPPPPPPPPPPPPPPPPPPPpp");
        }
    }

    public void pedirConsultaGato(int id) {
        GatoVO gato = new GatoVO();
        try {
            gatoDao.consultarGato(id, gato);
        } catch (SQLException ex) {
            controlPrincipal.mostrarMensajeError("SQLExceptio_ex :PPPPPPPPPPPPPPPPPPPPPPPPPPPPpp");
        }
    }

    public void insertarGato(GatoVO gato) {
        try {
            gatoDao.insertarGato(gato);
        } catch (SQLException ex) {
            controlPrincipal.mostrarMensajeError("SQLExceptio_ex :PPPPPPPPPPPPPPPPPPPPPPPPPPPPpp");
        }
    }

    public void eliminarGato(int id) {
        try {
            gatoDao.eliminarGato(id);
        } catch (SQLException ex) {
            controlPrincipal.mostrarMensajeError("SQLExceptio_ex :PPPPPPPPPPPPPPPPPPPPPPPPPPPPpp");
        }
    }
}
