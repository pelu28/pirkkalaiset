package data;
import java.io.*;

public class User implements Serializable{
	
	// Luokan tietotyypit
	private static final long serialVersionUID = 1L;
    private int id;
    private String fullname;
    private String email;
    private String password;
	
    // Getterit ja setterit
    public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	} 
     
}
