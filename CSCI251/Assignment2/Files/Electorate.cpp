#include "Person.h"
#include "Candidate.h"
#include "Electorate.h"

Electorate::Electorate(){}

Electorate::Electorate(string eName, int low, int high, int pop) :
eName(eName), stanceLow(low), stanceHigh(high), population(pop) {}

void Electorate::setName(string eName)
{
    this->eName = eName;
}

string Electorate::getName()
{
    return eName;
}

void Electorate::setHighStance(int stanceHigh)
{
    this->stanceHigh = stanceHigh;
}

int Electorate::getHighStance()
{
	return stanceHigh;
}

void Electorate::setLowStance(int stanceLow)
{
    this->stanceLow = stanceLow;
}

int Electorate::getLowStance()
{
	return  stanceLow;
}

void Electorate::setPopulation(int population)
{
	this->population += population;
}

int Electorate::getPopulation()
{
	return population;
}

void Electorate::pushCandidate(Candidate newCan)
{
	eCandidates.push_back(newCan);
}

Candidate Electorate::getCandidate(int index)
{
	return eCandidates[index];
}