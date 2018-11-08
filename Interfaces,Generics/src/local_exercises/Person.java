package local_exercises;

public class Person implements IBiggerThan<Person>{
	private String lastName;
	private String firstName;
	private int age;

	public Person( String firstName, String lastName, int age) {
		super();
		this.lastName = lastName;
		this.firstName = firstName;
		this.age = age;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	public boolean isBigger(Person p) {
		int length;
		if (this.lastName.length() < p.lastName.length()) {
			length = this.lastName.length();
		} else
			length = p.lastName.length();
		for (int i = 0; i < length; i++) {
			if (this.lastName.charAt(i) < p.lastName.charAt(i)) {
				return false;
			} else if (this.lastName.charAt(i) > p.lastName.charAt(i)) {
				return true;
			}
		}
		if(length==this.lastName.length()){
		return false;
		}
		else return true;
	}
	public boolean isSmaller(Person p) {
		int length;
		if (this.lastName.length() < p.lastName.length()) {
			length = this.lastName.length();
		} else
			length = p.lastName.length();
		for (int i = 0; i < length; i++) {
			if (this.lastName.charAt(i) > p.lastName.charAt(i)) {
				return false;
			} else if (this.lastName.charAt(i) < p.lastName.charAt(i)) {
				return true;
			}
		}
		if(length==this.lastName.length()){
			return true;
			}
			else return false;
	}
	public String toString() {
		return lastName +" "+ firstName+";  Alter: "+age+"\n";
	}
}