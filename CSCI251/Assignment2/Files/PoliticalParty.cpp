#include "Person.h"
#include "Candidate.h"
#include "PoliticalParty.h"

PoliticalParty::PoliticalParty(string pName, int stance) :
pName(pName), stance(stance) {electoratesWon=0;}

PoliticalParty::PoliticalParty(){}

int PoliticalParty::getStance()
{
	return stance;
}

void PoliticalParty::pushCandidate(Candidate newCan)
{
	candidates.push_back(newCan);
}

Candidate PoliticalParty::getCandidate(int index)
{
	return candidates[index];
}

void PoliticalParty::setVotes(int votes){
	this->numVotes = votes;
}

void PoliticalParty::addVotes(int votes)
{
	this->numVotes += votes;
}
int PoliticalParty::getVotes()
{
	return numVotes;
}

void PoliticalParty::addEWins()
{
	this->electoratesWon += 1;
}
int PoliticalParty::getEWins()
{
	return electoratesWon;
}
