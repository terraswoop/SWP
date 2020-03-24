import java.util.ArrayList;

public class Motor implements Obervable {
	private ArrayList<Observer> observers=new ArrayList<Observer>();
	//rpm
	int drehzahl=0;
	public void beschleunigen() {
		try {
			Thread.sleep(500);
			drehzahl+=500;
			System.out.println(drehzahl);
			
		} catch (InterruptedException e) {
			System.out.println("Motor kaputt");
		}
		this.notifyObservers();
	}
	@Override
	public void addObserver(Observer o) {
		observers.add(o);

	}
	@Override
	public void removeObserver(Observer o) {
		observers.remove(o);
		
	}
	@Override
	public void notifyObservers() {
		for(Observer o : observers) {
			o.update(drehzahl);
		}
	}
	public static void main(String[] args) {
		Motor m= new Motor();
		m.addObserver(new Controller(7000));
		for(int i=0;i<16;i++) {
			m.beschleunigen();
		}
	}
}
