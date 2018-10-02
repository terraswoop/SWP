package local_exercises;

public class PascalschesDreieck {

	public static int pd(int spalte, int reihe) {
		if(spalte==reihe || reihe==0) {
			return 1;
		}
		else return pd(spalte-1,reihe-1)+pd(spalte-1,reihe);
	}
	public static void main(String[] args) {
		System.out.println(pd(10,8));

	}

}
