package edu.progAvUD.parcialPrimerCorte.modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

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

    public GatoVO consultarGato(int id, GatoVO gato) throws SQLException {
        String consulta = "SELECT * FROM gatos where id='" + id + "'";
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

    public int consultarCantidadGatos() throws SQLException {
        String consulta = "SELECT COUNT() FROM gatos";
        connection = ConexionBD.getConnection();
        statement = connection.createStatement();
        resultSet = statement.executeQuery(consulta);
        int numero = 0;
        if (resultSet.next()) {
            numero = resultSet.getInt(1);
        }
        resultSet.close();
        statement.close();
        ConexionBD.desconectar();
        return numero;
    }

    public ArrayList<GatoVO> darListaGatos(GatoVO gato, ArrayList<GatoVO> gatos) throws SQLException {
        String consulta = "SELECT * FROM gatos";
        connection = ConexionBD.getConnection();
        statement = connection.createStatement();
        resultSet = statement.executeQuery(consulta);
        while (resultSet.next()) {
            gato.setId(resultSet.getInt("id"));
            gato.setNombre(resultSet.getString("nombre"));
            gato.setPeso(resultSet.getString("peso"));
            gato.setEdad(resultSet.getString("edad"));
            gato.setNombreRaza(resultSet.getString("nombreRaza"));
            gato.setCodigoEMS(resultSet.getString("codigoEMS"));
            gatos.add(gato);
        }
        statement.close();
        ConexionBD.desconectar();
        return gatos;
    }

    public void insertarGato(GatoVO gato) throws SQLException {
        String insercion = "INSERT INTO `gatos`(`nombre`, `peso`, `edad`, `nombreRaza`, `codigoEMS`) VALUES ('" + gato.getNombre() + "'," + gato.getPeso() + "," + gato.getEdad() + ",'" + gato.getNombreRaza() + "','" + gato.getCodigoEMS() + "')";
        connection = ConexionBD.getConnection();
        statement = connection.createStatement();
        statement.executeUpdate(insercion);
        statement.close();
        ConexionBD.desconectar();
    }

    public boolean eliminarGato(int id) throws SQLException {
        String consulta = "DELETE FROM gatos where codigo='" + id + "'";
        connection = ConexionBD.getConnection();
        statement = connection.createStatement();
        statement.executeUpdate(consulta);
        statement.close();
        ConexionBD.desconectar();
        return true;
    }

    public boolean modificarGato(int id, String atributoModificado, String valorModificado) throws SQLException {
        String consulta = "UPDATE gatos set " + atributoModificado + " = " + valorModificado + "WHERE id = '" + id + "'";
        connection = ConexionBD.getConnection();
        statement = connection.createStatement();
        statement.executeUpdate(consulta);
        statement.close();
        ConexionBD.desconectar();
        return true;
    }

    public ResultSet getResultSet() {
        return resultSet;
    }
}