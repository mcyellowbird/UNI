#include<iostream>
#include<string>

using namespace std;

class Worker
{
  public:
   int idNum;
   string lastName;
   string firstName;
   double salary;
   void setIdNum(int);
   void setLastName(string);
   void setFirstName(string);
   void setSalary(double);
   void displayWorker();
};

void Worker::setIdNum(int id)
{
   const int LOWID = 0;
   const int HIGHID = 999;
   if(id < LOWID && id > HIGHID)
     idNum = LOWID;
   else
     idNum = id;
}

void Worker::setLastName(string last)
{
   lastName = last;
}
void Worker::setFirstName(string first)
{
   firstName = first;
}
void Worker::setSalary(double payRate)
{
   const double LOWPAY = 5.75;
   const double HIGHPAY = 99.99;
   if (payRate < LOWPAY)
      salary = LOWPAY;
   else if (payRate > HIGHPAY)
      salary = HIGHPAY;
   else
      salary = payRate;
 }

void Worker::displayWorker()
{
   cout<<"ID # "<<idNum<<"\nName: "<<firstName<<" "<<lastName
   	<<"\nSalary: $"<<salary<<endl;
}

int main()
{
     Worker aWorker;
     aWorker.setIdNum(111);
     aWorker.setLastName("Anteater");
     aWorker.setFirstName("Alice");
     aWorker.setSalary(23.45);
     aWorker.displayWorker();
}
