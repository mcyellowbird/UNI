/*------------------------------------------------------
My name: Idries Eagle-Masuak
My student number: 6868288
My course code: CSIT121
My email address: idrieseaglemasuak@gmail.com | iem651@uowmail.edu.au
Assignment number: 1
-------------------------------------------------------*/


import java.util.Scanner; import java.util.ArrayList;

public class OrderingSystem {

    public static void main(String[] args){
		ArrayList<Order> orderList = new ArrayList<Order>();
		ArrayList<Customer> customerList = new ArrayList<Customer>();
		ArrayList<CPU> cpuList = new ArrayList<CPU>();
		ArrayList<Motherboard> motherboardList = new ArrayList<Motherboard>();
		ArrayList<Memory> memoryList = new ArrayList<Memory>();
		ArrayList<GraphicsCard> graphicsCardList = new ArrayList<GraphicsCard>();
		ArrayList<Monitor> monitorList = new ArrayList<Monitor>();

    	cpuList.add(new CPU("Intel", "i5", "9600K", 323));
    	cpuList.add(new CPU("Intel", "i7", "9700K", 462));
    	cpuList.add(new CPU("Intel", "i7", "9700F", 396));
    	cpuList.add(new CPU("Intel", "i9", "9900K", 591));
    	cpuList.add(new CPU("AMD", "4", "Ryzen 2200", 200));
    	cpuList.add(new CPU("AMD", "6", "Ryzen 3600", 310));
    	cpuList.add(new CPU("AMD", "8", "Ryzen 3700", 489));
    	cpuList.add(new CPU("AMD", "8", "Ryzen 5800", 669));

    	motherboardList.add(new Motherboard("Intel", "Gigabyte", "H81M-DS2", 129));
    	motherboardList.add(new Motherboard("Intel", "Asus", "J40051-C", 169));
    	motherboardList.add(new Motherboard("Intel", "MSI", "MGP-2390", 225));
    	motherboardList.add(new Motherboard("Intel", "Gigabyte", "Z490", 471));
    	motherboardList.add(new Motherboard("AMD", "Gigabyte", "B-450", 117));
    	motherboardList.add(new Motherboard("AMD", "Asus", "A320I", 128));
    	motherboardList.add(new Motherboard("AMD", "MSI", "B450", 232));
    	motherboardList.add(new Motherboard("AMD", "Gigabyte", "X570S", 679));

    	memoryList.add(new Memory("DDR3", "Kingston", "8G", "KCP316ND8", 116));
    	memoryList.add(new Memory("DDR3", "ADATA", "16G", "AX4U360038G18", 189));
    	memoryList.add(new Memory("DDR3", "G.Skill", "8G", "F3-10666CL9D", 96));
    	memoryList.add(new Memory("DDR4", "Kingston", "8G", "KCP426SS8", 93));
    	memoryList.add(new Memory("DDR4", "G.Skill", "16G", "F4-2666C18S", 158));
    	memoryList.add(new Memory("DDR4", "Crucial", "32G", "CT32G4SFD832A", 259));

    	graphicsCardList.add(new GraphicsCard("NVIDIA", "Gigabyte", "GeForce RTX 3070", 1999));
    	graphicsCardList.add(new GraphicsCard("NVIDIA", "Asus", "GeForce RTX 3070", 1899));
    	graphicsCardList.add(new GraphicsCard("NVIDIA", "MSI", "GeForce RTX 3080", 3099));
    	graphicsCardList.add(new GraphicsCard("AMD", "Gigabyte", "Radeon RX 6900", 3699));
    	graphicsCardList.add(new GraphicsCard("AMD", "Asus", "Radeon RX 6900", 3199));
    	graphicsCardList.add(new GraphicsCard("AMD", "MSI", "Radeon RX 6900", 2699));

    	monitorList.add(new Monitor("Acer", 24, "K242HYLB", 194));
    	monitorList.add(new Monitor("LG", 32, "32QN600", 506));
    	monitorList.add(new Monitor("Asus", 16, "MB16ACZ", 429));
    	monitorList.add(new Monitor("MSI", 27, "MP271QP", 399));
    	monitorList.add(new Monitor("BenQ", 32, "PD3200Q", 653));
    	monitorList.add(new Monitor("Philips", 27, "272M8CZ", 289));

    	Scanner input = new Scanner(System.in);

    	System.out.println("Welcome to our computer shop");
    	System.out.print("Enter your customer ID if you have one (If not, press enter): ");
    	String custID = input.nextLine();

    	if (custID.toString() == "" || !customerList.contains(custID)){
	    	System.out.print("Name: ");
	    	String name = input.nextLine();
	    	System.out.print("Gender: ");
	    	String gender = input.nextLine();
	    	System.out.print("Contact Number: ");
	    	String phone = input.nextLine();
	    	System.out.print("Delivery Address: ");
	    	String address = input.nextLine();

	    	customerList.add(new Customer(name, gender, phone, address));
	    	custID = customerList.get(customerList.size()-1).getID();
    	}

    	ArrayList<Object> partsList = new ArrayList<Object>();
    	int totalPrice = 0;

    	int option = 1;
    	do{
	    	System.out.println("\nPlease make a selection from the following:");
	    	System.out.println("1: Select a CPU");
	    	System.out.println("2: Select a Motherboard");
	    	System.out.println("3: Select Memory");
	    	System.out.println("4: Select a Graphics Card");
	    	System.out.println("5: Select a Monitor");
	    	System.out.println("6: View/Modify the order");
	    	System.out.println("7: Submit the order");
	    	System.out.println("8: Cancel order and Exit");
	    	System.out.print("\nSelection: ");
	    	option = input.nextInt();

	    	if (option == 1){
	    		System.out.println("\nWe offer the following CPU products:");
	    		for (int i = 0; i < cpuList.size(); i++){
	    			System.out.printf("(%d): %s", i, cpuList.get(i).toString());
	    			System.out.println("");
	    		}

	    		System.out.printf("Please select a CPU (-1 for no purchase): ");
	    		int selection = input.nextInt();

	    		if (selection >= 0 && selection < cpuList.size()){
	    			partsList.add(cpuList.get(selection));
	    			totalPrice += cpuList.get(selection).getPrice();
	    		}
	    		else if (selection == -1){
	    			System.out.println("No product added");
	    		}
	    		else{
	    			System.out.println("Error: Pick a valid option");
	    		}

	    	}

	    	else if (option == 2){
	    		System.out.println("\nWe offer the following Motherboard products:");
	    		for (int i = 0; i < motherboardList.size(); i++){
	    			System.out.printf("(%d): %s", i, motherboardList.get(i).toString());
	    			System.out.println("");
	    		}

	    		System.out.printf("Please select a Motherboard (-1 for no purchase): ");
	    		int selection = input.nextInt();

	    		if (selection >= 0 && selection < motherboardList.size()){
	    			partsList.add(motherboardList.get(selection));
	    			totalPrice += motherboardList.get(selection).getPrice();
	    		}
	    		else if (selection == -1){
	    			System.out.println("No product added");
	    		}
	    		else{
	    			System.out.println("Error: Pick a valid option");
	    		}
	    	}

	    	else if (option == 3){
	    		System.out.println("\nWe offer the following Memory products:");
	    		for (int i = 0; i < memoryList.size(); i++){
	    			System.out.printf("(%d): %s", i, memoryList.get(i).toString());
	    			System.out.println("");
	    		}

	    		System.out.printf("Please select a Memory (-1 for no purchase): ");
	    		int selection = input.nextInt();

	    		if (selection >= 0 && selection < memoryList.size()){
	    			partsList.add(memoryList.get(selection));
	    			totalPrice += memoryList.get(selection).getPrice();
	    		}
	    		else if (selection == -1){
	    			System.out.println("No product added");
	    		}
	    		else{
	    			System.out.println("Error: Pick a valid option");
	    		}
	    	}

	    	else if (option == 4){
	    		System.out.println("\nWe offer the following Graphics Card products:");
	    		for (int i = 0; i < graphicsCardList.size(); i++){
	    			System.out.printf("(%d): %s", i, graphicsCardList.get(i).toString());
	    			System.out.println("");
	    		}

	    		System.out.printf("Please select a Graphics Card (-1 for no purchase): ");
	    		int selection = input.nextInt();

	    		if (selection >= 0 && selection < graphicsCardList.size()){
	    			partsList.add(graphicsCardList.get(selection));
	    			totalPrice += graphicsCardList.get(selection).getPrice();
	    		}
	    		else if (selection == -1){
	    			System.out.println("No product added");
	    		}
	    		else{
	    			System.out.println("Error: Pick a valid option");
	    		}
	    	}

	    	else if (option == 5){
	    		System.out.println("\nWe offer the following Monitor products:");
	    		for (int i = 0; i < monitorList.size(); i++){
	    			System.out.printf("(%d): %s", i, monitorList.get(i).toString());
	    			System.out.println("");
	    		}

	    		System.out.printf("Please select a Monitor (-1 for no purchase): ");
	    		int selection = input.nextInt();

	    		if (selection >= 0 && selection < monitorList.size()){
	    			partsList.add(monitorList.get(selection));
	    			totalPrice += monitorList.get(selection).getPrice();
	    		}
	    		else if (selection == -1){
	    			System.out.println("No product added");
	    		}
	    		else{
	    			System.out.println("Error: Pick a valid option");
	    		}
	    	}

	    	else if (option == 6){
	    		for (int i = 0; i < partsList.size(); i++){
	    			System.out.printf("(%d): %s\n", i, partsList.get(i).toString());
	    		}
	    		System.out.println("Total Price: $" + totalPrice);

	    		System.out.print("\nMake a selection to remove a product (-1 for no removal): ");
		    	int selection = input.nextInt();

		    	if (selection >= 0 && selection < partsList.size() && partsList.size() > 0){
		    		if (partsList.get(selection) instanceof CPU){
		    			totalPrice -= (((CPU)partsList.get(selection)).getPrice());
		    		}
		    		else if (partsList.get(selection) instanceof Motherboard){
		    			totalPrice -= (((Motherboard)partsList.get(selection)).getPrice());
		    		}
		    		else if (partsList.get(selection) instanceof Memory){
		    			totalPrice -= (((Memory)partsList.get(selection)).getPrice());
		    		}
		    		else if (partsList.get(selection) instanceof GraphicsCard){
		    			totalPrice -= (((GraphicsCard)partsList.get(selection)).getPrice());
		    		}
		    		else if (partsList.get(selection) instanceof Monitor){
		    			totalPrice -= (((Monitor)partsList.get(selection)).getPrice());
		    		}
		    		partsList.remove(selection);
		    		System.out.println("Removed product at index " + selection);
		    	}

	    		else if (selection == -1){
	    			System.out.println("No product removed");
	    		}

	    		else{
		    		System.out.println("Error: Pick a valid option");
	    		}

	    	}

	    	else if (option == 7){
	    		if (totalPrice > 0){

	    		int customerIndex = 0;

	    		for (int i=0; i < customerList.size();i++ ) {
	    			if (customerList.get(i).getID().equals(custID)){
	    				customerIndex = i;
	    			}
	    		}

	    		orderList.add(new Order(totalPrice, customerList.get(customerIndex), partsList));
	    		System.out.println(orderList.get(orderList.size()-1).toString());
	    		System.out.printf("Order %s has been placed. Thank you for your purchase :)", orderList.get(orderList.size()-1).getID());
	    		break;
	    		}
	    		else{
	    			System.out.println("Error: Total order price must be greater than $0 to place an order");
	    		}
	    	}

	    	else if (option == 8){
    			System.out.println("Order cancelled.");
	    	}

	    	else if (option < 1 && option > 8){
	    		System.out.println("\nError: Pick a valid option");
	    	}
	    	option = 0;
    	}
    	while (option != 8);
    }
}
