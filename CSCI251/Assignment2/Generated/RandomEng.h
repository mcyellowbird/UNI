#ifndef RANDOMENG_H
#define RANDOMENG_H

class RandomEng {

private:
	default_random_engine randEng;

public:
	int randInt(int min, int max);

	float randFloat(float min, float max);
};

#endif
