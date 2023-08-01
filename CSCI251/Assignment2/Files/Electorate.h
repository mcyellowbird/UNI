#ifndef ELECTORATE_H
#define ELECTORATE_H

#include <vector>
#include <string>

using namespace std;

class Electorate
{
    public:
    	string eName;
        int population,stanceLow,stanceHigh;
        vector<Candidate> eCandidates;
        Electorate(string eName, int low, int high, int pop);
        Electorate();
        
        void setName(string eName);
        string getName();
        
        void setHighStance(int stanceHigh);
        int getHighStance();
        
        void setLowStance(int stanceLow);
        int getLowStance();

        void setPopulation(int population);
        int getPopulation();

        void pushCandidate(Candidate newCan);
        Candidate getCandidate(int pos);
};

#endif