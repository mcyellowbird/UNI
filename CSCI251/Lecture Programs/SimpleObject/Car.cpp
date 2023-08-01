#include <iostream>
using namespace std;

class Car{
    private:
        string brand, model, colour;
        double price, topSpeed;
    public:
        Car(string b, string m, string c, double p, double tS){
            brand = b;
            model = m;
            colour = c;
            price = p;
            topSpeed = tS;
        }

        print(){
            printf("Brand: %s\nModel: %s\nColour: %s\nPrice: %d\nTop Speed: %d", brand, model, colour, price, topSpeed);
        }
}

int main() {
    Car subaruLiberty_Blue = new Car("Subaru", "Liberty", "Blue", 31440, 187);
    subaruLiberty_Blue.print();
}