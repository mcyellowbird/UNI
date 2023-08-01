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
        void display();
};

class City{
    friend bool compare(Money&, City&);
    private:
        string cityName, country;
        double latitude, longitude;
        Money money;
    public:
        City(string, string, double, double, Money);
        void display();
};

// void Money::display(){
//     cout << "\nCurrency" << endl << "--------" << endl;
//     cout << "Amount: $" << units << endl;
//     cout << "Exchange Rate: " << exchangeRate << endl;
// }

// void City::display(){
//     cout << "City" << endl << "--------" << endl;
//     cout << "City Name: " << cityName << endl;
//     cout << "Country: " << country << endl;
//     cout << "Latitude: " << latitude << endl;
//     cout << "Longitude: " << longitude << endl;
//     money.display();
// }