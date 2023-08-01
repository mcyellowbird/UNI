#include <iostream>
using namespace std;

class City;
class Money{
    friend bool compare(Money&, City&);
    private:
        string country;
        double units;
        double exchangeRate;
    public:
        Money(string, double, double);
};

class City{
    friend bool compare(Money&, City&);
    private:
        string cityName, country;
        double latitude, longitude;
    public:
        City(string, string, double, double);
};