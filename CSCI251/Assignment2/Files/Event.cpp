#include "Event.h"

Event::Event(){}

Event::Event(string eName, string description, int effect) :
eName(eName), description(description), effect(effect) {}
        
void Event::setName(string eName)
{
	this->eName = eName;
}
string Event::getName()
{
	return eName;
}

void Event::setDescription(string description)
{
	this->description = description;
}
string Event::getDescription()
{
	return description;
}
        
void Event::setEffect(int effect)
{
	this->effect = effect;
}
int Event::getEffect()
{
	return effect;
}