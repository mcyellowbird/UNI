#include <iostream>
#include <string>

using namespace std;

class Hat {
  public:
    string type;
    char size; // S, M, L
    Hat() = default;
    Hat(string,char);
    void display();
};

Hat::Hat(string _type, char _size){
  type = _type;
  size = _size;
};

void Hat::display()
{
    cout << "Hat type   : " << type << endl;
    cout << "Hat size   : " << size << endl;
}

class Person {
  private:
    string name;
    unsigned int idNum;
    Hat myHat;

  public:
    Person() = default;
    Person(string,int,string,char);
    Person(string,int,Hat);
    void display();
};

Person::Person(string _name, int _idNum, string _hatType, char _hatSize){
  name = _name;
  idNum = _idNum;
  myHat = Hat(_hatType, _hatSize);
};

void Person::display()
{
        cout << "Given name : " << name << endl;
        cout << "ID number  : " << idNum << endl;
        myHat.display();
}

int main()
{
	Person personA = Person("Alice",12321,"Beret",'M');
	Person personB = Person("Bob",2324,"Trilby",'S');
	personA.display();
	personB.display();
}
