public class Motherboard {
    public String socketType, brand, model;
    public int price;

    public Motherboard(String sT, String b, String m, int p){
    	this.socketType = sT;
    	this.brand = b;
    	this.model = m;
    	this.price = p;
    }

    public String getSocketType(){
        return socketType;
    }
    
    public void setSocketType(String socketType){
        this.socketType = socketType;
    }
    
    public String getBrand(){
        return brand;
    }
    
    public void setBrand(String brand){
        this.brand = brand;
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
    	return "Motherboard | Brand: " + brand + " | Model: " + model + " | Socket: " + socketType + " | Price: $" + price;
    }
}
