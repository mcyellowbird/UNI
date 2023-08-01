import java.util.Scanner;

public class floatingPoint{
	public static void main(String[] args){

		Scanner input = new Scanner(System.in); // Create Scanner Object

		System.out.print("Input nA: "); // Display prompt for user
		double nA = input.nextDouble(); // Get user's input
		double nB = Math.pow(nA, 3.5); // Do math, nB = nA to the power of 3.5

		nB = Math.min(nB, 199.0);

		System.out.printf("Value of nB: %.1f", nB); // Print nB to 1 decimal place
	}
}
