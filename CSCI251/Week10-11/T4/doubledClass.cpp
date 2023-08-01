#include<iostream>

using namespace std;

template<class T>
class Hold{
	private:
		T data;
	public:
		Hold(T d){data = d;};
		T doubled(){return data+data;};
};

int main(){
	Hold<int> num(10);
	Hold<float> floatNum(6.45f);
	Hold<char> character(';');
	Hold<string> str("Dog");

	cout << "10 doubled is: " << num.doubled() << endl;
	cout << "6.45 doubled is: " << floatNum.doubled() << endl;
	cout << "';' doubled is: " << character.doubled() << endl;
	cout << "\"Dog\" doubled is: " << str.doubled() << endl;
}