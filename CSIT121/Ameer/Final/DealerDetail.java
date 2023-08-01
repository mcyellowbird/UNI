import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.IOException;
import java.io.Serializable;

class Application implements Serializable {
    private String name;
    private String address;
    private String phoneno;
    private String services;

    public Application(String name, String address, String phoneno, String services) {
        this.name = name;
        this.address = address;
        this.phoneno = phoneno;
        this.services = services;
    }

    public void printDetails() {
        System.out.println("Name: " + name);
        System.out.println("Address: " + address);
        System.out.println("Phoneno: " + phoneno);
        System.out.println("Services: " + services);
    }

    // get details in string format
    public String getDetails() {
        String str = "";
        str += "Name: " + name + "\n";
        str += "Address: " + address + "\n";
        str += "Phoneno: " + phoneno + "\n";
        str += "Services: " + services;
        return str;
    }
}

public class DealerDetail {
    public static void main(String args[]) {
        Application application = new Application("John Curtis", "84 Rose Street Springwood NSW 2777 ",
                "0401566788", "delivery");
        try {
            // Create file
            FileOutputStream fileOutput = new FileOutputStream("dealerdetails.txt");
            ObjectOutputStream objOutput = new ObjectOutputStream(fileOutput);

            // Write to file
            objOutput.writeObject(application.getDetails());
            fileOutput.close();
            objOutput.close();

            // BufferedWriter output = new BufferedWriter(new FileWriter("dealerdetails.txt"));
            // output.write(application.get_details());
            // output.close();
            application.printDetails();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}