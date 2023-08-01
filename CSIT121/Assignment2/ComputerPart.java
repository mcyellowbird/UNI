/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author fenghui
 */
public abstract class ComputerPart implements Compatible{
    private final String ID, BRAND, MODEL;
    private double price;
    
    public ComputerPart(){
        this("","","",0);
    }
    
    public ComputerPart(String prefix, String b, String m, double p){
        ID=prefix+Integer.toString((int)(Math.random()*90000)+10000);
        BRAND=b;
        MODEL=m;
        price=p;
    }
    
    public ComputerPart(ComputerPart cp){
        ID=cp.ID;
        BRAND=cp.BRAND;
        MODEL=cp.MODEL;
        price=cp.price;
    }
    
    public String getID(){
        return ID;
    }
       
    public String getBrand(){
        return BRAND;
    }
    
    public String getModel(){
        return MODEL;
    }
    
    public double getPrice(){
        return price;
    }
    
    public void setPrice(int p){
        price=p;
    }
    
    public String toString(){
        return getID()+"\t"+getBrand()+"\t"+getModel()+"\t"+"$"+getPrice();
    }  
}
