
public class SportState implements IState{
private int minspeed=60;
private int maxspeed=10000;
private double turbomult=0.9;
@Override
public void goNext(Context c) {
	if(c.isTurbo()) {
	if((double)(minspeed*turbomult*c.getKw()/100)>c.getActspeed()) {
		c.setState(new StandardState());
	}
	if((double)(maxspeed*turbomult*c.getKw()/100)<c.getActspeed()) {
		System.out.println("Nigga you trippin' balls.");
	}
	}
	else {
		if((double)(minspeed*c.getKw()/100)>c.getActspeed()) {
			c.setState(new StandardState());
		}
		if((double)(maxspeed*c.getKw()/100)<c.getActspeed()) {
			System.out.println("Nigga you trippin' balls.");
		}
	}
}
@Override
public void act() {
	System.out.println("Sport");
}

}
