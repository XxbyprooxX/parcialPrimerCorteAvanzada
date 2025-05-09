
package edu.progAvUD.parcialPrimerCorte.modelo;


public class GatoVO {
    
    private String nombreRaza;
    private String codigoEMS;
    private String colorCuerpo;
    private String patron;
    private String colorOjos;
    private String cola;

    public GatoVO(String nombreRaza, String codigoEMS, String colorCuerpo, String patron, String colorOjos, String cola) {
        this.nombreRaza = nombreRaza;
        this.codigoEMS = codigoEMS;
        this.colorCuerpo = colorCuerpo;
        this.patron = patron;
        this.colorOjos = colorOjos;
        this.cola = cola;
    }

    public String getNombreRaza() {
        return nombreRaza;
    }

    public void setNombreRaza(String nombreRaza) {
        this.nombreRaza = nombreRaza;
    }

    public String getCodigoEMS() {
        return codigoEMS;
    }

    public void setCodigoEMS(String codigoEMS) {
        this.codigoEMS = codigoEMS;
    }

    public String getColorCuerpo() {
        return colorCuerpo;
    }

    public void setColorCuerpo(String colorCuerpo) {
        this.colorCuerpo = colorCuerpo;
    }

    public String getPatron() {
        return patron;
    }

    public void setPatron(String patron) {
        this.patron = patron;
    }

    public String getColorOjos() {
        return colorOjos;
    }

    public void setColorOjos(String colorOjos) {
        this.colorOjos = colorOjos;
    }

    public String getCola() {
        return cola;
    }

    public void setCola(String cola) {
        this.cola = cola;
    }
    
    
    
}
