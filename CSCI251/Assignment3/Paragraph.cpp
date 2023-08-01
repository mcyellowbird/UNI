#include<iostream>
using namespace std;

class Paragraph{
	private:
		string data;
	public:
		Paragraph(string d);
		~Paragraph();
		void display();
		string getData();
		int difference(Paragraph p);
};

// Constructor
Paragraph::Paragraph(string d){
	this->data = d;
}

// Destructor
Paragraph::~Paragraph(){
	//cout << "Paragraph Destructor" << endl;
}

// Display method
void Paragraph::display(){
	cout << data << endl;
}

// Returning a string
string Paragraph::getData(){
	return data;
}

// Comparing this paragraph with another
int Paragraph::difference(Paragraph p){ // Int count of characters that are not the same
	// Setting the inital difference to the length of the paragraph, i.e. no difference
	int diff = data.length();

	// Looping through each character in the paragraph
	for (int i = 0; i < data.length(); i++){
		// Checking if the current character is equal to the other paragraph's
		if (data[i] == p.data[i]){
			cout << "0";

			diff--;
		}
		else{
			cout << "1";
		}
	}
	return diff;
}