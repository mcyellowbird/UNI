/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author fenghui
 */
public class DiscountOrder extends Order{
    private double discount;
    
    public DiscountOrder(double d){
        super();
        discount=d;
    }
    
    public DiscountOrder(){
        this(0);
    }
    
    public double getDiscount(){
        return discount*super.getTotalPrice();
    }
    
    public String toString(){
        String s="";
        s=super.toString()+"Member Customer Discount: $"+getDiscount()+"\t"+
                "Total Price after the Discount: $"+(super.getTotalPrice()-getDiscount())+"\n";
        return s;
    }
}
