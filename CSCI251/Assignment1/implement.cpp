#include <iostream>
#include <fstream>
#include <istream>
#include <sstream>
#include <ostream>
#include <error.h>
#include <random>
#include <iomanip>
#include <time.h>
#include "implement.h"

const int MAX = 20;

struct Mechanics{
    string name;
    int mechanicID, ability, variability;
};

vector<Mechanics> mechanicArray;

struct Claims{
    string description;
    int claimID, complexity, uncertainty;
    vector<Mechanics> mechanicList;
};

vector<Claims> claimArray;

void loadMechanics(string file_name){
    cout << "START MECHANICS" << endl;
    cout << "------------------------------\n" << endl;
    // Load input file
    ifstream file(file_name);
    string line, entries[MAX];

    // Check if file is valid
    if (!file.good())
        Error("Unable to access file " + file_name);

    // While there is a line available in the loaded file
    while(getline(file,line)){
        size_t last = 0, next = 0; int k = 0;

        // Separate by comma
        while((next = line.find(",", last)) != string::npos){
            //cout << line.substr(last, next) << endl;
            entries[k++] = line.substr(last, next-last);
            last = next + 1;
        }
        entries[k++] = line.substr(last);

        // Create temporary object of type Mechanic
        Mechanics newMec;

        // Set values of the temporary Mechanic to the stored values in the entries array
        newMec.mechanicID = stoi(entries[0]);
        newMec.name = entries[1];
        newMec.ability = stoi(entries[2]);
        newMec.variability = stoi(entries[3]);
        cout << "Mechanic ID: " << newMec.mechanicID << endl;
        cout << "Mechanic Name: " << newMec.name << endl;
        cout << "Mechanic Ability: " << newMec.ability << endl;
        cout << "Mechanic Variability: " << newMec.variability << endl;
        cout << endl;
        
        // Add temporary Mechanic to the list of Mechanics
        mechanicArray.push_back(newMec);
    }
    file.close();
    cout << "------------------------------" << endl;
    cout << "FINISHED MECHANICS" << endl;
}

void loadClaims(string file_name){
    cout << "START CLAIMS" << endl;
    cout << "------------------------------\n" << endl;
    // Load input file
    ifstream file(file_name);
    string line;

    char inString[100];

    if (!file.good())
        Error("Unable to access file " + file_name);
    while(file.good())
    {
        // Take the input of file and store to the inString variable
        file.getline(inString, 100, '\n');
        
        //cout << inString << endl;

        // Create a substring
        stringstream ss(inString);
        string subStr;

        // Create temporary object of type Claims
        Claims newClaim;

        // Set values of the temporary Claim to the stored value from the substring
        getline(ss, subStr, ',');
        newClaim.claimID = stoi(subStr);
        cout << "Claim ID: " << subStr << endl;

        getline(ss, subStr, ',');
        newClaim.description = subStr;
        cout << "Claim Description: " << subStr << endl;

        getline(ss, subStr, ',');
        newClaim.complexity = stoi(subStr);
        cout << "Claim Complexity: " << subStr << endl;

        getline(ss, subStr, ',');
        newClaim.uncertainty = stoi(subStr);
        cout << "Claim Uncertainty: " << subStr << endl;

        getline(ss, subStr, ':');
        getline(ss, subStr, '\n');

        // Another substring of the initial substring (which holds the values after the ':')
        stringstream sss(subStr);
        string subStrSubStr;

        int k = 0;
        cout << "Mechanic IDs: " << endl;

        while(getline(sss, subStrSubStr, ',')){
            //getline(ss, subStr, ',');
            newClaim.mechanicList.push_back(mechanicArray.at(stoi(subStrSubStr)));
            cout << "    ID:" << subStrSubStr << endl;
            k++;
        }

        cout << endl;

        // Add temporary Claim to the Claims array
        claimArray.push_back(newClaim);
    }

    file.close();
    cout << "------------------------------" << endl;
    cout << "FINISHED CLAIMS" << endl;
}


int normalDist(int m, int s){
    default_random_engine random_engine(time(NULL));

    normal_distribution<> dist(m, s);

    return round(dist(random_engine));
}


void claimEval(string output_file){
    cout << "\nSTART OF CLAIM EVAL" << endl;
    cout << "------------------------------\n" << endl;
    // Create output file
    ofstream outFile;
    outFile.open(output_file);

    if (outFile.bad()){
        Error("File could not be opened");
        //return 1;
    }

    int mean = 0, standardDeviation = 0;

    for (Claims c : claimArray){
        bool scrap = false;

        cout << left << setw(10) << "<>< <><    Claim "<< c.claimID <<"    ><> ><>" << endl;
        cout << "Claim Description: " << c.description << endl;
        cout << "Claim Complexity: " << c.complexity << endl;
        cout << "Claim Uncertainty: " << c.uncertainty << endl << endl;

        // Output following information to the output file
        outFile << left << setw(10) << "<>< <><    Claim "<< c.claimID <<"    ><> ><>" << endl;
        outFile << "Claim Description: " << c.description << endl;
        outFile << "Claim Complexity: " << c.complexity << endl;
        outFile << "Claim Uncertainty: " << c.uncertainty << endl << endl;
        for (Mechanics m : c.mechanicList){
            // Calculate mean and standard deviation
            mean = m.ability - c.complexity;
            standardDeviation = c.uncertainty + m.variability;

            // Calculate normal distribution
            int result = normalDist(mean, standardDeviation);

            // If result is equal to, or less than 50, fail
            if (result < 50){
                cout << "Trial with mechanic: " << m.mechanicID << ", " << m.name << ": Failed with a score of " << result << endl;
                outFile << "Trial with mechanic: " << m.mechanicID << ", " << m.name << ": Failed with a score of " << result << endl;
                scrap = true;
            }
            // If result is greater than 50, succeed
            else{
                cout << "Trial with mechanic: " << m.mechanicID << ", " << m.name << ": Succeeded with a score of " << result << endl;
                outFile << "Trial with mechanic: " << m.mechanicID << ", " << m.name << ": Succeeded with a score of " << result << endl;
                scrap = false;
                break;
            }
        }

        if (scrap == true){
                cout << "ATTENTION: Car is scrapped as all mechanics are unable to repair the issue" << endl;
                outFile << "ATTENTION: Car is scrapped as all mechanics are unable to repair the issue" << endl;
        }

        cout << endl;
        outFile << endl;
    }
    cout << "------------------------------" << endl;
    cout << "FINISHED CLAIM EVAL" << endl;

    outFile.close();
};

void Error(string errorMessage){
    cout << errorMessage;
};
