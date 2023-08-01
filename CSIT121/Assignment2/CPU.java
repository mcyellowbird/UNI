/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author fenghui
 */
public abstract class CPU extends ComputerPart{
    private final String CORE;
    
    public CPU(){
        this("","",0);
    }
    
    public CPU(String c, String m, double p){
        this("",c,m,p);
    }
    
    public CPU(String b, String c, String m, double p){
        super(b.substring(0,3).toUpperCase()+"CPU",b,m,p);
        CORE=c;
    }
    
    public CPU(CPU c){
        super(c);
        CORE=c.CORE;
    }
    
    public String getCore(){
        return CORE;
    }
    
    public String toString(){
        String s="";
        s+= super.toString()+"\t"+getCore();
	return s;
    }
}
