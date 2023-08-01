import java.util.Scanner;

class TimeTable{
	public static void main(String[] args){
		// Create Scanner object
		Scanner input = new Scanner(System.in);

		double value;

		do{ // Error check
			// Get user input
			System.out.print("Please input a positive integer number N: ");
			value = input.nextDouble();
		} while (value < 0 || value != Math.round(value));

		System.out.printf("\n  * |");

		String lineBreak = "";

		for (int i = 1; i <= value; i++){
			System.out.printf("%3d ", i);
		}

		for (int l = 0; l <= value; l++){
			lineBreak += "----";
		}

		System.out.print("\n"+lineBreak);
		for (int j = 1; j <= value; j++){
			System.out.printf("\n%3d |", j);
			for (int k = 1; k <= value; k++){
				System.out.printf("%3d ", j*k);
			}
		}
	}
}