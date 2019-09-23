package local_exercises;

import java.util.ArrayList;

public class PascalschesDreieck {

	public static int pd(int spalte, int reihe) {
		if(spalte==reihe || reihe==0) {
			return 1;
		}
		else return pd(spalte-1,reihe-1)+pd(spalte-1,reihe);
	}
	public static int pd2(int zeile, int spalte) {
		boolean list1=false;
		int zaehler=1;
		ArrayList<Integer> pyramid1= new ArrayList<>();
		ArrayList<Integer> pyramid2= new ArrayList<>();
		while(true){
			if(list1) {
				pyramid1.clear();
				pyramid1.add(1);
				for(int i=0;i<pyramid2.size()-1;i++) {
					pyramid1.add(pyramid2.get(i)+pyramid2.get(i+1));
				}
				pyramid1.add(1);
				//System.out.println(pyramid1.toString());
				if(zeile==zaehler) {
					return pyramid1.get(spalte);
				}
			}
			else {
				pyramid2.clear();
				pyramid2.add(1);
				for(int i=0;i<pyramid1.size()-1;i++) {
					pyramid2.add(pyramid1.get(i)+pyramid1.get(i+1));
				}
				pyramid2.add(1);
				//System.out.println(pyramid2.toString());
				if(zeile==zaehler) {
					return pyramid2.get(spalte);
				}
			}
			list1=!list1;
			zaehler++;
		}	
		
	}
	public static void main(String[] args) {
		long startzeit=System.currentTimeMillis();
		System.out.println(pd(50,8));
		System.out.println(System.currentTimeMillis()-startzeit);
		startzeit=System.currentTimeMillis();
		System.out.println(pd2(50,8));
		System.out.println(System.currentTimeMillis()-startzeit);
	}

}
