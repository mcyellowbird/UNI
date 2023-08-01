#include <iostream>

using namespace std;

static const double INSURANCE = 99.9;

struct Cat{
    string name, breed;
    int age;


    double calculatePrice(){
        return (age * 1.5 + INSURANCE);
    }

    void showCat(){
        cout << "Cat: " << name << " is a " << breed << endl;
        cout << "Its age is " << age << endl;
        cout << "Insurance fee: $" << INSURANCE << endl;
        cout << "Owing cost is: $" << calculatePrice();
    }

    void setCat(string n, string b, int a){
        name = n;
        breed = b;
        age = a;
    }

    string getName(){
        return name;
    }
    void setName(string n){
        name = n;
    }
    string getBreed(){
        return breed;
    }
    void setBreed(string b){
        breed = b;
    }
    int getAge(){
        return age;
    }
    void setAge(int a){
        age = a;
    }
};

int main(){
    Cat myCat;
    myCat.setCat("Tiger", "British Shorthair", 1);
    myCat.calculatePrice();
    myCat.showCat();
}