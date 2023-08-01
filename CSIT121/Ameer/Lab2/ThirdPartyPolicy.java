public class ThirdPartyPolicy extends InsurancePolicy {
    String comments;

    public ThirdPartyPolicy(String pH, int id, Car car, int nC, String comments){
        super(pH, id, car, nC);
        this.comments = comments;
    }

    public void print(){
        super.print();
        System.out.println("Comments: " + comments);
        System.out.println();
    }

    @Override
    public String toString(){
        return super.toString() +
               "\nComments: " + comments;
    }
    
    @Override
    public double calcPayment(double flatRate){
        return (car.getPrice() / 100 + numberOfClaims * 200 + flatRate);
    }
}
