
public class BestellungState implements IState {

	@Override
	public void goNext(Context c) {
		if(!c.isIchverstehen()) {
			c.setState(new IchNixVerstehenState());
			c.setIchverstehen(true);
		}
		else {
			c.setState(new GeldBitteState());
		}
	}

	@Override
	public void printMsg() {
		System.out.println("Margherita!");

	}

}
