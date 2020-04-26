
public class KlimanlagenDecorator extends FahrzeugDecorator{

	public KlimanlagenDecorator(IFahrzeug fahrzeug) {
		super(fahrzeug);
	}

	@Override
	public String getName() {
		return super.fahrzeug.getName()+" mit Klimaanlage;";
	}

	@Override
	public int getPreis() {
		return super.fahrzeug.getPreis()+200;
	}
	public String toString() {
		return super.fahrzeug.toString()+" mit Klimanlage;";
	}
}
