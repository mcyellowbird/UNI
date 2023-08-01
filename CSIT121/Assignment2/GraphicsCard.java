/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author fenghui
 */
public abstract class GraphicsCard extends ComputerPart{
    
    public GraphicsCard(){
        this("","",0);
    }
    
    public GraphicsCard(String b, String m, double p){
        this("",b,m,p);
    }
    
    public GraphicsCard(String prefix, String b, String m, double p){
        super(prefix+"GRC",b,m,p);
    }
       
    public GraphicsCard(GraphicsCard g){
        super(g);
    }
    
    public String toString(){
	return super.toString();
    }
}
