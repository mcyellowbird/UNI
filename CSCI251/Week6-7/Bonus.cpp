#include <iostream>
#include <string>

using namespace std;

const static double bonusRate[3][3] = {{0.03, 0.02, 0.005}, {0.05, 0.035, 0.015}, {0.075, 0.055, 0.04}};
class Staff{

    private:
        int staffNumber, salesMade;
        string firstName, lastName;
        double baseSalary, bonus;
        char staffClass;

    public:
        Staff() = default;
        void setFields(int,string,string,char,double,int);
        void display();
        void computeBonus();
};

static void displayBonus(){
    cout << "-------------------------------------------" << endl;
    cout << "Sales       Class A     Class B     Class C" << endl;

    for (int i = 0; i < 3; i++){
        if (i == 0){cout << "0 - 20       ";}
        else if (i == 1){cout << "21 - 50      ";}
        else if (i == 2){cout << "50+          ";}
        for (int j = 0; j < 3; j++){
            cout << bonusRate[i][j] << "        ";
        }
        cout << endl;
    }
    cout << "-------------------------------------------\n" << endl;
}

void Staff::computeBonus(){
    if (staffClass == 'A'){
        if (salesMade <= 20){
            bonus = baseSalary * salesMade * bonusRate[0][0];
        }
        else if (21 >= salesMade <= 50){
            bonus = baseSalary * salesMade * bonusRate[1][0];
        }
        else{
            bonus = baseSalary * salesMade * bonusRate[2][0];
        }
    }
    else if (staffClass == 'B'){
        if (salesMade <= 20){
            bonus = baseSalary * salesMade * bonusRate[0][1];
        }
        else if (21 >= salesMade <= 50){
            bonus = baseSalary * salesMade * bonusRate[1][1];
        }
        else{
            bonus = baseSalary * salesMade * bonusRate[2][1];
        }
    }
    else if (staffClass == 'C'){
        if (salesMade <= 20){
            bonus = baseSalary * salesMade * bonusRate[0][2];
        }
        else if (salesMade >= 21 && salesMade <= 50){
            bonus = baseSalary * salesMade * bonusRate[1][2];
        }
        else if (salesMade > 50){
            bonus = baseSalary * salesMade * bonusRate[2][2];
        }
    }
}

void Staff::setFields(int sN, string fN, string lN, char sC, double bS, int sM){
    staffNumber = sN;
    firstName = fN;
    lastName = lN;
    staffClass = sC;
    baseSalary = bS;
    salesMade = sM;
    
    computeBonus();
}

void Staff::display(){
    cout << "Name: " << firstName << " " << lastName << endl;
    cout << "Grade: " << staffClass << "          Staff Number: #" << staffNumber << endl;
    cout << "Salary: " << baseSalary << "     Sales Made: " << salesMade << endl;
    cout << "Bonus: $" << bonus << endl << endl;
}

int main(){
    displayBonus();
    Staff staffOne;
    staffOne.setFields(1001,"Thomas","the Tank Engine",'A',10000,21);
    staffOne.display();

    Staff staffTwo;
    staffTwo.setFields(1002,"Bob","the Builder",'C',5000,56);
    staffTwo.display();

    return 0;
}