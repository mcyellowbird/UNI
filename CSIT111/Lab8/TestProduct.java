public class TestProduct {
	public static void main(String[] args) {

		Product p1 = new Product("Milk", 2.5);
		Product p2 = new Product("Apple", 6);		
		// Display all product info
		System.out.println("***** You have " + Product.getTotal() + " products now.");
		System.out.println("You have " + p1.getName() + "(ID="+ p1.getProductID() +"). Its price is $"+ String.format("%.2f", p1.getPrice()));
		System.out.println("You have " + p2.getName() + "(ID="+ p2.getProductID() +"). Its price is $"+ String.format("%.2f", p2.getPrice()));
		
		Product p3 = new Product("Bread", 1.5);
		// Display all product info
		System.out.println("***** You have " + Product.getTotal() + " products now.");
		System.out.println("You have " + p1.getName() + "(ID="+ p1.getProductID() +"). Its price is $"+ String.format("%.2f", p1.getPrice()));
		System.out.println("You have " + p2.getName() + "(ID="+ p2.getProductID() +"). Its price is $"+ String.format("%.2f", p2.getPrice()));
		System.out.println("You have " + p3.getName() + "(ID="+ p3.getProductID() +"). Its price is $"+ String.format("%.2f", p3.getPrice()));
		
		// Change the price of Apple
		p2.changePrice(5.99);
		
		// Display all product info
		System.out.println("***** You have " + Product.getTotal() + " products now.");
		System.out.println("You have " + p1.getName() + "(ID="+ p1.getProductID() +"). Its price is $"+ String.format("%.2f", p1.getPrice()));
		System.out.println("You have " + p2.getName() + "(ID="+ p2.getProductID() +"). Its price is $"+ String.format("%.2f", p2.getPrice()));
		System.out.println("You have " + p3.getName() + "(ID="+ p3.getProductID() +"). Its price is $"+ String.format("%.2f", p3.getPrice()));
	}
}
