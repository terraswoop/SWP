
package Test;

import static org.junit.Assert.assertEquals;
import org.junit.BeforeClass;
import org.junit.Test;

import BST.BinaryTree;
import BST.ElementNotFoundException;

public class BSTTest {

	@Test
	public void insertTest() throws ElementNotFoundException{
		BinaryTree<Integer> bt=new BinaryTree<Integer>();
		bt.insert(10);
		bt.insert(5);
		bt.insert(12);
		bt.insert(6);
		bt.insert(20);
		bt.insert(25);
		bt.insert(4);
		bt.insert(30);
		System.out.println(bt.getSize());
		assertEquals(25,(int)bt.getNode(25).getValue());
		assertEquals(4,(int)bt.getNode(4).getValue());
		assertEquals(10,(int)bt.getNode(10).getValue());
		assertEquals(30,(int)bt.getNode(30).getValue());
	}
}
