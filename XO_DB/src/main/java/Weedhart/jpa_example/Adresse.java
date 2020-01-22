package Weedhart.jpa_example;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Adresse {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private long id;
	private String stadt;
	private String strasse;
	private int plz;
	private String hnr;
	public Adresse() {}
	public Adresse( String stadt, String strasse, int plz, String hnr) {
		super();
		this.stadt = stadt;
		this.strasse = strasse;
		this.plz = plz;
		this.hnr = hnr;
	}
	public String getString(int i) {
		if(i==0) {return "Adresse";}
		if(i==1) {return ""+id;}
		if(i==2) {return stadt;}
		if(i==3) {return strasse;}
		if(i==4) {return ""+plz;}
		if(i==5) {return hnr;}
		else return null;
	}
	@Override
	public String toString() {
		return "Adresse [id=" + id + ", stadt=" + stadt + ", strasse=" + strasse + ", plz=" + plz + ", hnr=" + hnr
				+ "]";
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getStadt() {
		return stadt;
	}
	public void setStadt(String stadt) {
		this.stadt = stadt;
	}
	public String getStrasse() {
		return strasse;
	}
	public void setStrasse(String strasse) {
		this.strasse = strasse;
	}
	public int getPlz() {
		return plz;
	}
	public void setPlz(int plz) {
		this.plz = plz;
	}
	public String getHnr() {
		return hnr;
	}
	public void setHnr(String hnr) {
		this.hnr = hnr;
	}
	
}
