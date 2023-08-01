
package labone;

import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface // different designs  
{
    
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
    
}
