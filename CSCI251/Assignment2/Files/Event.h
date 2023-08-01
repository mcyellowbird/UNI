#ifndef EVENT_H
#define EVENT_H

#include <vector>
#include <string>

using namespace std;

class Event
{
    public:
    	string eName, description;
        int effect;
        Event(string eName, string description, int effect);
        Event();
        void setName(string eName);
        string getName();
        void setDescription(string description);
        string getDescription();
        void setEffect(int effect);
        int getEffect();
};

#endif