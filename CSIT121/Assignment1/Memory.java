public class Memory {
    public String type, brand, size, model;
    public int price;

    public Memory(String t, String b, String s, String m, int p){
    	this.type = t;
    	this.brand = b;
    	this.size = s;
    	this.model = m;
    	this.price = p;
    }

    public String getType(){
        return type;
    }
    
    public void setType(String type){
        this.type = type;
    }
    
    public String getBrand(){
        return brand;
    }
    
    public void setBrand(String brand){
        this.brand = brand;
    }

    public String getSize(){
        return size;
    }
    
    public void setSize(String size){
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
    	return "Memory | Brand: " + brand + " | Model: " + model + " | Type: " + type + " | Size: " + size + " | Price: $" + price;
    }
}
