public class ComprehensivePolicy extends InsurancePolicy {
    int driverAge;
    int level;

    public ComprehensivePolicy(String pH, int id, Car car, int nC, int dA, int level){
        super(pH, id, car, nC);
        this.driverAge = dA;
        this.level = level;
    }

    public void print(){
        super.print();
        System.out.println("Driver Age: " + driverAge);
        System.out.println("Policy Level: " + level);
        System.out.println();
    }

    @Override
    public String toString(){
        return super.toString() +
               "\nDriver Age: " + driverAge +
               "\nLevel: " + level;
    }

    @Override
    public double calcPayment(double flatRate){
        if (driverAge < 30){
            return (car.getPrice() / 50 + numberOfClaims * 200 + flatRate + ((30 - driverAge) * 50));
        }
        else{
            return (car.getPrice() / 50 + numberOfClaims * 200 + flatRate);
        }
    }
}
