/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author fenghui
 */
public class IntelGraphicsCard extends GraphicsCard{
    private final String SOCKET;
    
    public IntelGraphicsCard(){
        this("","",0);
    }
    
    public IntelGraphicsCard(String c, String m, double p){
        super("INT",c,m,p);
        SOCKET="Intel";
    }
    
    public IntelGraphicsCard(IntelGraphicsCard ig){
        super(ig);
        SOCKET=ig.SOCKET;
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
        if(cp instanceof AMDCPU || cp instanceof AMDMotherboard)
            return false;
        else
            return true;
    }
}
