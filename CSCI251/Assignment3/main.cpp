#include<iostream>
#include<ctime>
#include "Document.cpp"
using namespace std;

// Creating a list of alpha-numeric characters
static const char alphanum[] = "0123456789" "ABCDEFGHIJKLMNOPQRSTUVWXYZ" "abcdefghijklmnopqrstuvwxyz";
int numLen = sizeof(alphanum) - 1;

// Method to generate a random character
char genRandom() {
	return alphanum[rand() % numLen];
}

int main(int argc, char* argv[])
{
	// Checking if inital command line input is valid
	if (argv[1] > 0 && argv[2] > 0 && argc != 1){
		// Used to generate random numbers
		srand(time(0));

		// Setting variables equal to the initial input
		int num = atoi(argv[1]);
		int len = atoi(argv[2]);

		// Creating the Document object
		Document doc = Document();

		// Creating each paragraph with a set of random characters to form one string based on user input
		for (int i = 0; i < num; i++){
			// Temporary storage
			string tempString = "";

			// Adding each random character to the temporary string
			for (int j = 0; j < len; j++){
				char tempChar = genRandom();
				tempString += tempChar;
			}

			// Temporary Paragraph object to be added to the Document
			Paragraph tempP = Paragraph(tempString);

			// Adding temporary Paragraph object to the Document
			doc.addParagraph(tempP);
		}

		// Main display method to print necessary information
		doc.display();
	}

	// Error
	else{
		cout << endl << "Input invalid. Please run the program as follows:" << endl << endl << 
		"./main num len" << endl << endl <<
		"Where 'num' is the number of paragraphs (Positive Integer)" << endl <<
		"And 'len' is a the number of characters each paragraph has (Positive Integer)";
	}
}