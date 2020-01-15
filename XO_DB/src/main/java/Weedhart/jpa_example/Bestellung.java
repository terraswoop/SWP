package Weedhart.jpa_example;

import javax.persistence.*;


@Entity
public class Bestellung {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private long id;
	private Kunde kunde;
	private Adresse addressrech;
	private Adresse addresslief;
	public Bestellung(Kunde kunde, Adresse addressrech, Adresse addresslief) {
		super();
		this.kunde=kunde;
		this.addressrech = addressrech;
		this.addresslief = addresslief;
	}
	@Override
	public String toString() {
		return "Bestellung [id=" + id + ", kunde=" + kunde + ", addressrech=" + addressrech + ", addresslief="
				+ addresslief + "]";
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Kunde getKunde() {
		return kunde;
	}
	public void setKunde(Kunde kunde) {
		this.kunde = kunde;
	}
	public Adresse getAddressrech() {
		return addressrech;
	}
	public void setAddressrech(Adresse addressrech) {
		this.addressrech = addressrech;
	}
	public Adresse getAddresslief() {
		return addresslief;
	}
	public void setAddresslief(Adresse addresslief) {
		this.addresslief = addresslief;
	}
	
}
