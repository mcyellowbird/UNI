#include <iostream>

using namespace std;

struct Fraction {
    int numerator;
    int denominator;
    Fraction add(Fraction f1, Fraction f2){
        Fraction newFraction;
        newFraction.numerator = ((f1.numerator * f2.denominator) + (f1.denominator * f2.numerator));
        newFraction.denominator = (f1.denominator * f2.denominator);
    }
};

int main(){
    int a[]={7, 8, 1, 2, 4, 12, 4};
    char b[]={'h', 'i', 'a','o','w'};
    double c[]={7.77, 1.11, 2.22, 3.33, 8.88};
    cout<<"Min value of INT array: "
    << findMinArr(a, sizeof(a)/sizeof(int))<<endl;
    cout<<"Min value of CHAR array: "
    << findMinArr(b, sizeof(b)/sizeof(char)) <<endl;
    cout<<"Min value of DOUBLE array: "
    << findMinArr(c, sizeof(c)/sizeof(double)) << endl;
    return 0;
}

