#include <iostream>
using namespace std;

void countDown(int highest, int lowest);


// Prints integers from highest to lowest, inclusive.

int main()
{
   int high, low, temp;

   cout << "Enter an integer: ";
   cin >> high; //2

   cout << "Enter another integer: ";
   cin >> low; //3

   if (high < low)
   {
       temp = high;
       high = low;
       low = temp;
   }

   countDown(high, low);
   return 0;
}

void countDown(int highest, int lowest)
{
   for (int x = highest; x >= lowest; --x)
     cout << x << " " << endl;
}
