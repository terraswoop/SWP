
public class Controller implements Observer {
	//rpm
	private int kritdreh;
	public Controller(int krit) {
		kritdreh=krit;
	}
	@Override
	public void update(int i) {
		if(i>=kritdreh) {
			System.out.println("SOUNDALARM BEEEP BEEP");
			System.out.println("DISPLAY ROOOT");
		}

	}

}
