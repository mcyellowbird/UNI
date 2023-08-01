class Alarm{
	private String alarmName;

	public Alarm(String aN, int h, int m){

	}

	public Alarm(int h, int m){
		this.alarmName = "N/A";
	}

	public String getAlarmName(){
	    return alarmName;
	}
	
	public void setAlarmName(String alarmName){
	    this.alarmName = alarmName;
	}
	
	public toString(){
		return String.Format("%s, %d:%d", alarmName, hour, minute);
	}
}