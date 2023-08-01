import java.util.Random;

public class Customer {
    public static final String ID = "C" + (10000 + (int)(Math.random() * (99999 - 10000)));
    public String name, gender, phone, address;

    public Customer(String n, String g, String p, String a){
    	this.name = n;
    	this.gender = g;
    	this.phone = p;
    	this.address = a;
    }

    public String getID(){
    	return ID;
    }

    public String getName(){
        return name;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public String getGender(){
        return gender;
    }
    
    public void setGender(String gender){
        this.gender = gender;
    }
    
    public String getPhone(){
        return phone;
    }
    
    public void setPhone(String phone){
        this.phone = phone;
    }

    public String getAddress(){
        return address;
    }
    
    public void setAddress(String address){
        this.address = address;
    }
        
    public String toString(){
    	return "Customer: " + ID + " | " + name + " | " + gender + " | " + phone + " | " + address;
    }
}
