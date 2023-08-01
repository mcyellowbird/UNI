/*------------------------------------------------------ 
Name: Ameer Al-Hariri
Subject code: DPIT121
Student number: 76151917
Email address: aah141@uowmail.edu.au
Task: Week 4 lab
-------------------------------------------------------*/
package labone;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class User implements Cloneable, Comparable < User > {

    //    static void printUsers(ArrayList<User> sortedUsers) {
    //        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    //    }
    private String name;
    private int userID;
    private Address address;
    //	private ArrayList<InsurancePolicy> policies;
    private HashMap < Integer,
    InsurancePolicy > policies;
    private Integer nextPolicyID = 1;
    public User(String name, int userID, Address address) {
        this.name = name;
        this.userID = userID;
        this.address = address;
        //		this.policies = new ArrayList<InsurancePolicy>();
        this.policies = new HashMap < Integer, InsurancePolicy > ();
    }
    public User(User user) {
        this.name = user.name;
        this.userID = user.userID;
        this.address = user.address;
        //		this.policies = new ArrayList<InsurancePolicy>();
        this.policies = new HashMap < Integer, InsurancePolicy > ();
    }
    //comparable intrfsce
    @Override
    public int compareTo(User user) {
        double thisCost = InsurancePolicy.calcTotalPayments(policies, Program.flatRate);
        double otherCost = InsurancePolicy.calcTotalPayments(user.getPolicies(), Program.flatRate);
        if (thisCost == otherCost) {
            return 0;
        }
        return otherCost > thisCost ? 1 : -1;
    }
    public int compareTo1(Address address) {
        return this.address.compareTo(address);
    }
    public User clone() throws CloneNotSupportedException {
        return (User) super.clone();
    }

    //this is the shallwCopy ArrayList
    public static ArrayList < User > shallowCopy(ArrayList < User > users) {
        ArrayList < User > shallowCopy = new ArrayList < User > ();
        for (User user: users) {
            shallowCopy.add(user);
        }
        return shallowCopy;
    }
    //this is the shallowCopy hashmap
    public static HashMap < Integer,
    User > shallowCopy(HashMap < Integer, User > users) {
        HashMap < Integer, User > shallowCopy = new HashMap < Integer, User > ();
        for (Integer userID: users.keySet()) {
            shallowCopy.put(userID, users.get(userID));
        }
        return shallowCopy;
    }

    //this is the deepcopy arraylist
    public static ArrayList < User > deepCopy(ArrayList < User > users) throws CloneNotSupportedException {
        ArrayList < User > deepCopy = new ArrayList < User > ();
        for (User user: users) {
            deepCopy.add(user.clone());
        }
        return deepCopy;
    }

    //this is the deepcopy hashmap
    public static HashMap < Integer,
    User > deepCopy(HashMap < Integer, User > users) throws CloneNotSupportedException {
        HashMap < Integer, User > deepCopy = new HashMap < Integer, User > ();
        for (Integer userID: users.keySet()) {
            deepCopy.put(userID, users.get(userID).clone());
        }
        return deepCopy;
    }

    public static void printUsers(ArrayList < User > users) {
        for (User user: users) {
            user.print();
            System.out.println("--");
        }
    }
    public static void printUsers(HashMap < Integer, User > users) {
        for (Integer userID: users.keySet()) {
            users.get(userID).print();
            System.out.println("--");
        }
    }

    public ArrayList < InsurancePolicy > sortPoliciesByDate() throws CloneNotSupportedException {
        ArrayList < InsurancePolicy > sort = InsurancePolicy.deepCopy(policies);
        Collections.sort(sort);
        return sort;
    }

    //get the total count of carss
    public int getTotalCountForCarModel(String carModel) {
        int total = 0;
        //for(InsurancePolicy policy: policies){
        for (InsurancePolicy policy: policies.values()) {
            if (policy.getCarModel() == carModel) {
                total++;
            }
        }
        return total;
    }

    //gets the total payment for car models
    public double getTotalPaymentForCarModel(String carModel) {
        double total = 0.0;
        //for(InsurancePolicy policy: policies){
        for (InsurancePolicy policy: policies.values()) {
            if (policy.getCarModel() == carModel) {
                total = total + policy.calcPayment(Program.flatRate);
            }
        }
        return total;
    }

    //deepcopy policies
    public ArrayList < InsurancePolicy > deepCopyPolicies() throws Exception {
		ArrayList<InsurancePolicy> _policies = new ArrayList<InsurancePolicy>();
		for (InsurancePolicy pol : policies.values()){
			_policies.add(pol);
		}
        return _policies;
    }
    //shallowcopy policies
    public ArrayList < InsurancePolicy > shallowCopyPolicies() {
        return InsurancePolicy.shallowCopy(policies);
    }

    //create 3rd party policy
    public boolean createThirdPartyPolicy(String policyHolderName, int id, Car car, int numberOfClaims, MyDate expiryDate, String comments) {
        if (findPolicy(id) != null) {
            return false;
        }
        ThirdPartyPolicy newPolicy = new ThirdPartyPolicy(policyHolderName, id, car, numberOfClaims, expiryDate, comments);
        this.addPolicy(newPolicy);
        return true;
    }

    //create comp policy
    public boolean createComprehensivePolicy(String policyHolderName, int id, Car car, int numberOfClaims, MyDate expiryDate, int driverAge, int level) {
        if (findPolicy(id) != null) {
            return false;
        }
        ComprehensivePolicy newPolicy = new ComprehensivePolicy(policyHolderName, id, car, numberOfClaims, expiryDate, driverAge, level);
        this.addPolicy(newPolicy);
        return true;
    }

    //return list filterbyexipirydate
    //	public ArrayList<InsurancePolicy> filterByExpiryDate(MyDate date){
    public HashMap < Integer,
    InsurancePolicy > filterByExpriryDate(MyDate date) {
        return InsurancePolicy.filterByExpiryDate(policies, date);
    }

    public void removePolicy(Integer id) {
        policies.remove(id);
    }

    //add policy
    public boolean addPolicy(InsurancePolicy policy) {
        InsurancePolicy find = findPolicy(policy.getId());
        if (find != null) {
            return false;
        }
        //policies.add(policy);
        policies.put(nextPolicyID, policy);
        nextPolicyID++;
        return true;
    }

    //find policy by the id
    public InsurancePolicy findPolicy(int policyId) {
        //		for (InsurancePolicy policy: policies){
        for (InsurancePolicy policy: policies.values()) {
            if (policy.getId() == policyId) {
                return policy;
            }
        }
        return null;
    }

    //print all tge policies
    public void printPolicies() {
        System.out.print("Policies:");
        //		for (InsurancePolicy policy: policies){
        if (policies.size() < 1) {
            System.out.println("No active policies");
        } else {
            for (InsurancePolicy policy: policies.values()) {
                policy.print();
            }
        }
    }

    //
    public double calcTotalPremiums(int flatRate) {
        return InsurancePolicy.calcTotalPayments(policies, flatRate);
    }

    //
    public void carPriceRiseAll(double priceRise) {
        InsurancePolicy.carPriceRiseAll(policies, priceRise);
    }

    //
    public ArrayList < InsurancePolicy > filterByCarModel(String carModel) {
        ArrayList < InsurancePolicy > filteredPolicies = new ArrayList < InsurancePolicy > ();
        //    	for (InsurancePolicy policy : policies) {
        for (InsurancePolicy policy: policies.values()) {
            if (policy.getCar().getModel().contains(carModel)) {
                filteredPolicies.add(policy);
            }
        }
        return filteredPolicies;
    }

    //print and to string
    public void print() {
        System.out.println("Name:" + name + ", Id:" + userID);
        System.out.println("Address:" + address.toString());
        System.out.println("Policies:");
        //		for (InsurancePolicy policy : policies){
        if (policies.size() < 1) {
            System.out.println("No active policies");
        } else {
            for (InsurancePolicy policy: policies.values()) {
                policy.print();
            }
        }
    }
    public String toString() {
        String string = "\n";
        //		for (InsurancePolicy policy : policies){
        for (InsurancePolicy policy: policies.values()) {
            string = string + policy.toString() + "\n";
        }
        return "Name:" + name + ", Id:" + userID + "\nAddress:" + address.toString() + "\nPolicies:" + string;
    }

    public HashMap < String,
    Integer > getTotalCountPerCarModel() {
        HashMap < String, Integer > counts = new HashMap < String, Integer > ();
        for (InsurancePolicy policy: policies.values()) {
            counts.put(policy.getCarModel(), (counts.get(policy.getCarModel()) + 1));
        }

        return counts;

    }

    public HashMap < String,
    Double > getTotalPremiumPerCarModel() {
        HashMap < String, Double > premiums = new HashMap < String, Double > ();
        for (InsurancePolicy policy: policies.values()) {
            premiums.put(policy.getCarModel(), (premiums.get(policy.getCarModel()) + policy.calcPayment(100)));
        }

        return premiums;

    }

    public HashMap < String,
    Double > getTotalPaymentPerCarModel(ArrayList < String > carModels) {
        HashMap < String, Double > payments = new HashMap < String, Double > ();
        for (String carModel: carModels) {
            payments.put(carModel, getTotalPaymentForCarModel(carModel));
        }

        return payments;

    }
    public void reportPaymentPerCarModel(ArrayList < String > carModels, ArrayList < Integer > counts, ArrayList < Double > payments) {
        System.out.format("%-1s", "Car Model");
        System.out.format("%42s", "Total Premium Payment");
        System.out.format("%32s", "Average Premium Payment");
        System.out.println();
        int iterator = 0;
        while (iterator < carModels.size()) {
            double average = payments.get(iterator) / counts.get(iterator);
            System.out.format("%-30s", carModels.get(iterator));
            System.out.format("%1s", "$" + String.format("%,.2f", payments.get(iterator)));
            System.out.format("%30s", "$" + String.format("%,.2f", average));
            iterator++;
            System.out.println();
        }
    }
    public void reportPaymentPerCarModel(HashMap < String, Integer > carModelsCounts, HashMap < String, Double > carModelsPayments) {
        System.out.format("%-1s", "Car Model");
        System.out.format("%42s", "Total Premium Payment");
        System.out.format("%32s", "Average Premium Payment");
        System.out.println();
        for (String carModel: carModelsCounts.keySet()) {
            double average = carModelsPayments.get(carModel) / carModelsCounts.get(carModel);
            System.out.format("%-30s", carModel);
            System.out.format("%1s", "$" + String.format("%,.2f", carModelsPayments.get(carModel)));
            System.out.format("%30s", "$" + String.format("%,.2f", average));
            System.out.println();

        }
    }
    //getters and setters
    //	public ArrayList<InsurancePolicy> getPolicies(){
    //		return policies;
    //	}
    public HashMap < Integer,
    InsurancePolicy > getPolicies() {
        return policies;
    }
    //	public void setPolicies(ArrayList<InsurancePolicy> policies){
    //		this.policies = policies;
    //	}
    public void setPolicies(HashMap < Integer, InsurancePolicy > policies) {
        this.policies = policies;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getUserID() {
        return userID;
    }
    public void setUserID(int userID) {
        this.userID = userID;
    }
    public Address getAddress() {
        return address;
    }
    public void setAddress(Address address) {
        this.address = address;
    }

    public String getCity() {
        return address.getCity();
    }
    public void setCity(String city) {
        address.setCity(city);
    }
}