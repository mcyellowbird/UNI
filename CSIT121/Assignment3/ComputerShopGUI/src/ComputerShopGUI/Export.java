package ComputerShopGUI;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Export{
    static ObjectOutputStream output;

    public static void main(String[] args){
        openFile();
        addRecords();
        closeFile();
    }

    public static void openFile(){
        try {
            output = new ObjectOutputStream(Files.newOutputStream(Paths.get("compshop.ser")));
        }
        catch (IOException ioException){
            System.err.println("Error Opening");
            System.exit(1);
        }
    }

    public static void addRecords(){
        try{
            OrderingSystem os = new OrderingSystem();
            output.writeObject(os);
        }
        catch(IOException ioException){
            System.err.println("Error Writing");
        }
    }

    public static void closeFile(){
        try{
            if (output != null)
                output.close();
        }
        catch(IOException ioException){
            System.err.println("Error Closing");
        }
    }
}