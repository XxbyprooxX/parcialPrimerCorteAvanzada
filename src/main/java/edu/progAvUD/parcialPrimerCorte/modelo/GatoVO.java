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
     * Constructor con todos los atributos (menos el ID).Se utiliza al crear un
     * nuevo gato con datos específicos.
     *
     * @param id
     * @param nombre
     * @param peso
     * @param colorCuerpo
     * @param cantidadBlanco
     * @param codigoEMS
     * @param nombreRaza
     * @param edad
     * @param puntosColor
     * @param patron
     * @param cola
     * @param colorOjos
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
    /**
     * Obtiene el identificador único del gato.
     *
     * @return entero que representa el ID del gato.
     */
    public int getId() {
        return id;
    }

    /**
     * Asigna un identificador único al gato.
     *
     * @param id entero que se establecerá como ID del gato.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Recupera el nombre del gato.
     *
     * @return cadena con el nombre del gato.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del gato.
     *
     * @param nombre cadena que contiene el nombre a asignar al gato.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Devuelve el peso del gato.
     *
     * @return cadena representando el peso (por ejemplo, "4.5kg").
     */
    public String getPeso() {
        return peso;
    }

    /**
     * Define el peso del gato.
     *
     * @param peso cadena con el peso a asignar (por ejemplo, "4.5kg").
     */
    public void setPeso(String peso) {
        this.peso = peso;
    }

    /**
     * Obtiene la edad del gato.
     *
     * @return cadena con la edad del gato (por ejemplo, "2 años").
     */
    public String getEdad() {
        return edad;
    }

    /**
     * Asigna la edad al gato.
     *
     * @param edad cadena que representa la edad a establecer (por ejemplo, "2
     * años").
     */
    public void setEdad(String edad) {
        this.edad = edad;
    }

    /**
     * Recupera el código EMS asociado a este gato.
     *
     * @return cadena con el código EMS (por ejemplo, "BRI").
     */
    public String getCodigoEMS() {
        return codigoEMS;
    }

    /**
     * Establece el código EMS para identificar características según el
     * estándar.
     *
     * @param codigoEMS cadena con el código EMS (por ejemplo, "BRI").
     */
    public void setCodigoEMS(String codigoEMS) {
        this.codigoEMS = codigoEMS;
    }

    /**
     * Obtiene el nombre de la raza del gato.
     *
     * @return cadena con el nombre de la raza (por ejemplo, "British
     * Shorthair").
     */
    public String getNombreRaza() {
        return nombreRaza;
    }

    /**
     * Asigna el nombre de la raza al gato.
     *
     * @param nombreRaza cadena que contiene la raza a establecer.
     */
    public void setNombreRaza(String nombreRaza) {
        this.nombreRaza = nombreRaza;
    }

    /**
     * Recupera el color del cuerpo según nomenclatura EMS.
     *
     * @return cadena con el color del cuerpo (por ejemplo, "a-blue").
     */
    public String getColorCuerpo() {
        return colorCuerpo;
    }

    /**
     * Establece el color del cuerpo del gato.
     *
     * @param colorCuerpo cadena con la descripción o código EMS del color.
     */
    public void setColorCuerpo(String colorCuerpo) {
        this.colorCuerpo = colorCuerpo;
    }

    /**
     * Obtiene el patrón del pelaje según EMS.
     *
     * @return cadena con el patrón (por ejemplo, "21-tabby / lynx").
     */
    public String getPatron() {
        return patron;
    }

    /**
     * Define el patrón del pelaje del gato.
     *
     * @param patron cadena que contiene el código o nombre del patrón.
     */
    public void setPatron(String patron) {
        this.patron = patron;
    }

    /**
     * Recupera el color de ojos del gato según EMS.
     *
     * @return cadena con el color de ojos (por ejemplo, "61-blue").
     */
    public String getColorOjos() {
        return colorOjos;
    }

    /**
     * Asigna el color de ojos al gato.
     *
     * @param colorOjos cadena con la descripción o código EMS del color de
     * ojos.
     */
    public void setColorOjos(String colorOjos) {
        this.colorOjos = colorOjos;
    }

    /**
     * Obtiene el tipo de cola según EMS.
     *
     * @return cadena con el tipo de cola (por ejemplo, "51-rumpy").
     */
    public String getCola() {
        return cola;
    }

    /**
     * Establece el tipo de cola del gato.
     *
     * @param cola cadena que contiene el código o descripción del tipo de cola.
     */
    public void setCola(String cola) {
        this.cola = cola;
    }

    /**
     * Recupera la cantidad de blanco presente en el pelaje.
     *
     * @return cadena indicando la proporción de blanco (por ejemplo, "50%
     * white").
     */
    public String getCantidadBlanco() {
        return cantidadBlanco;
    }

    /**
     * Define la cantidad de blanco en el pelaje.
     *
     * @param cantidadBlanco cadena que describe la proporción de blanco.
     */
    public void setCantidadBlanco(String cantidadBlanco) {
        this.cantidadBlanco = cantidadBlanco;
    }

    /**
     * Obtiene los puntos de color específicos en el pelaje.
     *
     * @return cadena con la descripción de puntos de color (por ejemplo, "point
     * seal").
     */
    public String getPuntosColor() {
        return puntosColor;
    }

    /**
     * Asigna la descripción de puntos de color en el pelaje.
     *
     * @param puntosColor cadena que detalla los puntos de color.
     */
    public void setPuntosColor(String puntosColor) {
        this.puntosColor = puntosColor;
    }
}