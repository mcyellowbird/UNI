import java.util.Scanner;

class SumOfDigits{
	public static void main(String[] args){
		// Create Scanner object
		Scanner input = new Scanner(System.in);

		System.out.print("Please input a postive integer number N: ");
		int value = input.nextInt();
		String sValue = String.valueOf(value);

		int sum = 0;

		for (int i = 0; i < sValue.length(); i++){
			sum = sum + value % 10;
			value = value / 10;
		}

		System.out.printf("The sum of all digits of the number %s is: %d", sValue, sum);
	}
}