import java.util.Scanner;

 // EXERCISE 2

class CheckPassFail{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);

		System.out.print("Input a mark: ");
		Double mark = input.nextDouble();

		if (mark >= 50)
		{
			System.out.println("PASS");
		}
		else
		{
			System.out.println("FAIL");
		}

		System.out.println("DONE");
	}
}