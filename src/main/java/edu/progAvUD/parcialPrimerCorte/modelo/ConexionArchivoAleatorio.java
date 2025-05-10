package edu.progAvUD.parcialPrimerCorte.modelo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 *
 * @author Andres Felipe
 */
public class ConexionArchivoAleatorio {
    
    private RandomAccessFile archivo;

    public ConexionArchivoAleatorio(File rutaGuardadoArchivo) throws FileNotFoundException{
        this.archivo = new RandomAccessFile(rutaGuardadoArchivo, "rw");
    }
    
    public void escribirArchivoAleatorio(int id, String informacionGato) throws IOException {
        archivo.writeInt(id);
        archivo.writeUTF(informacionGato);
    }

    public RandomAccessFile getArchivo() {
        return archivo;
    }

    public void setArchivo(RandomAccessFile archivo) {
        this.archivo = archivo;
    }
    
}