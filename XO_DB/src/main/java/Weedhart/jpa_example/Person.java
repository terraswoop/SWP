package Weedhart.jpa_example;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Person {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private long id;
	private int age;
	private String firstname;
	private String lastname;
	private Hobby hobby;
	//@Transient vor Variablen, die nicht in Datenbank sollen.
	public long getId() {
		return id;
	}
	public Person() {}	
	public Person( int age, String firstname, String lastname) {
	super();
	this.age = age;
	this.firstname = firstname;
	this.lastname = lastname;
}
	public void setId(long id) {
		this.id = id;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getfirstname() {
		return firstname;
	}
	public void setfirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getlastname() {
		return lastname;
	}
	public void setlastname(String lastname) {
		this.lastname = lastname;
	}
	@Override
	public String toString() {
		return "Person [id=" + id + ", age=" + age + ", firstname=" + firstname + ", lastname=" + lastname +", "+this.hobby.toString()+ "]";
	}
	public Hobby getHobby() {
		return hobby;
	}
	public void setHobby(Hobby hobby) {
		this.hobby = hobby;
	}
	
}
