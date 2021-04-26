package data;
 
import java.sql.*;
 
public class UserDAO {
 
	private String jdbcURL;
    private String jdbcUsername;
    private String jdbcPassword;
    private Connection jdbcConnection;
    
	public UserDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) {
        this.jdbcURL = jdbcURL;
        this.jdbcUsername = jdbcUsername;
        this.jdbcPassword = jdbcPassword;
    }
	
    public UserDAO() {
		// TODO Auto-generated constructor stub
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
    
    public User checkLogin(String email, String password) throws SQLException,
            ClassNotFoundException {
        //String jdbcURL = "jdbc:mysql://localhost:3306/vaalikone";
        //String dbUser = "root";
        //String dbPassword = "caution12";
    	
    	//String jdbcURL = "jdbURL";
 
        //Class.forName("com.mysql.jdbc.Driver");
        //Connection connection = DriverManager.getConnection(jdbcURL, dbUser, dbPassword);
    	
        String sql = "SELECT * FROM users WHERE email = ? and password = ?";
        connect();
        
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, email);
        statement.setString(2, password);
 
        ResultSet result = statement.executeQuery();
 
        User user = null;
 
        if (result.next()) {
            user = new User();
            user.setFullname(result.getString("fullname"));
            user.setEmail(email);
        }
 
        // jdbcConnection.close();
        disconnect();
 
        return user;
    }
}