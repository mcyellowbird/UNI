// Headers
#include <iostream>
#include <fstream>

using namespace std;

// Function Prototypes
void push(char word[]);
char *pop();
bool isEmpty();

// Global Variables
const int STACK_SIZE = 100;
const int WORD_SIZE = 20;
char stack[STACK_SIZE][WORD_SIZE];
int top = 0;

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

    // Pop the words from the stack while it is not empty
    while (!isEmpty()) {
        cout << pop() << endl;
    }
}

// Function to push words into the stack
void push(char word[]){
    if (top == STACK_SIZE) return;
    int i = 0;
    do {
        stack[top][i] = word[i];
        i++;
    } while (word[i]);
    top++;
    return;
}

// Function to pop words from the stack
char *pop(){
    return stack[--top];
}

// Function to check if the stack is empty
bool isEmpty(){
    return (top == 0);
}