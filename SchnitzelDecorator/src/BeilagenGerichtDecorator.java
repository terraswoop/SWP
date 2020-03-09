
public class BeilagenGerichtDecorator extends GerichtDeccorator{
	IBeilage beilage;
	public BeilagenGerichtDecorator(IGericht gericht, IBeilage beilage) {
		super(gericht);
		this.beilage=beilage;
	}
	@Override
	public int getPreis() {
		// TODO Auto-generated method stub
		return super.gericht.getPreis()+beilage.getPreis();
	}
	@Override
	public String toString() {
		return super.gericht.toString()+", "+beilage.toString();
	}
}
