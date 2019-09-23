
public class Main {

	public static void main(String[] args) {
		LinkedList<Integer> list= new LinkedList<Integer>();
		for(int i=0;i<10;i++) {
			list.add(i);
		}
		list.remove(9);
		for(int i=0;i<list.getSize();i++) {
		System.out.printf("%d ",list.getValue(i));
		}
		System.out.println();
		System.out.println(list.getValue(5));
	}

}
