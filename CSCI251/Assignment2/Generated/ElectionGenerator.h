#ifndef ELECTIONGENERATOR_H
#define ELECTIONGENERATOR_H

class ElectionGenerator {

private:
	vector<Event> elecEvent;
	vector<Issues> issues;
	vector<float> partiesStanceRanges;

public:
	void operation();

	void operation2();
};

#endif
