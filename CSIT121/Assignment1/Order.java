import java.util.ArrayList;

public class Order {
    public static final String ID = "O" + (10000 + (int)(Math.random() * (99999 - 10000)));
    public int totalPrice;
    public Customer customer;
    public ArrayList<Object> partsList = new ArrayList<Object>();

    public Order(int tP, Customer c, ArrayList<Object> pL){
    	this.totalPrice = tP;
    	this.customer = c;
    	this.partsList = pL;
    }
    public String getID(){
        return ID;
    }
    
    public int getTotalPrice(){
        return totalPrice;
    }
    
    public void setTotalPrice(int totalPrice){
        this.totalPrice = totalPrice;
    }
    
    public Customer getCustomer(){
        return customer;
    }
    
    public void setCustomer(Customer customer){
        this.customer = customer;
    }
    
    public ArrayList<Object> getPartsList(){
        return partsList;
    }
    
    public void setPartsList(ArrayList<Object> partsList){
        this.partsList = partsList;
    } 
    
    public String toString(){
        String partsString = "Product List:\n";

        for (int i = 0; i <  partsList.size(); i++){
            partsString += partsList.get(i).toString();
            partsString += "\n";
        }

    	return "\nHere is the summary of your order:" +
    	       "\nOrder: " + ID + " | " + "Total Price: $" + totalPrice + 
    	       "\n" + customer.toString() +
               "\n\n" + partsString;
    }
}
