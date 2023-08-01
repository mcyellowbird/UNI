/*------------------------------------------------------
Name: Idries Eagle-Masuak
Subject Code: CSIT111
Student number: 6868228
Email address: idrieseaglemasuak@gmail.com (Personal) | iem651@uowmail.edu.au (UOW)
Assignment number: 2
-------------------------------------------------------*/

import java.util.Scanner;

class OprWithComplexNumbers{
	// Class Variables
	private ComplexNumber resSum = new ComplexNumber(0.0, 0.0); // Declare resSum as a ComplexNumber
	private ComplexNumber resDifference = new ComplexNumber(0.0, 0.0); // Declare resDifference as a ComplexNumber
	private ComplexNumber resProduct = new ComplexNumber(0.0, 0.0); // Declare resProduct as a ComplexNumber
	private static OprWithComplexNumbers opr = new OprWithComplexNumbers(); // Declare opr as a static oprect of this class

	public static void main(String[] args){
		Scanner input = new Scanner(System.in); // Create the Scanner oprect

		System.out.println("--- Basic arithmetic operations with complex numbers ---");

		System.out.print("Enter the first complex number in the format r i: "); // Prompt user
		ComplexNumber c1 = new ComplexNumber(input.nextDouble(), input.nextDouble()); // Get user input for first ComplexNumber
		//c1.real = input.nextDouble();
		//c1.imaginary = input.nextDouble();

		System.out.print("Enter the second complex number in the format r i: "); // Prompt user
		ComplexNumber c2 = new ComplexNumber(input.nextDouble(), input.nextDouble()); // Get user input for second ComplexNumber

		opr.calculateResults(c1, c2); // Parse inputted ComplexNumbers to method for calculation
	}

	public void calculateResults(ComplexNumber c1, ComplexNumber c2){
		Calculator calc = new Calculator(c1, c2); // Create an oprect for the Calculator class and copy parsed values
		
		opr.resSum = calc.addTwoNumbers(); // Calculate addition based on parsed values
		opr.resDifference = calc.subTwoNumbers(); // Calculate subtraction based on parsed values
		opr.resProduct = calc.mulTwoNumbers(); // Calculate multiplication based on parsed values

		opr.displayResults(c1, c2); // Parse values to be displayed
	}

	public void displayResults(ComplexNumber c1, ComplexNumber c2){ // Display calculated values for addition, subtraction and multiplication
		System.out.printf("(%.1f, %.1f) + (%.1f, %.1f) = (%.1f, %.1f)\n", c1.real, c1.imaginary, c2.real, c2.imaginary, opr.resSum.real, opr.resSum.imaginary);
		System.out.printf("(%.1f, %.1f) - (%.1f, %.1f) = (%.1f, %.1f)\n", c1.real, c1.imaginary, c2.real, c2.imaginary, opr.resDifference.real, opr.resDifference.imaginary);
		System.out.printf("(%.1f, %.1f) * (%.1f, %.1f) = (%.1f, %.1f)\n", c1.real, c1.imaginary, c2.real, c2.imaginary, opr.resProduct.real, opr.resProduct.imaginary);
	}
}

class Calculator{
	private ComplexNumber compNum1; // Declare variable for the first ComplexNumber to be calculated 
	private ComplexNumber compNum2; // Declare variable for the second ComplexNumber to be calculated

	public Calculator(ComplexNumber c1, ComplexNumber c2){
		this.compNum1 = c1; // Set the value of this class's variable to the values inputted by the user
		this.compNum2 = c2; // Set the value of this class's variable to the values inputted by the user
	}

	public ComplexNumber addTwoNumbers(){
		ComplexNumber sum = new ComplexNumber(0.0, 0.0); // Create a temporary variable to be returned
		sum.real = compNum1.real + compNum2.real; // Add the first and the second ComplexNumber's 'real' values together
		sum.imaginary = compNum1.imaginary + compNum2.imaginary; // Add the first and the second ComplexNumber's 'imaginary' values together
		return (sum); // Return sum
	}

	public ComplexNumber subTwoNumbers(){
		ComplexNumber diff = new ComplexNumber(0.0, 0.0); // Create a temporary variable to be returned
		diff.real = compNum1.real - compNum2.real; // Subtract the first from the second ComplexNumber's 'real' value
		diff.imaginary = compNum1.imaginary - compNum2.imaginary; // Subtract the first from the second ComplexNumber's 'real' value
		return (diff); // Return difference
	}

	public ComplexNumber mulTwoNumbers(){
		ComplexNumber prod = new ComplexNumber(0.0, 0.0); // Create a temporary variable to be returned
		prod.real = (compNum1.real * compNum2.real) - (compNum1.imaginary * compNum2.imaginary); // Multiply the first and the second ComplexNumber's 'real' values
		prod.imaginary = (compNum1.real * compNum2.imaginary) + (compNum1.imaginary * compNum2.real); // Multiply the first and the second ComplexNumber's 'real' value
		return (prod); // Return product
	}
}

class ComplexNumber{
	public double real; // Declare variable to hold the 'real' value
	public double imaginary; // Declare variable to hold the 'imaginary' value

	public ComplexNumber(double r, double i){
		this.real = r; // Set oprect value to new value
		this.imaginary = i; // Set oprect value to new value
	}
}