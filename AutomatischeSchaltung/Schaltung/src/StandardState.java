
public class StandardState implements IState {
	private int minspeed = 0;
	private int maxspeed = 60;
	private double turbomult = 0.9;

	@Override
	public void goNext(Context c) {
		if (c.isTurbo()) {
			if ((double) (minspeed * turbomult * c.getKw() / 100) > c.getActspeed()) {
				System.out.println("Reverse Beep Beep!");
			}
			if ((double) (maxspeed * turbomult * c.getKw() / 100) < c.getActspeed()) {
				c.setState(new SportState());
			}
		} else {
			if ((double) (minspeed * c.getKw() / 100) > c.getActspeed()) {
				System.out.println("Reverse Beep Beep!");
			}
			if ((double) (maxspeed * c.getKw() / 100) < c.getActspeed()) {
				c.setState(new SportState());
			}
		}
	}

	@Override
	public void act() {
		System.out.println("Standard");

	}

}
