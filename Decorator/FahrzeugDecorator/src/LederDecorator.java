
public class LederDecorator extends FahrzeugDecorator{
	public LederDecorator(IFahrzeug fahrzeug) {
		super(fahrzeug);
	}

	@Override
	public String getName() {
		return super.fahrzeug.getName()+" mit Lederausstattung;";
	}

	@Override
	public int getPreis() {
		return super.fahrzeug.getPreis()+500;
	}
	public String toString() {
		return super.fahrzeug.toString()+" mit Lederausstattung;";
	}
}
