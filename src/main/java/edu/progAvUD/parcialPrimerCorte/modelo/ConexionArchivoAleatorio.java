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
    
    private String informacionGato;
    private RandomAccessFile archivo;

    public ConexionArchivoAleatorio(File rutaGuardadoArchivo) throws FileNotFoundException{
        this.archivo = new RandomAccessFile(rutaGuardadoArchivo, "rw");
    }
    
    public void escribirArchivoAleatorio() throws IOException {
        archivo.writeUTF(informacionGato);
    }

    public String getInformacionGato() {
        return informacionGato;
    }

    public void setInformacionGato(String informacionGato) {
        this.informacionGato = informacionGato;
    }

    public RandomAccessFile getArchivo() {
        return archivo;
    }

    public void setArchivo(RandomAccessFile archivo) {
        this.archivo = archivo;
    }
    
}