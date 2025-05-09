package edu.progAvUD.parcialPrimerCorte.modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
        this.resultSet = null;
    }

    public GatoVO consultarGato(String temaConsulta, GatoVO gato) throws SQLException {
        String consulta = "SELECT * FROM datosGatos where codigo='" + temaConsulta + "'";
        connection = (Connection) ConexionBD.getConnection();
        statement = connection.createStatement();
        resultSet = statement.executeQuery(consulta);
        gato.setId(resultSet.getInt("id"));
        gato.setNombre(resultSet.getString("nombre"));
        gato.setPeso(resultSet.getString("peso"));
        gato.setEdad(resultSet.getString("edad"));
        gato.setNombreRaza(resultSet.getString("nombreRaza"));
        gato.setCodigoEMS(resultSet.getString("codigoEMS"));
        statement.close();
        ConexionBD.desconectar();
        return gato;
    }

    public void insertarGato(GatoVO gato) throws SQLException{
        connection = ConexionBD.getConnection();
        statement = connection.createStatement();
        String insercion = "INSERT INTO `gatos`(`id`, `nombre`, `peso`, `edad`, `nombreRaza`, `codigoEMS`) VALUES ("+gato.getId()+",'"+gato.getNombre()+"',"+gato.getPeso()+","+gato.getEdad()+",'"+gato.getNombreRaza()+"','"+gato.getCodigoEMS()+"');";
        statement.executeUpdate(insercion);
        statement.close();
        ConexionBD.desconectar();
    }
    
}
