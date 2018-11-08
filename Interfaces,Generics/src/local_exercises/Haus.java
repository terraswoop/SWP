package local_exercises;

public class Haus implements IBiggerThan<Haus>{
	private int age;
	public boolean isBigger(Haus o) {
		if(this.age>o.age) {
			return true;
		}
		else return false;
	}
	

}
