package edu.progAvUD.parcialPrimerCorte.modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Clase que actúa como Data Access Object (DAO) para la entidad Gato. Se
 * encarga de manejar las operaciones CRUD sobre la tabla `gatos` de la base de
 * datos.
 *
 * Autor: Andres Felipe
 */
public class GatoDAO {

    private Connection connection;  // Conexión a la base de datos
    private Statement statement;    // Objeto para ejecutar sentencias SQL
    private ResultSet resultSet;    // Resultado de las consultas SQL

    /**
     * Constructor por defecto, inicializa las variables como null.
     */
    public GatoDAO() {
        this.connection = null;
        this.statement = null;
        this.resultSet = null;
    }

    /**
     * Consulta un gato por ID (entero) y carga sus datos en el objeto GatoVO
     * dado.
     *
     * @param id Identificador del gato.
     * @param gato Objeto GatoVO que será llenado con los datos encontrados.
     * @return GatoVO con los datos del gato si se encuentra.
     * @throws SQLException Si ocurre un error al ejecutar la consulta.
     */
    public GatoVO consultarGatoPorId(int id, GatoVO gato) throws SQLException {
        String consulta = "SELECT * FROM gatos where id='" + id + "'";
        connection = ConexionBD.getConnection();
        statement = connection.createStatement();
        resultSet = statement.executeQuery(consulta);
        if (resultSet.next()) {
            gato.setId(resultSet.getInt("id"));
            gato.setNombre(resultSet.getString("nombre"));
            gato.setPeso(resultSet.getString("peso"));
            gato.setEdad(resultSet.getString("edad"));
            gato.setNombreRaza(resultSet.getString("nombreRaza"));
            gato.setCodigoEMS(resultSet.getString("codigoEMS"));
        }
        statement.close();
        ConexionBD.desconectar();
        return gato;
    }

    /**
     * Consulta un gato por ID representado como String. (Útil si el ID proviene
     * de una entrada textual).
     *
     * @param datoBuscado ID del gato en formato String.
     * @param gato Objeto a llenar con los datos del gato encontrado.
     * @return GatoVO con los datos consultados.
     * @throws SQLException Si ocurre un error al ejecutar la consulta.
     */
    public ArrayList<GatoVO> consultarGatos(String factorBusqueda, String datoBuscado) throws SQLException {
        String consulta = "SELECT * FROM gatos where " + factorBusqueda + "='" + datoBuscado + "'";
        connection = ConexionBD.getConnection();
        statement = connection.createStatement();
        resultSet = statement.executeQuery(consulta);
        ArrayList<GatoVO> gatos = new ArrayList<>();
        while (resultSet.next()) {
            GatoVO gato = new GatoVO();
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

    /**
     * Consulta la cantidad total de gatos en la base de datos.
     *
     * @return Número de gatos registrados.
     * @throws SQLException Si ocurre un error al ejecutar la consulta.
     */
    public int consultarCantidadGatos() throws SQLException {
        String consulta = "SELECT COUNT(*) FROM gatos";
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

    /**
     * Obtiene la lista completa de gatos registrados en la base de datos.
     *
     * @return Lista de objetos GatoVO.
     * @throws SQLException Si ocurre un error al ejecutar la consulta.
     */
    public ArrayList<GatoVO> darListaGatos() throws SQLException {
        String consulta = "SELECT * FROM gatos";
        connection = ConexionBD.getConnection();
        statement = connection.createStatement();
        resultSet = statement.executeQuery(consulta);
        ArrayList<GatoVO> gatos = new ArrayList<>();
        while (resultSet.next()) {
            GatoVO gato = new GatoVO();
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

    /**
     * Inserta un nuevo gato en la base de datos.
     *
     * @param gato Objeto GatoVO con la información del gato a registrar.
     * @throws SQLException Si ocurre un error al insertar.
     */
    public void insertarGato(GatoVO gato) throws SQLException {
        String insercion = "INSERT INTO `gatos`(`nombre`, `peso`, `edad`, `nombreRaza`, `codigoEMS`) "
                + "VALUES ('" + gato.getNombre() + "'," + gato.getPeso() + "," + gato.getEdad() + ",'"
                + gato.getNombreRaza() + "','" + gato.getCodigoEMS() + "')";
        connection = ConexionBD.getConnection();
        statement = connection.createStatement();
        statement.executeUpdate(insercion);
        statement.close();
        ConexionBD.desconectar();
    }

    /**
     * Elimina un gato de la base de datos según su ID.
     *
     * @param id Identificador del gato.
     * @return true si se ejecuta correctamente.
     * @throws SQLException Si ocurre un error al ejecutar la eliminación.
     */
    public void eliminarGato(int id) throws SQLException {
        String consulta = "DELETE FROM gatos where id='" + id + "'";
        connection = ConexionBD.getConnection();
        statement = connection.createStatement();
        statement.executeUpdate(consulta);
        statement.close();
        ConexionBD.desconectar();
        
    }

    /**
     * Modifica un atributo específico de un gato en la base de datos.
     *
     * @param id ID del gato a modificar.
     * @param atributoModificado Nombre del campo a modificar.
     * @param valorModificado Nuevo valor que se quiere asignar.
     * @return true si la actualización fue exitosa.
     * @throws SQLException Si ocurre un error al ejecutar la modificación.
     */
    public void modificarGato(int id, String factorACambiar, String valorModificado) throws SQLException {
        String consulta = "UPDATE gatos SET " + factorACambiar + " = '" + valorModificado + "' WHERE id = '" + id + "'";
        connection = ConexionBD.getConnection();
        statement = connection.createStatement();
        statement.executeUpdate(consulta);
        statement.close();
        ConexionBD.desconectar();
        
    }
}
