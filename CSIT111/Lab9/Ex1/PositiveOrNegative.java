import java.util.Scanner;

 // EXERCISE 1

class PositiveOrNegative{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);

		System.out.println("(Case 1)");
		System.out.print("Please input a number: ");
		Double doubleValue = input.nextDouble();

		if (doubleValue >= 0)
			{
				if (doubleValue == Math.floor(doubleValue)){
					long intValue = Math.floor(doubleValue);
					System.out.printf("%d is a positive, even number", intValue);
				}
				else
				{
					System.out.printf("%.1f is a positive, floating number", doubleValue);
				}
			}

		if (doubleValue < 0)
			{
				if (doubleValue == Math.floor(doubleValue)){
					long intValue = Math.floor(doubleValue);
					System.out.printf("%d is a negative, even number", intValue);
				}
				else
				{
					System.out.printf("%.1f is a negative, floating number", doubleValue);
				}
			}

		System.out.println("\n\n(Case 2)");
		System.out.print("Please input a number: ");
		doubleValue = input.nextDouble();


		if (doubleValue >= 0)
			{
				if (doubleValue == Math.floor(doubleValue)){
					long intValue = Math.floor(doubleValue);
					System.out.printf("%d is a positive, even number", intValue);
				}
				else
				{
					System.out.printf("%.1f is a positive, floating number", doubleValue);
				}
			}

		if (doubleValue < 0)
			{
				if (doubleValue == Math.floor(doubleValue)){
					long intValue = Math.floor(doubleValue);
					System.out.printf("%d is a negative, even number", intValue);
				}
				else
				{
					System.out.printf("%.1f is a negative, floating number", doubleValue);
				}
			}
	}
}