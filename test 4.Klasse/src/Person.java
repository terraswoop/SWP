
public class Person {
	public String name;
	public int alter;
	
	public Person() {}
	public Person(String name, int alter) {
		this.name=name;
		this.alter=alter;
	}
	public String toString() {
		return "Person: "+name+" "+alter;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static void main(String[] args) {
		

	}

}
