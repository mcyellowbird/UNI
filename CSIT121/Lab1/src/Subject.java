import java.util.ArrayList;

public class Subject {
	
	String subjectName, code, session;
	int year;
	ArrayList<Student> students;

	public Subject(String sN, String c, String s, int y, ArrayList<Student> st){
		this.subjectName = sN;
		this.code = c;
		this.session = s;
		this.year = y;
		this.students = st;
	}

	public String getSubjectName() {
	    return subjectName;
	}
	 
	public void setSubjectName(String sn) {
	    this.subjectName = sn;
	}

	public String getCode(){
	    return code;
	}

	public void setCode(String c){
	    this.code = code;
	}

	public String getSession(){
	    return session;
	}

	public void setSession(String s){
	    this.session = s;
	}
	
	public int getYear(){
	    return year;
	}

	public void setYear(int y){
	    this.year = y;
	}
	
	public ArrayList<Student> getStudents(){
	    return students;
	}

	public void setStudents(ArrayList<Student> s){
	    this.students = s;
	}

	public void addStudent(Student s){
		this.students.add(s);
	}

	public void removeStudent(Student s){
		if (students.contains(s)){
			this.students.remove(s);
		}
	}
}