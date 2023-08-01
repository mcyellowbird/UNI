class CheckOut{
	public static void main(String[] args){

		System.out.println("***** At Register 1 *****");
		// Create first register
		CashRegister register1 = new CashRegister();

		// Create Milk Product, update total items in the register, update total price of items in the register
		Product milk = new Product("Milk", 2.99);
		register1.updateTotalItems();
		register1.updateTotalPrice(milk.getPrice());

		// Create Apple Product, update total items in the register, update total price of items in the register
		Product apple = new Product("Apple", 5.49);
		register1.updateTotalItems();
		register1.updateTotalPrice(apple.getPrice());

		// Create Bread Product, update total items in the register, update total price of items in the register
		Product bread = new Product("Bread", 1.75);
		register1.updateTotalItems();
		register1.updateTotalPrice(bread.getPrice());

		// Display total items and price in the register
		System.out.printf("You have purchased %s items", register1.totalItems);
		System.out.printf("\nTotal: $%s", register1.totalPrice);

		// Create second Apple Product, update total items in the register, update total price of items in the register
		register1.updateTotalItems();
		register1.updateTotalPrice(apple.getPrice());

		// Display new total items and price in the register
		System.out.printf("\nYou have purchased %s items", register1.totalItems);
		System.out.printf("\nTotal: $%s", register1.totalPrice);

		// Create second register
		System.out.println("\n\n***** At Register 2 *****");
		CashRegister register2 = new CashRegister();
		// Create Milk Product, update total items in the register, update total price of items in the register
		register2.updateTotalItems();
		register2.updateTotalPrice(milk.getPrice());

		// Create Bread Product, update total items in the register, update total price of items in the register
		register2.updateTotalItems();
		register2.updateTotalPrice(bread.getPrice());

		// Display total items and price in the second register
		System.out.printf("You have purchased %s items", register2.totalItems);
		System.out.printf("\nTotal: $%s", register2.totalPrice);
	}
}