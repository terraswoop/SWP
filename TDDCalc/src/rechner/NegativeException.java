/**
 * @author Alex
 * @version 0,1
 */
package rechner;

public class NegativeException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Override
	public String getMessage() {
		return "Negative Number!";
	}

}
