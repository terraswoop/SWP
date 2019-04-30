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
			
		String[] seperatedValues;
		if(input.contains(",")) {
			seperatedValues = input.split(",");
		}
		else {
			seperatedValues = input.split(";");
		}
		//if(seperatedValues.length > 2) {
		//	throw new TooManyArgsException();
		//}
		if(seperatedValues.length<2){
			throw new NumberFormatException();
		}
		for(String i:seperatedValues) {
			if(i.contains("-")) {
				throw new NegativeException();
			}
		}
		int count=0;
		for(int i=0;i<seperatedValues.length;i++) {
			count+=Integer.parseInt(seperatedValues[i]);
		}
		return count;

	}

	public static void main(String[] args) throws TooManyArgsException, NumberFormatException, NegativeException {

		System.out.println(sum("3,4,5"));

	}

}
