/*------------------------------------------------------ 
Name: Ameer Al-Hariri
Subject code: DPIT121
Student number: 76151917
Email address: aah141@uowmail.edu.au
Task: Week 4 lab
-------------------------------------------------------*/
package labone;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class InsuranceCompany implements Cloneable {
    //    private ArrayList<User> users;
    private HashMap < Integer, User > users;
    private String name;
    private String adminUsername;
    private String adminPassword;
    private int flatRate;

    //    public InsuranceCompany(ArrayList<User> users, String name, String adminUsername, String adminPassword, int flatRate) {
    public InsuranceCompany(HashMap < Integer, User > users, String name, String adminUsername, String adminPassword, int flatRate) {
        this.users = users;
        this.name = name;
        this.adminUsername = adminUsername;
        this.adminPassword = adminPassword;
        this.flatRate = flatRate;
    }
    public InsuranceCompany(InsuranceCompany insurancecompany) {
        this.users = insurancecompany.users;
        this.name = insurancecompany.name;
        this.adminUsername = insurancecompany.adminUsername;
        this.adminPassword = insurancecompany.adminPassword;
        this.flatRate = insurancecompany.flatRate;
    }
    @Override
    public InsuranceCompany clone() throws CloneNotSupportedException {
        return (InsuranceCompany) super.clone();
    }

    //        public ArrayList<User> sortUsers() throws CloneNotSupportedException {
    public ArrayList < User > sortUsers() throws CloneNotSupportedException {
        //        ArrayList<User> copy = deepCopy();
        HashMap < Integer, User > copyMap = deepCopy();
        ArrayList < User > copyList = new ArrayList < User > ();
        for (Integer userID: copyMap.keySet()) {
            copyList.add(copyMap.get(userID));
        }
        Collections.sort(copyList);
        return copyList;
    }

    //deepcopy users
    //    public ArrayList<User> deepCopyUsers() throws CloneNotSupportedException{
    public HashMap < Integer, User > deepCopy() throws CloneNotSupportedException {
        return User.deepCopy(users);
    }

    public ArrayList < String > populateDistinctCityNames() {
        ArrayList < String > city = new ArrayList < String > ();
        for (Integer userID: users.keySet()) {
            if (!city.contains(users.get(userID).getCity())) {
                city.add(users.get(userID).getCity());
            }
        }
        return city;
    }
    //shallowcopy users
    //    public ArrayList<User> shallowCopyUsers(){
    public HashMap < Integer, User > shallowCopyUsers(HashMap < Integer, User > users) {
        HashMap < Integer, User > shallowCopy = new HashMap < Integer, User > ();
        for (Integer userID: users.keySet()) {
            shallowCopy.put(userID, users.get(userID));
        }
        return shallowCopy;
    }

    // goes through all the users and populate a list of distinct city names for all users and returns as list.
    public ArrayList < String > populateDistintCityNames() {
        ArrayList < String > cities = new ArrayList < String > ();
        //for(User user: users){
        for (Integer userID: users.keySet()) {
            if (!cities.contains(users.get(userID).getCity())) {
                cities.add(users.get(userID).getCity());
            }
        }
        return cities;
    }

    public HashMap < String, Integer > getTotalCountPerCarModel(ArrayList < String > carModels) {
        HashMap < String, Integer > counts = new HashMap < String, Integer > ();
        for (String carModel: carModels) {
            int total = 0;
            for (Integer userID: users.keySet()) {
                total = total + users.get(userID).getTotalCountForCarModel(carModel);
            }
            counts.put(carModel, total);
        }
        return counts;
    }

    public HashMap < String, Double > getTotalPremiumPerCarModel(ArrayList < String > carModels) {
        HashMap < String, Double > totals = new HashMap < String, Double > ();
        for (String carModel: carModels) {
            double total = 0;
            for (Integer userID: users.keySet()) {
                total = total + users.get(userID).getTotalPaymentForCarModel(carModel);
            }
            totals.put(carModel, total);
        }
        return totals;
    }
    public void reportPaymentPerCity(ArrayList < String > cities, ArrayList < Double > payments) {
        System.out.format("%-1s", "City Name");
        System.out.format("%30s", "Total Premium Payment");
        System.out.println();
        int iterator = 0;
        while (iterator < cities.size()) {
            System.out.format("%-30s", cities.get(iterator));
            System.out.format("%1s", "$" + String.format("%,.2f", payments.get(iterator)));
            iterator++;
            System.out.println();
        }
    }
    public void reportPaymentPerCity(HashMap < String, Integer > cities, HashMap < String, Double > payments) {
        System.out.format("%-1s", "City Name");
        System.out.format("%30s", "Total Premium Payment");
        System.out.println();
        for (String city: cities.keySet()) {
            System.out.format("%-30s", cities.get(city));
            System.out.format("%1s", "$" + String.format("%,.2f", payments.get(city)));
            System.out.println();
        }
    }
    public double getTotalPaymentForCity(String city) {
        double total = 0.0;
        //for(User user: users){
        for (Integer userID: users.keySet()) {
            if (users.get(userID).getCity() == city) {
                total = total + users.get(userID).calcTotalPremiums(flatRate);
            }
        }
        return total;
    }

    public HashMap < String, Double > getTotalPremiumPerCity(ArrayList < String > cities) {
        HashMap < String, Double > citiesMap = new HashMap < String, Double > ();
        for (String city: cities) {
            citiesMap.put(city, getTotalPaymentForCity(city));
        }
        return citiesMap;
    }

    public ArrayList < Double > getTotalPaymentPerCity(ArrayList < String > cities) {
        ArrayList < Double > payments = new ArrayList < Double > ();
        for (String city: cities) {
            payments.add(getTotalPaymentForCity(city));
        }
        return payments;
    }

    //validate an admin given their input username and password
    public boolean validateAdmin(String username, String password) {
        //System.out.println("test1");
        if (username.equals(adminUsername) && password.equals(adminPassword)) {
            return true;
        } else {
            return false;
        }
    }

    //add user to company 
    public boolean addUser(User user) {
        if (findUser(user.getUserID()) != null) {
            return false;
        }
        users.put(user.getUserID(), user);
        Program.nextUserID = Program.nextUserID + 1;
        return true;
    }

    //add user to company
    public boolean addUser(String name, int userID, Address address) {
        if (findUser(userID) != null) {
            return false;
        }
        User newUser = new User(name, userID, address);
        return addUser(newUser);
    }

    //find user given that have been given to user ID
    public User findUser(int userID) {
        if (users.get(userID) == null) {
            System.out.println("User not found");
            return null;
        } else {
            return users.get(userID);
        }
    }

    //add policy to the user ID
    public boolean addPolicy(int userID, InsurancePolicy policy) {
        User user = findUser(userID);
        if (user == null) {
            return false;
        }
        user.addPolicy(policy);
        return true;
    }

    //find policy that has been given to a user id and a policy id
    public InsurancePolicy findPolicy(int userID, int policyID) {
        User user = findUser(userID);
        if (user == null) {
            return null;
        }
        for (Integer policyKey: user.getPolicies().keySet()) {
            if (policyID == policyKey) {
                return user.getPolicies().get(policyKey);
            }
        }
        return null;
    }

    //print all the policies from the user id
    public void printPolicies(int userID) {
        User user = findUser(userID);
        if (user == null) {
            System.out.print("User ID " + userID + " user ID Has Not Been found");
        }
        for (InsurancePolicy policy: user.getPolicies().values()) {
            policy.print();
        }
    }

    //create a third party policy and add to the user id
    public boolean createThirdPartyPolicy(int userID, String policyHolderName, int id, Car car, int numberOfClaims, MyDate expiryDate, String comments) {
        User user = findUser(userID);
        if (user == null) {
            return false;
        }
        boolean userTest = user.createThirdPartyPolicy(policyHolderName, id, car, numberOfClaims, expiryDate, comments);
        if (!userTest) {
            return false;
        }
        return true;
    }

    //create comprehensive policy, add user id
    public boolean createComprehensivePolicy(int userID, String policyHolderName, int id, Car car, int numberOfClaims, MyDate expiryDate, int driverAge, int level) {
        User user = findUser(userID);
        if (user == null) {
            return false;
        }
        boolean userTest = user.createComprehensivePolicy(policyHolderName, id, car, numberOfClaims, expiryDate, driverAge, level);
        if (!userTest) {
            return false;
        }
        return true;
    }

    //calculate total payments for a user id
    public double calcTotalPayments(int userID) {
        User user = findUser(userID);
        if (user == null) {
            return 0.0;
        }
        return user.calcTotalPremiums(flatRate);
    }

    //calctotalpayments across company
    public double calcTotalPayments() {
        double total = 0.0;
        //for(User user: users){
        for (Integer userID: users.keySet()) {
            total = total + users.get(userID).calcTotalPremiums(flatRate);
        }
        return total;
    }

    //increase car price across all of the users policies
    public boolean carPriceRise(int userID, double risePercent) {
        User user = findUser(userID);
        if (user == null) {
            return false;
        }
        user.carPriceRiseAll(risePercent);
        return true;
    }

    //increase car price across all the users
    public void carPriceRise(double risePercent) {
        //for(User user: users){
        for (Integer userID: users.keySet()) {
            users.get(userID).carPriceRiseAll(risePercent);
        }
    }

    //return all policies in the company
    //public ArrayList<InsurancePolicy> allPolicies(){
    public HashMap < Integer, InsurancePolicy > allPolicies() {
        //ArrayList<InsurancePolicy> all = new ArrayList<InsurancePolicy>();
        HashMap < Integer, InsurancePolicy > all = new HashMap < Integer, InsurancePolicy > ();
        //for(User user: users){
        for (Integer userID: users.keySet()) {
            //for(InsurancePolicy policy: user.getPolicies()){
            for (Integer policyID: users.get(userID).getPolicies().keySet()) {
                //all.put(policy);
                all.put(policyID, users.get(userID).getPolicies().get(policyID));
            }
        }
        return all;
    }

    //public ArrayList<InsurancePolicy> filterByCarModel(int userID, String carModel){
    public HashMap < Integer, InsurancePolicy > filterByCarModel(int userID, String carModel) {
        User user = findUser(userID);
        if (user == null) {
            return null;
        }
        //ArrayList<InsurancePolicy> policies = user.getPolicies();
        HashMap < Integer, InsurancePolicy > policies = user.getPolicies();
        return InsurancePolicy.filterByCarModel(policies, carModel);
    }

    //public ArrayList<InsurancePolicy> filterByExpiryDate(int userID, MyDate date){
    public HashMap < Integer, InsurancePolicy > filterByExpiryDate(int userID, MyDate date) {
        User user = findUser(userID);
        if (user == null) {
            return null;
        }
        HashMap < Integer, InsurancePolicy > policies = user.getPolicies();
        return InsurancePolicy.filterByExpiryDate(policies, date);
    }

    //return the filtered list of policies from car model
    //public ArrayList<InsurancePolicy> filterByCarModel(String carModel){
    public HashMap < Integer, InsurancePolicy > filterByCarModel(String carModel) {
        HashMap < Integer, InsurancePolicy > policies = allPolicies();
        return InsurancePolicy.filterByCarModel(policies, carModel);
    }

    //return a filtered list of policies from expiry date
    //public ArrayList<InsurancePolicy> filterByExpiryDate(MyDate date){
    public HashMap < Integer, InsurancePolicy > filterByExpiryDate(MyDate date) {
        HashMap < Integer, InsurancePolicy > policies = allPolicies();
        return InsurancePolicy.filterByExpiryDate(policies, date);
    }

    //print and to a string
    public void print() {
        //for(User user: users){
        for (Integer userID: users.keySet()) {
            users.get(userID).print();
            users.get(userID).printPolicies();
        }
    }
    public String toString() {
        String str = "";
        //for(User user: users){
        for (Integer userID: users.keySet()) {
            str = str + users.get(userID).toString() + "\n";
        }
        return str;
    }

    //this is the getters and setters
    public HashMap < Integer, User > getUsers() {
        return users;
    }

    public void printUsers(){
        for (User u : users.values()){
            u.print();
        }
    }
    //    public HashMap<Integer, User> getUsers(){
    //        return users;
    //    }
    //    public void setUsers(ArrayList<User> users){
    //        this.users = users;
    //    }
    public void setUsers(HashMap < Integer, User > users) {
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