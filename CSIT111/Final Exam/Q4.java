import java.util.Scanner;

class Q4{
	public static int sum = 0;

	public static void main(String[] args){
		Scanner input = new Scanner(System.in);

		System.out.print("Enter a positive even number (i.e. 8 will return 20): ");

		int num = input.nextInt();

		System.out.println("Sum of positive even numbers: " + sumPositiveEvenNumbers(num));
	}

	public static int sumPositiveEvenNumbers(int n){
		if (n % 2 == 0 && n > 0){
			int num = sumPositiveEvenNumbers(n-2);

			sum += n;
		}
		else if (n % 2 == 1 && n > 0){
			int num = sumPositiveEvenNumbers(n-1);
		}

		return sum;
	}
}