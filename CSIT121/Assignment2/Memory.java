/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author fenghui
 */
public class Memory extends ComputerPart{
    private final String SOCKET, SIZE;
    
    public Memory(){
        this("","","","",0);
    }
    
    public Memory(String s, String b, String si, String m, double p){
        super("MEM",b,m,p);
        SOCKET=s;
        SIZE=si;
    }
    
    
    public Memory(Memory m){
        super(m);
        SOCKET=m.SOCKET;
        SIZE=m.SIZE;
    }

    
    public String getSocket(){
        return SOCKET;
    }
    
    public String getSize(){
        return SIZE;
    }
    
    public String toString(){
        String s="";
        s+= super.toString()+"\t"+getSocket()+"\t"+getSize();
        
	return s;
    }

    @Override
    public boolean isCompatible(ComputerPart cp) {
        return true;
    }
}
