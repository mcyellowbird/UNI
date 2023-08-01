/*------------------------------------------------------
Name: Idries
Student number: 6868228
Email address: idrieseaglemasuak@gmail.com (Personal) | iem651@uowmail.edu.au (UOW)
Subject Code: CSIT111
Assignment number: 1
-------------------------------------------------------*/

import java.util.Scanner;

class KineticEnergy{

	// Constant Variables
	private static final double density = 7.8; // Iron Ball's density 

	public static void main(String[] args){
		
		// Create 'input' Scanner object
		Scanner input = new Scanner(System.in); // Instantiate the Scanner object and assign it to a variable

		System.out.println("*** Kinetic energy calculation ***\n"); // Print intro text

		// Get Inputs
		System.out.print(" - Radius of the ball (m): ");
		double radius = input.nextDouble(); // Create variable 'radius', and assign a value based on the user's input
		System.out.print(" - Linear velocity of the ball (m/s): ");
		double linearVelocity = input.nextDouble(); // Create variable 'linearVeloity', and assign a value based on the user's input

		// Assign variables and do math
		double mass = 4.0/3 * Math.PI * (Math.pow(radius, 3)) * density; // Calculate Mass | m = 4/3 * π * r^3 * p
		double inertia = 0.4 * mass * Math.pow(radius, 2); // Calculate Inertia | I = 0.4*m*r2
		double angularVelocity = linearVelocity / radius; // Calculate Angular Velocity | ω = v / r
		double angularKineticEnergy = 0.5 * inertia * Math.pow(angularVelocity, 2); // Calculate Angular Kinetic Energy | Ka = ½* I* ω^2
		double linearKineticEnergy = 0.5 * mass * Math.pow(linearVelocity, 2); // Calculate Linear Kinetic Energy | Kl = ½ * m * v^2
		double totalKineticEnergy = linearKineticEnergy + angularKineticEnergy; // Calculate Total Kinetic Energy | Kt = Kl + Ka

		// Display Outputs
		System.out.printf("The total kinetic energy is %.2f (J)\n", totalKineticEnergy); // Display Total Kinetic Energy with 2 decimal points
		System.out.println("The program has terminated");

		// Expected Output:

		// *** Kinetic energy calculation ***
		// Enter the following parameters
		//  - Radius of the ball (m): 1.0
		//  - Linear velocity of the ball (m/s): 1.0
		// The total kinetic energy is 22.87 (J)
		// The program has terminated

		// References for math:

		// totalKineticEnergy = linearKineticEnergy + angularKineticEnergy
		// linearKineticEnergy = ½ * mass * velocity^2
		// angularKineticEnergy = ½ * inertia * angularVelocity^2
		// angularVelocity = linearVelocity / radius

		// inertia = 0.4 * mass * radius^2
		// mass = 4/3 * π * r^3 * density
	}
}

