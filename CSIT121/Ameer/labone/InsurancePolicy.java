/*------------------------------------------------------ 
Name: Ameer Al-Hariri
Subject code: DPIT121
Student number: 76151917
Email address: aah141@uowmail.edu.au
Task: Week 3 lab
-------------------------------------------------------*/
package labone;

import java.util.ArrayList;

abstract public class InsurancePolicy {
	protected String policyHolderName;
    protected int id;
    protected static Car car;
    protected int numberOfClaims;
    protected MyDate expiryDate;
    
    public InsurancePolicy(String policyHolderName, int id, Car car, int numberOfClaims){
        this.policyHolderName = policyHolderName;
        this.id = id;
        this.car = car;
        this.numberOfClaims = numberOfClaims;
    }
    public abstract double calcPayment(double flatRate); //abstract method for calcPayment
    
    public void print(){
        System.out.print("Id:" + id + ", Name:" + policyHolderName + ", Car:(" + car.toString() + "), Claims:" + numberOfClaims);
    }
    public String toString(){
        return "Id:" + id + ", Name:" + policyHolderName + ", Car:(" + car.toString() + "), Claims:" + numberOfClaims;
    }
    
    public static ArrayList<InsurancePolicy> filterByExpiryDate(ArrayList<InsurancePolicy> policies, MyDate date){
	ArrayList<InsurancePolicy> filteredPolicies = new ArrayList<InsurancePolicy>();
    	for (InsurancePolicy policy : policies) {
        	if(policy.getExpiryDate().isExpired(date)) {
        		filteredPolicies.add(policy);
        	}
        }
    	return filteredPolicies;
	}
    
    public static void printPolicies(ArrayList<InsurancePolicy> policies) {
    	for (InsurancePolicy policy : policies) {
        	policy.print();  //call the print method
        }
        System.out.println(); //separate sections
    }
    public static double calcTotalPayments(ArrayList<InsurancePolicy> policies, int flatRate) {
    	double totalCost = 0;
        for (InsurancePolicy policy : policies) {
        	totalCost += policy.calcPayment(flatRate); //calculate the total cost of all given insurance policies
        }
		return totalCost;
    }
    public void carPriceRise(double risePercent) {
    	car.priceRise(risePercent);
    }
    public static void carPriceRiseAll(ArrayList<InsurancePolicy> policies, double risePercent) {
    	for(InsurancePolicy policy : policies) {
    		policy.car.priceRise(risePercent);
    	}
    }
    public static ArrayList<InsurancePolicy> filterByCarModel(ArrayList<InsurancePolicy> policies, String carModel){
    	ArrayList<InsurancePolicy> filteredPolicies = new ArrayList<InsurancePolicy>();
    	for (InsurancePolicy policy : policies) {
        	if(car.getModel().contains(carModel)) {
        		filteredPolicies.add(policy);
        	}
        }
    	return filteredPolicies;
    }
    
    
	public String getPolicyHolderName() {
		return policyHolderName;
	}
	public void setPolicyHolderName(String policyHolderName) {
		this.policyHolderName = policyHolderName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Car getCar() {
		return car;
	}
	public void setCar(Car car) {
		this.car = car;
	}
	public int getNumberOfClaims() {
		return numberOfClaims;
	}
	public void setNumberOfClaims(int numberOfClaims) {
		this.numberOfClaims = numberOfClaims;
	}
	public MyDate getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(MyDate expiryDate) {
		this.expiryDate = expiryDate;
	}
	public String getCarModel() {
		return car.getModel();
	}
	public void setCarModel(String model) {
		car.setModel(model);
		
	}
}
