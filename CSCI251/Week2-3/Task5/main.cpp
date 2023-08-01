#include <iostream>
#include "swap.cpp"
using namespace std;

int main(){
	int array[5] = {0,0,0,0,0}, * ptr1, * ptr2;
	cout << "Enter 5 numbers: ";

	for (int i = 0; i < 5; i++){
		cin >> array[i];
	}

	ptr1 = &array[3];
	ptr2 = &array[4];

	swap(ptr1, ptr2);

	display(array);
	system("pause");
}