/*------------------------------------------------------ 
Name: Ameer Al-Hariri
Subject code: DPIT121
Student number: 76151917
Email address: aah141@uowmail.edu.au
Task: Week 3 lab
-------------------------------------------------------*/
package labone;


public class ComprehensivePolicy extends InsurancePolicy {
	private int driverAge;
	private int level;
	
    public ComprehensivePolicy(String policyHolderName, int id, Car car, int numberOfClaims, MyDate expiryDate, int driverAge, int level){
        super(policyHolderName, id, car, numberOfClaims);
        this.driverAge = driverAge;
        this.level = level;
    }
    public double calcPayment(double flatRate){
        double premium = 0.0;
        if(driverAge<30){
            premium = (car.price/50.0) + numberOfClaims * (200.0+flatRate) + ((30.0-driverAge) * 50);
        } else {
            premium = (car.price/50.0) + numberOfClaims * (200.0+flatRate);
        }
        return premium; 
    }
    @Override
    public String toString(){
    	return super.toString() + ", DriverAge:" + driverAge + ", Level:" + level;
    }
    @Override
    public void print(){
        super.print();
        System.out.println(", DriverAge:" + driverAge + ", Level:" + level);
    }
    
    
}
