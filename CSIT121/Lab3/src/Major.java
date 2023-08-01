import java.util.ArrayList;

class Major{
	String majorName;
	ArrayList<Subject> majorSubjects;

	public Major(String mN, ArrayList<Subject> mS){
		this.majorName = mN;
		this.majorSubjects = mS;
	}

	public Major(String mN){
		this.majorName = mN;
		this.majorSubjects = new ArrayList<Subject>();
	}

	public String getMajorName(){
	    return majorName;
	}	
	public void setMajorName(String major){
	    this.majorName = majorName;
	}
	
	public ArrayList<Subject> getMajorSubjects(){
	    return majorSubjects;
	}	
	public void setMajorSubjects(ArrayList<Subject> majorSubjects){
	    this.majorSubjects = majorSubjects;
	}
	public void addMajorSubject(Subject majorSub){
		this.majorSubjects.add(majorSub);
	}
	public boolean findMajorSubject(String subjectCode){
		for (Subject subject : majorSubjects){
			if (subject.getSubjectCode().equals(subjectCode)){
				return true;
			}
		}
		return false;
	}
}