
public class PizzaFactory {
	public static IPizza getPizza(String pizza) {
		if(pizza=="Diavolo") {
			return new Diavolo();
		}
		else if(pizza=="Margherita") {
			return new Margherita();
		}
		else if(pizza=="Siciliana") {
			return new Siciliana();
		}
		else return null;
	}
}
