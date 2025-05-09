package edu.progAvUD.parcialPrimerCorte.modelo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 *
 * @author Andres Felipe
 */
public class Serializacion {

    private FileOutputStream fileOutSerializacion;
    private ObjectOutputStream salidaSerializacion;

    public Serializacion(File archivo) throws FileNotFoundException, IOException {
        fileOutSerializacion = new FileOutputStream(archivo);
        salidaSerializacion = new ObjectOutputStream(fileOutSerializacion);
    }

    public void escribirArchivoSerializado(GatoVO gato) throws IOException {
        salidaSerializacion.writeObject(gato);
    }
    
    public void cerrarArchivoSerializadoOut() throws IOException {
        salidaSerializacion.close();
    }

    public FileOutputStream getFileOutSerializacion() {
        return fileOutSerializacion;
    }

    public void setFileOutSerializacion(FileOutputStream fileOutSerializacion) {
        this.fileOutSerializacion = fileOutSerializacion;
    }

    public ObjectOutputStream getSalidaSerializacion() {
        return salidaSerializacion;
    }

    public void setSalidaSerializacion(ObjectOutputStream salidaSerializacion) {
        this.salidaSerializacion = salidaSerializacion;
    }

}