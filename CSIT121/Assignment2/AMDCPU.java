/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author fenghui
 */
public class AMDCPU extends CPU{
    private final String SOCKET;
    
    public AMDCPU(){
        this("","",0);
    }
    
    public AMDCPU(String c, String m, double p){
        super("AMD",c,m,p);
        SOCKET="AMD";
    }
    
    public AMDCPU(AMDCPU ac){
        super(ac);
        SOCKET=ac.SOCKET;
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
        if(cp instanceof IntelMotherboard || cp instanceof IntelGraphicsCard)
            return false;
        else
            return true;
    }
}
