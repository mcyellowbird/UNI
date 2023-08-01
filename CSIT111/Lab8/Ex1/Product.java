class Product{
	private String name;
	private double price;
	private int productID;
	private static int total;

	public Product(String n, double p){
		total++;
		productID = total;
		name = n;
		price = p;
	}

	public String getName(){
		return name;
	}

	public int getProductID(){
		return productID;
	}

	public double getPrice(){
		return price;
	}

	public void changePrice(Double p){
		price = p;
	}

	public static int getTotal(){
		return total;
	}
}