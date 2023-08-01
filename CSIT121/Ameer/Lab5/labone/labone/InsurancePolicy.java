/*------------------------------------------------------ 
Name: Ameer Al-Hariri
Subject code: DPIT121
Student number: 76151917
Email address: aah141@uowmail.edu.au
Task: Week 4 lab
-------------------------------------------------------*/
package labone;

import java.util.ArrayList;
import java.util.HashMap;

abstract public class InsurancePolicy implements Cloneable, Comparable < InsurancePolicy > {
    protected String policyHolderName;
    protected int id;
    protected static Car car;
    protected int numberOfClaims;
    protected MyDate expiryDate;

    public InsurancePolicy(String policyHolderName, int id, Car ncar, int numberOfClaims, MyDate expiryDate) {
        this.policyHolderName = policyHolderName;
        this.id = id;
        car = ncar;
        this.numberOfClaims = numberOfClaims;
        this.expiryDate = expiryDate;
    }
    public InsurancePolicy(InsurancePolicy insurancepolicy) {
        this.policyHolderName = insurancepolicy.policyHolderName;
        this.id = insurancepolicy.id;
        car = insurancepolicy.getCar();
        this.numberOfClaims = insurancepolicy.numberOfClaims;
        this.expiryDate = insurancepolicy.expiryDate;
    }
    //comparable
    @Override
    public int compareTo(InsurancePolicy policy) {
        return this.expiryDate.compareTo(policy.expiryDate);
    }

    //clone intrface
    @Override
    public InsurancePolicy clone() throws CloneNotSupportedException {
        return this;
    }
    //	public InsurancePolicy clone() throws CloneNotSupportedException {
    //		InsurancePolicy policy = (InsurancePolicy) super.clone();
    //		policy.car = this.car.clone();
    //		policy.expiryDate = this.expiryDate.clone();
    //		return policy;

    //	} // shallowcopy arraylist
    public static ArrayList < InsurancePolicy > shallowCopy(ArrayList < InsurancePolicy > policies) {
        ArrayList < InsurancePolicy > shallowCopy = new ArrayList < InsurancePolicy > ();
        for (InsurancePolicy policy: policies) {
            shallowCopy.add(policy);
        }
        return shallowCopy;
    }
    // shallowcopy HashaMap
    public static ArrayList < InsurancePolicy > shallowCopy(HashMap < Integer, InsurancePolicy > policies) {
        ArrayList < InsurancePolicy > shallowCopy = new ArrayList < InsurancePolicy > ();
        for (InsurancePolicy policy: policies.values()) {
            shallowCopy.add(policy);
        }
        return shallowCopy;
    }

    //deepcopy arraylist
    public static ArrayList < InsurancePolicy > deepCopy(ArrayList < InsurancePolicy > policies) throws CloneNotSupportedException {
        ArrayList < InsurancePolicy > deepCopy = new ArrayList < InsurancePolicy > ();
        for (InsurancePolicy policy: policies) {
            deepCopy.add(policy.clone());
        }
        return deepCopy;
    }
    // //deepcopy Hashmaop
    public static ArrayList < InsurancePolicy > deepCopy(HashMap < Integer, InsurancePolicy > policies) throws CloneNotSupportedException {
        ArrayList < InsurancePolicy > deepCopy = new ArrayList < InsurancePolicy > ();
        for (InsurancePolicy policy: policies.values()) {
            deepCopy.add(policy.clone());
        }
        return deepCopy;
    }

    public abstract double calcPayment(double flatRate); //abstract method for calcPayment

    public void print() {
        System.out.print("Id:" + id + ", Name:" + policyHolderName + ", Car:(" + car.toString() + "), Claims:" + numberOfClaims);
    }
    public String toString() {
        return "Id:" + id + ", Name:" + policyHolderName + ", Car:(" + car.toString() + "), Claims:" + numberOfClaims;
    }

    public static ArrayList < InsurancePolicy > filterByExpiryDate(ArrayList < InsurancePolicy > policies, MyDate date) {
        ArrayList < InsurancePolicy > filteredPolicies = new ArrayList < InsurancePolicy > ();
        for (InsurancePolicy policy: policies) {
            if (policy.getExpiryDate().isExpired(date)) {
                filteredPolicies.add(policy);
            }
        }
        return filteredPolicies;
    }
    public static HashMap < Integer,
    InsurancePolicy > filterByExpiryDate(HashMap < Integer, InsurancePolicy > policies, MyDate date) {
        HashMap < Integer, InsurancePolicy > filteredPolicies = new HashMap < Integer, InsurancePolicy > ();
        for (Integer policyID: policies.keySet()) {
            if (policies.get(policyID).getExpiryDate().isExpired(date)) {
                filteredPolicies.put(policyID, policies.get(policyID));
            }
        }
        return filteredPolicies;
    }

    public static void printPolicies(ArrayList < InsurancePolicy > policies) {
        for (InsurancePolicy policy: policies) {
            policy.print();
        }
        System.out.println();
    }
    public static void printPolicies(HashMap < Integer, InsurancePolicy > policies) {
        for (Integer policyID: policies.keySet()) {
            policies.get(policyID).print();
        }
        System.out.println();
    }

    public static double calcTotalPayments(ArrayList < InsurancePolicy > policies, int flatRate) {
        double totalCost = 0;
        for (InsurancePolicy policy: policies) {
            totalCost += policy.calcPayment(flatRate); //calculate the total cost of insurnce policies
        }
        return totalCost;
    }

    public static double calcTotalPayments(HashMap < Integer, InsurancePolicy > policies, double flatRate) {
        double totalCost = 0;
        for (InsurancePolicy policy: policies.values()) {
            totalCost += policy.calcPayment(flatRate);
        }
        return totalCost;
    }

    public void carPriceRise(double risePercent) {
        car.priceRise(risePercent);
    }
    public static void carPriceRiseAll(ArrayList < InsurancePolicy > policies, double risePercent) {
        for (InsurancePolicy policy: policies) {
            policy.getCar().priceRise(risePercent);
        }
    }

    public static void carPriceRiseAll(HashMap < Integer, InsurancePolicy > policies, double risePercent) {
        for (InsurancePolicy policy: policies.values()) {
            policy.getCar().priceRise(risePercent);
        }
    }

    public static ArrayList < InsurancePolicy > filterByCarModel(ArrayList < InsurancePolicy > policies, String carModel) {
        ArrayList < InsurancePolicy > filteredPolicies = new ArrayList < InsurancePolicy > ();
        for (InsurancePolicy policy: policies) {
            if (car.getModel().contains(carModel)) {
                filteredPolicies.add(policy);
            }
        }
        return filteredPolicies;
    }

    public static HashMap < Integer,
    InsurancePolicy > filterByCarModel(HashMap < Integer, InsurancePolicy > policies, String carModel) {
        HashMap < Integer, InsurancePolicy > filteredPolicies = new HashMap < Integer, InsurancePolicy > ();
        for (Integer policyID: policies.keySet()) {
            if (policies.get(policyID).getCarModel().equals(carModel)) {
                filteredPolicies.put(policyID, policies.get(policyID));
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
    public void setCar(Car ncar) {
        car = ncar;
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