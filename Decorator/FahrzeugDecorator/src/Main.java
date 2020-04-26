
public class Main {

	public static void main(String[] args) {
		Sportfahrzeug corvette= new Sportfahrzeug();
		corvette.setName("Corvette");
		corvette.setPreis(200000);
		IFahrzeug ck= new KlimanlagenDecorator(corvette);
		IFahrzeug ckl= new LederDecorator(ck);
		System.out.println(ckl.toString());
		System.out.println(ckl.getPreis());
	}

}
