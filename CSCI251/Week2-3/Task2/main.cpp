#include <iostream>
using namespace std;

int main(void){
	int m = 0;
	int n = 0;

	cout << "Enter the first number: ";
	cin >> m;
	while (m <= 1){
		cout << "Enter a number greater than 1: ";
		cin >> m;
	}

	cout << "Enter the second number to multiply the first number by: ";
	cin >> n;
	while (n <= 1){
		cout << "Enter a number greater than 1: ";
		cin >> n;
	}

	for (int i = 1; i <= n; i++){
		if (i == n){
			cout << m * i << endl;
		}
		else{
			cout << m * i << ", ";
		}
	}
	system("pause");
}