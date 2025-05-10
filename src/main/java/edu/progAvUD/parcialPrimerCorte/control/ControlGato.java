package edu.progAvUD.parcialPrimerCorte.control;

import edu.progAvUD.parcialPrimerCorte.modelo.GatoVO;
import java.util.ArrayList;
import java.util.Comparator;

/**
 *
 * @author Andres Felipe
 */
public class ControlGato {
    
    private ControlPrincipal controlPrincipal;
    private ArrayList<GatoVO> gatos;

    public ControlGato(ControlPrincipal controlPrincipal) {
        this.controlPrincipal = controlPrincipal;
        this.gatos = new ArrayList<>();
    }
    
    public void crearGato(int id, String nombre, String peso, String edad, String codigoEMS, String colorCuerpo, String patron, String colorOjos, String cola){
        String nombreRaza = identificarRaza(codigoEMS);
        GatoVO gato = new GatoVO(id, nombre, peso, edad, codigoEMS, nombreRaza, colorCuerpo, patron, colorOjos, cola);
        gatos.add(gato);
        gatos.sort(Comparator.comparingInt(GatoVO::getId));
    }
    
    public String identificarRaza(String codigoEMS){
        
        return null;
    }
}
