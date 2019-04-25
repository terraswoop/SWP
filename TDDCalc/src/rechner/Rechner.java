/**
 * @author Alex
 * @version 0,1
 */
package rechner;

public class Rechner {
	/**
	 * 
	 * @param input
	 *            should be for example "4,5"
	 * @return
	 * @throws TooManyArgsException 
	 * @throws NumberFormatException 
	 * @throws NegativeException 
	 */
	public static int sum(String input) throws TooManyArgsException, NumberFormatException, NegativeException {
		String[] seperatedValues = input.split(",");
		if(seperatedValues.length > 2) {
			throw new TooManyArgsException();
		}
		if(seperatedValues.length<2){
			throw new NumberFormatException();
		}
		for(String i:seperatedValues) {
			if(i.contains("-")) {
				throw new NegativeException();
			}
		}
		return Integer.parseInt(seperatedValues[0]) + Integer.parseInt(seperatedValues[1]);

	}

	public static void main(String[] args) {

		// TODO Auto-generated method stub

	}

}
