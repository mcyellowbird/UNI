/*------------------------------------------------------ 
Name: Ameer Al-Hariri
Subject code: DPIT121
Student number: 76151917
Email address: aah141@uowmail.edu.au
Task: Week 3 lab
-------------------------------------------------------*/ 
package labone;


import java.util.ArrayList;

public class User {
	private String name;
	private int userID;
	private Address address;
	private ArrayList<InsurancePolicy> policies;
	public User(String name, int userID, Address address) {
		this.name = name;
		this.userID = userID;
		this.address = address;
		this.policies = new ArrayList<InsurancePolicy>();
	}

	//create 3rd party policy if the id is unique
	public boolean createThirdPartyPolicy(String policyHolderName, int id, Car car, int numberOfClaims, MyDate expiryDate, String comments){
		if(findPolicy(id) != null){return false;}
		ThirdPartyPolicy newPolicy = new ThirdPartyPolicy(policyHolderName, id, car, numberOfClaims, expiryDate, comments);
		this.addPolicy(newPolicy);
		return true;
	}

	//create comprehensive policy if the id is unique
	public boolean createComprehensivePolicy(String policyHolderName, int id, Car car, int numberOfClaims, MyDate expiryDate, int driverAge, int level){
		if(findPolicy(id) != null){return false;}
		ComprehensivePolicy newPolicy = new ComprehensivePolicy(policyHolderName, id, car, numberOfClaims, expiryDate, driverAge, level);
		this.addPolicy(newPolicy);
		return true;
	}

	//return list of filtered policies by date
	public ArrayList<InsurancePolicy> filterByExpiryDate(MyDate date){
		return InsurancePolicy.filterByExpiryDate(policies, date);
	}

	//add policy, return false if duplicate id
	public boolean addPolicy(InsurancePolicy policy) {
		InsurancePolicy find = findPolicy(policy.getId());
		if(find != null){return false;}
		policies.add(policy);
		return true;
	}

	//find policy by id
	public InsurancePolicy findPolicy(int policyId) {
		for (InsurancePolicy policy: policies){
            if(policy.getId() == policyId) {
            	return policy;
            }
        }
        return null;
	}

	//print all policies that the user has
	public void printPolicies(int flatRate) {
		System.out.print("Policies:");
		for (InsurancePolicy policy: policies){
            policy.print();
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
	public ArrayList<InsurancePolicy> filterByCarModel(String carModel){
    	ArrayList<InsurancePolicy> filteredPolicies = new ArrayList<InsurancePolicy>();
    	for (InsurancePolicy policy : policies) {
        	if(policy.car.getModel().contains(carModel)) {
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
		for (InsurancePolicy policy : policies){
            policy.print();
        }
	}
	public String toString() {
		String string = "\n";
		for (InsurancePolicy policy : policies){
            string = string + policy.toString() + "\n";
        }
		return "Name:" + name + ", Id:" + userID + "\nAddress:" + address.toString() + "\nPolicies:" + string;
	}


	//getters and setters
	public ArrayList<InsurancePolicy> getPolicies(){
		return policies;
	}
	public void setPolicies(ArrayList<InsurancePolicy> policies){
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
