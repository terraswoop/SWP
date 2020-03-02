
public class HalloState implements IState {

	@Override
	public void goNext(Context c) {
		c.setState(new AufnahmeState());

	}

	@Override
	public void printMsg() {
		System.out.println("Hallo Simai!");

	}

}
