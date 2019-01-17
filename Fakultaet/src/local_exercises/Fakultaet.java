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
public static int facultyEnd(int n, int sum) {
	if(n==1) {
		return sum;
	}
	else {return facultyEnd(n-1,sum*n);}
}
	public static void main(String[] args) {
		long startzeit=System.currentTimeMillis();
		System.out.println(faculty(30));
		System.out.println(System.currentTimeMillis()-startzeit);
		startzeit=System.currentTimeMillis();
		System.out.println(facultyEnd(30,1));
		System.out.println(System.currentTimeMillis()-startzeit);

	}

}
