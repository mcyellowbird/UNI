#include "Library.h"
#include "Person.h"
#include "Candidate.h"
#include "PoliticalParty.h"
#include "Electorate.h"
#include "Event.h"

// Lists of electorates, parties, events and issues.
vector<Electorate> electorates;
vector<PoliticalParty> parties;
vector<Event> events;
vector<Event> issues;


// String array of full names for candidates
vector<string> names = {"Barnaby Joyce", "Bill Shorten", "Christopher McEwan", "Clive Palmer", "Donald Trump", "Duong Dong", "Elon Musk", "Fenghui Ren", "Hallam Roberts", "Henry Huang", "Jack Yank", "Jacqui Lambie", "Jane Doe", "Jonathan Fox",
"Julia Gillard", "Julie Bishop", "Kevin Rudd", "Malcolm Turnbull", "Mark Zuckerberg", "Ngoc Le", "Nicholas Sutherland", "Pairat Thorncharoensri", "Partha Roy", "Paul Keating", "Pauline Hanson",
"Peter Dutton", "Scott Morrison", "Tony Abbot", "William Morgan", "Sarai Rojas", "Jaydon Paul", "Lola Rice", "Alannah Kirby", "Abigayle Cross", "Arjun Richardson", "Kyra Forbes", "Shyann Chan", "Marvin Parker", "Joey Benjamin", "Aileen Cervantes"};

// String array of city names for electorates
string electorateNames[] = {"Arkham City", "Flavour Town", "Funky Town", "Gotham City", "Las Venturas", "Liberty City", "Los Santos", "North Yankton", "Springfield", "Vice City", "Wollongong"};

// Method to create parties and establish their candidates and leaders
void createParties(int n)
{
	cout << "==== POLITICAL PARTIES ====" << endl;
	cout << "---------------------------\n" << endl;

	// Establishing 3 parties
	PoliticalParty party1("Liberal Party", 2);
	parties.push_back(party1);

	PoliticalParty party2("Labor Party", 5);
	parties.push_back(party2);

	PoliticalParty party3("Independent Party", 8);
	parties.push_back(party3);

	// Looping through each party
	int rand = 0;
	for (int i = 0; i < 3; ++i)
	{
		// Looping through and adding 'n' amount of candidates to each party
		for (int j = 0; j < n; ++j)
		{
			// Creating a candidate
			rand = randomUniform(0, names.size() - 1);
			string tempName = names[rand];
			Candidate newCan(tempName, 1, 1);
			names.erase(names.begin()+rand);
			// Adding the new candidate to the party
			parties[i].pushCandidate(newCan);
		}
	}

	// Establishing leaders for each party
	rand = randomUniform(0, names.size() - 1);
	Candidate leader1(names[rand], 1, 1);
	
	rand = randomUniform(0, names.size() - 1);
	Candidate leader2(names[rand], 1, 1);

	rand = randomUniform(0, names.size() - 1);
	Candidate leader3(names[rand], 1, 1);

	// Setting a leader for each party
	parties[0].leader = leader1;
	parties[1].leader = leader2;
	parties[2].leader = leader3;

	// Looping through the list of parties
	for (int i = 0; i < parties.size(); ++i)
	{
		// Printing out each party's information (Name, Leader, Candidates)
		cout << "Party: " << parties[i].pName << endl;
		cout << "Leader: " + parties[i].leader.name << endl;
		// Looping through each candidate
		cout << "The candidates:" << endl;
		for (int j = 0; j < parties[i].candidates.size(); ++j)
		{
			// Printing out the name of each candidate
			cout << "    " << parties[i].candidates[j].name << endl;
		}
		cout << endl;
	}
	cout << endl;
}

