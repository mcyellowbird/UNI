#include<iostream>
using namespace std;

void level(int grade[], int size, int& honor, int& nonhonor){
	for (int i = 0; i < size; i++){
		if (grade[i] > 75){
			honor++;
		}
		else{
			nonhonor++;
		}
	}
}

int main()
{
	int array[6][4]={
		{60,80,90,75},
		{75,85,65,77},
		{80,88,90,98},
		{89,100,78,81},
		{62,68,69,75},
		{85,85,77,91}
		};
	int honor=0, nonhonor =0;
	int student=6;
	int gradesize=4;
	for(int i = 0; i < student; i++)
		level(array[i], gradesize, honor, nonhonor);
		
	cout <<"number of honor is " << honor << endl;
	cout <<"number of nonhonor is " << nonhonor << endl;
}
