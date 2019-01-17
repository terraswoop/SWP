
public class FibonacciZahlen {

	public static int calcFib(int n) {
		if(n==0 || n==1) {
			return 1; 
		}
		else return calcFib(n-1)+calcFib(n-2);
		
	}
	public static int calcFibEnd(int n, int sum, int sum2){
		if(n==1) {
			return sum+sum2;
		}
		else return calcFibEnd(n-1,sum2,sum+sum2);
		}
		public static int calcFibEnd(int n) {
			return calcFibEnd(n,0,1);
		}
	
	public static void main(String[] args) {
		long startzeit=System.currentTimeMillis();
		System.out.println(calcFibEnd(40));
		System.out.println(System.currentTimeMillis()-startzeit);
		startzeit=System.currentTimeMillis();
		System.out.println(calcFib(40));
		System.out.println(System.currentTimeMillis()-startzeit);
	}

}
