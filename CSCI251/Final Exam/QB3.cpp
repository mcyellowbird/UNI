#include<iostream> // Include
using namespace std; // Using

void swap(int &x1,int &x2)
{
    int t;
    t=x1;
    x1=x2;
    x2=t;
}

void order(int &a,int &b)
{
    if(a>b){
        swap(a,b);
    }
}

int main() // int not Int
{
    int x,y;
    cout<<"two inputs?\n";
    cin>>x>>y;
    cout<<"before ordering: x="<<x<<",y="<<y<<endl;
    order(x,y);
    cout<<"after ordering: x="<<x<<",y="<<y<<endl; // Semicolon
}