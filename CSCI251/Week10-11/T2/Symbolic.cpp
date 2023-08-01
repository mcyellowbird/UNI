#include<iostream>
using namespace std;

template<class T>
void display(T value, int n, char x){

	for (int i = 0; i < n; i ++){
		cout << x;
	}

	cout << " " << (value) << " ";

	for (int i = 0; i < n; i ++){
		cout << x;
	}
	cout << endl;
}

int main(){
	display('e', 4, 'o');
	display(47, 3, '*');
	display(32.64, 6, '0');
	display("Dog", 8, '-');
    return 0;
}