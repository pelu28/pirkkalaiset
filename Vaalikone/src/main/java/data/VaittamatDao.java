package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
 
public class VaittamatDao {
	
	// Luokan tietotyypit
    private String jdbcURL;
    private String jdbcUsername;
    private String jdbcPassword;
    private Connection jdbcConnection;
    
    // Alustus 
    public VaittamatDao(String jdbcURL, String jdbcUsername, String jdbcPassword) {
        this.jdbcURL = jdbcURL;
        this.jdbcUsername = jdbcUsername;
        this.jdbcPassword = jdbcPassword;
    }
     
    // Yhteyden muodostus
    protected void connect() throws SQLException {
        if (jdbcConnection == null || jdbcConnection.isClosed()) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                throw new SQLException(e);
            }
            jdbcConnection = DriverManager.getConnection(
                                        jdbcURL, jdbcUsername, jdbcPassword);
        }
    }
     
    protected void disconnect() throws SQLException {
        if (jdbcConnection != null && !jdbcConnection.isClosed()) {
            jdbcConnection.close(); 
        }
    }
     
    // Lisää väittämä
    public boolean insertVaittamat(Vaittamat vaittama) throws SQLException {
        String sql = "INSERT INTO vaittama (otsikko, vaite_teksti, luokka) VALUES (?, ?, ?)";
        connect();
         
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, vaittama.getOtsikko());
        statement.setString(2, vaittama.getVaite());
        statement.setString(3, vaittama.getLuokka());
         
        boolean rowInserted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowInserted;
    }
    
    // Listaa väittämät
    public List<Vaittamat> listAllVaittamat() throws SQLException {
        List<Vaittamat> listVaittamat = new ArrayList<>();
         
        String sql = "SELECT * FROM vaittama";
         
        connect();
         
        Statement statement = jdbcConnection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
         
        while (resultSet.next()) {
            int id = resultSet.getInt("vaittama_id");
            String otsikko = resultSet.getString("otsikko");
            String vaite_teksti = resultSet.getString("vaite_teksti");
            String luokka = resultSet.getString("luokka");
             
            Vaittamat vaittama = new Vaittamat(id, otsikko, vaite_teksti, luokka);
            listVaittamat.add(vaittama);
        }
         
        resultSet.close();
        statement.close();
         
        disconnect();
         
        return listVaittamat;
    }
    
    // Poista väittämä
    public boolean deleteVaittamat(Vaittamat vaittama) throws SQLException {
        String sql = "DELETE FROM vaittama where vaittama_id = ?";
         
        connect();
         
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setInt(1, vaittama.getId());
         
        boolean rowDeleted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowDeleted;     
    }
     
    // Muokkaa väittämää
    public boolean updateVaittamat(Vaittamat vaittama) throws SQLException {
        String sql = "UPDATE vaittama SET otsikko = ?, vaite_teksti = ?, luokka = ?";
        sql += " WHERE vaittama_id = ?";
        connect();
         
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, vaittama.getOtsikko());
        statement.setString(2, vaittama.getVaite());
        statement.setString(3, vaittama.getLuokka());
        statement.setInt(4, vaittama.getId());
         
        boolean rowUpdated = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowUpdated;     
    }
     
    // Hae väittämä
    public Vaittamat getVaittamat(int id) throws SQLException {
        Vaittamat vaittama = null;
        String sql = "SELECT * FROM vaittama WHERE vaittama_id = ?";
         
        connect();
         
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setInt(1, id);
         
        ResultSet resultSet = statement.executeQuery();
         
        if (resultSet.next()) {
            String otsikko = resultSet.getString("otsikko");
            String vaite_teksti = resultSet.getString("vaite_teksti");
            String luokka = resultSet.getString("luokka");
             
            vaittama = new Vaittamat(id, otsikko, vaite_teksti, luokka);
        }
         
        resultSet.close();
        statement.close();
         
        return vaittama;
    }
}