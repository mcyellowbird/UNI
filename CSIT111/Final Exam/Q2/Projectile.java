import java.util.Scanner;

class Projectile{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);

		System.out.print("Input projectile initial velocity: ");

		double vo = input.nextInt();

		System.out.printf("Maximum height: %.1f", Trajectory.calculateMaxHeight(vo));
	}
}

class Trajectory{
	private static final double G = 9.8;

	public static double calculateMaxHeight(double vo){
		double hMax = (vo * 2) / (2 * G);
		return hMax;
	}
}
