package db;

import javax.persistence.*;

@Entity
@Table(name="Benutzer")
public class User {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	long id; 
	private String username;
	private String password;
	public User() {}
	public User(String u, String p) {
		username=u;
		password=p;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
