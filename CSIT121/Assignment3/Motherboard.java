/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author fenghui
 */
public abstract class Motherboard extends ComputerPart{
    
    public Motherboard(){
        this("","",0);
    }
    
    public Motherboard(String b, String m, double p){
        this("",b,m,p);
    }
    
    public Motherboard(String prefix, String b, String m, double p){
        super(prefix+"MOT",b,m,p);
    }
    
    public Motherboard(Motherboard m){
        super(m);
    }
    
    public String toString(){ 
	return super.toString();
    }
}
