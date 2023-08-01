// Headers
#include <iostream>
#include <fstream>

using namespace std;

const int MAX_CUSTOMERS = 100;
int tellerCount = 0;
int customerCount = 0;

int main() {
    int customersServedTotal = 0;
    float avgServiceTime = 0.0000f;
    float avgWaitingTime = 0.0000f; // Time spent in queue only
    float simulationTime = 0.0000f; // Time difference between simulation start and end
    int maxQueueLength = 0; // Most amount of people waiting in the queue
    float avgQueueLength = 0.0000f; // Ratio between total queuing time and completion of last service request



    char filename[20];
    ifstream fin;

    cerr << "Enter amount of tellers to run the simulation with: ";
    cin >> tellerCount;

    cerr << "Enter the customer file name: ";
    cin >> filename;

    fin.open(filename);
    if (!fin) {
        cerr << "Error opening file " << filename << ". Program will exit." << endl;
        return 0;
    }

    // Add customer to Queue
    // If a teller is available, check if there's more than 1 customer waiting.
    // If more than 1 customer is waiting in the queue, check priority
    // If priority is the same, check arrival time
    // Then move customer to available teller
    // Otherwise do nothing (customer stays in queue)
    // Update statistics after customer finished being served

    float arrivalTime, serviceTime;
    int priority;
    int queueCount = 0;
    float lowPriority[MAX_CUSTOMERS][3];
    int lowCount = 0;
    int lowPointer = 0;
    float medPriority[MAX_CUSTOMERS][3];
    int medCount = 0;
    int medPointer = 0;
    float highPriority[MAX_CUSTOMERS][3];
    int highCount = 0;
    int highPointer = 0;
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
        if (arrivalTime == 0 && serviceTime == 0){
            break;
        }
    }

    // cout << "High Priority Queue" << endl;
    // for (int i = 0; i < highCount; i++){
    //     cout << i << endl;
    //     cout << "Arrival Time: " << highPriority[i][0] << endl;
    //     cout << "Service Time: " << highPriority[i][1] << endl;
    //     cout << "Priority: " << highPriority[i][2] << endl;
    // }
    // cout << endl << "Med Priority Queue" << endl;
    // for (int i = 0; i < medCount; i++){
    //     cout << i << endl;
    //     cout << "Arrival Time: " << medPriority[i][0] << endl;
    //     cout << "Service Time: " << medPriority[i][1] << endl;
    //     cout << "Priority: " << medPriority[i][2] << endl;
    // }
    // cout << endl << "Low Priority Queue" << endl;
    // for (int i = 0; i < lowCount; i++){
    //     cout << i << endl;
    //     cout << "Arrival Time: " << lowPriority[i][0] << endl;
    //     cout << "Service Time: " << lowPriority[i][1] << endl;
    //     cout << "Priority: " << lowPriority[i][2] << endl;
    // }

    // 2D Array of tellers.
    // First Index = Customers Served
    // Second Index = Serving Time
    // Third Index = Idle Time
    // Fourth Index = Finish Time
    float tellers[tellerCount][5] = {0,0,0,0,10};

    for (int i = 0; i < customerCount;){
        int currentTeller = 0;
        for (int t = 0; t < tellerCount; t++){
            for (int k = 0; k < tellerCount; k++){
                if (tellers[t][5] < tellers[k][5] && t != k){
                    currentTeller = t;
                }
            }
        }

        int nextCustomer;
        char nextQueue;

        //for (int j = 0; j < highCount; j++){
            if (highPriority[highPointer][0] < tellers[currentTeller][5] && highPointer <= highCount){
                nextCustomer = highPointer;
                nextQueue = 'H';
            }
            else if (medPriority[medPointer][0] < tellers[currentTeller][5] && medPointer <= medCount){
                nextCustomer = medPointer;
                nextQueue = 'M';
            }
            else if (lowPriority[lowPointer][0] < tellers[currentTeller][5] && lowPointer <= lowCount){
                nextCustomer = lowPointer;
                nextQueue = 'L';
            }
            // else{
                // for (int j = 0; j < highCount; j++){
                //     if (highPriority[nextCustomer][0] < medPriority[j][0] && j < medCount){
                //         nextCustomer = j;
                //         nextQueue = 'H';
                //     }
                //     else if (highPriority[nextCustomer][0] < lowPriority[j][0] && j < lowCount){
                //         nextCustomer = j;
                //         nextQueue = 'H';
                //     }
                // }
                // for (int j = 0; j < medCount; j++){
                //     if (medPriority[nextCustomer][0] < highPriority[j][0] && j < highCount){
                //         nextCustomer = j;
                //         nextQueue = 'M';
                //     }
                //     else if (medPriority[nextCustomer][0] < lowPriority[j][0] && j < lowCount){
                //         nextCustomer = j;
                //         nextQueue = 'M';
                //     }
                // }
                // for (int j = 0; j < lowCount; j++){
                //     if (lowPriority[nextCustomer][0] < medPriority[j][0] && j < medCount){
                //         nextCustomer = j;
                //         nextQueue = 'L';
                //     }
                //     else if (lowPriority[nextCustomer][0] < highPriority[j][0] && j < highCount){
                //         nextCustomer = j;
                //         nextQueue = 'L';
                //     }
                // }
            //}

            // Process

            switch(nextQueue){
                case 'H':
                    tellers[currentTeller][5] = highPriority[nextCustomer][0] + highPriority[nextCustomer][1];
                    break;
                case 'M':
                    tellers[currentTeller][5] = medPriority[nextCustomer][0] + medPriority[nextCustomer][1];
                    break;
                case 'L':
                    tellers[currentTeller][5] = lowPriority[nextCustomer][0] + lowPriority[nextCustomer][1];
                    break;
            }

            cout << endl << "Teller #" << currentTeller << "'s Finish Time: " << tellers[currentTeller][5]<<endl;

            // End Process

            cout << endl << "Customer: " << nextCustomer << " in " << nextQueue << endl;
            switch(nextQueue){
                case 'H':
                    highPointer++;
                    cout << "Arrival Time: " << highPriority[nextCustomer][0] << endl;
                    cout << "Service Time: " << highPriority[nextCustomer][1] << endl;
                    break;
                case 'M':
                    medPointer++;
                    cout << "Arrival Time: " << medPriority[nextCustomer][0] << endl;
                    cout << "Service Time: " << medPriority[nextCustomer][1] << endl;
                    break;
                case 'L':
                    lowPointer++;
                    break;
                    cout << "Arrival Time: " << lowPriority[nextCustomer][0] << endl;
                    cout << "Service Time: " << lowPriority[nextCustomer][1] << endl;
            }
        //}

        

        // for (int j = 0; j < medCount; j++){
        //     if (medPriority[j][0] < tellers[currentTeller][5]){
        //         // Process
        //     }
        //     else{
        //         break;
        //     }
        // }

        // for (int j = 0; j < lowCount; j++){
        //     if (lowPriority[j][0] < tellers[currentTeller][5]){
        //         // Process
        //     }
        //     else{
        //         break;
        //     }
        // }
        i++;
    }

    // Initial idle rate for first customer's arrival time
    
    // for (int i = 0; i < tellerCount; i++){
    //     tellers[i][3] += customers[0][1];
    // }

    // for (int i = 0; i < customerCount;){
    //     for (int j = 0; j < 3; j++){
    //         queue[queueCount][j] = customers[i][j];
    //         queueCount++;
    //     }

    //     if (queueCount > 0){
    //         for (int t = 0; t < tellerCount; t++){
    //             if (tellers[t][0] == 0){
    //                 tellers[t][0] = 1;
    //                 tellers[t][1] = i;
    //                 tellers[t][2]++;
    //                 for (int j = t; j < tellerCount; j++){
    //                     tellers[j][3] += queue[queueCount][1];
    //                 }
    //                 for (int j = 0; j < 3; j++){
    //                     queue[0][j] = 0;
    //                 }
    //                 i++;
    //                 tellers[t][0] = 0;
    //                 queueCount--;
    //             }
    //         }
    //     }
    // }

    // avgWaitingTime = avgWaitingTime / customerCount;
    // maxQueueLength = 1;

    // Outputs
    // for (int i = 0; i < tellerCount; i++){
    //     cout << "Teller #" << i+1 << " has served " << tellers[i][2] << " customers" << endl;
    // }
    // cout << endl;
    // cout << "Total Simulation Time: " << simulationTime << endl;
    // cout << "Average Service Time Per Customer: " << avgServiceTime << endl;
    // cout << "Average Waiting Time Per Customer: " << avgWaitingTime << endl;
    // cout << "Maximum Queue Length: " << maxQueueLength << endl;
    // cout << "Average Queue Length: " << avgQueueLength << endl;
    // cout << endl;
    // for (int i = 0; i < tellerCount; i++){
    //     cout << "Teller #" << i+1 << " has an idle rate of " << tellers[i][3] << endl;
    // }
    // cout << endl;

    // cout << "Simulation Time: " << simulationTime << endl;
}