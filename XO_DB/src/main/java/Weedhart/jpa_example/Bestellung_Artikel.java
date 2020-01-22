package Weedhart.jpa_example;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Bestellung_Artikel {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private long id;
	private Bestellung bestellung;
	private Artikel artikel;
	private int menge;
	public Bestellung_Artikel() {}
	public Bestellung_Artikel(Bestellung bestellung, Artikel artikel, int menge) {
		super();
		this.bestellung = bestellung;
		this.artikel = artikel;
		this.menge=menge;
	}
	public String getString(int i) {
		if(i==0) {return "BestArt";}
		if(i==1) {return ""+bestellung.getId();}
		if(i==2) {return ""+artikel.getId();}
		if(i==3) {return ""+menge;}
		else return null;
	}
	@Override
	public String toString() {
		return "Bestellung_Artikel [id=" + id + ", bestellung=" + bestellung + ", artikel=" + artikel + ", menge="
				+ menge + "]";
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public int getMenge() {
		return menge;
	}

	public void setMenge(int menge) {
		this.menge = menge;
	}

	public Bestellung getBestellung() {
		return bestellung;
	}
	public void setBestellung(Bestellung bestellung) {
		this.bestellung = bestellung;
	}
	public Artikel getArtikel() {
		return artikel;
	}
	public void setArtikel(Artikel artikel) {
		this.artikel = artikel;
	}
	
}
