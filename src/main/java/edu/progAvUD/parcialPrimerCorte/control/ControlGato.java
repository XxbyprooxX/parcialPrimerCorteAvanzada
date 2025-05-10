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

    public void crearGato(int id, String nombre, String peso, String edad, String codigoEMS) {
        divisionEMS = codigoEMS.split("/");
        GatoVO gato = new GatoVO(id, nombre, peso, edad, identificarRazaSegunEMS() + identificarColorCuerpoSegunEMS() + identificarPatronSegunEMS() + identificarColorOjosSegunEMS() + identificarColaSegunEMS(), identificarRazaSegunEMS(), identificarColorCuerpoSegunEMS(), identificarPatronSegunEMS(), identificarColorOjosSegunEMS(), identificarColaSegunEMS());
        gatos.add(gato);
        insertarGato(gato);
    }

    public String identificarRazaSegunEMS() {
        for (String raza : divisionEMS) {
            if (raza.equals("ABY")) {
                return "ABY";
            } else if (raza.equals("AMB")) {
                return "AMB";
            } else if (raza.equals("ACL")) {
                return "ACL";
            } else if (raza.equals("ACS")) {
                return "ACS";
            } else if (raza.equals("ASH")) {
                return "ASH";
            } else if (raza.equals("AWH")) {
                return "AWH";
            } else if (raza.equals("ANA")) {
                return "ANA";
            } else if (raza.equals("APL")) {
                return "APL";
            } else if (raza.equals("APS")) {
                return "APS";
            } else if (raza.equals("ARM")) {
                return "ARM";
            } else if (raza.equals("ASI")) {
                return "ASI";
            } else if (raza.equals("AUM")) {
                return "AUM";
            } else if (raza.equals("BAL")) {
                return "BAL";
            } else if (raza.equals("BEN")) {
                return "BEN";
            } else if (raza.equals("BOM")) {
                return "BOM";
            } else if (raza.equals("BRA")) {
                return "BRA";
            } else if (raza.equals("BLH")) {
                return "BLH";
            } else if (raza.equals("BRI")) {
                return "BRI";
            } else if (raza.equals("BUR")) {
                return "BUR";
            } else if (raza.equals("BML")) {
                return "BML";
            } else if (raza.equals("BMS")) {
                return "BMS";
            } else if (raza.equals("CAM")) {
                return "CAM";
            } else if (raza.equals("KKH")) {
                return "KKH";
            } else if (raza.equals("CEY")) {
                return "CEY";
            } else if (raza.equals("CHA")) {
                return "CHA";
            } else if (raza.equals("CHS")) {
                return "CHS";
            } else if (raza.equals("CRX")) {
                return "CRX";
            } else if (raza.equals("CYM")) {
                return "CYM";
            } else if (raza.equals("DLH")) {
                return "DLH";
            } else if (raza.equals("DRX")) {
                return "DRX";
            } else if (raza.equals("DSX")) {
                return "DSX";
            } else if (raza.equals("MAU")) {
                return "MAU";
            } else if (raza.equals("EXO")) {
                return "EXO";
            } else if (raza.equals("GRX")) {
                return "GRX";
            } else if (raza.equals("HAV")) {
                return "HAV";
            } else if (raza.equals("SFL")) {
                return "SFL";
            } else if (raza.equals("PER")) {
                return "PER";
            } else if (raza.equals("HHP")) {
                return "HHP";
            } else if (raza.equals("JBL")) {
                return "JBL";
            } else if (raza.equals("JBS")) {
                return "JBS";
            } else if (raza.equals("KAN")) {
                return "KAN";
            } else if (raza.equals("KAL")) {
                return "KAL";
            } else if (raza.equals("KAS")) {
                return "KAS";
            } else if (raza.equals("KAM")) {
                return "KAM";
            } else if (raza.equals("KOR")) {
                return "KOR";
            } else if (raza.equals("KBL")) {
                return "KBL";
            } else if (raza.equals("KBS")) {
                return "KBS";
            } else if (raza.equals("LPL")) {
                return "LPL";
            } else if (raza.equals("LPS")) {
                return "LPS";
            } else if (raza.equals("LYS")) {
                return "LYS";
            } else if (raza.equals("MCO")) {
                return "MCO";
            } else if (raza.equals("MAN")) {
                return "MAN";
            } else if (raza.equals("MBT")) {
                return "MBT";
            } else if (raza.equals("MIL")) {
                return "MIL";
            } else if (raza.equals("MIS")) {
                return "MIS";
            } else if (raza.equals("MNL")) {
                return "MNL";
            } else if (raza.equals("MNS")) {
                return "MNS";
            } else if (raza.equals("NEB")) {
                return "NEB";
            } else if (raza.equals("NFO")) {
                return "NFO";
            } else if (raza.equals("OCI")) {
                return "OCI";
            } else if (raza.equals("OSL")) {
                return "OSL";
            } else if (raza.equals("OSH")) {
                return "OSH";
            } else if (raza.equals("TLH")) {
                return "TLH";
            } else if (raza.equals("PBD")) {
                return "PBD";
            } else if (raza.equals("RGM")) {
                return "RGM";
            } else if (raza.equals("RAG")) {
                return "RAG";
            } else if (raza.equals("RUS")) {
                return "RUS";
            } else if (raza.equals("SBI")) {
                return "SBI";
            } else if (raza.equals("SFS")) {
                return "SFS";
            } else if (raza.equals("SRL")) {
                return "SRL";
            } else if (raza.equals("SRS")) {
                return "SRS";
            } else if (raza.equals("SIA")) {
                return "SIA";
            } else if (raza.equals("SIB")) {
                return "SIB";
            } else if (raza.equals("SIN")) {
                return "SIN";
            } else if (raza.equals("SNO")) {
                return "SNO";
            } else if (raza.equals("SOM")) {
                return "SOM";
            } else if (raza.equals("SPH")) {
                return "SPH";
            } else if (raza.equals("THA")) {
                return "THA";
            } else if (raza.equals("TIF")) {
                return "TIF";
            } else if (raza.equals("TON")) {
                return "TON";
            } else if (raza.equals("TOB")) {
                return "TOB";
            } else if (raza.equals("TUA")) {
                return "TUA";
            } else if (raza.equals("TUV")) {
                return "TUV";
            } else if (raza.equals("URL")) {
                return "URL";
            } else if (raza.equals("URS")) {
                return "URS";
            } else if (raza.equals("YOR")) {
                return "YOR";
            }
        }
        return null;
    }

    public String identificarColorCuerpoSegunEMS() {
        for (String colorCuerpo : divisionEMS) {
            if (colorCuerpo.equals("n")) {
                return "n";
            } else if (colorCuerpo.equals("f")) {
                return "f";
            } else if (colorCuerpo.equals("a")) {
                return "a";
            } else if (colorCuerpo.equals("g")) {
                return "g";
            } else if (colorCuerpo.equals("b")) {
                return "b";
            } else if (colorCuerpo.equals("h")) {
                return "h";
            } else if (colorCuerpo.equals("c")) {
                return "c";
            } else if (colorCuerpo.equals("o")) {
                return "o";
            } else if (colorCuerpo.equals("q")) {
                return "q";
            } else if (colorCuerpo.equals("d")) {
                return "d";
            } else if (colorCuerpo.equals("e")) {
                return "e";
            } else if (colorCuerpo.equals("p")) {
                return "p";
            } else if (colorCuerpo.equals("r")) {
                return "r";
            } else if (colorCuerpo.equals("j")) {
                return "j";
            } else if (colorCuerpo.equals("w")) {
                return "w";
            } else if (colorCuerpo.equals("x")) {
                return "x";
            }
        }
        return null;
    }

    public String identificarColaSegunEMS() {
        for (String cola : divisionEMS) {
            if (cola.equals("51")) {
                return "51";
            } else if (cola.equals("52")) {
                return "52";
            } else if (cola.equals("53")) {
                return "53";
            } else if (cola.equals("54")) {
                return "54";
            }
        }
        return null;
    }

    public String identificarPatronSegunEMS() {
        for (String patron : divisionEMS) {
            if (patron.equals("11")) {
                return "11";
            } else if (patron.equals("12")) {
                return "12";
            } else if (patron.equals("21")) {
                return "21";
            } else if (patron.equals("22")) {
                return "22";
            } else if (patron.equals("23")) {
                return "23";
            } else if (patron.equals("24")) {
                return "24";
            } else if (patron.equals("25")) {
                return "25";
            } else if (patron.equals("26")) {
                return "26";
            }
        }
        return null;
    }

    public String identificarColorOjosSegunEMS() {
        for (String colorOjos : divisionEMS) {
            if (colorOjos.equals("61")) {
                return "61";
            } else if (colorOjos.equals("62")) {
                return "62";
            } else if (colorOjos.equals("63")) {
                return "63";
            } else if (colorOjos.equals("64")) {
                return "64";
            } else if (colorOjos.equals("65")) {
                return "65";
            } else if (colorOjos.equals("66")) {
                return "66";
            } else if (colorOjos.equals("67")) {
                return "67";
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

        }
    }

    public void pedirConsultaGato(int id) {
        GatoVO gato = new GatoVO();
        try {
            gatoDao.consultarGato(id, gato);
        } catch (SQLException ex) {
            
        }
    }
    
    public void insertarGato(GatoVO gato){
        try {
            gatoDao.insertarGato(gato);
        } catch (SQLException ex) {
            
        }
    }
    
    public void eliminarGato(int id){
        try {
            gatoDao.eliminarGato(id);
        } catch (SQLException ex) {
            
        }
    }
}