/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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

}
