import java.util.ArrayList;

public class Course {

	String courseName;
	ArrayList<Student> students;
	ArrayList<Subject> subjects;

	public Course(String cN, ArrayList<Student> st, ArrayList<Subject> sub){
		this.courseName = cN;
		this.students = st;
		this.subjects = sub;
	}

	public String getCourseName(){
	    return courseName;
	}

	public void setCourseName(String cN){
	    this.courseName = cN;
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

	public ArrayList<Subject> getSubjects(){
	    return subjects;
	}

	public void setSubjects(ArrayList<Subject> s){
	    this.subjects = s;
	} 

	public void addSubject(Subject s){
		this.subjects.add(s);
	}

	public void print(){

		System.out.println("--------------------------");
		System.out.println("Course Name: " + this.courseName);

		for (int i = 0; i < subjects.size(); i++){
			System.out.printf("\nSubject Name: %s (%s, %s %d)\n", subjects.get(i).getSubjectName(), subjects.get(i).getCode(), subjects.get(i).getSession(), subjects.get(i).getYear());
			System.out.println("Enrolled Students:");

			for (int j = 0; j < subjects.get(i).getStudents().size(); j++){
				System.out.printf("%-15s (%d)\n", subjects.get(i).getStudents().get(j).getSName(), subjects.get(i).getStudents().get(j).getSN());
			}
		}
		System.out.println("--------------------------\n");
	}
}