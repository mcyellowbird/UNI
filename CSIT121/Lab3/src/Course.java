import java.util.ArrayList;

class Course{
	String courseName;
	ArrayList<Subject> coreSubjects;
	ArrayList<Major> majors;
	ArrayList<Subject> electiveSubjects;

	final int MIN_CREDIT_POINTS = 144;

	public Course(String cN){
		this.courseName = cN;
		this.coreSubjects = new ArrayList<Subject>();
		this.majors = new ArrayList<Major>();
		this.electiveSubjects = new ArrayList<Subject>();
	}

	public String getCourseName(){
	    return courseName;
	}	
	public void setCourseName(String courseName){
	    this.courseName = courseName;
	}
	
	public ArrayList<Subject> getCoreSubjectList(){
	    return coreSubjects;
	}		
	public Subject getCoreSubject(String subjectName){
		for (Subject subject : coreSubjects){
			if (subject.getSubjectName() == subjectName){
				return subject;
			}
		}
		return null;
	}
	public void setCoreSubjectList(ArrayList<Subject> coreSubjects){
	    this.coreSubjects = coreSubjects;
	}
	public void addCoreSubject(Subject core){
		this.coreSubjects.add(core);
	}
	
	public ArrayList<Major> getMajorList(){
	    return majors;
	}	
	public Major getMajor(String majorName){
		for (Major major : majors){
			if (major.getMajorName().equals(majorName)){
				return major;
			}
		}
		return null;
	}
	public void setMajorList(ArrayList<Major> majors){
	    this.majors = majors;
	}
	public void addMajor(Major major){
		this.majors.add(major);
	}
	
	public ArrayList<Subject> getElectiveSubjectList(){
	    return electiveSubjects;
	}	
	public void setElectiveSubjects(ArrayList<Subject> electiveSubjects){
	    this.electiveSubjects = electiveSubjects;
	}
	public void addElective(Subject elective){
		this.electiveSubjects.add(elective);
	}
	public Subject getElectiveSubject(String electiveCode){
		for (Subject subject : electiveSubjects){
			if (subject.getSubjectCode().equals(electiveCode)){
				return subject;
			}
		}
		return null;
	}
	public boolean findElective(String electiveCode){
		for (Subject subject : electiveSubjects){
			if (subject.getSubjectCode().equals(electiveCode)){
				return true;
			}
		}
		return false;
	}
	
	public int getMinCreditPoints(){
		return MIN_CREDIT_POINTS;
	}
}