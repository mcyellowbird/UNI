// finMax.cpp
#include<iostream>
using namespace std;

template<typename T>
T findMax(T & a, T & b){
    return (a>b) ? a : b;
}

int main(){
    int a = 20, b = 50;
    char c = 'a', d = 'b';
    float e = 3.12f, f = 3.13f;
    auto g = 1.11, h = 2.22;
    cout << findMax<int>(a, b)<<endl;
    cout << findMax<char>(c, d)<<endl;
    cout << findMax<float>(e, f)<<endl;
    cout << findMax(g, h)<<endl;
    return 0;
}