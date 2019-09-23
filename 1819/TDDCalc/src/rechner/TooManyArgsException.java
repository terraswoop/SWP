/**
 * @author Alex
 * @version 0,1
 */
package rechner;

public class TooManyArgsException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Override
	public String getMessage() {
		return "Too many Args";
	}
}
