import static java.lang.System.*;
import java.util.Scanner;

class milesToKM{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);

		double distInMiles, distInKilom;
		final double COEFF = 1.609;

		out.print("Distance in Miles: ");
		distInMiles = input.nextDouble();

		distInKilom = COEFF * distInMiles;
		out.printf("%.2f miles = %.2f km \n ", distInMiles, distInKilom);

		input.close();
	}
}