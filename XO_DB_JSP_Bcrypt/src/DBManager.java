import org.springframework.security.crypto.bcrypt.BCrypt;

public class DBManager {
	public static void addUser(String username, String password) {
		BCrypt.hashpw(password, BCrypt.gensalt());
		
	}
	public static boolean authorized(String username, String password) {
		BCrypt.checkpw(password, hashed);
	}

	
}
