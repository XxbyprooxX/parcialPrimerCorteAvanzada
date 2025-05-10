package edu.progAvUD.parcialPrimerCorte.modelo;

import java.io.Serializable;

public class GatoVO implements Serializable{
    
    private transient int id;
    private transient String nombre;
    private transient String peso;
    private transient String edad;
    private String codigoEMS;
    private String nombreRaza;
    private transient String colorCuerpo;
    private transient String patron;
    private transient String colorOjos;
    private transient String cola;

    public GatoVO(String nombre, String peso, String edad, String codigoEMS, String nombreRaza, String colorCuerpo, String patron, String colorOjos, String cola) {
        this.nombre = nombre;
        this.peso = peso;
        this.edad = edad;
        this.codigoEMS = codigoEMS;
        this.nombreRaza = nombreRaza;
        this.colorCuerpo = colorCuerpo;
        this.patron = patron;
        this.colorOjos = colorOjos;
        this.cola = cola;
    }

    public GatoVO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getCodigoEMS() {
        return codigoEMS;
    }

    public void setCodigoEMS(String codigoEMS) {
        this.codigoEMS = codigoEMS;
    }

    public String getNombreRaza() {
        return nombreRaza;
    }

    public void setNombreRaza(String nombreRaza) {
        this.nombreRaza = nombreRaza;
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