#include <iostream>
#include "calculator.cpp"
using namespace std;

int main(void){
	char mat;
	double width, height, depth, price;

	materialType(mat);
	dimensions(width, height, depth);
	price = calcPrice(width, height, depth, mat);
	display(price);
	system("pause");
}