
public class Fractale {
	
	public static double calcSnowflake(double length, int iterations, int init) {
		if(iterations==0) {
			return 3.0*length;
		}
		else { return calcSnowflake(length/3.0,iterations-1, init=2)*init+length*2;}
	}
	public static void main(String[] args) {
		System.out.println(calcSnowflake(9,3,3));
	}

}
