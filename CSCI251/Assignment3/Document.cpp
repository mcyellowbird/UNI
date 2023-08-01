#include<iostream>
#include<vector>
#include<algorithm>
#include "Paragraph.cpp"
using namespace std;

class Document{
	private:
		vector<Paragraph> paragraphs;
		vector<int> differences;
		vector<char> characters;
	public:
		Document();
		~Document();
		void addParagraph(Paragraph p);
		void display();
		void minDifference();
		void characterStatistics();
};

// Constructor
Document::Document(){}

// Destructor
Document::~Document(){}

// Method to add a paragraph to the vector
void Document::addParagraph(Paragraph p){
	paragraphs.push_back(p);
}

// Display method
void Document::display(){
	// Displaying each paragraph
	for (int i = 0; i < paragraphs.size(); i++){
		cout << "p" << (i + 1) << ": ";
		paragraphs[i].display();
	}

	cout << endl;

	// Creating a temporary vector to store paragraphs as a backup
	vector<Paragraph> temp = paragraphs;

	// Looping through each paragraph
	for (int i = 0; i < paragraphs.size(); i++){
		int difference = 0;
		// Looping through each other paragraph as to compare the current paragraph with them
		for (int j = 0; j < paragraphs.size(); j++){
			// Checking if the current paragraph does not equal the same paragraph, as to not create duplicates
			if (paragraphs[i].getData() != paragraphs[j].getData()){
				cout << "     ";
				paragraphs[i].display();
				cout << "(vs) ";
				paragraphs[j].display();
				cout << "=>   ";

				// Getting the difference between the two paragraphs
				difference = paragraphs[i].difference(paragraphs[j]);
				cout << "  => " << difference << endl << endl;
				// Adding the difference to a vector
				differences.push_back(difference);
			}
		}
		// Removing the current paragraph from the list as to not create duplicate comparisons
		paragraphs.erase(paragraphs.begin() + i);
	}

	// 'Loading' the backup list of paragraphs
	paragraphs = temp;

	// Finding and printing the smallest difference
	minDifference();

	// Printing out the statistics for each character (The number of occurances)
	characterStatistics();
}

void Document::minDifference(){
	// Makes use of the above function which already calculates and displays the differences for each paragraph and stores them in a vector.
	// Also using a function from the 'algorithm' library to add to the program's efficiency

	int smallest = *min_element(differences.begin(), differences.end());

	cout << "The minimum difference between Paragraphs is: " << smallest << endl << endl;
}

// Method to count occurances for each character
void Document::characterStatistics(){
	// Looping through each paragraph
	for (Paragraph p : paragraphs){
		// Seperating each character in the paragraph
		for (char c : p.getData()){
			// Adding each character to a vector
			characters.push_back(c);
		}
	}

	// Local vector to store unique characters
	vector<char> shortChars = characters;

	// Sorting the vector
	sort(shortChars.begin(), shortChars.end());
	// Removing duplicates
	shortChars.erase( unique(shortChars.begin(), shortChars.end() ), shortChars.end());

	cout << "---------" << endl;
	cout << " Chr  #" << endl;
	cout << "---------" << endl;
	// Cross-checking the unique characters with the whole list of characters
	for (char c : shortChars){
		// Counting the number of occurances of a specific character within the list of characters
		int occ = count(characters.begin(), characters.end(), c);
		// Printing out each character along with the number of occurances
		cout << "| " << c << " | " << occ << " |" << endl;
		cout << "---------" << endl;
	}
}