#include <iostream>
#include <fstream>

using namespace std;

int main(){
    fstream wordList;
    wordList.open("Words");

    if (!wordList.is_open()){
        cout << "Problem opening input file" << endl;
    }
    
    string word;   
    ofstream output;
    output.open("output.txt");

    if (output.is_open()){
        int counter = 1;
        while(wordList >> word){
            output << counter << ": " << word << "\n";
            counter++;
        }
    }
    else cout << "Problem with creating output file";

    output.close();
    wordList.close();

    return 0;
}