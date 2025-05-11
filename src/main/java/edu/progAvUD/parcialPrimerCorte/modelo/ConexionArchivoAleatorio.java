package edu.progAvUD.parcialPrimerCorte.modelo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * Clase que permite gestionar la conexión a un archivo de acceso aleatorio.
 * Esta clase se encarga de abrir, escribir y obtener el archivo.
 * 
 * @author Andres Felipe
 */
public class ConexionArchivoAleatorio {

    // Atributo que representa el archivo de acceso aleatorio
    private RandomAccessFile archivo;

    /**
     * Constructor que inicializa la conexión al archivo dado.
     * 
     * @param rutaGuardadoArchivo Ruta del archivo que se usará para lectura/escritura.
     * @throws FileNotFoundException Si no se encuentra el archivo en la ruta especificada.
     */
    public ConexionArchivoAleatorio(File rutaGuardadoArchivo) throws FileNotFoundException {
        // Se abre el archivo con permisos de lectura y escritura ("rw")
        this.archivo = new RandomAccessFile(rutaGuardadoArchivo, "rw");
    }

    /**
     * Método que escribe en el archivo un ID seguido de una cadena con la información del gato.
     * 
     * @param id Identificador entero que se almacenará primero.
     * @param informacionGato Cadena de texto que contiene la información del gato.
     * @throws IOException Si ocurre un error durante la escritura.
     */
    public void escribirArchivoAleatorio(int id, String informacionGato) throws IOException {
        archivo.writeInt(id);             
        archivo.writeUTF(informacionGato); 
    }

    /**
     * Retorna el archivo de acceso aleatorio actual.
     * 
     * @return Objeto RandomAccessFile.
     */
    public RandomAccessFile getArchivo() {
        return archivo;
    }

    /**
     * Permite establecer un nuevo archivo de acceso aleatorio.
     * 
     * @param archivo Objeto RandomAccessFile a asignar.
     */
    public void setArchivo(RandomAccessFile archivo) {
        this.archivo = archivo;
    }
}