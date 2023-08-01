#include <iostream>
#include "implement.h"

using namespace std;


int main(int argc, char* argv[]){
    if (argc != 4){
        Error("Please provide valid arguments:-\n./ABC <claim> <mechanics> <output_file>");

        return 0;
    }

    cout << "\n##########\nLoading Mechanics...\n##########\n" << endl;
    loadMechanics(argv[2]);
    
    cout << "\n##########\nProcessing Claims...\n##########\n" << endl;
    loadClaims(argv[1]);

    claimEval(argv[3]);

    return 0;
};

