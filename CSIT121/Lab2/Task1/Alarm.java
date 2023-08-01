public class Alarm {
    private String alarmName;
    private int hour, minute;

    public Alarm(String name, int h, int m){
    	if (h <24 && h >=0 && m <60 && m >=0){
    		this(name, h, m);
    	}
    }

    public Alarm(int h, int m){
    	if (h <24 && h >=0 && m <60 && m >=0){
    		this("", h, m);
    	}
    }

    public String getAlarmName(){
        return alarmName;
    }
    
    public void setAlarmName(String aN){
        this.alarmName = aN;
    }
    
    public int getHour(){
        return hour;
    }
    
    public void setHour(int h){
    	if (h < 24 && h >=0){
        	this.hour = h;
    	}
    }
    
    public int getMinute(){
        return minute;
    }
    
    public void setMinute(int m){
        if (m < 60 && m >=0){
        	this.minute = m;
        }
    }
    
    public String toString(){
    	return String.Format("%s, %d:%d", alarmName, hour, minute);
    }
}
