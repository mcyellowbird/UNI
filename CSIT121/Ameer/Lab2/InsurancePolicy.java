public abstract class InsurancePolicy {
    String policyHolderName;
    int id;
    Car car;
    int numberOfClaims;

    public InsurancePolicy(String pH, int id, Car car, int nC){
        this.policyHolderName = pH;
        this.id = id;
        this.car = car;
        this.numberOfClaims = nC;
    }
    
    public void print(){
        System.out.println("Policy Holder: " + policyHolderName);
        System.out.println("ID: " + id);
        System.out.println("Number of Claims: " + numberOfClaims);
        System.out.println(car.toString());
    }

    public int getID(){
        return id;
    }

    @Override
    public String toString(){
        return "Policy Holder: " + policyHolderName +
               "\nID: " + id +
               "\nNumber of Claims: " + numberOfClaims +
               car.toString();
    }

    public abstract double calcPayment(double flatRate);
}
