/*------------------------------------------------------ 
Name: Ameer Al-Hariri
Subject code: DPIT121
Student number: 76151917
Email address: aah141@uowmail.edu.au
Task: Week 3 lab
-------------------------------------------------------*/
package labone;

import java.util.ArrayList;

public class InsuranceCompany {
    private ArrayList<User> users;
    private String name;
    private String adminUsername;
    private String adminPassword;
    private int flatRate;

    public InsuranceCompany(ArrayList<User> users, String name, String adminUsername, String adminPassword, int flatRate) {
        this.users = users;
        this.name = name;
        this.adminUsername = adminUsername;
        this.adminPassword = adminPassword;
        this.flatRate = flatRate;
    }
    
//    // goes through all the users and populate a list of distinct city names for all users and returns as list.
//    public ArrayList<String> populateDistinctCityNames(){
//        ArrayList<String> city = new ArrayList<String>();
//        for (User user: users) {
//            if(!city.contains (user.getCity())){
//                city.add(user.getCity());
//            }
//        }
//        return city;
//    }
//    
//    public double getTotalPaymentForCity(String city) {
//        double total = 0.0;
//        for (User user: users) {
//            if(user.getCity() == city){ 
//            total = total + user.calcTotalPremiums(flatRate);
//        }
//        }
//        return total;
//    }
//    
//    public ArrayList<Double> getTotalPaymentPerCity(ArrayList<String> cities){
//        ArrayList<Double> payments = new ArrayList<Double>();
//        for(String city: cities) {
//            payments.add(getTotalPaymentForCity(city));
//        } 
//        return payments;
//    }
    
    //generates the report
    public void reportPaymentPerCity(ArrayList<String> cities, ArrayList<Double> payments){
        
    }
    
    //validate an admin given their input username and password
    public boolean validateAdmin(String username, String password){
        if(username.equals(adminUsername) && password.equals(adminPassword)){
            return true;
        } else {
            return false;
        }
    }

    //add user to company given user instance
    public boolean addUser(User user){
        if(findUser(user.getUserID()) != null){return false;}
        users.add(user);
        return true;
    }

    //add user to company given raw data
    public boolean addUser(String name, int userID, Address address){
        if(findUser(userID) != null){return false;}
        User newUser = new User(name, userID, address);
        return addUser(newUser);
    }

    //find user given user id
    public User findUser(int userID){
        for(User user: users){
            if(user.getUserID() == userID){
                return user;
            }
        }
        return null;
    }

    //add policy to a user id
    public boolean addPolicy(int userID, InsurancePolicy policy){
        User user = findUser(userID);
        if(user == null){return false;}
        user.addPolicy(policy);
        return true;
    }

    //find policy given user id and policy id
    public InsurancePolicy findPolicy(int userID, int policyID){
        User user = findUser(userID);
        if(user == null){return null;}
        for(InsurancePolicy policy: user.getPolicies()){
            if(policyID == policy.getId()){
                return policy;
            }
        }
        return null;
    }

    //print all policies from a user id
    public void printPolicies(int userID){
        User user = findUser(userID);
        if(user == null){
            System.out.print("User ID " + userID + " not found");
        }
        for(InsurancePolicy policy: user.getPolicies()){
            policy.print();
        }
    }

    //create third party policy and add to user id
    public boolean createThirdPartyPolicy(int userID, String policyHolderName, int id, Car car, int numberOfClaims, MyDate expiryDate, String comments){
        User user = findUser(userID);
        if(user == null){return false;}
        boolean userTest = user.createThirdPartyPolicy(policyHolderName, id, car, numberOfClaims, expiryDate, comments);
        if(!userTest){
            return false;
        }
        return true;
    }

    //create comprehensive policy and add to user id
    public boolean createComprehensivePolicy(int userID, String policyHolderName, int id, Car car, int numberOfClaims, MyDate expiryDate, int driverAge, int level){
        User user = findUser(userID);
        if(user == null){return false;}
        boolean userTest = user.createComprehensivePolicy(policyHolderName, id, car, numberOfClaims, expiryDate, driverAge, level);
        if(!userTest){
            return false;
        }
        return true;
    }

    //calculate total payments for user id
    public double calcTotalPayments(int userID){
        User user = findUser(userID);
        if(user == null){return 0.0;}
        return user.calcTotalPremiums(flatRate);
    }

    //calculate total payments across company
    public double calcTotalPayments(){
        double total = 0.0;
        for(User user: users){
            total = total + user.calcTotalPremiums(flatRate);
        }
        return total;
    }

    //increase price across all of a users policies
    public boolean carPriceRise(int userID, double risePercent){
        User user = findUser(userID);
        if(user == null){return false;}
        user.carPriceRiseAll(risePercent);
        return true;
    }

    //increase price across all users
    public void carPriceRise(double risePercent){
        for(User user: users){
            user.carPriceRiseAll(risePercent);
        }
    }

    //return all policies in the company
    public ArrayList<InsurancePolicy> allPolicies(){
        ArrayList<InsurancePolicy> all = new ArrayList<InsurancePolicy>();
        for(User user: users){
            for(InsurancePolicy policy: user.getPolicies()){
                all.add(policy);
            }
        }
        return all;
    }

    //return a filtered list of car models from a user
    public ArrayList<InsurancePolicy> filterByCarModel(int userID, String carModel){
        User user = findUser(userID);
        if(user == null){return null;}
        ArrayList<InsurancePolicy> policies = user.getPolicies();
        return InsurancePolicy.filterByCarModel(policies, carModel);
    }

    //return a filtered list of expiry dates under user id
    public ArrayList<InsurancePolicy> filterByExpiryDate(int userID, MyDate date){
        User user = findUser(userID);
        if(user == null){return null;}
        ArrayList<InsurancePolicy> policies = user.getPolicies();
    	return InsurancePolicy.filterByExpiryDate(policies, date);
    }

    //return a filtered list of policies from the car model from all policies in the company
    public ArrayList<InsurancePolicy> filterByCarModel(String carModel){
        ArrayList<InsurancePolicy> policies = allPolicies();
        return InsurancePolicy.filterByCarModel(policies, carModel);
    }
    
    //return a filtered list of policies from the expiry date from all policies in the company
    public ArrayList<InsurancePolicy> filterByExpiryDate(MyDate date){
        ArrayList<InsurancePolicy> policies = allPolicies();
        return InsurancePolicy.filterByExpiryDate(policies, date);
    }


    //print and to string
    public void print(){
        for(User user: users){
            user.print();
            user.printPolicies(flatRate);
        }
    }
    public String toString() {
        String str = "";
        for(User user: users){
            str = str + user.toString() + "\n";
        }
        return str;
    }


    //getters and setters
    public ArrayList<User> getUsers(){
        return users;
    }
    public void setUsers(ArrayList<User> users){
        this.users = users;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAdminUsername() {
        return this.adminUsername;
    }
    public void setAdminUsername(String adminUsername) {
        this.adminUsername = adminUsername;
    }
    public String getAdminPassword() {
        return this.adminPassword;
    }
    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }
    public int getFlatRate() {
        return this.flatRate;
    }
    public void setFlatRate(int flatRate) {
        this.flatRate = flatRate;
    }
}
