class Subject{
	String subjectName;
	String subjectCode;
	int credits;

	public Subject(String sC, String sN, int c){
		this.subjectCode = sC;
		this.subjectName = sN;
		this.credits = c;
	}

	public String getSubjectName(){
	    return subjectName;
	}	
	public void setSubjectName(String subjectName){
	    this.subjectName = subjectName;
	}
	
	public String getSubjectCode(){
	    return subjectCode;
	}	
	public void setSubjectCode(String subjectCode){
	    this.subjectCode = subjectCode;
	}
	
	public int getCredits(){
	    return credits;
	}	
	public void setCredits(int credits){
	    this.credits = credits;
	}
	
}