/*------------------------------------------------------ 
Name: Ameer Al-Hariri
Subject code: DPIT121
Student number: 76151917
Email address: aah141@uowmail.edu.au
Task: Week 3 lab
-------------------------------------------------------*/ 
package labone;

import java.util.ArrayList;
import java.util.Scanner;

public class Program {
    //need to be declared as attributes in order to access them in any method
    public static ThirdPartyPolicy policy1,policy3,policy4,policy6;
    public static ComprehensivePolicy policy2,policy5;
    public static InsuranceCompany company;
    public static Scanner scanner; 
    public static Car car1,car2,car3,car4,car5,car6,car7,car8,car9,car10;
    public static User user1,user2;
    public static Address address1,address2,address3;
    public static MyDate defaultExpDate;
    final static int flatRate = 100;
	public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);
         
            displayMainMenu();
            
        }
        
        
        
         public static void blank(){
        System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
    }
    
    public static void displayLogIn(){
        blank();
        System.out.println("Please Enter Admin Login:");
        System.out.print("Please Eneter Username: ");
    }
    
    
    public static void displayMainMenu(){
        blank();
        System.out.println("---Main Menu---");
        System.out.println("(1) Run The Test Code");
        System.out.println("(2) Create a user");
        System.out.println("(3) Create a ThirdPartyPolicy");
        System.out.println("(4) Create a ThirdPartyPolicy");
        System.out.println("(5) Print User Information");
        System.out.println("(6) Filter by Car Model");
        System.out.println("(7) Filter by Expiry Date");
        System.out.println("(8) Update Address");
        System.out.println("(9) Log Out");
        System.out.println("\n\nSelect and Option from 1-9");
        int option = Integer.parseInt(scanner.nextLine());
            switch (option) {
                case 1:
                    runTestCode();
                    break;
                case 2:
                    creatUser();
                    break;
                case 3:
                    createThirdPartyPolicy();
                    break;
                case 4:
                    createComprehensivePolicy();
                    break;
                case 5:
                    printUserInformation();
                    break;
                case 6:
                    filterByCarModel();
                    break;
                case 7:
                    filterByExpiryDate();
                    break;
                case 8:
                    updateAddress();
                    break;
                case 9:
                    logOut();
                    break;
                default:
                        System.out.println("You Have Chosen An Invalid Option");
            }
    }
    
       public static void runTestCode(){
        Car car1 = new Car("Toyota Chaser Tourer V", CarType.SEDAN, 1998, 35000.0);
        Car car2 = new Car("Nissan Silvia S15 Spec R", CarType.COUPE, 1994, 45000.0);
        Car car3 = new Car("Honda Integra Type R", CarType.COUPE, 2020, 42000.0);
        Car car4 = new Car("Toyota Corolla KE70", CarType.SEDAN, 1984, 6000.0);
        Car car5 = new Car("Toyota Sprinter AE86", CarType.COUPE, 1983, 35000.0);
        Car car6 = new Car("Nissan S14", CarType.COUPE, 1998, 23000.0);
        Car car7 = new Car("Nissan 180SX S13", CarType.COUPE, 1991, 26000.0);
        Car car8 = new Car("Mazda MX-5 NB", CarType.COUPE, 2001, 10000.0);
        Car car9 = new Car("Mazda MX-5 NA", CarType.COUPE, 1989, 12000.0);
        Car car10 = new Car("Mazda RX7", CarType.COUPE, 2000, 75000.0);
        
        Address address1 = new Address(617, "Princes Hwy", "Kirrawee", "Sydney");
        Address address2 = new Address(610, "Princes Hwy", "Kirrawee", "Sydney");
        Address address3 = new Address(611, "Princes Hwy", "Kirrawee", "Sydney");


        //create default expiry date
        MyDate defaultExpDate = new MyDate(2023, 1, 1);

        //name, id, car, numClaims | (third party: comment | comprehensive: driverAge, level)
        ThirdPartyPolicy policy1 = new ThirdPartyPolicy("Bob", 1, car1, 1, defaultExpDate, "7 speeding violations in the past 4 years");
        ComprehensivePolicy policy2 = new ComprehensivePolicy("Billy", 2, car2, 2, defaultExpDate, 22, 1);
        ThirdPartyPolicy policy3 = new ThirdPartyPolicy("Joel", 3, car3, 0, defaultExpDate, "Clean driving record");
        ThirdPartyPolicy policy4 = new ThirdPartyPolicy("Harry", 4, car4, 1, defaultExpDate, "3 speeding violations in the past 2 years");
        ComprehensivePolicy policy5 = new ComprehensivePolicy("Ameer", 5, car5, 2, defaultExpDate, 27, 2);
        ThirdPartyPolicy policy6 = new ThirdPartyPolicy("Ziyad", 1, car6, 0, defaultExpDate, "1 Reckless Driving Offence");

        //set all exp dates
        policy1.setExpiryDate(defaultExpDate);
        policy2.setExpiryDate(defaultExpDate);
        policy3.setExpiryDate(defaultExpDate);
        policy4.setExpiryDate(defaultExpDate);
        policy5.setExpiryDate(defaultExpDate);
        policy6.setExpiryDate(defaultExpDate);

        
        
        //name, id, address, policies
        User user1 = new User("Billy Fantano", 1, address1);
        User user2 = new User("Bob Builder", 2, address2);
        
        ArrayList<User> users = new ArrayList<User>();
        users.add(user1);
        users.add(user2);

        //create insurance company
        InsuranceCompany company = new InsuranceCompany(users, "NRMA", "user", "pass", flatRate);
       }
       
        public static void creatUser() {
            //login attempt
            System.out.println("Login to the insurance company as an admin:");
            System.out.print("Enter username: ");
            String inputUsername1 = scanner.nextLine();
            System.out.print("Enter password: ");
            String inputPassword1 = scanner.nextLine();
            boolean loginAttempt1 = company.validateAdmin(inputUsername1, inputPassword1);
            if(loginAttempt1){
                System.out.println("Login Success");
            } else {
                System.out.println("Login Failure");
            }
            //unsuccessful login
            System.out.println("Login to the insurance company as an admin:");
            System.out.print("Enter username: ");
            String inputUsername2 = scanner.nextLine();
            System.out.print("Enter password: ");
            String inputPassword2 = scanner.nextLine();
            boolean loginAttempt2 = company.validateAdmin(inputUsername2, inputPassword2);
            if(loginAttempt2){
                System.out.println("Login Success");
            } else {
                System.out.println("Login Failure");
            }


            //user way 1
            System.out.println("Add users to the company:");
            boolean addUser1 = company.addUser(user1);
            if(addUser1){
                System.out.println("User ID:" + user1.getUserID() + " (" + user1.getName() + ") company addition successful (added the user instance)");
            } else {
                System.out.println("User ID:" + user1.getUserID() + " (" + user1.getName() + ") company addition unsuccessful");
            }
            //user way 2
            System.out.println("Add a user to the company:");
            System.out.print("Enter user's name: ");
            String inputUserName2 = scanner.nextLine();
            System.out.print("Enter user's ID: ");
            int inputUserID2 = Integer.parseInt(scanner.nextLine());
            boolean addUser2 = company.addUser(inputUserName2, inputUserID2, address3);
            if(addUser2){
                System.out.println("User ID:" + inputUserID2 + " (" + inputUserName2 + ") company addition successful");
            } else {
                System.out.println("User ID:" + inputUserID2 + " (" + inputUserName2 + ") company addition unsuccessful");
            }
            //usr way 2 conflicting id
            System.out.println("Add a user to the company:");
            System.out.print("Enter user's name: ");
            String inputUserName3 = scanner.nextLine();
            System.out.print("Enter user's ID: ");
            int inputUserID3 = Integer.parseInt(scanner.nextLine());
            boolean addUser3 = company.addUser(inputUserName3, inputUserID3, address3);
            if(addUser3){
                System.out.println("User ID:" + inputUserID3 + " (" + inputUserName3 + ") company addition successful");
            } else {
                System.out.println("User ID:" + inputUserID3 + " (" + inputUserName3 + ") company addition unsuccessful");
            }
        
        }
        
        public static void createThirdPartyPolicy() {
            //create 3rd party policy and add to user
            System.out.println("Create a 3rd party policy and add to a user:");
            System.out.print("User ID: ");
            int createPolicy = Integer.parseInt(scanner.nextLine());
            System.out.print("Policy holder name: ");
            String createPolicy22 = scanner.nextLine();
            System.out.print("Policy ID: ");
            int createPolicy23 = Integer.parseInt(scanner.nextLine());
            System.out.print("Number of claims: ");
            int createPolicy24 = Integer.parseInt(scanner.nextLine());
            System.out.print("Comments: ");
            String createPolicy25 = scanner.nextLine();
//            boolean addPolicy5 = company.createThirdPartyPolicy(createPolicy21, createPolicy22, createPolicy23, car8, createPolicy24, policy4Exp, createPolicy25);
            if(addPolicy5){
                System.out.println("User ID: " + createPolicy21 + ", policy ID: " + createPolicy23 + " addition successful");
            } else {
                System.out.println("User ID: " + createPolicy21 + ", policy ID: " + createPolicy23 + " addition unsuccessful");
            }
            
             //create 3rd party policy and add to user (duplicate policy id)
            System.out.println("Create a 3rd party policy and add to a user:");
            System.out.print("User ID: ");
            int createPolicy41 = Integer.parseInt(scanner.nextLine());
            System.out.print("Policy holder name: ");
            String createPolicy42 = "1";//scanner.nextLine();
            System.out.print("Policy ID: ");
            int createPolicy43 = Integer.parseInt(scanner.nextLine());
            System.out.print("Number of claims: ");
            int createPolicy44 = Integer.parseInt(scanner.nextLine());
            System.out.print("Comments: ");
            String createPolicy45 = scanner.nextLine();
            boolean addPolicy7 = company.createThirdPartyPolicy(createPolicy41, createPolicy42, createPolicy43, car10, createPolicy44, policy4Exp, createPolicy45);
            if(addPolicy7){
                System.out.println("User ID: " + createPolicy41 + ", policy ID: " + createPolicy43 + " addition successful");
            } else {
                System.out.println("User ID: " + createPolicy41 + ", policy ID: " + createPolicy43 + " addition unsuccessful");
                
            }
        }
        
        public static void createComprehensivePolicy(){
            //create a comprehensive policy and add to a user
            System.out.println("Create a comprehensive policy and add to a user:");
            System.out.print("User ID: ");
            int createPolicy11 = Integer.parseInt(scanner.nextLine());
            System.out.print("Policy holder name: ");
            String createPolicy12 = scanner.nextLine();
            System.out.print("Policy ID: ");
            int createPolicy13 = Integer.parseInt(scanner.nextLine());
            System.out.print("Number of claims: ");
            int createPolicy14 = Integer.parseInt(scanner.nextLine());
            System.out.print("Driver age: ");
            int createPolicy15 = Integer.parseInt(scanner.nextLine());
            System.out.print("Level: ");
            int createPolicy16 = Integer.parseInt(scanner.nextLine());
            boolean addPolicy4 = company.createComprehensivePolicy(createPolicy11, createPolicy12, createPolicy13, car7, createPolicy14, policy4Exp, createPolicy15, createPolicy16);
            if(addPolicy4){
                System.out.println("User ID: " + createPolicy11 + ", policy ID: " + createPolicy13 + " addition successful");
            } else {
                System.out.println("User ID: " + createPolicy11 + ", policy ID: " + createPolicy13 + " addition unsuccessful");
            }

        

            //create comprehensive policy and add to user (invalid user id)
            System.out.println("Create a comprehensive policy and add to a user:");
            System.out.print("User ID: ");
            int createPolicy31 = Integer.parseInt(scanner.nextLine());
            System.out.print("Policy holder name: ");
            String createPolicy32 = scanner.nextLine();
            System.out.print("Policy ID: ");
            int createPolicy33 = Integer.parseInt(scanner.nextLine());
            System.out.print("Number of claims: ");
            int createPolicy34 = Integer.parseInt(scanner.nextLine());
            System.out.print("Driver age: ");
            int createPolicy35 = Integer.parseInt(scanner.nextLine());
            System.out.print("Level: ");
            int createPolicy36 = Integer.parseInt(scanner.nextLine());
            boolean addPolicy6 = company.createComprehensivePolicy(createPolicy31, createPolicy32, createPolicy33, car9, createPolicy34, policy4Exp, createPolicy35, createPolicy36);
            if(addPolicy6){
                System.out.println("User ID: " + createPolicy11 + ", policy ID: " + createPolicy13 + " addition successful");
            } else {
                System.out.println("User ID: " + createPolicy11 + ", policy ID: " + createPolicy13 + " addition unsuccessful");
            } 
        }
        
        public static void printUserInformation(){
            //ask for a user id and print the user
            System.out.println("Print user along with all policies: ");
            System.out.print("Enter a userID: ");
            int inputUserID1 = Integer.parseInt(scanner.nextLine());
            User inputUser = company.findUser(inputUserID1);
            if(inputUser == null){
                System.out.println("User ID " + inputUserID1 + " not found :(");
            } else {
                System.out.println("Printing User ID " + inputUserID1 + "...");
                inputUser.print();
            }


            //ask for user id and policy id and print policy
            System.out.println("Print user's policy from id: ");
            System.out.print("Enter a userID: ");
            int inputUserID4 = Integer.parseInt(scanner.nextLine());
            System.out.print("Enter a policyID: ");
            int inputPolicyID4 = Integer.parseInt(scanner.nextLine());
            InsurancePolicy inputPolicy4 = company.findPolicy(inputUserID4, inputPolicyID4);
            if(inputPolicy4 == null){
                System.out.println("User ID " + inputUserID4 + " / Policy ID " + inputPolicyID4 + " not found :(");
            } else {
                System.out.println("Printing User ID " + inputUserID4 + " / Policy ID " + inputPolicyID4 + "...");
                inputPolicy4.print();
            }


            //print all users in the company
            System.out.println("Printing all users in the company...");
            for(User user: company.getUsers()){
                user.print();
                System.out.println("--------------");
            }
        }
        
        public static void filterByCarModel(){
           //print all policies matching a car model
           System.out.println("Print all policies matching car model...");
           System.out.print("Enter a car model: ");
           String filteredCarModel = scanner.nextLine();
           ArrayList<InsurancePolicy> filteredCarModels = company.filterByCarModel(filteredCarModel);
           InsurancePolicy.printPolicies(filteredCarModels);
        }
        
        public static void filterByExpiryDate(){
            System.out.println("Print all policies from user filtered by expiry date:"); //1/1/2024
            System.out.print("Enter a userID: ");
            Integer filteredExpUserID = Integer.parseInt(scanner.nextLine());
            System.out.println("Enter a Date: ");
            System.out.print("Year: ");
            Integer filteredExpDateY = Integer.parseInt(scanner.nextLine());
            System.out.print("Month: ");
            Integer filteredExpDateM = Integer.parseInt(scanner.nextLine());
            System.out.print("Day: ");
            Integer filteredExpDateD = Integer.parseInt(scanner.nextLine());
            MyDate filteredExpDate = new MyDate(filteredExpDateY, filteredExpDateM, filteredExpDateD);
            System.out.println("Printing policies with userID: " + filteredExpUserID + ", expiry date: " + filteredExpDate.toString());
            ArrayList<InsurancePolicy> filteredDatePolicies = company.filterByExpiryDate(filteredExpUserID, filteredExpDate);
            InsurancePolicy.printPolicies(filteredDatePolicies);
            



            //get all policies filtered by expiry date
            System.out.println("Print all policies filtered by expiry date...");
            System.out.println("Enter a Date: ");
            System.out.print("Year: ");
            Integer filteredExpDateY1 = Integer.parseInt(scanner.nextLine());
            System.out.print("Month: ");
            Integer filteredExpDateM1 = Integer.parseInt(scanner.nextLine());
            System.out.print("Day: ");
            Integer filteredExpDateD1 = Integer.parseInt(scanner.nextLine());
            MyDate filteredExpDate1 = new MyDate(filteredExpDateY1, filteredExpDateM1, filteredExpDateD1);
            ArrayList<InsurancePolicy> filteredDatePolicies1 = company.filterByExpiryDate(filteredExpDate1);
            InsurancePolicy.printPolicies(filteredDatePolicies1);
        }
        
        public static void updateAddress(){
            //update address of user
            System.out.println("Update address of a user...");
            System.out.print("Enter a userID: ");
            Integer updateAddressUserID = Integer.parseInt(scanner.nextLine());
            User updateAddressUser = company.findUser(updateAddressUserID);
            System.out.println("Enter an Address:");
            System.out.print("Enter a street number: ");
            Integer updateAddressNum = Integer.parseInt(scanner.nextLine());
            System.out.print("Enter a street: ");
            String updateAddressStreet = scanner.nextLine();
            System.out.print("Enter a suburb: ");
            String updateAddressSuburb = scanner.nextLine();
            System.out.print("Enter a city: ");
            String updateAddressCity = scanner.nextLine();
            Address updateAddress = new Address(updateAddressNum, updateAddressStreet, updateAddressSuburb, updateAddressCity);
            updateAddressUser.setAddress(updateAddress);
            System.out.println("Set userID:" + updateAddressUserID + "'s address to " + updateAddress.toString());
        }
        
        public static void logOut(){
            
        }
        
        
        

