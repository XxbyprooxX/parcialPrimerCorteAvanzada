package edu.progAvUD.parcialPrimerCorte.modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Andres Felipe
 */
public class ConexionBD {

    private static Connection connection;
    private static String URLBD;
    private static String usuario;
    private static String contrasena;

    public static Connection getConnection() throws SQLException {
        connection = DriverManager.getConnection(URLBD, usuario, contrasena);
        return connection; 
    }
    
    public static void desconectar() {
        connection = null;
    }

    public static void setURLBD(String URLBD) {
        ConexionBD.URLBD = URLBD;
    }

    public static void setUsuario(String usuario) {
        ConexionBD.usuario = usuario;
    }

    public static void setContrasena(String contrasena) {
        ConexionBD.contrasena = contrasena;
    }

}