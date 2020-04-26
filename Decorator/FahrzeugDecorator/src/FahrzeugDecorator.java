
public abstract class FahrzeugDecorator implements IFahrzeug {
	public IFahrzeug fahrzeug;
	public FahrzeugDecorator(IFahrzeug fahrzeug) {
		this.fahrzeug=fahrzeug;
	}
}
