/*------------------------------------------------------ 
Name: Ameer Al-Hariri
Subject code: DPIT121
Student number: 76151917
Email address: aah141@uowmail.edu.au
Task: Week 4 lab
-------------------------------------------------------*/
package labone;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.HashMap;

public class Program {
    //these need to be declared as attributes in order to access them in any method
    public static ThirdPartyPolicy policy1, policy3, policy4, policy6;
    public static ComprehensivePolicy policy2, policy5;
    public static InsuranceCompany company;
    public static Scanner scanner;
    public static Car car1, car2, car3, car4, car5, car6, car7, car8, car9, car10;
    //public static User user1,user2;
    public static Address address1, address2, address3;
    public static MyDate defaultExpDate;
    final static int flatRate = 100;
    public static int currentUserID = -1;
    public static int nextUserID = 1;

    public static HashMap < Integer, User > users = new HashMap < Integer, User > ();

    public static void login() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        if (company.validateAdmin(username, password)) {
            displayAdminConsole();
        } else {
            displayNormieConsole();
        }
    }
    public static void main(String[] args) {

        //        address1 = new Address(617, "Princes Hwy", "Kirrawee", "Sydney");
        //        address2 = new Address(610, "Princes Hwy", "Kirrawee", "Sydney");
        //        address3 = new Address(611, "Princes Hwy", "Kirrawee", "Sydney");
        //        User user1 = new User("Billy Fantano", 1, address1);
        //        User user2 = new User("Bob Builder", 2, address2);
        //
        //        users.add(user1);
        //        users.add(user2);
        //        HashMap<Integer, User> users = new HashMap<Integer, User>();
        //
        //        //create insurance company
        //        company = new InsuranceCompany(users, "NRMA", "bob", "lol", flatRate);
        initalizeData();

        //        user1 = new User("Billy Fantano", nextUserID, address1);
        //        //users.add(user1);
        //        users.put(nextUserID, user1);
        //        nextUserID++;
        //        user2 = new User("Bob Builder", nextUserID, address2);
        //        //users.add(user2);
        //        users.put(nextUserID, user2);
        //        nextUserID++;
        login();

    }

    public static void blank() {
        System.out.print("\n\n\n");
    }

    public static int getIntInput() {
        boolean success = false;
        int x = 0;
        while (!success) {
            try {
                x = Integer.parseInt(scanner.nextLine());
                success = true;
                break;
            } catch (Exception e) {
                System.out.print("Input error: Please input a valid integer: ");
            }
        }
        return x;
    }
    //get string input 
    public static String getStringInput() {
        boolean success = false;
        String x = "";
        while (!success) {
            try {
                x = scanner.nextLine();
                success = true;
                break;
            } catch (Exception e) {
                System.out.print("Input error: Please input a valid string: ");
            }
        }
        return x;
    }

    public static void displayLogIn() {
        blank();
        System.out.println("Please Enter Admin Login:");
        System.out.print("Please Eneter Username: ");
    }
    public static void displayNormieConsole() {
        blank();
        Scanner scanner = new Scanner(System.in);
        System.out.println("---Main Menu---");
        System.out.println("(1) Print User Information");
        System.out.println("(2) Filter by Car Model");
        System.out.println("(3) Filter by Expiry Date");
        System.out.println("(4) Update Address");
        System.out.println("(5) Log Out");
        System.out.println("\n\nSelect and Option from 1-5");
        int option = scanner.nextInt();
        switch (option) {
        case 1:
            printUserInformation();
            displayNormieConsole();
            break;
        case 2:
            filterByCarModel();
            displayNormieConsole();
            break;
        case 3:
            filterByExpiryDate();
            displayNormieConsole();
            break;
        case 4:
            updateAddress();
            displayNormieConsole();
            break;
        case 5:
            logOut();
            break;
        default:
            System.out.println("You Have Chosen An Invalid Option");
        }
    }

    public static void displayAdminConsole() {
        blank();
        Scanner scanner = new Scanner(System.in);
        System.out.println("---Admin Menu---");
        System.out.println("(1) Run The Test Code - ERROR");
        System.out.println("(2) Create a user");
        System.out.println("(3) Create a ThirdPartyPolicy");
        System.out.println("(4) Create a ComprehensivePolicy");
        System.out.println("(5) Print User Information");
        System.out.println("(6) Filter by Car Model");
        System.out.println("(7) Filter by Expiry Date");
        System.out.println("(8) Update Address");
        System.out.println("(9) Log Out");
        System.out.println("\n\nSelect and Option from 1-9");
        int option = scanner.nextInt();
        switch (option) {
        case 1:
            runTestCode();
            displayAdminConsole();
            break;
        case 2:
            creatUser();
            displayAdminConsole();
            break;
        case 3:
            createThirdPartyPolicy();
            displayAdminConsole();
            break;
        case 4:
            createComprehensivePolicy();
            displayAdminConsole();
            break;
        case 5:
            printUserInformation();
            displayAdminConsole();
            break;
        case 6:
            filterByCarModel();
            displayAdminConsole();
            break;
        case 7:
            filterByExpiryDate();
            displayAdminConsole();
            break;
        case 8:
            updateAddress();
            displayAdminConsole();
            break;
        case 9:
            logOut();
            break;
        default:
            System.out.println("You Have Chosen An Invalid Option");
        }
    }

    public static void initalizeData() {
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

        address1 = new Address(617, "Princes Hwy", "Kirrawee", "Sydney");
        address2 = new Address(610, "Princes Hwy", "Kirrawee", "Sydney");
        address3 = new Address(611, "Princes Hwy", "Kirrawee", "Sydney");

        User user1 = new User("Billy Fantano", 1, address1);
        User user2 = new User("Bob Builder", 2, address2);

        users.put(1, user1);
        users.put(2, user2);

        //create insurance company
        company = new InsuranceCompany(users, "NRMA", "bob", "lol", flatRate);
        company.addPolicy(1, policy1);
        company.addPolicy(2, policy2);
        //        company.addPolicy(1, policy6);
    }

    public static void runTestCode() {

        ArrayList < String > cityNames = company.populateDistinctCityNames();
        ArrayList < Double > cityPayments = company.getTotalPaymentPerCity(cityNames);

        company.reportPaymentPerCity(cityNames, cityPayments);

        //name, id, address, policies
        System.out.println("User policies cloning...");
        User user1ToCopy = company.findUser(1);
        company.print();
        ArrayList < InsurancePolicy > user1DeepCopy = new ArrayList < InsurancePolicy > ();
        try {
            user1DeepCopy = user1ToCopy.deepCopyPolicies();
        } catch (Exception f) {
            //            f.printStackTrace();
        }
        ArrayList < InsurancePolicy > user1ShallowCopy = new ArrayList < InsurancePolicy > ();
        try {
            user1ShallowCopy = user1ToCopy.shallowCopyPolicies();
        } catch (Exception f) {

        }
        user1ToCopy.setCity("Sydney");
        MyDate expDate1 = new MyDate(2020, 3, 3);
        user1ToCopy.createComprehensivePolicy("Bob", 4, car8, 2, expDate1, 64, 2);
        ArrayList < InsurancePolicy > user1sorted = new ArrayList < InsurancePolicy > ();
        try {
            user1sorted = user1ToCopy.sortPoliciesByDate();
        } catch (CloneNotSupportedException f) {
            f.printStackTrace();
        }
        // ERROR
        // System.out.println("Printing user ones current policies, this is sorted by expiry date.");
        // for (InsurancePolicy pol : user1sorted){
        //     pol.print();
        // }

        // ERROR
        // System.out.println("Printing user ones deep copy policies..");
        // InsurancePolicy.printPolicies(user1DeepCopy);

        // ERROR
        // System.out.println("Printing user ones shallow copy policies..");
        // InsurancePolicy.printPolicies(user1ShallowCopy);

        // ERROR
        //copy company users and print
        // System.out.println("Company users is cloning");
        // HashMap < Integer, User > companyUsersDeepCopy = new HashMap < Integer, User > ();
        // try {
        //     companyUsersDeepCopy = company.deepCopy();
        // } catch (Exception f) {
        //     f.printStackTrace();
        // }

        // ERROR
        HashMap < Integer, User > companyUsersShallowCopy = company.shallowCopyUsers(company.getUsers());
        // company.addUser("Bill Clinton", nextUserID, address3);
        // ArrayList < User > sortedUsers = new ArrayList < User > ();
        // try {
        //     sortedUsers = company.sortUsers();
        // } catch (Exception f) {
        //     f.printStackTrace();
        // }
        // System.out.println("Printing the current company users (this is sorted by city name).......");
        // User.printUsers(sortedUsers);

        // ERROR
        // System.out.println("Printing the deep copy company users.......");
        // User.printUsers(companyUsersDeepCopy);

        // ERROR
        // System.out.println("Printing the shallow copy company users.......");
        // User.printUsers(companyUsersShallowCopy);

        // ERROR
        //clone insurance company
        // System.out.println("Check that insurance company deep copy works");
        // InsuranceCompany company1Copy = null;
        // try {
        //     company1Copy = company.clone();
        // } catch (Exception e) {
        //     e.printStackTrace();
        // }

        // ERROR
        // System.out.println("Total payments for original company: " + company.calcTotalPayments());
        // System.out.println("Total payments for cloned company: " + company1Copy.calcTotalPayments());

        //fimished
        System.out.println("Test code ran successfully");
        System.out.print("Press enter to return to the admin menu");
    }

    public static void creatUser() {
        Scanner scanner = new Scanner(System.in);

        // Create a user
        System.out.println("WIP. Need to create a user");

    }
    public static Car createCar() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Model: ");
        String model = scanner.nextLine();
        System.out.print("Enter Type: ");
        String type = scanner.nextLine();
        CarType ct;
        if (type == "sedan") {
            ct = CarType.SEDAN;
        } else if (type == "suv") {
            ct = CarType.SUV;
        } else if (type == "coupe") {
            ct = CarType.COUPE;
        } else if (type == "hatch") {
            ct = CarType.HATCH;
        } else {
            ct = CarType.WAGON;
        }

        System.out.print("Enter Manufacturing Year: ");
        int man_year = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter Price: ");
        double price = Double.parseDouble(scanner.nextLine());
        return new Car(model, ct, man_year, price);
    }
    public static MyDate createExpiryDate() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Expiry Year: ");
        int year = Integer.parseInt(scanner.nextLine());
        System.out.print("Expiry Month: ");
        int month = Integer.parseInt(scanner.nextLine());
        System.out.print("Expiry Day: ");
        int day = Integer.parseInt(scanner.nextLine());
        return new MyDate(year, month, day);
    }
    public static void createThirdPartyPolicy() {
        Scanner scanner = new Scanner(System.in);
        //create 3rd partypolicy
        System.out.println("Create a 3rd party policy and add to a user:");
        System.out.print("User ID: ");
        int uid = Integer.parseInt(scanner.nextLine());
        System.out.print("Policy holder name: ");
        String name = scanner.nextLine();
        System.out.print("Policy ID: ");
        int pid = Integer.parseInt(scanner.nextLine());
        System.out.print("Number of claims: ");
        int num_of_claims = Integer.parseInt(scanner.nextLine());
        MyDate expdate = createExpiryDate();
        Car car = createCar();
        System.out.print("Comments: ");
        String comments = scanner.nextLine();
        boolean addPolicy = company.createThirdPartyPolicy(uid, name, pid, car, num_of_claims, expdate, comments);
        if (addPolicy) {
            System.out.println("User ID: " + uid + ", policy ID: " + pid + " addition successful");
        } else {
            System.out.println("User ID: " + uid + ", policy ID: " + pid + " addition unsuccessful");
        }
    }

    public static void createComprehensivePolicy() {
        Scanner scanner = new Scanner(System.in);
        //create a comprehensive policy
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
        MyDate expdate = createExpiryDate();
        boolean addPolicy4 = company.createComprehensivePolicy(createPolicy11, createPolicy12, createPolicy13, car7, createPolicy14, expdate, createPolicy15, createPolicy16);
        if (addPolicy4) {
            System.out.println("User ID: " + createPolicy11 + ", policy ID: " + createPolicy13 + " addition successful");
        } else {
            System.out.println("User ID: " + createPolicy11 + ", policy ID: " + createPolicy13 + " addition unsuccessful");
        }

    }

    public static void printUserInformation() {
        Scanner scanner = new Scanner(System.in);
        //ask for a user id and print the user
        System.out.println("Print user along with all policies: ");
        System.out.print("Enter a userID: ");
        int inputUserID1 = Integer.parseInt(scanner.nextLine());
        User inputUser = company.findUser(inputUserID1);
        if (inputUser == null) {
            System.out.println("User ID " + inputUserID1 + " not found :(");
        } else {
            System.out.println("Printing User ID " + inputUserID1 + "...");
            inputUser.print();
        }

        // //ask for user id and policy id and print policy
        // System.out.println("Print user's policy from id: ");
        // System.out.print("Enter a userID: ");
        // int inputUserID4 = Integer.parseInt(scanner.nextLine());
        // System.out.print("Enter a policyID: ");
        // int inputPolicyID4 = Integer.parseInt(scanner.nextLine());
        // InsurancePolicy inputPolicy4 = company.findPolicy(inputUserID4, inputPolicyID4);
        // if(inputPolicy4 == null){
        //     System.out.println("User ID " + inputUserID4 + " / Policy ID " + inputPolicyID4 + " not found :(");
        // } else {
        //     System.out.println("Printing User ID " + inputUserID4 + " / Policy ID " + inputPolicyID4 + "...");
        //     inputPolicy4.print();
        // }

        //             //print all users in the company
        //             System.out.println("Printing all the users that are in the company.");
        // //            for(User user: company.getUsers()){
        //                 for(Integer userID: company.getUsers().keySet()){

        // //                user.print();
        //                 System.out.println("---------");
        //             }
    }

    public static void filterByCarModel() {
        Scanner scanner = new Scanner(System.in);
        //print all policies matching that match a car model
        System.out.println("Print all policies matching car model...");
        System.out.print("Enter a car model: ");
        String filteredCarModel = scanner.nextLine();
        HashMap < Integer, InsurancePolicy > filteredCarModels = company.filterByCarModel(filteredCarModel);
        InsurancePolicy.printPolicies(filteredCarModels);
    }

    public static void filterByExpiryDate() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Print all policies from user filtered by expiry date:"); //1/1/2024
        System.out.print("Enter a userID: ");
        Integer filteredExpUserID = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter a Year: ");
        Integer filteredExpDateY = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter a Month: ");
        Integer filteredExpDateM = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter a Day: ");
        Integer filteredExpDateD = Integer.parseInt(scanner.nextLine());
        MyDate filteredExpDate = new MyDate(filteredExpDateY, filteredExpDateM, filteredExpDateD);
        System.out.println("Printing policies with userID: " + filteredExpUserID + ", expiry date: " + filteredExpDate.toString());
        HashMap < Integer, InsurancePolicy > filteredDatePolicies = company.filterByExpiryDate(filteredExpUserID, filteredExpDate);
        InsurancePolicy.printPolicies(filteredDatePolicies);
    }

    public static void updateAddress() {
        Scanner scanner = new Scanner(System.in);
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

    public static void logOut() {
        System.out.print("You have logged out: ");
        login();
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