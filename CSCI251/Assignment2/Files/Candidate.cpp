#include "Library.h"
#include "Person.h"
#include "Candidate.h"
#include "PoliticalParty.h"

Candidate::Candidate(string name, int stance, int popularity) : 
Person(name, stance), popularity(popularity) {}

Candidate::Candidate(){}

void Candidate::setPopularity(int p)
{
    popularity += p;
}

int Candidate::getPopularity()
{
    return popularity;
}

void Candidate::printObj()
{
    cout << "Name: " << " | " << "Stance: " << this->getStance() << endl;
}
