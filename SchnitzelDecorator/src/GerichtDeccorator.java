
public abstract class GerichtDeccorator implements IGericht{
	protected IGericht gericht;
	public GerichtDeccorator(IGericht gericht) {
		this.gericht=gericht;
	}
	
}
