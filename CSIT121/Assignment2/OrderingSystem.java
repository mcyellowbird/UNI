
import java.util.ArrayList;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author fenghui
 */
public class OrderingSystem {
    private ArrayList<Customer> customers;
    private ArrayList<ComputerPart> parts;
    
    public static void main(String[] args){
        OrderingSystem os=new OrderingSystem();
        
        System.out.println("Welcome to our compute shop.");
        
        Scanner input=new Scanner(System.in);
        
        Customer cus=null;
        
        Order order =null;
        
        boolean loop = true;
        boolean loop2= true;
        String[] s;
        
        while(loop){
            System.out.println("\nPlease make a select from the following items");
            
            System.out.println("1: login as a member customer");
            System.out.println("2: login as a new customer");
            System.out.println("3: add computer parts");
            System.out.println("4: view/modify the current order");
            System.out.println("5: submit the current order");
            System.out.println("6: view all submitted orders");
            System.out.println("7: exist the online shop");           
        
            int item = input.nextInt();
            
            switch(item){
                case 1:
                    System.out.println("Please provide your customer ID");
                    
                    String id=input.next();
                    
                    for(Customer c:os.getCustomers()){
                        if(c.getID().equals(id)){
                            cus=c;
                            if(cus instanceof MemberCustomer){
                                MemberCustomer mcus=(MemberCustomer)cus;
                                order = new DiscountOrder(mcus.getDiscount());
                            }
                        break;
                        }
                     }

                    if (cus==null)
                        System.out.println("Sorry, your ID can't be found. Please login as a new customer.");
                    
                    break;
                    
                case 2:
                    
                    input.nextLine();
                    System.out.println("For a new customer, please input personal information: name, gender, mobile number, delivery address");
        
                    String[] info=input.nextLine().split(",");
        
                    if(info.length==4){
                        cus = new Customer(info[0],info[1],info[2],info[3]);
                        order = new Order();
                        os.addCustomer(cus);
                    }
                    
                    break;
                    
                case 3:
                    System.out.println("We offer the following products");
                    
                    int i=0;
                    for(ComputerPart cp:os.getComputerParts()){
                        System.out.println("("+(i++)+"): "+cp);
                    }     
                    
                    input.nextLine();
                    
                    if(order==null){
                        if(cus instanceof MemberCustomer){
                            MemberCustomer mcus=(MemberCustomer)cus;
                            order = new DiscountOrder(mcus.getDiscount());
                        }else{
                            order = new Order();
                        }
                    }
                    
                    loop2=true;
                    
                    while(loop2){
                        System.out.println("Please select part/s (-1 for return to the main menu).");
                        s=input.nextLine().split(",");
  
                        for(int j=0;j<s.length;j++){
                            if(Integer.parseInt(s[j])==-1){
                                loop2=false;
                            }else{
                                ComputerPart cp=os.getComputerParts().get(Integer.parseInt(s[j]));
                                
                                if(cp instanceof AMDCPU){
                                    order.addComputerPart(new AMDCPU((AMDCPU)cp));
                                }else if (cp instanceof IntelCPU){
                                    order.addComputerPart(new IntelCPU((IntelCPU)cp));
                                }else if(cp instanceof AMDMotherboard){
                                    order.addComputerPart(new AMDMotherboard((AMDMotherboard)cp));
                                }else if (cp instanceof IntelMotherboard){
                                    order.addComputerPart(new IntelMotherboard((IntelMotherboard)cp));
                                }else if (cp instanceof Memory){
                                    order.addComputerPart(new Memory((Memory)cp));
                                }else if(cp instanceof AMDGraphicsCard){
                                    order.addComputerPart(new AMDGraphicsCard((AMDGraphicsCard)cp));
                                }else if (cp instanceof IntelGraphicsCard){
                                    order.addComputerPart(new IntelGraphicsCard((IntelGraphicsCard)cp));
                                }else if (cp instanceof Monitor){
                                    order.addComputerPart(new Monitor((Monitor)cp));
                                }
                            }
                        }
                    }
                    
                    break;
                case 4:
                    loop2=true;
                    
                    input.nextLine();
                    while(loop2){ 
                        System.out.println("Here is the summary of your current order.");
                        System.out.println(cus);
                        System.out.println(order);
                        
                        System.out.println("Please select part/s to be removed from the order (-1 for return to the main menu).");
                        s=input.nextLine().split(",");
                    
                    
                        for(int j=0;j<s.length;j++){
                            if(Integer.parseInt(s[j])==-1){
                                loop2=false;
                            }else{
                                order.removeComputerPart(Integer.parseInt(s[j]));
                            }
                        }
                    }
                    
                    break;  
                case 5:
                    if(order.getTotalPrice()>0 && cus!=null){
                        System.out.println(cus);
                        System.out.println(order);
                        cus.addOrder(order);
                        order=null;
                        System.out.println("Your order has been submitted. Thanks for your purchase.");
                    }
                    break; 
                case 6:
                    loop2 = true;
                    
                    input.nextLine();
                    while(loop2){ 
                        System.out.println("Here are all your submitted orders. ");
                        System.out.println(cus);
                        for(int j=0;j<cus.getOrders().size();j++){
                            System.out.println("Order "+j+":");
                            System.out.println(cus.getOrders().get(j));
                        }
                        
                        //input.nextLine();
                        System.out.println("Please select order/s to be cancelled (-1 for return to the main menu).");
                        s=input.nextLine().split(",");
                    
                    
                        for(int j=0;j<s.length;j++){
                            if(Integer.parseInt(s[j])==-1){
                                loop2=false;
                            }else{
                                cus.removeOrder(Integer.parseInt(s[j]));
                            }
                        }
                    }
                    
                    break;
                case 7:
                    loop=false;
                    System.out.println("Thanks for visiting our shop, see you next time.");
                    break;                       
                default:
                    loop=false;
                    System.out.println("Thanks for visiting our shop, see you next time.");
            }
        }
    }
    
