import java.util.Scanner;

public class AlarmView {
    public AlarmView(){

    }

    public String userCreateAnAlarm(){
    	Scanner input = new Scanner(System.in);

    	System.out.println("Create a new Alarm");
    	System.out.println("------------------");
    	System.out.println("Name of Alarm: ");
    	System.out.println("Hour of Alarm: ");
    	System.out.println("Minute of Alarm: ");
    }

    public int getAlarmIndex(){

    }

    public void displayAlarm(String alarm){
    	System.out.println(alarm);
    }
}
