package db;
import javax.persistence.EntityManager;

import org.springframework.security.crypto.bcrypt.BCrypt;

public class DBManager {
	public static void addUser(EntityManager manager, String username, String password) {
		User u=new User(username, BCrypt.hashpw(password, BCrypt.gensalt()));
		manager.getTransaction();
		manager.persist(u);
		manager.getTransaction().commit();
		
	}
	public static boolean authorized(EntityManager manager, String username, String password) {
		User u=manager.find(User.class, username);
		return BCrypt.checkpw(password, u.getPassword());
	}

	
}
