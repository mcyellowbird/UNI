import java.util.Scanner;

class Projectile{
	
	private final double G = 9.8;

	public static void main(String[] args){
		Scanner input = new Scanner(System.in);

		System.out.print("Enter projectile initial velocity: ");
		double initialVelocity = input.nextDouble();

		Projectile prj = new Projectile();

		double maxHeight = prj.calculateMaxHeight(initialVelocity);
		System.out.printf("Maximum Height: %.2f", maxHeight);
	}

	public double calculateMaxHeight(double x){
		return (Math.pow(x, 2) / (2 * G));
	}
}