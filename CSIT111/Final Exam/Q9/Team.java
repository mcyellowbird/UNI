class Team{

	private Employee teamLeader;
	private Employee programmer;
	private Employee engineer;

	public static void main(String[] args){
		Team newTeam = new Team("Alex Norris", "Peter Chen", "Paul Smith");

		int min = (int) 1000, max = (int) 9000;

		newTeam.setTeamLeaderNumber((int) Math.ceil(Math.random() * (max - min) + min));

		newTeam.setProgrammerNumber((int) Math.ceil(Math.random() * (max - min) + min));

		newTeam.setEngineerNumber((int) Math.ceil(Math.random() * (max - min) + min));

		newTeam.printTeam();
	}

	public Team(String tL, String p, String e){
		teamLeader = new Employee(tL, 0);
		programmer = new Employee(p, 0);
		engineer = new Employee(e, 0);
	}

	public void setTeamLeaderNumber(int n){
		teamLeader.staffNumber = n;
	}

	public void setProgrammerNumber(int n){
		programmer.staffNumber = n;
	}

	public void setEngineerNumber(int n){
		engineer.staffNumber = n;
	}

	public void printTeam(){
		System.out.printf("Team Leader: %s %d", teamLeader.getFullName(), teamLeader.getStaffNumber());
		System.out.printf("\nProgrammer: %s %d", programmer.getFullName(), programmer.getStaffNumber());
		System.out.printf("\nEngineer: %s %d", engineer.getFullName(), engineer.getStaffNumber());
	}
}

class Employee{
	String fullName;
	int staffNumber;

	public Employee(String fN, int sN){
		fullName = fN;
		staffNumber = sN;
	}

	public void setFullName(String fN){
		fullName = fN;
	}

	public String getFullName(){
		return fullName;
	}

	public void setStaffNumber(int sN){
		staffNumber = sN;
	}

	public int getStaffNumber(){
		return staffNumber;
	}
}