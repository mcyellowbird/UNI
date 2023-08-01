import java.util.ArrayList; import java.util.Scanner;

class TestCourse{
	
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		Student amyBell = new Student("Amy Bell", "01/01/2001", "Female", 100001);
		Student bobBrown = new Student("Bob Brown", "02/02/2002", "Male", 100002);
		Student cindyMa = new Student("Cindy Ma", "03/03/2001", "Female", 100003);
		Student davidHintz = new Student("David Hintz", "04/04/2000", "Male", 100004);

		Subject csit111 = new Subject("Programming Fundamentals", "CSIT111", "Spring", 2021, new ArrayList<Student>());
		Subject csit121 = new Subject("Object Oriented Design and Programming", "CSIT121", "Spring", 2021, new ArrayList<Student>());

		Course comSci = new Course("Bachelor of Computer Science", new ArrayList<Student>(), new ArrayList<Subject>());

		comSci.addStudent(amyBell);
		comSci.addStudent(bobBrown);
		comSci.addStudent(cindyMa);
		comSci.addStudent(davidHintz);

		csit111.addStudent(amyBell);
		csit111.addStudent(bobBrown);
		csit111.addStudent(cindyMa);

		csit121.addStudent(davidHintz);

		comSci.addSubject(csit111);
		comSci.addSubject(csit121);

		comSci.print();

		csit111.removeStudent(cindyMa);
		csit121.addStudent(cindyMa);

		comSci.print();
		System.out.println("John cunt : " + input.nextLine());
	} 	
}