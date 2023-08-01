/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author fenghui
 */
public class Monitor extends ComputerPart{
    private final String SIZE;
    
    public Monitor(){
        this("","","",0);
    }
    
    public Monitor(String b, String si, String m, double p){
        super("MON",b,m,p);
        SIZE=si;
    }
    
    public Monitor(Monitor m){
        super(m);
        SIZE=m.SIZE;
    }
    
    public String getSize(){
        return SIZE;
    }
    
    public String toString(){
        String s="";
        s+= super.toString()+"\t"+getSize();
        
	return s;
    }

    @Override
    public boolean isCompatible(ComputerPart cp) {
        return true;
    }
}