//        //policies to users being added
//        System.out.println("Add policies to users");
//        company.addPolicy(1, policy1);
//        company.addPolicy(1, policy2);
//        company.addPolicy(1, policy3);
//        System.out.println("Added 3 policies to userID: 1");
//
//        System.out.println("Add policies userID: 2:");
//        boolean addPolicy1 = company.addPolicy(2, policy4);
//        if(addPolicy1){
//            System.out.println("User ID:" + user2.getUserID() + ", policy ID:" + policy4.getId() + " addition successful");
//        } else {
//            System.out.println("User ID:" + user2.getUserID() + ", policy ID:" + policy4.getId() + " addition unsuccessful");
//        }
//        //invalid user id
//        System.out.println("Added policy instance to userID: 2, now add to user 3 (id invalid)");
//        boolean addPolicy2 = company.addPolicy(3, policy5);
//        if(addPolicy2){
//            System.out.println("User ID:3, policy ID:" + policy5.getId() + " addition successful");
//        } else {
//            System.out.println("User ID:3, policy ID:" + policy5.getId() + " addition unsuccessful");
//        }
//        //duplicate policy id
//        System.out.println("Now add to user 1 (duplicate policy id)");
//        boolean addPolicy3 = company.addPolicy(2, policy6);
//        if(addPolicy3){
//            System.out.println("User ID:2, policy ID:" + policy6.getId() + " addition successful");
//        } else {
//            System.out.println("User ID:2, policy ID:" + policy6.getId() + " addition unsuccessful");
//        }
//        sep();
//
//
//        //create a date
//        System.out.println("Create a date for the following policies:"); //1/1/2023
//        System.out.print("Year: ");
        
        
//
//        
//
//       
//
//        
//        
//
//        //rise price of all cars by 10%
//        company.carPriceRise(0.1);
//        System.out.println("All company car prises raised by 10%");
//        System.out.println("Printing all users in the company... again...");
//        for(User user: company.getUsers()){
//            user.print();
//            System.out.println("--------------");
//        }
//        sep();
//
//        //ask for user id and print total payments
//        System.out.println("Print total payments from user ID:");
//        System.out.print("Enter a userID: ");
//        Integer totalPaymentsUserID = Integer.parseInt(scanner.nextLine());
//        double totalPaymentsUser = company.calcTotalPayments(totalPaymentsUserID);
//        if(totalPaymentsUser == 0){
//            System.out.println("User ID " + totalPaymentsUserID + " not found :(");
//        } else {
//            System.out.println("Total payments for userID " + totalPaymentsUserID + ": " + totalPaymentsUser);
//        }
//        sep();
//
//        //print total premium payment for all users
//        System.out.println("Total payments for all users in the company...");
//        double totalPayments = company.calcTotalPayments();
//        System.out.println("Total payments: " + totalPayments);
//        sep();
//
//        //print all policies using aray list
//        System.out.println("Printing all policies in the company...");
//        ArrayList<InsurancePolicy> allPolicies = company.allPolicies();
//        InsurancePolicy.printPolicies(allPolicies);
//        sep();

        
        

        


//        //close scanner
//        scanner.close();
//       System.gc();
    }

    //seperating method to make it easier to read different sections
//    public static void sep(){
//        System.out.println("--------------");
//        System.out.println();
    // }
// }
