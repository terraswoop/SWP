package Weedhart.jpa_example;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Artikel {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private long id;
	private String name;
	private double preis;
	public Artikel() {}
	public Artikel( String name, double preis) {
		super();
		this.name = name;
		this.preis = preis;
	}
	public String getString(int i) {
		if(i==0) {return "Artikel";}
		if(i==1) {return ""+id;}
		if(i==2) {return name;}
		if(i==3) {return ""+preis;}
		else return null;
	}
	@Override
	public String toString() {
		return "Artikel [id=" + id + ", name=" + name + ", preis=" + preis + "]";
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPreis() {
		return preis;
	}
	public void setPreis(double preis) {
		this.preis = preis;
	}
	
	
}
