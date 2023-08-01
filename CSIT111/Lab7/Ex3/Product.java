class Product{
	private String name;
	private double price;
	private int scanCode;
	private static int numOfObjects = 0;

	public Product(String n, double p){
		numOfObjects++;
		name = n;
		price = p;

		scanCode = (1000+numOfObjects);
	}

	public String getName(){
		return name;
	}

	public int getScanCode(){
		return scanCode;
	}

	public double getPrice(){
		return price;
	}

	public void changePrice(double p){
		price = p;
	}

	public static int getNumOfObjects(){
		return numOfObjects;
	}
}

// You can't execute the program with "java Product", because Product.java doesn't include a 'main' method.  