class PassByValue{
	public static void main(String[] args){
		int num1 = 5, num2 = 10;

		System.out.println("Numbers before swap: x = " + num1 + " & y = " + num2);

		swap(num1, num2);

		System.out.println("Numbers after swap: x = " + num1 + " & y = " + num2);
	}

	public static void swap(int num1, int num2){
		int temp = num1;
		num1 = num2;
		num2 = temp;
	}
}