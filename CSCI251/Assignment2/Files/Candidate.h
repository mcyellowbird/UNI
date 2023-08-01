#ifndef CANDIDATE_H
#define CANDIDATE_H

using namespace std;

class Candidate : public Person
{
    public:
    	int popularity;
        void setName(string n);
        string getName();
        void setPopularity(int p);
        int getPopularity();
        Candidate(string name, int stance, int popularity);
        Candidate();
        void printObj();
};

#endif