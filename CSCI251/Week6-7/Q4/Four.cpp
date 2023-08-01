#include <iostream>
#include "Library.h"
using namespace std;

int main()
{
Money nzMoney("NZ", 1000, 0.70);

City C1("Sydney", "Australia", -33.53, 151.10);
City C2("Auckland", "NZ", -43.33, 172.47);

if (compare(nzMoney, C1))
cout << "Different associated countries." << endl;
else
cout << "They are associated with the same country." << endl;

if (compare(nzMoney, C2))
cout << "Different associated countries." << endl;
else
cout << "They are associated with the same country." << endl;
}