class Calendar
{
	public enum Day {SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY}

	public static void main(String[] args)
	{
		Day lectureDay, labDay;

		lectureDay = Day.TUESDAY;
		labDay = Day.WEDNESDAY;
		String lectureTime = "16:30";
		String labTime = "17:30";

		for(Day d:Day.values()){ // Loop through each day and print its value
			System.out.printf("%s      ", d);
		}

		System.out.println();

		for(Day d:Day.values()){ // Loop through each day and check if there is a lecture or lab
			if(lectureDay == d){
				System.out.printf(" Lecture %s   ", lectureTime);
			}
			else if(labDay == d){
				System.out.printf("Lab %s", labTime);
			}
			else{System.out.print("          ");}
		}

		System.out.print("\n");
	}
}