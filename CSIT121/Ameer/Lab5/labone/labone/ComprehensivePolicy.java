/*------------------------------------------------------ 
Name: Ameer Al-Hariri
Subject code: DPIT121
Student number: 76151917
Email address: aah141@uowmail.edu.au
Task: Week 4 lab
-------------------------------------------------------*/
package labone;

public class ComprehensivePolicy extends InsurancePolicy {
    private int driverAge;
    private int level;

    public ComprehensivePolicy(String policyHolderName, int id, Car car, int numberOfClaims, MyDate expiryDate, int driverAge, int level) {
        super(policyHolderName, id, car, numberOfClaims, expiryDate);
        this.driverAge = driverAge;
        this.level = level;
    }
    public ComprehensivePolicy(ComprehensivePolicy policy) {
        super(policy.policyHolderName, policy.id, policy.getCar(), policy.numberOfClaims, policy.expiryDate);
        this.driverAge = policy.driverAge;
        this.level = policy.level;
    }
    public double calcPayment(double flatRate) {
        double premium = 0.0;
        if (driverAge < 30) {
            premium = (super.getCar().price / 50.0) + numberOfClaims * (200.0 + flatRate) + ((30.0 - driverAge) * 50);
        } else {
            premium = (super.getCar().price / 50.0) + numberOfClaims * (200.0 + flatRate);
        }
        return premium;
    }
    @Override
    public String toString() {
        return super.toString() + ", DriverAge:" + driverAge + ", Level:" + level;
    }
    @Override
    public void print() {
        super.print();
        System.out.println(", DriverAge:" + driverAge + ", Level:" + level);
    }

}