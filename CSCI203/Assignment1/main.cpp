// Headers
#include <iostream>
#include <fstream>

using namespace std;

// Function Prototypes
void push(char word[]);
bool isEmpty();
char formatCharacter(char letter);
void sortWords();
bool isAlphabet(char letter);
void printFirstTen();
void printLastTen();
void printUnique();
int checkUnique(int index);

// Global Variables
const int STACK_SIZE = 50000;
const int WORD_SIZE = 20;
char stack[STACK_SIZE][WORD_SIZE];
int top = 0;
int words = 0;
int wordCount[STACK_SIZE];

// Main Function
int main(){
    // Local Variables
    char filename[20];
    ifstream fin;
    char word[WORD_SIZE];

    // Get file input
    cerr << "Please enter the name of the input file: ";
    cin >> filename;

    // Open file
    fin.open(filename);
    // Print error if file doesn't open, then quit the program.
    if (!fin) {
        cerr << "Error opening file " << filename << ". Program will exit." << endl;
        return 0; 
    }

    // Read the file into the stack
    while (fin >> word) {
        push(word);
    }

    // Close file
    fin.close();

    // Sort by decreasing word count
    sortWords();

    // Print first ten words
    printFirstTen();
    // Print last ten words
    printLastTen();
    // Print unique words
    printUnique();
}

// Function to push words into the stack
void push(char word[]){
    if (top == STACK_SIZE) return;

    // Counter for each character
    int i = 0;
    // Counter for each English letter
    int j = 0;

    do {
        // Check if the current character is an English letter
        if (isAlphabet(word[i])){
            // Format the current character
            word[i] = formatCharacter(word[i]);
            // Insert English letter in the current counter's position
            stack[top][j] = word[i];
            j++;
        }
        i++;
    } while (word[i]);

    // Set the number of characters in the current word to the amount of English letters it contains
    wordCount[words] = j;
    
    top++;
    words++;
    return;
}

// Function to check if the stack is empty
bool isEmpty(){
    return (top == 0);
}

bool isAlphabet(char letter){
    // Check if the current character is an English letter
    if ((letter < 'A' || letter > 'Z') && (letter < 'a' || letter > 'z')){
        return false;
    }
    else{
        return true;
    }
}

char formatCharacter(char letter){
    // If the current letter is uppercase, convert to lowercase
    if (letter >= 'A' && letter <= 'Z'){
        letter = letter + 32;
    }
    return letter;
}

void sortWords(){
    // Sort by decreasing word count
    // Sort words by decreasing word count
    for (int i = 0; i < words; i++){
        for (int j = i + 1; j < words; j++){
            if (wordCount[i] < wordCount[j]){
                char tempWord[WORD_SIZE] = {0};
                // Filling temporary array of characters
                for (int k = 0; k < wordCount[j]; k++){
                    tempWord[k] = stack[i][k];
                }
                
                // Replacing characters of the smaller word, with the characters of the bigger word
                for (int k = 0; k < wordCount[j]; k++){
                    stack[i][k] = stack[j][k];
                }
                
                // Removing all characters in the bigger word
                for (int k = 0; k < wordCount[j]; k++){
                    stack[j][k] = '\0';
                }

                // Replacing characters of the bigger word, with the characters of the temporary word
                for (int k = 0; k < wordCount[i]; k++){
                    stack[j][k] = tempWord[k];
                }
                
                // Set temporary int to the number of characters in the word at index 'i'
                int tempCount = wordCount[i];
                // Replace the number of characters in 'i' with 'j'
                wordCount[i] = wordCount[j];
                // Replace the number of characters in 'j' with the temporary number of characters
                wordCount[j] = tempCount;
            }
        }
    }

    // Sort Alphabetically
    // For each word
    for (int i = 0; i < words; i++){
        bool swap = false;
        for (int j = i + 1; j < words; j++){
            // If both words have the same character count, and if the two indices are not the same
            if (wordCount[i] == wordCount[j]){

                // For each character
                for (int k = 0; k < wordCount[i]; k++){

                    // If the character in the current word is greater than the character in the next word (i.e. if B is greater than A)
                    if (stack[i][k] > stack[j][k])
                    {
                        swap = true;
                        break;
                    }
                    // If both characters are the same, continue
                    else if (stack[i][k] == stack[j][k]){
                        continue;
                    }
                    else{
                        break;
                    }
                }
                if (swap){
                    // Temporary word
                    char tempWord[WORD_SIZE] = { 0 };
                    
                    // Set the temporary word to 'i'
                    for (int k = 0; k < wordCount[i]; k++){
                        tempWord[k] = stack[i][k];
                    }

                    // Set 'i' to 'j'
                    for (int k = 0; k < wordCount[i]; k++){
                        stack[i][k] = stack[j][k];
                    }

                    // Set 'j' to the temporary word
                    for (int k = 0; k < wordCount[i]; k++){
                        stack[j][k] = tempWord[k];
                    }
                    swap = false;
                }
            }
        }
    }
}

void printFirstTen(){
    cout << "First 10 Words:" << endl << endl;
    for (int i = 0; i < 10; i++){
        cout << stack[i] << ": " << wordCount[i] << endl;
    }
    cout << endl;
}

void printLastTen(){
    cout << "Last 10 Words:" << endl << endl;
    for (int i = words - 10; i < words; i++){
        cout << stack[i] << ": " << wordCount[i] << endl;
    }

    cout << endl;
}

void printUnique(){
    cout << "Unique Words:" << endl << endl;

    for (int i = 0; i < words; i++){
        if (checkUnique(i) == 1){
            cout << stack[i] << endl;
        }
    }
}

int checkUnique(int index){
    int occurrences = 1;

    // For each word
    for (int i = 0; i < words; i++){    
        // If current index is not the same as comparison index, and the word length of each word is the same
        if (index != i && wordCount[index] == wordCount[i]){
            bool wordFound = false;
            // For each character in the current index
            for (int j = 0; j < wordCount[index]; j++){
                // Compare the current character in the current index with the character of the next index
                if (stack[index][j] == stack[i][j] && stack[i][j] != '\0'){
                    wordFound = true;
                }
                else{
                    wordFound = false;
                    break;
                }
            }
            if (wordFound){
                occurrences++;
            }
        }
    }

    return occurrences;
}