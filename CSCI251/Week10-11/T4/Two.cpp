#include<iostream>

using namespace std;

template<class R, class S>
class Two{
	private:
		R valR;
		S valS;
	public:
		Two(R r, S s){
			valR = r;
			valS = s;
		}

		void display(){
			cout << "First: " << valR << endl;
			cout << "Second: " << valS << endl;
		}

		void add(){
			cout << "Sum of both values is: " << (valR + valS) << endl;
		}
};

int main(){
	Two<int, double> t1(6, 4.5);
	cout << "Using int & double data types:" << endl;
	t1.display();
	t1.add();

	Two<char, int> t2('.', 6);
	cout << "\nUsing char & int data types:" << endl;
	t2.display();
	t2.add();
}