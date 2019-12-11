package Weedhart.jpa_example;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	 EntityManagerFactory f=Persistence.createEntityManagerFactory("Blog");
         EntityManager manager=f.createEntityManager();
       /*create
        Person p=new Person(25,"Simon","Kuttner");
        manager.getTransaction().begin();
        manager.persist(p);
        manager.getTransaction().commit();
        
        update
        Person p=manager.find(Person.class, 1L);
        System.out.println(p.toString());
        manager.getTransaction().begin();
        p.setfirstname("Batschkahn");
        manager.getTransaction().commit();
        
        remove
        Person p=manager.find(Person.class, 1L);
        manager.getTransaction().begin();
        manager.remove(p);
        manager.getTransaction().commit();
        */
         Person p=manager.find(Person.class, 1L);
         System.out.println(p);
         /*
         Hobby h=new Hobby("Fußball",4,12.40);
         p.setHobby(h);
         System.out.println("New Hobby-before Persist");
         System.out.println(h);
         manager.getTransaction().begin();
         manager.persist(h);
         manager.getTransaction().commit();
         System.out.println("New Hobby-after persist");
         System.out.println(h);
         */
    }
}
