
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author fenghui
 */
public class Customer {
    private final String ID;
    private String name, gender, mobile, address;
    private ArrayList<Order> orders;
    
    public Customer(){
        this("","","","");
    }
    
    public Customer(String n, String g, String m, String a){ 
        this("C"+((int)(Math.random()*90000)+10000),n,g,m,a);
    }
    
    public Customer(String id, String n, String g, String m, String a){ 
        ID=id;
        name=n;
        gender=g;
        mobile=m;
        address=a;
        orders=new ArrayList<Order>(0);
    }
    
    public String getID(){
        return ID;
    }
     
    public String getName(){
        return name;
    }   
    
    public String getGender(){
        return gender;
    }
 
    public String getMobile(){
        return mobile;
    }
        
    public String getAddress(){
        return address;
    }
           
    public void setName(String n){
        name=n;
    }   
    
    public void setGender(String g){
        gender=g;
    }
 
    public void setMobile(String m){
        mobile=m;
    }
        
    public void setAddress(String a){
        address=a;
    }
    
    public ArrayList<Order> getOrders(){
        return orders;
    }
    
    public void addOrder(Order o){
        orders.add(o);
    }
    
    public void removeOrder(int i){
        if(i<orders.size())
            orders.remove(i);
    }
    
    public String toString(){
        String s="";
        s+= "Customer: "+getID()+"\t"+getName()+"\t"+getGender()+"\t"+getMobile()+"\t"+getAddress();
        
	return s;
    }
}
