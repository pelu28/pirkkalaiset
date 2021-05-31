package data;
 
import java.sql.*;

import com.google.appengine.repackaged.org.apache.commons.codec.digest.Crypt;
 
public class UserDAO {

	public User checkLogin(String email, String password) throws SQLException,
            ClassNotFoundException {
        
		// Tietokantayhteyden parametrit
		String jdbcURL = "jdbc:mysql://localhost:3306/vaalikone";
        String dbUser = "root";
        String dbPassword = "1234";
        String s = Crypt.crypt(dbPassword);
        
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection(jdbcURL, dbUser, dbPassword);
        String sql = "SELECT * FROM users WHERE email = ? and password = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, email);
        statement.setString(2, password);
 
        ResultSet result = statement.executeQuery();
 
        User user = null;
 
        if (result.next()) {
            user = new User();
            user.setFullname(result.getString("fullname"));
            user.setEmail(email);
        }
 
        connection.close();
 
        return user;
    }
}