#include <iostream>
#include "LibraryC.h"
using namespace std;

int main()
{
Money jpMoney("JP", 1000, 0.011);
Money nzMoney("NZ", 1000, 0.91);

City C1("Tokyo", "Japan", 35.67, 139.65, jpMoney);
City C2("Auckland", "NZ", -43.33, 172.47, nzMoney);

C1.display();
C2.display();
}