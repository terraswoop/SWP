
public class Diavolo implements IPizza{
	private static String name="Diavolo";
	private static String[] ingredients= {"Tomaten","Chilli","Paprika","Salami"};
	@Override
	public String getName() {
		return name;
	}
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
