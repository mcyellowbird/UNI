import java.util.Scanner;

class SumAndAverageV2{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);

		System.out.println("*********");

		Double doubleValue = 0.0;

		do {
			System.out.print("\nInput a positive integer number: ");
			doubleValue = input.nextDouble();
		} while (doubleValue != Math.round(doubleValue) || doubleValue < 0);

		double value = Math.round(doubleValue);
		double sum = 0;

		for (int i = 0; i <= value ; i++ ){
			sum += i;
		}

		double average = (sum / value);

		System.out.printf("\nThe sum from 1 to %.0f is: %.0f", value, sum);

		System.out.printf("\n\nThe average is: %.1f", average);

		System.out.println("\n\n*********");
	}
}