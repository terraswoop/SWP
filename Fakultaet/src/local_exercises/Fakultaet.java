package local_exercises;

public class Fakultaet {
	public static int fac(int zahl) {
		int wert=1;
		for(int i=1;i<=zahl;i++) {
			wert=wert*i;
		}
		return wert;
	}
public static int faculty(int n) {
	if(n==1) {
		return 1;
	}
	return n*faculty(n-1);
}
	public static void main(String[] args) {
		System.out.println(faculty(6));

	}

}
