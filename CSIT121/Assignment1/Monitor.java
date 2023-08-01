public class Monitor {
    public String brand, model;
    public int size, price;

    public Monitor(String b, int s, String m, int p){
    	this.brand = b;
    	this.model = m;
    	this.size = s;
    	this.price = p;
    }
    
    public String getBrand(){
        return brand;
    }
    
    public void setBrand(String brand){
        this.brand = brand;
    }

    public int getSize(){
        return size;
    }
    
    public void setSize(int size){
        this.size = size;
    }
        
    public String getModel(){
        return model;
    }
    
    public void setModel(String model){
        this.model = model;
    }
    
    public int getPrice(){
        return price;
    }
    
    public void setPrice(int price){
        this.price = price;
    }
    
    public String toString(){
    	return "Monitor | Brand: " + brand + " | Model: " + model + " | Size: " + size + " | Price: $" + price;
    }
}
