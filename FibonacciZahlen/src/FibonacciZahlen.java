
public class FibonacciZahlen {

	public static int calcFib(int n) {
		if(n==0 || n==1) {
			return 1; 
		}
		else return calcFib(n-1)+calcFib(n-2);
		
	}
	public static int calcFibEnd(int n, int sum, int sum2, int c){
		if(c==n) {
			return sum+sum2;
		}
		else return calcFibEnd(n,sum2,sum+sum2,++c);
		}
		public static int calcFibEnd(int n) {
			return calcFibEnd(n,0,1,1);
		}
	
	public static void main(String[] args) {
		long startzeit=System.currentTimeMillis();
		System.out.println(calcFibEnd(30));
		System.out.println(System.currentTimeMillis()-startzeit);
		startzeit=System.currentTimeMillis();
		System.out.println(calcFib(30));
		System.out.println(System.currentTimeMillis()-startzeit);
	}

}
