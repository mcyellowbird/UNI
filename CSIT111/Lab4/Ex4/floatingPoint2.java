class floatingPoint2{
	public static void main(String[] args){

		double nA = Double.parseDouble(args[0]);
		double nB = Math.exp(nA);

		System.out.println("Value of nB: " + (int) nB);
	}
}