// Method to create electorates
void createElectorates(int n)
{
	cout << "==== ELECTORATES ====" << endl;
	cout << "---------------------\n" << endl;

	// Looping through and creating 'n' amount of electorates
	for (int i = 0; i < n; ++i)
	{	
		// Establishing a random number for each electorate's stance
		int stanceHigh, stanceLow, temp;
		stanceLow = randomUniform(1,8);
		stanceHigh = randomUniform(1,8);

		// If the value for stanceLow is greater than the value of stanceHigh, swap
		if(stanceLow > stanceHigh)
		{
			temp = stanceLow;
			stanceLow = stanceHigh;
			stanceHigh = temp;
		}

		// Establishing a new Electorate with a random population 
		Electorate newElec(electorateNames[i], stanceLow, stanceHigh, randomUniform(3000, 10000));


		// Printing out the new Electorate's information
		cout << newElec.getName() << endl << "Stance: " <<  newElec.getLowStance() << "-" << newElec.getHighStance() << endl << "Population: " << newElec.getPopulation() << endl;
		cout << "Representatives:" << endl;

		// Adding candidates to represent their party for each Electorate
		for (int j = 0; j < parties.size(); ++j)
		{
			Candidate can = parties[j].getCandidate(i);
			newElec.pushCandidate(can);
			cout << "    " << can.name << " of The " << parties[j].pName << endl;
		}
		// Adding the new Electorate to the list of Electorates
		electorates.push_back(newElec);
		cout << endl;
	}
	cout << endl;
}

// Method to establish events
void createEvents()
{
	// Creating events
	Event event1("Debate", " is having a debate between candidates.", 100);
	Event event2("Fight", " has started a fight with a bystander.", -200);
	Event event3("Helping Hand", " has helped an old lady cross the road", 200);
	Event event4("Raising Tax", " wants to increase low income tax rates", -150);
	Event event5("School Funding", " wants to increase the public school budget", 150);
	Event event6("Environment Cleanup", "A flood has broken out leaving many dead", -500);
	Event event7("Public Holiday", "Today is Waffle Day, everyone loves the waffles", 500);

	// Adding the new events to the events list
	events.push_back(event1);
	events.push_back(event2);
	events.push_back(event3);
	events.push_back(event4);
	events.push_back(event5);
	events.push_back(event6);
	events.push_back(event7);
}

// Method to establish issues
void createIssues()
{
	// Creating issues
	Event issue1("Frog Invasion", "There has been an enormous spike in the population of Cane Toads.", 300);
	Event issue2("Nuclear War", "The U.S. have threatened nuclear war. It is up to the leaders to defend the nation.", 300);
	Event issue3("Hacking", "Russia recently launched cyber-attacks on government servers, and now the default browser is Microsoft Edge.", 300);
	Event issue4("Economy", "Australia's debt has climbed an incredible amount. It is up to the leaders to rejuvinate the Economy", 300);
	Event issue5("Capital Punishment", "The measure of punishment must depend upon the atrocity of the crime. Is life in prison for murder enough of a punishment?", 300);

	// Adding the new issues to the issues list
	issues.push_back(issue1);
	issues.push_back(issue2);
	issues.push_back(issue3);
	issues.push_back(issue4);
	issues.push_back(issue5);

	// Print out each Issue's information
	cout << "==== ISSUES ====" << endl;
	cout << "----------------\n" << endl;
	for (Event i : issues){
		cout << i.getName() << endl << i.getDescription() << endl << endl;
	}
	cout << endl;
}

