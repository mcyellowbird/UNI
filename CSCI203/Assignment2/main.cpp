// Headers
#include <iostream>
#include <fstream>

using namespace std;

// Global Variables

int tellerCount = 0;
int customerCount = 0;
int servedCustomers = 0;
int maxQueueLength = 0;
int currentQueueLength = 0;
float simulationTime = 0.0000;
float totalServingTime = 0.0000;
float totalWaitingTime = 0.0000;
float highPriority[100][3] = {0,0,0};
float medPriority[100][3] = {0,0,0};
float lowPriority[100][3] = {0,0,0};
int lowPointer = 0;
int medPointer = 0;
int highPointer = 0;

// Initialize Functions

int loadCustomerData();
void runSimulation(float tellers[][4]);
int getNextTeller(float tellers[][4]);
void getNextCustomer(int nextTeller, float tellers[][4], float nextCustomer[]);
void printStatistics(float tellers[][4]);
void getQueueLength();

int main() {
    // Get input for number of tellers
    cerr << "Enter amount of tellers to run the simulation with: ";
    cin >> tellerCount;
    float tellers[tellerCount][4] = {0,0,0,0}; 

    loadCustomerData();
    runSimulation(tellers);
}

// Function to load customer data
int loadCustomerData(){
    char filename[20];
    ifstream fin;

    // Get input for file name
    cerr << "Enter the customer file name: ";
    cin >> filename;

    // Open file
    fin.open(filename);
    // If file is not found, print error, close program
    if (!fin) {
        cerr << "Error opening file " << filename << ". Program will exit." << endl;
        return 0;
    }

    float arrivalTime, serviceTime;
    int priority;

    int lowCount, medCount, highCount;
    
    // While file is open, insert values into corresponding 2D arrays based on priority
    while (fin >> arrivalTime >> serviceTime >> priority){
        switch(priority){
            case 1:
                lowPriority[lowCount][0] = arrivalTime;
                lowPriority[lowCount][1] = serviceTime;
                lowPriority[lowCount][2] = priority;
                lowCount++;
            break;

            case 2:
                medPriority[medCount][0] = arrivalTime;
                medPriority[medCount][1] = serviceTime;
                medPriority[medCount][2] = priority;
                medCount++;
            break;

            case 3:
                highPriority[highCount][0] = arrivalTime;
                highPriority[highCount][1] = serviceTime;
                highPriority[highCount][2] = priority;
                highCount++;
            break;
        }

        customerCount++;
        // If artificial end of file found, break loop
        if (arrivalTime == 0 && serviceTime == 0){
            break;
        }
    }

    // Close file
    fin.close();
    return 0;
}

// Function to print statistics of the simulation
void printStatistics(float tellers[][4]){
    cout << "Simulation Time: " << simulationTime << endl; 
    cout << "Average Service Time: " << (totalServingTime / customerCount) << endl; 
    cout << "Average Waiting Time: " << (totalWaitingTime / customerCount) << endl;
    cout << "Max Queue Length: " << maxQueueLength << endl;
    cout << "Average Queue Length: " << (totalWaitingTime / totalServingTime) << endl << endl;
    
    // For each teller, print stats
    for (int i = 0; i < tellerCount; i++){
        cout << "----------" << endl;
        cout << "Teller " << i+1 << endl;
        cout << "Customers Served: " << tellers[i][0] << endl;
        cout << "Idle Time: " << tellers[i][2] << endl;
        cout << "Idle Rate: " << (tellers[i][2] / simulationTime) << endl;
    }
    cout << "----------" << endl;
}

// Function to get length of queue
void getQueueLength(int nextTeller, float tellers[][4]){
    currentQueueLength = 0;

    // Loop through each priority list to see what customers are waiting in a queue
    for (int i = highPointer; i < customerCount; i++){
        if (highPriority[i][0] == 0) {break;}

        if (highPriority[i][0] < tellers[nextTeller][3]){
            currentQueueLength++;
        }
    }

    for (int i = medPointer; i < customerCount; i++){
        if (medPriority[i][0] == 0) {break;}

        if (medPriority[i][0] < tellers[nextTeller][3]){
            currentQueueLength++;
        }
    }

    for (int i = lowPointer; i < customerCount; i++){
        if (lowPriority[i][0] == 0) {break;}

        if (lowPriority[i][0] < tellers[nextTeller][3]){
            currentQueueLength++;
        }
    }

    if (currentQueueLength > maxQueueLength){
        maxQueueLength = currentQueueLength;
    }
}

