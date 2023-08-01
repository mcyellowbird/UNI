class Time{
	private int hour, minute, second;

	public Time(int h, int m, int s){
		if (0<= hour < 24 && 0<= minute < 60 && 0<= second < 60){
			this.hour = h;
			this.minute = m;
			this.second = s;
		}
	}
	public Time(int m, s){
		if (0<= minute < 60 && 0<= second < 60){
			this.minute = m;
			this.second = s;
		}
	}
	public Time(int s){
		if (0<= second < 60){
			this.second = s;
		}
	}
	public Time(){
		this.hour = 0;
		this.minute = 0;
		this.second = 0;
	}

	public int getHour(){
	    return hour;
	}	
	public void setHour(int hour){
		if (0<= hour < 24)
	    	this.hour = hour;
	}

	public int getMinute(){
	    return minute;
	}	
	public void setMinute(int minute){
		if (0<= minute < 60)
	    	this.minute = minute;
	}

	public int getSecond(){
	    return second;
	}	
	public void setSecond(int second){
		if (0<= minute < 60)
	    	this.second = second;
	}
	
	public String toString(){
		return String.Format("%d:%d:%d", hour, minute, second);
	}
}