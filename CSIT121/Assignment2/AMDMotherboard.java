/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author fenghui
 */
public class AMDMotherboard extends Motherboard{
    private final String SOCKET;
    
    public AMDMotherboard(){
        this("","",0);
    }
    
    public AMDMotherboard(String c, String m, int p){
        super("AMD",c,m,p);
        SOCKET="AMD";
    }
    
    public AMDMotherboard(AMDMotherboard am){
        super(am);
        SOCKET=am.SOCKET;
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
        if(cp instanceof IntelCPU || cp instanceof IntelGraphicsCard)
            return false;
        else
            return true;
    }
}
