import java.util.ArrayList;

public class Sortieralgorithmen {
	static int counter=0;
	public static void bubbleSort(ArrayList<Integer> l) {
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

	public static void counterSort(ArrayList<Integer> l) {
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
	public static void selectionSort(ArrayList<Integer> l) {
		ArrayList<Integer> l2=new ArrayList<>();
		long startzeit=System.currentTimeMillis();
		int smallest;
		while(l.size()!=0) {
			smallest=l.get(0);
			for(int i=0;i<l.size();i++) {
				if(l.get(i)<smallest) {
					smallest=l.get(i);
				}
			}
			l.remove(l.indexOf(smallest));
			l2.add(smallest);
		}
		System.out.println(System.currentTimeMillis()-startzeit);
		System.out.println(l2.toString());
		System.out.println(System.currentTimeMillis()-startzeit);
	}
	public static ArrayList<Integer> quickSort(ArrayList<Integer> l) {
		if(l.size()<=1) {
			return l;
		}
		counter++;
		int pvot = l.get((int)(Math.random()*l.size()));
		ArrayList<Integer> l1=new ArrayList<>();
		ArrayList<Integer> l2=new ArrayList<>();
		for(int i=0;i<l.size();i++) {
			if(l.get(i)<pvot) {
				l1.add(l.get(i));
			}
			else l2.add(l.get(i));
		}
		
		l1= quickSort(l1);
		l1.addAll(quickSort(l2));
		return l1;
	}

	public static void quickSort2(int[] l,int a, int b){
		int pvot=l[(a+b)/2];
		int zw;
		int i=a;
		int j=b;
		while(i<=j) {
			while(l[i]<pvot) {
				i++;
			}
			while(l[j]>pvot) {
				j--;
			}
			if(i<=j) {
				zw=l[i];
				l[i]=l[j];
				l[j]=zw;
				i++;
				j--;
			}
		}
		if(a<i-1) {
			quickSort2(l,a,i-1);
		}
		if(b>i) {
			quickSort2(l,i,b);
		}
	}
/*	public static void quickSort3(int[] l, int a, int b) {
		int pvot=l[(a+b)/2];
		int pvindex=(a+b)/2;
		int zw;
		boolean pvotwechs=false;
		for(int i=a;i<pvindex;i++) {
			if(l[i]>=pvot) {
				for(int j=pvindex;j<=b;j++) {
					if(l[j]<=l[i]) {
						zw=l[i];
						l[i]=l[j];
						l[j]=zw;
						System.out.println("swap");
						if(zw==pvot) {pvotwechs=true;}
					}
				}
			}
		}
		for(int i=pvindex;i<=b;i++) {
			if(l[i]<pvot) {
				for(int j=a;j<pvindex;j++) {
					if(l[j]>l[i]) {
						zw=l[i];
						l[i]=l[j];
						l[j]=zw;
						System.out.println("swap2");					
					}
				}
			}
		}
		for(int i=a;i<=b;i++) {
			System.out.printf("%d ",l[i]);
		}
		System.out.println("      "+ a+"   "+b+"   "+pvindex);
		if(a+1<b) {
			if(!pvotwechs) {
				System.out.println("next1");
				quickSort3(l,a,pvindex);
				quickSort3(l,pvindex+1,b);
			}
			else {
				System.out.println("next2");
				quickSort3(l,a,pvindex-1);
				quickSort3(l,pvindex,b);
			}
		}
		
	}
	public static void monkeySort(ArrayList<Integer> l) {
		int biggest=0;
		int counter=0;
		long startzeit=System.currentTimeMillis();
		ArrayList<Integer> l2= new ArrayList<>();
		for(int i=0;i<l.size();i++) {
			if(l.get(i)>biggest) {
				biggest=l.get(i);
			}
		}
		boolean fertig= false;
		while(!fertig) {
			
			int random;
			while(l.size()!=0) {
				random= (int)(Math.random()*biggest+1);
				if(l.contains(random)) {
					l2.add(random);
					l.remove(l.indexOf(random));
				}
				
			}	
			for(int i=0;i<l2.size();i++) {
				l.add(l2.get(i));
			}
			counter++;
			l2.clear();
			fertig=true;
			for(int i=1;i<l.size();i++) {
				if(l.get(i-1)>l.get(i)) {
					fertig=false;
				}
			}
				
		}
		System.out.println(System.currentTimeMillis()-startzeit);
		System.out.println(counter);
		System.out.println(l.toString());
	}
	*/
	public static void insertionSort(ArrayList <Integer> l) {
		ArrayList<Integer> l2= new ArrayList<>();
		boolean firstCard=true;
		while(l.size()!=0) {
			int index=0;
			int wert=l.get(0);
			if(!firstCard) {
				for(int i=0;i<l2.size();i++) {
				
					if(wert<l2.get(i)) {
						index=i;
						break;
					}
					else index=i+1;
				}
			}
			else {firstCard=false; l2.add(wert);}
			l.remove(0);
			l2.add(index, wert);
		}
		System.out.println(l2.toString());
	}
	public static ArrayList<Integer> getRandomList(int length){
		ArrayList<Integer> l=new ArrayList<>();
		for(int i=0;i<length;i++) {
			l.add((int)(Math.random()*1000+1));
		}
		return l;
	}
	public static void main(String[] args) {
		ArrayList<Integer> l = new ArrayList<>();
		l=getRandomList(20);
		int[] a = new int[l.size()];
		for(int i=0;i<l.size();i++) {
			a[i]=l.get(i);
		}
		//quickSort(a,0,a.length-1);
		
		System.out.println();
		System.out.println(counter);
		quickSort2(a,0,a.length-1);
		for(int i= 0;i<a.length;i++) {
			System.out.printf("%d, ",a[i]);
		}
		//System.out.println(l.toString());
		//insertionSort(l);
		//monkeySort(l);
		
	}
}
