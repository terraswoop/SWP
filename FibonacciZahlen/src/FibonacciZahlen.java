
public class FibonacciZahlen {

	public static int calcFib(int n) {
		if(n==0 || n==1) {
			return 1; 
		}
		else return calcFib(n-1)+calcFib(n-2);
		
	}
	public static void main(String[] args) {
		System.out.println(calcFib(17));
	}

}
