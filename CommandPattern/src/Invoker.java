
public class Invoker {
	Command c;
	public Invoker(Command c) {
		this.c=c;
	}
	public Command getC() {
		return c;
	}
	public void setC(Command c) {
		this.c = c;
	}
	public void run() {
		c.execute();
	}
	public void redo() {
		c.redo();
	}
	public void undo() {
		c.undo();
	}
}
