public class Student {

	String studentName, dateOfBirth, sex;
	int studentNumber;

	public Student(String n, String d, String s, int sN){
		this.studentName = n;
		this.dateOfBirth = d;
		this.sex = s;
		this.studentNumber = sN;
	}
	
	public String getSName(){
		return studentName;
	}

	public void setSName(String n){
		this.studentName = n;
	}

	public String getDOB(){
		return dateOfBirth;
	}

	public void setDOB(String d){
		this.dateOfBirth = d;
	}

	public String getSex(){
		return sex;
	}

	public void setSex(String s){
		this.sex = s;
	}

	public int getSN(){
		return studentNumber;
	}

	public void setSN(int sN){
		this.studentNumber = sN;
	}
}