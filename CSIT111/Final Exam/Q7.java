class Q7{
	public static void main(String[] args){
		double value = 9;

		System.out.printf(" * |");

		String lineBreak = "";

		for (int i = 1; i <= value; i++){
			System.out.printf("%2d ", i);
		}

		for (int l = 0; l <= value; l++){
			lineBreak += "---";
		}

		int[] mult = new int[9];

		System.out.print("\n"+lineBreak);
		for (int j = 1; j <= value; j++){
			System.out.printf("\n%2d |", j);

			for (int k = 1; k <= value; k++){
				mult[k-1] = j * k;
			}

			for (int l = 0; l < mult.length; l++){
				System.out.printf("%2d ", mult[l]);
			}
		}
	}
}