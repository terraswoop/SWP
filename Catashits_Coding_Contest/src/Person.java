
public class Person {
	private int größe;
	private String name;
	public Person(int gr, String n) {
		größe=gr;
		name=n;
	}
	public Person() {}
	
	public int getGröße() {
		return größe;
	}
	public void setGröße(int größe) {
		this.größe = größe;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void ausgabe() {
		System.out.printf("%s, %d",name,größe);
	}
	
	public static void main(String[] args) {
		Person p=null;
		System.out.println(p);
		p.setGröße(190);
		p.ausgabe();
		
	}

}
