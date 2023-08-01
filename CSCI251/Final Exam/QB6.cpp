#include<iostream>
using namespace std;

class Ship {
    private:
        int numberofstaff;
        double length;
        char purpose;
    public:
        Ship(int,double,char);
        void print();
};

Ship::Ship(int n = 15, double l = 14.1, char p = 'r'){
    numberofstaff = n;
    length = l;
    purpose = p;
}

void Ship::print(){
    cout << "Staff: " << numberofstaff << endl;
    cout << "Length: " << length << endl;
    cout << "Purpose: " << purpose << endl << endl;
}

int main(){
    Ship one = Ship();
    Ship two = Ship(2);
    Ship three = Ship(2, 3.5);
    Ship four = Ship(2, 3.5, 'a');

    one.print();
    two.print();
    three.print();
    four.print();
}