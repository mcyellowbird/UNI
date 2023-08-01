/*------------------------------------------------------ 
Name: Ameer Al-Hariri
Subject code: DPIT121
Student number: 76151917
Email address: aah141@uowmail.edu.au
Task: Week 3 lab
-------------------------------------------------------*/ 

import java.util.ArrayList;

class Program {
    public static ThirdPartyPolicy policy1,policy3,policy4,policy6;
    public static ComprehensivePolicy policy2,policy5;
    public static Car car1,car2,car3,car4,car5,car6,car7,car8,car9,car10;
    final static int flatRate = 100;

    public static ArrayList<InsurancePolicy> policies = new ArrayList<InsurancePolicy>();

    public static void main(String[] args){
        Car car1 = new Car("Toyota Chaser Tourer V", Car.CarType.SEDAN, 1998, 35000.0);
        Car car2 = new Car("Nissan Silvia S15 Spec R", Car.CarType.COUPE, 1994, 45000.0);
        Car car3 = new Car("Honda Integra Type R", Car.CarType.COUPE, 2020, 42000.0);
        Car car4 = new Car("Toyota Corolla KE70", Car.CarType.SEDAN, 1984, 6000.0);
        Car car5 = new Car("Toyota Sprinter AE86", Car.CarType.COUPE, 1983, 35000.0);
        Car car6 = new Car("Nissan S14", Car.CarType.COUPE, 1998, 23000.0);
        Car car7 = new Car("Nissan 180SX S13", Car.CarType.COUPE, 1991, 26000.0);
        Car car8 = new Car("Mazda MX-5 NB", Car.CarType.COUPE, 2001, 10000.0);
        Car car9 = new Car("Mazda MX-5 NA", Car.CarType.COUPE, 1989, 12000.0);
        Car car10 = new Car("Mazda RX7", Car.CarType.COUPE, 2000, 75000.0);
        
        ThirdPartyPolicy policy1 = new ThirdPartyPolicy("Bob", 1, car1, 1, "7 speeding violations in the past 4 years");
        ComprehensivePolicy policy2 = new ComprehensivePolicy("Billy", 2, car2, 2, 22, 1);
        ThirdPartyPolicy policy3 = new ThirdPartyPolicy("Joel", 3, car3, 0, "Clean driving record");
        ThirdPartyPolicy policy4 = new ThirdPartyPolicy("Harry", 4, car4, 1, "3 speeding violations in the past 2 years");
        ComprehensivePolicy policy5 = new ComprehensivePolicy("Ameer", 5, car5, 2, 27, 2);
        ThirdPartyPolicy policy6 = new ThirdPartyPolicy("Ziyad", 6, car6, 0, "1 Reckless Driving Offence");

        policies.add(policy1);
        policies.add(policy2);
        policies.add(policy3);
        policies.add(policy4);
        policies.add(policy5);
        policies.add(policy6);

        System.out.println("Policies using print method: \n");
        for(InsurancePolicy policy : policies){
            policy.print();
        }
        
        System.out.println("Policies using toString method: \n");
        for(InsurancePolicy policy : policies){
            System.out.println(policy.toString());
            System.out.println();
        }

        System.out.println("Policy Payments: \n");
        for(InsurancePolicy policy : policies){
            System.out.println("Policy " + policy.getID() + " Payment: " + policy.calcPayment(flatRate));
        }
    }
}