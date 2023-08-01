public class CPU {
    public String brand, cores, model;
    public int price;

    public CPU(String b, String c, String m, int p){
    	this.brand = b;
    	this.cores = c;
    	this.model = m;
    	this.price = p;
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
    
    public String getCores(){
        return cores;
    }
    
    public void setCores(String cores){
        this.cores = cores;
    }
    
    public int getPrice(){
        return price;
    }
    
    public void setPrice(int price){
        this.price = price;
    }
    
    public String toString(){
    	return "CPU | Brand: " + brand + " | Model: " + model + " | Cores: " + cores + " | Price: $" + price;
    }
}
