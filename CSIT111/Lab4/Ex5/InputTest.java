import java.util.Scanner;
class InputTest
	{
	public static void main( String[] args )
	{
		 Scanner keyboard = new Scanner(System.in);

		 System.out.print("Enter a double: ");
		 double db = keyboard.nextDouble();
		 keyboard.nextLine(); // Here is the fix
		 System.out.println("Input was: " + db);

		 System.out.print("Enter an integer: ");
		 int ia = keyboard.nextInt();
		 System.out.println("Input was: " + ia);
		}
}

// The program doesn't remove any blank spaces so by adding 'keyboard.nextLine()', it removes the blank space, takes in the correct values, and runs as intended