
public class ZahlenState implements IState {

	@Override
	public void goNext(Context c) {
		c.setState(new HalloState());

	}

	@Override
	public void printMsg() {
		System.out.println("Hier, 4,20€ !");

	}

}
