
public class AufnahmeState implements IState {

	@Override
	public void goNext(Context c) {
		c.setState(new BestellungState());

	}

	@Override
	public void printMsg() {
		System.out.println("Was willsch?");

	}

}
