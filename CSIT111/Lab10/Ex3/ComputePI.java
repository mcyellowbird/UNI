class ComputePI{
	public static void main(String[] args){
		double pi = 0.0;
		double sum = 1/3;

		for (int i = 3; i < 15; i = i + 2){
			sum += (1/i);
		}

		pi = 4*(1-sum);

		System.out.printf("Calculated Value: %.2f", pi);

		System.out.printf("\nCalculated Value: %.2f", Math.PI);

		System.out.printf("\nPercentage of Math.PI: %.2f", (Math.PI / pi * 100));

	}
}