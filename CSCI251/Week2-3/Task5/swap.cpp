#include <iostream>
using namespace std;

void swap(int *ptr1, int *ptr2){
	int temp = 0;
	temp = *ptr2;
	*ptr2 = *ptr1;
	*ptr1 = temp;
}

void display(int array[]){
	for (int i = 0; i < 5; i++){
		cout << i << ": " << array[i] << endl;
	}
}