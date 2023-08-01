#include <iostream>
#include "LibraryC.h"
using namespace std;

Money::Money(string c, double u, double r):country(c), units(u), exchangeRate(r){}

City::City(string cN, string c, double NS, double EW, Money m):cityName(cN), country(c), latitude(NS), longitude(EW), money(m){}

bool compare(Money& m, City& c){
    return (m.country == c.country);
}

void Money::display(){
    cout << "\nCurrency" << endl << "--------" << endl;
    cout << "Amount: $" << units << endl;
    cout << "Exchange Rate: " << exchangeRate << endl;
    cout << "=--------=\n" << endl;
}

void City::display(){
    cout << "=--------=" << endl;
    cout << "City" << endl << "--------" << endl;
    cout << "City Name: " << cityName << endl;
    cout << "Country: " << country << endl;
    cout << "Latitude: " << latitude << endl;
    cout << "Longitude: " << longitude << endl;
    money.display();
}