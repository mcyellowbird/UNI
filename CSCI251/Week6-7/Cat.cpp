#include<iostream>
#include<string>
using namespace std;

class Cat
{
private:
   string name;
   string breed;
   int age;
   static constexpr double licenseFee = 10;

public:
   void setCatData(string, string, int);
   void showCat();
   Cat()=default;
   Cat(string n, string b, int a);
   ~Cat();
   Cat(const Cat &);
   void showAddresses();
};
//const double Cat::licenseFee = 10;

Cat::Cat(string n, string b, int a){
   name = n;
   breed = b;
   age = a;
}

Cat::~Cat(){
   cout << "Cat removed from memory" << endl;
}

Cat::Cat(const Cat & copy){
   name = copy.name;
   breed = copy.breed;
   age = copy.age;
}

void Cat::setCatData(string catName, string catBreed, int catAge)
{
   name = catName;
   breed = catBreed;
   age = catAge;
}

void Cat::showCat()
{
  cout << "Cat: " << name << " is a " << breed << endl;
  cout << "The cat's age is " << age << endl;
  cout << "License fee: $" << licenseFee << endl << endl;
}

void Cat::showAddresses(){
   cout << "Address of the Cat object: " << this << endl;
   cout << "Address of the Cat's name: " << &name << endl;
   cout << "Address of the Cat's breed: " << &breed << endl;
   cout << "Address of the Cat's age: " << &age << endl << endl;
}

int main()
{
     Cat myCat;
     myCat.setCatData("Tigger", "Fluffy unit", 3);
     Cat twoCat = myCat;
     myCat.showCat();
     twoCat.showCat();
     myCat.showAddresses();
     twoCat.showAddresses();

     return 0;
}

