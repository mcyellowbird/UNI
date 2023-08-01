/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author fenghui
 */
public class IntelCPU extends CPU{
    private final String SOCKET;
    
    public IntelCPU(){
        this("","",0);
    }
    
    public IntelCPU(String c, String m, double p){
        super("Intel",c,m,p);
        SOCKET="Intel";
    }
    
    public IntelCPU(IntelCPU ic){
        super(ic);
        SOCKET=ic.SOCKET;
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
        if(cp instanceof AMDMotherboard || cp instanceof AMDGraphicsCard)
            return false;
        else
            return true;
    }
}