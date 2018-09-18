
public class CalcTypes {

	public int modifyPrimitive(int a) {
		return a=4;
		
	}
	public String modifyObject(String s) {
		return s="Hallo";
	}
	public void modifyPerson(Person p) {
		p.name="josef";
		p.alter=20;
	}
	public static void main(String[] args) {
		CalcTypes c= new CalcTypes();
		Person p=new Person();
		c.modifyPerson(p);
		int a=0;
		String s=" ";
		a=c.modifyPrimitive(a);
		s=c.modifyObject(s);
		System.out.println(a);
		System.out.println(s);
		System.out.println(p.toString());
	}

}
