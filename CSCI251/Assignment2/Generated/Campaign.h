#ifndef CAMPAIGN_H
#define CAMPAIGN_H

class Campaign {

private:
	unsigned int duration;
	unsigned int currentDate;

public:
	void run(Election election);

	void runLocal(Election election, Event event, String area);

	void runNation(Election election, int event_Event);
};

#endif
