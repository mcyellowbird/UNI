/*------------------------------------------------------ 
Name: Ameer Al-Hariri
Subject code: DPIT121
Student number: 76151917
Email address: aah141@uowmail.edu.au
Task: Week 3 lab
-------------------------------------------------------*/
package labone;

public class ThirdPartyPolicy extends InsurancePolicy {
private String comments;
	
    public ThirdPartyPolicy(String policyHolderName, int id, Car car, int numberOfClaims, MyDate expiryDate, String comments){
        super(policyHolderName, id, car, numberOfClaims);
        this.comments = comments;
    }
    @Override
    public double calcPayment(double flatRate){
        return (car.price/100.0) + numberOfClaims * (200.0+flatRate); //calculates payment
    }
    @Override
    public String toString(){
        return super.toString() + ", Comments:" + comments;
    }
    @Override
    public void print(){
        super.print();
        System.out.println(", Comments:" + comments);
    }
}
