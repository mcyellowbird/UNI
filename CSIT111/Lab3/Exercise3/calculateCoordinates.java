import static java.lang.Math.*;
import java.util.Scanner;

class calculateCoordinates
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in); // Creating the Scanner object

		System.out.print("Enter radius: ");
		double radius = input.nextDouble(); // Getting user input for radius

		System.out.print("Enter angle: ");
		double angle = input.nextDouble(); // Getting user input for angle

		double x = radius * cos(Math.toRadians(angle)); // Without Math.toRadians (converts degrees to radians), it gives me the incorrect result
		double y = radius * sin(Math.toRadians(angle));

		System.out.printf("Value x = %.1f%nValue y = %.1f", x, y); // Displaying results
	}
}