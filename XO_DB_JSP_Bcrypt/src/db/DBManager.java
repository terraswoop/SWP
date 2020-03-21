package db;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.security.crypto.bcrypt.BCrypt;

public class DBManager {
	public static void addUser(EntityManager manager, String username, String password) {
		User u=new User(username, BCrypt.hashpw(password, BCrypt.gensalt()));
		manager.getTransaction().begin();
		manager.persist(u);
		manager.getTransaction().commit();
		
	}
	public static boolean authorized(EntityManager manager, String username, String password) {
		Query query = manager.createNativeQuery("Select * FROM Benutzer;",User.class);
		List<User> result=query.getResultList();
		for(User u : result) {
			if(u.getUsername().equals(username)) {
				return BCrypt.checkpw(password, u.getPassword());
			}
		}
		return false;
	}

	
}
