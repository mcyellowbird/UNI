class DataType{
	public static void main(String[] args){
		int num1 = 4, num2 = 6;

		Calculation calc = new Calculation();

		int num3 = calc.calcInt(num1, num2);

		System.out.println("a + b = " + num3);
	}
}

class Calculation{
	public int calcInt(int x, int y){
		return x + y;
	}
}