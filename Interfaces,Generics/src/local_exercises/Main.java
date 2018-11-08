package local_exercises;

import java.util.ArrayList;

public class Main {
	public static void bubbleSort(ArrayList<IBiggerThan> l) {
		IBiggerThan zw;
		for (int i = 0; i < l.size(); i++) {
			for (int j = i + 1; j < l.size(); j++) {
				if (l.get(i).isBigger(l.get(j))) {
					zw = l.get(i);
					l.set(i, l.get(j));
					l.set(j, zw);
				}
			}
		}
		System.out.println(l.toString());
	}
	public static void main(String[] args) {
		ArrayList<IBiggerThan> l= new ArrayList<>();
		l.add(new Person("Martin","Schöpf",18));
		l.add(new Person("Sepp","Schöpfer",70));
		l.add(new Person("Juen","Klingler",65));
		l.add(new Person("Alex","Winter",10));
		l.add(new Person("Batuhan","Azcan",85));
		//l.add(new Haus());
		bubbleSort(l);
	}

}
