#ifndef POLITICALPARTY_H
#define POLITICALPARTY_H

#include <vector>

//#include "ManagerialTeam.h"
using namespace std;

class PoliticalParty
{
	public:
		string pName;
		int stance, numVotes, electoratesWon;
		Candidate leader;
		vector<Candidate> candidates;
		PoliticalParty(string pName, int stance);
		PoliticalParty();
		int getStance();
		void setVotes(int votes);
		void addVotes(int votes);
		int getVotes();
		void addEWins();
		int getEWins();
		void pushCandidate(Candidate newCan);
		Candidate getCandidate(int pos);
};

#endif