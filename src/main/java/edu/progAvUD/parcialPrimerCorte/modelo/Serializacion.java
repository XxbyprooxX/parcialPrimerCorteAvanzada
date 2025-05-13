package edu.progAvUD.parcialPrimerCorte.modelo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * Clase encargada de serializar objetos GatoVO y guardarlos en un archivo.
 * Utiliza flujos de salida para escribir objetos en un archivo binario.
 *
 * @author Andres Felipe
 */
public class Serializacion {

    // Flujo para escribir bytes en un archivo
    private FileOutputStream fileOutSerializacion;

    // Flujo para escribir objetos serializables en un archivo
    private ObjectOutputStream salidaSerializacion;

    /**
     * Constructor que inicializa los flujos para la serialización.
     *
     * @param archivo Archivo destino donde se guardará el objeto serializado.
     * @throws FileNotFoundException Si el archivo no puede crearse o abrirse.
     * @throws IOException Si ocurre un error al inicializar los flujos.
     */
    public Serializacion(File archivo) throws FileNotFoundException, IOException {
        fileOutSerializacion = new FileOutputStream(archivo);
        salidaSerializacion = new ObjectOutputStream(fileOutSerializacion);
    }

    /**
     * Método que escribe un objeto GatoVO en el archivo serializado.
     *
     * @param gato Objeto de tipo GatoVO que se desea guardar.
     * @throws IOException Si ocurre un error al escribir el objeto.
     */
    public void escribirArchivoSerializado(GatoVO gato) throws IOException {
        salidaSerializacion.writeObject(gato);
    }

    /**
     * Método que cierra el flujo de salida para la serialización.
     *
     * @throws IOException Si ocurre un error al cerrar el archivo.
     */
    public void cerrarArchivoSerializadoOut() throws IOException {
        salidaSerializacion.close();
    }

    // Métodos getter y setter para acceder a los flujos de salida
    /**
     * Devuelve el flujo de salida de archivo que se utiliza para escribir datos
     * serializados.
     *
     * @return FileOutputStream apuntando al archivo de destino para la
     * serialización.
     */
    public FileOutputStream getFileOutSerializacion() {
        return fileOutSerializacion;
    }

    /**
     * Establece o actualiza el flujo de salida de archivo para la
     * serialización.
     *
     * @param fileOutSerializacion flujo de tipo FileOutputStream donde se
     * escribirán los bytes resultantes de la serialización.
     */
    public void setFileOutSerializacion(FileOutputStream fileOutSerializacion) {
        this.fileOutSerializacion = fileOutSerializacion;
    }

    /**
     * Obtiene el flujo de objetos usado para encapsular y escribir objetos
     * serializados.
     *
     * @return ObjectOutputStream que envuelve el FileOutputStream subyacente,
     * permitiendo serializar instancias de objetos Java.
     */
    public ObjectOutputStream getSalidaSerializacion() {
        return salidaSerializacion;
    }

    /**
     * Configura el flujo de objetos para la serialización de instancias Java.
     *
     * @param salidaSerializacion ObjectOutputStream encargado de convertir y
     * escribir los objetos en el flujo de bytes.
     */
    public void setSalidaSerializacion(ObjectOutputStream salidaSerializacion) {
        this.salidaSerializacion = salidaSerializacion;
    }
}
