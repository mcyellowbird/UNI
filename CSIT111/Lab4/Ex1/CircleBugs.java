public class CircleBugs{
	public static void main(String[] args){

		double r = Double.parseDouble(args[0]); // Previously, variable was declared as an 'int' when it needed to be a 'double'
		double t = Double.parseDouble(args[1]);
		
		System.out.println("r = " + r + ", t = " + t); // Added ';' to the end
		
		double c = 2 * Math.PI * r;
		double a = Math.PI * r * r;
		
		// cos() and sin() methods need radians inputs.
		double x = r * Math.cos(t); // Needed to reference the 'Math' class
		double y = r * Math.sin(t); // ^^^
		
		System.out.println("c = " + c );
		System.out.println("A = " + a ); // Changed 'A' to 'a'
		System.out.println("x = " + x + ", " + "y = " + y );
	}
}
