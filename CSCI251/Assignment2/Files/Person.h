#ifndef PERSON_H
#define PERSON_H

#include <string>

using namespace std;

class Person
{
	public:
		string name;
		int stance;
		Person(string name, int stance);
		Person();
		void setName(string n);
		string getName();
		void setStance(int stance);
		int getStance();
		void printObj();
};

#endif