    public OrderingSystem(){
        customers=new ArrayList<Customer>(0);
        parts=new ArrayList<ComputerPart>(0);
        
        initaliseShop();
    }
    
    public void initaliseShop(){
        addComputerPart(new IntelCPU("i5","9600K",323));
        addComputerPart(new IntelCPU("i7","9700K",462));
        addComputerPart(new IntelCPU("i7","9700F",396));
        addComputerPart(new IntelCPU("i9","9900K",591));
        addComputerPart(new AMDCPU("4","Ryzen2200",200));
        addComputerPart(new AMDCPU("6","Ryzen3600",310));
        addComputerPart(new AMDCPU("8","Ryzen3700",489));
        addComputerPart(new AMDCPU("8","Ryzen5800",669));
        
        addComputerPart(new IntelMotherboard("Gigabyte", "H81M-DS2", 129));
        addComputerPart(new IntelMotherboard("Asus", "J40051-C", 169));
        addComputerPart(new IntelMotherboard("Msi", "Mpg-2390", 225));
        addComputerPart(new IntelMotherboard("Gigabyte", "Z490", 471));
        addComputerPart(new AMDMotherboard("Gigabyte", "B-450", 117));
        addComputerPart(new AMDMotherboard("Asus", "A320I", 128));
        addComputerPart(new AMDMotherboard("Msi", "B450", 232));
        addComputerPart(new AMDMotherboard("Gigabyte", "X570S", 679));
        
        addComputerPart(new Memory("DDR3","Kingston","8G","KCP316ND8",116));
        addComputerPart(new Memory("DDR3","ADATA","16G","AX4U360038G18",189));
        addComputerPart(new Memory("DDR3","G.Skill","8G","F3-10666CL9D",96));
        addComputerPart(new Memory("DDR4","Kingston","8G","KCP426SS8",93));
        addComputerPart(new Memory("DDR4","G.Skill","16G","F4-2666C18S",158));
        addComputerPart(new Memory("DDR4","Crucial","32G","CT32G4SFD832A",259));
        
        addComputerPart(new IntelGraphicsCard("Gigabyte","GeForce RTX 3070",1999));
        addComputerPart(new IntelGraphicsCard("Asus","GeForce RTX 3070",1899));
        addComputerPart(new IntelGraphicsCard("Msi","GeForce RTX 3070",3099));
        addComputerPart(new AMDGraphicsCard("Gigabyte","Radeon RX 6900",3699));
        addComputerPart(new AMDGraphicsCard("Asus","Radeon RX 6900",3199));
        addComputerPart(new AMDGraphicsCard("Msi","Radeon RX 6900",2699));
        
        addComputerPart(new Monitor("Acer","24","K242HYLB",194));
        addComputerPart(new Monitor("LG","32","32QN600",506));
        addComputerPart(new Monitor("Asus","16","MB16ACZ",429));
        addComputerPart(new Monitor("Msi","27","MP271QP",399));
        addComputerPart(new Monitor("Benq","32","PD3200Q",653));
        addComputerPart(new Monitor("Philips","27","272M8CZ",289));
        
        addCustomer(new MemberCustomer("C000001","Amy Bell","Female","04211111","No. 1, NoName Street, NeverLand, 0000."));
        addCustomer(new MemberCustomer("C000002","Bob Brown","Male","04222222","No. 2, NoName Street, NeverLand, 0000."));
        addCustomer(new MemberCustomer("C000003","Cindy Ma","Female","04233333","No. 3, NoName Street, NeverLand, 0000."));
        addCustomer(new MemberCustomer("C000004","David Hintz","Male","04244444","No. 4, NoName Street, NeverLand, 0000."));
        addCustomer(new MemberCustomer("C000005","Rex White","Male","04255555","No. 5, NoName Street, NeverLand, 0000."));
    }
    
    public ArrayList<Customer> getCustomers(){
        return customers;
    }   
    
    public ArrayList<ComputerPart> getComputerParts(){
        return parts;
    }

    public void addComputerPart(ComputerPart cp){
        parts.add(cp);
    }  
    
    public void addCustomer(Customer c){
        customers.add(c);
    }
}
