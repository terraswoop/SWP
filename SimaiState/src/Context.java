
public class Context {
	private boolean ichverstehen;
	private boolean geld;
	private IState state;

	public void advance() {
		state.printMsg();
		state.goNext(this);
	}

	public boolean isIchverstehen() {
		return ichverstehen;
	}

	public void setIchverstehen(boolean ichverstehen) {
		this.ichverstehen = ichverstehen;
	}

	public boolean isGeld() {
		return geld;
	}

	public void setGeld(boolean geld) {
		this.geld = geld;
	}

	public IState getState() {
		return state;
	}

	public void setState(IState state) {
		this.state = state;
	}

	public static void main(String[] args) {
		Context c=new Context();
		c.setGeld(false);
		c.setIchverstehen(false);
		c.setState(new HalloState());
		for(int i=0;i<18;i++) {
			c.advance();
		}
	}
}
