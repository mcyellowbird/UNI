#include <iostream>
using namespace std;

int main()
{
	double r, s, v;

	cout << "input the radius: ";
	cin >> r;

	s = 3.14159 * (r*r);

	cout << "the area of this circle is: " << s << endl;

	v = 2 * 3.14159 * r;

	cout << "the circumference of this circle is: " << v << endl;
	system("pause");
}
