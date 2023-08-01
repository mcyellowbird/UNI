#include<iostream>

using namespace std;

template<typename T>
T doubled(T x){
	// If type is int, normal addition is implemented (10+10 = 20)
	// If type is float, normal addition is implemented (6.45+6.45 = 12.9)
	// If type is char, addition of ascii values is implemented, so: ; = 59, 59 + 59 = 118, 118 = v
	// If type is string, concatenation is implemented (Dog + Dog = DogDog)
	return (x + x);
}

class Wallet{
	private:
		int cash;
	public:
		Wallet(int c){
			cash = c;
		}
		int getCash(){
			return cash;
		}
		Wallet operator+(Wallet& other){
			return Wallet(cash + other.cash);
		}
};

int main(){
	cout << "10 doubled is: " << doubled(10) << endl;
	cout << "6.45 doubled is: " << doubled(6.45f) << endl;
	cout << "';' doubled is: " << doubled(';') << endl;
	cout << "\"Dog\" doubled is: " << doubled<string>("Dog") << endl;

	Wallet w(145);
	Wallet w2=doubled(w);
	cout << "Doubled Wallet(" << w.getCash() << "): Wallet(" << w2.getCash() << ")" << endl;
	return 0;
}