import java.util.ArrayList;

public class Heizung {
	ArrayList<Observer> observers=new ArrayList<Observer>();
	private int temp;
	public Heizung(int temp) {
		this.temp=temp;
	}
	public void setValue(int i) {
		temp=i;
		notifyObservers();
	}
	public void notifyObservers() {
		for(Observer o:observers) {
			if(temp>=o.getInterest()) {
				o.update(temp);
			}
		}
	}
	public void register(Observer o) {
		observers.add(o);
	}
	public void unregister(Observer o) {
		observers.remove(o);
	}
	public static void main(String[] args) {
		Heizung h= new Heizung(20);
		Zapnon z=new Zapnon();
		h.register(z);
		Batuhan b= new Batuhan();
		h.register(b);
		h.setValue(31);

	}

}
