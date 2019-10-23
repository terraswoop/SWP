
public class Batuhan implements Observer{
	public int temp=0;
	public int interest=25;
	@Override
	public void update(int i) {
		temp=i;
		System.out.println("Batuhan! Die Temperatur beträgt nun "+i+"°C");
	}
	@Override
	public int getInterest() {
		return interest;
	}
	

}
