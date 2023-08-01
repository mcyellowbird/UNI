package ComputerShopGUI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

class CSFrame{

    static ArrayList<ComputerPart> currentOrder = new ArrayList<ComputerPart>();
    static ArrayList<Order> orderList = new ArrayList<Order>();
    static Customer customer = null;
    static String[] empty = {""};
    static boolean buttonPressed = false;
    static OrderingSystem orderingsystem = new OrderingSystem();

    private static ObjectInputStream input;

    public static void main(String[] args){
        // Make store
        try{
            input = new ObjectInputStream(Files.newInputStream(Paths.get("compshop.ser")));
        }
        catch (IOException ioException){
            System.err.println("Error opening file");
            System.exit(1);
        }

        try{
            while (true)
            {
                orderingsystem = (OrderingSystem)input.readObject();
            }
        }
        catch (EOFException endOfFileException){
            System.out.printf("%No more records%n");
        }
        catch (ClassNotFoundException classNotFoundException){
            System.out.printf("Invalid object type%n");
        }
        catch (IOException ioException){
            System.out.printf("");
        }

        // Create frame
        JFrame frame = new JFrame("Computer Store");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create panel
        JPanel panel = new JPanel();

        // Create buttons, inputs, etc
        ArrayList<String> partList = new ArrayList<String>();

        for (ComputerPart part : orderingsystem.getComputerParts()){
            partList.add(part.getID());
        }

        String[] partID = partList.toArray(new String[0]);

        JList<String> partJList = new JList<String>(partID);
        partJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        JList<String> partInfoJList = new JList<String>();
        partInfoJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        JList<String> customerInfoJlist = new JList<String>();
        customerInfoJlist.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        JList<String> curOrderJList = new JList<String>();
        curOrderJList.setModel(new DefaultListModel<String>());
        curOrderJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        JList<String> curOrderInfoJList = new JList<String>();
        curOrderInfoJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        JList<String> preOrderJList = new JList<String>();
        preOrderJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        JList<String> preOrderInfoJList = new JList<String>();
        preOrderInfoJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        JButton memberLoginButton = new JButton("Login as Member");
        JButton newCustomerButton = new JButton("Login as New Customer");
        JButton addItemButton = new JButton("Add Item To Order");
        JButton removeItemButton = new JButton("Remove Item From Current Order");
        JButton submitOrderButton = new JButton("Submit Current Order");
        JButton deleteOrderButton = new JButton("Delete Previous Order");
        JButton exportOrderButton = new JButton("Export Previous Orders");
        JButton exitButton = new JButton("Exit");

        JLabel partLabel = new JLabel("Computer Part List");
        JLabel partInfoLabel = new JLabel("Computer Part Information");
        JLabel orderLabel = new JLabel("Current Order");
        JLabel orderInfoLabel = new JLabel("Current Order Information");
        JLabel preOrderLabel = new JLabel("Previous Orders");
        JLabel preOrderInfoLabel = new JLabel("Previous Order Information");

        panel.add(partLabel);
        panel.add(partInfoLabel);

        panel.add(new JScrollPane(partJList));
        partJList.addListSelectionListener(
            new ListSelectionListener(){
                @Override
                public void valueChanged(ListSelectionEvent event){
                    ArrayList<String> partArray = new ArrayList<String>();
                    partArray.add(orderingsystem.getComputerParts().get(partJList.getSelectedIndex()).getID());
                    partArray.add(orderingsystem.getComputerParts().get(partJList.getSelectedIndex()).getBrand());
                    partArray.add(orderingsystem.getComputerParts().get(partJList.getSelectedIndex()).getModel());
                    partArray.add("$" + orderingsystem.getComputerParts().get(partJList.getSelectedIndex()).getPrice());
                    partInfoJList.setListData(partArray.toArray(new String[0]));
                }
            }
        );

        panel.add(new JScrollPane(partInfoJList));

        panel.add(memberLoginButton);
        memberLoginButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent event){
                if (customer == null){
                    customer = MemberLogin(orderingsystem);
    
                    if (customer != null){
                        ArrayList<String> memberData = new ArrayList<String>();
                        memberData.add(customer.getID());
                        memberData.add(customer.getName());
                        memberData.add(customer.getGender());
                        memberData.add(customer.getMobile());
                        memberData.add(customer.getAddress());
                        memberData.add("Discount: " + ((MemberCustomer)customer).getDiscount());
        
                        String[] memberArray = memberData.toArray(new String[0]);
        
                        customerInfoJlist.setListData(memberArray);
                    }
                }
            }
        });

        panel.add(newCustomerButton);
        newCustomerButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent event){
                if (customer == null){
                    customer = NewCustomer(orderingsystem);
    
                    if (customer != null){
                        ArrayList<String> newCustData = new ArrayList<String>();
                        newCustData.add(customer.getID());
                        newCustData.add(customer.getName());
                        newCustData.add(customer.getGender());
                        newCustData.add(customer.getMobile());
                        newCustData.add(customer.getAddress());
        
                        String[] custArray = newCustData.toArray(new String[0]);
        
                        customerInfoJlist.setListData(custArray);
                    }
                }
            }
        });

        panel.add(new JScrollPane(customerInfoJlist));

        panel.add(addItemButton);
        addItemButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent event){
                if (customer != null)
                {
                    currentOrder.add(orderingsystem.getComputerParts().get(partJList.getSelectedIndex()));
                    ArrayList<String> partArray = new ArrayList<String>();
                    for (ComputerPart part : currentOrder){
                        partArray.add(part.getID());
                    }
                    partArray.add("Order Summary");
                    curOrderJList.setListData(partArray.toArray(new String[0]));
                }
            }
        });
        

        panel.add(orderLabel);
        panel.add(orderInfoLabel);

        panel.add(new JScrollPane(curOrderJList));
        curOrderJList.addListSelectionListener(
            new ListSelectionListener(){
                @Override
                public void valueChanged(ListSelectionEvent event){                    
                    if (curOrderJList.getSelectedIndex() == currentOrder.size()){
                        ArrayList<String> summaryArray = new ArrayList<String>();
                        double tempTotal = 0;

                        for (ComputerPart part : currentOrder){
                            summaryArray.add(part.toString());
                            for (ComputerPart compatiblePart : currentOrder){
                                boolean compatible = part.isCompatible(compatiblePart);
                                if (!compatible){
                                    summaryArray.add("Part " + part.getID() + " is not compatible with " + compatiblePart.getID());
                                }
                            }

                            tempTotal += part.getPrice();
                        }
                        summaryArray.add("");
                        summaryArray.add("Total Price: $" + tempTotal);

                        if (customer instanceof MemberCustomer){
                            double discountTotal = tempTotal - (tempTotal * ((MemberCustomer)customer).getDiscount());
                            summaryArray.add("Discount Price: $" + discountTotal);
                        }

                        curOrderInfoJList.setListData(summaryArray.toArray(new String[0]));
                    }

                    else if (!curOrderJList.isSelectionEmpty()){
                        ArrayList<String> partArray = new ArrayList<String>();
                        partArray.add(currentOrder.get(curOrderJList.getSelectedIndex()).getID());
                        partArray.add(currentOrder.get(curOrderJList.getSelectedIndex()).getBrand());
                        partArray.add(currentOrder.get(curOrderJList.getSelectedIndex()).getModel());
                        partArray.add("$" + currentOrder.get(curOrderJList.getSelectedIndex()).getPrice());
                        curOrderInfoJList.setListData(partArray.toArray(new String[0]));
                    }
                }
            }
        );

        panel.add(new JScrollPane(curOrderInfoJList));

        panel.add(removeItemButton);
        removeItemButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent event){
                if (curOrderJList.getSelectedIndex() != currentOrder.size() && currentOrder.size() > 0){
                    currentOrder.remove(curOrderJList.getSelectedIndex());

                    ArrayList<String> partArray = new ArrayList<String>();
                    for (ComputerPart part : currentOrder){
                        partArray.add(part.getID());
                    }

                    partArray.add("Order Summary");
                    curOrderInfoJList.setModel(new DefaultListModel<String>());
                    curOrderJList.setListData(partArray.toArray(new String[0]));
                    curOrderJList.clearSelection();
                }
            }
        });
        
        panel.add(submitOrderButton);
        submitOrderButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent event){
                if (customer != null)
                {
                    if (currentOrder.size() > 0){

                        if (customer instanceof MemberCustomer){
                            Order newOrder = new DiscountOrder(((MemberCustomer)customer).getDiscount());
                            for (ComputerPart part : currentOrder)
                            {
                                newOrder.addComputerPart(part);
                            }
                            customer.addOrder(newOrder);
                            orderList.add(newOrder);
                        }
                        else{
                            Order newOrder = new Order();
                            for (ComputerPart part : currentOrder)
                            {
                                newOrder.addComputerPart(part);
                            }
                            customer.addOrder(newOrder);
                            orderList.add(newOrder);
                        }
                        currentOrder.clear();

                        ArrayList<String> orderArray = new ArrayList<String>();
                        for (Order order : orderList){
                            orderArray.add(order.getID());
                        }

                        preOrderJList.setListData(orderArray.toArray(new String[0]));
                        preOrderJList.clearSelection();
                        
                        curOrderJList.setModel(new DefaultListModel<String>());
                        curOrderInfoJList.setModel(new DefaultListModel<String>());
                        curOrderJList.clearSelection();
                    }
                }
            }
        });

        panel.add(preOrderLabel);
        panel.add(preOrderInfoLabel);

        panel.add(new JScrollPane(preOrderJList));
        preOrderJList.addListSelectionListener(
            new ListSelectionListener(){
                @Override
                public void valueChanged(ListSelectionEvent event){
                    if (!preOrderJList.isSelectionEmpty()){
                        ArrayList<String> orderString = new ArrayList<String>();
                        for (ComputerPart part : customer.getOrders().get(preOrderJList.getSelectedIndex()).getComputerParts()){
                            orderString.add(part.getID() + "  " + part.getBrand() + "  " + part.getModel() + "  $" + part.getPrice());
                        }
                        double totalPrice = customer.getOrders().get(preOrderJList.getSelectedIndex()).getTotalPrice();
                        orderString.add("Total: $" + totalPrice);
    
                        if (customer.getOrders().get(preOrderJList.getSelectedIndex()) instanceof DiscountOrder){
                            orderString.add("Discount Total: $" + (totalPrice - (totalPrice * ((MemberCustomer)customer).getDiscount())));
                        }
    
                        preOrderInfoJList.setListData(orderString.toArray(new String[0]));
                    }
                }
            }
        );

        panel.add(new JScrollPane(preOrderInfoJList));

        panel.add(deleteOrderButton);
        deleteOrderButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent event){
                if (preOrderJList.getSelectedIndex() != customer.getOrders().size() && customer.getOrders().size() > 0 && !preOrderJList.isSelectionEmpty()){
                    customer.getOrders().remove(preOrderJList.getSelectedIndex());
                    
                    orderList.remove((preOrderJList.getSelectedIndex()));

                    if (orderList.size() > 0){
                        ArrayList<String> orderArray = new ArrayList<String>();
                        for (Order order : orderList){
                            orderArray.add(order.getID());
                        }
                        preOrderJList.setListData(orderArray.toArray(new String[0]));
                        preOrderJList.clearSelection();
                        preOrderInfoJList.setModel(new DefaultListModel<String>());
                    }
                    else{
                        preOrderJList.removeAll();;
                        preOrderJList.clearSelection();
                        preOrderJList.setModel(new DefaultListModel<String>());
                        preOrderInfoJList.setModel(new DefaultListModel<String>());
                    }
                }
            }
        });

        panel.add(exportOrderButton);
        exportOrderButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent event){
                if (customer.getOrders().size() > 0 && customer != null){
                    try (PrintWriter out = new PrintWriter(customer.getID() + ".txt")){
                        for (int i = 0; i < customer.getOrders().size(); i++){
                            if (customer.getOrders().get(i) instanceof DiscountOrder){
                                out.println((DiscountOrder)customer.getOrders().get(i));
                            }
                            else{
                                out.println(customer.getOrders().get(i));
                            }
                        }
                    }
                    catch (FileNotFoundException FileNotFoundException){
                        System.err.println("File output error");
                    }
                }
            }
        });

        panel.add(exitButton);
        exitButton.addActionListener(
            new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent event){
                    System.exit(0);
                }
            }
        );
        frame.setVisible(true);

        // Set frame layout
        panel.setLayout(new GridLayout(11, 2, 5, 5));
        frame.setSize(800,1000);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);

        frame.add(panel);
    }

    static public MemberCustomer MemberLogin(OrderingSystem os){
        MemberCustomer member = new MemberCustomer();
        boolean idFound = false;
        JFrame memberLoginFrame = new JFrame();
        String inputID = JOptionPane.showInputDialog(memberLoginFrame, "Enter Customer ID");

        for (Customer cust : os.getCustomers()){
            if (cust.getID().equals(inputID)){
                member = (MemberCustomer)cust;
                idFound = true;
            }                
        }

        if (!idFound){
            JDialog error = new JDialog(memberLoginFrame, "Error");
            error.getContentPane().add(new JLabel("Invalid Customer ID", SwingConstants.CENTER));
            error.setLayout(new GridLayout(2,1));

            JButton okButton = new JButton("OK");
            okButton.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent event){
                    error.dispose();
                }
            });
            error.getContentPane().add(okButton);
            error.setSize(300, 100);
            error.setResizable(false);
            error.setLocationRelativeTo(null);
            error.setVisible(true);
            return null;
        }
        else{
            return member;
        }
    }
    
    public static Customer NewCustomer(OrderingSystem os){
        JFrame newCustomerFrame = new JFrame();
        newCustomerFrame.setSize(600, 400);
        newCustomerFrame.setResizable(false);
        newCustomerFrame.setLocationRelativeTo(null);
        Container container = newCustomerFrame.getContentPane();
        container.setLayout(null);

        JLabel nameLabel = new JLabel("Full Name");
        nameLabel.setSize(100, 25);
        nameLabel.setLocation(50, 50);
        container.add(nameLabel);

        JTextField name = new JTextField();
        name.setSize(300, 25);
        name.setLocation(150, 50);
        container.add(name);

        JLabel genderLabel = new JLabel("Gender");
        genderLabel.setSize(100, 25);
        genderLabel.setLocation(50, 100);
        container.add(genderLabel);

        String[] genders = {"Male", "Female", "Other"};
        JComboBox<String> genderBox = new JComboBox<String>(genders);
        genderBox.setSize(300, 25);
        container.add(genderBox);
        genderBox.setLocation(150, 100);
        
        JLabel mobileLabel = new JLabel("Mobile");
        mobileLabel.setSize(100, 25);
        mobileLabel.setLocation(50, 150);
        container.add(mobileLabel);

        JTextField mobile = new JTextField();
        mobile.setSize(300, 25);
        mobile.setLocation(150, 150);
        container.add(mobile);

        JLabel addressLabel = new JLabel("Address");
        addressLabel.setSize(100, 25);
        addressLabel.setLocation(50, 200);
        container.add(addressLabel);

        JTextField address = new JTextField();
        address.setSize(300, 25);
        address.setLocation(150, 200);
        container.add(address);

        JButton submitButton = new JButton("Submit");
        submitButton.setSize(100, 50);
        submitButton.setLocation(150, 250);
        container.add(submitButton);

        newCustomerFrame.setVisible(true);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // If any inputs are blank / empty
                if (name.getText().isBlank() || mobile.getText().isBlank() || address.getText().isBlank()){
                    JDialog error = new JDialog(newCustomerFrame, "Error");
                    error.getContentPane().add(new JLabel("Empty Inputs", SwingConstants.CENTER));
                    error.setLayout(new GridLayout(2,1));

                    JButton okButton = new JButton("OK");
                    okButton.addActionListener(new ActionListener(){
                        public void actionPerformed(ActionEvent event){
                            error.dispose();
                        }
                    });
                    error.getContentPane().add(okButton);
                    error.setSize(300, 100);
                    error.setResizable(false);
                    error.setLocationRelativeTo(null);
                    error.setVisible(true);
                }
                else{
                    customer = new Customer(name.getText(), genderBox.getItemAt(genderBox.getSelectedIndex()), mobile.getText(), address.getText());
                    os.addCustomer(customer);
                    newCustomerFrame.dispose();
                    buttonPressed = true;
                }
            }
        });

        if (buttonPressed){
            return customer;
        }
        else{
            return null;
        }
    }
}