import java.util.Scanner;

class Projectile{
	
	private static final double G = 9.8;

	public static void main(String[] args){
		Scanner input = new Scanner(System.in);

		System.out.print("Enter projectile initial velocity: ");
		double initialVelocity = input.nextDouble();

		double maxHeight = calculateMaxHeight(initialVelocity);
		System.out.printf("Maximum Height: %.2f", maxHeight);
	}

	public static double calculateMaxHeight(double x){
		return (Math.pow(x, 2) / (2 * G));
	}
}