package Test;

import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.Test;

import DLL.LinkedList;

public class DLLTest {
	public static LinkedList<String> t1;
	public static LinkedList<String> t2;
	public static LinkedList<String> t3;
	@BeforeClass
	public void lists() {
		t1= new LinkedList<>();
		t2= new LinkedList<>();
		t3= new LinkedList<>();
	}
	@Test
	public void getValueTest() {
		t1.add("Hallo");
		t1.add("du");
		t1.add("Bist");
		assertEquals("du", t1.getValue(1));
	}
	
	@Test
	public void removeTest() {
		
		t2.add("Hallo");
		t2.add("du");
		t2.add("Bist");
		t2.remove(0);
		assertEquals("du", t2.getValue(0));
	}
	
	
	@Test
	public void sizeTest() {
		
		t3.add("Hallo");;
		t3.add("du");;
		t3.add("bist");
		t3.remove(2);
		assertEquals(2, t3.getSize());
	}
	
}
