#include <iostream>
#include <vector>
#include <string>

using namespace std;

class Box{
	private:
		string name;
		int length, width, height;
		vector<Box> boxes;
	public:
		Box(string n, int l, int w, int h);
		string getName();
		int getVolume();
		bool compareVolume(Box b);
		void fillBox(Box b);
		void showData();
};

Box::Box(string n, int l, int w, int h){
	name = n;
	length = l;
	width = w;
	height = h;
}

string Box::getName(){
	return name;
}

int Box::getVolume(){
	return (length * width * height);
}

bool Box::compareVolume(Box b){
	return this->getVolume() > b.getVolume();
}

void Box::fillBox(Box b){
	if (compareVolume(b)){
		boxes.push_back(b);
		cout << b.getName() << " can fit in " << getName() << endl;
	}
	else{
		cout << b.getName() << " cannot fit in " << getName() << endl;
	}
}

void Box::showData(){
	cout << "Name: " << name << "\nLength: " << length << "\nWidth: " << width << "\nHeight: " << height << endl << endl;
}

int main(){
	Box box1("Box 1", 5,10,5);
	Box box2("Box 2", 6,10,5);

	box1.showData();
	box2.showData();

	box1.fillBox(box2);
	box2.fillBox(box1);

	return 0;
}