/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.progAvUD.parcialPrimerCorte.modelo;

import com.mysql.cj.xdevapi.Statement;
import java.sql.Connection;
import java.sql.ResultSet;

/**
 *
 * @author Andres Felipe
 */
public class GatoDAO {
    
    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;

    public GatoDAO() {
        this.connection = null;
        this.statement = null;
        this.resultSet =null;
    }
    
    public void consultarGato(){
    
}
    
    
}
