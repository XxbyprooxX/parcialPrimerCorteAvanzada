package edu.progAvUD.parcialPrimerCorte.modelo;

import java.io.Serializable;

/**
 * Clase que representa un objeto de tipo Gato. Implementa Serializable para
 * permitir su serialización.
 */
public class GatoVO implements Serializable {

    // Atributos que no serán serializados (por ejemplo, si se guarda en archivo o se transmite por red)
    private transient int id;
    private transient String nombre;
    private transient String peso;
    private transient String edad;

    // Atributos que sí serán serializados
    private String codigoEMS;
    private String nombreRaza;

    private transient String colorCuerpo;
    private transient String cantidadBlanco;
    private transient String patron;
    private transient String puntosColor;
    private transient String cola;
    private transient String colorOjos;

    /**
     * Constructor con todos los atributos (menos el ID). Se utiliza al crear un
     * nuevo gato con datos específicos.
     */
    public GatoVO(int id, String nombre, String peso, String edad, String codigoEMS, String nombreRaza, String colorCuerpo, String cantidadBlanco, String patron, String puntosColor, String cola, String colorOjos) {
        this.id = id;
        this.nombre = nombre;
        this.peso = peso;
        this.edad = edad;
        this.codigoEMS = codigoEMS;
        this.nombreRaza = nombreRaza;
        this.colorCuerpo = colorCuerpo;
        this.cantidadBlanco = cantidadBlanco;
        this.patron = patron;
        this.puntosColor = puntosColor;
        this.cola = cola;
        this.colorOjos = colorOjos;
    }

    /**
     * Constructor vacío. Útil cuando se quiere construir el objeto paso a paso
     * con setters.
     */
    public GatoVO() {
    }

    // Métodos getter y setter para acceder y modificar los atributos
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

    public String getCantidadBlanco() {
        return cantidadBlanco;
    }

    public void setCantidadBlanco(String cantidadBlanco) {
        this.cantidadBlanco = cantidadBlanco;
    }

    public String getPuntosColor() {
        return puntosColor;
    }

    public void setPuntosColor(String puntosColor) {
        this.puntosColor = puntosColor;
    }

}
