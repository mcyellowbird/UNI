import java.util.Scanner;

class SumAndAverage{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);

		System.out.println("*********");
		System.out.print("\nInput a positive integer number: ");
		Double doubleValue = input.nextDouble();

		while (doubleValue != Math.round(doubleValue) || doubleValue < 0){
			System.out.print("\nInput a positive integer number: ");
			doubleValue = input.nextDouble();
		}

		double value = Math.round(doubleValue);
		double sum = 0;
		int i = 0;

		while (i <= value){
			sum += i;
			i++;
		}

		double average = (sum / value);

		System.out.printf("\nThe sum from 1 to %.0f is: %.0f", value, sum);

		System.out.printf("\n\nThe average is: %.1f", average);

		System.out.println("\n\n*********");
	}
}