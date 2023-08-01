
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
public class Order {
    private final String ID;
    private ArrayList<ComputerPart> parts;
    private double tPrice;
    
    public Order(){
        ID="O"+((int)(Math.random()*90000)+10000);
        
        tPrice=0;
        
        parts=new ArrayList<ComputerPart>(0);
    }
    
        
    public String getID(){
        return ID;
    }  
    
    public ArrayList<ComputerPart> getComputerParts(){
        return parts;
    }
 
    public void addComputerPart(ComputerPart cp){
        if(!parts.contains(cp)){ 
            parts.add(cp);
            tPrice=tPrice+cp.getPrice();
        }
    }
    
    public void removeComputerPart(int i){
        if(i<=parts.size()){
            tPrice-=parts.get(i).getPrice();
            parts.remove(i);
        }
    }
        
    public double getTotalPrice(){
        return tPrice;
    }   
    
    public String toString(){
        String s="";
        
        /*
        if(getCustomer() instanceof MemberCustomer){
            MemberCustomer mc=(MemberCustomer)getCustomer();
            double dis=getTotalPrice()*mc.getDiscount();
            s+= "Order: "+getID()+"\t"+"Total Price: $"+(getTotalPrice()-dis)+"\t"+"Discount: $"+dis+"\n";
        }else{
            s+= "Order: "+getID()+"\t"+"Total Price: $"+getTotalPrice()+"\n";
        }*/
        
        for(int i=0;i<parts.size();i++){
            s+=i+"\t"+parts.get(i);
            
            String ip="";
            
            for(int j=0;j<parts.size();j++){
                if(!parts.get(i).isCompatible(parts.get(j)))
                    ip+=parts.get(j).getID()+", ";
            }
            
            if (!ip.equals(""))
                ip="\t"+"Not compatible with: "+ip+"\n";
            else
                ip="\n";
            
            s+=ip;
        }
        
        s+= "Order: "+getID()+"\t"+"Total Price: $"+getTotalPrice()+"\n";

	return s;
    }
            
}
