#ifndef ELECTION_H
#define ELECTION_H

class Election {

private:
	unsigned int partyNum;
	unsigned int electorateNum;
	vector<Party> parties;
	vector<Electorate> electorates;
	Campaign campaign;

public:
	void partyReport();

	void electorateReport();

	void electionReport();

	void main();
};

#endif
