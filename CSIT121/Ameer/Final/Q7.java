import java.util.Scanner;

public class Q7 {
    public static void main(String args[]){
        // Input Scanner
        Scanner input = new Scanner(System.in);
    
        // Nested Try & Catch for error
        try {
            // Get user input
            System.out.print("Enter a number: ");
            int num = input.nextInt();
    
            // Throw exception if negative input
            if (num < 0){
                throw new InputException("Value cannot be negative");
            }
    
            // Throw exception if input is over 45
            if (num > 45){
                throw new InputException("Please enter a value between 0 and 45");
            }
        } catch (InputException e){
            System.out.println(e);
        } finally {
            System.out.println("Continuation of uninterupted program");
            System.out.println("Program continues smoothly");
        }
    }
}

class InputException extends Exception {
    public InputException(String error){
        super(error);
        System.out.println("My Exception was thrown and handled");
    }
}