
public class Main {

	public static void main(String[] args) {
		Pariserschnitzel p=new Pariserschnitzel();
		Salat s=new Salat();
		IGericht gericht=new BeilagenGerichtDecorator(p,s);
		IGericht gericht2=new BeilagenGerichtDecorator(gericht, new Pommes());
		System.out.println(gericht2.getPreis());
		System.out.println(gericht2.toString());

	}

}
