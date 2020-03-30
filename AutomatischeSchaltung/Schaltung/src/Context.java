import java.util.Scanner;

public class Context {
private int actspeed;
private int kw;
private boolean turbo;
private IState state;
public Context(int actspeed, int kw, boolean turbo, IState beginstate) {
	this.actspeed=actspeed;
	this.kw=kw;
	this.turbo=turbo;
	this.state=beginstate;
}
public int getActspeed() {
	return actspeed;
}
public void setActspeed(int actspeed) {
	this.actspeed = actspeed;
}
public int getKw() {
	return kw;
}
public void setKw(int kw) {
	this.kw = kw;
}
public boolean isTurbo() {
	return turbo;
}
public void setTurbo(boolean turbo) {
	this.turbo = turbo;
}
public IState getState() {
	return state;
}
public void setState(IState state) {
	this.state = state;
}
public static void main(String[] args) {
	Context c=new Context(0,95,true,new StandardState());
	Scanner s= new Scanner(System.in);
	System.out.println("Stop Simulation with 'n'");
	while(true) {
		String next=s.next();
		if(next.equals("n")) {
			break;
		}
		try {
			c.actspeed=Integer.parseInt(next);
		}
		catch(Exception e) {
			System.out.println("Motor broke!");
		}
		c.getState().goNext(c);
		c.getState().act();
	}
	System.out.println("See ya!");
	s.close();
}
}
