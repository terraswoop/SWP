
public class Margherita implements IPizza {
	private static String name="Margherita";
	private static String[] ingredients= {"Tomaten","Kas"};
	@Override
	public String getName() {
		return name;	}

	@Override
	public String[] getIngredients() {
		return ingredients;
	}
	@Override
	public String toString() {
		String ing="";
		for(int i=0;i<ingredients.length;i++) {
			ing+=ingredients[i]+"; ";
		}
		return ing;
	}
}
