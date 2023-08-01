#include "Person.h"
#include "Candidate.h"
#include "PoliticalParty.h"
#include "Library.h"
#include "Electorate.h"
#include "Event.h"

int main(int argc, char*argv[])
{
	int electorates = atoi(argv[1]);
	int days = atoi(argv[2]);
	
	if (electorates >= 1 && electorates <= 10 && days >= 1 && days <= 30){
		createIssues();
		createParties(electorates);
		createElectorates(electorates);
		createEvents();
		runCampaign(electorates, days);
		runElection();
	}
	else{
		cout << "Error:" << " Enter the amount of electorates to be between 1-10" << endl << "And the days to be between 1-30" << endl;
	}
	return 0;
}