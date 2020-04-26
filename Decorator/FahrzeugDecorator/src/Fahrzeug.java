
public abstract class Fahrzeug implements IFahrzeug{
	private String name;
	private int preis;
	@Override
	public String getName() {
		return name;
	}

	@Override
	public int getPreis() {
		// TODO Auto-generated method stub
		return preis;
	}
	public void setPreis(int preis) {
		this.preis=preis;
	}
	public void setName(String name) {
		this.name=name;
	}
	public String toString() {
		return name+"; Einzelpreis: "+preis;
	}
}
