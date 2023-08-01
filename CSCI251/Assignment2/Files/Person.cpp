#include "Person.h"
#include "Candidate.h"
#include <iostream>

Person::Person(string name, int stance) :
name(name), stance(stance) {}

Person::Person(){}

void Person::setName(string n)
{
	name = n;
}

string Person::getName()
{
	return name;
}

void Person::setStance(int stance)
{
	stance = stance;
}

int Person::getStance()
{
	return stance;
}

void Person::printObj()
{
	cout << "Name: " << " | " << "Stance: " << this->stance << endl;
}
