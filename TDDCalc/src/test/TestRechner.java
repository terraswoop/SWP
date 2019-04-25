package test;
/**
 * @author Alex
 * @version 0,1
 */
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import rechner.*;
import rechner.NumberFormatException;

public class TestRechner {
	
	
	@Test
	public void validInput() throws TooManyArgsException, NumberFormatException, NegativeException {
		assertEquals(8, Rechner.sum("3,5"));
	}
	@Test(expected = TooManyArgsException.class)
	public void tooManyArgs() throws TooManyArgsException, NumberFormatException, NegativeException{
		Rechner.sum("3,4,5");
	}
	
	@Test(expected = NumberFormatException.class)
	public void syntaxDelimiter() throws NumberFormatException, TooManyArgsException, NegativeException{
		Rechner.sum("3000;4");
	}
	@Test(expected = NegativeException.class)
	public void negative() throws NumberFormatException, TooManyArgsException, NegativeException{
		Rechner.sum("-3,4");
	}
}
