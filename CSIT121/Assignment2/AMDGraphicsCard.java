/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author fenghui
 */
public class AMDGraphicsCard extends GraphicsCard{
    private final String SOCKET;
    
    public AMDGraphicsCard(){
        this("","",0);
    }
    
    public AMDGraphicsCard(String b, String m, double p){
        super("AMD",b,m,p);
        SOCKET="AMD";
    }
    
    public AMDGraphicsCard(AMDGraphicsCard ac){
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
        if(cp instanceof IntelMotherboard || cp instanceof IntelCPU)
            return false;
        else
            return true;
    }
}
