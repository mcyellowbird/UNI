import java.util.Random;

class FindSmallest{
	public static void main(String[] args){
		int[] intArray = new int [10];
		Random random = new Random();

		for (int i = 0; i < 10; i++){
			intArray[i] = random.nextInt(100 - 1) + 1;
			System.out.printf("Index %d: %d\n", i, intArray[i]);
		}

		int smallest = 1000, smallestIndex = 0;

		for (int j = 0; j < 10; j++){
			if (smallest > intArray[j]){
				smallest = intArray[j];
				smallestIndex = j;
			}
		}
		System.out.println("\nSmallest number: " + smallest);
		System.out.println("Smallest number's index: " + smallestIndex);
	}
}