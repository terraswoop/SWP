
public class FizzBuzz {

	public static void main(String[] args) {
		for (int i = 1; i <= 100; i++) {
			 System.out.print(i+" : ");
			if (i % 3 == 0) {
				 System.out.print("fizz");
			}
			if (i % 4 == 0) {
				 System.out.print("buzz");
			}

			if (i % 3 != 0 && i % 4 != 0) {
				 System.out.print(i);
			}
			 System.out.println();
		}

	}

}
