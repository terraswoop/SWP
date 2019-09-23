
public class Zapnon implements Observer{
	public int temp=0;
	public int interest=30;
	@Override
	public void update(int i) {
			temp=i;
			System.out.println("Zapnon! Die Temperatur beträgt nun "+i+"°C");
	}
	@Override
	public int getInterest() {
		return interest;
	}

}
