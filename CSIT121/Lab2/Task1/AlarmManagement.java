import java.util.ArrayList;

public class AlarmManagement {
    private ArrayList<Alarm> alarms;
    private AlarmView view;

    public AlarmManagement(){

    }

    public addAlarm(Alarm alarm){
    	alarms.add(alarm);
    }

    public Alarm getAlarmAt(int index){
    	return alarms.get(index);
    }

    public void addAlarmFromView(){
    	
    }

    public void displayAlarmView(){
    	view.userCreateAnAlarm();
    }
}