// Method to run the Campaign
void runCampaign(int n, int m)
{
	cout << "==== CAMPAIGN ====" << endl;
	cout << "------------------\n" << endl;

	// Looping through each day
	for (int i = m; i > 0; --i)
	{
		if (i != 1){
			cout << "There are " << i << " days until the election!" << endl;
		}
		else{	
			cout << "There is " << i << " day until the election!" << endl;
		}

		// Picking a random event
		int eventNum = randomUniform(1,20);

		Electorate currentElec;
		PoliticalParty currentParty;
		Candidate currentLeader;
		Candidate currentCan;
		Event currentEvent;

		// 50% Chance of an event occuring
		if(eventNum < 9)
		{
			cout << "Nothing event today" << endl;
			cout << endl;
		}

		// Different outcomes for each event
		else if(eventNum > 8 && eventNum < 15)
		{
			currentEvent = events[0];

			// Choosing a random Electorate
			currentElec = electorates[randomUniform(0,electorates.size()-1)];
			cout << currentElec.getName() << currentEvent.getDescription() << endl;
			
			// Choosing a random Candidate
			currentCan = currentElec.getCandidate(randomUniform(0,2));
			cout << currentCan.name << " has won the debate. Their popularity has increased." << endl;
			// Increasing the Candidate's popularity
			currentCan.setPopularity(currentEvent.getEffect());

			cout << endl;
		}
		else if(eventNum == 15)
		{
			currentEvent = events[1];

			// Choosing a random Electorate
			currentElec = electorates[randomUniform(0,electorates.size()-1)];
			
			// Choosing a random Candidate
			currentCan = currentElec.getCandidate(randomUniform(0,2));
			cout << currentCan.name << " from the " << currentElec.getName() << " electorate" << currentEvent.getDescription() << endl;
			cout << currentCan.name << " has lost support from followers. Their popularity has decreased." << endl;

			// Decreasing the Candidate's popularity
			currentCan.setPopularity(currentEvent.getEffect());

			cout << endl;
		}
		else if(eventNum == 16)
		{
			currentEvent = events[2];

			// Choosing a random Electorate
			currentElec = electorates[randomUniform(0,electorates.size()-1)];
			
			// Choosing a random Candidate
			currentCan = currentElec.getCandidate(randomUniform(0,2));
			cout << currentCan.name << " from the " << currentElec.getName() << " electorate" << currentEvent.getDescription() << endl;
			cout << currentCan.name << " has gained support from followers and others. Their popularity has increased." << endl;

			// Increasing the Candidate's popularity
			currentCan.setPopularity(currentEvent.getEffect());

			cout << endl;
		}
		else if(eventNum == 17)
		{
			currentEvent = events[3];

			// Choosing a random Electorate
			currentElec = electorates[randomUniform(0,electorates.size()-1)];
			
			// Choosing a random Candidate
			currentCan = currentElec.getCandidate(randomUniform(0,2));
			cout << currentCan.name << " from the " << currentElec.getName() << " electorate" << currentEvent.getDescription() << endl;
			cout << currentCan.name << " has lost support from followers. Their popularity has decreased." << endl;

			// Decreasing the Candidate's popularity
			currentCan.setPopularity(currentEvent.getEffect());

			cout << endl;
		}
		else if(eventNum == 18)
		{
			currentEvent = events[4];

			// Choosing a random Electorate
			currentElec = electorates[randomUniform(0,electorates.size()-1)];
			
			// Choosing a random Candidate
			currentCan = currentElec.getCandidate(randomUniform(0,2));
			cout << currentCan.name << " from the " << currentElec.getName() << " electorate" << currentEvent.getDescription() << endl;
			cout << currentCan.name << " has gained support from followers. Their popularity has increased." << endl;

			// Decreasing the Candidate's popularity
			currentCan.setPopularity(currentEvent.getEffect());

			cout << endl;
		}
		else if(eventNum == 19)
		{
			currentEvent = events[5];

			// Choosing a random Electorate
			currentElec = electorates[randomUniform(0,electorates.size()-1)];
			
			// Choosing a random Candidate
			cout << currentEvent.getDescription() << " in " << currentElec.getName() << "." << endl;

			// Altering the Candidate's popularity
			currentElec.setPopulation(currentEvent.getEffect());

			cout << endl;
		}
		else if(eventNum == 20)
		{
			currentEvent = events[6];

			// Choosing a random Electorate
			currentElec = electorates[randomUniform(0,electorates.size()-1)];
			
			// Choosing a random Candidate
			cout << currentEvent.getDescription() << " in " << currentElec.getName() << "." << endl;

			// Altering the Candidate's popularity
			currentElec.setPopulation(currentEvent.getEffect());

			cout << endl;
		}
	}
	cout << endl;
}

