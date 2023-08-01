import java.util.ArrayList; import java.util.Scanner; import java.util.Arrays;

class Enrolment{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);

		// Core Subjects
		Subject CSIT111 = new Subject("CSIT111", "Programming Fundamentals", 6);
		Subject CSIT113 = new Subject("CSIT113", "Problem Solving", 6);
		Subject CSIT114 = new Subject("CSIT114", "System Analysis", 6);
		Subject CSIT115 = new Subject("CSIT115", "Data Management and Security", 6);
		Subject CSIT121 = new Subject("CSIT121", "Object Oriented Design and Programming", 6);
		Subject CSIT127 = new Subject("CSIT127", "Networks and Communication", 6);
		Subject CSIT128 = new Subject("CSIT128", "Introduction to Web Technology", 6);
		Subject CSCI235 = new Subject("CSCI235", "Database Systems", 6);
		Subject CSCI251 = new Subject("CSCI251", "Advanced Programming", 6);
		Subject CSIT214 = new Subject("CSIT214", "IT Project Management", 6);
		Subject MATH221 = new Subject("MATH221", "Mathematics for Computer Science", 6);
		Subject CSCI203 = new Subject("CSCI203", "Algorithms and Data Strctures", 6);
		Subject CSIT226 = new Subject("CSIT226", "Human Computer Interaction", 6);
		Subject CSIT314 = new Subject("CSIT314", "Software Development Methodologies", 6);
		Subject CSIT321 = new Subject("CSIT321", "Project", 12);
		Subject CSCI317 = new Subject("CSCI317", "Database Performance Tuning", 6);
		Subject INFO411 = new Subject("INFO411", "Data Mining and Knowledge Discovery", 6);
		Subject CSCI316 = new Subject("CSCI316", "Big Data Mining Techniques and Implementation", 6);
		Subject ISIT312 = new Subject("ISIT312", "Big Data Management", 6);
		Subject CSCI301 = new Subject("CSCI301", "Comntemporary Topics in Security", 6);
		Subject CSCI262 = new Subject("CSCI262", "System Security", 6);
		Subject CSCI369 = new Subject("CSCI369", "Ethical Hacking", 6);
		Subject CSIT302 = new Subject("CSIT302", "Cybersecurity", 6);
		Subject CSCI361 = new Subject("CSCI361", "Cryptography and Secure Applications", 6);
		Subject CSCI368 = new Subject("CSCI368", "Network Security", 6);
		Subject CSCI376 = new Subject("CSCI376", "Multicore and GPU Programming", 6);
		Subject CSCI236 = new Subject("CSCI236", "3D Modelling and Animation", 6);
		Subject CSCI336 = new Subject("CSCI336", "Interactive Computer Graphics", 6);
		Subject CSCI366 = new Subject("CSCI366", "Mobile Multimedia", 6);
		Subject CSCI356 = new Subject("CSCI356", "Game Engine Essentials", 6);
		Subject CSCI334 = new Subject("CSCI334", "Software Design", 6);
		Subject ISIT219 = new Subject("ISIT219", "Knowledge and Information Engineering", 6);
		Subject CSCI318 = new Subject("CSCI318", "Software Engineering Practices & Principles", 6);
		Subject ISIT315 = new Subject("ISIT315", "Semantic Web", 6);

		Major bigData = new Major("Big Data");
		bigData.addMajorSubject(CSCI317);
		bigData.addMajorSubject(INFO411);
		bigData.addMajorSubject(CSCI316);
		bigData.addMajorSubject(ISIT312);

		Major cyberSec = new Major("Cyber Security");
		cyberSec.addMajorSubject(CSCI301);
		cyberSec.addMajorSubject(CSCI262);
		cyberSec.addMajorSubject(CSCI369);
		cyberSec.addMajorSubject(CSIT302);

		Major digitalSysSec = new Major("Digital System Security");
		digitalSysSec.addMajorSubject(CSCI361);
		digitalSysSec.addMajorSubject(CSCI262);
		digitalSysSec.addMajorSubject(CSCI368);
		digitalSysSec.addMajorSubject(CSCI376);

		Major gameMobDev = new Major("Game and Mobile Development");
		gameMobDev.addMajorSubject(CSCI236);
		gameMobDev.addMajorSubject(CSCI336);
		gameMobDev.addMajorSubject(CSCI366);
		gameMobDev.addMajorSubject(CSCI356);
		gameMobDev.addMajorSubject(CSCI376);

		Major softEng = new Major("Software Engineering");
		softEng.addMajorSubject(CSCI334);
		softEng.addMajorSubject(ISIT219);
		softEng.addMajorSubject(CSCI318);
		softEng.addMajorSubject(ISIT315);

		Course bcs = new Course("Bachelor of Computer Science");
		bcs.addCoreSubject(CSIT111);
		bcs.addCoreSubject(CSIT113);
		bcs.addCoreSubject(CSIT114);
		bcs.addCoreSubject(CSIT115);
		bcs.addCoreSubject(CSIT121);
		bcs.addCoreSubject(CSIT127);
		bcs.addCoreSubject(CSIT128);
		bcs.addCoreSubject(CSCI235);
		bcs.addCoreSubject(CSCI251);
		bcs.addCoreSubject(CSIT214);
		bcs.addCoreSubject(MATH221);
		bcs.addCoreSubject(CSCI203);
		bcs.addCoreSubject(CSIT226);
		bcs.addCoreSubject(CSIT314);
		bcs.addCoreSubject(CSIT321);

		bcs.addMajor(bigData);
		bcs.addMajor(cyberSec);
		bcs.addMajor(digitalSysSec);
		bcs.addMajor(gameMobDev);
		bcs.addMajor(softEng);

		bcs.addElective(CSCI317);
		bcs.addElective(INFO411);
		bcs.addElective(CSCI316);
		bcs.addElective(ISIT312);
		bcs.addElective(CSCI301);
		bcs.addElective(CSCI262);
		bcs.addElective(CSCI369);
		bcs.addElective(CSIT302);
		bcs.addElective(CSCI361);
		bcs.addElective(CSCI368);
		bcs.addElective(CSCI376);
		bcs.addElective(CSCI236);
		bcs.addElective(CSCI336);
		bcs.addElective(CSCI366);
		bcs.addElective(CSCI356);
		bcs.addElective(CSCI334);
		bcs.addElective(ISIT219);
		bcs.addElective(CSCI318);
		bcs.addElective(ISIT315);

		System.out.println("Welcome to the enrolment system for the Bachelor of Computer Science course");
		System.out.println("The course structure is as follows:");
		System.out.println("---------------------------\n");
		System.out.printf("Course: %s", bcs.getCourseName());

		System.out.println("Core Subjects:");
		for (Subject subject : bcs.getCoreSubjectList()){
			System.out.printf("%s (%s, %dpt)\n", subject.getSubjectCode(), subject.getSubjectName(), subject.getCredits());
		}

		System.out.println("\nBig Data Major:");
		for (Subject subject : bcs.getMajor("Big Data").getMajorSubjects()){
			System.out.printf("%s (%s, %dpt)\n", subject.getSubjectCode(), subject.getSubjectName(), subject.getCredits());
		}

		System.out.println("\nCyber Security Major:");
		for (Subject subject : bcs.getMajor("Cyber Security").getMajorSubjects()){
			System.out.printf("%s (%s, %dpt)\n", subject.getSubjectCode(), subject.getSubjectName(), subject.getCredits());
		}

		System.out.println("\nDigital System Security Major:");
		for (Subject subject : bcs.getMajor("Digital System Security").getMajorSubjects()){
			System.out.printf("%s (%s, %dpt)\n", subject.getSubjectCode(), subject.getSubjectName(), subject.getCredits());
		}

		System.out.println("\nGame and Mobile Development Major:");
		for (Subject subject : bcs.getMajor("Game and Mobile Development").getMajorSubjects()){
			System.out.printf("%s (%s, %dpt)\n", subject.getSubjectCode(), subject.getSubjectName(), subject.getCredits());
		}

		System.out.println("\nSoftware Engineering Major:");
		for (Subject subject : bcs.getMajor("Software Engineering").getMajorSubjects()){
			System.out.printf("%s (%s, %dpt)\n", subject.getSubjectCode(), subject.getSubjectName(), subject.getCredits());
		}

		System.out.println("\nElective Subjects:");
		for (Subject subject : bcs.getElectiveSubjectList()){
			System.out.printf("%s (%s, %dpt)\n", subject.getSubjectCode(), subject.getSubjectName(), subject.getCredits());
		}
		System.out.println("---------------------------\n");

		System.out.println("Some personal information is required");
		System.out.print("Please enter your full name: ");
		String fullName = input.nextLine();
		System.out.print("Please enter your student number: ");
		int studentNumber = input.nextInt();
		input.nextLine();
		System.out.print("Please enter your gender: ");
		String gender = input.nextLine();
		System.out.print("Please enter your date of birth (dd/mm/yyyy): ");
		String dateOfBirth = input.nextLine();

		Student student = new Student(fullName, studentNumber, gender, dateOfBirth);

		int totalCredits = 0;
		// Adding credits from core subject list to the totalCredits variable
		for (Subject subject : bcs.getCoreSubjectList()){
			totalCredits+= subject.getCredits();
		}

		System.out.println("\nThank you for your information.");
		System.out.println("\nPlease select a major from the list:");

		for (int i = 0; i < bcs.getMajorList().size(); i++){
			System.out.printf("%d: %s\n", (i+1), bcs.getMajorList().get(i).getMajorName());
		}

		System.out.print("\nPlease make a selection from the list: ");
		int majorSelection = (input.nextInt()-1);
		input.nextLine();
		System.out.println("\nYou enrolled into " + bcs.getMajorList().get(majorSelection).getMajorName());

		for (Subject subject : bcs.getMajorList().get(majorSelection).getMajorSubjects()){
			System.out.printf("%s (%s, %dpt)\n", subject.getSubjectCode(), subject.getSubjectName(), subject.getCredits());
			totalCredits+= subject.getCredits();
		}

		System.out.println("\nSelect elective subjects from the list to continue the enrolment process");
		System.out.println("\nElective Subjects:");
		for (Subject subject : bcs.getElectiveSubjectList()){
			System.out.printf("%s (%s, %dpt)\n", subject.getSubjectCode(), subject.getSubjectName(), subject.getCredits());
		}

		int electivesPicked = 0;
		ArrayList<Subject> electiveList = new ArrayList<Subject>();
		while (electivesPicked < 4){
			System.out.println("");
			System.out.printf("Please select %d more elective subject(s) (i.e. CSIT111 | or | CSIT111, CSIT114): ", (4 - electivesPicked));
			String[] electiveCode = input.nextLine().split("[\\s,]+");

			for (int i = 0; i < electiveCode.length; i++){
				// If the elective code exists, and the elective code is not included in the Major's core subjects
				if (bcs.findElective(electiveCode[i]) == true && bcs.getMajorList().get(majorSelection).findMajorSubject(electiveCode[i]) == false){
					electiveList.add(bcs.getElectiveSubject(electiveCode[i]));
					electivesPicked++;
				}
				// If the elective code exists, but the elective code is included in the Major's core subjects
				else if (bcs.findElective(electiveCode[i]) == true && bcs.getMajorList().get(majorSelection).findMajorSubject(electiveCode[i]) == true){
					System.out.printf("(Error: %s is included in the selected Major's core subjects, pick again)\n", electiveCode[i]);
				}
				// If the elective code doesn't exist
				else if (bcs.findElective(electiveCode[i]) == false){
					System.out.printf("(Error: %s does not exist, pick again)\n", electiveCode[i]);
				}
			}
		}
		System.out.println("\nCongratulations. You have completed the enrolment to the " + bcs.getCourseName() + " course");
		System.out.println("---------------------------");
		System.out.printf("Student: %s (%d, %s, %s)\n", student.getFullName(), student.getStudentNumber(), student.getGender(), student.getDateOfBirth());


		System.out.println("\nCores:");
		for (Subject subject : bcs.getCoreSubjectList()){
			System.out.printf("%s (%s, %dpt)\n", subject.getSubjectCode(), subject.getSubjectName(), subject.getCredits());
		}

		System.out.println("\nMajor: " + bcs.getMajorList().get(majorSelection).getMajorName());
		for (Subject subject : bcs.getMajorList().get(majorSelection).getMajorSubjects()){
			System.out.printf("%s (%s, %dpt)\n", subject.getSubjectCode(), subject.getSubjectName(), subject.getCredits());
		}

		System.out.println("\nElectives:");
		for (Subject subject : electiveList){
			System.out.printf("%s (%s, %dpt)\n", subject.getSubjectCode(), subject.getSubjectName(), subject.getCredits());
			totalCredits+= subject.getCredits();
		}
		System.out.println("---------------------------");
		System.out.printf("Total Enrolled Credit Points: %d", totalCredits);
	}
}