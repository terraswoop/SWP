
public class Context {
	private IStrategy s;
	public Context(IStrategy s) {
		this.s=s;
	}
	public void execute(double d1,double d2) {
		System.out.println(s.operate(d1, d2));
	}
}