// Function to run the simulation
void runSimulation(float tellers[][4]){
    while (servedCustomers < customerCount){
        // Finding next available teller
        int nextTeller = getNextTeller(tellers);
        
        // Getting next customer
        float nextCustomer[2] = {0,0};
        getNextCustomer(nextTeller, tellers, nextCustomer);

        // Check if customer in queue
        if (nextCustomer[0] < tellers[nextTeller][3]){
            totalWaitingTime += tellers[nextTeller][3] - nextCustomer[0];
            getQueueLength(nextTeller, tellers);
            nextTeller = getNextTeller(tellers);
            tellers[nextTeller][0]++;
            tellers[nextTeller][1] += nextCustomer[1];
            tellers[nextTeller][3] += nextCustomer[1];
        }
        // Check if teller can serve
        else if (tellers[nextTeller][3] < nextCustomer[0]){
            tellers[nextTeller][0]++;
            tellers[nextTeller][1] += nextCustomer[1];
            tellers[nextTeller][2] += nextCustomer[0] - tellers[nextTeller][3];
            tellers[nextTeller][3] = nextCustomer[0] + nextCustomer[1];
        }

        simulationTime = tellers[nextTeller][3];
        totalServingTime += tellers[nextTeller][1];
        servedCustomers++;
    }
    printStatistics(tellers);
}

// Function to get next available teller
int getNextTeller(float tellers[][4]){
    int nextTeller = 0;
    float finishTime = tellers[0][0];

    // Finding teller with earliest finish time
    for (int i = 0; i < tellerCount; i++){
        if (tellers[i][0] < finishTime){
            nextTeller = i;
            finishTime = tellers[i][0];
        }
    }

    return nextTeller;
}

// Function to get next customer
void getNextCustomer(int nextTeller, float tellers[][4], float nextCustomer[]){
    float customerDetails[2] = {0,0};
    // Checking if a customer is queued
    if (highPriority[highPointer][0] < tellers[nextTeller][3] && highPriority[highPointer][0] > 0 && highPriority[highPointer][0] != 0){
        nextCustomer[0] = highPriority[highPointer][0];
        nextCustomer[1] = highPriority[highPointer][1];
        currentQueueLength++;
        highPointer++;
    }
    else if (medPriority[medPointer][0] < tellers[nextTeller][3] && medPriority[medPointer][0] > 0 && medPriority[medPointer][0] != 0){
        nextCustomer[0] = medPriority[medPointer][0];
        nextCustomer[1] = medPriority[medPointer][1];
        currentQueueLength++;
        medPointer++;
    }
    else if (lowPriority[lowPointer][0] < tellers[nextTeller][3] && lowPriority[lowPointer][0] > 0 && lowPriority[lowPointer][0] != 0){
        nextCustomer[0] = lowPriority[lowPointer][0];
        nextCustomer[1] = lowPriority[lowPointer][1];
        currentQueueLength++;
        lowPointer++;
    }
    else{
        // If no customer is in the queue, return customer with lowest arrival time
        if (highPriority[highPointer][0] < medPriority[medPointer][0] && highPriority[highPointer][0] < lowPriority[lowPointer][0] && highPriority[highPointer][0] > 0 && highPriority[highPointer][0] != 0){
            nextCustomer[0] = highPriority[highPointer][0];
            nextCustomer[1] = highPriority[highPointer][1];
            currentQueueLength++;
            highPointer++;
        }
        else if (medPriority[medPointer][0] < highPriority[highPointer][0] && medPriority[medPointer][0] < lowPriority[lowPointer][0] && medPriority[medPointer][0] > 0 && medPriority[medPointer][0] != 0){
            nextCustomer[0] = medPriority[medPointer][0];
            nextCustomer[1] = medPriority[medPointer][1];
            currentQueueLength++;
            medPointer++;
        }
        else if (lowPriority[lowPointer][0] < medPriority[medPointer][0] && lowPriority[lowPointer][0] < highPriority[highPointer][0] && lowPriority[lowPointer][0] > 0 && lowPriority[lowPointer][0] != 0){
            nextCustomer[0] = lowPriority[lowPointer][0];
            nextCustomer[1] = lowPriority[lowPointer][1];
            currentQueueLength++;
            lowPointer++;
        }
    }
}