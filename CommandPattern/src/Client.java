
public class Client {

	public static void main(String[] args) throws InterruptedException {
		Invoker i=new Invoker(new CommandSystemData());
		i.run();
		Thread.sleep(200);
		//Andere Systemzeit als davor
		i.run();
		Thread.sleep(200);
		//Gleiche Systemzeit wie davor
		i.redo();
		//Wenn man zu oft i.undo() macht, dann bekommt man eine Empty Stack Exception, also sollte die Methode auch funktionieren
	}

}
