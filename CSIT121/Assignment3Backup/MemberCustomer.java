/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author fenghui
 */
public class MemberCustomer extends Customer{
    private final double DISCOUNT;
    
    public MemberCustomer(){
        this("","","","","");
    }
    
    public MemberCustomer(String id, String n, String g, String m, String a){ 
        super(id,n,g,m,a);
        DISCOUNT=0.05;
    }
    
    public double getDiscount(){
        return DISCOUNT;
    }
    
    public String toString(){
        return super.toString()+"\t"+getDiscount()+"%";
    }
}
