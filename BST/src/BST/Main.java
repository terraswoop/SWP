package BST;

public class Main {

	public static void main(String[] args) {
		BinaryTree<Integer> bt= new BinaryTree<Integer>();
		bt.insert(10);
		bt.insert(5);
		bt.insert(12);
		bt.insert(6);
		bt.insert(20);
		bt.insert(25);
		bt.insert(4);
		bt.insert(30);
		bt.insert(3);
		bt.insert(2);
		bt.insert(1);
		
		try {
		bt.removeElement(5);
		System.out.println(bt.getNode(4).getValue());
		}
		catch(ElementNotFoundException e) {
			System.out.println("Nicht vorhanden!");
		}
		

	}

}
