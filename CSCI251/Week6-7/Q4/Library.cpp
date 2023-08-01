#include <iostream>
#include "Library.h"
using namespace std;

Money::Money(string c, double u, double r):country(c), units(u), exchangeRate(r){}

City::City(string cN, string c, double NS, double EW):cityName(cN), country(c), latitude(NS), longitude(EW){}

bool compare(Money& m, City& c){
    return (m.country == c.country);
}