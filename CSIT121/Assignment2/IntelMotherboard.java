/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author fenghui
 */
public class IntelMotherboard extends Motherboard{
    private final String SOCKET;
    
    public IntelMotherboard(){
        this("","",0);
    }
    
    public IntelMotherboard(String c, String m, int p){
        super("INT",c,m,p);
        SOCKET="Intel";
    }
    
    public IntelMotherboard(IntelMotherboard im){
        super(im);
        SOCKET=im.SOCKET;
    }
    
    public String getSocket(){
        return SOCKET;
    }
    
    public String toString(){
        String s="";
        s+=super.toString()+"\t"+getSocket();
        return s;
    }

    @Override
    public boolean isCompatible(ComputerPart cp) {
        if(cp instanceof AMDGraphicsCard || cp instanceof AMDCPU)
            return false;
        else
            return true;
    }
}
