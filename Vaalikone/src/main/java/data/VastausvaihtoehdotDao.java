package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
 
public class VastausvaihtoehdotDao {
    private String jdbcURL;
    private String jdbcUsername;
    private String jdbcPassword;
    private Connection jdbcConnection;
     
    public VastausvaihtoehdotDao(String jdbcURL, String jdbcUsername, String jdbcPassword) {
        this.jdbcURL = jdbcURL;
        this.jdbcUsername = jdbcUsername;
        this.jdbcPassword = jdbcPassword;
    }
     
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
     
     
    public List<Vastausvaihtoehdot> listAllVastausvaihtoehdot() throws SQLException { 
        List<Vastausvaihtoehdot> listVastausvaihtoehdot = new ArrayList<>();
         
        String sql = "SELECT * FROM vastausvaihtoehdot";
         
        connect();
         
        Statement statement = jdbcConnection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
         
        while (resultSet.next()) {
            int nro = resultSet.getInt("vaihtoehto_nro");
            String teksti = resultSet.getString("vaihtoehto_teksti");

            Vastausvaihtoehdot vastausvaihtoehto = new Vastausvaihtoehdot(nro, teksti);
            listVastausvaihtoehdot.add(vastausvaihtoehto);
        }
         
        resultSet.close();
        statement.close();
         
        disconnect();
         
        return listVastausvaihtoehdot;
    }
    
    public Vastausvaihtoehdot getVastausvaihtoehto(int vaihtoehto_nro) throws SQLException {
        Vastausvaihtoehdot vastausvaihtoehto = null;
        String sql = "SELECT * FROM vastausvaihtoehdot WHERE vaihtoehto_nro = ?";
         
        connect();
         
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setInt(1, vaihtoehto_nro);
         
        ResultSet resultSet = statement.executeQuery();
         
        if (resultSet.next()) {
            String vaihtoehto_teksti = resultSet.getString("vaihtoehto_teksti");
             
            vastausvaihtoehto = new Vastausvaihtoehdot(vaihtoehto_nro, vaihtoehto_teksti);
        }
         
        resultSet.close();
        statement.close();
         
        return vastausvaihtoehto;
    }
}
