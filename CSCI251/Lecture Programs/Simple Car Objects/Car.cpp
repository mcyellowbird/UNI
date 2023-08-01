#include <iostream>
using namespace std;

class Car{
    public:
        string brand, model, colour;
        double price, topSpeed;

        Car(string b, string m, string c, double p, double tS){
            brand = b;
            model = m;
            colour = c;
            price = p;
            topSpeed = tS;
        }

        void print(){
            cout << "Brand: " << brand;
            cout << "\nModel: " << model;
            cout << "\nColour: " << colour;
            cout << "\nPrice: $" << price;
            cout << "\nTop Speed: " << topSpeed;
            cout << "km/h\n";
        }
};

int main() {
    Car subaruLiberty_Blue("Subaru", "Liberty", "Blue", 31440, 187);
    subaruLiberty_Blue.print();
    system("pause");
}