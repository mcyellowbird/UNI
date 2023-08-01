#include <iostream>
using namespace std;


void materialType(char &mat){
	cout << "('w' = Wooden, 'c' = Concrete, 'b' = brick)" << endl;
	cout << "Enter material type: ";
	cin >> mat;
}

void dimensions(double &width, double &height, double &depth){
	cout << "\nEnter width: ";
	cin >> width;
	cout << "Enter height: ";
	cin >> height;
	cout << "Enter depth: ";
	cin >> depth;
}

double calcPrice(double width, double height, double depth, char mat){
	double matCost = 0;
	if (mat == 'w'){matCost = 75;}
	else if (mat == 'c'){matCost = 150;}
	else if (mat == 'b'){matCost = 175;}
	return (matCost * (width * depth * height));
}

void display(double price){
	cout << "\nTotal Price: " << price << "\n";
}