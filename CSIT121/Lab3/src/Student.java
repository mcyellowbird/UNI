class Student{
	String fullName;
	int studentNumber;
	String gender;
	String dateOfBirth;

	public Student(String fN, int sN, String g, String d){
		this.fullName = fN;
		this.studentNumber = sN;
		this.gender = g;
		this.dateOfBirth = d;
	}

	public String getFullName(){
	    return fullName;
	}	
	public void setFullName(String fullName){
	    this.fullName = fullName;
	}

	public int getStudentNumber(){
	    return studentNumber;
	}	
	public void setStudentNumber(int studentNumber){
	    this.studentNumber = studentNumber;
	}
	
	public String getGender(){
	    return gender;
	}	
	public void setGender(String gender){
	    this.gender = gender;
	}
	
	public String getDateOfBirth(){
	    return dateOfBirth;
	}	
	public void setDateOfBirth(String dateOfBirth){
	    this.dateOfBirth = dateOfBirth;
	}
}