// Method to run the Election
void runElection()
{
	cout << "==== ELECTION DAY ====" << endl;
	cout << "----------------------\n" << endl;
	parties[0].setVotes(0);
	parties[1].setVotes(0);
	parties[2].setVotes(0);

	// Looping through each Electorate
	for (int i = 0; i < electorates.size(); ++i)
	{
		// Establishing variables to count each party's votes
		int p1Votes = 0, p2Votes = 0, p3Votes = 0;

		// Looping through each voter in an Electorate
		for (int j = 0; j < electorates[i].getPopulation(); ++j)
		{
			// Establishing a random value for each voter's stance
			int voterStance = randomUniform(electorates[i].getLowStance(), electorates[i].getHighStance());

			// Switch Case for each voter and adding their vote to the appropriate party
			switch(voterStance)
			{
				case 1 ... 3:
					p1Votes++;
					break;
				case 4 ... 6:
					p2Votes++;
					break;
				case 7 ... 9:
					p3Votes++;
					break;
			}
		}
		
		cout << "The " << electorates[i].getName() << " electorate has finished voting." << endl << endl;
		cout << "The results:" << endl;
		
		// Adding the votes to each party
		parties[0].addVotes(p1Votes);
		parties[1].addVotes(p2Votes);
		parties[2].addVotes(p3Votes);

		// Printing each party's votes
		for (int k = 0; k < 3; ++k)
		{
			cout << "    " << parties[k].pName << " currently have " << parties[k].getVotes() << " votes." << endl;
		}

		// If the Liberal Party have more votes than the other parties
		if(p1Votes >= p2Votes && p1Votes >= p3Votes)
		{
			cout << "    " << "The Liberal Party have won this electorate." << endl << endl;
			parties[0].addEWins();
		}
		// If the Labor Party have more votes than the other parties
		else if(p2Votes >= p1Votes && p2Votes >= p3Votes)
		{
			cout << "    " << "The Labor Party have won this electorate." << endl << endl;
			parties[1].addEWins();
		}
		// If the Independent Party
		else if(p3Votes >= p1Votes && p3Votes >= p2Votes)
		{
			cout << endl << "The Independent Party have won this electorate." << endl << endl;
			parties[2].addEWins();
		}
		cout << "-----------------------------------" << endl << endl;
	}

	cout << "Voting has now ended." << endl << endl;
	cout << "\nSummary" << endl;
	cout << "-------\n" << endl; 
	// Printing out each party's total votes and the electorates they've won
	for (int k = 0; k < 3; ++k)
	{
		cout << "The " << parties[k].pName << " recieved a total of " << parties[k].getVotes() << " votes and won " << parties[k].getEWins() << " electorates." << endl;
	}
	cout << endl;

	// Printing out the appropriate party if they've won the Campaign
	if(((double)parties[0].getEWins() / electorates.size()) > 0.5)
	{
		cout << "The Liberal Party have won the election by winning more than 50% of the votes and won in " << parties[0].getEWins() << "/" << electorates.size() << " electorates." << endl;
		cout << "Congratulations to our new leader " << parties[0].leader.name << endl;
	}
	else if(((double)parties[1].getEWins() / electorates.size()) > 0.5)
	{
		cout << "The Labor Party have won the election by winning more than 50% of the votes and won in " << parties[1].getEWins() << "/" << electorates.size() << " electorates." << endl;
		cout << "Congratulations to our new leader " << parties[1].leader.name << endl;
	}
	else if(((double)parties[2].getEWins() / electorates.size()) > 0.5)
	{
		cout << "The Independent Party have won the election by winning more than 50% of the votes and won in " << parties[2].getEWins() << "/" << electorates.size() << " electorates." << endl;
		cout << "Congratulations to our new leader, " << parties[2].leader.name << endl;
	}

	else/*(parties[0].getEWins() == parties[1].getEWins() && parties[0].getEWins() == parties[2].getEWins() && parties[1].getEWins() == parties[2].getEWins())*/{
		cout << "No party has won over 50% of the votes. As such, it is now a hung parliament." << endl;
	}
}

// Random engine to calculate a result within a specified range.
// Uses mean and deviation
int randomUniform(int num1, int num2)
{
	static std::random_device rd;
	static std::mt19937 mt(rd());
	uniform_int_distribution<> distr(num1, num2);
	return distr(mt);
}