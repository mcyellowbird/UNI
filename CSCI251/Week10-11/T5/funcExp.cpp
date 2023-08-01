#include<iostream>

using namespace std;

template <typename T>
T funcExp(T list[], int size){
	int j;
	T x = list[0];
	T y = list[size-1];

	for(j=1; j<(size-1)/2;j++){
		if (x < list[j]) x = list[j];
		if (y > list[size-1-j]) y = list[size-1-j];
	}

	return (x+y);
}

int main(){
	int list[8]={1,2,9,3,5,8,13,10};
	string strlist[]={"one","fish","two","fish","red","fish","blue","fish"};

	cout << funcExp(list, 8) << " :: " << funcExp(strlist, 8) << endl;
}