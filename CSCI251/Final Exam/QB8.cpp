#include<iostream>

using namespace std;

template<typename T>
double Avg(T a, T b){
    return (a + b) / 2;
}

template<typename T>
double Avg(T *a, int size){
    double average;
    average = 0.0;

    for (int i = 0; i < size; i++){
        average += a[i];
    }

    average /= size;

    return average;
}

int main(){
    cout << Avg(20, 50)<<endl;
    double a[3] = {1.2, 3.5, 43.66};
    cout << Avg(a, 3)<<endl;
    int b[4] = {1, 3, 43, 14};
    cout << Avg(b, 4)<<endl;
}