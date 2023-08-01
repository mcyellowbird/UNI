#include <iostream>
#include "mylibrary.cpp"
using namespace std;

int main(void)
{
    // These comments reflect what the program should do.
    // functionOne should take 3 integers from the user.
    // functionTwo should calculate the sum of those 3 integers.

    int one, two, three, sum;
    functionOne(one, two, three);
    sum = functionTwo(one, two, three);

    cout << "The sum of " << one << ", " << two << " and " << three;
    cout << " is " << sum << endl;
    system("pause");
}
