
public class KeinGeldState implements IState {

	@Override
	public void goNext(Context c) {
		c.setState(new AufnahmeState());

	}

	@Override
	public void printMsg() {
		System.out.println("Wart so viel Geld hab i nid i frag gach Kollegen.");

	}

}
