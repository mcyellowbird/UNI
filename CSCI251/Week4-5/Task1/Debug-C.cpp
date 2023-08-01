#include<iostream>
#include<fstream>
using namespace std;

int main()
{
   int bookID;
   string name;
   double price;  

   const string note1 = "Enter ID, name, and price";
   const string note2 = "Enter end-of-file key combination (Ctrl-d) to end ";

   ofstream outFile;
   outFile.open("library.txt");

   if (outFile.bad())
      {
         cout << "File could not be opened" << endl;
         return 1;
      }

   
   cout << note2 << endl;
   cout << endl << note1 << endl;
   while (cin >> bookID >> name >> price)
   {
      outFile << bookID << " " << name << " " << price << "\n";
   }
   outFile.close();

   return 0;
}
