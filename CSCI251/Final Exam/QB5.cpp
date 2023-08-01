#include<iostream>
#include<string>
using namespace std;

class Cat {
    private:
        string name;
        int age;
    public:
        Cat() = default;
        ~Cat();
        Cat(string name, int age);
        Cat(const Cat & ); //copy constructor
        Cat(Cat && mCat);
};

Cat::~Cat() {
    cout << "Destructor" << endl;
}

Cat::Cat(string _name, int _age) {
    name = _name;
    age = _age;
    cout << "Cat constructing" << endl;
}

Cat::Cat(const Cat & copyCat) {
    name = copyCat.name;
    age = copyCat.age;
    cout << "Copy Cat constructor" << endl;
}

Cat::Cat(Cat && mCat) {
    name = move(mCat.name);
    age = move(mCat.age);
    cout << "Move Cat constructor" << endl;
}

int main() {
    Cat myCat("Daisy", 2);
    Cat secondCat = myCat;
    Cat thirdCat = move(secondCat);
    return 0;
}