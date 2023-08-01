class PassByReference{
	public static int num1 = 5, num2 = 10;

	public static void main(String[] args){

		System.out.println("Numbers before swap: x = " + num1 + " & y = " + num2);

		swap(num1, num2);

		System.out.println("Numbers after swap: x = " + num1 + " & y = " + num2);
	}

	public static void swap(int n1, int n2){
		int temp = n1;
		num1 = n2;
		num2 = temp;
	}
}