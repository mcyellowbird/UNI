import java.util.Scanner; import java.util.ArrayList;

class FindBiggest{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);

		ArrayList<Integer> intArray = new ArrayList<Integer>();
		int newVal = 0, biggest = 0, biggestIndex = 0;

		do {
			System.out.print("Input an integer number (Enter '0' to find biggest): ");
			newVal = input.nextInt();
			if (newVal != 0){
				intArray.add(newVal);
			}
		} while (newVal != 0);

		System.out.println("\n~~~~~~~~~~~\n");

		for (int i = 0; i < intArray.size(); i++){
			System.out.printf("Index %d: %d\n", i, intArray.get(i));
		}

		for (int j = 0; j < intArray.size(); j++){
			if (biggest < intArray.get(j) || biggest == 0){
				biggest = intArray.get(j);
				biggestIndex = j;
			}
		}

		System.out.println("\nBiggest: " + biggest);
		System.out.println("Biggest Index: " + biggestIndex);
	}
}