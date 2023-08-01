#include<iostream>
#include<string>
#include<vector>

using namespace std;

// Animal
class Animal
{
private:
   string name;
   int age;

public:
   void setAnimalData(string, int);
   void showAnimal();
   virtual void dummy() = 0;
};

void Animal::setAnimalData(string _name, int _age)
{
   name = _name;
   age = _age;
}

void Animal::showAnimal()
{
   cout << "Name: " << name << endl;
   cout << "Age: " << age << endl;
}

// Cat
class Cat : public Animal
{
private:
   string breed;
   static constexpr double licenseFee = 10;

public:
   void setCatData(string, string, int);
   void showCat();
   void dummy(){};
};

void Cat::setCatData(string catName, string catBreed, int catAge)
{
   setAnimalData(catName, catAge);
   breed = catBreed;
}

void Cat::showCat()
{
   showAnimal();
   cout << "Our cat is a " << breed << endl;
   cout << "Cat License fee: $" << licenseFee << endl;
}

// Moose
class Moose : public Animal
{
private:
   string country;

public:
   void setMooseData(string, string, int);
   void showMoose();
   void dummy(){};
};

void Moose::setMooseData(string _name, string _country, int _age){
   setAnimalData(_name, _age);
   country = _country;
}

void Moose::showMoose(){
   showAnimal();
   cout << "Our moose is from " << country << endl;
}

int main()
{
     Cat myCat;
     myCat.setCatData("Tigger", "Fluffy unit", 3);
     myCat.showCat();
     cout << endl;

     Moose myMoose;
     myMoose.setMooseData("Morris", "Canada", 10);
     myMoose.showMoose();
     cout << endl;

     Animal* zoo[2];
     zoo[0] = &myMoose;
     zoo[1] = &myCat;

     zoo[0]->showAnimal();
     zoo[1]->showAnimal();

     vector<Animal*> vZoo;
     vZoo.push_back(&myMoose);
     vZoo.push_back(&myCat);

     vZoo[0]->showAnimal();
     vZoo[1]->showAnimal();

     return 0;
}

