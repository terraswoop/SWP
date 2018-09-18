import java.util.ArrayList;

public class First_Test {

	public static void sort(ArrayList<Integer> l) {
		int zw = 0;

		for (int i = 0; i < l.size(); i++) {
			for (int j = i + 1; j < l.size(); j++) {
				if (l.get(j) < l.get(i)) {
					zw = l.get(i);
					l.set(i, l.get(j));
					l.set(j, zw);
				}
			}
		}
		System.out.println(l.toString());
	}

	public static void sort2(ArrayList<Integer> l) {
		boolean fertig=false;
		ArrayList<Integer> l2= new ArrayList<>();
		int zaehler=1;
		while(!fertig) {
			if(l.contains(zaehler)) {
				l2.add(zaehler);
			}
			zaehler++;
			if(l.size()==l2.size()) {
				fertig=true;
			}
		}
		System.out.println(l2.toString());
	}
	public static void main(String[] args) {
		ArrayList<Integer> l = new ArrayList<>();
		l.add(3);
		l.add(15);
		l.add(2);
		l.add(4);
		l.add(1);
		sort2(l);

		for (int i = 1; i <= 100; i++) {
			// System.out.print(i+" : ");
			if (i % 3 == 0) {
				// System.out.print("fizz");
			}
			if (i % 4 == 0) {
				// System.out.print("buzz");
			}

			if (i % 3 != 0 && i % 4 != 0) {
				// System.out.print(i);
			}
			// System.out.println();
		}

	}

}
