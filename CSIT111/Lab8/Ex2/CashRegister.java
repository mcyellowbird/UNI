class CashRegister{
	public int totalItems;
	public double totalPrice;

	public void updateTotalItems(){
		totalItems = totalItems + 1;
	}

	public void updateTotalPrice(double p){
		totalPrice = totalPrice + p;
	}
}