package Test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import DLL.LinkedList;

public class DLLTest {
	@Test
	public void removeTest() {
		LinkedList<String> test= new LinkedList<>();
		test.add("Hallo");
		test.add("du");
		test.add("Bist");
		test.remove(0);
		assertEquals("du", test.getValue(0));
	}
	
	@Test
	public void sizeTest() {
		LinkedList<String> test= new LinkedList<>();
		test.add("Hallo");;
		test.add("du");;
		test.add("bist");
		assertEquals(3, test.getSize());
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
