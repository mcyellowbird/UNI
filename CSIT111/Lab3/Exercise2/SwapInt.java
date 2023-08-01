class SwapInt
{
	public static void main(String[] args)
	{
		// Use the command line arguments to get two integer numbers from the user
		int a = Integer.parseInt(args[0]);
		int b = Integer.parseInt(args[1]);

		System.out.println("Before swapping: " + "a = " + a + ", b = " + b);

		int temp = a;
		a = b;
		b = temp;
		
		System.out.println("After swapping: " + "a = " + a + ", b = " + b);
	}
}