import java.util.Scanner; // Import Scanner

public class asciiConversion{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in); // Create Scanner object

		System.out.print("Enter a lowercase letter: "); // Prompt user

		char lowerCaseCharacter = input.next().charAt(0); // Get user input
		char upperCaseCharacter = 0; // Create variable for conversion

		while (true){ // Infinite loop so the user has to input a correct value (lowercase character)

			if (lowerCaseCharacter >= 97 && lowerCaseCharacter <= 122){ // Check if the user's input is a valid character (97 = a, 122 = z)
				int asciiValue = lowerCaseCharacter - 32; // Create int variable to convert (input character - 32) to its uppercase ascii value
				upperCaseCharacter = (char) asciiValue; // Assign converted value to 'upperCaseCharacter' variable
				break; // Exit 'while' loop
			}

			else{ // Otherwise user's input is invalid, repeat until user's input is valid
				System.out.print("Invalid, enter a lowercase letter: "); // Prompt user again
				lowerCaseCharacter = input.next().charAt(0); // Redo same code as above
				int asciiValue = lowerCaseCharacter - 32; // ^^^
				upperCaseCharacter = (char) asciiValue; // ^^^
			}
		}

		System.out.print("Uppercase conversion: " + upperCaseCharacter); // Print converted character
	}
}