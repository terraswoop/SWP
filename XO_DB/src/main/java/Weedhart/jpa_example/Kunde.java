package Weedhart.jpa_example;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Kunde {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private long id;
	private String titelv;
	private String vorname;
	private String nachname;
	private String titeln;
	public Kunde() {}
	public Kunde(String titelv, String vorname, String nachname, String titeln) {
		super();
		this.titelv = titelv;
		this.vorname = vorname;
		this.nachname = nachname;
		this.titeln = titeln;
	}
	@Override
	public String toString() {
		return "Person [id=" + id + ", TitelV=" + titelv + ", Firstname=" + vorname + ", Lastname=" + nachname +", TitelN= "+titeln+ "]";
	}
	public String getString(int i) {
		if(i==0) {return "Kunde";}
		if(i==1) {return ""+id;}
		if(i==2) {return titelv;}
		if(i==3) {return vorname;}
		if(i==4) {return nachname;}
		if(i==5) {return titeln;}
		else return null;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTitelv() {
		return titelv;
	}
	public void setTitelv(String titelv) {
		this.titelv = titelv;
	}
	public String getVorname() {
		return vorname;
	}
	public void setVorname(String vorname) {
		this.vorname = vorname;
	}
	public String getNachname() {
		return nachname;
	}
	public void setNachname(String nachname) {
		this.nachname = nachname;
	}
	public String getTiteln() {
		return titeln;
	}
	public void setTiteln(String titeln) {
		this.titeln = titeln;
	}
	
}
